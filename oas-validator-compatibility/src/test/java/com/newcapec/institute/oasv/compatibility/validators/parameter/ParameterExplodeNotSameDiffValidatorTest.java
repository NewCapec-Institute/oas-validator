/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.newcapec.institute.oasv.compatibility.validators.parameter;

import com.newcapec.institute.oasv.diffvalidation.api.DiffViolationMessages;
import com.newcapec.institute.oasv.diffvalidation.api.OasDiffViolation;
import com.newcapec.institute.oasv.diffvalidation.api.ParameterDiffValidator;
import com.newcapec.institute.oasv.diffvalidation.config.OasDiffValidatorsSkeletonConfiguration;

import com.newcapec.institute.oasv.compatibility.validators.OasCompatibilityTestBase;
import io.swagger.v3.oas.models.OpenAPI;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static com.newcapec.institute.oasv.common.OasObjectType.*;
import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = ParameterExplodeNotSameDiffValidatorTest.TestConfiguration.class)
public class ParameterExplodeNotSameDiffValidatorTest extends OasCompatibilityTestBase {

  @Test
  public void validate() {
    OpenAPI leftOpenAPI = loadRelative("petstore-parameter-explode-a.yaml");
    OpenAPI rightOpenAPI = loadRelative("petstore-parameter-explode-b.yaml");
    List<OasDiffViolation> violations = oasSpecDiffValidator
      .validate(createContext(leftOpenAPI, rightOpenAPI), leftOpenAPI, rightOpenAPI);

    assertThat(violations)
      .containsExactlyInAnyOrder(
        createViolation(
          "[name=limit,in=query]:" + DiffViolationMessages.NEW_NOT_EQ_OLD,
          new Object[] {
            "paths", PATHS,
            "/pets", PATH_ITEM,
            "get", OPERATION,
            "parameters[0]", PARAMETER,
            "explode", null
          },
          new Object[] {
            "paths", PATHS,
            "/pets", PATH_ITEM,
            "get", OPERATION,
            "parameters[1]", PARAMETER,
            "explode", null
          }
        )
      );

  }

  @Configuration
  @Import(OasDiffValidatorsSkeletonConfiguration.class)
  public static class TestConfiguration {

    @Bean
    public ParameterDiffValidator parameterExplodeNotSameDiffValidator() {

      return new ParameterExplodeNotSameDiffValidator();
    }

  }

}

