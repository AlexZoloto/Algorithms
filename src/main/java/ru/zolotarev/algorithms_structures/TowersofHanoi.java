package main.java.ru.zolotarev.algorithms_structures;

 class TowersofHanoi {

    private void moveInfo(int firstTower, int secondTower){
        System.out.println("Переместить кольцо из основания № " + firstTower + " в основание №" + secondTower);
    }

    void moveTower(int rings, int startTower, int finalTower, int tempTower){
        if (rings == 0){
            return;
        }
        moveTower(rings-1, startTower, tempTower, finalTower);
        moveInfo(startTower, finalTower);
        moveTower(rings-1, tempTower, finalTower, startTower);
    }
}
