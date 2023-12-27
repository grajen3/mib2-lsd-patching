/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs.impl;

import de.esolutions.fw.comm.asi.navigation.ncfs.NCFSProviderReply;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sBoundingBoxSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sEdgeSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sLGIEventSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sRestrictionSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sTileInfoSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.sBoundingBox;
import de.esolutions.fw.comm.asi.navigation.ncfs.sEdge;
import de.esolutions.fw.comm.asi.navigation.ncfs.sLGIEvent;
import de.esolutions.fw.comm.asi.navigation.ncfs.sRestriction;
import de.esolutions.fw.comm.asi.navigation.ncfs.sTileInfo;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class NCFSProviderReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.navigation.ncfs.NCFSProvider");
    private static int dynamicHandle = 0;
    private NCFSProviderReply p_NCFSProviderReply;

    public NCFSProviderReplyService(NCFSProviderReply nCFSProviderReply) {
        super(new ServiceInstanceID("7114efbf-e1b7-4c0f-a8ef-4e4718806d54", NCFSProviderReplyService.nextDynamicHandle(), "45c3e4f9-004e-561f-92cf-4451d9da24ab", "asi.navigation.ncfs.NCFSProvider"));
        this.p_NCFSProviderReply = nCFSProviderReply;
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
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    sBoundingBox sBoundingBox2 = sBoundingBoxSerializer.getOptionalsBoundingBox(iDeserializer);
                    int n = iDeserializer.getEnum();
                    this.p_NCFSProviderReply.updateVZOTileIndexes(nArray, sBoundingBox2, n);
                    break;
                }
                case 16: {
                    sTileInfo[] sTileInfoArray = sTileInfoSerializer.getOptionalsTileInfoVarArray(iDeserializer);
                    sEdge[] sEdgeArray = sEdgeSerializer.getOptionalsEdgeVarArray(iDeserializer);
                    sRestriction[] sRestrictionArray = sRestrictionSerializer.getOptionalsRestrictionVarArray(iDeserializer);
                    int n = iDeserializer.getEnum();
                    this.p_NCFSProviderReply.updateVZORestrictions(sTileInfoArray, sEdgeArray, sRestrictionArray, n);
                    break;
                }
                case 3: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    sBoundingBox sBoundingBox3 = sBoundingBoxSerializer.getOptionalsBoundingBox(iDeserializer);
                    int n = iDeserializer.getEnum();
                    this.p_NCFSProviderReply.updateLGITileIndexes(nArray, sBoundingBox3, n);
                    break;
                }
                case 15: {
                    sTileInfo[] sTileInfoArray = sTileInfoSerializer.getOptionalsTileInfoVarArray(iDeserializer);
                    sLGIEvent[] sLGIEventArray = sLGIEventSerializer.getOptionalsLGIEventVarArray(iDeserializer);
                    int n = iDeserializer.getEnum();
                    this.p_NCFSProviderReply.updateLGIEvents(sTileInfoArray, sLGIEventArray, n);
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

