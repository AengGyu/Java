package enumeration.ref3;

public class EnumRefMain3_4 {
    public static void main(String[] args) {
        int price = 10000;
        Grade[] values = Grade.values();
        for (Grade value : values) {
            printDiscount(value, price);
        }
    }
    public static void printDiscount(Grade grade, int price){
        System.out.println(grade + " 등급의 할인 금액 : " + grade.discount(price));
    }
}
