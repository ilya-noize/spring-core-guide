package noize.dev.spring_core_guide.guide.context;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Task {
    private final String name;
    private final Integer duration;

    public Task(
            @Value("${task.name}") String name,
            @Value("${task.duration}") Integer duration
    ) {
        this.name = name;
        this.duration = duration;
    }

    public String name() {
        return name;
    }

    public Integer duration() {
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
