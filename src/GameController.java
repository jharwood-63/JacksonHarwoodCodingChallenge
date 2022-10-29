import GamePlay.Display;
import GamePlay.Words;

import java.util.Scanner;

public class GameController {
    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
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
        while (continueGame && numWords > 0) {
            selectedWord = words.selectWord();
            display.initializeGuessedWord(selectedWord);
            display.displayNumLetters(selectedWord);

            useGallows = false;
            numBodyParts = 6;
            numGuessesMade = 0;
            numIncorrect = 0;
            numCorrect = 0;
            numWords--;

            System.out.print("Would you like to play with gallows? Enter y or n: ");
            String chooseGallows = scanner.nextLine();
            if (chooseGallows.equalsIgnoreCase("y")) {
                useGallows = true;
                display.displayGallows();
            }

            while (!display.isWordGuessed() && numBodyParts > 0) {
                System.out.print("Please guess a letter: ");
                String guessedLetter = scanner.nextLine();
                if (!display.alreadyGuessed(guessedLetter)) {
                    numGuessesMade++;
                    boolean isInWord = display.updateGuessedWord(selectedWord, guessedLetter);
                    if (isInWord) {
                        numCorrect++;
                    } else {
                        if (useGallows) {
                            display.updateGallows();
                            numBodyParts--;
                        }

                        numIncorrect++;
                    }
                    display.displayNumGuesses(numGuessesMade, numIncorrect, numCorrect);
                }
                else {
                    System.out.println("You have already guessed " + guessedLetter + "! Please try again!");
                }
            }

            if (numBodyParts == 0) {
                display.displayResult(selectedWord, numGuessesMade, false);
            }
            else {
                display.displayResult(selectedWord, numGuessesMade, true);
                numWordsCorrect++;
            }

            System.out.print("Would you like to continue playing? Enter y or n: ");
            String continuePrompt = scanner.nextLine();
            continueGame = continuePrompt.equalsIgnoreCase("y");
        }

        if (numWords == 0) {
            System.out.println("You have attempted to guess all of my words!");
        }
        else {
            System.out.println("Thanks for playing!");
        }
        System.out.println("You got " + numWordsCorrect + " correct out of 10");
    }
}
