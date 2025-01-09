package time.test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TestLoopPlus {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2024, 1, 1);

        for (int i = 0; i < 5; i++) {
            // 방법1
//            System.out.println("날짜"+ i+1 + ": " + localDate.plusDays(14*i));
            //방법 2
//            LocalDate nextDate = localDate.plus(2 * i, ChronoUnit.WEEKS);
//            System.out.println("날짜" + i + 1 + ": " + nextDate);
            //방법 3
            LocalDate nextDate = localDate.plusWeeks(2 * i);
            System.out.println("날짜" + i + 1 + ": " + nextDate);
        }
    }
}
