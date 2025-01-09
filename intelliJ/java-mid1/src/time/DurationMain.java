package time;

import java.time.Duration;
import java.time.LocalTime;

public class DurationMain {
    public static void main(String[] args) {
        Duration duration = Duration.ofMinutes(30);
        System.out.println("duration = " + duration);

        LocalTime lt = LocalTime.of(1, 0);
        System.out.println("lt = " + lt);

        LocalTime plusTime = lt.plus(duration);
        System.out.println("더한 시간 = " + plusTime);

        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(10, 0);
        Duration between = Duration.between(startTime, endTime);
        System.out.println("차이 : " + between.getSeconds() + "초");
        System.out.println("근무 시간 : " + between.toHours() + "시간 " + between.toMinutesPart()+ "분");
    }
}
