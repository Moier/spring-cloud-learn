package com.example.netty.server.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @Description:
 * @Author: huanghs
 * @Date: Created in 3:42 PM 2019/4/2
 */
public class ChildChannelHandler extends ChannelInitializer{
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
        ch.pipeline().addLast(new StringDecoder());
        ch.pipeline().addLast(new TimeServerHandler());
    }
}
