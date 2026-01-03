package noize.dev.spring_core_guide.practice.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component
@Scope(scopeName = SCOPE_PROTOTYPE)
public class T1000 implements Terminator {
    private final String name;

    public T1000() {
        this.name = getClass().getSimpleName();
        System.out.println(name + ":core system downloading.");
    }

    @Override
    @PostConstruct
    public void init() {
        System.out.println(name + " downloading.");
        System.out.println(name + ": searching shape to transformation.");
    }

    @Override
    @PreDestroy
    public void destroy() {
        System.out.println("AUF!");
        System.out.println(name + ": removing all shapes for transformation.");
        System.out.println(name + " terminated.");
    }

    @Override
    public void say() {
        System.out.println(name + ":  Thank you for your cooperation.");
    }

    @Override
    public void process() {
        System.out.println(name + ": Request for a combat mission.");
    }
}
