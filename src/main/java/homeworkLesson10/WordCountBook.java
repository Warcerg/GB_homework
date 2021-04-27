package homeworkLesson10;

import java.io.*;
import java.util.*;

public class WordCountBook {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> wordArray = new ArrayList<>();
        String text = "";
        int smallWordCharCount = 3;
        try {

            fileToStringBuilder(sb);

            text = stringBuilderToString(sb, text);

            stringToArrayList(wordArray, text);

            removeSmallWords(wordArray, smallWordCharCount);

            wordCount(wordArray);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileToStringBuilder(StringBuilder sb) throws IOException {
        var file = new File("src/main/java/homeworkLesson10/text.txt");
        var is = new FileReader(file);
        int n;
        while ((n = is.read()) != -1) {
            sb.append((char) n);
        }
    }

    private static String stringBuilderToString(StringBuilder sb, String text) {
        text += sb.toString();
        text = text.toLowerCase(Locale.ROOT);
        text = removeUnnecessaryChars(text);
        return text;
    }

    private static String removeUnnecessaryChars(String text) {
        char[] delChars = {',', '.', '!', '?', '–', '-', ':', ';', '«', '»'};
        for (char delChar : delChars) {
            text = text.replace(delChar, ' ');
        }
        return text;
    }

    private static void stringToArrayList(ArrayList<String> wordArray, String text) {
        for (String word : text.split("\\s+")) {
            wordArray.add(word);
        }
        System.out.println(wordArray);
    }

    private static void removeSmallWords(ArrayList<String> wordArray, int smallWordCharCount) {
        Iterator itr = wordArray.iterator();
        while (itr.hasNext()) {
            String word = (String) itr.next();
            if (word.length() <= smallWordCharCount) {
                itr.remove();
            }
        }
        wordArray.trimToSize();
        System.out.println(wordArray);
    }

/*    private static void wordCount(ArrayList<String> wordArray) { // Вариант через HashSet по примеру первого задания
        Set<String> set = new HashSet<>();
        set.addAll(wordArray);
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
    }*/

    private static void wordCount(ArrayList<String> wordArray) { // Вариант через HashMap с сохранением кол-ва повторений в values
        HashMap<String, Integer> map = new HashMap<>();
        for (String value : wordArray) {
            map.put(value, 0);
        }
        for (Map.Entry entry : map.entrySet()) {
            int count = 0;
            for (String s : wordArray) {
                if (entry.getKey().equals(s)) {
                    count++;
                }
            }
            entry.setValue(count);
        }
 /*       printMap(map);*/
        sortedMap(map);
    }

    private static void printMap(HashMap<String, Integer> map) {
        Iterator itrSet = map.entrySet().iterator();
        while (itrSet.hasNext()) {
            System.out.println(itrSet.next());
        }
    }


    private static void sortedMap(HashMap<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        Map<Object, Object> sortedMap = new LinkedHashMap<>();
        for (Map.Entry entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
