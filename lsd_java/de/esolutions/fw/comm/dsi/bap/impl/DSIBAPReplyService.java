/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.bap.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.bap.DSIBAPReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIBAPReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.bap.DSIBAP");
    private static int dynamicHandle = 0;
    private DSIBAPReply p_DSIBAPReply;

    public DSIBAPReplyService(DSIBAPReply dSIBAPReply) {
        super(new ServiceInstanceID("187b8dba-bafe-54d9-bd32-ccc4dc6d16c7", DSIBAPReplyService.nextDynamicHandle(), "e99f0395-02b6-5a98-9d51-8714b5fcad80", "dsi.bap.DSIBAP"));
        this.p_DSIBAPReply = dSIBAPReply;
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
                case 2: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIBAPReply.bapStateStatus(n, n2);
                    break;
                }
                case 7: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIBAPReply.indication(n, n3, n4, n5, n6);
                    break;
                }
                case 10: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIBAPReply.indicationVoid(n, n7, n8);
                    break;
                }
                case 8: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    byte[] byArray = iDeserializer.getOptionalInt8VarArray();
                    this.p_DSIBAPReply.indicationByteSequence(n, n9, n10, byArray);
                    break;
                }
                case 9: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSIBAPReply.indicationError(n, n11, n12);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSIBAPReply.acknowledge(n, n13, n14);
                    break;
                }
                case 1: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSIBAPReply.asyncException(n, string, n15);
                    break;
                }
                case 19: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIBAPReply.yyIndication(string, string2);
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

