package lmller.github.io.gofkotlin.decorator;

public class Decorator {
    public interface Text {
        void draw();
    }

    public static class DefaultText implements Text {
        private String text;

        public DefaultText(String text){
            this.text = text;
        }
        @Override
        public void draw() {
            System.out.print(text);
        }
    }

    public static abstract class TextDecorator implements Text {
        protected Text decorated;
        public TextDecorator(Text decorated) {
            this.decorated = decorated;
        }

        @Override
        public void draw() {
            decorated.draw();
        }
    }

    public static class Underline extends TextDecorator {

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

    public static class Background extends TextDecorator {

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
        new Background(new Underline(new DefaultText("Hallo"))).draw();
    }

}
