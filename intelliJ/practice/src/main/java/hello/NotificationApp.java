package hello;


import hello.notifier.NotificationService;
import hello.user.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NotificationApp {
    public static void main(String[] args) {
        User user = new User(1L, "userA", "userA@example.com", "010-1234-5678");
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        NotificationService notificationService = ac.getBean(NotificationService.class);

        notificationService.notifyUser(user, "hello, Spring DI");
    }
}
