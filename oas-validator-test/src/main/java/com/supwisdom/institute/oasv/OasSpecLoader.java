package com.supwisdom.institute.oasv;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.ParseOptions;
import io.swagger.v3.parser.core.models.SwaggerParseResult;
import io.swagger.v3.parser.util.ClasspathHelper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

public abstract class OasSpecLoader {

  /**
   * 解析绝对路径下的文件
   *
   * @param classpath
   * @return
   */
  protected final SwaggerParseResult parseAbsolute(String classpath) {

    String content = ClasspathHelper.loadFileFromClasspath(classpath);
    OpenAPIV3Parser parser = new OpenAPIV3Parser();
    return parser.readContents(content, null, createParseOptions());

  }

  protected abstract ParseOptions createParseOptions();

  /**
   * 加载绝对路径下的文件
   *
   * @param classpath
   * @return
   */
  protected final OpenAPI loadAbsolute(String classpath) {
    SwaggerParseResult parseResult = parseAbsolute(classpath);
    if (CollectionUtils.isNotEmpty(parseResult.getMessages())) {
      throw new RuntimeException(StringUtils.join(parseResult.getMessages(), ","));
    }
    return parseResult.getOpenAPI();
  }

  /**
   * 加载相对路径下的文件
   *
   * @param fileName
   * @return
   */
  protected final OpenAPI loadRelative(String fileName) {
    String basePath = getClass().getPackage().getName().replaceAll("\\.", "/");
    return loadAbsolute(basePath + "/" + fileName);
  }

}
