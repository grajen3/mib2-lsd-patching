/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.service;

import de.esolutions.fw.comm.agent.config.CommConfig;
import de.esolutions.fw.comm.agent.diag.info.ServiceHandlerInfo;
import de.esolutions.fw.comm.agent.service.IServiceFinder;
import de.esolutions.fw.comm.agent.service.IServiceHandlerListener;
import de.esolutions.fw.comm.agent.service.ServiceHandler;
import de.esolutions.fw.comm.agent.service.ServiceQueueWorker;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IServiceWorker;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.error.IRunnableWrapper;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ServiceRegistry
implements IServiceFinder {
    protected Map serviceMap;
    protected int serviceID;
    protected IServiceHandlerListener listener;
    protected CommConfig config;
    private final short agentID;
    private final ITimeSource monoTime;
    private final IRunnableWrapper runnableWrapper;

    public ServiceRegistry(IServiceHandlerListener iServiceHandlerListener, CommConfig commConfig, short s, ITimeSource iTimeSource, IRunnableWrapper iRunnableWrapper) {
        this.listener = iServiceHandlerListener;
        this.config = commConfig;
        this.serviceMap = new HashMap();
        this.serviceID = 0;
        this.agentID = s;
        this.monoTime = iTimeSource;
        this.runnableWrapper = iRunnableWrapper;
    }

    public synchronized int getNumberOfServices() {
        return this.serviceMap.size();
    }

    private String getServiceWorkerName(IService iService) {
        Buffer buffer = new Buffer();
        buffer.append("commSrv");
        buffer.append(this.serviceID);
        ServiceInstanceID serviceInstanceID = iService.getInstanceID();
        if (serviceInstanceID != null) {
            buffer.append('_');
            buffer.append(serviceInstanceID.getServiceUUID().toString());
            buffer.append('_');
            buffer.append(Integer.toHexString(serviceInstanceID.getHandle()));
        }
        return buffer.toString();
    }

    public synchronized void registerService(IService iService, IServiceWorker iServiceWorker) {
        CommAgentTracing.REGISTRY.log((short)1, "registerService #%1:%2", new Integer(this.serviceID), (Object)iService.getInstanceID());
        if (iServiceWorker == null) {
            iServiceWorker = new ServiceQueueWorker(this.getServiceWorkerName(iService), this.config.getCallQueueSize(), this.config.getCallTimeout(), this.config.getServiceLazyStart(), this.config.getPriorities().getDefaultSvcWorkerPrio(), this.monoTime, this.runnableWrapper);
        }
        ServiceHandler serviceHandler = new ServiceHandler(this.listener, iService, this.serviceID, iServiceWorker, this.agentID);
        this.serviceMap.put(iService.getInstanceID(), serviceHandler);
        ++this.serviceID;
    }

    public synchronized void unregisterService(IService iService) {
        CommAgentTracing.REGISTRY.log((short)1, "unregisterService #%1:%2", new Integer(this.serviceID), (Object)iService.getInstanceID());
        ServiceHandler serviceHandler = this.findAndRemoveService(iService.getInstanceID());
        if (serviceHandler != null) {
            serviceHandler.shutdown();
        }
    }

    public synchronized ServiceHandler findAndRemoveService(ServiceInstanceID serviceInstanceID) {
        Iterator iterator = this.serviceMap.keySet().iterator();
        while (iterator.hasNext()) {
            ServiceInstanceID serviceInstanceID2 = (ServiceInstanceID)iterator.next();
            if (!serviceInstanceID2.equals(serviceInstanceID)) continue;
            return (ServiceHandler)this.serviceMap.remove(serviceInstanceID2);
        }
        return null;
    }

    @Override
    public synchronized ServiceHandler findService(ServiceInstanceID serviceInstanceID) {
        Iterator iterator = this.serviceMap.keySet().iterator();
        while (iterator.hasNext()) {
            ServiceInstanceID serviceInstanceID2 = (ServiceInstanceID)iterator.next();
            if (!serviceInstanceID2.equals(serviceInstanceID)) continue;
            return (ServiceHandler)this.serviceMap.get(serviceInstanceID2);
        }
        return null;
    }

    public synchronized IService[] getAllServices() {
        IService[] iServiceArray = new IService[this.serviceMap.size()];
        Iterator iterator = this.serviceMap.values().iterator();
        int n = 0;
        while (iterator.hasNext()) {
            ServiceHandler serviceHandler = (ServiceHandler)iterator.next();
            iServiceArray[n++] = serviceHandler.getService();
        }
        return iServiceArray;
    }

    public synchronized void shutdown() {
        CommAgentTracing.REGISTRY.log((short)0, "+ shutdown registry");
        Iterator iterator = this.serviceMap.values().iterator();
        while (iterator.hasNext()) {
            ServiceHandler serviceHandler = (ServiceHandler)iterator.next();
            serviceHandler.shutdown();
        }
        CommAgentTracing.REGISTRY.log((short)0, "- shutdown registry");
    }

    public synchronized ServiceHandlerInfo[] createServiceHandlerInfos() {
        int n = this.serviceMap.size();
        ServiceHandlerInfo[] serviceHandlerInfoArray = new ServiceHandlerInfo[n];
        Iterator iterator = this.serviceMap.values().iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            ServiceHandler serviceHandler = (ServiceHandler)iterator.next();
            serviceHandlerInfoArray[n2++] = new ServiceHandlerInfo(serviceHandler);
        }
        return serviceHandlerInfoArray;
    }
}

