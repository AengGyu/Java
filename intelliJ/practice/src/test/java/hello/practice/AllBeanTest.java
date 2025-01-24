package hello.practice;

import hello.AutoAppConfig;
import hello.notifier.Notifier;
import hello.user.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllNotifier(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, NotificationService.class);

        NotificationService notificationService = ac.getBean(NotificationService.class);
        User userA = new User(1L, "userA", "userA@aaa.com", "010-1234-5678");
        notificationService.notifyUser(userA, "Hi, Spring", "pushNotifier");

        Assertions.assertThat(notificationService).isInstanceOf(NotificationService.class);
    }

    static class NotificationService{
        private final Map<String, Notifier> notifierMap;

        public NotificationService(Map<String, Notifier> notifierMap) {
            this.notifierMap = notifierMap;
            System.out.println("notifierMap = " + notifierMap);
        }

        public void notifyUser(User user, String message, String notifierType){
            Notifier notifier = notifierMap.get(notifierType);

            System.out.println("notifierType = " + notifierType);
            System.out.println("notifier = " + notifier);

            notifier.send(message, user);
        }
    }
}
