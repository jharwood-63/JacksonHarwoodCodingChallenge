package GamePlay;

import java.util.ArrayList;

public class Display {
    private ArrayList<Character> guessedWord;
    private final ArrayList<String> incorrectLetters = new ArrayList<>();
    private int numBodyParts = 0;

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
                } else {
                    if (guessedLetter.equals(selectedWord.substring(i))) {
                        guessedWord.set(i, guessedLetter.charAt(0));
                        numLettersCorrect++;
                    }
                }
            }

            if (numLettersCorrect == 1) {
                System.out.println("There is " + numLettersCorrect + " " + guessedLetter + " in the word");
            } else {
                System.out.println("There are " + numLettersCorrect + " " + guessedLetter + "s in the word");
            }

            isInWord = true;
        } else {
            System.out.println("The letter " + guessedLetter + " is not in the word");
            incorrectLetters.add(guessedLetter);
        }

        displayIncorrectLetters();
        displayGuessedWord();
        return isInWord;
    }

    public boolean alreadyGuessed(String guessedLetter) {
        return guessedWord.contains(guessedLetter.charAt(0)) || incorrectLetters.contains(guessedLetter);
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

    public void displayResult(String selectedWord, int numGuesses, boolean guessedWord) {
        if (guessedWord) {
            System.out.println("Congratulations! You guessed the word " + selectedWord + " correctly!");
            System.out.println("You saved Bowly's life! And it only took you " + numGuesses + " guesses!");
        }
        else {
            System.out.println("Oh no! Bowly was hanged for his crimes!");
            System.out.println("The word was " + selectedWord + "!");
        }
    }

    public void displayNumGuesses(int numGuesses, int numIncorrect, int numCorrect) {
        System.out.println("Guesses: " + numGuesses + " Correct: " + numCorrect + " Incorrect: " + numIncorrect);
    }
}
