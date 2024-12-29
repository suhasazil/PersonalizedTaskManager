package taskmanager;

import java.util.*;

public class TaskManager {
    private List<Task> tasks; // Main list of all tasks
    private Map<String, List<Task>> categories; // Map category names to tasks

    // Constructor
    public TaskManager() {
        this.tasks = new ArrayList<>();
        this.categories = new HashMap<>();
        this.categories.put("All Tasks", new ArrayList<>()); // Default category
    }

    // Add a Task
    public void addTask(Task task, String category) {
        // Add task to the main list
        tasks.add(task);

        // Add task to the "All Tasks" category
        categories.get("All Tasks").add(task);

        // Add task to the user-specified category
        if (!categories.containsKey(category)) {
            categories.put(category, new ArrayList<>()); // Create the category if it doesn't exist
        }
        task.addCategory(category);
        categories.get(category).add(task);
    }

    // Retrieve All Tasks
    public List<Task> getAllTasks() {
        return tasks;
    }

    // Retrieve Tasks by Category
    public List<Task> getTasksByCategory(String category) {
        return categories.getOrDefault(category, Collections.emptyList());
    }

    // Retrieve Available Categories
    public Set<String> getAvailableCategories() {
        return categories.keySet();
    }

    // Update a Task
    public boolean updateTask(int index, Task updatedTask, String newCategory) {
        if (index >= 0 && index < tasks.size()) {
            Task existingTask = tasks.get(index);

            // Update task in the main list
            tasks.set(index, updatedTask);

            // Remove the existing task from its current categories
            for (String category : existingTask.getCategories()) {
                categories.get(category).remove(existingTask);
            }

            // Add the updated task to the "All Tasks" category
            categories.get("All Tasks").add(updatedTask);
            updatedTask.addCategory("All Tasks");

            // Add the updated task to the new category
            if (!categories.containsKey(newCategory)) {
                categories.put(newCategory, new ArrayList<>());
            }
            updatedTask.addCategory(newCategory);
            categories.get(newCategory).add(updatedTask);

            return true;
        }
        return false;
    }

    // Delete a Task
    public boolean deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task taskToRemove = tasks.remove(index);

            // Remove the task from all its categories
            for (String category : taskToRemove.getCategories()) {
                categories.get(category).remove(taskToRemove);
            }
            return true;
        }
        return false;
    }

    // Sort Tasks Dynamically Based on Comparator
    public List<Task> getTasksSorted(Comparator<Task> comparator) {
        List<Task> sortedTasks = new ArrayList<>(tasks); // Create a copy to avoid modifying the original list
        sortedTasks.sort(comparator);
        return sortedTasks;
    }
    public List<Task> getTasksDefaultSorted() {
        return getTasksSorted(TaskComparators.BY_RECENT_CREATION_DATE);
    }


    @Override
    public String toString() {
        return "TaskManager{" +
                "tasks=" + tasks +
                ", categories=" + categories +
                '}';
    }
}
