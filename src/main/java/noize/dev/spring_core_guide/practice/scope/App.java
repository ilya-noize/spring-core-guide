package noize.dev.spring_core_guide.practice.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static final int COUNT = 10;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        CounterBean singletonOne = (SingletonCounterBean)
                context.getBean("singleton-counter");
        CounterBean singletonTwo = (SingletonCounterBean)
                context.getBean("singleton-counter");
        CounterBean prototypeOne = (PrototypeCounterBean)
                context.getBean("prototype-counter");
        CounterBean prototypeTwo = (PrototypeCounterBean)
                context.getBean("prototype-counter");

        for (int i = 0; i < COUNT; i++) {
            singletonOne.increment();
            System.out.println("Singleton 1 = " + singletonOne.value());
            singletonTwo.increment();
            System.out.println("Singleton 2 = " + singletonTwo.value());
            prototypeOne.increment();
            System.out.println("Prototype 1 = " + prototypeOne.value());
            prototypeTwo.increment();
            System.out.println("Prototype 2 = " + prototypeTwo.value());
        }

        boolean singletonEquals = singletonOne.value() == singletonTwo.value();
        System.out.printf("Счётчики синглтонов равны? - %s%n",
                singletonEquals ? "ДА" : "НЕТ");
        boolean singletonCounterIsOwn = singletonTwo.value() == COUNT + COUNT;
        System.out.printf("Счётчик общий для всех синглтонов и имеют двойную сумму? - %s%n",
                singletonCounterIsOwn ? "ДА" : "НЕТ");
        boolean prototypeIsDifference = prototypeOne.value() == prototypeTwo.value();
        System.out.printf("Счётчики прототипов равны? - %s%n",
                prototypeIsDifference ? "ДА" : "НЕТ");
        boolean prototypeCounterIsNotOwn = prototypeTwo.value() == COUNT;
        System.out.printf("Счётчики прототипов каждый сам по себе и равен половине от счётчика синглтона? - %s%n",
                prototypeCounterIsNotOwn ? "ДА" : "НЕТ");
    }
}
