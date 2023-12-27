/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mobilityhorizon.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.mobilityhorizon.DSIMobilityHorizonReply;
import de.esolutions.fw.comm.dsi.mobilityhorizon.impl.MobilityHorizonLocationSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation;

public class DSIMobilityHorizonReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.mobilityhorizon.DSIMobilityHorizon");
    private static int dynamicHandle = 0;
    private DSIMobilityHorizonReply p_DSIMobilityHorizonReply;

    public DSIMobilityHorizonReplyService(DSIMobilityHorizonReply dSIMobilityHorizonReply) {
        super(new ServiceInstanceID("7d847e9a-3c9b-5a2c-b62d-7f65852518ec", DSIMobilityHorizonReplyService.nextDynamicHandle(), "b0185ce3-3de1-549a-8790-709b4294a359", "dsi.mobilityhorizon.DSIMobilityHorizon"));
        this.p_DSIMobilityHorizonReply = dSIMobilityHorizonReply;
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
                case 11: {
                    MobilityHorizonLocation[] mobilityHorizonLocationArray = MobilityHorizonLocationSerializer.getOptionalMobilityHorizonLocationVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobilityHorizonReply.updateLocations(mobilityHorizonLocationArray, n);
                    break;
                }
                case 10: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobilityHorizonReply.updateConsideredLocationTypes(nArray, n);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIMobilityHorizonReply.updateDriveTrainMode(n, n2);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIMobilityHorizonReply.updateMobilityHorizonStatus(n, n3);
                    break;
                }
                case 19: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIMobilityHorizonReply.requestLocationRangeLevelResult(n, n4);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobilityHorizonReply.locationRangeLevelChanged(n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIMobilityHorizonReply.asyncException(n, string, n5);
                    break;
                }
                case 12: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIMobilityHorizonReply.yyIndication(string, string2);
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

