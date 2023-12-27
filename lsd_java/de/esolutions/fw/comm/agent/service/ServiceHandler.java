/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.service;

import de.esolutions.fw.comm.agent.service.IServiceHandlerListener;
import de.esolutions.fw.comm.agent.service.ServiceHandler$1;
import de.esolutions.fw.comm.agent.service.ServiceHandler$2;
import de.esolutions.fw.comm.agent.service.Stub;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IServiceWorker;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import java.util.ArrayList;

public class ServiceHandler {
    private final IService service;
    private final int serviceID;
    private final IServiceHandlerListener listener;
    private final IServiceWorker worker;
    private final short myAgentID;
    private ArrayList stubList;

    public ServiceHandler(IServiceHandlerListener iServiceHandlerListener, IService iService, int n, IServiceWorker iServiceWorker, short s) {
        this.listener = iServiceHandlerListener;
        this.service = iService;
        this.serviceID = n;
        this.worker = iServiceWorker;
        this.myAgentID = s;
        this.stubList = new ArrayList();
        CommAgentTracing.SERVICE.log((short)1, "+ register worker for service=#%1:%2", new Integer(n), (Object)iService.getInstanceID());
        iServiceWorker.registerService(iService);
        CommAgentTracing.SERVICE.log((short)1, "- register worker for service=#%1:%2", new Integer(n), (Object)iService.getInstanceID());
    }

    public synchronized void shutdown() {
        CommAgentTracing.SERVICE.log((short)0, "+ shutdown worker for service=#%1:%2", new Integer(this.serviceID), (Object)this.service.getInstanceID());
        if (!this.stubList.isEmpty()) {
            CommAgentTracing.SERVICE.log((short)3, "shutdown called but %1 stubs still attached!", new Integer(this.stubList.size()));
            Object[] objectArray = this.stubList.toArray();
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                this.detachedStub((Stub)objectArray[i2]);
            }
        }
        this.worker.unregisterService(this.service);
        CommAgentTracing.SERVICE.log((short)0, "- shutdown worker for service=#%1:%2", new Integer(this.serviceID), (Object)this.service.getInstanceID());
    }

    public String toString() {
        return new StringBuffer().append("[Service #").append(this.serviceID).append("]").toString();
    }

    public ServiceInstanceID getInstanceID() {
        return this.service.getInstanceID();
    }

    public IService getService() {
        return this.service;
    }

    public IServiceWorker getServiceWorker() {
        return this.worker;
    }

    public int getServiceID() {
        return this.serviceID;
    }

    public synchronized void attachedStub(Stub stub) {
        this.stubList.add(stub);
        CommAgentTracing.SERVICE.log((short)0, "service=#%1:%2 attach stub. count=%3", new Integer(this.serviceID), (Object)this.service.getInstanceID(), (Object)new Integer(this.stubList.size()));
        CommAgentTracing.COMM.log((short)2, "on='%1' event='interface' interface='%2:%3' info='client-connected' count='%4' home='%5'", new Short(this.myAgentID), (Object)this.service.getInstanceID().getServiceUUID(), (Object)new Integer(this.service.getInstanceID().getHandle()), (Object)new Integer(this.stubList.size()), (Object)new Short(stub.getRemoteAgentID()));
        ServiceHandler$1 serviceHandler$1 = new ServiceHandler$1(this, stub);
        this.listener.serviceStubAttached(this.service, this.stubList.size(), stub, serviceHandler$1);
    }

    public synchronized void detachedStub(Stub stub) {
        boolean bl = this.stubList.remove(stub);
        CommAgentTracing.SERVICE.log((short)0, "service=#%1:%2 detach stub. count=%3", new Integer(this.serviceID), (Object)this.service.getInstanceID(), (Object)new Integer(this.stubList.size()));
        CommAgentTracing.COMM.log((short)2, "on='%1' event='interface' interface='%2:%3' info='client-disconnected' count='%4' home='%5'", new Short(this.myAgentID), (Object)this.service.getInstanceID().getServiceUUID(), (Object)new Integer(this.service.getInstanceID().getHandle()), (Object)new Integer(this.stubList.size()), (Object)new Short(stub.getRemoteAgentID()));
        ServiceHandler$2 serviceHandler$2 = new ServiceHandler$2(this);
        if (bl) {
            this.listener.serviceStubDetached(this.service, this.stubList.size(), stub, serviceHandler$2);
        }
    }

    public synchronized void detachedStubComplete() {
        this.worker.stubCountChanged(this.service, this.stubList.size());
        CommAgentTracing.SERVICE.log((short)0, "service=#%1:%2 completed detach stub. count=%3", new Integer(this.serviceID), (Object)this.service.getInstanceID(), (Object)new Integer(this.stubList.size()));
    }

    public synchronized void attachtedStubComplete(Stub stub) {
        this.worker.stubCountChanged(this.service, this.stubList.size());
        CommAgentTracing.SERVICE.log((short)0, "service=#%1:%2 completed attach stub. count=%3", new Integer(this.serviceID), (Object)this.service.getInstanceID(), (Object)new Integer(this.stubList.size()));
        stub.goLive();
    }

    public synchronized int getStubCount() {
        return this.stubList.size();
    }
}

