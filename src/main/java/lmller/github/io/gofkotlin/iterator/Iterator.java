package lmller.github.io.gofkotlin.iterator;

import java.util.Arrays;
import java.util.List;

public class Iterator {
    public static class Sentence {
        private final List<String> words;

        public Sentence(List<String> words) {
            this.words = words;
        }

        public List<String> getWords() {
            return words;
        }
    }

    public static class IterableSentence extends Sentence implements Iterable<String> {

        public IterableSentence(List<String> words) {
            super(words);
        }

        @Override
        public java.util.Iterator<String> iterator() {
            return getWords().iterator();
        }
    }

    public static void main(String[] args) {
        String[] sentence = "This is not the greatest example in the world".split(" ");
        List<String> words = Arrays.asList(sentence);

        for (String s1 : new Sentence(words).getWords()) {
            //not so cool
        }

        for (String s1 : new IterableSentence(words)) {
            //better
        }

    }
}
