package noize.dev.spring_core_guide.practice.ioc;

public class UserMessagePrinter {
    private final UserMessageService userMessageService;

    public UserMessagePrinter(UserMessageService userMessageService) {
        this.userMessageService = userMessageService;
    }

    public void printMessage(String name) {
        String message = userMessageService.createMessage(name);
        System.out.println(message);
    }
}
