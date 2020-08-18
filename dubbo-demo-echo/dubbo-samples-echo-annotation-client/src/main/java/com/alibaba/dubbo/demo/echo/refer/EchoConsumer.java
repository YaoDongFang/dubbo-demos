package com.alibaba.dubbo.demo.echo.refer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.demo.echo.api.EchoService;
import org.springframework.stereotype.Component;

/**
 * EchoConsumer
 *
 * @author YaoDF
 * Description:
 * Created in: 2020-08-18 23:27
 * Modified by:
 */
@Component
public class EchoConsumer {

    @Reference
    private EchoService echoService;

    public String echo(String name) {
        return echoService.echo(name);
    }
}
