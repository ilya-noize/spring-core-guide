package noize.dev.spring_core_guide.practice.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreetingPrinterField {
    @Autowired
    private final GreetingService greetingService;

    public GreetingPrinterField(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public void print(String name) {
        System.out.println(greetingService.greet(name));
    }
}
