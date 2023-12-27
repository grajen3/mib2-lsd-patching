/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephoneng.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.telephoneng.DSIMobileEquipmentTopologyReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIMobileEquipmentTopologyReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.telephoneng.DSIMobileEquipmentTopology");
    private static int dynamicHandle = 0;
    private DSIMobileEquipmentTopologyReply p_DSIMobileEquipmentTopologyReply;

    public DSIMobileEquipmentTopologyReplyService(DSIMobileEquipmentTopologyReply dSIMobileEquipmentTopologyReply) {
        super(new ServiceInstanceID("feeabe13-beb4-557e-896d-8930e0c0a11f", DSIMobileEquipmentTopologyReplyService.nextDynamicHandle(), "32209517-73f4-5519-832e-1d0884f7b94b", "dsi.telephoneng.DSIMobileEquipmentTopology"));
        this.p_DSIMobileEquipmentTopologyReply = dSIMobileEquipmentTopologyReply;
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
                case 5: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentTopologyReply.responseChangeTopology(n);
                    break;
                }
                case 9: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentTopologyReply.updateTopology(nArray, n);
                    break;
                }
                case 12: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentTopologyReply.updateUsage(nArray, n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentTopologyReply.asyncException(n, string, n2);
                    break;
                }
                case 10: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIMobileEquipmentTopologyReply.yyIndication(string, string2);
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

