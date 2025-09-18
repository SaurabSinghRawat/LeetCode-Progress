import java.util.*;

class TaskManager {
    private static class Task {
        int userId, taskId, priority;
        Task(int u, int t, int p) {
            userId = u; taskId = t; priority = p;
        }
    }
    
    private Map<Integer, Task> taskMap; 
    private PriorityQueue<Task> pq;
    
    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> {
            if (b.priority != a.priority) return b.priority - a.priority;
            return b.taskId - a.taskId;
        });
        for (List<Integer> t : tasks) {
            add(t.get(0), t.get(1), t.get(2));
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        pq.offer(task);
    }
    
    public void edit(int taskId, int newPriority) {
        Task newTask = new Task(taskMap.get(taskId).userId, taskId, newPriority);
        taskMap.put(taskId, newTask);
        pq.offer(newTask);
    }
    
    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }
    
    public int execTop() {
        while (!pq.isEmpty()) {
            Task top = pq.poll();
            Task cur = taskMap.get(top.taskId);
            // Only accept if this is the current, valid copy
            if (cur != null && cur == top) {
                taskMap.remove(top.taskId);
                return top.userId;
            }
        }
        return -1;
    }
}
