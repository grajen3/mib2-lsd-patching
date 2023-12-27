/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbVCardExchange;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbVCardExchangeC;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbVCardExchangeReply;
import de.esolutions.fw.comm.dsi.organizer.impl.DSIAdbVCardExchangeProxy$1;
import de.esolutions.fw.comm.dsi.organizer.impl.DSIAdbVCardExchangeReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.ResourceLocator;

public class DSIAdbVCardExchangeProxy
implements DSIAdbVCardExchange,
DSIAdbVCardExchangeC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.organizer.DSIAdbVCardExchange");
    private Proxy proxy;

    public DSIAdbVCardExchangeProxy(int n, DSIAdbVCardExchangeReply dSIAdbVCardExchangeReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("f8c7f2ec-5e1d-56d3-a9da-173d018ea384", n, "64d95b9f-2477-56fc-aa67-8173e9bbb3c9", "dsi.organizer.DSIAdbVCardExchange");
        DSIAdbVCardExchangeReplyService dSIAdbVCardExchangeReplyService = new DSIAdbVCardExchangeReplyService(dSIAdbVCardExchangeReply);
        this.proxy = new Proxy(serviceInstanceID, dSIAdbVCardExchangeReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void importVCard(ResourceLocator[] resourceLocatorArray, int n) {
        DSIAdbVCardExchangeProxy$1 dSIAdbVCardExchangeProxy$1 = new DSIAdbVCardExchangeProxy$1(this, resourceLocatorArray, n);
        this.proxy.remoteCallMethod((short)11, dSIAdbVCardExchangeProxy$1);
    }

    @Override
    public void exportVCard(int n, String string, long[] lArray, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalInt64VarArray(lArray);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)28, genericSerializable);
    }

    @Override
    public void exportSpellerVCard(int n, int n2, String string, long[] lArray, int n3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalInt64VarArray(lArray);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)27, genericSerializable);
    }

    @Override
    public void createVCard(int n, long[] lArray, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalInt64VarArray(lArray);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    @Override
    public void parseVCard(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    @Override
    public void requestAbort(int n) {
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
    public void setNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
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
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)7, null);
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
        this.proxy.remoteCallMethod((short)1, genericSerializable);
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
        this.proxy.remoteCallMethod((short)2, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)0, null);
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
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }
}

