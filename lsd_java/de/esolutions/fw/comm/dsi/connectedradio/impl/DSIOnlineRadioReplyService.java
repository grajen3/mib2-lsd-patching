/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.connectedradio.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.connectedradio.DSIOnlineRadioReply;
import de.esolutions.fw.comm.dsi.connectedradio.impl.RadioStationSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.connectedradio.RadioStation;

public class DSIOnlineRadioReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.connectedradio.DSIOnlineRadio");
    private static int dynamicHandle = 0;
    private DSIOnlineRadioReply p_DSIOnlineRadioReply;

    public DSIOnlineRadioReplyService(DSIOnlineRadioReply dSIOnlineRadioReply) {
        super(new ServiceInstanceID("67900ab4-039a-59dd-9141-ca1a0fb8a2bf", DSIOnlineRadioReplyService.nextDynamicHandle(), "cda08e84-495a-5b75-83b5-00f0e4603808", "dsi.connectedradio.DSIOnlineRadio"));
        this.p_DSIOnlineRadioReply = dSIOnlineRadioReply;
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
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    RadioStation radioStation = RadioStationSerializer.getOptionalRadioStation(iDeserializer);
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIOnlineRadioReply.getRadioStationLogoResult(n, n2, radioStation, n3);
                    break;
                }
                case 13: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    RadioStation radioStation = RadioStationSerializer.getOptionalRadioStation(iDeserializer);
                    this.p_DSIOnlineRadioReply.getStreamUrlResult(n, n4, radioStation);
                    break;
                }
                case 9: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    RadioStation radioStation = RadioStationSerializer.getOptionalRadioStation(iDeserializer);
                    this.p_DSIOnlineRadioReply.getMetaInformationResult(n, n5, radioStation);
                    break;
                }
                case 7: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIOnlineRadioReply.downloadDatabaseResult(n, n6);
                    break;
                }
                case 2: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIOnlineRadioReply.cancelDownloadDatabaseResult(n, n7);
                    break;
                }
                case 27: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSIOnlineRadioReply.updateProfileState(n, n8, n9);
                    break;
                }
                case 20: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSIOnlineRadioReply.profileChanged(n, n10);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSIOnlineRadioReply.profileCopied(n, n11, n12);
                    break;
                }
                case 24: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSIOnlineRadioReply.profileReset(n, n13);
                    break;
                }
                case 26: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineRadioReply.profileResetAll(n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSIOnlineRadioReply.asyncException(n, string, n14);
                    break;
                }
                case 17: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIOnlineRadioReply.yyIndication(string, string2);
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

