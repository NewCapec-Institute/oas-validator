package com.supwisdom.insitute.oasv.web.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/validator")
public class ValidatorController {

  @GetMapping()
  public String index() {
    
    
    
    return "/validator/index";
  }

  @GetMapping(path = "/compliance")
  public String complianceValidator() {
    
    
    
    return "/validator/compliance";
  }

  @GetMapping(path = "/compatibility")
  public String compatibilityValidator() {
    
    
    
    return "/validator/compatibility";
  }

}
