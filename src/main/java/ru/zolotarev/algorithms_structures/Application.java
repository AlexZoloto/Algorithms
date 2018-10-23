package main.java.ru.zolotarev.algorithms_structures;

import java.util.ArrayList;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        final int TREES = 20;
        int balanced = 0;
        for (int i = 0; i < TREES; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            randomNumber(a, 100);
            Tree tree = new Tree(a);
            balanced += (tree.isBalanced(false)) ? 1 : 0;
        }
        System.out.println(balanced * 100f / TREES + "%");
    }

    public static void randomNumber(ArrayList<Integer> a, int count){
        Random r = new Random();
        while (a.size() < count){
            int num = r.nextInt();
            if (!a.contains(num)){
                a.add(num);
            }
        }
    }
}