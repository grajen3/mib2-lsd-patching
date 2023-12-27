/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.ILifecycleListener;
import de.esolutions.fw.comm.core.IProxyBackend;
import de.esolutions.fw.comm.core.IProxyConnector;
import de.esolutions.fw.comm.core.IProxyListener;
import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.IServiceWorker;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.Lifecycle;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.IMethodCaller;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.core.tracing.ProxyTracing;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.tracing.TraceChannel;

public final class Proxy
implements IMethodCaller,
ILifecycleListener {
    public static final int NORMAL_OPERATION;
    public static final int DUPLICATE_INSTANCEID;
    public static final int INVALID_INSTANCEID;
    public static final int CONNECTION_LOST;
    public static final int INTERFACE_KEY_MISMATCH;
    public static final int OOM;
    public static final int SERVICE_NOT_AVAILABLE;
    public static final int FACTORY_NOT_FOUND;
    public static final int ID_POOL_EXHAUSTED;
    public static final int OBJECT_IS_DEAD;
    public static final int PROXY_IS_INVALID;
    public static final int INVALID_AGENT_ID;
    public static final int AGENT_IN_SHUTDOWN;
    public static final int INTERNAL_ERROR;
    public static final String[] ERROR_NAMES;
    public static final short INVALID_ID;
    protected static IProxyConnector proxyConnector;
    protected ServiceInstanceID instanceID;
    protected IProxyBackend backend;
    protected Lifecycle lifecycle = new Lifecycle(this);
    protected short proxyID = (short)-1;
    protected short stubID = (short)-1;
    protected short replyStubID = (short)-1;
    private IReplyService replyService;
    private IStub replyStub;
    private IStub requestStub;
    private CallContext callContext;
    private boolean isReplyProxy;
    protected IServiceWorker replyServiceWorker = null;
    private Boolean checkIK;
    private boolean detectInterfaceKeyMismatch = false;
    private boolean hasInterfaceKeyMismatch = false;
    private boolean connecting = false;
    private boolean disconnectPending = false;
    private boolean notifyProxyBackend = false;
    private int pendingError = 0;
    private int numCalls;
    private int errorCalls;
    private boolean replyServiceRegistered = false;

    public static void setProxyConnector(IProxyConnector iProxyConnector) {
        proxyConnector = iProxyConnector;
    }

    private Proxy() {
        this.lifecycle.setListener(this);
    }

    public void setReplyProxyFlag(boolean bl) {
        this.isReplyProxy = bl;
    }

    public boolean getReplyProxyFlag() {
        return this.isReplyProxy;
    }

    public Proxy(ServiceInstanceID serviceInstanceID) {
        this();
        this.instanceID = serviceInstanceID;
    }

    public Proxy(ServiceInstanceID serviceInstanceID, IReplyService iReplyService) {
        this(serviceInstanceID);
        this.replyService = iReplyService;
    }

    public Proxy(ServiceInstanceID serviceInstanceID, CallContext callContext) {
        this(serviceInstanceID);
        this.callContext = callContext;
    }

    public Proxy(ServiceInstanceID serviceInstanceID, IReplyService iReplyService, CallContext callContext) {
        this(serviceInstanceID, iReplyService);
        this.callContext = callContext;
    }

    public void setReplyServiceWorker(IServiceWorker iServiceWorker) {
        this.replyServiceWorker = iServiceWorker;
    }

    public void setReplyStub(IStub iStub) {
        this.replyStub = iStub;
    }

    public IStub getReplyStub() {
        return this.replyStub;
    }

    public void setRequestStub(IStub iStub) {
        this.requestStub = iStub;
    }

    public IStub getRequestStub() {
        return this.requestStub;
    }

    @Override
    public void lifecycleChanged(Lifecycle lifecycle, Object object) {
        Proxy proxy = (Proxy)object;
        int n = proxy.getState();
        proxyConnector.proxyStateChanged(proxy, n);
    }

    public ServiceInstanceID getInstanceID() {
        return this.instanceID;
    }

    public IReplyService getReplyService() {
        return this.replyService;
    }

    public IServiceWorker getReplyServiceWorker() {
        return this.replyServiceWorker;
    }

    public boolean connect() {
        if (!this.connectAsync()) {
            return false;
        }
        return this.waitUntilAlive();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean connectAsync() {
        if (this.isAlive()) {
            return false;
        }
        Proxy proxy = this;
        synchronized (proxy) {
            if (this.disconnectPending) {
                return false;
            }
            if (this.connecting) {
                return false;
            }
            this.connecting = true;
        }
        proxyConnector.connectProxy(this);
        return true;
    }

    public boolean disconnect() {
        if (!this.disconnectAsync()) {
            return false;
        }
        return this.waitUntilDead();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean disconnectAsync() {
        if (!this.isAlive() && !this.isUnborn()) {
            return false;
        }
        boolean bl = false;
        Proxy proxy = this;
        synchronized (proxy) {
            if (this.disconnectPending) {
                return false;
            }
            this.disconnectPending = true;
            if (this.notifyProxyBackend) {
                bl = true;
            }
        }
        if (bl) {
            proxyConnector.disconnectProxy(this);
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean setNotifyProxyBackend() {
        Proxy proxy = this;
        synchronized (proxy) {
            this.notifyProxyBackend = true;
            return this.disconnectPending;
        }
    }

    public synchronized boolean isDisconnectPending() {
        return this.disconnectPending;
    }

    public void registerProxyListener(IProxyListener iProxyListener) {
        proxyConnector.registerProxyListener(this, iProxyListener, true);
    }

    public void unregisterProxyListener(IProxyListener iProxyListener) {
        proxyConnector.registerProxyListener(this, iProxyListener, false);
    }

    public void registerRemoteReplyService(short s) {
        proxyConnector.registerRemoteReplyService(this.instanceID, s);
    }

    public void unregisterRemoteReplyService(short s) {
        proxyConnector.unregisterRemoteReplyService(this.instanceID, s);
    }

    public void setBackend(IProxyBackend iProxyBackend) {
        this.backend = iProxyBackend;
    }

    public IProxyBackend getBackend() {
        return this.backend;
    }

    public boolean waitUntilDead() {
        return this.lifecycle.waitUntilDead();
    }

    public boolean waitUntilAlive() {
        return this.lifecycle.waitUntilAlive();
    }

    public boolean waitUntilDead(long l) {
        return this.lifecycle.waitUntilDead(l);
    }

    public boolean waitUntilAlive(long l) {
        return this.lifecycle.waitUntilAlive(l);
    }

    public boolean isDead() {
        return this.lifecycle.isDead();
    }

    public boolean isUnborn() {
        return this.lifecycle.isUnborn();
    }

    public boolean isAlive() {
        return this.lifecycle.isAlive();
    }

    public boolean isError() {
        return this.lifecycle.isError();
    }

    public int getErrorCode() {
        return this.lifecycle.getErrorCode();
    }

    public String getErrorString() {
        int n = this.lifecycle.getErrorCode();
        if (n >= 0 && n < ERROR_NAMES.length) {
            return ERROR_NAMES[n];
        }
        return new StringBuffer().append("ERROR:").append(n).toString();
    }

    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    public int getState() {
        return this.lifecycle.getState();
    }

    public String getStateString() {
        return this.lifecycle.getStateString();
    }

    public synchronized void reincarnate() {
        this.proxyID = (short)-1;
        this.stubID = (short)-1;
        this.connecting = false;
        this.disconnectPending = false;
        this.notifyProxyBackend = false;
        this.lifecycle.reincarnate();
        this.pendingError = 0;
    }

    @Override
    public void remoteCallMethod(short s, ISerializable iSerializable) {
        int n = this.numCalls++;
        if (!this.lifecycle.isAlive()) {
            ++this.errorCalls;
            throw new MethodException(new StringBuffer().append("called method ").append(s).append(" and proxy is not alive").toString());
        }
        try {
            ProxyTracing proxyTracing = null;
            if (ProxyTracing.isEnabled()) {
                TraceChannel traceChannel = null;
                if (this.callContext != null) {
                    traceChannel = this.callContext.getTraceChannel();
                }
                if (traceChannel != null && traceChannel.getFilterLevel() <= 2) {
                    short s2 = this.backend.getPeerAgentID();
                    proxyTracing = new ProxyTracing(this, s2, traceChannel, n);
                }
            }
            this.backend.remoteCallMethod(this.stubID, s, iSerializable, proxyTracing);
        }
        catch (MethodException methodException) {
            ++this.errorCalls;
            throw methodException;
        }
    }

    public void setProxyID(short s) {
        this.proxyID = s;
    }

    public short getProxyID() {
        return this.proxyID;
    }

    public void setStubID(short s) {
        this.stubID = s;
    }

    public short getStubID() {
        return this.stubID;
    }

    public void setReplyStubID(short s) {
        this.replyStubID = s;
    }

    public short getReplyStubID() {
        return this.replyStubID;
    }

    public void setCheckIK(Boolean bl) {
        this.checkIK = bl;
    }

    public Boolean getCheckIK() {
        return this.checkIK;
    }

    public void setDetectInterfaceKeyMismatch(boolean bl) {
        this.detectInterfaceKeyMismatch = bl;
    }

    public boolean detectInterfaceKeyMismatch() {
        return this.detectInterfaceKeyMismatch;
    }

    public void setInterfaceKeyMismatch(boolean bl) {
        this.hasInterfaceKeyMismatch = bl;
    }

    public boolean hasInterfaceKeyMismatch() {
        return this.hasInterfaceKeyMismatch;
    }

    public void setPendingError(int n) {
        this.pendingError = n;
    }

    public int getPendingError() {
        return this.pendingError;
    }

    public int getTotalCalls() {
        return this.numCalls;
    }

    public int getErrorCalls() {
        return this.errorCalls;
    }

    public void setReplyServiceRegistered(boolean bl) {
        this.replyServiceRegistered = true;
    }

    public boolean getReplyServiceRegistered() {
        return this.replyServiceRegistered;
    }

    static {
        ERROR_NAMES = new String[]{"normal operation", "duplicate instance id", "invalid instance id", "connection lost", "interface key mismatch", "out of memory", "service not available", "factory not found", "id pool exhausted", "object is dead", "proxy is invalid", "invalid agent id", "agent in shutdown", "internal error"};
    }
}

