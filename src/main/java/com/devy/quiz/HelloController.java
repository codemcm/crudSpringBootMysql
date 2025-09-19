package com.devy.quiz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Map<String, Object> helloWorld() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "¡Hola Mundo!");
        response.put("status", "success");
        response.put("timestamp", System.currentTimeMillis());
        return response;
    }

    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Bienvenido a la aplicación Quiz");
        response.put("status", "success");
        response.put("application", "Quiz Application");
        response.put("version", "1.0.0");
        return response;
    }
}