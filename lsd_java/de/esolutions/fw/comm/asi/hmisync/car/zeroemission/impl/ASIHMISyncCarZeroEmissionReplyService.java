/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl;

import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.ASIHMISyncCarZeroEmissionReply;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.ZeroEmissionEntry;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl.ZeroEmissionEntrySerializer;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncCarZeroEmissionReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.car.zeroemission.ASIHMISyncCarZeroEmission");
    private static int dynamicHandle = 0;
    private ASIHMISyncCarZeroEmissionReply p_ASIHMISyncCarZeroEmissionReply;

    public ASIHMISyncCarZeroEmissionReplyService(ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply) {
        super(new ServiceInstanceID("83464154-9032-473d-b4c8-2dac866dcb2a", ASIHMISyncCarZeroEmissionReplyService.nextDynamicHandle(), "49028b78-c4f4-5526-896b-c466f65870bd", "asi.hmisync.car.zeroemission.ASIHMISyncCarZeroEmission"));
        this.p_ASIHMISyncCarZeroEmissionReply = aSIHMISyncCarZeroEmissionReply;
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
                case 6: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarZeroEmissionReply.updateASIVersion(string, bl);
                    break;
                }
                case 9: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarZeroEmissionReply.updateRequestIDs(sArray, bl);
                    break;
                }
                case 8: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarZeroEmissionReply.updateReplyIDs(sArray, bl);
                    break;
                }
                case 11: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarZeroEmissionReply.updateZEVisibilityState(n, bl);
                    break;
                }
                case 10: {
                    ZeroEmissionEntry[] zeroEmissionEntryArray = ZeroEmissionEntrySerializer.getOptionalZeroEmissionEntryVarArray(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarZeroEmissionReply.updateZeroEmissionValues(zeroEmissionEntryArray, bl);
                    break;
                }
                case 7: {
                    ZeroEmissionEntry zeroEmissionEntry = ZeroEmissionEntrySerializer.getOptionalZeroEmissionEntry(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarZeroEmissionReply.updateCurrentZeroEmissionValue(zeroEmissionEntry, bl);
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

