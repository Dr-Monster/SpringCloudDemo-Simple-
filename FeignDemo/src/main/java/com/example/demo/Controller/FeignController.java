package com.example.demo.Controller;

import com.example.demo.Service.IFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeignController {

    @Autowired
    IFeignService iFeignService;

    @RequestMapping(value = "/getListByFeign")
    public List<String> getAllList(){
        return iFeignService.getAllList();
    }
}
