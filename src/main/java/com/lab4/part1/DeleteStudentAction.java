package com.lab4.part1;

import com.lab4.Main;
import java.util.Scanner;

public class DeleteStudentAction extends Students {

    public void execute() {
        Scanner sc = Main.scanner;
        System.out.print("\nВведите ID студента для удаления: ");
        String id = sc.nextLine();

        boolean deleted = Main.dbManager.deleteStudent(id);
        if (deleted) {
            System.out.println("Студент с ID \"" + id + "\" успешно удалён из БД.");

            // Показать оставшихся
            var remaining = Main.dbManager.getAllStudentsOrdered();
            if (!remaining.isEmpty()) {
                System.out.println("\n=== Оставшиеся студенты ===");
                System.out.println("| ID       | ФИО                            | Направление                   | Группа       |");
                System.out.println("-".repeat(90));
                for (String row : remaining) {
                    System.out.println(row);
                }
                System.out.println("-".repeat(90));
            } else {
                System.out.println("Список студентов пуст.");
            }
        } else {
            System.out.println("Студент с ID \"" + id + "\" не найден.");
        }
    }
}