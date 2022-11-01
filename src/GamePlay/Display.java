package GamePlay;

import java.util.ArrayList;
import java.util.Scanner;

public class Display {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Character> guessedWord;
    private final ArrayList<String> incorrectLetters = new ArrayList<>();
    private int numBodyParts = 0;

    public String promptGuess() {
        System.out.print("Please guess a letter: ");
        return scanner.nextLine();
    }

    public void displayWarning() {
        System.out.println("Please only enter 1 letter at a time");
    }

    public boolean promptContinue() {
        System.out.print("Would you like to continue playing? Enter y or n: ");
        String continuePrompt = scanner.nextLine();

        if (continuePrompt.equalsIgnoreCase("y")) {
            incorrectLetters.clear(); // Added line 26-27 to reset the incorrect letter list and gallows when the user continues playing
            numBodyParts = 0;
            return true;
        }
        else if (continuePrompt.equalsIgnoreCase("n")) {
            return false;
        }
        else {
            System.out.println("You entered an invalid response! Because you can't follow a simple instruction, you can no longer play");
            return false;
        }
    }

    public boolean useGallows() {
        System.out.print("Would you like to play with gallows? Enter y or n: ");
        String chooseGallows = scanner.nextLine();

        if (chooseGallows.equalsIgnoreCase("y")) {
            return true;
        }
        else if (chooseGallows.equalsIgnoreCase("n")) {
            return false;
        }
        else {
            System.out.println("I'm not sure what that means but you are using the gallows because I said so!");
            return true;
        }
    }

    public void updateGallows() {
        numBodyParts++;
        displayGallows();
    }

    public void displayGallows() {
        switch (numBodyParts) {
            case 0 -> {
                System.out.println(" ____");
                System.out.println("|    |");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|___");
            }
            case 1 -> {
                System.out.println(" ____");
                System.out.println("|    |");
                System.out.println("|    O");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|___");
            }
            case 2 -> {
                System.out.println(" ____");
                System.out.println("|    |");
                System.out.println("|    O");
                System.out.println("|    |");
                System.out.println("|");
                System.out.println("|___");
            }
            case 3 -> {
                System.out.println(" ____");
                System.out.println("|    |");
                System.out.println("|    O");
                System.out.println("|   /|");
                System.out.println("|");
                System.out.println("|___");
            }
            case 4 -> {
                System.out.println(" ____");
                System.out.println("|    |");
                System.out.println("|    O");
                System.out.println("|   /|\\");
                System.out.println("|");
                System.out.println("|___");
            }
            case 5 -> {
                System.out.println(" ____");
                System.out.println("|    |");
                System.out.println("|    O");
                System.out.println("|   /|\\");
                System.out.println("|   /");
                System.out.println("|___");
            }
            case 6 -> {
                System.out.println(" ____");
                System.out.println("|    |");
                System.out.println("|    O");
                System.out.println("|   /|\\");
                System.out.println("|   / \\");
                System.out.println("|___");
            }
        }
    }

    public void displayWelcome() {
        System.out.println("Welcome to Hangman!");
    }

    public void displayNumLetters(String selectedWord) {
        System.out.println("Word Size: " + selectedWord.length());
    }

    public void initializeGuessedWord(String selectedWord) {
        guessedWord = new ArrayList<>();
        for (int i = 0; i < selectedWord.length(); i++) {
            guessedWord.add('_');
        }
    }

    public boolean updateGuessedWord(String selectedWord, String guessedLetter) {
        int numLettersCorrect = 0;
        boolean isInWord = false;

        if (selectedWord.contains(guessedLetter)) {
            for (int i = 0; i < guessedWord.size(); i++) {
                if ((i + 1) < guessedWord.size()) {
                    if (guessedLetter.equals(selectedWord.substring(i, i + 1))) {
                        guessedWord.set(i, guessedLetter.charAt(0));
                        numLettersCorrect++;
                    }
                }
                else {
                    if (guessedLetter.equals(selectedWord.substring(i))) {
                        guessedWord.set(i, guessedLetter.charAt(0));
                        numLettersCorrect++;
                    }
                }
            }

            if (numLettersCorrect == 1) {
                System.out.println("There is " + numLettersCorrect + " " + guessedLetter + " in the word");
            }
            else {
                System.out.println("There are " + numLettersCorrect + " " + guessedLetter + "s in the word");
            }

            isInWord = true;
        }
        else {
            System.out.println("The letter " + guessedLetter + " is not in the word");
            incorrectLetters.add(guessedLetter);
        }

        displayIncorrectLetters();
        displayGuessedWord();
        return isInWord;
    }

    public boolean alreadyGuessed(String guessedLetter) {
        if (guessedWord.contains(guessedLetter.charAt(0)) || incorrectLetters.contains(guessedLetter)) {
            System.out.println("You have already guessed " + guessedLetter + "! Please try again!");
            return true;
        }
        else {
            return false;
        }
    }

    private void displayGuessedWord() {
        for (Character letter : guessedWord) {
            System.out.print(letter + " ");
        }
        System.out.println();
    }

    public boolean isWordGuessed() {
        for (char letter : guessedWord) {
            if (letter == '_') {
                return false;
            }
        }

        return true;
    }

    private void displayIncorrectLetters() {
        System.out.print("Incorrect Letters: ");
        for (String letter : incorrectLetters) {
            System.out.print(letter + " ");
        }
        System.out.println();
    }

    public void displayResult(String selectedWord, int numGuesses, boolean guessedWord, boolean useGallows) {
        if (guessedWord) {
            System.out.println("Congratulations! You guessed the word " + selectedWord + " correctly!");
            if (useGallows) {
                System.out.println("You saved Bowly's life! And it only took you " + numGuesses + " guesses!");
            }
            else {
                System.out.println("And it only took you " + numGuesses + " guesses!");
            }
        }
        else {
            if (useGallows) {
                System.out.println("Oh no! Bowly was hanged for his crimes!");
            }
            System.out.println("The word was " + selectedWord + "! You made " + numGuesses + " guesses!"); // Added a space after numGuesses
        }
    }

    public void displayNumGuesses(int numGuesses, int numIncorrect, int numCorrect) {
        System.out.println("Guesses: " + numGuesses + " Correct: " + numCorrect + " Incorrect: " + numIncorrect);
    }

    public void displayEndGame(int numWords, int numWordsCorrect) {
        if (numWords == 0) {
            System.out.println("You have attempted to guess all of my words!");
        }
        else {
            System.out.println("Thanks for playing!");
        }
        System.out.println("You got " + numWordsCorrect + " word correct out of 10");
    }

    public void displayDivider() {
        System.out.println("//////////////////////////////////");
    }
}
