package com.supwisdom.institute.oasv.validation.api;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * OpenAPI v3 校验出的违反限制条件的错误
 */
public class OasViolation {

  /**
   * 对象位置
   */
  private final OasObjectPropertyLocation location;

  /**
   * 错误信息
   */
  private final String error;

  public OasViolation(OasObjectPropertyLocation location, String error) {
    this.location = location;
    this.error = error;
  }

  public OasObjectPropertyLocation getLocation() {
    return location;
  }

  public String getError() {
    return error;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", OasViolation.class.getSimpleName() + "[", "]")
      .add("location=" + location)
      .add("error='" + error + "'")
      .toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OasViolation that = (OasViolation) o;
    return Objects.equals(location, that.location) &&
      Objects.equals(error, that.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(location, error);
  }
}
