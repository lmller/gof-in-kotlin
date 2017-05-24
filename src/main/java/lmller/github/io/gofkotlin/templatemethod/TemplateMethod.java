package lmller.github.io.gofkotlin.templatemethod;

public class TemplateMethod {
    
    public static abstract class Task {

        protected abstract void beforeWork();
        protected abstract void afterWork();
        
        public void execute(){
            beforeWork();
            System.out.println("Working...");
            afterWork();
        }
    }

    public static class TimeTrackingTask extends Task {
        private long startTime;

        @Override
        protected void beforeWork() {
            startTime = System.currentTimeMillis();
        }

        @Override
        protected void afterWork() {
            long duration = System.currentTimeMillis() - startTime;
            System.out.println("Work took " + duration + " millis");
        }
    }


    public static void main(String[] args){
        new TimeTrackingTask().execute();
    }
}
