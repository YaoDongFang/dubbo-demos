package com.alibaba.dubbo.demo.echo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.dubbo.demo.echo.refer.EchoConsumer;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * AnnotationConsumer
 *
 * @author YaoDF
 * Description:
 * Created in: 2020-08-18 22:32
 * Modified by:
 */
public class AnnotationConsumer {

    public static void main(String[] args) {
        //基于注解配置初始化spring上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        //发起服务调用
        EchoConsumer echoConsumer = context.getBean(EchoConsumer.class);
        String hello = echoConsumer.echo("Hello world!");
        System.out.println("result: " + hello);

    }

    @Configuration
    //指定要扫描的消费者注解，会触发注入
    @EnableDubbo(scanBasePackages = "com.alibaba.dubbo.demo.echo")
    @ComponentScan(value = {"com.alibaba.dubbo.demo.echo"})
    static class ConsumerConfiguration {

        @Bean
        public ApplicationConfig applicationConfig() {
            ApplicationConfig applicationConfig = new ApplicationConfig();
            applicationConfig.setName("echo-annotation-consumer");
            return applicationConfig;
        }

        @Bean
        public ConsumerConfig consumerConfig() {
            return new ConsumerConfig();
        }

        @Bean
        public RegistryConfig registryConfig() {
            RegistryConfig registryConfig = new RegistryConfig();
            registryConfig.setProtocol("zookeeper");
            registryConfig.setAddress("localhost");
            registryConfig.setPort(2181);
            return registryConfig;
        }


    }

}
