package com.alibaba.dubbo.demo.echo;

import com.alibaba.dubbo.demo.echo.api.EchoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * EchoConsumer
 *
 * @author YaoDF
 * Description:
 * Created in: 2020-08-24 23:19
 * Modified by:
 */
public class EchoConsumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/echo-consumer.xml"});
        context.start();
        EchoService echoService = (EchoService) context.getBean("echoService");
        String status = echoService.echo("Hello World");
        System.out.println("echo result: " + status);
    }
}
