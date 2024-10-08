// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: proto/greeter.proto
// Protobuf Java Version: 4.28.2

package pb.greeter;

public final class GreeterOuterClass {
  private GreeterOuterClass() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 28,
      /* patch= */ 2,
      /* suffix= */ "",
      GreeterOuterClass.class.getName());
  }
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface NoParamOrBuilder extends
      // @@protoc_insertion_point(interface_extends:greeter.NoParam)
      com.google.protobuf.MessageOrBuilder {
  }
  /**
   * Protobuf type {@code greeter.NoParam}
   */
  public static final class NoParam extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:greeter.NoParam)
      NoParamOrBuilder {
  private static final long serialVersionUID = 0L;
    static {
      com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
        com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
        /* major= */ 4,
        /* minor= */ 28,
        /* patch= */ 2,
        /* suffix= */ "",
        NoParam.class.getName());
    }
    // Use NoParam.newBuilder() to construct.
    private NoParam(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
    }
    private NoParam() {
    }

    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return pb.greeter.GreeterOuterClass.internal_static_greeter_NoParam_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return pb.greeter.GreeterOuterClass.internal_static_greeter_NoParam_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              pb.greeter.GreeterOuterClass.NoParam.class, pb.greeter.GreeterOuterClass.NoParam.Builder.class);
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      size += getUnknownFields().getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof pb.greeter.GreeterOuterClass.NoParam)) {
        return super.equals(obj);
      }
      pb.greeter.GreeterOuterClass.NoParam other = (pb.greeter.GreeterOuterClass.NoParam) obj;

      if (!getUnknownFields().equals(other.getUnknownFields())) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static pb.greeter.GreeterOuterClass.NoParam parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static pb.greeter.GreeterOuterClass.NoParam parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static pb.greeter.GreeterOuterClass.NoParam parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static pb.greeter.GreeterOuterClass.NoParam parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static pb.greeter.GreeterOuterClass.NoParam parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static pb.greeter.GreeterOuterClass.NoParam parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static pb.greeter.GreeterOuterClass.NoParam parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input);
    }
    public static pb.greeter.GreeterOuterClass.NoParam parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static pb.greeter.GreeterOuterClass.NoParam parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseDelimitedWithIOException(PARSER, input);
    }

    public static pb.greeter.GreeterOuterClass.NoParam parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static pb.greeter.GreeterOuterClass.NoParam parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input);
    }
    public static pb.greeter.GreeterOuterClass.NoParam parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(pb.greeter.GreeterOuterClass.NoParam prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code greeter.NoParam}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:greeter.NoParam)
        pb.greeter.GreeterOuterClass.NoParamOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return pb.greeter.GreeterOuterClass.internal_static_greeter_NoParam_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return pb.greeter.GreeterOuterClass.internal_static_greeter_NoParam_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                pb.greeter.GreeterOuterClass.NoParam.class, pb.greeter.GreeterOuterClass.NoParam.Builder.class);
      }

      // Construct using pb.greeter.GreeterOuterClass.NoParam.newBuilder()
      private Builder() {

      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);

      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return pb.greeter.GreeterOuterClass.internal_static_greeter_NoParam_descriptor;
      }

      @java.lang.Override
      public pb.greeter.GreeterOuterClass.NoParam getDefaultInstanceForType() {
        return pb.greeter.GreeterOuterClass.NoParam.getDefaultInstance();
      }

      @java.lang.Override
      public pb.greeter.GreeterOuterClass.NoParam build() {
        pb.greeter.GreeterOuterClass.NoParam result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public pb.greeter.GreeterOuterClass.NoParam buildPartial() {
        pb.greeter.GreeterOuterClass.NoParam result = new pb.greeter.GreeterOuterClass.NoParam(this);
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof pb.greeter.GreeterOuterClass.NoParam) {
          return mergeFrom((pb.greeter.GreeterOuterClass.NoParam)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(pb.greeter.GreeterOuterClass.NoParam other) {
        if (other == pb.greeter.GreeterOuterClass.NoParam.getDefaultInstance()) return this;
        this.mergeUnknownFields(other.getUnknownFields());
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        if (extensionRegistry == null) {
          throw new java.lang.NullPointerException();
        }
        try {
          boolean done = false;
          while (!done) {
            int tag = input.readTag();
            switch (tag) {
              case 0:
                done = true;
                break;
              default: {
                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                  done = true; // was an endgroup tag
                }
                break;
              } // default:
            } // switch (tag)
          } // while (!done)
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.unwrapIOException();
        } finally {
          onChanged();
        } // finally
        return this;
      }

      // @@protoc_insertion_point(builder_scope:greeter.NoParam)
    }

    // @@protoc_insertion_point(class_scope:greeter.NoParam)
    private static final pb.greeter.GreeterOuterClass.NoParam DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new pb.greeter.GreeterOuterClass.NoParam();
    }

    public static pb.greeter.GreeterOuterClass.NoParam getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<NoParam>
        PARSER = new com.google.protobuf.AbstractParser<NoParam>() {
      @java.lang.Override
      public NoParam parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        Builder builder = newBuilder();
        try {
          builder.mergeFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.setUnfinishedMessage(builder.buildPartial());
        } catch (com.google.protobuf.UninitializedMessageException e) {
          throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
        } catch (java.io.IOException e) {
          throw new com.google.protobuf.InvalidProtocolBufferException(e)
              .setUnfinishedMessage(builder.buildPartial());
        }
        return builder.buildPartial();
      }
    };

    public static com.google.protobuf.Parser<NoParam> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<NoParam> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public pb.greeter.GreeterOuterClass.NoParam getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface HelloResponseOrBuilder extends
      // @@protoc_insertion_point(interface_extends:greeter.HelloResponse)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string message = 1;</code>
     * @return The message.
     */
    java.lang.String getMessage();
    /**
     * <code>string message = 1;</code>
     * @return The bytes for message.
     */
    com.google.protobuf.ByteString
        getMessageBytes();
  }
  /**
   * Protobuf type {@code greeter.HelloResponse}
   */
  public static final class HelloResponse extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:greeter.HelloResponse)
      HelloResponseOrBuilder {
  private static final long serialVersionUID = 0L;
    static {
      com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
        com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
        /* major= */ 4,
        /* minor= */ 28,
        /* patch= */ 2,
        /* suffix= */ "",
        HelloResponse.class.getName());
    }
    // Use HelloResponse.newBuilder() to construct.
    private HelloResponse(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
    }
    private HelloResponse() {
      message_ = "";
    }

    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return pb.greeter.GreeterOuterClass.internal_static_greeter_HelloResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return pb.greeter.GreeterOuterClass.internal_static_greeter_HelloResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              pb.greeter.GreeterOuterClass.HelloResponse.class, pb.greeter.GreeterOuterClass.HelloResponse.Builder.class);
    }

    public static final int MESSAGE_FIELD_NUMBER = 1;
    @SuppressWarnings("serial")
    private volatile java.lang.Object message_ = "";
    /**
     * <code>string message = 1;</code>
     * @return The message.
     */
    @java.lang.Override
    public java.lang.String getMessage() {
      java.lang.Object ref = message_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        message_ = s;
        return s;
      }
    }
    /**
     * <code>string message = 1;</code>
     * @return The bytes for message.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getMessageBytes() {
      java.lang.Object ref = message_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        message_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!com.google.protobuf.GeneratedMessage.isStringEmpty(message_)) {
        com.google.protobuf.GeneratedMessage.writeString(output, 1, message_);
      }
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!com.google.protobuf.GeneratedMessage.isStringEmpty(message_)) {
        size += com.google.protobuf.GeneratedMessage.computeStringSize(1, message_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof pb.greeter.GreeterOuterClass.HelloResponse)) {
        return super.equals(obj);
      }
      pb.greeter.GreeterOuterClass.HelloResponse other = (pb.greeter.GreeterOuterClass.HelloResponse) obj;

      if (!getMessage()
          .equals(other.getMessage())) return false;
      if (!getUnknownFields().equals(other.getUnknownFields())) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
      hash = (53 * hash) + getMessage().hashCode();
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static pb.greeter.GreeterOuterClass.HelloResponse parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static pb.greeter.GreeterOuterClass.HelloResponse parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static pb.greeter.GreeterOuterClass.HelloResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static pb.greeter.GreeterOuterClass.HelloResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static pb.greeter.GreeterOuterClass.HelloResponse parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static pb.greeter.GreeterOuterClass.HelloResponse parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static pb.greeter.GreeterOuterClass.HelloResponse parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input);
    }
    public static pb.greeter.GreeterOuterClass.HelloResponse parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static pb.greeter.GreeterOuterClass.HelloResponse parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseDelimitedWithIOException(PARSER, input);
    }

    public static pb.greeter.GreeterOuterClass.HelloResponse parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static pb.greeter.GreeterOuterClass.HelloResponse parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input);
    }
    public static pb.greeter.GreeterOuterClass.HelloResponse parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(pb.greeter.GreeterOuterClass.HelloResponse prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code greeter.HelloResponse}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:greeter.HelloResponse)
        pb.greeter.GreeterOuterClass.HelloResponseOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return pb.greeter.GreeterOuterClass.internal_static_greeter_HelloResponse_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return pb.greeter.GreeterOuterClass.internal_static_greeter_HelloResponse_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                pb.greeter.GreeterOuterClass.HelloResponse.class, pb.greeter.GreeterOuterClass.HelloResponse.Builder.class);
      }

      // Construct using pb.greeter.GreeterOuterClass.HelloResponse.newBuilder()
      private Builder() {

      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);

      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        bitField0_ = 0;
        message_ = "";
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return pb.greeter.GreeterOuterClass.internal_static_greeter_HelloResponse_descriptor;
      }

      @java.lang.Override
      public pb.greeter.GreeterOuterClass.HelloResponse getDefaultInstanceForType() {
        return pb.greeter.GreeterOuterClass.HelloResponse.getDefaultInstance();
      }

      @java.lang.Override
      public pb.greeter.GreeterOuterClass.HelloResponse build() {
        pb.greeter.GreeterOuterClass.HelloResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public pb.greeter.GreeterOuterClass.HelloResponse buildPartial() {
        pb.greeter.GreeterOuterClass.HelloResponse result = new pb.greeter.GreeterOuterClass.HelloResponse(this);
        if (bitField0_ != 0) { buildPartial0(result); }
        onBuilt();
        return result;
      }

      private void buildPartial0(pb.greeter.GreeterOuterClass.HelloResponse result) {
        int from_bitField0_ = bitField0_;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          result.message_ = message_;
        }
      }

      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof pb.greeter.GreeterOuterClass.HelloResponse) {
          return mergeFrom((pb.greeter.GreeterOuterClass.HelloResponse)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(pb.greeter.GreeterOuterClass.HelloResponse other) {
        if (other == pb.greeter.GreeterOuterClass.HelloResponse.getDefaultInstance()) return this;
        if (!other.getMessage().isEmpty()) {
          message_ = other.message_;
          bitField0_ |= 0x00000001;
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        if (extensionRegistry == null) {
          throw new java.lang.NullPointerException();
        }
        try {
          boolean done = false;
          while (!done) {
            int tag = input.readTag();
            switch (tag) {
              case 0:
                done = true;
                break;
              case 10: {
                message_ = input.readStringRequireUtf8();
                bitField0_ |= 0x00000001;
                break;
              } // case 10
              default: {
                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                  done = true; // was an endgroup tag
                }
                break;
              } // default:
            } // switch (tag)
          } // while (!done)
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.unwrapIOException();
        } finally {
          onChanged();
        } // finally
        return this;
      }
      private int bitField0_;

      private java.lang.Object message_ = "";
      /**
       * <code>string message = 1;</code>
       * @return The message.
       */
      public java.lang.String getMessage() {
        java.lang.Object ref = message_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          message_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string message = 1;</code>
       * @return The bytes for message.
       */
      public com.google.protobuf.ByteString
          getMessageBytes() {
        java.lang.Object ref = message_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          message_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string message = 1;</code>
       * @param value The message to set.
       * @return This builder for chaining.
       */
      public Builder setMessage(
          java.lang.String value) {
        if (value == null) { throw new NullPointerException(); }
        message_ = value;
        bitField0_ |= 0x00000001;
        onChanged();
        return this;
      }
      /**
       * <code>string message = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearMessage() {
        message_ = getDefaultInstance().getMessage();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
        return this;
      }
      /**
       * <code>string message = 1;</code>
       * @param value The bytes for message to set.
       * @return This builder for chaining.
       */
      public Builder setMessageBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) { throw new NullPointerException(); }
        checkByteStringIsUtf8(value);
        message_ = value;
        bitField0_ |= 0x00000001;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:greeter.HelloResponse)
    }

    // @@protoc_insertion_point(class_scope:greeter.HelloResponse)
    private static final pb.greeter.GreeterOuterClass.HelloResponse DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new pb.greeter.GreeterOuterClass.HelloResponse();
    }

    public static pb.greeter.GreeterOuterClass.HelloResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<HelloResponse>
        PARSER = new com.google.protobuf.AbstractParser<HelloResponse>() {
      @java.lang.Override
      public HelloResponse parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        Builder builder = newBuilder();
        try {
          builder.mergeFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.setUnfinishedMessage(builder.buildPartial());
        } catch (com.google.protobuf.UninitializedMessageException e) {
          throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
        } catch (java.io.IOException e) {
          throw new com.google.protobuf.InvalidProtocolBufferException(e)
              .setUnfinishedMessage(builder.buildPartial());
        }
        return builder.buildPartial();
      }
    };

    public static com.google.protobuf.Parser<HelloResponse> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<HelloResponse> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public pb.greeter.GreeterOuterClass.HelloResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_greeter_NoParam_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_greeter_NoParam_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_greeter_HelloResponse_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_greeter_HelloResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023proto/greeter.proto\022\007greeter\"\t\n\007NoPara" +
      "m\" \n\rHelloResponse\022\017\n\007message\030\001 \001(\t2A\n\007G" +
      "reeter\0226\n\010SayHello\022\020.greeter.NoParam\032\026.g" +
      "reeter.HelloResponse\"\000B\032\n\npb.greeterZ\014./" +
      "pb/greeterb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_greeter_NoParam_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_greeter_NoParam_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_greeter_NoParam_descriptor,
        new java.lang.String[] { });
    internal_static_greeter_HelloResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_greeter_HelloResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_greeter_HelloResponse_descriptor,
        new java.lang.String[] { "Message", });
    descriptor.resolveAllFeaturesImmutable();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
