/*
 * Copyright (C) 2022 Benjamin Marwell
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.bmarwell.shiro.issuer.services;

import io.github.bmarwell.shiro.issuer.dto.LoginCredentials;
import java.util.Arrays;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

@Default
@ApplicationScoped
public class CredentialsValidatorImpl implements CredentialsValidator {

  @Override
  public void validate(LoginCredentials credentials) {
    // all are ok if user == password
    if (!Arrays.equals(credentials.getUsername().toCharArray(), credentials.getPassword().toCharArray())) {
      throw new WebApplicationException("No details given", Status.UNAUTHORIZED);
    }
  }
}
