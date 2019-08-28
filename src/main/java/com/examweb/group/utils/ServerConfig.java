package com.examweb.group.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author yanni
 */
@Component
@Data
@Configuration
public class ServerConfig implements ApplicationListener<WebServerInitializedEvent> {


    public int serverPort;
    @Value("${server.port}")
    private int propertyPort;

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        this.setServerPort(event.getApplicationContext().getWebServer().getPort());
        System.out.println("这是第一个" + this.getServerPort());
    }

    public int getPort() {
        System.out.println("这是第两个个" + this.getServerPort());
        //return this.getServerPort();
        return 8048;
    }

    public String getUrl() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        assert address != null;
        System.out.println("配置文件的" + this.getPropertyPort());
        return "http://" + address.getHostAddress() + ":" + this.getPort();
    }
}


