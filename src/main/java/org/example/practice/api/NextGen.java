package org.example.practice.api;


import org.springframework.web.bind.annotation.*;

@RestController
public class NextGen {



    @GetMapping("/hello/gen")
    public String sayHello(){
        return "Hollaaaaaa!!!, welcome!!..";
    }

    @GetMapping("/cpu")
    public String stressCpu() {
        long end = System.currentTimeMillis() + 10000; // Run for 10 seconds
        while (System.currentTimeMillis() < end) {
            Math.sqrt(Math.random());
        }
        return "CPU stress done";
    }




}
