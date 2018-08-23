package com.bw.fit.system.socket.component;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.bw.fit.system.socket.handler.IMSocketHandler;
import com.bw.fit.system.socket.interceptor.HandshakeInterceptor;

public class MyWebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer{

	@Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        //前台 可以使用websocket环境
        registry.addHandler(myWebSocketHandler(),"/websocket").addInterceptors(new HandshakeInterceptor());


      //前台 不可以使用websocket环境，则使用sockjs进行模拟连接
        registry.addHandler(myWebSocketHandler(), "/sockjs/websocket").addInterceptors(new HandshakeInterceptor())
                .withSockJS();
    }


    // websocket 处理类
    @Bean
    public WebSocketHandler myWebSocketHandler(){
        return new IMSocketHandler();
    }

}
