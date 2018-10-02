package main.java.ru.zolotarev.algorithms_structures;


import java.util.Scanner;

public class Application {
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Возведение в степень");
        System.out.println(extendNumber(getNumber(), getPowerNumber()));

        GetMinimalNumberArray getMinimalNumberArray = new GetMinimalNumberArray();
        getMinimalNumberArray.foundMinNumber();
        getMinimalNumberArray.getInfoMinNumberArray();

        AverageOfArray averageOfArray = new AverageOfArray();
        averageOfArray.foundAverageNumberArray();
        averageOfArray.getInfoAverageNumberArray();
    }

    private static int getNumber(){
        System.out.println("Введите число");
        String numberScanner = scanner.next();
        int number = Integer.valueOf(numberScanner);
        return number;
    }
    private static int getPowerNumber(){
        System.out.println("Введите степень");
        String powerNumberScanner = scanner.next();
        int powerNumber = Integer.valueOf(powerNumberScanner);
        return powerNumber;
    }
    private static int extendNumber(int number, int powerNumber){
        int result = 1;
        for (int i = 0; i < powerNumber - 1; i++) {
            result = result * number;
        }
        return result * number;
    }

}
