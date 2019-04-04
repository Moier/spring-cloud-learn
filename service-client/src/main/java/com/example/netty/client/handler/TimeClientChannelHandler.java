package com.example.netty.client.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @Author: huanghs
 * @Date: Created in 3:59 PM 2019/4/2
 */
public class TimeClientChannelHandler extends ChannelInboundHandlerAdapter{

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeClientChannelHandler.class);

    private byte[] req;

    private int counter = 0;


    public TimeClientChannelHandler(){
        req = ("QUERY TIME ORDER"+System.getProperty("line.separator")).getBytes();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf byteBuf = null;
        for(int i=0;i<100;i++){
            byteBuf = Unpooled.buffer();
            byteBuf.writeBytes(req);
            ctx.writeAndFlush(byteBuf);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        LOGGER.info("now is {} , the counter is {}", msg, ++counter);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOGGER.error(cause.getLocalizedMessage(),cause.getStackTrace());
        ctx.close();
    }
}
