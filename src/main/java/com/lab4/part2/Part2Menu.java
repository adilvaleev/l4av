package com.lab4.part2;

import com.lab4.ExcelExporter;
import com.lab4.Main;

public class Part2Menu {

    public static void show() {
        while (true) {
            System.out.println("\n╔══════════════════════════════════════════╗");
            System.out.println("║    ЧАСТЬ 2 - Списки (Listik)             ║");
            System.out.println("╠══════════════════════════════════════════╣");
            System.out.println("║ 1. Вывести все таблицы из БД             ║");
            System.out.println("║ 2. Создать таблицу в БД                  ║");
            System.out.println("║ 3. Ввести список и сохранить в БД        ║");
            System.out.println("║ 4. Удалить элемент по ID                 ║");
            System.out.println("║ 5. Сохранить в Excel и вывести           ║");
            System.out.println("║ 0. Назад в главное меню                  ║");
            System.out.println("╚══════════════════════════════════════════╝");

            int choice = Main.readInt("Выберите действие: ");
            switch (choice) {
                case 0 -> { return; }
                case 1 -> displayTables();
                case 2 -> Main.dbManager.createAllTables();
                case 3 -> new InputListAction().execute();
                case 4 -> new DeleteListElementAction().execute();
                case 5 -> {
                    ExcelExporter.exportAndDisplay(Main.dbManager, "listik_random");
                    ExcelExporter.exportAndDisplay(Main.dbManager, "listik_input");
                }
                default -> System.out.println("Неверный выбор!");
            }
        }
    }

    private static void displayTables() {
        System.out.println("\nТаблицы в БД:");
        for (String t : Main.dbManager.getAllTables()) {
            System.out.println(" - " + t);
        }
    }
}