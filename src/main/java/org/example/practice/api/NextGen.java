package org.example.practice.api;


import org.springframework.web.bind.annotation.*;

@RestController
public class NextGen {



    @GetMapping("/hello/gen")
    public String sayHello(){
        return "Hollaaaaaa!!!, welcome!!..";
    }




}
