package com.supwisdom.institute.oasv.diffvalidation.util;

import java.util.List;
import java.util.Objects;

public class ChangeRangeCheckUtils {

  public static boolean isNotViolated(Object left, Object right, List<Object[]> allowedList) {

    if (Objects.equals(left, right)) {
      return true;
    }
    for (Object[] objects : allowedList) {
      if (Objects.equals(objects[0], left) && Objects.equals(objects[1], right)) {
        return true;
      }
    }
    return false;

  }
}
