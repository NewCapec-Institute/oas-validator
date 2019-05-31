package com.supwisdom.institute.oasv.common;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * OpenAPI V3 对象属性信息
 */
public class OasObjectProperty {

  /**
   * 属性名称
   */
  private final String name;

  /**
   * 属性的对象的类型，如果为null则代表基础类型，而不是OAS Object
   */
  private final OasObjectType objectType;

  public OasObjectProperty(String name) {
    this(null, name);
  }

  public OasObjectProperty(OasObjectType objectType, String name) {
    this.objectType = objectType;
    this.name = name;
  }

  public OasObjectType getObjectType() {
    return objectType;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OasObjectProperty that = (OasObjectProperty) o;
    return objectType == that.objectType &&
      Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objectType, name);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", OasObjectProperty.class.getSimpleName() + "[", "]")
      .add("name='" + name + "'")
      .add("objectType=" + objectType)
      .toString();
  }
}
