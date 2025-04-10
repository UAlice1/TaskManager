public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();


        testAddTasks(manager);
        testInvalidTasks(manager);
        testSorting(manager);
        testSearch(manager);
        testRemoval(manager);
        testEdgeCases(manager);
    }

    private static void testAddTasks(TaskManager manager) {
        System.out.println("\n Testing Add Tasks ");
        manager.addTask("Complete Java assignment");
        manager.addTask("Buy groceries");
        manager.addTask("Call mom");
        manager.displayAllTasks();
    }

    private static void testInvalidTasks(TaskManager manager) {
        System.out.println("\n Testing Invalid Inputs");
        try {
            manager.addTask("");
        } catch (IllegalArgumentException e) {
            System.out.println(" Properly caught: " + e.getMessage());
        }

        try {
            manager.addTask(null);
        } catch (IllegalArgumentException e) {
            System.out.println(" Properly caught: " + e.getMessage());
        }
    }

    private static void testSorting(TaskManager manager) {
        System.out.println("\n Testing Sorting ");
        manager.sortTasks();
        manager.displayAllTasks();
    }

    private static void testSearch(TaskManager manager) {
        System.out.println("\n Testing Search ");
        manager.searchTask("Call mom");
        manager.searchTask("Non-existent task");
    }

    private static void testRemoval(TaskManager manager) {
        System.out.println("\n Testing Removal ");
        manager.removeTask(1);  // Valid
        manager.removeTask(99); // Invalid
        manager.displayAllTasks();
    }

    private static void testEdgeCases(TaskManager manager) {
        System.out.println("\n Testing Edge Cases ");
        System.out.println("Longest task: " + manager.findLongestTask());
        manager.getTask(0);     // Valid
        manager.getTask(-1);    // Invalid

        TaskManager emptyManager = new TaskManager();
        emptyManager.findLongestTask();
        emptyManager.displayAllTasks();
    }
}