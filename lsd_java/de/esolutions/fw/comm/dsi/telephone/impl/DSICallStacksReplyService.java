/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.telephone.DSICallStacksReply;
import de.esolutions.fw.comm.dsi.telephone.impl.CallStackEntrySerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.MissedCallIndicatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.telephone.CallStackEntry;
import org.dsi.ifc.telephone.MissedCallIndicator;

public class DSICallStacksReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.telephone.DSICallStacks");
    private static int dynamicHandle = 0;
    private DSICallStacksReply p_DSICallStacksReply;

    public DSICallStacksReplyService(DSICallStacksReply dSICallStacksReply) {
        super(new ServiceInstanceID("b4d4a6fb-dbca-5e1d-942b-304e14e8354d", DSICallStacksReplyService.nextDynamicHandle(), "77e0797d-7f62-56df-984f-75f67467400e", "dsi.telephone.DSICallStacks"));
        this.p_DSICallStacksReply = dSICallStacksReply;
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
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICallStacksReply.updateIsReverted(bl, n);
                    break;
                }
                case 13: {
                    CallStackEntry[] callStackEntryArray = CallStackEntrySerializer.getOptionalCallStackEntryVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICallStacksReply.updateLastAnsweredNumbers(callStackEntryArray, n);
                    break;
                }
                case 14: {
                    CallStackEntry[] callStackEntryArray = CallStackEntrySerializer.getOptionalCallStackEntryVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICallStacksReply.updateLastDialedNumbers(callStackEntryArray, n);
                    break;
                }
                case 17: {
                    CallStackEntry[] callStackEntryArray = CallStackEntrySerializer.getOptionalCallStackEntryVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICallStacksReply.updateMissedNumbers(callStackEntryArray, n);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSICallStacksReply.updateMEDataValidity(n, n2);
                    break;
                }
                case 16: {
                    MissedCallIndicator missedCallIndicator = MissedCallIndicatorSerializer.getOptionalMissedCallIndicator(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICallStacksReply.updateMissedCallIndicator(missedCallIndicator, n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSICallStacksReply.asyncException(n, string, n3);
                    break;
                }
                case 18: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSICallStacksReply.yyIndication(string, string2);
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

