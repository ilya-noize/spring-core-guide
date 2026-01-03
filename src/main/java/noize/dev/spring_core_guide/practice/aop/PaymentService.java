package noize.dev.spring_core_guide.practice.aop;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public void processPayment(double amount) {
        System.out.printf("Обработка платежа на сумму: %s руб.%n", amount);
        if(amount <0) {
            throw new IllegalArgumentException("Сумма не может быть отрицательным");
        }
    }

    public String checkStatus() {
        return "Платёж успешно обработан";
    }
}
