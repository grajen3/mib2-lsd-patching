/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.diag.info;

import de.esolutions.fw.comm.agent.diag.AbstractInfoBase;
import de.esolutions.fw.comm.agent.service.ServiceHandler;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class ServiceHandlerInfo
extends AbstractInfoBase {
    public final ServiceInstanceID svcID;
    public final String svcClass;
    public final String svcWorker;
    public final int stubCount;

    public ServiceHandlerInfo(ServiceHandler serviceHandler) {
        super(serviceHandler.getServiceID());
        IService iService = serviceHandler.getService();
        this.svcID = iService.getInstanceID();
        this.svcClass = super.getClass().getName();
        this.svcWorker = super.getClass().getName();
        this.stubCount = serviceHandler.getStubCount();
    }

    @Override
    public ServiceInstanceID getServiceInstanceID() {
        return this.svcID;
    }
}

