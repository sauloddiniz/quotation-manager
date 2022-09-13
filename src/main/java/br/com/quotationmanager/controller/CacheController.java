package br.com.quotationmanager.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cache")
public class CacheController {

    @DeleteMapping
    @CacheEvict(value = "quotes-local")
    public ResponseEntity<?> deleteCache() {
        return ResponseEntity.ok().build();
    }
}
