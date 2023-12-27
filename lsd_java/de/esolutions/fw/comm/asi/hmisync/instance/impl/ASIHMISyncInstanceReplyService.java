/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.instance.impl;

import de.esolutions.fw.comm.asi.hmisync.instance.ASIHMISyncInstanceReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncInstanceReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.instance.ASIHMISyncInstance");
    private static int dynamicHandle = 0;
    private ASIHMISyncInstanceReply p_ASIHMISyncInstanceReply;

    public ASIHMISyncInstanceReplyService(ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        super(new ServiceInstanceID("33835c21-9cd6-4b66-a078-9209b43a1b61", ASIHMISyncInstanceReplyService.nextDynamicHandle(), "15181a2f-42ba-55da-a0d1-172a25018685", "asi.hmisync.instance.ASIHMISyncInstance"));
        this.p_ASIHMISyncInstanceReply = aSIHMISyncInstanceReply;
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
                case 4: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_ASIHMISyncInstanceReply.responseInstanceId(string, string2, n, n2);
                    break;
                }
                case 8: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncInstanceReply.updateASIVersion(string, bl);
                    break;
                }
                case 10: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncInstanceReply.updateRequestIDs(sArray, bl);
                    break;
                }
                case 9: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncInstanceReply.updateReplyIDs(sArray, bl);
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

