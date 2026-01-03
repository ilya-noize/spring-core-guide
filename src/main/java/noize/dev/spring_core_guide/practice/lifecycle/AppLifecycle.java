package noize.dev.spring_core_guide.practice.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class AppLifecycle {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppLifecycleConfig.class);

        T600 t600 = context.getBean(T600.class);
        initTerminator(t600);

        T1000 t1000 = context.getBean(T1000.class);
        initTerminator(t1000);

        context.close();
    }

    private static void initTerminator(Terminator terminator) {
        terminator.process();
        terminator.say();
    }
}

@Configuration
@ComponentScan(basePackages = "noize.dev.spring_core_guide.practice.lifecycle")
class AppLifecycleConfig {

}
