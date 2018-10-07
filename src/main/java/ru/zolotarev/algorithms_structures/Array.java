package main.java.ru.zolotarev.algorithms_structures;

import com.sun.deploy.util.ArrayUtil;

public class Array {
    private int arr[];
    private int size;
    private boolean isSorted;

    private Array() {
        isSorted = false;
    }

    public Array(int size) {
        this();
        this.size = 0;
        this.arr = new int[size];
    }

    public Array(int... args) {
        this();
        this.size = args.length;
        this.arr = args;
    }

    public int length() {
        return size;
    }

    public int get(int index) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        return arr[index];
    }

    public void set(int index, int value) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        arr[index] = value;
        isSorted = false;
    }

    public void append(int value) {
        if (size >= arr.length) {
            int[] temp = arr;
            arr = new int[size * 2];
            System.arraycopy(temp, 0, arr, 0, size);
        }
        arr[size++] = value;
        isSorted = false;
    }

    /**
     * Deletes the last value in array
     */
    boolean delete() {
        if (size == 0) return false;
        size--;
        return true;
    }

    boolean delete(int index) { // by index
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return true;
    }

    boolean deleteValue(int value) { // by value
        int countValue = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                countValue++;
                for (int j = i, k = 1; j < size - 1; j++, k++) {
                    arr[j] = arr[i + k];
                }
            }
        }
        size -= countValue;
        return true;
    }

    void deleteAll() { // clear array
        size = 0;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder b = new StringBuilder("[");
        for (int i = 0; ; i++) {
            b.append(arr[i]);
            if (i == size - 1)
                return b.append("]").toString();
            b.append(", ");
        }
    }

    /**
     * Search
     */
    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    public boolean hasValue(int value) {
        if (!isSorted)
            throw new RuntimeException("Try the 'find' method");
        int l = 0;
        int r = size;
        int m;
        while (l < r) {
            // n >> k == n / 2 ^ k
            m = (l + r) >> 1; // 8 = 00001000 >> 1 = 00000100 = 4
            if (value == arr[m])
                return true;
            else if (value < arr[m])
                r = m;
            else
                l = m + 1;
        }
        return false;
    }

    /**
     * Sort
     */
    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void sortBubble() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);
            }
        }
        isSorted = true;
    }

    //Чётно-нечётная сортировка
    public void sortBubbleV1() {
        boolean noChange = false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j += 2) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                    noChange = false;
                }
            }
            for (int j = 1; j < size - 1; j += 2) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                    noChange = false;
                }
            }
        }
    }

    //Шейкерная сортировка
    public void sortBubbleV2() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);
            }
            for (int j = size - 1; j > 0; j--) {
                if (arr[j] < arr[j - 1])
                    swap(j - 1, j);
            }
        }
        isSorted = true;
    }

    //Сортировка расчёской
    public void sortBubbleV3() {
        for (int i = 0; i < size; i++) {
            for (int j = 0, k = size - i; k < size; j++, k++) {
                if (arr[j] > arr[k]) {
                    swap(j, k);
                }
            }
        }
        isSorted = true;
    }

    public void sortSelect() {
        for (int flag = 0; flag < size; flag++) {
            int cMin = flag;
            for (int rem = flag + 1; rem < size; rem++) {
                if (arr[rem] < arr[cMin])
                    cMin = rem;
            }
            swap(flag, cMin);
        }
        isSorted = true;
    }

    public void sortInsert() {
        int in;
        for (int out = 0; out < size; out++) {
            int temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
        isSorted = true;
    }

//    public void sortCounting() {
//        int[] temp = new int[size];
//        int count = 0;
//        int repeat = 0;
//
//        for (int i = 0; i < size; i++) {
//            if (arr[i] == 6) {
//                for (int j = 0; j < size; j++) {
//                    if (arr[i] > arr[j]) {
//                        count++;
//                    }
//                    if (arr[i] == arr[j]) {
//                        repeat++;
//                    }
//                    temp[count + repeat] = arr[i];
//                    count = 0;
//                    repeat = 0;
//                }
//            }
//            for (int i = 0; i < size; i++) {
//                arr[i] = temp[i];
//            }
//        }
//        System.out.println(count+repeat);
//    }


    public void getInfo() {
        for (int i = 0; i < length(); i++) {
            System.out.print(get(i));
        }
        System.out.println();
    }

}
