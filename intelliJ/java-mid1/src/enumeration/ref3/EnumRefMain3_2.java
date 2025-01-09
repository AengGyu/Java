package enumeration.ref3;

import static enumeration.ref3.Grade.*;

public class EnumRefMain3_2 {
    public static void main(String[] args) {
        int price = 10000;

        System.out.println("BISIC 등급의 할 금액 : " + Grade.BASIC.discount(price));
        System.out.println("GOLD 등급의 할 금액 : " + Grade.GOLD.discount(price));
        System.out.println("DIAMOND 등급의 할 금액 : " + Grade.DIAMOND.discount(price));
    }
}
