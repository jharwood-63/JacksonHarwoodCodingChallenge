import GamePlay.Display;
import GamePlay.Words;

public class GameController {
    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        Words words = new Words();
        Display display = new Display();

        boolean continueGame = true;
        int numWords = 10;
        int numWordsCorrect = 0;
        boolean useGallows;
        String selectedWord;
        int numBodyParts;
        int numGuessesMade;
        int numCorrect;
        int numIncorrect;

        display.displayWelcome();
        while (continueGame) {
            selectedWord = words.selectWord();
            display.initializeGuessedWord(selectedWord);
            display.displayNumLetters(selectedWord);

            numBodyParts = 6;
            numGuessesMade = 0;
            numIncorrect = 0;
            numCorrect = 0;
            numWords--;
            useGallows = display.useGallows();

            while (!display.isWordGuessed() && numBodyParts > 0) {
                String guessedLetter = display.promptGuess();
                if (!display.alreadyGuessed(guessedLetter)) {
                    numGuessesMade++;
                    boolean isInWord = display.updateGuessedWord(selectedWord, guessedLetter);

                    if (isInWord) {
                        numCorrect++;
                        if (useGallows) {
                            display.displayGallows();
                        }
                    }
                    else {
                        if (useGallows) {
                            display.updateGallows();
                            numBodyParts--;
                        }

                        numIncorrect++;
                    }
                    display.displayNumGuesses(numGuessesMade, numIncorrect, numCorrect);
                    display.displayDivider();
                }
            }

            if (numBodyParts == 0) {
                // Word was not guessed and the gallows were being used
                display.displayResult(selectedWord, numGuessesMade, false, true);
            }
            else {
                // Word was guessed and gallows may have been used
                display.displayResult(selectedWord, numGuessesMade, true, useGallows);
                numWordsCorrect++;
            }

            if (numWords > 0) {
                continueGame = display.promptContinue();
            }
            else {
                continueGame = false;
            }
        }

        display.displayEndGame(numWords, numWordsCorrect);
    }
}
