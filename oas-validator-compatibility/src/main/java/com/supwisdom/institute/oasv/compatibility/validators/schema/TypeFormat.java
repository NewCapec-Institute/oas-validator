package com.supwisdom.institute.oasv.compatibility.validators.schema;

import io.swagger.v3.oas.models.media.Schema;

import java.util.Objects;
import java.util.StringJoiner;

public class TypeFormat {
  private final String type;
  private final String format;

  public TypeFormat(String type, String format) {
    this.type = type;
    this.format = format;
  }

  public TypeFormat(Schema schema) {
    this.type = schema.getType();
    this.format = schema.getFormat();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TypeFormat that = (TypeFormat) o;
    return Objects.equals(type, that.type) &&
      Objects.equals(format, that.format);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, format);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", TypeFormat.class.getSimpleName() + "[", "]")
      .add("type='" + type + "'")
      .add("format='" + format + "'")
      .toString();
  }

  public String getType() {
    return type;
  }

  public String getFormat() {
    return format;
  }
}
