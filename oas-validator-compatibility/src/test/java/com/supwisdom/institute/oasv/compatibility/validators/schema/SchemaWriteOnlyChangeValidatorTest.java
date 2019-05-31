package com.supwisdom.institute.oasv.compatibility.validators.schema;

import com.supwisdom.institute.oasv.diffvalidation.api.DiffViolationMessages;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffViolation;
import com.supwisdom.institute.oasv.diffvalidation.api.SchemaCompareValidator;
import com.supwisdom.institute.oasv.diffvalidation.config.OasDiffValidatorsSkeletonConfiguration;

import com.supwisdom.institute.oasv.compatibility.validators.OasCompatibilityTestBase;
import io.swagger.v3.oas.models.OpenAPI;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.*;
import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = SchemaWriteOnlyChangeValidatorTest.TestConfiguration.class)
public class SchemaWriteOnlyChangeValidatorTest extends OasCompatibilityTestBase {

  @Test
  public void validate() {
    OpenAPI leftOpenAPI = loadRelative("petstore-schema-write-only-a.yaml");
    OpenAPI rightOpenAPI = loadRelative("petstore-schema-write-only-b.yaml");
    List<OasDiffViolation> violations = oasSpecDiffValidator
      .validate(createContext(leftOpenAPI, rightOpenAPI), leftOpenAPI, rightOpenAPI);

    assertThat(violations)
      .containsExactlyInAnyOrder(
        createViolationBoth(
          DiffViolationMessages.NEW_NOT_EQ_OLD,
          new Object[] {
            "paths", PATHS,
            "/pets", PATH_ITEM,
            "post", OPERATION,
            "parameters[0]", PARAMETER,
            "schema", SCHEMA,
            "properties.'foo'", SCHEMA,
            "writeOnly", null
          }
        ),
        createViolationBoth(
          DiffViolationMessages.NEW_NOT_EQ_OLD,
          new Object[] {
            "paths", PATHS,
            "/pets", PATH_ITEM,
            "post", OPERATION,
            "requestBody", REQUEST_BODY,
            "content.'application/xml'", MEDIA_TYPE,
            "schema", SCHEMA,
            "properties.'foo'", SCHEMA,
            "writeOnly", null
          }
        ),
        createViolationBoth(
          DiffViolationMessages.NEW_NOT_EQ_OLD,
          new Object[] {
            "paths", PATHS,
            "/pets", PATH_ITEM,
            "post", OPERATION,
            "responses", RESPONSES,
            "200", RESPONSE,
            "content.'application/xml'", MEDIA_TYPE,
            "schema", SCHEMA,
            "properties.'foo'", SCHEMA,
            "writeOnly", null
          }
        )
      );

  }

  @Configuration
  @Import(OasDiffValidatorsSkeletonConfiguration.class)
  public static class TestConfiguration {

    @Bean
    public SchemaCompareValidator schemaWriteOnlyChangeValidator() {

      return new SchemaWriteOnlyChangeValidator();
    }

  }

}



