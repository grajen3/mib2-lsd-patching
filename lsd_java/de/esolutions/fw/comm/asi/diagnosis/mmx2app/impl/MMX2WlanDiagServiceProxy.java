/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2WlanDiagService;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2WlanDiagServiceC;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2WlanDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2WlanDiagServiceProxy$1;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2WlanDiagServiceProxy$2;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2WlanDiagServiceReplyService;
import de.esolutions.fw.comm.asi.diagnosis.wlan.sWlanProperties;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2WlanDiagServiceProxy
implements MMX2WlanDiagService,
MMX2WlanDiagServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2WlanDiagService");
    private Proxy proxy;

    public MMX2WlanDiagServiceProxy(int n, MMX2WlanDiagServiceReply mMX2WlanDiagServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("2ffff5fe-3ecc-4e5e-a640-76dd6851b878", n, "1be1b0ee-6e07-530b-8fc9-ff8327651d0c", "asi.diagnosis.mmx2app.MMX2WlanDiagService");
        MMX2WlanDiagServiceReplyService mMX2WlanDiagServiceReplyService = new MMX2WlanDiagServiceReplyService(mMX2WlanDiagServiceReply);
        this.proxy = new Proxy(serviceInstanceID, mMX2WlanDiagServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void responseErrorWlan(sClientResponseError sClientResponseError2) {
        MMX2WlanDiagServiceProxy$1 mMX2WlanDiagServiceProxy$1 = new MMX2WlanDiagServiceProxy$1(this, sClientResponseError2);
        this.proxy.remoteCallMethod((short)24, mMX2WlanDiagServiceProxy$1);
    }

    @Override
    public void responseWlanProperties(sWlanProperties sWlanProperties2) {
        MMX2WlanDiagServiceProxy$2 mMX2WlanDiagServiceProxy$2 = new MMX2WlanDiagServiceProxy$2(this, sWlanProperties2);
        this.proxy.remoteCallMethod((short)20, mMX2WlanDiagServiceProxy$2);
    }

    @Override
    public void responseSetWlanHotSpotActive(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }

    @Override
    public void responseWlanHotSpotActive(long l, boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }

    @Override
    public void responseWlanConnectToAP(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }
}

