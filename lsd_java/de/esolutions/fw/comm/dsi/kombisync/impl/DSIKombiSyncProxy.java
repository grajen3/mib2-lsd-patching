/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.kombisync.DSIKombiSync;
import de.esolutions.fw.comm.dsi.kombisync.DSIKombiSyncC;
import de.esolutions.fw.comm.dsi.kombisync.DSIKombiSyncReply;
import de.esolutions.fw.comm.dsi.kombisync.impl.DSIKombiSyncProxy$1;
import de.esolutions.fw.comm.dsi.kombisync.impl.DSIKombiSyncProxy$2;
import de.esolutions.fw.comm.dsi.kombisync.impl.DSIKombiSyncProxy$3;
import de.esolutions.fw.comm.dsi.kombisync.impl.DSIKombiSyncProxy$4;
import de.esolutions.fw.comm.dsi.kombisync.impl.DSIKombiSyncReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.kombisync.MMIDisplayRequest;
import org.dsi.ifc.kombisync.MMIDisplayStatus;
import org.dsi.ifc.kombisync.MMIPopupRequest;
import org.dsi.ifc.kombisync.MenuState;

public class DSIKombiSyncProxy
implements DSIKombiSync,
DSIKombiSyncC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.kombisync.DSIKombiSync");
    private Proxy proxy;

    public DSIKombiSyncProxy(int n, DSIKombiSyncReply dSIKombiSyncReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("10fe841e-7d8c-5802-8d40-e4219083c9e7", n, "d02e08c1-ad26-5243-b8ad-ac9dfee27dca", "dsi.kombisync.DSIKombiSync");
        DSIKombiSyncReplyService dSIKombiSyncReplyService = new DSIKombiSyncReplyService(dSIKombiSyncReply);
        this.proxy = new Proxy(serviceInstanceID, dSIKombiSyncReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setMMIDisplayStatus(MMIDisplayStatus mMIDisplayStatus) {
        DSIKombiSyncProxy$1 dSIKombiSyncProxy$1 = new DSIKombiSyncProxy$1(this, mMIDisplayStatus);
        this.proxy.remoteCallMethod((short)36, dSIKombiSyncProxy$1);
    }

    @Override
    public void setMMIDisplayRequest(MMIDisplayRequest mMIDisplayRequest) {
        DSIKombiSyncProxy$2 dSIKombiSyncProxy$2 = new DSIKombiSyncProxy$2(this, mMIDisplayRequest);
        this.proxy.remoteCallMethod((short)35, dSIKombiSyncProxy$2);
    }

    @Override
    public void setMenuState(MenuState menuState) {
        DSIKombiSyncProxy$3 dSIKombiSyncProxy$3 = new DSIKombiSyncProxy$3(this, menuState);
        this.proxy.remoteCallMethod((short)41, dSIKombiSyncProxy$3);
    }

    @Override
    public void setMMIPopupRequest(MMIPopupRequest mMIPopupRequest) {
        DSIKombiSyncProxy$4 dSIKombiSyncProxy$4 = new DSIKombiSyncProxy$4(this, mMIPopupRequest);
        this.proxy.remoteCallMethod((short)40, dSIKombiSyncProxy$4);
    }

    @Override
    public void setHMIIsReady(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
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
        this.proxy.remoteCallMethod((short)13, genericSerializable);
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
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)12, null);
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

