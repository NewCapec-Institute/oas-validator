package com.supwisdom.insitute.oasv.web.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/editor")
public class EditorController {
  
  @GetMapping()
  public String index() {
    
    
    
    return "/editor/index";
  }

}
