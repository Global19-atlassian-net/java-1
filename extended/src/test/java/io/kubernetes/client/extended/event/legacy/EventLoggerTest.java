/*
Copyright 2021 The Kubernetes Authors.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package io.kubernetes.client.extended.event.legacy;

import static org.junit.Assert.*;

import io.kubernetes.client.custom.V1Patch;
import org.junit.Test;
import org.joda.time.DateTime;

public class EventLoggerTest {

  @Test
  public void buildEventPatch() {
    String expectedStr = "2021-03-02T15:02:48.179Z";
    DateTime expected = DateTime.parse("2021-03-02T15:02:48.179Z");
    V1Patch patch = EventLogger.buildEventPatch(1, "foo", expected);
    assertEquals(
        "{\"message\":\"foo\",\"count\":1,\"lastTimestamp\":\"" + expectedStr + "\"}",
        patch.getValue());
  }
}
