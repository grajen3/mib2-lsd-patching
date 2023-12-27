/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sClientResponseErrorSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2WlanDiagServiceS;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2WlanDiagServiceReplyProxy;
import de.esolutions.fw.comm.asi.diagnosis.wlan.impl.sWlanPropertiesSerializer;
import de.esolutions.fw.comm.asi.diagnosis.wlan.sWlanProperties;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2WlanDiagServiceService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2WlanDiagService");
    private MMX2WlanDiagServiceS p_MMX2WlanDiagService;

    public MMX2WlanDiagServiceService(int n, MMX2WlanDiagServiceS mMX2WlanDiagServiceS) {
        super(new ServiceInstanceID("2ffff5fe-3ecc-4e5e-a640-76dd6851b878", n, "1be1b0ee-6e07-530b-8fc9-ff8327651d0c", "asi.diagnosis.mmx2app.MMX2WlanDiagService"));
        this.p_MMX2WlanDiagService = mMX2WlanDiagServiceS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new MMX2WlanDiagServiceReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 24: {
                    sClientResponseError sClientResponseError2 = sClientResponseErrorSerializer.getOptionalsClientResponseError(iDeserializer);
                    this.p_MMX2WlanDiagService.responseErrorWlan(sClientResponseError2, (MMX2WlanDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 20: {
                    sWlanProperties sWlanProperties2 = sWlanPropertiesSerializer.getOptionalsWlanProperties(iDeserializer);
                    this.p_MMX2WlanDiagService.responseWlanProperties(sWlanProperties2, (MMX2WlanDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 17: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2WlanDiagService.responseSetWlanHotSpotActive(l, (MMX2WlanDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 19: {
                    long l = iDeserializer.getUInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_MMX2WlanDiagService.responseWlanHotSpotActive(l, bl, (MMX2WlanDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 18: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2WlanDiagService.responseWlanConnectToAP(l, (MMX2WlanDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s).append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}

