package com.itea.controller;

import com.itea.service.NacosClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: cy
 * @Description:
 * @Date 13:47 2022/5/9
 */
@Slf4j
@RestController
@RequestMapping("/nacos-licent")
public class NacosClientController {
    @Autowired
    private NacosClientService nacosClientService;

    @GetMapping("/service-instance")
    public List<ServiceInstance> getNacosClientInfo(@RequestParam(defaultValue = "itea-nacos-client") String serviceId) {
        return nacosClientService.getNacosClientInfo(serviceId);
    }
}


