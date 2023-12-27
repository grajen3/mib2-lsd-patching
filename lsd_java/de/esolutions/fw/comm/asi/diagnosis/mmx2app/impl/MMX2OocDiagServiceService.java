/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sClientResponseErrorSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sRoutineResponseSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2OocDiagServiceS;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2OocDiagServiceReplyProxy;
import de.esolutions.fw.comm.asi.diagnosis.ooc.impl.sTemperatureMMXSerializer;
import de.esolutions.fw.comm.asi.diagnosis.ooc.sTemperatureMMX;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2OocDiagServiceService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2OocDiagService");
    private MMX2OocDiagServiceS p_MMX2OocDiagService;

    public MMX2OocDiagServiceService(int n, MMX2OocDiagServiceS mMX2OocDiagServiceS) {
        super(new ServiceInstanceID("09c63284-f374-4fbe-89ea-924e201190ad", n, "24561f40-b427-5b46-a327-ce4029a7b7b0", "asi.diagnosis.mmx2app.MMX2OocDiagService"));
        this.p_MMX2OocDiagService = mMX2OocDiagServiceS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new MMX2OocDiagServiceReplyProxy();
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
                    this.p_MMX2OocDiagService.responseErrorOoc(sClientResponseError2, (MMX2OocDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    sTemperatureMMX sTemperatureMMX2 = sTemperatureMMXSerializer.getOptionalsTemperatureMMX(iDeserializer);
                    this.p_MMX2OocDiagService.responseTemperatureMMX(sTemperatureMMX2, (MMX2OocDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 5: {
                    sRoutineResponse sRoutineResponse2 = sRoutineResponseSerializer.getOptionalsRoutineResponse(iDeserializer);
                    this.p_MMX2OocDiagService.responseDeleteMemory(sRoutineResponse2, (MMX2OocDiagServiceReplyProxy)iProxyFrontend);
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

