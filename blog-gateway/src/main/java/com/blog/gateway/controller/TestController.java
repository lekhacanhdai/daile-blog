package com.blog.gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author lkadai0801
 * @since 28/03/2024
 */

@RestController
public class TestController {
    @GetMapping("public")
    public ResponseEntity<?> publicAPI(){
        return ResponseEntity.ok(Map.of("success", true));
    }
    
    @GetMapping("private")
    public ResponseEntity<?> privateAPI(){
        return ResponseEntity.ok(Map.of("success", true));
    }
}
