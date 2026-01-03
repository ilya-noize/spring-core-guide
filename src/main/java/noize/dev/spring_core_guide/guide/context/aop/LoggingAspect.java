package noize.dev.spring_core_guide.guide.context.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* noize.dev.spring_core_guide.guide.context.TaskManager.*(..))")
    public void logBefore(
            JoinPoint joinPoint
    ) {
        System.out.println("Перед вызовом метода: " +
                joinPoint.getSignature().getName());
    }

    @AfterReturning(
            value = "execution(* noize.dev.spring_core_guide.guide.context.TaskManager.*(..))",
            returning = "result"
    )
    public void logAfterReturning(
            JoinPoint joinPoint,
            Object result
    ) {
        System.out.printf("После возвращения результата: %s." +
                        " Результат: %s%n",
                joinPoint.getSignature().getName(),
                result);
    }

    @AfterThrowing(
            value = "execution(* noize.dev.spring_core_guide.guide.context.TaskManager.*(..))",
            throwing = "exc"
    )
    public void logAfterThrowing(
            JoinPoint joinPoint,
            Exception exc
    ) {
        System.out.println("После исключения: " + exc.getMessage());
    }

    @After(
            value = "execution(* noize.dev.spring_core_guide.guide.context.TaskManager.*(..))"
    )
    public void logAfter(
            JoinPoint joinPoint
    ) {
        System.out.println("После вызова метода: " + joinPoint.getSignature().getName());
    }

    @Around(value = "execution(* noize.dev.spring_core_guide.guide.context.TaskManager.*(..))")
    public Object logAround(
            ProceedingJoinPoint proceedingJoinPoint
    ) throws Throwable {
        // logic before
        long start = System.currentTimeMillis();
        // System.out.println("До метода" + " .".repeat(10));

        Integer result = (Integer) proceedingJoinPoint.proceed();

        // logic after
        long end = System.currentTimeMillis();
        //System.out.println("После метода" + " .".repeat(10));
        System.out.printf("Метод работал %s мс%n", end - start);

        return result;
    }
    /**/

    @Before("@annotation(loggable)")
    public void log(
            JoinPoint joinPoint,
            Loggable loggable
    ) {
        for (int i = 0; i < loggable.times(); i++) {
            System.out.printf("LOG %s: before method = %s%n",
                    loggable.value(),
                    joinPoint.getSignature().getName());
        }
    }
}
