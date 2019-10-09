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

package com.newcapec.institute.oasv.diffvalidation.api;

import com.newcapec.institute.oasv.common.OasObjectPropertyLocation;

import java.util.Objects;
import java.util.StringJoiner;

public class OasDiffViolation {

  /**
   * 对象位置
   */
  private final OasObjectPropertyLocation leftLocation;

  /**
   * 对象位置
   */
  private final OasObjectPropertyLocation rightLocation;

  private final String error;

  public static OasDiffViolation onlyLeft(OasObjectPropertyLocation location, String error) {
    return new OasDiffViolation(location, null, error);
  }

  public static OasDiffViolation onlyRight(OasObjectPropertyLocation location, String error) {
    return new OasDiffViolation(null, location, error);
  }

  public OasDiffViolation(OasObjectPropertyLocation leftLocation,
    OasObjectPropertyLocation rightLocation, String error) {
    this.leftLocation = leftLocation;
    this.rightLocation = rightLocation;
    this.error = error;
  }

  public OasObjectPropertyLocation getLeftLocation() {
    return leftLocation;
  }

  public OasObjectPropertyLocation getRightLocation() {
    return rightLocation;
  }

  public String getError() {
    return error;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", OasDiffViolation.class.getSimpleName() + "[", "]")
      .add("leftLocation=" + leftLocation)
      .add("rightLocation=" + rightLocation)
      .add("error='" + error + "'")
      .toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OasDiffViolation that = (OasDiffViolation) o;
    return Objects.equals(leftLocation, that.leftLocation) &&
      Objects.equals(rightLocation, that.rightLocation) &&
      Objects.equals(error, that.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(leftLocation, rightLocation, error);
  }

  public static void main(String[] args) {
    System.out.println( "openapi: \"3.0.2\"\ninfo:\n  version: v1\n  title: Swagger Petstore\n  description: A sample API that uses a petstore as an example to demonstrate features in the OpenAPI 3.0 specification\nservers:\n  - url: https://poa.newcapec.com/apis/pet/v1\ntags:\n  - name: Pet1\n    description: pet1\n  - name: Pet2\n    description: pet2\npaths:\n  /pets:\n    get:\n      summary: Return all pets\n      description: |\n        Returns all pets from the system that the user has access to\n      operationId: findPets\n      tags:\n        - Pet1\n      security:\n        - oauth2:\n          - pet:v1:read\n      parameters:\n        - name: tags\n          in: query\n          description: tags to filter by\n          required: false\n          style: form\n          schema:\n            type: array\n            items:\n              type: string\n        - name: limit\n          in: query\n          description: maximum number of results to return\n          required: false\n          schema:\n            type: integer\n            format: int32\n        - $ref: \"#/components/parameters/Param1\"\n      responses:\n        '200':\n           $ref: \"#/components/responses/AllPetsResp\"\n        default:\n           $ref: \"#/components/responses/ErrorResp\"\n\n    post:\n      summary: Creates a new pet in the store\n      description: Creates a new pet in the store.  Duplicates are allowed\n      operationId: addPet\n      security:\n        - oauth2:\n          - pet:v1:write\n      tags:\n        - Pet2\n      requestBody:\n        $ref: \"#/components/requestBodies/NewPetRequest\"\n      responses:\n        '200':\n          $ref: \"#/components/responses/PetResp\"\n        default:\n          $ref: \"#/components/responses/ErrorResp\"\n\n  /pets/{id}:\n    get:\n      summary: Returns a user based on a single ID\n      description: Returns a user based on a single ID, if the user does not have access to the pet\n      operationId: findPetById\n      security:\n        - oauth2:\n          - pet:v1:read\n      tags:\n        - Pet1\n      parameters:\n        - name: id\n          in: path\n          description: ID of pet to fetch\n          required: true\n          schema:\n            type: integer\n            format: int64\n        - name: foo\n          in: cookie\n          description: dummy foo cookie param\n          schema:\n            type: string\n        - name: X-Pet-Bar\n          in: header\n          description: dummy bar param\n          schema:\n            type: string\n      responses:\n        '200':\n          $ref: \"#/components/responses/PetResp\"\n        default:\n          $ref: \"#/components/responses/ErrorResp\"\n\n    delete:\n      summary: deletes a single pet based on the ID supplied\n      operationId: deletePet\n      security:\n        - oauth2:\n          - pet:v1:write\n      tags:\n        - Pet2\n      parameters:\n        - name: id\n          in: path\n          description: ID of pet to delete\n          required: true\n          schema:\n            type: integer\n            format: int64\n      responses:\n        '204':\n          description: Pet deleted\n        default:\n          $ref: \"#/components/responses/ErrorResp\"\n\ncomponents:\n  \n  headers:\n    X-Pet-Id:\n      description: Pet ID\n      schema:\n        type: string\n        \n  requestBodies:\n    NewPetRequest:\n      description: Pet to add to the store\n      required: true\n      content:\n        application/json:\n          schema:\n            $ref: '#/components/schemas/NewPet'\n          encoding:\n            name:\n              contentType: application/octet-stream\n              headers:\n                X-Pet-Zoo:\n                  description: dummy pet zoo\n                  schema:\n                    type: string\n  \n  responses:\n    AllPetsResp:\n      description: pet response\n      headers:\n        X-Pet-Id:\n          $ref: \"#/components/headers/X-Pet-Id\"\n        X-Pet-Loo:\n          description: dummy pet loo\n          schema:\n            type: string\n      content:\n        application/json:\n          schema:\n            type: array\n            items:\n              $ref: '#/components/schemas/Pet'\n    ErrorResp:\n      description: unexpected error\n      content:\n        application/json:\n          schema:\n            $ref: '#/components/schemas/Error'\n            \n    PetResp:\n      description: pet response\n      content:\n        application/json:\n          schema:\n            $ref: '#/components/schemas/Pet'\n\n  schemas:\n    Pet:\n      title: Pet Object\n      allOf:\n        - $ref: '#/components/schemas/NewPet'\n        - required:\n            - id\n          properties:\n            id:\n              type: integer\n              format: int64\n\n    NewPet:\n      title: New Pet\n      required:\n        - name\n      properties:\n        name:\n          title: Pet name\n          type: string\n        tag:\n          title: Pet tag\n          type: string\n\n    Error:\n      title: Error Object\n      required:\n        - code\n        - message\n      properties:\n        code:\n          title: Error code\n          type: integer\n          format: int32\n        message:\n          title: Error message\n          type: string\n\n  parameters:\n    Param1:\n      description: param1\n      in: query\n      name: param1\n      schema:\n        type: string\n\n  securitySchemes:\n    oauth2:\n      type: oauth2\n      flows:\n        clientCredentials:\n          tokenUrl: https://poa.newcapec.com/oauth2/token\n          scopes:\n            \"pet:v1:read\": \"read pet info\"\n            \"pet:v1:write\": \"write pet info\"\n");

  }
}
