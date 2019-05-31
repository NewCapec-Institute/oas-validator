package com.supwisdom.institute.oasv.compatibility.validators.operation;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.diffvalidation.api.*;
import io.swagger.v3.oas.models.Operation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Collections.*;

public class OperationOAuth2ScopeNotSameDiffValidator
  extends OasObjectDiffValidatorTemplate<Operation>
  implements OperationDiffValidator {

  @Override
  protected List<OasDiffViolation> validateCompare(OasDiffValidationContext context,
    OasObjectPropertyLocation leftLocation, Operation leftOasObject, OasObjectPropertyLocation rightLocation,
    Operation rightOasObject) {

    Set<String> leftScopes = extractScopes(leftOasObject);
    Set<String> rightScopes = extractScopes(rightOasObject);

    if (leftScopes.equals(rightScopes)) {
      return emptyList();
    }

    OasObjectPropertyLocation leftOauth2Loc = leftLocation
      .property("security[0]", OasObjectType.SECURITY_REQUIREMENT)
      .property("oauth2");

    OasObjectPropertyLocation rightOauth2Loc = rightLocation
      .property("security[0]", OasObjectType.SECURITY_REQUIREMENT)
      .property("oauth2");

    return singletonList(new OasDiffViolation(leftOauth2Loc, rightOauth2Loc, DiffViolationMessages.NEW_NOT_EQ_OLD));

  }

  private Set<String> extractScopes(Operation operation) {
    try {
      return new HashSet<>(operation.getSecurity().get(0).get("oauth2"));
    } catch (NullPointerException e) {
      return emptySet();
    }
  }

}
