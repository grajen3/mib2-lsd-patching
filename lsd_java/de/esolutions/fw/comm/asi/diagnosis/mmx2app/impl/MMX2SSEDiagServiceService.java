/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sClientResponseErrorSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SSEDiagServiceS;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2SSEDiagServiceReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2SSEDiagServiceService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2SSEDiagService");
    private MMX2SSEDiagServiceS p_MMX2SSEDiagService;

    public MMX2SSEDiagServiceService(int n, MMX2SSEDiagServiceS mMX2SSEDiagServiceS) {
        super(new ServiceInstanceID("244251e4-1310-11e4-b506-bf7ecd99c5a4", n, "2fd4d7ca-1076-542d-af3f-1bc9d3bd54a8", "asi.diagnosis.mmx2app.MMX2SSEDiagService"));
        this.p_MMX2SSEDiagService = mMX2SSEDiagServiceS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new MMX2SSEDiagServiceReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 2: {
                    sClientResponseError sClientResponseError2 = sClientResponseErrorSerializer.getOptionalsClientResponseError(iDeserializer);
                    this.p_MMX2SSEDiagService.responseErrorSSE(sClientResponseError2, (MMX2SSEDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 1: {
                    long l = iDeserializer.getUInt32();
                    long l2 = iDeserializer.getUInt32();
                    this.p_MMX2SSEDiagService.responseClippingCounterMic1(l, l2, (MMX2SSEDiagServiceReplyProxy)iProxyFrontend);
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

