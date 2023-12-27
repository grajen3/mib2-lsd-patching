/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.online.DSIOperatorCallReply;
import de.esolutions.fw.comm.dsi.online.impl.OperatorCallResultSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.online.OperatorCallResult;

public class DSIOperatorCallReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.online.DSIOperatorCall");
    private static int dynamicHandle = 0;
    private DSIOperatorCallReply p_DSIOperatorCallReply;

    public DSIOperatorCallReplyService(DSIOperatorCallReply dSIOperatorCallReply) {
        super(new ServiceInstanceID("1f7c2f4e-9ee9-51d8-bc8d-f8217b5da57e", DSIOperatorCallReplyService.nextDynamicHandle(), "2d39ebd3-2cbc-582c-92a3-833b2cadd715", "dsi.online.DSIOperatorCall"));
        this.p_DSIOperatorCallReply = dSIOperatorCallReply;
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
                case 16: {
                    int n = iDeserializer.getInt32();
                    OperatorCallResult[] operatorCallResultArray = OperatorCallResultSerializer.getOptionalOperatorCallResultVarArray(iDeserializer);
                    this.p_DSIOperatorCallReply.responseOperatorCallResult(n, operatorCallResultArray);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIOperatorCallReply.responseOperatorPhoneNumber(n, string, stringArray, n2);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIOperatorCallReply.asyncException(n, string, n3);
                    break;
                }
                case 12: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIOperatorCallReply.yyIndication(string, string2);
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

