package sample;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;

import static org.opencv.imgproc.Imgproc.getRotationMatrix2D;

class RotAndCrop {

    private Mat cropped = new Mat();
    private Mat moreCropped = new Mat();

    private Mat crop(RotatedRect rect, Mat frame2, Mat rotated) {

        Size rect_size = rect.size;
        double rectW = rect_size.width;
        double rectH = rect_size.height;

        float angle = (float) rect.angle;

        if (rect_size.width > rect_size.height) {
            angle += 90;
            rectW = rect_size.height;
            rectH = rect_size.width;
        }

        Mat m = getRotationMatrix2D(rect.center, angle, 1.0);
        Imgproc.warpAffine(frame2, rotated, m, new Size(frame2.width(), frame2.height()), Imgproc.INTER_CUBIC);

        Imgproc.getRectSubPix(rotated, new Size(rectW, rectH), rect.center, cropped);

        Mat tempC = new Mat();
        cropped.copyTo(tempC);
        Imgproc.resize(tempC, tempC, new Size(400, 800));

        Rect rectCrop = new Rect(new Point(0, 0), new Point(45, 200));
        Size rectCrop_size = rectCrop.size();
        Imgproc.getRectSubPix(tempC, rectCrop_size, new Point(40, 120), moreCropped);

        Imgproc.resize(moreCropped, moreCropped, new Size(600, 800));

        return moreCropped;
    }


    Mat croppedLetter(RotatedRect rect, Mat frame2, Mat rotated) {

        moreCropped = this.crop(rect, frame2, rotated);

        Mat croppedLetter = new Mat();
        Rect rectCropLetter = new Rect(new Point(0, 0), new Point(550, 450));
        Size croppedLetter_size = rectCropLetter.size();
        Imgproc.getRectSubPix(moreCropped, croppedLetter_size, new Point(300, 225), croppedLetter);

        Imgproc.cvtColor(croppedLetter, croppedLetter, Imgproc.COLOR_BGR2GRAY);
        Core.bitwise_not(croppedLetter, croppedLetter);

        return croppedLetter;
    }

    Mat croppedSymbol(RotatedRect rect, Mat frame2, Mat rotated) {

        moreCropped = this.crop(rect, frame2, rotated);

        Mat croppedSymbol = new Mat();
        Rect rectCropSymbol = new Rect(new Point(0, 0), new Point(550, 400));
        Size croppedSymbol_size = rectCropSymbol.size();
        Imgproc.getRectSubPix(moreCropped, croppedSymbol_size, new Point(300, 625), croppedSymbol);

        Imgproc.cvtColor(croppedSymbol, croppedSymbol, Imgproc.COLOR_BGR2GRAY);
        Core.bitwise_not(croppedSymbol, croppedSymbol);

        return croppedSymbol;
    }
}
