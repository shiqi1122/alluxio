/*
 * The Alluxio Open Foundation licenses this work under the Apache License, version 2.0
 * (the "License"). You may not use this work except in compliance with the License, which is
 * available at www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied, as more fully set forth in the License.
 *
 * See the NOTICE file distributed with this work for information regarding copyright ownership.
 */

package alluxio.stress;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import alluxio.stress.cli.StressMasterBench;
import alluxio.stress.master.MasterBenchSummary;
import alluxio.util.JsonSerializable;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * Tests {@link StressMasterBench}.
 */
public class StressMasterBenchIntegrationTest extends AbstractStressBenchIntegrationTest {
  @Test
  public void createFileAndDelete() throws Exception {
    // Only in-process will work for unit testing.
    String output = new StressMasterBench().run(new String[] {
        "--in-process",
        "--base", sLocalAlluxioClusterResource.get().getMasterURI() + "/",
        "--operation", "CreateFile",
        "--fixed-count", "20",
        "--target-throughput", "100",
        "--threads", "5",
        "--warmup", "0s", "--duration", "1s",
    });
    generateAndVerifyReport(Collections.singletonList("CreateFile"), output);

    // run again to test the deletion of the test directory
    output = new StressMasterBench().run(new String[] {
        "--in-process",
        "--base", sLocalAlluxioClusterResource.get().getMasterURI() + "/",
        "--operation", "CreateFile",
        "--fixed-count", "20",
        "--target-throughput", "100",
        "--threads", "2",
        "--warmup", "0s", "--duration", "1s",
    });

    String output2 = new StressMasterBench().run(new String[] {
        "--in-process",
        "--base", sLocalAlluxioClusterResource.get().getMasterURI() + "/",
        "--operation", "GetBlockLocations",
        "--fixed-count", "20",
        "--target-throughput", "100",
        "--threads", "5",
        "--warmup", "0s", "--duration", "1s",
    });

    String output3 = new StressMasterBench().run(new String[] {
        "--in-process",
        "--base", sLocalAlluxioClusterResource.get().getMasterURI() + "/",
        "--operation", "OpenFile",
        "--fixed-count", "20",
        "--target-throughput", "100",
        "--threads", "5",
        "--warmup", "0s", "--duration", "1s",
    });

    String output4 = new StressMasterBench().run(new String[] {
        "--in-process",
        "--base", sLocalAlluxioClusterResource.get().getMasterURI() + "/",
        "--operation", "DeleteFile",
        "--fixed-count", "20",
        "--target-throughput", "100",
        "--threads", "5",
        "--warmup", "0s", "--duration", "1s",
    });

    generateAndVerifyReport(
        Arrays.asList("CreateFile", "GetBlockLocations", "OpenFile", "DeleteFile"), output, output2,
        output3, output4);
  }

  @Test
  public void createDir() throws Exception {
    // Only in-process will work for unit testing.
    String output = new StressMasterBench().run(new String[] {
        "--in-process",
        "--base", sLocalAlluxioClusterResource.get().getMasterURI() + "/",
        "--operation", "CreateDir",
        "--fixed-count", "20",
        "--target-throughput", "100",
        "--threads", "5",
        "--warmup", "0s", "--duration", "1s",
    });
    generateAndVerifyReport(Collections.singletonList("CreateDir"), output);
  }

  @Test
  public void createFileAndListAndRename() throws Exception {
    // Only in-process will work for unit testing.
    String output1 = new StressMasterBench().run(new String[] {
        "--in-process",
        "--base", sLocalAlluxioClusterResource.get().getMasterURI() + "/",
        "--operation", "CreateFile",
        "--fixed-count", "20",
        "--target-throughput", "100",
        "--threads", "5",
        "--warmup", "0s", "--duration", "1s",
    });

    String output2 = new StressMasterBench().run(new String[] {
        "--in-process",
        "--base", sLocalAlluxioClusterResource.get().getMasterURI() + "/",
        "--operation", "GetFileStatus",
        "--fixed-count", "20",
        "--target-throughput", "100",
        "--threads", "5",
        "--warmup", "0s", "--duration", "1s",
    });

    String output3 = new StressMasterBench().run(new String[] {
        "--in-process",
        "--base", sLocalAlluxioClusterResource.get().getMasterURI() + "/",
        "--operation", "ListDir",
        "--fixed-count", "20",
        "--target-throughput", "100",
        "--threads", "5",
        "--warmup", "0s", "--duration", "1s",
    });

    String output4 = new StressMasterBench().run(new String[] {
        "--in-process",
        "--base", sLocalAlluxioClusterResource.get().getMasterURI() + "/",
        "--operation", "ListDirLocated",
        "--fixed-count", "20",
        "--target-throughput", "100",
        "--threads", "5",
        "--warmup", "0s", "--duration", "1s",
    });

    String output5 = new StressMasterBench().run(new String[] {
        "--in-process",
        "--base", sLocalAlluxioClusterResource.get().getMasterURI() + "/",
        "--operation", "RenameFile",
        "--fixed-count", "20",
        "--target-throughput", "100",
        "--threads", "5",
        "--warmup", "0s", "--duration", "1s",
    });

    generateAndVerifyReport(
        Arrays.asList("CreateFile", "GetFileStatus", "ListDir", "ListDirLocated", "RenameFile"),
        output1, output2, output3, output4, output5);
  }

  @Test
  public void writeTypeParameterTest() throws Exception {
    String[] writeType = new String[] {"MUST_CACHE", "CACHE_THROUGH", "THROUGH", "ASYNC_THROUGH"};

    for (int i = 0; i < writeType.length; i++) {
      validateTheResultWithWriteType(writeType[i]);
    }
  }

  private void validateTheResultWithWriteType(String writeType) throws Exception {
    String output1 = new StressMasterBench().run(new String[] {
        "--in-process",
        "--base", sLocalAlluxioClusterResource.get().getMasterURI() + "/",
        "--operation", "CreateFile",
        "--fixed-count", "20",
        "--target-throughput", "300",
        "--threads", "5",
        "--warmup", "0s", "--duration", "3s",
        "--write-type", writeType,
    });

    String output2 = new StressMasterBench().run(new String[] {
        "--in-process",
        "--base", sLocalAlluxioClusterResource.get().getMasterURI() + "/",
        "--operation", "DeleteFile",
        "--fixed-count", "20",
        "--target-throughput", "100",
        "--threads", "5",
        "--warmup", "0s", "--duration", "1s",
        "--write-type", writeType,
    });

    // convert the result into summary, and check whether it have errors.
    MasterBenchSummary summary1 = (MasterBenchSummary) JsonSerializable.fromJson(output1);
    MasterBenchSummary summary2 = (MasterBenchSummary) JsonSerializable.fromJson(output2);

    // confirm that the results contain information, and they don't contain errors.
    assertFalse(summary1.getNodes().isEmpty());
    assertTrue(summary1.getErrors().isEmpty());
    assertFalse(summary2.getNodes().isEmpty());
    assertTrue(summary2.getErrors().isEmpty());
  }
}
