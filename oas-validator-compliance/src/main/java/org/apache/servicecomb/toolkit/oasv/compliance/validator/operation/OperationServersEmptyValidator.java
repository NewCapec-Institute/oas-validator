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

package org.apache.servicecomb.toolkit.oasv.compliance.validator.operation;

import org.apache.servicecomb.toolkit.oasv.common.OasObjectPropertyLocation;
import org.apache.servicecomb.toolkit.oasv.validation.api.OasValidationContext;
import org.apache.servicecomb.toolkit.oasv.validation.api.OasViolation;
import org.apache.servicecomb.toolkit.oasv.validation.api.OperationValidator;
import io.swagger.v3.oas.models.Operation;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

import static org.apache.servicecomb.toolkit.oasv.common.OasObjectType.SERVER;
import static org.apache.servicecomb.toolkit.oasv.validation.api.ViolationMessages.MUST_BE_EMPTY;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#operationObject">Operation Object</a>
 * .servers属性校验器
 * <ul>
 * <li>不允许提供</li>
 * </ul>
 */
public class OperationServersEmptyValidator implements OperationValidator {
  @Override
  public List<OasViolation> validate(OasValidationContext context, OasObjectPropertyLocation location,
    Operation oasObject) {
    if (CollectionUtils.isEmpty(oasObject.getServers())) {
      return emptyList();
    }
    return singletonList(new OasViolation(location.property("servers", SERVER), MUST_BE_EMPTY));
  }
}
