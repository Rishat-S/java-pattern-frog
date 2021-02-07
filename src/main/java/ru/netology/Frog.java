package ru.netology;

public class Frog {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;

    protected int position;

    public Frog() {
        position = 5;
    }

    public boolean jump(int steps) {
        // сделаем прыжок, если прыжок слишком большой
        // для поля, то не прыгнем и вернём false
        if ((position + steps) > MAX_POSITION || (position + steps) < MIN_POSITION) {
            System.out.println("Прыжок не возможен.");
            return false;
        } else {
            position = position + steps;
            return true;
        }
    }

    public void draw() {
        for (int i = 0; i <= MAX_POSITION; i++) {
            if (i == position) {
                System.out.print("F");
            } else {
                System.out.print("0");
            }
        }
        System.out.println();
    }
}
