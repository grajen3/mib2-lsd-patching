/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.FecAppMMXReply;
import de.esolutions.fw.comm.asi.fec.SFecState;
import de.esolutions.fw.comm.asi.fec.impl.SFecStateSerializer;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class FecAppMMXReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.fec.FecAppMMX");
    private static int dynamicHandle = 0;
    private FecAppMMXReply p_FecAppMMXReply;

    public FecAppMMXReplyService(FecAppMMXReply fecAppMMXReply) {
        super(new ServiceInstanceID("3a7a576a-0b38-45fc-9ad4-1eab302e4f5b", FecAppMMXReplyService.nextDynamicHandle(), "25185772-f55e-575f-a737-9ae88d532512", "asi.fec.FecAppMMX"));
        this.p_FecAppMMXReply = fecAppMMXReply;
    }

    private static synchronized int nextDynamicHandle() {
        int n = ++dynamicHandle;
        return n;
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 3: {
                    int n = iDeserializer.getEnum();
                    this.p_FecAppMMXReply.reportError(n);
                    break;
                }
                case 8: {
                    SFecState[] sFecStateArray = SFecStateSerializer.getOptionalSFecStateVarArray(iDeserializer);
                    this.p_FecAppMMXReply.updateFECs(sFecStateArray);
                    break;
                }
                case 1: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_FecAppMMXReply.checkPkgSignature(string, bl);
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

