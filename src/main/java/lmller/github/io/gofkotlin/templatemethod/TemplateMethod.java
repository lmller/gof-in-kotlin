package lmller.github.io.gofkotlin.templatemethod;

public class TemplateMethod {

    public static abstract class Task {
        private long startTime;
        private void beforeWork() {
            startTime = System.currentTimeMillis();
        }
        private void afterWork(){
            long duration = System.currentTimeMillis() - startTime;
            System.out.println(String.format("Work took %d millis", duration));
        }

        protected abstract void work();

        public void execute(){
            beforeWork();
            work();
            afterWork();
        }
    }

    public static class PrintTask extends Task {
        @Override
        protected void work() {
            System.out.println("I'm working...!");
        }
    }


    public static void main(String[] args){
        new TemplateMethod.PrintTask().execute();
    }
}
