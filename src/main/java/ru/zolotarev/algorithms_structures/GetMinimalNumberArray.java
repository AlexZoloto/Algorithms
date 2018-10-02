package main.java.ru.zolotarev.algorithms_structures;

public class GetMinimalNumberArray {
    private int[] numbers = {4, 1, 7};
    private int minNumber = numbers[0];
    void foundMinNumber(){
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < minNumber){
                minNumber = numbers[i];
            }
        }
    }
    void getInfoMinNumberArray(){
        System.out.println(minNumber);
    }
}
