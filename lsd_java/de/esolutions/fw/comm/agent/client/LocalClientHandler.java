/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.client;

import de.esolutions.fw.comm.agent.client.IClientHandler;
import de.esolutions.fw.comm.agent.client.ProxyStubPools;
import de.esolutions.fw.comm.agent.client.StubOrError;
import de.esolutions.fw.comm.agent.diag.info.ClientInfo;
import de.esolutions.fw.comm.agent.service.Stub;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.comm.core.IProxyConnector;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.message.ICallMethodSerializeCallback;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.IStreamDeserializer;
import de.esolutions.fw.util.serializer.adapter.DefaultExtendedDeserializer;
import de.esolutions.fw.util.serializer.adapter.DefaultExtendedSerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import de.esolutions.fw.util.serializer.stream.BEDefaultDeserializer;
import de.esolutions.fw.util.serializer.stream.BEDefaultSerializer;
import de.esolutions.fw.util.transport.buffer.TransportBuffer;

public class LocalClientHandler
implements IClientHandler {
    protected short myAgentID;
    protected short myAgentEpoch;
    protected ProxyStubPools proxyStubPools;
    private IProxyConnector connector;
    private final ITimeSource monoTime;
    private long lastConnectTimeStamp;
    private long lastDisconnectTimeStamp;

    public LocalClientHandler(short s, short s2, ProxyStubPools proxyStubPools, IProxyConnector iProxyConnector, ITimeSource iTimeSource) {
        this.myAgentID = s;
        this.myAgentEpoch = s2;
        this.proxyStubPools = proxyStubPools;
        this.connector = iProxyConnector;
        this.monoTime = iTimeSource;
        CommAgentTracing.CLIENT.log((short)1, "create local handler");
        this.lastConnectTimeStamp = iTimeSource.getCurrentTime();
    }

    @Override
    public short getPeerAgentID() {
        return this.myAgentID;
    }

    @Override
    public byte getProtocolVersion() {
        return 0;
    }

    @Override
    public short getPeerAgentEpoch() {
        return this.myAgentEpoch;
    }

    @Override
    public short getMyAssignedAgentID() {
        return this.myAgentID;
    }

    @Override
    public short getMyAssignedAgentEpoch() {
        return this.myAgentEpoch;
    }

    @Override
    public ServiceInstanceID getBrokerServiceInstanceID() {
        return null;
    }

    @Override
    public void shutdown() {
        CommAgentTracing.CLIENT.log((short)1, "shutdown local handler");
        this.lastDisconnectTimeStamp = this.monoTime.getCurrentTime();
    }

    @Override
    public boolean isConnected() {
        return true;
    }

    @Override
    public boolean isDeadOrError() {
        return false;
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public boolean connectProxy(Proxy proxy) {
        CommAgentTracing.CLIENT.log((short)1, "< local: connectProxy");
        short s = this.proxyStubPools.addProxy(proxy, this);
        if (s == -1) {
            proxy.getLifecycle().setError(5);
            return false;
        }
        StubOrError stubOrError = this.proxyStubPools.createStub(proxy.getInstanceID(), this, s, this.myAgentID);
        if (stubOrError.hasError()) {
            this.proxyStubPools.makeProxyFailed(s, (byte)stubOrError.getError());
            return false;
        }
        Stub stub = stubOrError.getStub();
        stub.goLive();
        short s2 = stub.getStubID();
        IProxyFrontend iProxyFrontend = null;
        Proxy proxy2 = null;
        Stub stub2 = null;
        IReplyService iReplyService = proxy.getReplyService();
        if (iReplyService != null) {
            ServiceInstanceID serviceInstanceID = iReplyService.getInstanceID();
            CommAgentTracing.CLIENT.log((short)1, "local: setting up reply proxy: instance=%1", serviceInstanceID);
            iProxyFrontend = stub.getServiceHandler().getService().createReplyProxy();
            if (iProxyFrontend == null || iProxyFrontend.getProxy() == null) {
                CommAgentTracing.CLIENT.log((short)4, "local: can't create reply proxy for instance=%1", serviceInstanceID);
                this.proxyStubPools.makeProxyFailed(s, (byte)6);
                this.proxyStubPools.removeStub(s2);
                return false;
            }
            proxy2 = iProxyFrontend.getProxy();
            proxy2.getInstanceID().setHandle(serviceInstanceID.getHandle());
            short s3 = proxy2.getProxyID();
            this.proxyStubPools.addProxy(proxy2, this);
            StubOrError stubOrError2 = this.proxyStubPools.createStub(serviceInstanceID, this, s3, this.myAgentID);
            if (stubOrError2.hasError()) {
                CommAgentTracing.CLIENT.log((short)4, "local: can't create reply stub for instance=%1", serviceInstanceID);
                int n = stubOrError2.getError();
                this.proxyStubPools.makeProxyFailed(s, (byte)n);
                this.proxyStubPools.makeProxyFailed(s3, (byte)n);
                this.proxyStubPools.removeStub(s2);
                return false;
            }
            stub2 = stubOrError2.getStub();
            stub2.goLive();
        }
        if (proxy2 != null) {
            stub.setReplyProxyFrontend(iProxyFrontend);
            proxy.setReplyStubID(stub2.getStubID());
            proxy.setReplyStub(stub2);
            proxy2.setRequestStub(stub);
            stub2.setRequestProxy(proxy);
            this.proxyStubPools.makeProxyAlive(proxy2.getProxyID(), stub2.getStubID());
            stub2.getServiceHandler().attachedStub(stub2);
        }
        this.proxyStubPools.makeProxyAlive(s, s2);
        stub.getServiceHandler().attachedStub(stub);
        CommAgentTracing.CLIENT.log((short)1, "> local: connectProxy stub=#%1 proxy=#%2 instance=%3", new Short(s2), (Object)new Short(s), (Object)proxy.getInstanceID());
        return true;
    }

    @Override
    public void proxyAliveDone(Proxy proxy) {
        boolean bl = proxy.setNotifyProxyBackend();
        if (bl) {
            this.connector.disconnectProxy(proxy);
        }
    }

    @Override
    public void remoteCallMethod(short s, short s2, ISerializable iSerializable, ICallMethodSerializeCallback iCallMethodSerializeCallback) {
        CommAgentTracing.CLIENT.log((short)1, "< local: remoteCallMethod stub=#%1 method=#%2", new Short(s), (Object)new Short(s2));
        Stub stub = this.proxyStubPools.getStubForID(s);
        if (stub == null) {
            return;
        }
        IStreamDeserializer iStreamDeserializer = null;
        try {
            DefaultExtendedSerializer defaultExtendedSerializer = new DefaultExtendedSerializer(new BEDefaultSerializer());
            defaultExtendedSerializer.beginSizeCalc();
            if (iSerializable != null) {
                iSerializable.serialize(defaultExtendedSerializer);
            }
            int n = defaultExtendedSerializer.endSizeCalc();
            CommAgentTracing.CLIENT.log((short)1, "local: serialized %1 bytes", new Integer(n));
            TransportBuffer transportBuffer = new TransportBuffer(n);
            defaultExtendedSerializer.attachBuffer(transportBuffer);
            if (iCallMethodSerializeCallback != null) {
                iCallMethodSerializeCallback.beginSerializeCallMethodPayload(s, s2, defaultExtendedSerializer);
            }
            if (iSerializable != null) {
                iSerializable.serialize(defaultExtendedSerializer);
            }
            if (iCallMethodSerializeCallback != null) {
                iCallMethodSerializeCallback.endSerializeCallMethodPayload(s, s2, defaultExtendedSerializer);
            }
            defaultExtendedSerializer.detachBuffer();
            iStreamDeserializer = new DefaultExtendedDeserializer(new BEDefaultDeserializer());
            iStreamDeserializer.attachBuffer(transportBuffer);
        }
        catch (SerializerException serializerException) {
            CommAgentTracing.CLIENT.log((short)4, "local: serializer failed: %1", serializerException);
        }
        stub.handleCallMethod(s2, (IDeserializer)iStreamDeserializer, stub.getReplyProxyFrontend());
        if (iStreamDeserializer != null) {
            iStreamDeserializer.detachBuffer();
        }
        CommAgentTracing.CLIENT.log((short)1, "> local: remoteCallMethod stub=#%1 method=#%2", new Short(s), (Object)new Short(s2));
    }

    @Override
    public void disconnectProxy(Proxy proxy) {
        Proxy proxy2;
        short s = proxy.getProxyID();
        short s2 = proxy.getStubID();
        CommAgentTracing.CLIENT.log((short)1, "< local: disconnectProxy proxy=#%1 stub=#%2 instance=%3", new Short(s), (Object)new Short(s2), (Object)proxy.getInstanceID());
        this.proxyStubPools.makeProxyDead(proxy);
        Stub stub = this.proxyStubPools.removeStub(s2);
        IProxyFrontend iProxyFrontend = null;
        if (stub != null) {
            stub.getServiceHandler().detachedStub(stub);
            iProxyFrontend = stub.getReplyProxyFrontend();
        }
        if (iProxyFrontend != null && (proxy2 = iProxyFrontend.getProxy()) != null) {
            short s3 = proxy2.getProxyID();
            short s4 = proxy2.getStubID();
            CommAgentTracing.CLIENT.log((short)1, "local: cleaning up reply proxy: proxy=#%1 stub=#%2 instance=%3", new Short(s3), (Object)new Short(s4), (Object)proxy2.getInstanceID());
            this.proxyStubPools.makeProxyDead(proxy2);
            Stub stub2 = this.proxyStubPools.removeStub(s4);
            if (stub2 != null) {
                stub2.getServiceHandler().detachedStub(stub2);
            }
        }
        CommAgentTracing.CLIENT.log((short)1, "> local: disconnectProxy proxy=#%1 stub=#%2 instance=%3", new Short(s), (Object)new Short(s2), (Object)proxy.getInstanceID());
    }

    @Override
    public void dropStub(IStub iStub) {
        short s = iStub.getRemoteProxyID();
        CommAgentTracing.CLIENT.log((short)1, "= local: removeStub: proxy=#%1 stub=#%2 instance=#%3", new Short(s), (Object)new Short(iStub.getStubID()), (Object)iStub.getService().getInstanceID());
        if (s != -1) {
            Proxy proxy = this.proxyStubPools.getProxyForID(s);
            if (proxy != null) {
                this.disconnectProxy(proxy);
            }
        } else {
            CommAgentTracing.CLIENT.log((short)3, "Invalid proxy id");
        }
    }

    @Override
    public ClientInfo createInfo() {
        return new ClientInfo(-1, -1, 0, super.getClass().getName(), "local", null, -1, -1, 0, "ok", this.lastConnectTimeStamp, this.lastDisconnectTimeStamp, null, null);
    }
}

