/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IExtendedReplyService;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;

public class AbstractReplyService
implements IExtendedReplyService {
    protected ServiceInstanceID instanceID;
    protected Boolean checkIK;

    public AbstractReplyService(ServiceInstanceID serviceInstanceID) {
        this.instanceID = serviceInstanceID;
    }

    @Override
    public ServiceInstanceID getInstanceID() {
        return this.instanceID;
    }

    @Override
    public void setInstanceID(ServiceInstanceID serviceInstanceID) {
        this.instanceID = serviceInstanceID;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return null;
    }

    @Override
    public CallContext getCallContext() {
        return null;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        throw new MethodException(new StringBuffer().append("Unknown method: ").append(s).toString());
    }

    public void setCheckIK(Boolean bl) {
        this.checkIK = bl;
    }

    @Override
    public Boolean getCheckIK() {
        return this.checkIK;
    }
}

