package com.project.bookzy.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomePageController {
  @GetMapping("/")
  public String showWelcomeMessage() {
  String returnMessage = "Hello ...... Welcome to Bookzy App!!!!";
  //String returnMessage = null;
  return returnMessage;
  }
}
