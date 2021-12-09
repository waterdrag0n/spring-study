package hello.core.singleton;

public class StatefulService {

    private int price;

    public void order(String name, int price) {
        this.price = price; //문제 상황
    }

    public int getPrice() {
        return price;
    }
}
