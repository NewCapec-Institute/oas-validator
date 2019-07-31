package com.supwisdom.insitute.oasv.web.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffViolation;
import com.supwisdom.institute.oasv.validation.api.OasViolation;

public class ImportError2 {

  private final List<String> leftParseErrors = new ArrayList<>();

  private final List<String> rightParseErrors = new ArrayList<>();

  private final List<OasDiffViolation> violations = new ArrayList<>();

  @JsonIgnore
  public boolean isNotEmpty() {
    return CollectionUtils.isNotEmpty(leftParseErrors)
        || CollectionUtils.isNotEmpty(rightParseErrors)
        || CollectionUtils.isNotEmpty(violations);
  }

  public List<String> getLeftParseErrors() {
    return leftParseErrors;
  }

  public List<String> getRightParseErrors() {
    return rightParseErrors;
  }


  /**
   * 违反兼容性检查
   *
   * @return
   */
  public List<OasDiffViolation> getViolations() {
    return violations;
  }

  public void addLeftParseErrors(List<String> syntaxErrors) {
    this.leftParseErrors.addAll(syntaxErrors);
  }

  public void addRightParseErrors(List<String> syntaxErrors) {
    this.rightParseErrors.addAll(syntaxErrors);
  }


  public void addViolations(List<OasDiffViolation> diffViolations) {
    this.violations.addAll(diffViolations);
  }
}
