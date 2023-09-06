package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.awt.*;

public class SpringTestRunner {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context =
                new FileSystemXmlApplicationContext("mvn/SpringExampleXml/src/resources/spring-bean.xml");

        Thread.sleep(5000);
        Test obj1 = (Test) context.getBean("test");
        Thread.sleep(5000);
        Test obj2 = (Test) context.getBean("test");
        Thread.sleep(5000);
        Test obj3 = (Test) context.getBean("test1");
//
        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3);
//
        obj1.setName("Oleksandr");
//
        System.out.println(obj1.getName());
        System.out.println(obj2.getName());
        System.out.println(obj3.getName());

    }

}
