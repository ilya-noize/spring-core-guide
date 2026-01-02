package noize.dev.spring_core_guide.practice.di;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component("format-greeting")
public class FormatGreetingService implements GreetingService{
    @Override
    public String greet(String name) {
        return "Здравствуйте, "+ name;
    }
}
