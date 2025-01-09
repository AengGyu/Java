package enumeration.test;

import java.util.Scanner;

public class AuthGradeMain2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("당신의 등급을 입력하세요[GUEST, LOGIN, ADMIN]:");
        String grade = scanner.next();
        AuthGrade authGrade = AuthGrade.valueOf(grade.toUpperCase());
        System.out.println("당신의 등급은 " + authGrade.getDescription() + "등급입니다.");
        printMenu(authGrade);
    }
    public static void printMenu(AuthGrade authGrade){
        if(AuthGrade.GUEST == authGrade){
            System.out.println("==메뉴 목록==");
            System.out.println("-메인 화면");
        }else if(AuthGrade.LOGIN == authGrade){
            System.out.println("==메뉴 목록==");
            System.out.println("-메인 화면");
            System.out.println("-이메일 관리 화면");
        }else if(AuthGrade.ADMIN == authGrade){
            System.out.println("==메뉴 목록==");
            System.out.println("-메인 화면");
            System.out.println("-이메일 관리 화면");
            System.out.println("-관리자 화면");
        }
    }
}
