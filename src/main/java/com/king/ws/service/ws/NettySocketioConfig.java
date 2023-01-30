package com.king.ws.service.ws;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wangyonglong
 * @Date 2023/1/3 4:19 下午
 * @Desc
 **/
@Configuration
@Slf4j
public class NettySocketioConfig {
    /**
     * netty-socketio服务器
     */
    @Bean
    public SocketIOServer socketIOServer() {
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setHostname("localhost");
        config.setPort(9092);
        SocketIOServer server = new SocketIOServer(config);

        log.info("创建SocketIOServer");
        return server;
    }

    /**
     * 用于扫描netty-socketio的注解，比如 @OnConnect、@OnEvent
     */
    @Bean
    public SpringAnnotationScanner springAnnotationScanner() {
        log.info("创建SpringAnnotationScanner");
        return new SpringAnnotationScanner(socketIOServer());
    }
}
