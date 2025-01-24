package hello.notifier;

import hello.user.User;
import org.springframework.stereotype.Component;

@Component
public class SMSNotifier implements Notifier{
    @Override
    public void send(String message, User recipient) {
        System.out.println("SMS sent to " + recipient + ": " + message);
    }

    @Override
    public String toString() {
        return "SMSNotifier{}";
    }
}
