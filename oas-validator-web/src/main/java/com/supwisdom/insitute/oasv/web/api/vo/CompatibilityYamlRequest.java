package com.supwisdom.insitute.oasv.web.api.vo;

import lombok.Getter;
import lombok.Setter;

public class CompatibilityYamlRequest {
  
  @Getter
  @Setter
  String leftYaml;

  @Getter
  @Setter
  String rightYaml;

}
