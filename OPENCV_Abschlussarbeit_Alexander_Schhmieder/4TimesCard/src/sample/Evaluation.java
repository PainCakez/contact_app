package sample;

import org.opencv.core.Mat;

import java.util.Arrays;

class Evaluation {

    private CardTemplates template = new CardTemplates();

    String compareLetter(Mat croppedLetter) {

        double letters[] = template.lettersToArray(croppedLetter);
        double lettersRanking[] = template.lettersToArray(croppedLetter);

        Arrays.sort(lettersRanking);

        String letter = "";

        if (lettersRanking[0] == letters[0]) {
            letter = "Ass";
        } else if (lettersRanking[0] == letters[1]) {
            letter = "King";
        } else if (lettersRanking[0] == letters[2]) {
            letter = "Queen";
        } else if (lettersRanking[0] == letters[3]) {
            letter = "Jack";
        }

        //System.out.println(lettersRanking[3]);
        //System.out.println(letters[0] + " + " + letters[1] + " + " + letters[2] + " + " + letters[3]);

        return letter;
    }

    String compareSymbol(Mat croppedSymbol) {

        double symbols[] = template.symbolsToArray(croppedSymbol);
        double symbolsRanking[] = template.symbolsToArray(croppedSymbol);

        Arrays.sort(symbolsRanking);

        String letter = "";

        if (symbolsRanking[0] == symbols[0]) {
            letter = "Karo";
        } else if (symbolsRanking[0] == symbols[1]) {
            letter = "Cross";
        } else if (symbolsRanking[0] == symbols[2]) {
            letter = "Pic";
        } else if (symbolsRanking[0] == symbols[3]) {
            letter = "Herz";
        }

        //System.out.println(symbols[0] + "+" +symbols[1]+ "+" +symbols[2]+ "+" + symbols[3]);
        //System.out.println(symbolsRanking[0] + "+" +symbolsRanking[1]+ "+" +symbolsRanking[2]+ "+" + symbolsRanking[3]);

        return letter;
    }
}
