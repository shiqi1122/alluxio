// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: grpc/file_system_master.proto

package alluxio.grpc;

public interface ListStatusPOptionsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:alluxio.grpc.file.ListStatusPOptions)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * This is deprecated since 1.1.1 and will be removed in 2.0. Use loadMetadataType.
   * </pre>
   *
   * <code>optional bool loadDirectChildren = 1;</code>
   * @return Whether the loadDirectChildren field is set.
   */
  boolean hasLoadDirectChildren();
  /**
   * <pre>
   * This is deprecated since 1.1.1 and will be removed in 2.0. Use loadMetadataType.
   * </pre>
   *
   * <code>optional bool loadDirectChildren = 1;</code>
   * @return The loadDirectChildren.
   */
  boolean getLoadDirectChildren();

  /**
   * <code>optional .alluxio.grpc.file.LoadMetadataPType loadMetadataType = 2;</code>
   * @return Whether the loadMetadataType field is set.
   */
  boolean hasLoadMetadataType();
  /**
   * <code>optional .alluxio.grpc.file.LoadMetadataPType loadMetadataType = 2;</code>
   * @return The loadMetadataType.
   */
  alluxio.grpc.LoadMetadataPType getLoadMetadataType();

  /**
   * <code>optional .alluxio.grpc.file.FileSystemMasterCommonPOptions commonOptions = 3;</code>
   * @return Whether the commonOptions field is set.
   */
  boolean hasCommonOptions();
  /**
   * <code>optional .alluxio.grpc.file.FileSystemMasterCommonPOptions commonOptions = 3;</code>
   * @return The commonOptions.
   */
  alluxio.grpc.FileSystemMasterCommonPOptions getCommonOptions();
  /**
   * <code>optional .alluxio.grpc.file.FileSystemMasterCommonPOptions commonOptions = 3;</code>
   */
  alluxio.grpc.FileSystemMasterCommonPOptionsOrBuilder getCommonOptionsOrBuilder();

  /**
   * <code>optional bool recursive = 4;</code>
   * @return Whether the recursive field is set.
   */
  boolean hasRecursive();
  /**
   * <code>optional bool recursive = 4;</code>
   * @return The recursive.
   */
  boolean getRecursive();
}