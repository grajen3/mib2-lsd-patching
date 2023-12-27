/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation.impl;

import de.esolutions.fw.comm.asi.hmisync.navigation.ASIHMISyncNavigationReply;
import de.esolutions.fw.comm.asi.hmisync.navigation.CarPosition;
import de.esolutions.fw.comm.asi.hmisync.navigation.DestinationInfo;
import de.esolutions.fw.comm.asi.hmisync.navigation.NextDestinationInfo;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.CarPositionSerializer;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.DestinationInfoSerializer;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.NextDestinationInfoSerializer;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncNavigationReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.navigation.ASIHMISyncNavigation");
    private static int dynamicHandle = 0;
    private ASIHMISyncNavigationReply p_ASIHMISyncNavigationReply;

    public ASIHMISyncNavigationReplyService(ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
        super(new ServiceInstanceID("8d39242f-638c-434c-a3c2-23fe7dad4907", ASIHMISyncNavigationReplyService.nextDynamicHandle(), "85677657-50cb-53c6-b534-c27796d5fb16", "asi.hmisync.navigation.ASIHMISyncNavigation"));
        this.p_ASIHMISyncNavigationReply = aSIHMISyncNavigationReply;
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
                case 9: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncNavigationReply.startGuidanceToDestinationsResult(n);
                    break;
                }
                case 10: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncNavigationReply.updateASIVersion(string, bl);
                    break;
                }
                case 19: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncNavigationReply.updateRequestIDs(sArray, bl);
                    break;
                }
                case 18: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncNavigationReply.updateReplyIDs(sArray, bl);
                    break;
                }
                case 16: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl2 = iDeserializer.getBool();
                    this.p_ASIHMISyncNavigationReply.updateRouteGuidanceActive(bl, bl2);
                    break;
                }
                case 11: {
                    CarPosition carPosition = CarPositionSerializer.getOptionalCarPosition(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncNavigationReply.updateCarPosition(carPosition, bl);
                    break;
                }
                case 12: {
                    DestinationInfo[] destinationInfoArray = DestinationInfoSerializer.getOptionalDestinationInfoVarArray(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncNavigationReply.updateDestinationInfo(destinationInfoArray, bl);
                    break;
                }
                case 13: {
                    DestinationInfo[] destinationInfoArray = DestinationInfoSerializer.getOptionalDestinationInfoVarArray(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncNavigationReply.updateDestinationsForGuidance(destinationInfoArray, bl);
                    break;
                }
                case 15: {
                    NextDestinationInfo nextDestinationInfo = NextDestinationInfoSerializer.getOptionalNextDestinationInfo(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncNavigationReply.updateNextDestinationInfo(nextDestinationInfo, bl);
                    break;
                }
                case 17: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl3 = iDeserializer.getBool();
                    this.p_ASIHMISyncNavigationReply.updateNightDesignRequested(bl, bl3);
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

