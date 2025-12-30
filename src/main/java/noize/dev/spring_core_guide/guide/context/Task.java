package noize.dev.spring_core_guide.guide.context;

import org.springframework.stereotype.Component;

@Component("main-task")
public class Task {
    private final String name;
    private final Long duration;

    public Task() {
        this.name = "task";
        this.duration = 60L;
    }

    public String name() {
        return name;
    }

    public Long duration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}
