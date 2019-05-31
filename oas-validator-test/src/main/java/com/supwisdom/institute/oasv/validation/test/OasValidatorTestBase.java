package com.supwisdom.institute.oasv.validation.test;

import com.supwisdom.institute.oasv.OasSpecLoader;
import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.*;
import io.swagger.v3.oas.models.OpenAPI;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public abstract class OasValidatorTestBase extends OasSpecLoader {

  @Autowired
  protected OasSpecValidator oasSpecValidator;

  final protected OasValidationContext createContext(OpenAPI openAPI) {
    OasValidationContext oasValidationContext = new OasValidationContext(openAPI);
    initContext(oasValidationContext);
    return oasValidationContext;
  }

  protected void initContext(OasValidationContext context) {
  }

  final protected OasViolation createViolation(String error, Object... path) {
    OasObjectPropertyLocation loc = OasObjectPropertyLocation.root();
    for (int i = 0; i < path.length; i = i + 2) {
      loc = loc.property((String) path[i], (OasObjectType) path[i + 1]);
    }
    return new OasViolation(loc, error);
  }

}
