/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sClientResponseErrorSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SwdlDiagServiceS;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2SwdlDiagServiceReplyProxy;
import de.esolutions.fw.comm.asi.diagnosis.swdl.impl.sModuleVersionNumbersSerializer;
import de.esolutions.fw.comm.asi.diagnosis.swdl.sModuleVersionNumbers;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2SwdlDiagServiceService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2SwdlDiagService");
    private MMX2SwdlDiagServiceS p_MMX2SwdlDiagService;

    public MMX2SwdlDiagServiceService(int n, MMX2SwdlDiagServiceS mMX2SwdlDiagServiceS) {
        super(new ServiceInstanceID("229d40ff-d184-467e-b62b-7947f55cce40", n, "ff9a2a97-610f-5d16-aa8f-2c4cc52cde72", "asi.diagnosis.mmx2app.MMX2SwdlDiagService"));
        this.p_MMX2SwdlDiagService = mMX2SwdlDiagServiceS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new MMX2SwdlDiagServiceReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 8: {
                    sClientResponseError sClientResponseError2 = sClientResponseErrorSerializer.getOptionalsClientResponseError(iDeserializer);
                    this.p_MMX2SwdlDiagService.responseErrorSwdl(sClientResponseError2, (MMX2SwdlDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    sModuleVersionNumbers sModuleVersionNumbers2 = sModuleVersionNumbersSerializer.getOptionalsModuleVersionNumbers(iDeserializer);
                    this.p_MMX2SwdlDiagService.responseModuleVersionNumbers(sModuleVersionNumbers2, (MMX2SwdlDiagServiceReplyProxy)iProxyFrontend);
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

