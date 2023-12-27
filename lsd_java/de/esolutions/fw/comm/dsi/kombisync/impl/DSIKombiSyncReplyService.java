/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.kombisync.DSIKombiSyncReply;
import de.esolutions.fw.comm.dsi.kombisync.impl.KombiDisplayRequestSerializer;
import de.esolutions.fw.comm.dsi.kombisync.impl.KombiDisplayStatusSerializer;
import de.esolutions.fw.comm.dsi.kombisync.impl.KombiPopupStatusSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.kombisync.KombiDisplayRequest;
import org.dsi.ifc.kombisync.KombiDisplayStatus;
import org.dsi.ifc.kombisync.KombiPopupStatus;

public class DSIKombiSyncReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.kombisync.DSIKombiSync");
    private static int dynamicHandle = 0;
    private DSIKombiSyncReply p_DSIKombiSyncReply;

    public DSIKombiSyncReplyService(DSIKombiSyncReply dSIKombiSyncReply) {
        super(new ServiceInstanceID("40d02636-2ab7-567a-9154-88be065dffaf", DSIKombiSyncReplyService.nextDynamicHandle(), "537ae951-1aea-55dd-a1d3-eb95ccc3ecd3", "dsi.kombisync.DSIKombiSync"));
        this.p_DSIKombiSyncReply = dSIKombiSyncReply;
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
                case 15: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIKombiSyncReply.updateKombiCommunicationState(bl, n);
                    break;
                }
                case 26: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIKombiSyncReply.updateKombiMessageStateDisplayStatus(n, n2);
                    break;
                }
                case 25: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIKombiSyncReply.updateKombiMessageStateDisplayRequest(n, n3);
                    break;
                }
                case 27: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIKombiSyncReply.updateKombiMessageStatePopupStatus(n, n4);
                    break;
                }
                case 34: {
                    KombiDisplayStatus kombiDisplayStatus = KombiDisplayStatusSerializer.getOptionalKombiDisplayStatus(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIKombiSyncReply.responseKombiDisplayStatus(kombiDisplayStatus, n);
                    break;
                }
                case 33: {
                    KombiDisplayRequest kombiDisplayRequest = KombiDisplayRequestSerializer.getOptionalKombiDisplayRequest(iDeserializer);
                    this.p_DSIKombiSyncReply.responseKombiDisplayRequest(kombiDisplayRequest);
                    break;
                }
                case 39: {
                    KombiPopupStatus kombiPopupStatus = KombiPopupStatusSerializer.getOptionalKombiPopupStatus(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIKombiSyncReply.responseKombiPopupStatus(kombiPopupStatus, n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIKombiSyncReply.asyncException(n, string, n5);
                    break;
                }
                case 16: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIKombiSyncReply.yyIndication(string, string2);
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

