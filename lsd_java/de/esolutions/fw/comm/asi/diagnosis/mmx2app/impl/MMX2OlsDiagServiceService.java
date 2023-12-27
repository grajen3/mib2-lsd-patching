/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sClientResponseErrorSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2OlsDiagServiceS;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2OlsDiagServiceReplyProxy;
import de.esolutions.fw.comm.asi.diagnosis.ols.impl.sActivationStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.ols.impl.sConnectionStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.ols.sActivationState;
import de.esolutions.fw.comm.asi.diagnosis.ols.sConnectionState;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2OlsDiagServiceService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2OlsDiagService");
    private MMX2OlsDiagServiceS p_MMX2OlsDiagService;

    public MMX2OlsDiagServiceService(int n, MMX2OlsDiagServiceS mMX2OlsDiagServiceS) {
        super(new ServiceInstanceID("424a4ae2-a7c9-4146-810b-30406bca0fdc", n, "e8d46886-db30-5882-ad53-07b965ab808b", "asi.diagnosis.mmx2app.MMX2OlsDiagService"));
        this.p_MMX2OlsDiagService = mMX2OlsDiagServiceS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new MMX2OlsDiagServiceReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 7: {
                    sClientResponseError sClientResponseError2 = sClientResponseErrorSerializer.getOptionalsClientResponseError(iDeserializer);
                    this.p_MMX2OlsDiagService.responseErrorOls(sClientResponseError2, (MMX2OlsDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 6: {
                    sConnectionState sConnectionState2 = sConnectionStateSerializer.getOptionalsConnectionState(iDeserializer);
                    this.p_MMX2OlsDiagService.responseConnectionState(sConnectionState2, (MMX2OlsDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 5: {
                    sActivationState sActivationState2 = sActivationStateSerializer.getOptionalsActivationState(iDeserializer);
                    this.p_MMX2OlsDiagService.responseActivationState(sActivationState2, (MMX2OlsDiagServiceReplyProxy)iProxyFrontend);
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

