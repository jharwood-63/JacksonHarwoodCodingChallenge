import GamePlay.Display;
import GamePlay.Hangman;

import java.util.Scanner;

public class GameController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hangman hangman = new Hangman();
        Display display = new Display();

        boolean continueGame = true;
        int numWords = 10;
//        int numWordsCorrect = 0;
        boolean useGallows;
        String selectedWord;
        int numBodyParts;
        int numGuessesMade;
        int numCorrect;
        int numIncorrect;

        display.displayWelcome();
        while (continueGame && numWords > 0) {
            selectedWord = hangman.selectWord();
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
                        //update the gallows
                        if (useGallows) {
                            numBodyParts--;
                        }

                        numIncorrect++;
                    }
                }
                else {
                    System.out.println("You have already guessed " + guessedLetter + "! Please try again!");
                }
                display.displayNumGuesses(numGuessesMade, numIncorrect, numCorrect);
            }

            display.displayResult(selectedWord, numGuessesMade, !(numBodyParts == 0));

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
    }
}
