/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.NavRectangleSerializer;
import de.esolutions.fw.comm.dsi.navigation.DSIBlockingReply;
import de.esolutions.fw.comm.dsi.navigation.impl.BlockElementSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.BlockElement;

public class DSIBlockingReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.navigation.DSIBlocking");
    private static int dynamicHandle = 0;
    private DSIBlockingReply p_DSIBlockingReply;

    public DSIBlockingReplyService(DSIBlockingReply dSIBlockingReply) {
        super(new ServiceInstanceID("6afc3000-ee79-58d1-bd7b-c2ed0e0804bd", DSIBlockingReplyService.nextDynamicHandle(), "4d4866c8-b77a-58e3-89ce-99092a93d36f", "dsi.navigation.DSIBlocking"));
        this.p_DSIBlockingReply = dSIBlockingReply;
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
                case 23: {
                    BlockElement[] blockElementArray = BlockElementSerializer.getOptionalBlockElementVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIBlockingReply.updateListOfBlocks(blockElementArray, n);
                    break;
                }
                case 30: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIBlockingReply.updateNaviCoreAvailableToSetBlocks(n, n2);
                    break;
                }
                case 26: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIBlockingReply.updateMaximumNumberOfBlockedAreas(n, n3);
                    break;
                }
                case 28: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIBlockingReply.updateMaximumNumberOfBlockedRouteSegments(n, n4);
                    break;
                }
                case 27: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIBlockingReply.updateMaximumNumberOfBlockedRoadSegments(n, n5);
                    break;
                }
                case 24: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIBlockingReply.updateMaximumDimensionsOfBlockedArea(n, n6, n7);
                    break;
                }
                case 29: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIBlockingReply.updateMaximumSegmentLengthOfBlockedRouteSegment(n, n8);
                    break;
                }
                case 25: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSIBlockingReply.updateMaximumLengthOfBlockRouteBasedOnLength(n, n9);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSIBlockingReply.blockAreaResult(l, n);
                    break;
                }
                case 8: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSIBlockingReply.blockRouteSegmentsResult(l, n);
                    break;
                }
                case 4: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSIBlockingReply.blockRoadSegmentsResult(l, n);
                    break;
                }
                case 6: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSIBlockingReply.blockRouteBasedOnLengthResult(l, n);
                    break;
                }
                case 17: {
                    long[] lArray = iDeserializer.getOptionalInt64VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSIBlockingReply.persistBlockResult(lArray, n);
                    break;
                }
                case 13: {
                    long[] lArray = iDeserializer.getOptionalInt64VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSIBlockingReply.deleteBlockResult(lArray, n);
                    break;
                }
                case 19: {
                    long[] lArray = iDeserializer.getOptionalInt64VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSIBlockingReply.setBlockDescriptionResult(lArray, n);
                    break;
                }
                case 33: {
                    long[] lArray = iDeserializer.getOptionalInt64VarArray();
                    NavRectangle navRectangle = NavRectangleSerializer.getOptionalNavRectangle(iDeserializer);
                    this.p_DSIBlockingReply.getBoundingRectangleOfBlocksResult(lArray, navRectangle);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSIBlockingReply.asyncException(n, string, n10);
                    break;
                }
                case 31: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIBlockingReply.yyIndication(string, string2);
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

