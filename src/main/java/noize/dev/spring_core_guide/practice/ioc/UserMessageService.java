package noize.dev.spring_core_guide.practice.ioc;

public class UserMessageService {

    public String createMessage(String name) {
        return String.format("Привет, %s, добро пожаловать!%n", name);
    }
}
