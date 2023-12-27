/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.connectedradio.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.connectedradio.DSIHybridRadio;
import de.esolutions.fw.comm.dsi.connectedradio.DSIHybridRadioC;
import de.esolutions.fw.comm.dsi.connectedradio.DSIHybridRadioReply;
import de.esolutions.fw.comm.dsi.connectedradio.impl.DSIHybridRadioProxy$1;
import de.esolutions.fw.comm.dsi.connectedradio.impl.DSIHybridRadioProxy$2;
import de.esolutions.fw.comm.dsi.connectedradio.impl.DSIHybridRadioProxy$3;
import de.esolutions.fw.comm.dsi.connectedradio.impl.DSIHybridRadioProxy$4;
import de.esolutions.fw.comm.dsi.connectedradio.impl.DSIHybridRadioProxy$5;
import de.esolutions.fw.comm.dsi.connectedradio.impl.DSIHybridRadioReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.connectedradio.RadioStation;

public class DSIHybridRadioProxy
implements DSIHybridRadio,
DSIHybridRadioC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.connectedradio.DSIHybridRadio");
    private Proxy proxy;

    public DSIHybridRadioProxy(int n, DSIHybridRadioReply dSIHybridRadioReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("bf0a0c09-9f7a-5d42-a5e3-a58d461ed435", n, "e36b89a2-7496-5acc-86ee-24b37288c8fc", "dsi.connectedradio.DSIHybridRadio");
        DSIHybridRadioReplyService dSIHybridRadioReplyService = new DSIHybridRadioReplyService(dSIHybridRadioReply);
        this.proxy = new Proxy(serviceInstanceID, dSIHybridRadioReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void getOnlineRadioAvailability(int n, RadioStation[] radioStationArray) {
        DSIHybridRadioProxy$1 dSIHybridRadioProxy$1 = new DSIHybridRadioProxy$1(this, n, radioStationArray);
        this.proxy.remoteCallMethod((short)6, dSIHybridRadioProxy$1);
    }

    @Override
    public void getRadioStationLogo(int n, RadioStation[] radioStationArray, int n2) {
        DSIHybridRadioProxy$2 dSIHybridRadioProxy$2 = new DSIHybridRadioProxy$2(this, n, radioStationArray, n2);
        this.proxy.remoteCallMethod((short)8, dSIHybridRadioProxy$2);
    }

    @Override
    public void cancelGetRadioStationLogo(int n) {
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
    public void getStream(int n, RadioStation radioStation) {
        DSIHybridRadioProxy$3 dSIHybridRadioProxy$3 = new DSIHybridRadioProxy$3(this, n, radioStation);
        this.proxy.remoteCallMethod((short)10, dSIHybridRadioProxy$3);
    }

    @Override
    public void startSlideshow(int n, RadioStation radioStation, int n2, int n3) {
        DSIHybridRadioProxy$4 dSIHybridRadioProxy$4 = new DSIHybridRadioProxy$4(this, n, radioStation, n2, n3);
        this.proxy.remoteCallMethod((short)16, dSIHybridRadioProxy$4);
    }

    @Override
    public void stopSlideshow(int n, RadioStation radioStation) {
        DSIHybridRadioProxy$5 dSIHybridRadioProxy$5 = new DSIHybridRadioProxy$5(this, n, radioStation);
        this.proxy.remoteCallMethod((short)18, dSIHybridRadioProxy$5);
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
        this.proxy.remoteCallMethod((short)24, genericSerializable);
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
        this.proxy.remoteCallMethod((short)27, genericSerializable);
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
        this.proxy.remoteCallMethod((short)28, genericSerializable);
    }

    @Override
    public void profileResetAll() {
        this.proxy.remoteCallMethod((short)30, null);
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
        this.proxy.remoteCallMethod((short)14, genericSerializable);
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
        this.proxy.remoteCallMethod((short)15, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)13, null);
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
        this.proxy.remoteCallMethod((short)23, genericSerializable);
    }
}

