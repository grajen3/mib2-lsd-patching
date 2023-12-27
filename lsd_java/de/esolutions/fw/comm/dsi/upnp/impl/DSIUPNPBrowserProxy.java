/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.upnp.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.upnp.DSIUPNPBrowser;
import de.esolutions.fw.comm.dsi.upnp.DSIUPNPBrowserC;
import de.esolutions.fw.comm.dsi.upnp.DSIUPNPBrowserReply;
import de.esolutions.fw.comm.dsi.upnp.impl.DSIUPNPBrowserProxy$1;
import de.esolutions.fw.comm.dsi.upnp.impl.DSIUPNPBrowserReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.upnp.ListEntry;

public class DSIUPNPBrowserProxy
implements DSIUPNPBrowser,
DSIUPNPBrowserC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.upnp.DSIUPNPBrowser");
    private Proxy proxy;

    public DSIUPNPBrowserProxy(int n, DSIUPNPBrowserReply dSIUPNPBrowserReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("8d35f5b4-3fbf-5229-98d1-b7f48f398272", n, "4689e104-88c5-580b-8c75-45b23c93e421", "dsi.upnp.DSIUPNPBrowser");
        DSIUPNPBrowserReplyService dSIUPNPBrowserReplyService = new DSIUPNPBrowserReplyService(dSIUPNPBrowserReply);
        this.proxy = new Proxy(serviceInstanceID, dSIUPNPBrowserReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void changeFolder(ListEntry[] listEntryArray) {
        DSIUPNPBrowserProxy$1 dSIUPNPBrowserProxy$1 = new DSIUPNPBrowserProxy$1(this, listEntryArray);
        this.proxy.remoteCallMethod((short)1, dSIUPNPBrowserProxy$1);
    }

    @Override
    public void requestList(String string, int n, int n2, int n3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
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
        this.proxy.remoteCallMethod((short)3, genericSerializable);
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
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)2, null);
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
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }
}

