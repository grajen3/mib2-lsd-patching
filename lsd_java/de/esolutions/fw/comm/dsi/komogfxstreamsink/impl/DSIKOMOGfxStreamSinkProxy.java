/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.komogfxstreamsink.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.komogfxstreamsink.DSIKOMOGfxStreamSink;
import de.esolutions.fw.comm.dsi.komogfxstreamsink.DSIKOMOGfxStreamSinkC;
import de.esolutions.fw.comm.dsi.komogfxstreamsink.DSIKOMOGfxStreamSinkReply;
import de.esolutions.fw.comm.dsi.komogfxstreamsink.impl.DSIKOMOGfxStreamSinkReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIKOMOGfxStreamSinkProxy
implements DSIKOMOGfxStreamSink,
DSIKOMOGfxStreamSinkC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.komogfxstreamsink.DSIKOMOGfxStreamSink");
    private Proxy proxy;

    public DSIKOMOGfxStreamSinkProxy(int n, DSIKOMOGfxStreamSinkReply dSIKOMOGfxStreamSinkReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("e431fc99-c578-5fa8-b280-ce902809bd5d", n, "7f54a915-2fc6-5ec3-81a7-a15e19315a24", "dsi.komogfxstreamsink.DSIKOMOGfxStreamSink");
        DSIKOMOGfxStreamSinkReplyService dSIKOMOGfxStreamSinkReplyService = new DSIKOMOGfxStreamSinkReplyService(dSIKOMOGfxStreamSinkReply);
        this.proxy = new Proxy(serviceInstanceID, dSIKOMOGfxStreamSinkReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setFGLayer(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    @Override
    public void fadeIn(int n, int n2, int n3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void fadeOut(int n) {
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
    public void setNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
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
        this.proxy.remoteCallMethod((short)12, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)10, null);
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
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }
}

