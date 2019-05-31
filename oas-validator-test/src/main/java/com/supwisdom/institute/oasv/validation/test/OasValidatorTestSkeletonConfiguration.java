package com.supwisdom.institute.oasv.validation.test;

import com.supwisdom.institute.oasv.validation.api.*;
import com.supwisdom.institute.oasv.validation.skeleton.components.*;
import com.supwisdom.institute.oasv.validation.skeleton.encoding.EncodingHeadersValuesValidator;
import com.supwisdom.institute.oasv.validation.skeleton.header.HeaderSchemaValidator;
import com.supwisdom.institute.oasv.validation.skeleton.mediatype.MediaTypeEncodingValidator;
import com.supwisdom.institute.oasv.validation.skeleton.mediatype.MediaTypeSchemaValidator;
import com.supwisdom.institute.oasv.validation.skeleton.openapi.*;
import com.supwisdom.institute.oasv.validation.skeleton.operation.OperationParametersValidator;
import com.supwisdom.institute.oasv.validation.skeleton.operation.OperationRequestBodyValidator;
import com.supwisdom.institute.oasv.validation.skeleton.operation.OperationResponsesValidator;
import com.supwisdom.institute.oasv.validation.skeleton.parameter.ParameterContentValidator;
import com.supwisdom.institute.oasv.validation.skeleton.parameter.ParameterSchemaValidator;
import com.supwisdom.institute.oasv.validation.skeleton.pathitem.PathItemOperationsValidator;
import com.supwisdom.institute.oasv.validation.skeleton.pathitem.PathItemParametersValidator;
import com.supwisdom.institute.oasv.validation.skeleton.paths.PathsPathItemsValidator;
import com.supwisdom.institute.oasv.validation.skeleton.requestbody.RequestBodyContentValidator;
import com.supwisdom.institute.oasv.validation.skeleton.response.ResponseContentValidator;
import com.supwisdom.institute.oasv.validation.skeleton.response.ResponseHeadersValuesValidator;
import com.supwisdom.institute.oasv.validation.skeleton.responses.ResponsesResponsesValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * OAS测试骨架Configuration。包含
 * <ol>
 * <li>骨架Validator，指只那些自己没有验证逻辑，只是将OAS Object属性交给对应OAS Validator校验的Validator</li>
 * <li>DefaultOasSpecValidator</li>
 * </ol>
 */
@Configuration
public class OasValidatorTestSkeletonConfiguration {

  @Bean
  public OasSpecValidator oasSpecValidator(List<OpenApiValidator> openApiValidators) {
    return new DefaultOasSpecValidator(openApiValidators);
  }

  @Bean
  public ComponentsValidator componentsHeadersValuesValidator(
    List<HeaderValidator> headerValidators) {
    return new ComponentsHeadersValuesValidator(headerValidators);
  }

  @Bean
  public ComponentsValidator componentsParametersValuesValidator(
    List<ParameterValidator> parameterValidators) {
    return new ComponentsParametersValuesValidator(parameterValidators);
  }

  @Bean
  public ComponentsValidator componentsRequestBodiesValuesValidator(
    List<RequestBodyValidator> requestBodyValidators) {
    return new ComponentsRequestBodiesValuesValidator(requestBodyValidators);
  }

  @Bean
  public ComponentsValidator componentsResponsesValuesValidator(
    List<ResponseValidator> responseValidators) {
    return new ComponentsResponsesValuesValidator(responseValidators);
  }

  @Bean
  public ComponentsValidator componentsSchemasValuesValidator(
    List<SchemaValidator> schemaValidators) {
    return new ComponentsSchemasValuesValidator(schemaValidators);
  }

  @Bean
  public ComponentsValidator componentSecuritySchemesValidator(
    List<SecuritySchemeValidator> securitySchemeValidators) {
    return new ComponentsSecuritySchemesValuesValidator(securitySchemeValidators);
  }

  @Bean
  public EncodingValidator encodingHeadersValuesValidator(
    List<HeaderValidator> headerValidators) {
    return new EncodingHeadersValuesValidator(headerValidators);
  }

  @Bean
  public HeaderValidator headerSchemaValidator(
    List<SchemaValidator> schemaValidators) {
    return new HeaderSchemaValidator(schemaValidators);
  }

  @Bean
  public MediaTypeValidator mediaTypeSchemaValidator(
    List<SchemaValidator> schemaValidators) {
    return new MediaTypeSchemaValidator(schemaValidators);
  }

  @Bean
  public MediaTypeValidator mediaTypeEncodingValidator(
    List<EncodingValidator> encodingValidators) {
    return new MediaTypeEncodingValidator(encodingValidators);
  }

  @Bean
  public OpenApiValidator openApiComponentsValidator(
    List<ComponentsValidator> componentsValidators) {
    return new OpenApiComponentsValidator(componentsValidators);
  }

  @Bean
  public OpenApiValidator openApiInfoValidator(
    List<InfoValidator> infoValidators) {
    return new OpenApiInfoValidator(infoValidators);
  }

  @Bean
  public OpenApiValidator openApiPathsValidator(
    List<PathsValidator> pathsValidators) {
    return new OpenApiPathsValidator(pathsValidators);
  }

  @Bean
  public OpenApiValidator openApiServersValidator(
    List<ServerValidator> serverValidators) {
    return new OpenApiServersValidator(serverValidators);
  }

  @Bean
  public OpenApiValidator openApiTagsValidator(
    List<TagValidator> tagValidators) {
    return new OpenApiTagsValidator(tagValidators);
  }

  @Bean
  public OperationValidator operationParametersValidator(
    List<ParameterValidator> parameterValidators) {
    return new OperationParametersValidator(parameterValidators);
  }

  @Bean
  public OperationValidator operationResponsesValidator(
    List<ResponsesValidator> responsesValidators) {
    return new OperationResponsesValidator(responsesValidators);
  }

  @Bean
  public OperationValidator operationRequestBodyValidator(
    List<RequestBodyValidator> requestBodyValidators) {
    return new OperationRequestBodyValidator(requestBodyValidators);
  }

  @Bean
  public ParameterValidator parameterSchemaValidator(
    List<SchemaValidator> schemaValidators) {
    return new ParameterSchemaValidator(schemaValidators);
  }

  @Bean
  public ParameterValidator parameterContentMediaTypeValidator(
    List<MediaTypeValidator> mediaTypeValidators) {
    return new ParameterContentValidator(mediaTypeValidators);
  }

  @Bean
  public PathItemValidator pathItemOperationsValidator(
    List<OperationValidator> operationValidators) {
    return new PathItemOperationsValidator(operationValidators);
  }

  @Bean
  public PathItemValidator pathItemParametersValidator(
    List<ParameterValidator> parameterValidators) {
    return new PathItemParametersValidator(parameterValidators);
  }

  @Bean
  public PathsValidator pathsPathItemsValidator(
    List<PathItemValidator> pathItemValidators) {
    return new PathsPathItemsValidator(pathItemValidators);
  }

  @Bean
  public RequestBodyValidator requestBodyContentValidator(
    List<MediaTypeValidator> mediaTypeValidators) {
    return new RequestBodyContentValidator(mediaTypeValidators);
  }

  @Bean
  public ResponsesValidator responsesResponsesValidator(
    List<ResponseValidator> responseValidators) {
    return new ResponsesResponsesValidator(responseValidators);
  }

  @Bean
  public ResponseValidator responseContentValidator(
    List<MediaTypeValidator> mediaTypeValidators) {
    return new ResponseContentValidator(mediaTypeValidators);
  }

  @Bean
  public ResponseValidator responseHeadersValuesValidator(
    List<HeaderValidator> headerValidators) {
    return new ResponseHeadersValuesValidator(headerValidators);
  }

}
