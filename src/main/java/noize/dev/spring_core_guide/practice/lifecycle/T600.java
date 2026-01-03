package noize.dev.spring_core_guide.practice.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

@Component
@Scope(scopeName = SCOPE_SINGLETON)
public class T600 implements Terminator {
    private final String name;
    public T600() {
        this.name = getClass().getSimpleName();
        System.out.println(name + ":core system downloading.");
    }

    @Override
    @PostConstruct
    public void init() {
        System.out.println(name + " downloading. ");
        System.out.println(name + ": scanning the surroundings.");
    }

    @Override
    @PreDestroy
    public void destroy() {
        System.out.println(name + ": Hasta la vista, baby.");
        System.out.println(name + " terminated.");
    }

    @Override
    public void say() {
        System.out.println(name + ":  I'll be back.");
    }

    @Override
    public void process() {
        System.out.println(name + ": search for boots, pants, jackets, and a motorcycle.");
    }
}
