package com.supwisdom.institute.oasv.diffvalidation.api;

public abstract class DiffViolationMessages {

  public static final String OP_DEL_FORBIDDEN = "不允许在新版本中删除";
  public static final String OP_ADD_FORBIDDEN = "不允许在新版本中添加";

  public static final String NEW_NOT_EQ_OLD = "新旧值不一致";
  public static final String NEW_NOT_GTE_OLD = "新值必须>=旧值";
  public static final String NEW_NOT_LTE_OLD = "新值必须<=旧值";

}
