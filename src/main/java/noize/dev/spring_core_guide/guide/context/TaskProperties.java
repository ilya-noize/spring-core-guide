package noize.dev.spring_core_guide.guide.context;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class TaskProperties {
    @Value("${task.name}")
    private String taskName;

    @Value("${task.duration}")
    private Integer duration;

    @Value("#{'${list.values}'.split(',')}")
    private List<String> values;

    @Value("#{'${set.values}'.split(',')}")
    private Set<String> setValues;

    @Value("#{${map.values}}")
    private Map<String,Integer> mapValues;

    @Override
    public String toString() {
        return "TaskProperties{" +
                "taskName='" + taskName + '\'' +
                ", duration=" + duration +
                ", values=" + values +
                ", setValues=" + setValues +
                ", mapValues=" + mapValues +
                '}';
    }
}
