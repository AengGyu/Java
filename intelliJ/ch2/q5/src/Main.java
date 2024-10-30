import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stu1 = scanner.next();
        int stu1_late = scanner.nextInt();
        int stu1_abs = scanner.nextInt();

        String stu2 = scanner.next();
        int stu2_late = scanner.nextInt();
        int stu2_abs = scanner.nextInt();

        int stu1_deduction = stu1_late * 3 + stu1_abs * 8;
        int stu2_deduction = stu2_late * 3 + stu2_abs * 8;

        int stu1_att = 100 - stu1_deduction;
        int stu2_att = 100 - stu2_deduction;

        System.out.println(stu1_deduction+" points will be deducted from the attendance points of " + stu1 + ".");
        System.out.println(stu2_deduction+" points will be deducted from the attendance points of " + stu2 + ".");

        if(stu1_deduction < stu2_deduction) {
            System.out.println(stu1 + " attendance points are greater than " + stu2 + ".");
            System.out.println(stu1 + " attendance points are " + stu1_att + ".");
        }
        else if(stu1_deduction > stu2_deduction) {
            System.out.println(stu2 + " attendance points are greater than " + stu1 + ".");
            System.out.println(stu2 + " attendance points are " + stu2_att + ".");
        }
        else {
            System.out.println("equal");
        }
    }
}


//SonHeungMin 4 3 
//KimMinJae 2 4

//36 points will be deducted from the attendance points of SonHeungMin. 
//38 points will be deducted from the attendance points of KimMinJae. 
//SonHeungMin attendance points are greater than KimMinJae.
//SonHeungMin attendance points are 64.