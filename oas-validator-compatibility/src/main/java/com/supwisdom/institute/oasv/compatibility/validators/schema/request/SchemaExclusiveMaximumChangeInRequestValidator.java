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

package com.supwisdom.institute.oasv.compatibility.validators.schema.request;

import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffValidationContext;
import com.supwisdom.institute.oasv.diffvalidation.util.ChangeRangeCheckUtils;
import com.supwisdom.institute.oasv.compatibility.validators.schema.SchemaPropertyChangeValidator;
import io.swagger.v3.oas.models.media.Schema;
import org.apache.commons.lang3.ObjectUtils;

import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.isInParameter;
import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.isInRequestBody;
import static java.util.Collections.singletonList;

public class SchemaExclusiveMaximumChangeInRequestValidator extends SchemaPropertyChangeValidator<Boolean> {

  @Override
  protected Boolean getProperty(Schema schema) {
    return ObjectUtils.defaultIfNull(schema.getExclusiveMaximum(), Boolean.FALSE);
  }

  @Override
  protected String getPropertyName() {
    return "exclusiveMaximum";
  }

  @Override
  protected boolean isAllowed(Boolean leftProperty, Boolean rightProperty) {

    return ChangeRangeCheckUtils
      .isNotViolated(leftProperty, rightProperty, singletonList(new Object[] { true, false }));

  }

  @Override
  protected String getMessage(Boolean leftProperty, Boolean rightProperty) {
    return "仅允许true->false的修改";
  }

  @Override
  protected boolean needValidate(OasDiffValidationContext context) {
    return isInParameter(context) || isInRequestBody(context);
  }

}
