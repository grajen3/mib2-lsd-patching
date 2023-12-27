/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync2.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.kombisync2.DSIKombiSyncReply;
import de.esolutions.fw.comm.dsi.kombisync2.impl.DisplayIdentificationSerializer;
import de.esolutions.fw.comm.dsi.kombisync2.impl.DisplayRequestResponseSerializer;
import de.esolutions.fw.comm.dsi.kombisync2.impl.DisplayStatusSerializer;
import de.esolutions.fw.comm.dsi.kombisync2.impl.PopupActionRequestResponseSerializer;
import de.esolutions.fw.comm.dsi.kombisync2.impl.PopupRegisterRequestResponseSerializer;
import de.esolutions.fw.comm.dsi.kombisync2.impl.PopupStatusSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.kombisync2.DisplayIdentification;
import org.dsi.ifc.kombisync2.DisplayRequestResponse;
import org.dsi.ifc.kombisync2.DisplayStatus;
import org.dsi.ifc.kombisync2.PopupActionRequestResponse;
import org.dsi.ifc.kombisync2.PopupRegisterRequestResponse;
import org.dsi.ifc.kombisync2.PopupStatus;

public class DSIKombiSyncReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.kombisync2.DSIKombiSync");
    private static int dynamicHandle = 0;
    private DSIKombiSyncReply p_DSIKombiSyncReply;

    public DSIKombiSyncReplyService(DSIKombiSyncReply dSIKombiSyncReply) {
        super(new ServiceInstanceID("30d4067c-4595-5e28-a2f6-cb8f9a05d616", DSIKombiSyncReplyService.nextDynamicHandle(), "286587af-7c4b-5082-b0e2-a5927520759a", "dsi.kombisync2.DSIKombiSync"));
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
                case 21: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIKombiSyncReply.updateKombiCommunicationState(bl, n);
                    break;
                }
                case 22: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIKombiSyncReply.updateKombiMessageStateDisplayIdentification(n, n2);
                    break;
                }
                case 23: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIKombiSyncReply.updateKombiMessageStateDisplayRequestResponse(n, n3);
                    break;
                }
                case 24: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIKombiSyncReply.updateKombiMessageStateDisplayStatus(n, n4);
                    break;
                }
                case 25: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIKombiSyncReply.updateKombiMessageStatePopupActionRequest(n, n5);
                    break;
                }
                case 26: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIKombiSyncReply.updateKombiMessageStatePopupRegisterResponse(n, n6);
                    break;
                }
                case 27: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIKombiSyncReply.updateKombiMessageStatePopupStatus(n, n7);
                    break;
                }
                case 5: {
                    DisplayRequestResponse displayRequestResponse = DisplayRequestResponseSerializer.getOptionalDisplayRequestResponse(iDeserializer);
                    this.p_DSIKombiSyncReply.responseKombiDisplayRequestResponse(displayRequestResponse);
                    break;
                }
                case 6: {
                    DisplayStatus displayStatus = DisplayStatusSerializer.getOptionalDisplayStatus(iDeserializer);
                    this.p_DSIKombiSyncReply.responseKombiDisplayStatus(displayStatus);
                    break;
                }
                case 4: {
                    DisplayIdentification displayIdentification = DisplayIdentificationSerializer.getOptionalDisplayIdentification(iDeserializer);
                    this.p_DSIKombiSyncReply.responseKombiDisplayIdentification(displayIdentification);
                    break;
                }
                case 8: {
                    PopupRegisterRequestResponse popupRegisterRequestResponse = PopupRegisterRequestResponseSerializer.getOptionalPopupRegisterRequestResponse(iDeserializer);
                    this.p_DSIKombiSyncReply.responseKombiPopupRegisterResponse(popupRegisterRequestResponse);
                    break;
                }
                case 7: {
                    PopupActionRequestResponse popupActionRequestResponse = PopupActionRequestResponseSerializer.getOptionalPopupActionRequestResponse(iDeserializer);
                    this.p_DSIKombiSyncReply.responseKombiPopupActionRequest(popupActionRequestResponse);
                    break;
                }
                case 9: {
                    PopupStatus popupStatus = PopupStatusSerializer.getOptionalPopupStatus(iDeserializer);
                    this.p_DSIKombiSyncReply.responseKombiPopupStatus(popupStatus);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIKombiSyncReply.asyncException(n, string, n8);
                    break;
                }
                case 28: {
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

