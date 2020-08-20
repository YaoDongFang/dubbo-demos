package com.alibaba.dubbo.demo.echo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.demo.echo.api.EchoService;
import com.alibaba.dubbo.rpc.RpcContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * EchoServiceImpl
 *
 * @author YaoDF
 * Description:
 * Created in: 2020-08-20 23:19
 * Modified by:
 */
@Service
public class EchoServiceImpl implements EchoService {

    @Override
    public String echo(String message) {
        String now = new SimpleDateFormat("HH:mm:ss").format(new Date());
        System.out.println("[" + now + "] Hello " + message
                + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return message;
    }
}
