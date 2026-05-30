package com.lab4.part1;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class SortedStudents extends Students {

    // Переопределённый метод — сортировка по фамилии (алфавиту)
    @Override
    public void printTable() {
        // Сортируем по полю fullName
        List<StudentRecord> sorted = getStudentList().stream()
                .sorted(Comparator.comparing(StudentRecord::getFullName))
                .collect(Collectors.toList());

        System.out.println("\n=== СОРТИРОВАННЫЙ СПИСОК (по алфавиту) ===");
        printHeader();
        for (StudentRecord s : sorted) {
            System.out.println(formatRow(s));
        }
        printFooter();
    }
}