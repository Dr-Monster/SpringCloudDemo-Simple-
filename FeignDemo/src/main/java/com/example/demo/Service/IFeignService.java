package com.example.demo.Service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "service/ServiceController")
public interface IFeignService {

    @RequestMapping(value = "/getList")
    public List<String> getAllList();
}
