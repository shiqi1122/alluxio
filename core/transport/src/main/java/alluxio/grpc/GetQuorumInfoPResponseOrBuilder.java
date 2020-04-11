// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: grpc/journal_master.proto

package alluxio.grpc;

public interface GetQuorumInfoPResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:alluxio.grpc.journal.GetQuorumInfoPResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .alluxio.grpc.journal.JournalDomain domain = 1;</code>
   * @return Whether the domain field is set.
   */
  boolean hasDomain();
  /**
   * <code>optional .alluxio.grpc.journal.JournalDomain domain = 1;</code>
   * @return The domain.
   */
  alluxio.grpc.JournalDomain getDomain();

  /**
   * <code>repeated .alluxio.grpc.journal.QuorumServerInfo serverInfo = 2;</code>
   */
  java.util.List<alluxio.grpc.QuorumServerInfo> 
      getServerInfoList();
  /**
   * <code>repeated .alluxio.grpc.journal.QuorumServerInfo serverInfo = 2;</code>
   */
  alluxio.grpc.QuorumServerInfo getServerInfo(int index);
  /**
   * <code>repeated .alluxio.grpc.journal.QuorumServerInfo serverInfo = 2;</code>
   */
  int getServerInfoCount();
  /**
   * <code>repeated .alluxio.grpc.journal.QuorumServerInfo serverInfo = 2;</code>
   */
  java.util.List<? extends alluxio.grpc.QuorumServerInfoOrBuilder> 
      getServerInfoOrBuilderList();
  /**
   * <code>repeated .alluxio.grpc.journal.QuorumServerInfo serverInfo = 2;</code>
   */
  alluxio.grpc.QuorumServerInfoOrBuilder getServerInfoOrBuilder(
      int index);
}