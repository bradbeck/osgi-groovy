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
package com.example.jowambi.client.cmd;

import java.util.HashMap;
import java.util.Map;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;

import com.example.jowambi.client.Jsoner;

@Command(scope = "jowambi", name = "json", description = "Example json fast string")
@Service
public class Json
    implements Action
{
  @Reference
  private Jsoner jsoner;

  private final Map<String, String> m = new HashMap<String, String>() {
    private static final long serialVersionUID = 1L;
    {
      put("one", "1");
      put("two", "2");
      put("three", "3");
    }
  };

  @Override
  public Object execute() throws Exception {
    return jsoner.toJson(m);
  }
}
