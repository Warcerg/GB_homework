package homeworkLesson10;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordCount {
    public static void main(String[] args) {
        String[] wordArray = {"paper", "negotiation", "agreement", "tennis",
                "preference", "perspective", "preference", "agreement",
                "paper", "agreement", "agreement","paper", "assistance",
                "affair", "courage" , "debt", "preference", "paper", "paper" };
        System.out.println(Arrays.toString(wordArray));
        wordCount(wordArray);
    }

    private static void wordCount(String[] wordArray) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, wordArray);
        for (String value : set) {
            int count = 0;
            System.out.print(value + ": ");
            for (String s : wordArray) {
                if (value.equals(s)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
