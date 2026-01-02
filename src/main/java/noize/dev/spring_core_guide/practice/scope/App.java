package noize.dev.spring_core_guide.practice.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        CounterBean s1 = (SingletonCounterBean)
                context.getBean("singleton-counter");
        CounterBean s2 = (SingletonCounterBean)
                context.getBean("singleton-counter");
        CounterBean p1 = (PrototypeCounterBean)
                context.getBean("prototype-counter");
        CounterBean p2 = (PrototypeCounterBean)
                context.getBean("prototype-counter");

        for (int i = 0; i < 10; i++) {
            s1.increment();
            System.out.println("s1Count = " + s1.value());
            s2.increment();
            System.out.println("s2Count = " + s2.value());
            p1.increment();
            System.out.println("p1Count = " + p1.value());
            p2.increment();
            System.out.println("p2Count = " + p2.value());
        }
    }
}
