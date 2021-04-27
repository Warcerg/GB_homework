package homeworkLesson10;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Phonebook {
    public static HashMap<String, String> pb;

    public Phonebook() {
        pb = new HashMap<>();
    }
    public void add(String name, String number){
        pb.put(number, name);
    }

    public void get(String name){
        if(pb.containsValue(name)) {
            System.out.print(name + ": ");
            int n = 0;
            for (Map.Entry<String, String> entry : pb.entrySet()) {
                if (Objects.equals(name, entry.getValue())) {
                    if (n == 0) {
                        System.out.println(entry.getKey());
                        n++;
                    } else {
                        StringBuilder empty = new StringBuilder();
                        for (int i = 0; i <= name.length() + 1; i++) {
                            empty.append(" ");
                        }
                        System.out.println(empty + entry.getKey());
                    }
                }
            }
        } else{
            System.out.println(name + "'s number not found in the phonebook.");
        }
    }

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Tolstoj", "8091345678");
        phonebook.add("Lermontov", "8195673892");
        phonebook.add("Chekhov", "8729671235");
        phonebook.add("Pushkin", "8126671829");
        phonebook.add("Gogol", "8129084356");
        phonebook.add("Dostoevskij", "8959257381");
        phonebook.add("Bulgakov", "8164569867");
        phonebook.add("Chekhov", "8091364397");
        phonebook.add("Dostoevskij", "8121112223");
        phonebook.add("Turgenev", "8468119123");
        phonebook.add("Chekhov", "8458963521");

        phonebook.get("Gogol");
        phonebook.get("Chekhov");
        phonebook.get("Dostoevskij");
        phonebook.get("Solzhenitsyn");

    }

}



