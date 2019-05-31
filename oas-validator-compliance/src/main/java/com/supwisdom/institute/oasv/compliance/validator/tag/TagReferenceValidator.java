package com.supwisdom.institute.oasv.compliance.validator.tag;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.validation.api.OasValidationContext;
import com.supwisdom.institute.oasv.validation.api.OasViolation;
import com.supwisdom.institute.oasv.validation.api.TagValidator;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.tags.Tag;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

import static java.util.Collections.emptySet;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#tagObject">Tag Object</a>引用情况校验器
 * <ul>
 * <li>不得存在没有被<a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#operationObject">Operation Object</a>引用的<a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#tagObject">Tag Object</a></li>
 * </ul>
 */
public class TagReferenceValidator implements TagValidator {

  private static final String CACHE_KEY = TagReferenceValidator.class.getName() + ".allOperationsTags";

  @Override
  public List<OasViolation> validate(OasValidationContext context, OasObjectPropertyLocation location, Tag tag) {
    Set<String> allOperationsTags = getAllOperationsTags(context);

    List<OasViolation> violations = new ArrayList<>();

    if (!allOperationsTags.contains(tag.getName())) {
      violations.add(new OasViolation(location, "此Tag没有被Operation Object使用过"));
    }

    return violations;

  }

  private Set<String> getAllOperationsTags(OasValidationContext context) {

    Set<String> allTags = context.getAttribute(CACHE_KEY);
    if (allTags != null) {
      return allTags;
    }

    allTags = new HashSet<>();

    OpenAPI openAPI = context.getOpenAPI();
    Paths paths = openAPI.getPaths();
    if (paths == null) {
      return emptySet();
    }

    for (Map.Entry<String, PathItem> entry : paths.entrySet()) {
      PathItem pathItem = entry.getValue();
      List<Operation> operations = pathItem.readOperations();
      for (Operation operation : operations) {
        List<String> tags = operation.getTags();
        if (CollectionUtils.isEmpty(tags)) {
          continue;
        }
        allTags.addAll(tags);
      }
    }

    context.setAttribute(CACHE_KEY, allTags);
    return allTags;
  }
}
