package noize.dev.spring_core_guide.practice.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public interface Terminator {

    @PostConstruct
    void init();

    @PreDestroy
    void destroy();

    void say();

    void process();
}
