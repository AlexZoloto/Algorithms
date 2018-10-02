package ru.zolotarev.algorithms_structures;

public class AverageOfArray {
    private int[] numbers = {1, 2, 3, 4, 5, 6, 7};
    private int averageNumberArray;

    void foundAverageNumberArray(){
        for (int i = 0; i < numbers.length; i++) {
            averageNumberArray += numbers[i];
        }
        averageNumberArray = averageNumberArray / numbers.length;
        System.out.println(averageNumberArray);
    }

    void getInfoAverageNumberArray(){
        System.out.println(averageNumberArray);
    }
}
