package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/ClientController")
public class ClientController {

    @Autowired
    RestTemplate restTemplate ;

    @RequestMapping(value = "/getList")
    public List<String> getList(){
        return restTemplate.getForObject("http://service/ServiceController/getList" , List.class) ;
    }

}
