import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TaskManager {
    private final List<String> tasksArray;
    private final List<String> tasksLinked;

    public TaskManager() {
        this.tasksArray = new ArrayList<>();
        this.tasksLinked = new LinkedList<>();
    }

    // Fixed: Better null/empty validation
    public void addTask(String task) {
        if (task == null || task.trim().isEmpty()) {
            throw new IllegalArgumentException("Task cannot be empty or null");
        }
        tasksArray.add(task);
        tasksLinked.add(task);
        System.out.println("✓ Added: '" + task + "'");
    }

    // Fixed: Return sorted list instead of void
    public List<String> sortTasks() {
        List<String> sorted = new ArrayList<>(tasksArray);
        Collections.sort(sorted);
        System.out.println("✓ Tasks sorted alphabetically");
        return sorted;
    }

    // Fixed: More detailed search result
    public int searchTask(String task) {
        int index = tasksArray.indexOf(task);
        if (index != -1) {
            System.out.println("✓ Found '" + task + "' at index: " + index);
        } else {
            System.out.println("✗ Task '" + task + "' not found");
        }
        return index;
    }

    // Fixed: Better index validation
    public void removeTask(int index) {
        if (index < 0 || index >= tasksArray.size()) {
            System.out.println("✗ Invalid index: " + index + " (size: " + tasksArray.size() + ")");
            return;
        }
        String removed = tasksArray.remove(index);
        tasksLinked.remove(removed);
        System.out.println("✓ Removed: '" + removed + "'");
    }

    // Fixed: Handle empty list case
    public String findLongestTask() {
        if (tasksArray.isEmpty()) {
            System.out.println("! No tasks available");
            return null;
        }
        return Collections.max(tasksArray, (a, b) -> a.length() - b.length());
    }

    // Fixed: Better error message
    public String getTask(int index) {
        try {
            String task = tasksArray.get(index);
            System.out.println("✓ Task at " + index + ": '" + task + "'");
            return task;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("✗ Invalid index: " + index + " (size: " + tasksArray.size() + ")");
            return null;
        }
    }

    // Fixed: Better display format
    public void displayAllTasks() {
        if (tasksArray.isEmpty()) {
            System.out.println("! No tasks in the list");
            return;
        }
        System.out.println("\n📝 Task List:");
        for (int i = 0; i < tasksArray.size(); i++) {
            System.out.printf("%2d. %s%n", i+1, tasksArray.get(i));
        }
    }
}