package main.java.ru.zolotarev.algorithms_structures;

public class Stack {
    private char[] stack;
    private int head;

    public Stack(int stringLenght){
        this.stack = new char[stringLenght];
        this.head = -1;
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return head == stack.length - 1;
    }

    public boolean insert(String string) {
        if (isFull())
            return false;
        for (int i = string.length()-1; i >= 0; i--) {
            stack[++head] = string.charAt(i);
        }
        return true;
    }

    public char remove() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        return stack[head--];
    }

    public char[] peek() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        return stack;
    }
    public void info(){
        for (int i = 0; i < stack.length; i++) {
            System.out.print(stack[i]);
        }
    }
}
//[..........]
//[||||||....]
