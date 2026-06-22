package designprinciples.singleton;

public class TestSingleton {

    public static void main(String[] args) {

        Logger obj1 = Logger.getInstance();
        obj1.log("First message");

        Logger obj2 = Logger.getInstance();
        obj2.log("Second message");

        System.out.println(obj1 == obj2);
    }
}