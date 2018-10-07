package main.java.ru.zolotarev.algorithms_structures;

public class Application {

    public static void main(String[] args) {
        Array array = new Array(3, 5, 2, 8, 4, 2, 6, 3, 4, 7, 1, 8, 5, 9, 3, 1);
        Array array1 = new Array(3, 2, 6, 4, 7, 9, 1, 4);
        array.getInfo();
        System.out.println("-------------");
        array.delete();
        array.getInfo();
        System.out.println("-------------");
        array.delete(1);
        array.getInfo();
        System.out.println("-------------");
        array.deleteValue(2);
        array.getInfo();
        System.out.println("-------------");
        array.sortBubbleV3();
        array.getInfo();
        System.out.println("133344567889");
    }
}