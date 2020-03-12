/*
 * Copyright (c) 2020-present Brad Beck All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package com.example.jowambi.client;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

import groovy.json.JsonOutput;

@Component
public class JsonerImpl
    implements Jsoner
{
  @Override
  public String toJson(Map<String, String> m) {
    return JsonOutput.toJson(m);
  }
}
