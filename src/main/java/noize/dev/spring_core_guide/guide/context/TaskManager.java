package noize.dev.spring_core_guide.guide.context;

import noize.dev.spring_core_guide.guide.context.aop.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskManager {

    private final Task task;

    @Autowired
    public TaskManager(Task task) {
        this.task = task;
    }

    @Loggable(
            value = "ERROR",
            times = 5
    )
    public int printTaskError() {
        System.out.println("Current task: " + task);
        throw new RuntimeException("Exception in TaskManager");
    }

    @Loggable
    public int printTaskInfo() {
        System.out.println("Current task: " + task);
        return task.duration();
    }
}
