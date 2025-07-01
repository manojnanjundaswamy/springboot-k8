package org.example.practice.api;


import org.springframework.web.bind.annotation.*;

@RestController
public class GreetApis {



    @GetMapping("/hello")
    public String sayHello(){
        return "Hello, welcome!!..";
    }

    @GetMapping("/goodbye")
    public String sayGoodbye() {
        return "Goodbye, see you soon!";
    }

    @GetMapping("/greet/{name}")
    public String greetByName(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/status")
    public String getStatus() {
        return "Service is up and running!";
    }

    @PostMapping("/greet")
    public String createGreeting(@RequestBody String name) {
        return "Greeting created for " + name;
    }

    @PutMapping("/greet/{name}")
    public String updateGreeting(@PathVariable String name, @RequestBody String newName) {
        return "Greeting updated from " + name + " to " + newName;
    }

    @DeleteMapping("/greet/{name}")
    public String deleteGreeting(@PathVariable String name) {
        return "Greeting deleted for " + name;
    }



}
