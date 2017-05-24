package lmller.github.io.gofkotlin.singleton;

import java.util.HashMap;
import java.util.Map;

public class Singleton {
    public static class Dictionary {

        private static final Dictionary INSTANCE = new Dictionary();

        private Map<String, String> definitions = new HashMap<>();

        private Dictionary() {
            definitions.put("singleton", "a single person or thing of the kind under consideration");
            definitions.put("pattern", "a model or design used as a guide in needlework and other crafts");
            definitions.put("kotlin", "a Russian island, located near the head of the Gulf of Finland");
        }

        public static Dictionary get() {
            return INSTANCE;
        }

        public void addWord(String word, String definition){
            definitions.put(word.toLowerCase(), definition);
        }

        public String getDefinition(String word) {
            return definitions.get(word.toLowerCase());
        }
    }

    public static void main(String[] args) {
        System.out.println("Did you know that: ");

        fun1();
        fun2();
        fun1();
    }

    static void fun1(){
        Dictionary d = Dictionary.get();
        String word = "kotlin";
        System.out.println(word + " is " + d.getDefinition(word));
    }

    static void fun2(){
        Dictionary d = Dictionary.get();
        String word = "kotlin";
        d.addWord(word, "an awesome programming language created by JetBrains");
    }

}
