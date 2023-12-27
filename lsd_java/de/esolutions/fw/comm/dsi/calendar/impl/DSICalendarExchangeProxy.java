/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.calendar.DSICalendarExchange;
import de.esolutions.fw.comm.dsi.calendar.DSICalendarExchangeC;
import de.esolutions.fw.comm.dsi.calendar.DSICalendarExchangeReply;
import de.esolutions.fw.comm.dsi.calendar.impl.DSICalendarExchangeProxy$1;
import de.esolutions.fw.comm.dsi.calendar.impl.DSICalendarExchangeReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.ResourceLocator;

public class DSICalendarExchangeProxy
implements DSICalendarExchange,
DSICalendarExchangeC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.calendar.DSICalendarExchange");
    private Proxy proxy;

    public DSICalendarExchangeProxy(int n, DSICalendarExchangeReply dSICalendarExchangeReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("84985ea1-90a4-5f1b-b5e1-054905ba1132", n, "f490b393-8d24-5cd7-9b34-e61e7c72d711", "dsi.calendar.DSICalendarExchange");
        DSICalendarExchangeReplyService dSICalendarExchangeReplyService = new DSICalendarExchangeReplyService(dSICalendarExchangeReply);
        this.proxy = new Proxy(serviceInstanceID, dSICalendarExchangeReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void parseICal(String string) {
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
    public void parseICalDirectory(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    @Override
    public void exportICal(int n, int n2, long[] lArray, int n3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putOptionalInt64VarArray(lArray);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void importICal(ResourceLocator[] resourceLocatorArray) {
        DSICalendarExchangeProxy$1 dSICalendarExchangeProxy$1 = new DSICalendarExchangeProxy$1(this, resourceLocatorArray);
        this.proxy.remoteCallMethod((short)5, dSICalendarExchangeProxy$1);
    }

    @Override
    public void abortExport() {
        this.proxy.remoteCallMethod((short)0, null);
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
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }
}

