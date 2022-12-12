package Yahtzee.service;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */

public final class serveClientGrpc {

  private serveClientGrpc() {
  }

  public static final String SERVICE_NAME = "Yahtzee.serveClient";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Yahtzee.service.Client.User, Yahtzee.service.Client.Username> getCreateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/'
      + "createUser", requestType = Yahtzee.service.Client.User.class, responseType = Yahtzee.service.Client.Username.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Yahtzee.service.Client.User, Yahtzee.service.Client.Username> getCreateUserMethod() {
    io.grpc.MethodDescriptor<Yahtzee.service.Client.User, Yahtzee.service.Client.Username> getCreateUserMethod;
    if ((getCreateUserMethod = serveClientGrpc.getCreateUserMethod) == null) {
      synchronized (serveClientGrpc.class) {
        if ((getCreateUserMethod = serveClientGrpc.getCreateUserMethod) == null) {
          serveClientGrpc.getCreateUserMethod = getCreateUserMethod = io.grpc.MethodDescriptor.<Yahtzee.service.Client.User, Yahtzee.service.Client.Username>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createUser")).setSampledToLocalTracing(true)
              .setRequestMarshaller(
                  io.grpc.protobuf.ProtoUtils.marshaller(Yahtzee.service.Client.User.getDefaultInstance()))
              .setResponseMarshaller(
                  io.grpc.protobuf.ProtoUtils.marshaller(Yahtzee.service.Client.Username.getDefaultInstance()))
              .setSchemaDescriptor(new serveClientMethodDescriptorSupplier("createUser")).build();
        }
      }
    }
    return getCreateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Yahtzee.service.Client.Password, Yahtzee.service.Client.Valid> getSetPasswordMethod;

  @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/'
      + "setPassword", requestType = Yahtzee.service.Client.Password.class, responseType = Yahtzee.service.Client.Valid.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Yahtzee.service.Client.Password, Yahtzee.service.Client.Valid> getSetPasswordMethod() {
    io.grpc.MethodDescriptor<Yahtzee.service.Client.Password, Yahtzee.service.Client.Valid> getSetPasswordMethod;
    if ((getSetPasswordMethod = serveClientGrpc.getSetPasswordMethod) == null) {
      synchronized (serveClientGrpc.class) {
        if ((getSetPasswordMethod = serveClientGrpc.getSetPasswordMethod) == null) {
          serveClientGrpc.getSetPasswordMethod = getSetPasswordMethod = io.grpc.MethodDescriptor.<Yahtzee.service.Client.Password, Yahtzee.service.Client.Valid>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setPassword")).setSampledToLocalTracing(true)
              .setRequestMarshaller(
                  io.grpc.protobuf.ProtoUtils.marshaller(Yahtzee.service.Client.Password.getDefaultInstance()))
              .setResponseMarshaller(
                  io.grpc.protobuf.ProtoUtils.marshaller(Yahtzee.service.Client.Valid.getDefaultInstance()))
              .setSchemaDescriptor(new serveClientMethodDescriptorSupplier("setPassword")).build();
        }
      }
    }
    return getSetPasswordMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Yahtzee.service.Client.Password, Yahtzee.service.Client.Valid> getVerifyPasswordMethod;

  @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/'
      + "verifyPassword", requestType = Yahtzee.service.Client.Password.class, responseType = Yahtzee.service.Client.Valid.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Yahtzee.service.Client.Password, Yahtzee.service.Client.Valid> getVerifyPasswordMethod() {
    io.grpc.MethodDescriptor<Yahtzee.service.Client.Password, Yahtzee.service.Client.Valid> getVerifyPasswordMethod;
    if ((getVerifyPasswordMethod = serveClientGrpc.getVerifyPasswordMethod) == null) {
      synchronized (serveClientGrpc.class) {
        if ((getVerifyPasswordMethod = serveClientGrpc.getVerifyPasswordMethod) == null) {
          serveClientGrpc.getVerifyPasswordMethod = getVerifyPasswordMethod = io.grpc.MethodDescriptor.<Yahtzee.service.Client.Password, Yahtzee.service.Client.Valid>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "verifyPassword")).setSampledToLocalTracing(true)
              .setRequestMarshaller(
                  io.grpc.protobuf.ProtoUtils.marshaller(Yahtzee.service.Client.Password.getDefaultInstance()))
              .setResponseMarshaller(
                  io.grpc.protobuf.ProtoUtils.marshaller(Yahtzee.service.Client.Valid.getDefaultInstance()))
              .setSchemaDescriptor(new serveClientMethodDescriptorSupplier("verifyPassword")).build();
        }
      }
    }
    return getVerifyPasswordMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Yahtzee.service.Client.Username, Yahtzee.service.Client.Score> getGetScoreMethod;

  @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/'
      + "getScore", requestType = Yahtzee.service.Client.Username.class, responseType = Yahtzee.service.Client.Score.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Yahtzee.service.Client.Username, Yahtzee.service.Client.Score> getGetScoreMethod() {
    io.grpc.MethodDescriptor<Yahtzee.service.Client.Username, Yahtzee.service.Client.Score> getGetScoreMethod;
    if ((getGetScoreMethod = serveClientGrpc.getGetScoreMethod) == null) {
      synchronized (serveClientGrpc.class) {
        if ((getGetScoreMethod = serveClientGrpc.getGetScoreMethod) == null) {
          serveClientGrpc.getGetScoreMethod = getGetScoreMethod = io.grpc.MethodDescriptor.<Yahtzee.service.Client.Username, Yahtzee.service.Client.Score>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getScore")).setSampledToLocalTracing(true)
              .setRequestMarshaller(
                  io.grpc.protobuf.ProtoUtils.marshaller(Yahtzee.service.Client.Username.getDefaultInstance()))
              .setResponseMarshaller(
                  io.grpc.protobuf.ProtoUtils.marshaller(Yahtzee.service.Client.Score.getDefaultInstance()))
              .setSchemaDescriptor(new serveClientMethodDescriptorSupplier("getScore")).build();
        }
      }
    }
    return getGetScoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Yahtzee.service.Client.Score, Yahtzee.service.Client.Username> getSetLastScoreMethod;

  @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/'
      + "setLastScore", requestType = Yahtzee.service.Client.Score.class, responseType = Yahtzee.service.Client.Username.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Yahtzee.service.Client.Score, Yahtzee.service.Client.Username> getSetLastScoreMethod() {
    io.grpc.MethodDescriptor<Yahtzee.service.Client.Score, Yahtzee.service.Client.Username> getSetLastScoreMethod;
    if ((getSetLastScoreMethod = serveClientGrpc.getSetLastScoreMethod) == null) {
      synchronized (serveClientGrpc.class) {
        if ((getSetLastScoreMethod = serveClientGrpc.getSetLastScoreMethod) == null) {
          serveClientGrpc.getSetLastScoreMethod = getSetLastScoreMethod = io.grpc.MethodDescriptor.<Yahtzee.service.Client.Score, Yahtzee.service.Client.Username>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setLastScore")).setSampledToLocalTracing(true)
              .setRequestMarshaller(
                  io.grpc.protobuf.ProtoUtils.marshaller(Yahtzee.service.Client.Score.getDefaultInstance()))
              .setResponseMarshaller(
                  io.grpc.protobuf.ProtoUtils.marshaller(Yahtzee.service.Client.Username.getDefaultInstance()))
              .setSchemaDescriptor(new serveClientMethodDescriptorSupplier("setLastScore")).build();
        }
      }
    }
    return getSetLastScoreMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static serveClientStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serveClientStub> factory = new io.grpc.stub.AbstractStub.StubFactory<serveClientStub>() {
      @java.lang.Override
      public serveClientStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
        return new serveClientStub(channel, callOptions);
      }
    };
    return serveClientStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output
   * calls on the service
   */
  public static serveClientBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serveClientBlockingStub> factory = new io.grpc.stub.AbstractStub.StubFactory<serveClientBlockingStub>() {
      @java.lang.Override
      public serveClientBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
        return new serveClientBlockingStub(channel, callOptions);
      }
    };
    return serveClientBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the
   * service
   */
  public static serveClientFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serveClientFutureStub> factory = new io.grpc.stub.AbstractStub.StubFactory<serveClientFutureStub>() {
      @java.lang.Override
      public serveClientFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
        return new serveClientFutureStub(channel, callOptions);
      }
    };
    return serveClientFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class serveClientImplBase implements io.grpc.BindableService {

    /**
     */
    public void createUser(Yahtzee.service.Client.User request,
        io.grpc.stub.StreamObserver<Yahtzee.service.Client.Username> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateUserMethod(), responseObserver);
    }

    /**
     */
    public void setPassword(Yahtzee.service.Client.Password request,
        io.grpc.stub.StreamObserver<Yahtzee.service.Client.Valid> responseObserver) {
      asyncUnimplementedUnaryCall(getSetPasswordMethod(), responseObserver);
    }

    /**
     */
    public void verifyPassword(Yahtzee.service.Client.Password request,
        io.grpc.stub.StreamObserver<Yahtzee.service.Client.Valid> responseObserver) {
      asyncUnimplementedUnaryCall(getVerifyPasswordMethod(), responseObserver);
    }

    /**
     */
    public void getScore(Yahtzee.service.Client.Username request,
        io.grpc.stub.StreamObserver<Yahtzee.service.Client.Score> responseObserver) {
      asyncUnimplementedUnaryCall(getGetScoreMethod(), responseObserver);
    }

    /**
     */
    public void setLastScore(Yahtzee.service.Client.Score request,
        io.grpc.stub.StreamObserver<Yahtzee.service.Client.Username> responseObserver) {
      asyncUnimplementedUnaryCall(getSetLastScoreMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(getCreateUserMethod(),
              asyncUnaryCall(new MethodHandlers<Yahtzee.service.Client.User, Yahtzee.service.Client.Username>(this,
                  METHODID_CREATE_USER)))
          .addMethod(getSetPasswordMethod(),
              asyncUnaryCall(new MethodHandlers<Yahtzee.service.Client.Password, Yahtzee.service.Client.Valid>(this,
                  METHODID_SET_PASSWORD)))
          .addMethod(getVerifyPasswordMethod(),
              asyncUnaryCall(new MethodHandlers<Yahtzee.service.Client.Password, Yahtzee.service.Client.Valid>(this,
                  METHODID_VERIFY_PASSWORD)))
          .addMethod(getGetScoreMethod(),
              asyncUnaryCall(new MethodHandlers<Yahtzee.service.Client.Username, Yahtzee.service.Client.Score>(this,
                  METHODID_GET_SCORE)))
          .addMethod(getSetLastScoreMethod(),
              asyncUnaryCall(new MethodHandlers<Yahtzee.service.Client.Score, Yahtzee.service.Client.Username>(this,
                  METHODID_SET_LAST_SCORE)))
          .build();
    }
  }

  /**
   */
  public static final class serveClientStub extends io.grpc.stub.AbstractAsyncStub<serveClientStub> {
    private serveClientStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serveClientStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serveClientStub(channel, callOptions);
    }

    /**
     */
    public void createUser(Yahtzee.service.Client.User request,
        io.grpc.stub.StreamObserver<Yahtzee.service.Client.Username> responseObserver) {
      asyncUnaryCall(getChannel().newCall(getCreateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setPassword(Yahtzee.service.Client.Password request,
        io.grpc.stub.StreamObserver<Yahtzee.service.Client.Valid> responseObserver) {
      asyncUnaryCall(getChannel().newCall(getSetPasswordMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void verifyPassword(Yahtzee.service.Client.Password request,
        io.grpc.stub.StreamObserver<Yahtzee.service.Client.Valid> responseObserver) {
      asyncUnaryCall(getChannel().newCall(getVerifyPasswordMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getScore(Yahtzee.service.Client.Username request,
        io.grpc.stub.StreamObserver<Yahtzee.service.Client.Score> responseObserver) {
      asyncUnaryCall(getChannel().newCall(getGetScoreMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setLastScore(Yahtzee.service.Client.Score request,
        io.grpc.stub.StreamObserver<Yahtzee.service.Client.Username> responseObserver) {
      asyncUnaryCall(getChannel().newCall(getSetLastScoreMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class serveClientBlockingStub extends io.grpc.stub.AbstractBlockingStub<serveClientBlockingStub> {
    private serveClientBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serveClientBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serveClientBlockingStub(channel, callOptions);
    }

    /**
     */
    public Yahtzee.service.Client.Username createUser(Yahtzee.service.Client.User request) {
      return blockingUnaryCall(getChannel(), getCreateUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public Yahtzee.service.Client.Valid setPassword(Yahtzee.service.Client.Password request) {
      return blockingUnaryCall(getChannel(), getSetPasswordMethod(), getCallOptions(), request);
    }

    /**
     */
    public Yahtzee.service.Client.Valid verifyPassword(Yahtzee.service.Client.Password request) {
      return blockingUnaryCall(getChannel(), getVerifyPasswordMethod(), getCallOptions(), request);
    }

    /**
     */
    public Yahtzee.service.Client.Score getScore(Yahtzee.service.Client.Username request) {
      return blockingUnaryCall(getChannel(), getGetScoreMethod(), getCallOptions(), request);
    }

    /**
     */
    public Yahtzee.service.Client.Username setLastScore(Yahtzee.service.Client.Score request) {
      return blockingUnaryCall(getChannel(), getSetLastScoreMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class serveClientFutureStub extends io.grpc.stub.AbstractFutureStub<serveClientFutureStub> {
    private serveClientFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serveClientFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serveClientFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Yahtzee.service.Client.Username> createUser(
        Yahtzee.service.Client.User request) {
      return futureUnaryCall(getChannel().newCall(getCreateUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Yahtzee.service.Client.Valid> setPassword(
        Yahtzee.service.Client.Password request) {
      return futureUnaryCall(getChannel().newCall(getSetPasswordMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Yahtzee.service.Client.Valid> verifyPassword(
        Yahtzee.service.Client.Password request) {
      return futureUnaryCall(getChannel().newCall(getVerifyPasswordMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Yahtzee.service.Client.Score> getScore(
        Yahtzee.service.Client.Username request) {
      return futureUnaryCall(getChannel().newCall(getGetScoreMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Yahtzee.service.Client.Username> setLastScore(
        Yahtzee.service.Client.Score request) {
      return futureUnaryCall(getChannel().newCall(getSetLastScoreMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_USER = 0;
  private static final int METHODID_SET_PASSWORD = 1;
  private static final int METHODID_VERIFY_PASSWORD = 2;
  private static final int METHODID_GET_SCORE = 3;
  private static final int METHODID_SET_LAST_SCORE = 4;

  private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final serveClientImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(serveClientImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_USER:
          serviceImpl.createUser((Yahtzee.service.Client.User) request,
              (io.grpc.stub.StreamObserver<Yahtzee.service.Client.Username>) responseObserver);
          break;
        case METHODID_SET_PASSWORD:
          serviceImpl.setPassword((Yahtzee.service.Client.Password) request,
              (io.grpc.stub.StreamObserver<Yahtzee.service.Client.Valid>) responseObserver);
          break;
        case METHODID_VERIFY_PASSWORD:
          serviceImpl.verifyPassword((Yahtzee.service.Client.Password) request,
              (io.grpc.stub.StreamObserver<Yahtzee.service.Client.Valid>) responseObserver);
          break;
        case METHODID_GET_SCORE:
          serviceImpl.getScore((Yahtzee.service.Client.Username) request,
              (io.grpc.stub.StreamObserver<Yahtzee.service.Client.Score>) responseObserver);
          break;
        case METHODID_SET_LAST_SCORE:
          serviceImpl.setLastScore((Yahtzee.service.Client.Score) request,
              (io.grpc.stub.StreamObserver<Yahtzee.service.Client.Username>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class serveClientBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    serveClientBaseDescriptorSupplier() {
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Yahtzee.service.Client.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("serveClient");
    }
  }

  private static final class serveClientFileDescriptorSupplier extends serveClientBaseDescriptorSupplier {
    serveClientFileDescriptorSupplier() {
    }
  }

  private static final class serveClientMethodDescriptorSupplier extends serveClientBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    serveClientMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (serveClientGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new serveClientFileDescriptorSupplier()).addMethod(getCreateUserMethod())
              .addMethod(getSetPasswordMethod()).addMethod(getVerifyPasswordMethod()).addMethod(getGetScoreMethod())
              .addMethod(getSetLastScoreMethod()).build();
        }
      }
    }
    return result;
  }
}
