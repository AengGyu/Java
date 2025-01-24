package hello.notifier;

import hello.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {
    private final Notifier notifier;

    @Autowired
    public NotificationService(@Qualifier("pushNotifier") Notifier notifier) {
        this.notifier = notifier;
    }

    public void notifyUser(User user, String message){
        notifier.send(message,user);
    }
}
