package noize.dev.spring_core_guide.practice.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

    @Bean("singleton-counter")
    @Scope("singleton")
    public SingletonCounterBean singletonCounterBean() {
        return new SingletonCounterBean();
    }

    @Bean("prototype-counter")
    @Scope("prototype")
    public PrototypeCounterBean prototypeCounterBean() {
        return new PrototypeCounterBean();
    }
}
