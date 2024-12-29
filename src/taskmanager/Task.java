package taskmanager;

import java.util.HashSet;
import java.util.Set;
import java.time.LocalDateTime;

public class Task {
    private String title;
    private String description;
    private LocalDateTime creationTimestamp;
    private LocalDateTime dueDate;
    private int priority; // 1 = High, 2 = Medium, 3 = Low
    private boolean isCompleted;
    private Set<String> categories; // Set of categories (max 2)

    // Constructor
    public Task(String title, String description, LocalDateTime  dueDate, int priority) {
        this.title = title;
        this.description = description;
        this.creationTimestamp  = LocalDateTime.now(); // Automatically set creation date to now
        this.dueDate = dueDate;
        this.priority = priority;
        this.isCompleted = false; // Default: task is not completed
        this.categories = new HashSet<>();
        this.categories.add("All Tasks"); // Default category
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreationTimestamp() {
        return creationTimestamp;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public Set<String> getCategories() {
        return categories;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(int priority) {
        if (priority < 1 || priority > 3) {
            throw new IllegalArgumentException("Priority must be 1 (High), 2 (Medium), or 3 (Low).");
        }
        this.priority = priority;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    // Add a category (max 2 categories)
    public void addCategory(String category) {
        if (categories.size() >= 2) {
            throw new IllegalStateException("A task can only belong to a maximum of 2 categories.");
        }
        categories.add(category);
    }

    // Utility Methods
    @Override
    public String toString() {
        return "Task with " + title + " name, " + description + " with description is created at "+
                creationTimestamp +
                ", with due date " + dueDate +
                ", and priority " + (priority == 1 ? "High" : priority == 2 ? "Medium" : "Low") +
                ". The task " + isCompleted +
                ", in this " + categories +
                " category.";
    }
}
