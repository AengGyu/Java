package enumeration.test;

public class AuthGradeMain1 {
    public static void main(String[] args) {
        AuthGrade[] values = AuthGrade.values();
        for (AuthGrade value : values) {
            printAuthGrade(value);
        }
    }
    public static void printAuthGrade(AuthGrade grade){
        System.out.println("grade=" + grade + ", level=" + grade.getLevel() + ", 설명=" + grade.getDescription());
    }
}
