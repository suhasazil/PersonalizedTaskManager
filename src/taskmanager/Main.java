package taskmanager;

import taskmanager.Task;
import taskmanager.TaskManager;
import taskmanager.TaskComparators;
import java.time.LocalDateTime;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) throws InterruptedException { // Add throws InterruptedException for sleep
        TaskManager taskManager = new TaskManager();

        // Add tasks with sleep in between
        Task task1 = new Task("Study Java", "Complete OOP assignment", LocalDateTime.now().plusDays(5), 1);
        taskManager.addTask(task1, "Personal");
        Thread.sleep(1000); // Pause for 1 second

        Task task2 = new Task("Grocery Shopping", "Buy vegetables", LocalDateTime.now().plusDays(2), 2);
        taskManager.addTask(task2, "Household");
        Thread.sleep(1000); // Pause for 1 second

        Task task3 = new Task("Workout", "Go to the gym", LocalDateTime.now().plusDays(3), 3);
        taskManager.addTask(task3, "Health");

        // Display all tasks sorted by recent creation date
        System.out.println("\nTasks Sorted by Recent Creation Date:");
        taskManager.getTasksSorted(TaskComparators.BY_RECENT_CREATION_DATE).forEach(System.out::println);
    }
}