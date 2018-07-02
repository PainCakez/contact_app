package sample;

import org.opencv.core.*;
import org.opencv.core.Point;
import org.opencv.imgproc.Imgproc;

import java.awt.*;
import java.util.List;


class GenerateRect {

    private Angle angle = new Angle();
    private Evaluation eva = new Evaluation();
    private RotAndCrop rac = new RotAndCrop();

    private Mat rotated = new Mat();

    Mat detectedCards(List<MatOfPoint> contours, Mat frame2) {
        for (MatOfPoint contour : contours) {

            double tempA = Imgproc.contourArea(contour);
            if (tempA > 10000) {

                MatOfPoint2f temp = new MatOfPoint2f(contour.toArray());

                MatOfPoint2f approxCurve = new MatOfPoint2f();
                Imgproc.approxPolyDP(temp, approxCurve,
                        Imgproc.arcLength(temp, true) * 0.02, true);

                if (approxCurve.total() == 4) {
                    double maxCosine = 0;

                    List<Point> curves = approxCurve.toList();
                    for (int j = 2; j < 5; j++) {

                        double cosine = Math.abs(angle.angle(curves.get(j % 4),
                                curves.get(j - 2), curves.get(j - 1)));
                        maxCosine = Math.max(maxCosine, cosine);
                    }

                    if (maxCosine < 0.3) {
                        MatOfPoint maxMatOfPoint = contours.get(contours.indexOf(contour));
                        MatOfPoint2f maxMatOfPoint2f = new MatOfPoint2f(maxMatOfPoint.toArray());
                        RotatedRect rect = Imgproc.minAreaRect(maxMatOfPoint2f);

                        Point points[] = new Point[4];
                        rect.points(points);
                        for (int i = 0; i < 4; ++i) {
                            Imgproc.line(frame2, points[i], points[(i + 1) % 4], new Scalar(255, 0, 0), 2);
                        }

                        Mat croppedLetter = rac.croppedLetter(rect, frame2, rotated);
                        Mat croppedSymbol = rac.croppedSymbol(rect, frame2, rotated);

                        //Imgcodecs.imwrite("Jack.jpg", croppedLetter);
                        //Imgcodecs.imwrite("Pic.jpg", croppedSymbol);

                        String L = eva.compareLetter(croppedLetter);
                        String S = eva.compareSymbol(croppedSymbol);

                        Imgproc.putText(frame2, L + S, (rect.boundingRect().tl()), 4, 2, new Scalar(255,100,0));
                        //System.out.println(L+S);

                        // Rect rectCrop = new Rect(new Point(0,0), new Point(22,50));
                    }
                }
            }
        }
        return frame2;
    }
}
