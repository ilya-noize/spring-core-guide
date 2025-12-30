package noize.dev.spring_core_guide.practice.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IoCStarter {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserMessagePrinter printer = context.getBean(UserMessagePrinter.class);
        printer.printMessage("Spring");
    }
}
