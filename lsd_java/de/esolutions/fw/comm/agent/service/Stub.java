/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.service;

import de.esolutions.fw.comm.agent.client.IClientHandler;
import de.esolutions.fw.comm.agent.service.Method;
import de.esolutions.fw.comm.agent.service.ServiceHandler;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IServiceWorker;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.core.tracing.StubTracing;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.tracing.TraceChannel;
import java.util.ArrayList;

public final class Stub
implements IStub {
    private final ServiceHandler serviceHandler;
    private final IClientHandler client;
    private final short remoteAgentID;
    private final IService service;
    private final CallContext context;
    private final IServiceWorker worker;
    private short stubID;
    private short remoteProxyID;
    private IProxyFrontend reply;
    private Proxy requestProxy;
    private int numCalls;
    private int pendingCalls;
    private int errorCalls;
    private final Object postponeLock = new Object();
    private final ArrayList postponedCalls = new ArrayList(16);
    private boolean doPostpone = true;
    private final ITimeSource monoTime;
    private int ilMin = -129;
    private int ilMax;
    private long ilAvg;
    private int itMin = -129;
    private int itMax;
    private long itAvg;

    public Stub(ServiceHandler serviceHandler, IClientHandler iClientHandler, short s, short s2, ITimeSource iTimeSource) {
        this.serviceHandler = serviceHandler;
        this.client = iClientHandler;
        this.remoteProxyID = s;
        this.remoteAgentID = s2;
        this.monoTime = iTimeSource;
        if (serviceHandler != null) {
            this.service = serviceHandler.getService();
            this.context = this.service.getCallContext();
            this.worker = serviceHandler.getServiceWorker();
        } else {
            this.service = null;
            this.context = null;
            this.worker = null;
        }
    }

    public ServiceHandler getServiceHandler() {
        return this.serviceHandler;
    }

    @Override
    public IService getService() {
        return this.serviceHandler.getService();
    }

    @Override
    public short getStubID() {
        return this.stubID;
    }

    public void setStubID(short s) {
        this.stubID = s;
    }

    public IClientHandler getClient() {
        return this.client;
    }

    public void setRemoteProxyID(short s) {
        this.remoteProxyID = s;
    }

    @Override
    public short getRemoteProxyID() {
        return this.remoteProxyID;
    }

    @Override
    public short getRemoteAgentID() {
        return this.remoteAgentID;
    }

    public void setReplyProxyFrontend(IProxyFrontend iProxyFrontend) {
        this.reply = iProxyFrontend;
    }

    @Override
    public IProxyFrontend getReplyProxyFrontend() {
        return this.reply;
    }

    @Override
    public Proxy getReplyProxy() {
        if (this.reply != null) {
            return this.reply.getProxy();
        }
        return null;
    }

    public void setRequestProxy(Proxy proxy) {
        this.requestProxy = proxy;
    }

    @Override
    public Proxy getRequestProxy() {
        return this.requestProxy;
    }

    public String toString() {
        return new StringBuffer().append("[stub=").append(this.stubID).append(" proxy=").append(this.remoteProxyID).append(" agent=").append(this.remoteAgentID).append("]").toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        Object object;
        if (this.service == null) {
            return;
        }
        if (StubTracing.isEnabled()) {
            object = null;
            if (this.context != null) {
                object = this.context.getTraceChannel();
            }
            if (object != null && ((TraceChannel)object).getFilterLevel() <= 2 && iDeserializer != null) {
                StubTracing stubTracing = new StubTracing(this, (TraceChannel)object, this.numCalls);
                stubTracing.log(s, iDeserializer);
            }
        }
        object = null;
        if (iDeserializer != null) {
            object = (IDeserializer)iDeserializer.clone();
        }
        long l = this.numCalls++;
        long l2 = this.monoTime.getCurrentTime();
        Method method = new Method(this, s, (IDeserializer)object, l, iProxyFrontend, l2);
        ++this.pendingCalls;
        Object object2 = this.postponeLock;
        synchronized (object2) {
            if (this.doPostpone) {
                CommAgentTracing.SERVICE.log((short)1, "  postpone %1 for stub=#%2:%3", method, (Object)new Integer(this.stubID), (Object)this.service.getInstanceID());
                this.postponedCalls.add(method);
            } else {
                CommAgentTracing.SERVICE.log((short)1, "  + enque %1 for stub=#%2:%3", method, (Object)new Integer(this.stubID), (Object)this.service.getInstanceID());
                this.worker.enqueueCall(method);
                CommAgentTracing.SERVICE.log((short)1, "  - enque %1 for stub=#%2:%3", method, (Object)new Integer(this.stubID), (Object)this.service.getInstanceID());
            }
        }
    }

    public void methodPreInvoke(Method method) {
        --this.pendingCalls;
        long l = this.monoTime.getCurrentTime();
        method.setInvokeTime(l);
        int n = (int)(l - method.getCreateTime());
        if (n < this.ilMin) {
            this.ilMin = n;
        }
        if (n > this.ilMax) {
            this.ilMax = n;
        }
        this.ilAvg += (long)n;
    }

    public void methodPostInvoke(Method method, MethodException methodException) {
        long l = this.monoTime.getCurrentTime();
        int n = (int)(l - method.getInvokeTime());
        if (n < this.itMin) {
            this.itMin = n;
        }
        if (n > this.itMax) {
            this.itMax = n;
        }
        this.itAvg += (long)n;
        if (methodException != null) {
            ++this.errorCalls;
        }
    }

    public int[] getInvocationLatency() {
        long l = this.ilAvg;
        if (this.numCalls > 0) {
            l /= (long)this.numCalls;
        }
        return new int[]{this.ilMin, this.ilMax, (int)l};
    }

    public int[] getInvocationDuration() {
        long l = this.itAvg;
        if (this.numCalls > 0) {
            l /= (long)this.numCalls;
        }
        return new int[]{this.itMin, this.itMax, (int)l};
    }

    public int getTotalCalls() {
        return this.numCalls;
    }

    public int getErrorCalls() {
        return this.errorCalls;
    }

    public int getPendingCalls() {
        return this.pendingCalls;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void goLive() {
        CommAgentTracing.SERVICE.log((short)1, "  stub=#%1:%2 going live", new Integer(this.stubID), (Object)this.service.getInstanceID());
        Object object = this.postponeLock;
        synchronized (object) {
            this.doPostpone = false;
            int n = this.postponedCalls.size();
            for (int i2 = 0; i2 < n; ++i2) {
                Method method = (Method)this.postponedCalls.get(i2);
                CommAgentTracing.SERVICE.log((short)1, "  + enque postponed %1 for stub=#%2:%3", method, (Object)new Integer(this.stubID), (Object)this.service.getInstanceID());
                this.worker.enqueueCall(method);
                CommAgentTracing.SERVICE.log((short)1, "  - enque postponed %1 for stub=#%2:%3", method, (Object)new Integer(this.stubID), (Object)this.service.getInstanceID());
            }
            this.postponedCalls.clear();
        }
    }
}

