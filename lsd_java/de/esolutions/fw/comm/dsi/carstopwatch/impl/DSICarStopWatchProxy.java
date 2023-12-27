/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carstopwatch.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carstopwatch.DSICarStopWatch;
import de.esolutions.fw.comm.dsi.carstopwatch.DSICarStopWatchC;
import de.esolutions.fw.comm.dsi.carstopwatch.DSICarStopWatchReply;
import de.esolutions.fw.comm.dsi.carstopwatch.impl.DSICarStopWatchProxy$1;
import de.esolutions.fw.comm.dsi.carstopwatch.impl.DSICarStopWatchProxy$2;
import de.esolutions.fw.comm.dsi.carstopwatch.impl.DSICarStopWatchReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carstopwatch.StopWatchTime;

public class DSICarStopWatchProxy
implements DSICarStopWatch,
DSICarStopWatchC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.carstopwatch.DSICarStopWatch");
    private Proxy proxy;

    public DSICarStopWatchProxy(int n, DSICarStopWatchReply dSICarStopWatchReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("584611ca-824a-5095-926b-c7c6c33c89aa", n, "0abc5c31-c9dc-54c0-ab3d-316f61979c15", "dsi.carstopwatch.DSICarStopWatch");
        DSICarStopWatchReplyService dSICarStopWatchReplyService = new DSICarStopWatchReplyService(dSICarStopWatchReply);
        this.proxy = new Proxy(serviceInstanceID, dSICarStopWatchReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setStopWatchFastestLapTime(StopWatchTime stopWatchTime) {
        DSICarStopWatchProxy$1 dSICarStopWatchProxy$1 = new DSICarStopWatchProxy$1(this, stopWatchTime);
        this.proxy.remoteCallMethod((short)8, dSICarStopWatchProxy$1);
    }

    @Override
    public void setStopWatchLapRating(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    @Override
    public void setStopWatchLapProgress(float f2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putFloat(f2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    @Override
    public void setStopWatchLapGPSTrigger() {
        this.proxy.remoteCallMethod((short)9, null);
    }

    @Override
    public void setStopWatchControl(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    @Override
    public void setStopWatchSlowestLapTime(StopWatchTime stopWatchTime) {
        DSICarStopWatchProxy$2 dSICarStopWatchProxy$2 = new DSICarStopWatchProxy$2(this, stopWatchTime);
        this.proxy.remoteCallMethod((short)21, dSICarStopWatchProxy$2);
    }

    @Override
    public void setNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void setNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)4, null);
    }

    @Override
    public void clearNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)2, genericSerializable);
    }

    @Override
    public void clearNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)1, null);
    }

    @Override
    public void yySet(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)20, genericSerializable);
    }
}

