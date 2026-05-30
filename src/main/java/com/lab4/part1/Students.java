package com.lab4.part1;

import java.util.ArrayList;
import java.util.List;

public class Students {
    private List<StudentRecord> studentList = new ArrayList<>();

    // Внутренний класс для хранения данных студента
    protected static class StudentRecord {
        String studentId;
        String fullName;
        String direction;
        String groupName;

        StudentRecord(String studentId, String fullName, String direction, String groupName) {
            this.studentId = studentId;
            this.fullName = fullName;
            this.direction = direction;
            this.groupName = groupName;
        }

        public String getFullName() { return fullName; }
        public String getStudentId() { return studentId; }
        public String getDirection() { return direction; }
        public String getGroupName() { return groupName; }
    }

    public void addStudent(String studentId, String fullName, String direction, String groupName) {
        studentList.add(new StudentRecord(studentId, fullName, direction, groupName));
    }

    public List<StudentRecord> getStudentList() {
        return studentList;
    }

    public int getCount() {
        return studentList.size();
    }

    // Базовый табличный вывод (без сортировки)
    public void printTable() {
        printHeader();
        for (StudentRecord s : studentList) {
            System.out.println(formatRow(s));
        }
        printFooter();
    }

    protected void printHeader() {
        System.out.println("\n" + "=".repeat(90));
        System.out.println("| ID       | ФИО                            | Направление                   | Группа       |");
        System.out.println("=".repeat(90));
    }

    protected String formatRow(StudentRecord s) {
        return String.format("| %-8s | %-30s | %-30s | %-12s |",
                s.getStudentId(), s.getFullName(), s.getDirection(), s.getGroupName());
    }

    protected void printFooter() {
        System.out.println("=".repeat(90));
        System.out.println("Всего студентов: " + studentList.size());
    }
}