package com.example.netty.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @Description:
 * @Author: huanghs
 * @Date: Created in 3:45 PM 2019/4/2
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeServerHandler.class);
    private int counter = 0;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
       String body = (String)msg;
       LOGGER.info("receive msg : {} , the counter : {}",body,counter++);
       String currentTime = "QUERY TIME ORDER".equals(body)
               ?(new Date(System.currentTimeMillis())).toString():"BAD ORDER";
       currentTime += System.getProperty("line.separator");
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.writeAndFlush(resp);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
