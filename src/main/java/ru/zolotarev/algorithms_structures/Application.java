package main.java.ru.zolotarev.algorithms_structures;

public class Application {
    public static void main(String[] args) {
//        System.out.println(recPower(2, 9));
        TowersofHanoi towersofHanoi = new TowersofHanoi();
        towersofHanoi.moveTower(3, 1,2,3);
    }

    private static int recPower(int base, int sign) {
        if (sign == 0) return 1;
        if (sign % 2 == 0){
            return recPower(base * base, sign/2);
        }
        else {
            return base * recPower(base, --sign);
        }
    }
}