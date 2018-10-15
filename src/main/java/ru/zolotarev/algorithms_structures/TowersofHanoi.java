package main.java.ru.zolotarev.algorithms_structures;

 class TowersofHanoi {

    void moveTower(int rings, int startTower, int finalTower, int tempTower){
        if (rings == 0){
            return;
        }
        moveTower(rings-1, startTower, tempTower, finalTower);
        System.out.println("Переместить кольцо из основания № " + startTower + " в основание №" + finalTower);
        moveTower(rings-1, tempTower, finalTower, startTower);
    }
}
