/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sClientResponseErrorSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.displaymanager.impl.sTrunkOfferFBASSerializer;
import de.esolutions.fw.comm.asi.diagnosis.displaymanager.impl.sVideoInputStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.displaymanager.sTrunkOfferFBAS;
import de.esolutions.fw.comm.asi.diagnosis.displaymanager.sVideoInputState;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2DisplayManagerDiagServiceS;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2DisplayManagerDiagServiceReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2DisplayManagerDiagServiceService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2DisplayManagerDiagService");
    private MMX2DisplayManagerDiagServiceS p_MMX2DisplayManagerDiagService;

    public MMX2DisplayManagerDiagServiceService(int n, MMX2DisplayManagerDiagServiceS mMX2DisplayManagerDiagServiceS) {
        super(new ServiceInstanceID("d9796ad7-dbdb-4a6a-91b8-87d2003632af", n, "ce357906-130f-5933-baca-79721aa7173a", "asi.diagnosis.mmx2app.MMX2DisplayManagerDiagService"));
        this.p_MMX2DisplayManagerDiagService = mMX2DisplayManagerDiagServiceS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new MMX2DisplayManagerDiagServiceReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 16: {
                    sClientResponseError sClientResponseError2 = sClientResponseErrorSerializer.getOptionalsClientResponseError(iDeserializer);
                    this.p_MMX2DisplayManagerDiagService.responseErrorDisplayManager(sClientResponseError2, (MMX2DisplayManagerDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 13: {
                    sVideoInputState sVideoInputState2 = sVideoInputStateSerializer.getOptionalsVideoInputState(iDeserializer);
                    this.p_MMX2DisplayManagerDiagService.responseVideoInputState(sVideoInputState2, (MMX2DisplayManagerDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 12: {
                    sTrunkOfferFBAS sTrunkOfferFBAS2 = sTrunkOfferFBASSerializer.getOptionalsTrunkOfferFBAS(iDeserializer);
                    this.p_MMX2DisplayManagerDiagService.responseTrunkOfferFBAS(sTrunkOfferFBAS2, (MMX2DisplayManagerDiagServiceReplyProxy)iProxyFrontend);
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

