package noize.dev.spring_core_guide.guide.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskManager {

    private final Task task;

    @Autowired
    public TaskManager(Task task) {
        this.task = task;
    }

    public void printTask() {
        System.out.println("Current task: " + task);
    }
}
