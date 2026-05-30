package com.lab4.part1;

import com.lab4.Main;
import java.util.Scanner;

public class StudentByIdAction extends Students {

    public void execute() {
        Scanner sc = Main.scanner;
        System.out.print("\nВведите ID студента для поиска: ");
        String id = sc.nextLine();

        String result = Main.dbManager.getStudentById(id);
        if (result != null) {
            System.out.println("\n=== Найден студент ===");
            System.out.println("| ID       | ФИО                            | Направление                   | Группа       |");
            System.out.println("-".repeat(90));
            System.out.println(result);
            System.out.println("-".repeat(90));
        } else {
            System.out.println("Студент с ID \"" + id + "\" не найден.");
        }
    }
}