package com.lab4.part2;

import java.util.List;

public class Listik {
    protected List<Integer> randomList;
    protected List<String> inputList;

    // Метод random — создаёт список из 1000 случайных int
    protected void random() {
        java.util.Random rand = new java.util.Random();
        randomList = new java.util.ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            randomList.add(rand.nextInt(10000)); // 0-9999
        }
    }

    // Метод input — создаёт список из 10 строк с клавиатуры
    protected void input(java.util.Scanner sc) {
        inputList = new java.util.ArrayList<>();
        System.out.println("Введите 10 строк:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("Строка %d: ", i + 1);
            inputList.add(sc.nextLine());
        }
    }

    public List<Integer> getRandomList() { return randomList; }
    public List<String> getInputList() { return inputList; }
}