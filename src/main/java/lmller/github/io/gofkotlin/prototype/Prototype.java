package lmller.github.io.gofkotlin.prototype;

public class Prototype {
    public static class EMail {

        private String recipient;
        private String subject;

        private String message;

        public EMail(String recipient, String subject, String message) {
            this.recipient = recipient;
            this.subject = subject;
            this.message = message;
        }

        private EMail(EMail src){
            this.recipient = src.recipient;
            this.subject = src.subject;
            this.message = src.message;
        }


        public EMail copy() {
            return new EMail(this);
        }
    }

    public static void main(String[] args) {
        EMail mail = new EMail("abc@example.com", "Hello", "Don't know what to write.");

        EMail copy = mail.copy();

        copy.recipient = "other@example.com";

        System.out.println("Email1 goes to " + mail.recipient + " with subject " + mail.subject);
        System.out.println("Email2 goes to " + copy.recipient + " with subject " + copy.subject);
    }
}
