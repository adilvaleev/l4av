package com.lab4.part2;

public final class ListikInput extends Listik {

    @Override
    protected void input(java.util.Scanner sc) {
        super.input(sc);
        System.out.println("\n=== Список введённых строк ===");
        for (int i = 0; i < inputList.size(); i++) {
            System.out.printf("%2d. %s%n", i + 1, inputList.get(i));
        }
    }
}