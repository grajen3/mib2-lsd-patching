/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerGoogleCtrl;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerGoogleCtrlC;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerGoogleCtrlReply;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerGoogleCtrlProxy$1;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerGoogleCtrlReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.map.Rect;

public class DSIMapViewerGoogleCtrlProxy
implements DSIMapViewerGoogleCtrl,
DSIMapViewerGoogleCtrlC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.map.DSIMapViewerGoogleCtrl");
    private Proxy proxy;

    public DSIMapViewerGoogleCtrlProxy(int n, DSIMapViewerGoogleCtrlReply dSIMapViewerGoogleCtrlReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("e47f3481-29e1-5677-a2cc-6de88b0916fb", n, "dfac13da-c25c-582e-a177-03e1c52e6c16", "dsi.map.DSIMapViewerGoogleCtrl");
        DSIMapViewerGoogleCtrlReplyService dSIMapViewerGoogleCtrlReplyService = new DSIMapViewerGoogleCtrlReplyService(dSIMapViewerGoogleCtrlReply);
        this.proxy = new Proxy(serviceInstanceID, dSIMapViewerGoogleCtrlReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void requestClearCache() {
        this.proxy.remoteCallMethod((short)5, null);
    }

    @Override
    public void setLanguage(String string) {
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
    public void setLayerVisibility(int[] nArray) {
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
    public void setConnectionInformation(int n) {
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
    public void loadKml(String[] stringArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalStringVarArray(stringArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void setCopyrightPosition(Rect rect, int n, int n2) {
        DSIMapViewerGoogleCtrlProxy$1 dSIMapViewerGoogleCtrlProxy$1 = new DSIMapViewerGoogleCtrlProxy$1(this, rect, n, n2);
        this.proxy.remoteCallMethod((short)20, dSIMapViewerGoogleCtrlProxy$1);
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
        this.proxy.remoteCallMethod((short)10, genericSerializable);
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
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)9, null);
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
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }
}

