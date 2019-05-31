package com.supwisdom.institute.oasv.diffvalidation.skeleton.paths;

import com.supwisdom.institute.oasv.diffvalidation.api.*;
import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.diffvalidation.util.OasObjectDiffValidatorUtils.doDiffValidateProperty;
import static com.supwisdom.institute.oasv.common.OasObjectType.PATH_ITEM;

public class PathsPathItemsDiffValidator
  extends OasObjectDiffValidatorTemplate<Paths>
  implements PathsDiffValidator {

  private final List<PathItemDiffValidator> pathItemValidators;

  public PathsPathItemsDiffValidator(List<PathItemDiffValidator> pathItemValidators) {
    this.pathItemValidators = pathItemValidators;
  }

  @Override
  public List<OasDiffViolation> validateCompare(OasDiffValidationContext context,
    OasObjectPropertyLocation leftLocation, Paths leftOasObject,
    OasObjectPropertyLocation rightLocation, Paths rightOasObject) {

    List<OasDiffViolation> violations = new ArrayList<>();

    for (Map.Entry<String, PathItem> entry : leftOasObject.entrySet()) {
      String lPath = entry.getKey();
      PathItem lPathItem = entry.getValue();
      OasObjectPropertyLocation lPathItemLoc = leftLocation.property(lPath, PATH_ITEM);

      PathItem rPathItem = rightOasObject.get(lPath);
      if (rPathItem == null) {
        violations.addAll(doDiffValidateProperty(context, lPathItemLoc, lPathItem, null, null, pathItemValidators));
      } else {
        OasObjectPropertyLocation rPathItemLoc = rightLocation.property(lPath, PATH_ITEM);
        violations.addAll(
          doDiffValidateProperty(context, lPathItemLoc, lPathItem, rPathItemLoc, rPathItem, pathItemValidators));
      }

    }

    for (Map.Entry<String, PathItem> entry : rightOasObject.entrySet()) {
      String rPath = entry.getKey();
      if (leftOasObject.containsKey(rPath)) {
        continue;
      }
      PathItem rPathItem = entry.getValue();
      OasObjectPropertyLocation rPathItemLoc = leftLocation.property(rPath, PATH_ITEM);
      violations.addAll(doDiffValidateProperty(context, null, null, rPathItemLoc, rPathItem, pathItemValidators));
    }
    return violations;
  }

}
