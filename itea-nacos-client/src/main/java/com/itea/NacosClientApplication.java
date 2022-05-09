package com.itea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: cy
 * @Description:
 * @Date 13:39 2022/5/9
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosClientApplication.class,args);
    }
}
