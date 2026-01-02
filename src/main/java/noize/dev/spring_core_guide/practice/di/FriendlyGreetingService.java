package noize.dev.spring_core_guide.practice.di;

import org.springframework.stereotype.Component;

@Component
public class FriendlyGreetingService implements GreetingService{
    @Override
    public String greet(String name) {
        return "Привет, " + name;
    }
}
