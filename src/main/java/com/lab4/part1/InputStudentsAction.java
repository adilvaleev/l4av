package com.lab4.part1;

import com.lab4.Main;
import java.util.Scanner;

public class InputStudentsAction extends Students {

    public void execute() {
        Scanner sc = Main.scanner;
        SortedStudents sortedStudents = new SortedStudents();

        System.out.print("\nВведите количество студентов (минимум 7): ");
        int count = Main.readInt("");
        while (count < 7) {
            System.out.print("Минимум 7! Введите ещё раз: ");
            count = Main.readInt("");
        }

        for (int i = 0; i < count; i++) {
            System.out.println("\n--- Студент " + (i + 1) + " ---");
            System.out.print("ID студента: ");
            String id = sc.nextLine();
            System.out.print("ФИО (Фамилия И.О.): ");
            String name = sc.nextLine();
            System.out.print("Направление подготовки: ");
            String direction = sc.nextLine();
            System.out.print("Группа: ");
            String group = sc.nextLine();

            sortedStudents.addStudent(id, name, direction, group);
            Main.dbManager.saveStudent(id, name, direction, group);
        }

        // Вывод отсортированного списка
        sortedStudents.printTable();

        // Вывод данных из БД для подтверждения
        System.out.println("\n=== Данные из БД (отсортированы) ===");
        var dbList = Main.dbManager.getAllStudentsOrdered();
        System.out.println("| ID       | ФИО                            | Направление                   | Группа       |");
        System.out.println("-".repeat(90));
        for (String row : dbList) {
            System.out.println(row);
        }
        System.out.println("-".repeat(90));

        System.out.println("\nДанные сохранены в БД.");
    }
}