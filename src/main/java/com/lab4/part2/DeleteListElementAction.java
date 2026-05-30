package com.lab4.part2;

import com.lab4.Main;

public class DeleteListElementAction extends Listik {

    public void execute() {
        System.out.println("\nИз какой таблицы удалить элемент?");
        System.out.println("1. listik_random (случайные числа)");
        System.out.println("2. listik_input (строки)");
        int tableChoice = Main.readInt("Выбор: ");

        String tableName;
        if (tableChoice == 1) {
            tableName = "listik_random";
        } else if (tableChoice == 2) {
            tableName = "listik_input";
        } else {
            System.out.println("Неверный выбор!");
            return;
        }

        int id = Main.readInt("Введите ID элемента для удаления: ");
        boolean deleted = Main.dbManager.deleteListikElement(tableName, id);

        if (deleted) {
            System.out.println("Элемент с ID=" + id + " удалён из таблицы " + tableName + ".");
        } else {
            System.out.println("Элемент с ID=" + id + " не найден в таблице " + tableName + ".");
        }
    }
}