package com.lab4.part2;

import com.lab4.Main;
import java.util.Scanner;

public class InputListAction extends Listik {

    public void execute() {
        Scanner sc = Main.scanner;

        System.out.println("\n=== Генерация случайного списка (1000 int) ===");
        ListikRandom listRandom = new ListikRandom();
        listRandom.random();

        // Сохраняем в БД
        System.out.println("Сохраняю в БД...");
        for (Integer val : listRandom.getRandomList()) {
            Main.dbManager.saveRandomValue(val);
        }
        System.out.println("Случайный список сохранён в таблицу listik_random.");

        System.out.println("\n=== Ввод строкового списка (10 строк) ===");
        ListikInput listInput = new ListikInput();
        listInput.input(sc);

        // Сохраняем в БД
        System.out.println("Сохраняю в БД...");
        for (String val : listInput.getInputList()) {
            Main.dbManager.saveInputValue(val);
        }
        System.out.println("Строковый список сохранён в таблицу listik_input.");

        System.out.println("\n=== Оба списка сохранены в БД ===");
    }
}