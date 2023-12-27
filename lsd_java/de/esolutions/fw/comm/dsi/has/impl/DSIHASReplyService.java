/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.has.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.has.DSIHASReply;
import de.esolutions.fw.comm.dsi.has.impl.HASDataContainerSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.has.HASDataContainer;

public class DSIHASReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.has.DSIHAS");
    private static int dynamicHandle = 0;
    private DSIHASReply p_DSIHASReply;

    public DSIHASReplyService(DSIHASReply dSIHASReply) {
        super(new ServiceInstanceID("e8b825cb-88b6-5891-b307-10ee3b08dd9c", DSIHASReplyService.nextDynamicHandle(), "184e7a94-37bf-56cc-890e-bf8fe7451678", "dsi.has.DSIHAS"));
        this.p_DSIHASReply = dSIHASReply;
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
                case 21: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    HASDataContainer[] hASDataContainerArray = HASDataContainerSerializer.getOptionalHASDataContainerVarArray(iDeserializer);
                    this.p_DSIHASReply.actionRequest(n, n2, hASDataContainerArray);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIHASReply.subscribeRequest(n, n3);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIHASReply.unsubscribeRequest(n);
                    break;
                }
                case 14: {
                    this.p_DSIHASReply.unsubscribeAllRequest();
                    break;
                }
                case 6: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIHASReply.getPropertyRequest(n);
                    break;
                }
                case 2: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIHASReply.asyncException(n, string, n4);
                    break;
                }
                case 16: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIHASReply.yyIndication(string, string2);
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

