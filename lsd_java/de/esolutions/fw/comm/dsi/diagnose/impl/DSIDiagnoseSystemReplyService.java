/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.diagnose.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.diagnose.DSIDiagnoseSystemReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIDiagnoseSystemReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.diagnose.DSIDiagnoseSystem");
    private static int dynamicHandle = 0;
    private DSIDiagnoseSystemReply p_DSIDiagnoseSystemReply;

    public DSIDiagnoseSystemReplyService(DSIDiagnoseSystemReply dSIDiagnoseSystemReply) {
        super(new ServiceInstanceID("7128b77d-0ce1-5205-bd4b-a30f854ae2cb", DSIDiagnoseSystemReplyService.nextDynamicHandle(), "7c1fb9de-e446-595e-98c6-4a9038900c37", "dsi.diagnose.DSIDiagnoseSystem"));
        this.p_DSIDiagnoseSystemReply = dSIDiagnoseSystemReply;
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
                case 12: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIDiagnoseSystemReply.updateDiagnosticValueChanged(n, l, n2);
                    break;
                }
                case 7: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSIDiagnoseSystemReply.requestRoutine(n, n3, n4, nArray);
                    break;
                }
                case 6: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSIDiagnoseSystemReply.requestActuatorTest(n, n5, n6, n7, nArray);
                    break;
                }
                case 2: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIDiagnoseSystemReply.asyncException(n, string, n8);
                    break;
                }
                case 13: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIDiagnoseSystemReply.yyIndication(string, string2);
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

