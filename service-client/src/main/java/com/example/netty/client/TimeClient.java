package com.example.netty.client;

import com.example.netty.client.handler.ClientChannelInit;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;


/**
 * @Description:
 * @Author: huanghs
 * @Date: Created in 3:54 PM 2019/4/2
 */
public class TimeClient {
    public static void main(String[] args) throws Exception{
        EventLoopGroup eventLoopGroup = new  NioEventLoopGroup();
        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY,true)
                    .handler(new ClientChannelInit());
            ChannelFuture channelFuture = bootstrap.connect("localhost",8080).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            eventLoopGroup.shutdownGracefully();
        }

    }
}
