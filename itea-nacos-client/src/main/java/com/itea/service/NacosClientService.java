package com.itea.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: cy
 * @Description:
 * @Date 13:43 2022/5/9
 */
@Service
@Slf4j
public class NacosClientService {

    @Autowired
    private DiscoveryClient discoveryClient;

    public List<ServiceInstance> getNacosClientInfo(String serviceId) {
        log.info("查询指定注册服务 : [{}]", serviceId);
        return discoveryClient.getInstances(serviceId);
    }
}
