package com.devy.quiz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/materias")
public class MateriasController {

    @GetMapping
    public Map<String, Object> getMaterias() {
        Map<String, Object> response = new HashMap<>();
        
        try {
            // Cargar el archivo JSON desde el classpath
            ClassPathResource resource = new ClassPathResource("materias.json");
            InputStream inputStream = resource.getInputStream();
            
            // Leer y parsear el JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(inputStream);
            
            response.put("status", "success");
            response.put("data", jsonNode);
            response.put("message", "Lista de materias obtenida exitosamente");
            
        } catch (IOException e) {
            response.put("status", "error");
            response.put("message", "Error al cargar la lista de materias: " + e.getMessage());
            response.put("data", null);
        }
        
        return response;
    }

    @GetMapping("/count")
    public Map<String, Object> getMateriasCount() {
        Map<String, Object> response = new HashMap<>();
        
        try {
            ClassPathResource resource = new ClassPathResource("com/devy/materias/materias.json");
            InputStream inputStream = resource.getInputStream();
            
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(inputStream);
            JsonNode materiasArray = jsonNode.get("materias");
            
            int count = materiasArray != null ? materiasArray.size() : 0;
            
            response.put("status", "success");
            response.put("totalMaterias", count);
            response.put("message", "Conteo de materias obtenido exitosamente");
            
        } catch (IOException e) {
            response.put("status", "error");
            response.put("message", "Error al contar las materias: " + e.getMessage());
            response.put("totalMaterias", 0);
        }
        
        return response;
    }
}
