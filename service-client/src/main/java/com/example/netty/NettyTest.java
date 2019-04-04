package com.example.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

/**
 * @Description:
 * @Author: huanghs
 * @Date: Created in 1:40 PM 2019/3/28
 */
public class NettyTest {

    private static final Logger logger = LoggerFactory.getLogger(NettyTest.class);

    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.copiedBuffer("Netty in action rocks", Charset.forName("utf-8"));
        logger.info((char) byteBuf.getByte(0)+"");
        int writeIndex = byteBuf.writerIndex();
        int readIndex = byteBuf.readerIndex();
        logger.info(writeIndex+"  "+readIndex);

    }
}
