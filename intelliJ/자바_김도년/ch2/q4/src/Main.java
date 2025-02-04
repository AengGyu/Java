import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tour = scanner.nextLine();
        int numOfMember = scanner.nextInt();
        int nights = scanner.nextInt();
        int airCost = scanner.nextInt();
        int roomCost = scanner.nextInt();

        int day = nights + 1;
        int room = (numOfMember + 1) / 2;
        int total = numOfMember * airCost + room * roomCost * nights;

        System.out.println(numOfMember + " person tour to " + tour + " for "+ day + " days and " + nights + "nights" + " You need " + room + " rooms.");
        System.out.println("The total cost is " + total + ".");
    }
}


/*
Jeju Island 여행
5 인원
4 숙박
250000 1인 항공
150000 숙박

5 person tour to Jeju Island for 5 days and 4 nights You need 3 rooms.
The total cost is 3050000.
*/
