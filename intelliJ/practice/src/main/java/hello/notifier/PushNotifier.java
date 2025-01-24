package hello.notifier;

import hello.user.User;
import org.springframework.stereotype.Component;

@Component
public class PushNotifier implements Notifier{

    @Override
    public void send(String message, User recipient) {
        System.out.println("Push notification sent to " + recipient.getName() + ": " + message);
    }

    @Override
    public String toString() {
        return "PushNotifier{}";
    }
}
