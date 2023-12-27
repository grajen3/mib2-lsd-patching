/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.komoview.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.komoview.DSIKOMOView;
import de.esolutions.fw.comm.dsi.komoview.DSIKOMOViewC;
import de.esolutions.fw.comm.dsi.komoview.DSIKOMOViewReply;
import de.esolutions.fw.comm.dsi.komoview.impl.DSIKOMOViewProxy$1;
import de.esolutions.fw.comm.dsi.komoview.impl.DSIKOMOViewProxy$2;
import de.esolutions.fw.comm.dsi.komoview.impl.DSIKOMOViewReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.komoview.RouteInfoElement;

public class DSIKOMOViewProxy
implements DSIKOMOView,
DSIKOMOViewC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.komoview.DSIKOMOView");
    private Proxy proxy;

    public DSIKOMOViewProxy(int n, DSIKOMOViewReply dSIKOMOViewReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("4152be76-57b5-5a4d-a6f6-69587a25d01b", n, "e661e4a9-2fb1-5280-8ee8-4c2c186b2698", "dsi.komoview.DSIKOMOView");
        DSIKOMOViewReplyService dSIKOMOViewReplyService = new DSIKOMOViewReplyService(dSIKOMOViewReply);
        this.proxy = new Proxy(serviceInstanceID, dSIKOMOViewReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void enableKomoView(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void notifyVisibility(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void setRouteInfoElement(RouteInfoElement routeInfoElement) {
        DSIKOMOViewProxy$1 dSIKOMOViewProxy$1 = new DSIKOMOViewProxy$1(this, routeInfoElement);
        this.proxy.remoteCallMethod((short)20, dSIKOMOViewProxy$1);
    }

    @Override
    public void setRouteInfo(RouteInfoElement[] routeInfoElementArray) {
        DSIKOMOViewProxy$2 dSIKOMOViewProxy$2 = new DSIKOMOViewProxy$2(this, routeInfoElementArray);
        this.proxy.remoteCallMethod((short)21, dSIKOMOViewProxy$2);
    }

    @Override
    public void setKomoViewStyle(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)15, genericSerializable);
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
        this.proxy.remoteCallMethod((short)7, genericSerializable);
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
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)6, null);
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

