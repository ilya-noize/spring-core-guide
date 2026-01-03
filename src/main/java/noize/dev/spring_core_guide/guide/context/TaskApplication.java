package noize.dev.spring_core_guide.guide.context;

import noize.dev.spring_core_guide.guide.context.config.TaskConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TaskApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                TaskConfiguration.class
        );
        workTasks(context);

        workTaskProperties(context);
    }

    private static void workTaskProperties(AnnotationConfigApplicationContext context) {
        System.out.println("- ".repeat(5) + "Task Properties" + " -".repeat(5));
        TaskProperties taskProperties = context.getBean(TaskProperties.class);
        System.out.println("taskProperties = " + taskProperties);
    }

    private static void workTasks(AnnotationConfigApplicationContext context) {
        System.out.println("- ".repeat(5) + "Tasks" + " -".repeat(5));
        Task task = context.getBean(Task.class);
        System.out.println("task = " + task);
        TaskManager taskManager = (TaskManager) context.getBean("taskManager");
        taskManager.printTask();
    }
}

