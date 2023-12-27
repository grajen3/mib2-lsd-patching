/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.service;

import de.esolutions.fw.comm.agent.service.Stub;
import de.esolutions.fw.comm.core.IMethod;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;

public class Method
implements IMethod {
    final Stub stub;
    final IService service;
    final short methodID;
    final IDeserializer deserializer;
    final long numCalls;
    final IProxyFrontend reply;
    final long createTime;
    long invokeTime;

    public Method(Stub stub, short s, IDeserializer iDeserializer, long l, IProxyFrontend iProxyFrontend, long l2) {
        this.stub = stub;
        this.service = stub.getService();
        this.methodID = s;
        this.deserializer = iDeserializer;
        this.numCalls = l;
        this.reply = iProxyFrontend;
        this.createTime = l2;
    }

    @Override
    public short getMethodID() {
        return this.methodID;
    }

    public long getNumCalls() {
        return this.numCalls;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setInvokeTime(long l) {
        this.invokeTime = l;
    }

    public long getInvokeTime() {
        return this.invokeTime;
    }

    @Override
    public IService getService() {
        return this.service;
    }

    public String toString() {
        return new StringBuffer().append("[MethodId=").append(this.methodID).append(",numCalls=").append(this.numCalls).append(",service=").append(this.service.getInstanceID()).append("]").toString();
    }

    @Override
    public void invoke() {
        this.stub.methodPreInvoke(this);
        if (this.service != null) {
            try {
                this.service.handleCallMethod(this.methodID, this.deserializer, this.reply);
                this.stub.methodPostInvoke(this, null);
            }
            catch (MethodException methodException) {
                this.stub.methodPostInvoke(this, methodException);
                throw methodException;
            }
        } else {
            MethodException methodException = new MethodException("service instance is null!");
            this.stub.methodPostInvoke(this, methodException);
            throw methodException;
        }
    }
}

