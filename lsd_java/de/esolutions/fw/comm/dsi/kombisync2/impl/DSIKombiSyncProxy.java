/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync2.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.kombisync2.DSIKombiSync;
import de.esolutions.fw.comm.dsi.kombisync2.DSIKombiSyncC;
import de.esolutions.fw.comm.dsi.kombisync2.DSIKombiSyncReply;
import de.esolutions.fw.comm.dsi.kombisync2.impl.DSIKombiSyncProxy$1;
import de.esolutions.fw.comm.dsi.kombisync2.impl.DSIKombiSyncProxy$2;
import de.esolutions.fw.comm.dsi.kombisync2.impl.DSIKombiSyncProxy$3;
import de.esolutions.fw.comm.dsi.kombisync2.impl.DSIKombiSyncProxy$4;
import de.esolutions.fw.comm.dsi.kombisync2.impl.DSIKombiSyncProxy$5;
import de.esolutions.fw.comm.dsi.kombisync2.impl.DSIKombiSyncProxy$6;
import de.esolutions.fw.comm.dsi.kombisync2.impl.DSIKombiSyncProxy$7;
import de.esolutions.fw.comm.dsi.kombisync2.impl.DSIKombiSyncReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.kombisync2.DisplayIdentification;
import org.dsi.ifc.kombisync2.DisplayRequestResponse;
import org.dsi.ifc.kombisync2.DisplayStatus;
import org.dsi.ifc.kombisync2.MenuState;
import org.dsi.ifc.kombisync2.PopupActionRequestResponse;
import org.dsi.ifc.kombisync2.PopupRegisterRequestResponse;
import org.dsi.ifc.kombisync2.PopupStatus;

public class DSIKombiSyncProxy
implements DSIKombiSync,
DSIKombiSyncC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.kombisync2.DSIKombiSync");
    private Proxy proxy;

    public DSIKombiSyncProxy(int n, DSIKombiSyncReply dSIKombiSyncReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("6bda2552-d7b7-52c8-947c-ac3ec12ded8c", n, "a7f6ba8f-bf72-5749-a74f-39e04ad0dd56", "dsi.kombisync2.DSIKombiSync");
        DSIKombiSyncReplyService dSIKombiSyncReplyService = new DSIKombiSyncReplyService(dSIKombiSyncReply);
        this.proxy = new Proxy(serviceInstanceID, dSIKombiSyncReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setMMIDisplayRequestResponse(DisplayRequestResponse displayRequestResponse) {
        DSIKombiSyncProxy$1 dSIKombiSyncProxy$1 = new DSIKombiSyncProxy$1(this, displayRequestResponse);
        this.proxy.remoteCallMethod((short)12, dSIKombiSyncProxy$1);
    }

    @Override
    public void setMMIDisplayStatus(DisplayStatus displayStatus) {
        DSIKombiSyncProxy$2 dSIKombiSyncProxy$2 = new DSIKombiSyncProxy$2(this, displayStatus);
        this.proxy.remoteCallMethod((short)13, dSIKombiSyncProxy$2);
    }

    @Override
    public void setMenuState(MenuState menuState) {
        DSIKombiSyncProxy$3 dSIKombiSyncProxy$3 = new DSIKombiSyncProxy$3(this, menuState);
        this.proxy.remoteCallMethod((short)17, dSIKombiSyncProxy$3);
    }

    @Override
    public void setMMIPopupRegisterRequest(PopupRegisterRequestResponse popupRegisterRequestResponse) {
        DSIKombiSyncProxy$4 dSIKombiSyncProxy$4 = new DSIKombiSyncProxy$4(this, popupRegisterRequestResponse);
        this.proxy.remoteCallMethod((short)15, dSIKombiSyncProxy$4);
    }

    @Override
    public void setMMIPopupActionResponse(PopupActionRequestResponse popupActionRequestResponse) {
        DSIKombiSyncProxy$5 dSIKombiSyncProxy$5 = new DSIKombiSyncProxy$5(this, popupActionRequestResponse);
        this.proxy.remoteCallMethod((short)14, dSIKombiSyncProxy$5);
    }

    @Override
    public void setMMIPopupStatus(PopupStatus popupStatus) {
        DSIKombiSyncProxy$6 dSIKombiSyncProxy$6 = new DSIKombiSyncProxy$6(this, popupStatus);
        this.proxy.remoteCallMethod((short)16, dSIKombiSyncProxy$6);
    }

    @Override
    public void setMMIDisplayIdentification(DisplayIdentification displayIdentification) {
        DSIKombiSyncProxy$7 dSIKombiSyncProxy$7 = new DSIKombiSyncProxy$7(this, displayIdentification);
        this.proxy.remoteCallMethod((short)11, dSIKombiSyncProxy$7);
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
        this.proxy.remoteCallMethod((short)10, genericSerializable);
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
        this.proxy.remoteCallMethod((short)19, genericSerializable);
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
        this.proxy.remoteCallMethod((short)20, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)18, null);
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
        this.proxy.remoteCallMethod((short)29, genericSerializable);
    }
}

