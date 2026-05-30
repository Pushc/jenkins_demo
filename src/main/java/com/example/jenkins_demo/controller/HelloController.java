package com.example.jenkins_demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {

 @GetMapping("/")
 public String home() {
   return "Version 3";
 }

}