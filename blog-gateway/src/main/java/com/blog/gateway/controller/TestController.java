package com.blog.gateway.controller;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lkadai0801
 * @since 28/03/2024
 */
@RestController
public class TestController {
  @GetMapping("public")
  public ResponseEntity<Object> publicAPI() {
    return ResponseEntity.ok(Map.of("success", true));
  }

  @GetMapping("private")
  @Secured({"ADMIN", "USER"})
  public ResponseEntity<Object> privateAPI() {
    return ResponseEntity.ok(Map.of("success", true));
  }
}
