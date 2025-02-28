package com.korit.spring_basic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korit.spring_basic.service.JpaService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/jpa")
@RequiredArgsConstructor
public class JpaController {
    
    private final JpaService jpaService;
    
    @PostMapping("/sample1")
    public ResponseEntity<String> postSample1() {
        ResponseEntity<String> response = jpaService.createSampleTable1();
        return response;
    }
    

}
