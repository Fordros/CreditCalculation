package net.riverSoft;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring.xml");
        CreditLogic creditLogic = (CreditLogic) context.getBean("creditLogic");
        creditLogic.actionApp(context);
    }
}
