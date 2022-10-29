import GamePlay.Display;
import GamePlay.Hangman;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GameController {
    public static void main(String[] args) {
        Hangman hangman = new Hangman();
        Display display = new Display();

        display.displayWelcome();
        String selectedWord = hangman.selectWord();


    }
}
