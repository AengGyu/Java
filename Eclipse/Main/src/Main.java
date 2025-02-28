import java.util.Scanner;
import java.util.Calendar;

import java.util.Random;
public class Main {
	public static void printCalendar(String msg, Calendar cal) {
		int year = cal.get(Calendar.YEAR);
		
		int month = cal.get(Calendar.MONTH + 1);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int hour = cal.get(Calendar.HOUR);
		int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);
		int ampm = cal.get(Calendar.AM_PM);
		int minute = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		int milsec = cal.get(Calendar.MILLISECOND);
		
		System.out.print(msg + year + "/" + month + "/" + day + "/");
		switch(dayOfWeek) {
		case Calendar.SUNDAY : System.out.print("일요일"); break;
		case Calendar.MONDAY : System.out.print("월요일"); break;
		case Calendar.TUESDAY : System.out.print("화요일"); break;
		case Calendar.WEDNESDAY : System.out.print("수요일"); break;
		case Calendar.THURSDAY : System.out.print("목요일"); break;
		case Calendar.FRIDAY: System.out.print("금요일"); break;
		case Calendar.SATURDAY : System.out.print("토요일"); break;
		}
		System.out.print("(" + hourOfDay + "시)");
		if(ampm == Calendar.AM) System.out.print("오전");
		else System.out.print("오후");
		System.out.println(hour + "시 " + minute + "분 " + sec + "초" + milsec +"밀리초");
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2024);
		cal.set(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 5);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(dayOfWeek);
		
		scanner.close();
	}
}
