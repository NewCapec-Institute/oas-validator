package com.supwisdom.insitute.oasv.web.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/viewer")
public class ViewerController {
  
  @GetMapping()
  public String index() {
    
    
    
    return "/viewer/index";
  }

}
