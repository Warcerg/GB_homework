package homeworkLesson3;

import java.util.Scanner;

public class exercise2 {

    public static void main(String[] args) {

        char[] guessArr = new char[15];
        for (int i = 0; i < guessArr.length; i++) {
            guessArr[i] = '#';
        }
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println("Let's play fruits&veggies guessing game! try to guess a word");
        playGame(guessArr, words);
    }

    private static void playGame(char[] array, String[] words) {
        String word = pickingRandomWord(words);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String userWord = scanner.next();
            if (word.equals(userWord)) {
                System.out.println("You guessed it right! Congratulations!");
                break;
            } else {
                checkCharacter(array, word, userWord);
            }
            printGuessArr(array);
        }
    }

    private static String pickingRandomWord(String[] array) {
        int i = (int) (Math.random() * array.length);
        return array[i];
    }

    private static void checkCharacter(char[] array, String word, String userWord) {
        for (int j = 0; j < word.length() & j < userWord.length(); j++) {
            if (word.charAt(j) == userWord.charAt(j)) {
                array[j] = word.charAt(j);
            }
        }
    }

    private static void printGuessArr(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%c", array[i]);
        }
        System.out.println();
    }
}
