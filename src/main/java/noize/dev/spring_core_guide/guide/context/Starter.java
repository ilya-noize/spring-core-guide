package noize.dev.spring_core_guide.guide.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Starter {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
//                "noize.dev"
                TaskConfiguration.class
        );

        Task task = context.getBean(Task.class);
        Task taskName = (Task) context.getBean("main-task");

        System.out.println("task = " + task);
        System.out.println("taskName = " + taskName);
        boolean isTwins = task == taskName;
        System.out.println("isTwins = " + isTwins);

        TaskManager taskManager = (TaskManager) context.getBean("taskManager");
        taskManager.printTask();

    }

    private static void nativeInitialization() {
        Task task = new Task();
        TaskManager taskManager = new TaskManager(task);
        taskManager.printTask();
    }

}
