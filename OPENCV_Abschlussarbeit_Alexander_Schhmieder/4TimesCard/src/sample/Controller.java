package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {

    private GenerateRect gr = new GenerateRect();

    @FXML
    private Button cameraButton;

    @FXML
    private ImageView originalFrame;
    @FXML
    private ImageView cardFrame;

    private ScheduledExecutorService timer;

    private VideoCapture capture;

    private boolean cameraActive;

    void init() {
        this.capture = new VideoCapture();

        originalFrame.setFitWidth(800);
        originalFrame.setPreserveRatio(true);

        cardFrame.setFitWidth(800);
        cardFrame.setPreserveRatio(true);

        startCamera();
    }


    @FXML
    protected void startCamera() {
        if (!this.cameraActive) {

            //this.capture.open(0);

            this.cameraActive = true;


            Runnable frameGrabber = () -> {

                //Mat frame = grabFrame();

                Mat frame = Imgcodecs.imread("resources/Example1.jpg", Imgcodecs.CV_LOAD_IMAGE_COLOR);
                Image imageToShow = Utils.mat2Image(frame);

                updateImageView(originalFrame, imageToShow);


            };
            Runnable frameGrabber2 = () -> {

                Mat cardFrameF = grabCardFrame();

                Image imageToShow2 = Utils.mat2Image(cardFrameF);

                updateImageView(cardFrame, imageToShow2);

            };

            this.timer = Executors.newSingleThreadScheduledExecutor();
            this.timer.scheduleAtFixedRate(frameGrabber, 0, 33, TimeUnit.MILLISECONDS);
            this.timer = Executors.newSingleThreadScheduledExecutor();
            this.timer.scheduleAtFixedRate(frameGrabber2, 0, 33, TimeUnit.MILLISECONDS);

            this.cameraButton.setText("Stop Camera");
        } else {

            this.cameraActive = false;

            this.cameraButton.setText("Start Camera");

            this.stopAcquisition();
        }
    }

  /*  private Mat grabFrame() {
        Mat frame = new Mat();
        this.capture.read(frame);

        return frame;
    }*/

    private Mat grabCardFrame() {
        Mat frame = Imgcodecs.imread("resources/Example1.jpg", Imgcodecs.CV_LOAD_IMAGE_COLOR);
        //Mat frame = grabFrame();
        Imgproc.medianBlur(frame, frame, 9);

        Mat gray0 = new Mat(frame.size(), CvType.CV_8U), gray = new Mat();

        List<MatOfPoint> contours = new ArrayList<>();

        List<Mat> blurredChannel = new ArrayList<>();
        blurredChannel.add(frame);
        List<Mat> gray0Channel = new ArrayList<>();
        gray0Channel.add(gray0);

        Mat result = new Mat();

        Mat frame2 = Imgcodecs.imread("resources/Example1.jpg", Imgcodecs.CV_LOAD_IMAGE_COLOR);
        //Mat frame2 = new Mat();
        //this.capture.read(frame2);

        for (int c = 0; c < 3; c++) {
            int ch[] = {c, 0};
            Core.mixChannels(blurredChannel, gray0Channel, new MatOfInt(ch));

            int thresholdLevel = 1;
            for (int t = 0; t < thresholdLevel; t++) {
                Imgproc.Canny(gray0, gray, 100, 100 * 3, 3, true); // true ?
                Imgproc.dilate(gray, gray, new Mat(), new Point(-1, -1), 1); // 1
                // ?

                Imgproc.findContours(gray, contours, new Mat(),
                        Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);

                result = gr.detectedCards(contours, frame2);
            }
        }

        return result;
    }

    private void stopAcquisition() {
        if (this.timer != null && !this.timer.isShutdown()) {
            try {

                this.timer.shutdown();
                this.timer.awaitTermination(33, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {

                System.err.println("Exception in stopping the frame capture, trying to release the camera now... " + e);
            }
        }

        if (this.capture.isOpened()) {

            this.capture.release();
        }
    }


    private void updateImageView(ImageView view, Image image) {
        Utils.onFXThread(view.imageProperty(), image);
    }

    void setClosed() {
        this.stopAcquisition();
    }

}
