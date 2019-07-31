package com.supwisdom.insitute.oasv.web.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffViolation;
import com.supwisdom.institute.oasv.validation.api.OasViolation;

public class ImportError {

  private final List<String> parseErrors = new ArrayList<>();

  private final List<OasViolation> violations = new ArrayList<>();

  private final List<OasDiffViolation> diffViolations = new ArrayList<>();

  @JsonIgnore
  public boolean isNotEmpty() {
    return CollectionUtils.isNotEmpty(parseErrors)
        || CollectionUtils.isNotEmpty(violations)
        || CollectionUtils.isNotEmpty(diffViolations);
  }

  /**
   * OAS Spec Yaml parse错误
   *
   * @return
   */
  public List<String> getParseErrors() {
    return parseErrors;
  }

  /**
   * 违反合规性检查
   *
   * @return
   */
  public List<OasViolation> getViolations() {
    return violations;
  }

  /**
   * 违反兼容性检查
   *
   * @return
   */
  public List<OasDiffViolation> getDiffViolations() {
    return diffViolations;
  }

  public void addParseErrors(List<String> syntaxErrors) {
    this.parseErrors.addAll(syntaxErrors);
  }

  public void addViolations(List<OasViolation> violations) {
    this.violations.addAll(violations);
  }

  public void addDiffViolations(List<OasDiffViolation> diffViolations) {
    this.diffViolations.addAll(diffViolations);
  }


}
