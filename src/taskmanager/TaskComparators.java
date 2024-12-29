package taskmanager;

import java.util.Comparator;

public class TaskComparators {
    // Sort by priority (1 = High, 2 = Medium, 3 = Low)
    public static final Comparator<Task> BY_PRIORITY = Comparator.comparingInt(Task::getPriority);

    // Sort by due date (earliest first)
    public static final Comparator<Task> BY_DUE_DATE = Comparator.comparing(Task::getDueDate);

    // Sort by creation date (earliest first)
    public static final Comparator<Task> BY_CREATION_DATE = Comparator.comparing(Task::getCreationTimestamp);

    // Sort by title (alphabetical, case-insensitive)
    public static final Comparator<Task> BY_TITLE = Comparator.comparing(Task::getTitle, String.CASE_INSENSITIVE_ORDER);

    // Sort by completion status (incomplete first)
    public static final Comparator<Task> BY_COMPLETION_STATUS = Comparator.comparing(Task::isCompleted);

    // Combine comparators: Priority then due date
    public static final Comparator<Task> BY_PRIORITY_THEN_DUE_DATE =
            BY_PRIORITY.thenComparing(BY_DUE_DATE);

    // Sort by reverse due date (latest first)
    public static final Comparator<Task> BY_REVERSE_DUE_DATE =
            (task1, task2) -> task2.getDueDate().compareTo(task1.getDueDate());

    // Sort by recent creation date (most recent first)
    public static final Comparator<Task> BY_RECENT_CREATION_DATE =
            (task1, task2) -> task2.getCreationTimestamp().compareTo(task1.getCreationTimestamp());
}
