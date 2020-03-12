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
package com.example.jowambi.itest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.ops4j.pax.exam.CoreOptions.maven;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.configureConsole;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.features;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.karafDistributionConfiguration;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.keepRuntimeFolder;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.options.MavenUrlReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.jowambi.client.Groover;
import com.example.jowambi.client.Jsoner;

@RunWith(PaxExam.class)
public class ClientTest
{
  private static final Logger LOG = LoggerFactory.getLogger(ClientTest.class);

  @Inject
  protected Jsoner jsoner;

  @Inject
  protected Groover groover;

  @Configuration
  public Option[] config() {
    MavenUrlReference karafUrl = maven()
        .groupId("org.apache.karaf")
        .artifactId("apache-karaf")
        .versionAsInProject()
        .type("zip");

    MavenUrlReference jowambiRepo = maven()
        .groupId("com.example.jowambi")
        .artifactId("com.example.jowambi.features")
        .versionAsInProject()
        .classifier("features")
        .type("xml");

    return new Option[] {
        karafDistributionConfiguration()
            .frameworkUrl(karafUrl)
            .unpackDirectory(new File("target", "exam"))
            .useDeployFolder(false),
        keepRuntimeFolder(),
        configureConsole().ignoreLocalConsole(),
        features(jowambiRepo, "com.example.jowambi.features")
    };
  }

  @Test
  public void testJsoner() {
    LOG.info("Testing Jsoner...");
    @SuppressWarnings("serial")
    final Map<String, String> m = new HashMap<String, String>() {{
      put("foo", "bar");
    }};
    assertThat(jsoner.toJson(m), equalTo("{\"foo\":\"bar\"}"));
  }

  @Test
  public void testGroover() {
    LOG.info("Testing Groover...");
    assertThat(groover.groove("'foo'"), equalTo("foo"));
  }
}
