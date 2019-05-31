package com.supwisdom.institute.oasv.common;

/**
 * OpenAPI v3 的Object类型
 * <p>
 * 对应<a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#schema">OpenAPI Specification - Schema</a>
 * </p>
 */
public enum OasObjectType {
  OPENAPI,
  INFO,
  CONTACT,
  LICENSE,
  SERVER,
  SERVER_VARIABLE,
  COMPONENTS,
  PATHS,
  PATH_ITEM,
  OPERATION,
  EXTERNAL_DOCUMENTATION,
  PARAMETER,
  REQUEST_BODY,
  MEDIA_TYPE,
  ENCODING,
  RESPONSES,
  RESPONSE,
  CALLBACK,
  EXAMPLE,
  HEADER,
  TAG,
  REFERENCE,
  SCHEMA,
  DISCRIMINATOR,
  XML,
  SECURITY_SCHEME,
  OAUTH_FLOWS,
  OAUTH_FLOW,
  LINK,
  SECURITY_REQUIREMENT
}
