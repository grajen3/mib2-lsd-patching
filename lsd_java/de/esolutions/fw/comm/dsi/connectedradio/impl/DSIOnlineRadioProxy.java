/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.connectedradio.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.connectedradio.DSIOnlineRadio;
import de.esolutions.fw.comm.dsi.connectedradio.DSIOnlineRadioC;
import de.esolutions.fw.comm.dsi.connectedradio.DSIOnlineRadioReply;
import de.esolutions.fw.comm.dsi.connectedradio.impl.DSIOnlineRadioProxy$1;
import de.esolutions.fw.comm.dsi.connectedradio.impl.DSIOnlineRadioProxy$2;
import de.esolutions.fw.comm.dsi.connectedradio.impl.DSIOnlineRadioProxy$3;
import de.esolutions.fw.comm.dsi.connectedradio.impl.DSIOnlineRadioReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.connectedradio.RadioStation;

public class DSIOnlineRadioProxy
implements DSIOnlineRadio,
DSIOnlineRadioC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.connectedradio.DSIOnlineRadio");
    private Proxy proxy;

    public DSIOnlineRadioProxy(int n, DSIOnlineRadioReply dSIOnlineRadioReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("e9c160f1-2e8f-57da-bb54-db1c92f1890e", n, "5bc1908d-d9a1-5c95-a333-c2a845af78ee", "dsi.connectedradio.DSIOnlineRadio");
        DSIOnlineRadioReplyService dSIOnlineRadioReplyService = new DSIOnlineRadioReplyService(dSIOnlineRadioReply);
        this.proxy = new Proxy(serviceInstanceID, dSIOnlineRadioReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void getRadioStationLogo(int n, RadioStation radioStation, int n2) {
        DSIOnlineRadioProxy$1 dSIOnlineRadioProxy$1 = new DSIOnlineRadioProxy$1(this, n, radioStation, n2);
        this.proxy.remoteCallMethod((short)10, dSIOnlineRadioProxy$1);
    }

    @Override
    public void getStreamUrl(int n, RadioStation radioStation) {
        DSIOnlineRadioProxy$2 dSIOnlineRadioProxy$2 = new DSIOnlineRadioProxy$2(this, n, radioStation);
        this.proxy.remoteCallMethod((short)12, dSIOnlineRadioProxy$2);
    }

    @Override
    public void getMetaInformation(int n, RadioStation radioStation) {
        DSIOnlineRadioProxy$3 dSIOnlineRadioProxy$3 = new DSIOnlineRadioProxy$3(this, n, radioStation);
        this.proxy.remoteCallMethod((short)8, dSIOnlineRadioProxy$3);
    }

    @Override
    public void downloadDatabase(int n) {
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
    public void cancelDownloadDatabase(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)1, genericSerializable);
    }

    @Override
    public void profileChange(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }

    @Override
    public void profileCopy(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)22, genericSerializable);
    }

    @Override
    public void profileReset(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)23, genericSerializable);
    }

    @Override
    public void profileResetAll() {
        this.proxy.remoteCallMethod((short)25, null);
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
        this.proxy.remoteCallMethod((short)15, genericSerializable);
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
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)14, null);
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
        this.proxy.remoteCallMethod((short)4, genericSerializable);
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
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)3, null);
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
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }
}

