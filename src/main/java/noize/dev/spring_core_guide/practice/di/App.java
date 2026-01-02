package noize.dev.spring_core_guide.practice.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        GreetingPrinterConstructor printer =
                context.getBean(GreetingPrinterConstructor.class);

        printer.print("Name");

        context.close();
    }
}
