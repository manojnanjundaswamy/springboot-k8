package org.example.practice.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class CpuLoadController {

    @GetMapping("/cpu-heavy")
    public String heavyCpuLoad(@RequestParam(defaultValue = "8") int threads,
                               @RequestParam(defaultValue = "20000") long durationMs) {

        ExecutorService executor = Executors.newFixedThreadPool(threads);
        long endTime = System.currentTimeMillis() + durationMs;

        Runnable task = () -> {
            while (System.currentTimeMillis() < endTime) {
                // Pure CPU usage
                double x = Math.pow(Math.random(), Math.random());
            }
        };

        for (int i = 0; i < threads; i++) {
            executor.submit(task);
        }

        executor.shutdown();
        return "Started " + threads + " CPU load threads for " + durationMs + "ms";
    }
}
