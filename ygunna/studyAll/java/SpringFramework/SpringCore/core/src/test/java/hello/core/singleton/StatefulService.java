package hello.core.singleton;

public class StatefulService {

    // 무상태를 위해 주석 처리private int price; // 상태를 유지하는 필드
    
    public int order(String name, int price) {
        System.out.println("name  = " + name + " price = " + price);
        // 무상태를 위해 주석 this.price = price; // 여기가 문제!
        return price;
    }

    /*  무상태 때문에 필요없음.
    public int getPrice() {
        // return price;

    }
     */
}
