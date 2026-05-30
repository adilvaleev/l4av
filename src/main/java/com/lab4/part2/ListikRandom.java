package com.lab4.part2;

public final class ListikRandom extends Listik {

    @Override
    protected void random() {
        super.random();
        System.out.println("\n=== Список случайных чисел (первые 20 из 1000) ===");
        for (int i = 0; i < 20 && i < randomList.size(); i++) {
            System.out.printf("%5d", randomList.get(i));
            if ((i + 1) % 10 == 0) System.out.println();
        }
        System.out.println("\n... (всего 1000 элементов)");
    }
}