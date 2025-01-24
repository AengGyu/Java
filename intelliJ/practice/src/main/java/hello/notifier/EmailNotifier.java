package hello.notifier;

import hello.user.User;
import org.springframework.stereotype.Component;

@Component
public class EmailNotifier implements Notifier{

    @Override
    public void send(String message, User recipient) {
        System.out.println("Email sent to " + recipient.getEmail() + ": " + message);
    }

    @Override
    public String toString() {
        return "EmailNotifier{}";
    }
}
