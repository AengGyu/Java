package collection.list.test.ex2;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> cart = new ArrayList<>();
    private int total = 0;

    public void addItem(Item item){
        cart.add(item);
        total += item.getTotalPrice();
    }

    public void displayItems(){
        System.out.println("장바구니 상품 출력");
        for(int i=0;i<cart.size();i++){
            System.out.println("상품명: " + cart.get(i).getName() + ", 합계: " + cart.get(i).getTotalPrice());
        }
        System.out.println("전체 가격 합: " + total);
    }
}
