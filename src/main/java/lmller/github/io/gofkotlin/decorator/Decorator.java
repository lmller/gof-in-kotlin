package lmller.github.io.gofkotlin.decorator;

public class Decorator {
    public interface Text {
        void draw();
    }

    public static class PrintedText implements Text {
        private String text;

        public PrintedText(String text){
            this.text = text;
        }
        @Override
        public void draw() {
            System.out.print(text);
        }
    }

    public static abstract class TextEffect implements Text {
        protected Text decorated;
        public TextEffect(Text decorated) {
            this.decorated = decorated;
        }

        @Override
        public void draw() {
            decorated.draw();
        }
    }

    public static class Underline extends TextEffect {

        public Underline(Text decorated) {
            super(decorated);
        }

        @Override
        public void draw() {
            drawUnderline();
            super.draw();
            drawUnderline();
        }

        private void drawUnderline() {
            System.out.print("_");
        }
    }

    public static class Background extends TextEffect {

        public Background(Text decorated) {
            super(decorated);
        }

        @Override
        public void draw() {
            drawBackground();
            super.draw();
            resetBackground();
        }

        private void drawBackground() {
            System.out.print("\u001B[43m");
        }

        private void resetBackground() {
            System.out.print("\u001B[0m");
        }
    }

    public static void main(String[] args) {
        new Background(new Underline(new PrintedText("Hallo"))).draw();
    }

}
