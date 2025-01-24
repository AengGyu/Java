package hello.notifier;

import hello.user.User;

public interface Notifier {
    void send(String message, User recipient);
}
