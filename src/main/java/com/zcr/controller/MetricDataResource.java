package com.zcr.controller;

import com.zcr.entities.MetricRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metric")
public class MetricDataResource {

    @GetMapping
    public String search(MetricRequest metricRequest) {
       /* String[] hobby = metricRequest.getHobby();
        System.out.println(hobby);
        return hobby.toString();*/
       String id = metricRequest.getId();
       System.out.println(id);
       String[] hobby = metricRequest.getHobby();
       System.out.println(hobby);
       System.out.println(hobby[0]);
       System.out.println(hobby[1]);
       System.out.println(hobby[2]);
       return id+"shshshshsh"+hobby[0]+"shshshshsh"+hobby[1]+"shshshshsh"+hobby[2];
    }
}
