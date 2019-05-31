package com.supwisdom.institute.oasv.validation.skeleton.pathitem;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.util.OasObjectValidatorUtils;
import com.supwisdom.institute.oasv.validation.api.*;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#pathItemObject">Path Item Object</a>
 * .get / .put / .post / .delete / .options / .head / .patch / .trace 各个
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#operationObject">Operation Object</a>的校验器
 */
public class PathItemOperationsValidator implements PathItemValidator {

  private final List<OperationValidator> operationValidators;

  public PathItemOperationsValidator(List<OperationValidator> operationValidators) {
    this.operationValidators = operationValidators;
  }

  @Override
  public List<OasViolation> validate(OasValidationContext context, OasObjectPropertyLocation location,
    PathItem oasObject) {
    if (StringUtils.isNotBlank(oasObject.get$ref())) {
      return emptyList();
    }

    List<OasViolation> violations = new ArrayList<>();

    Map<PathItem.HttpMethod, Operation> operationMap = oasObject.readOperationsMap();

    for (Map.Entry<PathItem.HttpMethod, Operation> entry : operationMap.entrySet()) {
      PathItem.HttpMethod method = entry.getKey();
      Operation operation = entry.getValue();
      OasObjectPropertyLocation operationLocation = location.property(method.toString().toLowerCase(), OasObjectType.OPERATION);
      violations.addAll(
        OasObjectValidatorUtils.doValidateProperty(context, operationLocation, operation, operationValidators));
    }
    return violations;
  }
}
