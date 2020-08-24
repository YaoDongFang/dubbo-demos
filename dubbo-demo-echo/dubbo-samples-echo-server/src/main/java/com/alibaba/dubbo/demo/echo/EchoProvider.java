package com.alibaba.dubbo.demo.echo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * EchoProvider
 *
 * @author YaoDF
 * Description:
 * Created in: 2020-08-24 23:19
 * Modified by:
 */
public class EchoProvider {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/echo-provider.xml"});
        context.start();
        System.in.read();
    }
}
