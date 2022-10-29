package GamePlay;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Words {
    private final List<String> wordList;
    private final int[] usedWordList = {0,0,0,0,0,0,0,0,0,0};

    public Words() {
        wordList = initializeWordList();
    }

    private List<String> initializeWordList() {
        String[] words = {"clock", "picture", "mattress", "mountain", "dinosaur", "blanket", "basket", "hotel", "computer", "clarinet"};
        return Arrays.asList(words);
    }

    public String selectWord() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(wordList.size());

        while (usedWordList[randomIndex] == 1) {
            randomIndex = rand.nextInt(wordList.size());
        }

        String selectedWord = wordList.get(randomIndex);
        usedWordList[randomIndex] = 1;

        return selectedWord;
    }
}
