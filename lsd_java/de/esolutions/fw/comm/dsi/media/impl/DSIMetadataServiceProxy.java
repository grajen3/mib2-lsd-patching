/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.media.DSIMetadataService;
import de.esolutions.fw.comm.dsi.media.DSIMetadataServiceC;
import de.esolutions.fw.comm.dsi.media.DSIMetadataServiceReply;
import de.esolutions.fw.comm.dsi.media.impl.DSIMetadataServiceProxy$1;
import de.esolutions.fw.comm.dsi.media.impl.DSIMetadataServiceReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.media.CoverartInfo;

public class DSIMetadataServiceProxy
implements DSIMetadataService,
DSIMetadataServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.media.DSIMetadataService");
    private Proxy proxy;

    public DSIMetadataServiceProxy(int n, DSIMetadataServiceReply dSIMetadataServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("efe4731d-84ce-530f-a510-7f84abfd9ffa", n, "49b22f6f-2342-51d2-9b32-7e731b01148b", "dsi.media.DSIMetadataService");
        DSIMetadataServiceReplyService dSIMetadataServiceReplyService = new DSIMetadataServiceReplyService(dSIMetadataServiceReply);
        this.proxy = new Proxy(serviceInstanceID, dSIMetadataServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void requestCoverArt(int n, CoverartInfo coverartInfo) {
        DSIMetadataServiceProxy$1 dSIMetadataServiceProxy$1 = new DSIMetadataServiceProxy$1(this, n, coverartInfo);
        this.proxy.remoteCallMethod((short)6, dSIMetadataServiceProxy$1);
    }

    @Override
    public void disableOnlineLookup() {
        this.proxy.remoteCallMethod((short)4, null);
    }

    @Override
    public void enableOnlineLookup() {
        this.proxy.remoteCallMethod((short)5, null);
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
        this.proxy.remoteCallMethod((short)9, genericSerializable);
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
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)8, null);
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
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }
}

