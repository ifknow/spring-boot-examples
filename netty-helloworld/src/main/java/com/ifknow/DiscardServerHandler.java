package com.ifknow;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

/**
 * @author: ifknow <br>
 * @date: 2020/8/31  10:25 <br>
 * @description: 服务端处理通道，这里只是打印一下请求的内容，并不对请求进行任何的响应 DiscardServerHandler 继承自 ChannelHandlerAdapter，<br>
 * 这个类实现了 ChannelHandler 接口，ChannelHandler 提供了许多事件处理的接口方法。然后你可以覆盖这些方法，现在只需继承 ChannelHandlerAdapter <br>
 * 而不是你自己去实现接口方法
 */
public class DiscardServerHandler extends ChannelHandlerAdapter {

    /**
     * 重写 channelRead 方法：每当客户端收到新的数据时，这个方法会在收到消息时被调用，这个例子中，收到的消息类型是 ByteBuf
     *
     * @param ctx 通道处理的上下文信息
     * @param msg 接收的消息
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            ByteBuf in = (ByteBuf) msg;
            // 打印客户端输入，传输过来的字符
            System.out.print(in.toString(CharsetUtil.UTF_8));
        } finally {
            /**
             * ByteBuf 是一个引用计数对象，这个对象必须显示地调用 release 方法来释放，处理器的职责就是释放所有传递到处理器的引用计数对象
             */
            // 抛弃收到的数据
            ReferenceCountUtil.release(msg);
        }
    }

    /**
     * 这个方法会在发生异常时触发
     *
     * @param ctx   通道处理的上下文信息
     * @param cause 异常
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
