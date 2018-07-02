package sample;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

class CardTemplates {

    private Mat templateAss = Imgcodecs.imread("resources/letter/Ass.jpg", Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);
    private Mat templateKing = Imgcodecs.imread("resources/letter/King.jpg", Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);
    private Mat templateQueen = Imgcodecs.imread("resources/letter/Queen.jpg", Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);
    private Mat templateJack = Imgcodecs.imread("resources/letter/Jack.jpg", Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);

    private Mat templateKaro = Imgcodecs.imread("resources/Symbol/Karo.jpg", Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);
    private Mat templateCross = Imgcodecs.imread("resources/Symbol/Cross.jpg", Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);
    private Mat templatePic = Imgcodecs.imread("resources/Symbol/Pic.jpg", Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);
    private Mat templateHerz = Imgcodecs.imread("resources/Symbol/Herz.jpg", Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);

    double[] lettersToArray(Mat croppedLetter) {
        double ass = compareLetterAss(croppedLetter);
        double king = compareLetterKing(croppedLetter);
        double queen = compareLetterQueen(croppedLetter);
        double jack = compareLetterJack(croppedLetter);

        return new double[]{ass, king, queen, jack};
    }

    private double compareLetterAss(Mat croppedLetter) {
        int resultLetter_cols = croppedLetter.cols() - templateAss.cols() + 1;
        int resultLetter_rows = croppedLetter.rows() - templateAss.rows() + 1;

        Mat resultLetter = new Mat(resultLetter_rows, resultLetter_cols, CvType.CV_32FC1);

        Imgproc.matchTemplate(croppedLetter, templateAss, resultLetter, Imgproc.TM_SQDIFF_NORMED);
        //Core.normalize(resultLetter, resultLetter, 0, 255, Core.NORM_MINMAX, -1, new Mat());
        Core.MinMaxLocResult res = Core.minMaxLoc(resultLetter);

        //System.out.println(ass.maxVal);
        return res.minVal;
    }

    private double compareLetterKing(Mat croppedLetter) {
        int resultLetter_cols = croppedLetter.cols() - templateKing.cols() + 1;
        int resultLetter_rows = croppedLetter.rows() - templateKing.rows() + 1;

        Mat resultLetter = new Mat(resultLetter_rows, resultLetter_cols, CvType.CV_32FC1);

        Imgproc.matchTemplate(croppedLetter, templateKing, resultLetter, Imgproc.TM_SQDIFF_NORMED);
        //Core.normalize(resultLetter, resultLetter, 0, 255, Core.NORM_MINMAX, -1, new Mat());
        Core.MinMaxLocResult res = Core.minMaxLoc(resultLetter);

        //System.out.println(king.maxVal);
        return res.minVal;
    }

    private double compareLetterQueen(Mat croppedLetter) {
        int resultLetter_cols = croppedLetter.cols() - templateQueen.cols() + 1;
        int resultLetter_rows = croppedLetter.rows() - templateQueen.rows() + 1;

        Mat resultLetter = new Mat(resultLetter_rows, resultLetter_cols, CvType.CV_32FC1);

        Imgproc.matchTemplate(croppedLetter, templateQueen, resultLetter, Imgproc.TM_SQDIFF_NORMED);
        //Core.normalize(resultLetter, resultLetter, 0, 255, Core.NORM_MINMAX, -1, new Mat());
        Core.MinMaxLocResult res = Core.minMaxLoc(resultLetter);

        //System.out.println(king.maxVal);
        return res.minVal;
    }

    private double compareLetterJack(Mat croppedLetter) {
        int resultLetter_cols = croppedLetter.cols() - templateJack.cols() + 1;
        int resultLetter_rows = croppedLetter.rows() - templateJack.rows() + 1;

        Mat resultLetter = new Mat(resultLetter_rows, resultLetter_cols, CvType.CV_32FC1);

        Imgproc.matchTemplate(croppedLetter, templateJack, resultLetter, Imgproc.TM_SQDIFF_NORMED);
        //Core.normalize(resultLetter, resultLetter, 0, 255, Core.NORM_MINMAX, -1, new Mat());

        Core.MinMaxLocResult res = Core.minMaxLoc(resultLetter);

        //System.out.println(king.maxVal);
        return res.minVal;
    }

    double[] symbolsToArray(Mat croppedSymbol) {
        double karo = compareSymbolKaro(croppedSymbol);
        double cross = compareSymbolCross(croppedSymbol);
        double pic = compareSymbolPic(croppedSymbol);
        double herz = compareSymbolHerz(croppedSymbol);

        return new double[]{karo, cross, pic, herz};
    }

    private double compareSymbolKaro(Mat croppedSymbol) {
        int resultSymbol_cols = croppedSymbol.cols() - templateKaro.cols() + 1;
        int resultSymbol_rows = croppedSymbol.rows() - templateKaro.rows() + 1;

        Mat resultSymbol = new Mat(resultSymbol_rows, resultSymbol_cols, CvType.CV_32FC1);

        Imgproc.matchTemplate(croppedSymbol, templateKaro, resultSymbol, Imgproc.TM_SQDIFF_NORMED);
        //Core.normalize(resultSymbol, resultSymbol, 0, 1, Core.NORM_MINMAX, -1, new Mat());

        Core.MinMaxLocResult res = Core.minMaxLoc(resultSymbol);

        //System.out.println(res.minVal);
        return res.minVal;
    }

    private double compareSymbolCross(Mat croppedSymbol) {
        int resultSymbol_cols = croppedSymbol.cols() - templateCross.cols() + 1;
        int resultSymbol_rows = croppedSymbol.rows() - templateCross.rows() + 1;

        Mat resultSymbol = new Mat(resultSymbol_rows, resultSymbol_cols, CvType.CV_32FC1);

        Imgproc.matchTemplate(croppedSymbol, templateCross, resultSymbol, Imgproc.TM_SQDIFF_NORMED);
        //Core.normalize(resultSymbol, resultSymbol, 0, 1, Core.NORM_MINMAX, -1, new Mat());

        Core.MinMaxLocResult res = Core.minMaxLoc(resultSymbol);

        //System.out.println(res.minVal);
        return res.minVal;
    }

    private double compareSymbolPic(Mat croppedSymbol) {
        int resultSymbol_cols = croppedSymbol.cols() - templatePic.cols() + 1;
        int resultSymbol_rows = croppedSymbol.rows() - templatePic.rows() + 1;

        Mat resultSymbol = new Mat(resultSymbol_rows, resultSymbol_cols, CvType.CV_32FC1);

        Imgproc.matchTemplate(croppedSymbol, templatePic, resultSymbol, Imgproc.TM_SQDIFF_NORMED);
        //Core.normalize(resultSymbol, resultSymbol, 0, 1, Core.NORM_MINMAX, -1, new Mat());

        Core.MinMaxLocResult res = Core.minMaxLoc(resultSymbol);

        return res.minVal;
    }

    private double compareSymbolHerz(Mat croppedSymbol) {
        int resultSymbol_cols = croppedSymbol.cols() - templateHerz.cols() + 1;
        int resultSymbol_rows = croppedSymbol.rows() - templateHerz.rows() + 1;

        Mat resultSymbol = new Mat(resultSymbol_rows, resultSymbol_cols, CvType.CV_32FC1);

        Imgproc.matchTemplate(croppedSymbol, templateHerz, resultSymbol, Imgproc.TM_SQDIFF_NORMED);
        //Core.normalize(resultSymbol, resultSymbol, 0, 1, Core.NORM_MINMAX, -1, new Mat());

        Core.MinMaxLocResult res = Core.minMaxLoc(resultSymbol);

        return res.minVal;
    }
}
