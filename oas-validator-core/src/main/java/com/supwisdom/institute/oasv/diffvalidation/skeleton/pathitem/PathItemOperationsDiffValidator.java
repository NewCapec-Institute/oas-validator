package com.supwisdom.institute.oasv.diffvalidation.skeleton.pathitem;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.diffvalidation.api.*;
import com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.OPERATION;
import static com.supwisdom.institute.oasv.diffvalidation.util.OasObjectDiffValidatorUtils.doDiffValidateProperty;

public class PathItemOperationsDiffValidator
  extends OasObjectDiffValidatorTemplate<PathItem>
  implements PathItemDiffValidator {

  private final List<OperationDiffValidator> operationValidators;

  public PathItemOperationsDiffValidator(List<OperationDiffValidator> operationValidators) {
    this.operationValidators = operationValidators;
  }

  @Override
  public List<OasDiffViolation> validateCompare(OasDiffValidationContext context,
    OasObjectPropertyLocation leftLocation, PathItem leftOasObject,
    OasObjectPropertyLocation rightLocation, PathItem rightOasObject) {

    Map<PathItem.HttpMethod, Operation> leftOperationMap = leftOasObject.readOperationsMap();
    Map<PathItem.HttpMethod, Operation> rightOperationMap = rightOasObject.readOperationsMap();

    List<OasDiffViolation> violations = new ArrayList<>();

    for (Map.Entry<PathItem.HttpMethod, Operation> entry : leftOperationMap.entrySet()) {
      PathItem.HttpMethod leftMethod = entry.getKey();
      Operation leftOperation = entry.getValue();
      OasObjectPropertyLocation leftOperationLoc = leftLocation
        .property(leftMethod.toString().toLowerCase(), OPERATION);

      Operation rightOperation = rightOperationMap.get(leftMethod);
      if (rightOperation == null) {

        violations.addAll(
          doDiffValidateProperty(
            context,
            leftOperationLoc,
            leftOperation,
            null,
            null,
            operationValidators
          )
        );

      } else {

        OasObjectPropertyLocation rightOperationLoc = rightLocation
          .property(leftMethod.toString().toLowerCase(), OPERATION);
        violations.addAll(
          doDiffValidateProperty(
            context,
            leftOperationLoc,
            leftOperation,
            rightOperationLoc,
            rightOperation,
            operationValidators
          )
        );

      }

    }

    for (Map.Entry<PathItem.HttpMethod, Operation> entry : rightOperationMap.entrySet()) {
      PathItem.HttpMethod rightMethod = entry.getKey();
      if (leftOperationMap.containsKey(rightMethod)) {
        continue;
      }
      Operation rightOperation = rightOperationMap.get(rightMethod);
      OasObjectPropertyLocation rightOperationLoc = rightLocation
        .property(rightMethod.toString().toLowerCase(), OPERATION);

      violations.addAll(
        doDiffValidateProperty(
          context,
          null,
          null,
          rightOperationLoc,
          rightOperation,
          operationValidators
        )
      );

    }

    return violations;

  }

}
