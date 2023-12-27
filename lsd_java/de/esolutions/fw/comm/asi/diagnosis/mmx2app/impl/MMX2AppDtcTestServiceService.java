/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sTestStatusSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sTestStatus;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2AppDtcTestServiceS;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2AppDtcTestServiceReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2AppDtcTestServiceService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2AppDtcTestService");
    private MMX2AppDtcTestServiceS p_MMX2AppDtcTestService;

    public MMX2AppDtcTestServiceService(int n, MMX2AppDtcTestServiceS mMX2AppDtcTestServiceS) {
        super(new ServiceInstanceID("4ab484de-3b10-4a6a-aa60-18bfc5c3235b", n, "45d3480f-8a52-5f5e-a109-695d43a1f88e", "asi.diagnosis.mmx2app.MMX2AppDtcTestService"));
        this.p_MMX2AppDtcTestService = mMX2AppDtcTestServiceS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new MMX2AppDtcTestServiceReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 9: {
                    int n = iDeserializer.getEnum();
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_MMX2AppDtcTestService.registerForDiagnosis(n, lArray, (MMX2AppDtcTestServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 0: {
                    this.p_MMX2AppDtcTestService.deregisterForDiagnosis((MMX2AppDtcTestServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 10: {
                    sTestStatus sTestStatus2 = sTestStatusSerializer.getOptionalsTestStatus(iDeserializer);
                    this.p_MMX2AppDtcTestService.testStatus(sTestStatus2, (MMX2AppDtcTestServiceReplyProxy)iProxyFrontend);
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

