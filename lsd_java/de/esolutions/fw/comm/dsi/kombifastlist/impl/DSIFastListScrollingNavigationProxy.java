/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.kombifastlist.DSIFastListScrollingNavigation;
import de.esolutions.fw.comm.dsi.kombifastlist.DSIFastListScrollingNavigationC;
import de.esolutions.fw.comm.dsi.kombifastlist.DSIFastListScrollingNavigationReply;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingNavigationProxy$1;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingNavigationProxy$2;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingNavigationProxy$3;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingNavigationProxy$4;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingNavigationReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.kombifastlist.DataAddress;
import org.dsi.ifc.kombifastlist.DataInitials;

public class DSIFastListScrollingNavigationProxy
implements DSIFastListScrollingNavigation,
DSIFastListScrollingNavigationC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.kombifastlist.DSIFastListScrollingNavigation");
    private Proxy proxy;

    public DSIFastListScrollingNavigationProxy(int n, DSIFastListScrollingNavigationReply dSIFastListScrollingNavigationReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("f2e88e8e-4a51-55c7-8960-fd77a08d2878", n, "7061a2de-13b6-5651-ae47-a77376db7ad2", "dsi.kombifastlist.DSIFastListScrollingNavigation");
        DSIFastListScrollingNavigationReplyService dSIFastListScrollingNavigationReplyService = new DSIFastListScrollingNavigationReplyService(dSIFastListScrollingNavigationReply);
        this.proxy = new Proxy(serviceInstanceID, dSIFastListScrollingNavigationReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void pushFunctionAvailabilityNavigation(int n) {
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
    public void pushMOSTOperationStateNavigation(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }

    @Override
    public void responseNavBook(int n, int n2, int n3, int n4, int n5, long l, int n6, int n7, int n8, int n9, int n10, int n11, int n12) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
            genericSerializable.putInt32(n4);
            genericSerializable.putInt32(n5);
            genericSerializable.putInt64(l);
            genericSerializable.putInt32(n6);
            genericSerializable.putInt32(n7);
            genericSerializable.putInt32(n8);
            genericSerializable.putInt32(n9);
            genericSerializable.putInt32(n10);
            genericSerializable.putInt32(n11);
            genericSerializable.putInt32(n12);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    @Override
    public void responseNavBookArray(int n, int n2, DataAddress[] dataAddressArray) {
        DSIFastListScrollingNavigationProxy$1 dSIFastListScrollingNavigationProxy$1 = new DSIFastListScrollingNavigationProxy$1(this, n, n2, dataAddressArray);
        this.proxy.remoteCallMethod((short)17, dSIFastListScrollingNavigationProxy$1);
    }

    @Override
    public void responseGetInitialsNavigation(int n, int n2, int n3, int n4, DataInitials[] dataInitialsArray) {
        DSIFastListScrollingNavigationProxy$2 dSIFastListScrollingNavigationProxy$2 = new DSIFastListScrollingNavigationProxy$2(this, n, n2, n3, n4, dataInitialsArray);
        this.proxy.remoteCallMethod((short)15, dSIFastListScrollingNavigationProxy$2);
    }

    @Override
    public void pushLastDestList(int n, int n2, DataAddress[] dataAddressArray) {
        DSIFastListScrollingNavigationProxy$3 dSIFastListScrollingNavigationProxy$3 = new DSIFastListScrollingNavigationProxy$3(this, n, n2, dataAddressArray);
        this.proxy.remoteCallMethod((short)12, dSIFastListScrollingNavigationProxy$3);
    }

    @Override
    public void pushUpdateFavoriteDestList(int n, int n2, DataAddress[] dataAddressArray) {
        DSIFastListScrollingNavigationProxy$4 dSIFastListScrollingNavigationProxy$4 = new DSIFastListScrollingNavigationProxy$4(this, n, n2, dataAddressArray);
        this.proxy.remoteCallMethod((short)14, dSIFastListScrollingNavigationProxy$4);
    }

    @Override
    public void pushCurrentListSizeNavigation(int n, int n2, int n3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    @Override
    public void responseNavBookJobs(int n, int n2, int n3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    @Override
    public void responseNotifyCurrentListSizesNavigation(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }

    @Override
    public void responseNotifyFavoriteDestList(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)20, genericSerializable);
    }

    @Override
    public void responseNotifyLastDestList(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)21, genericSerializable);
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
        this.proxy.remoteCallMethod((short)23, genericSerializable);
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
        this.proxy.remoteCallMethod((short)24, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)22, null);
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
        this.proxy.remoteCallMethod((short)26, genericSerializable);
    }
}

