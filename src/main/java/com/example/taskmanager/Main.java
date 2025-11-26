package com.example.taskmanager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager tm = new TaskManager();

        FileHandler.loadTasks();

        while (true) {
            System.out.println("\n=== SMART TASK MANAGER ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Search Task");
            System.out.println("6. Save & Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Description: ");
                    String desc = sc.nextLine();
                    tm.addTask(title, desc);
                    break;

                case 2:
                    tm.viewTasks();
                    break;

                case 3:
                    System.out.print("Enter Task ID: ");
                    tm.updateTask(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    tm.deleteTask(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Keyword: ");
                    tm.searchTask(sc.nextLine());
                    break;

                case 6:
                    FileHandler.saveTasks(tm.getTasks());
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
