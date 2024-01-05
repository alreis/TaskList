package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Task;

public class TaskList {
    private static List<Task> taskList = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            System.out.println("\n==== TaskList =====");
            System.out.println("1. New Task");
            System.out.println("2. Show Tasks");
            System.out.println("3. Edit Task");
            System.out.println("4. Mark task as concluded");
            System.out.println("0. Exit");

            option = scanner.nextInt();
            scanner.nextLine(); // to clean the buffer

            switch (option) {
                case 1:
                    newTask(scanner);
                    break;
                case 2:
                    showTasks();
                    break;
                case 3:
                    editTask(scanner);
                    break;
                case 4:
                    markTaskAsCompleted(scanner);
                    break;
            }

        } while (option != 0);

        System.out.println("System closed.");
    }

    private static void newTask(Scanner scanner) {
        System.out.print("Enter the task description: ");
        String description = scanner.nextLine();

        Task newTask = new Task(nextId, description, "Today", false);
        taskList.add(newTask);
        nextId++;

        System.out.println("New task creted!");
    }

    private static void showTasks() {
        System.out.println("\n==== List of Tasks ====");
        for (Task task : taskList) {
            System.out.println(" - ID: " + task.getId() + ".\n" + " - Description: " + task.getDescription()
                    + "\n - Date of creation: " + task.getDateOfCreation() + "\n - Completed: " + task.isCompleted()
                    + "\n");
        }
    }

    private static void markTaskAsCompleted(Scanner scanner) {
        System.out.print("Enter the task ID: ");
        int idTask = scanner.nextInt();

        for (Task task : taskList) {
            if (task.getId() == idTask) {
                task.setCompleted(true);
                System.out.println("Task as completed!");
                return;
            }
        }

        System.out.println("Task not found.");
    }

    private static void editTask(Scanner scanner) {
        System.out.print("Enter the task ID to edit: ");
        int idTask = scanner.nextInt();
        scanner.nextLine();

        for (Task task : taskList) {
            if (task.getId() == idTask) {
                System.out.print("Enter the new description: ");
                String newDescription = scanner.nextLine();
                task.setDescription(newDescription);
                System.out.println("Task edited successfully!");
                return;
            }
        }
        System.out.println("Task not found.");
    }
}
