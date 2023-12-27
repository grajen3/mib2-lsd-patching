/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.networking.DSIDataConfigurationReply;
import de.esolutions.fw.comm.dsi.networking.impl.CDataProfileSerializer;
import de.esolutions.fw.comm.dsi.networking.impl.CPacketCounterSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.networking.CDataProfile;
import org.dsi.ifc.networking.CPacketCounter;

public class DSIDataConfigurationReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.networking.DSIDataConfiguration");
    private static int dynamicHandle = 0;
    private DSIDataConfigurationReply p_DSIDataConfigurationReply;

    public DSIDataConfigurationReplyService(DSIDataConfigurationReply dSIDataConfigurationReply) {
        super(new ServiceInstanceID("f9fb7e79-4d84-5a34-a680-170dceb55106", DSIDataConfigurationReplyService.nextDynamicHandle(), "c8650c36-f6c5-5d60-9989-d1f0620ec7e8", "dsi.networking.DSIDataConfiguration"));
        this.p_DSIDataConfigurationReply = dSIDataConfigurationReply;
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
                case 38: {
                    CDataProfile[] cDataProfileArray = CDataProfileSerializer.getOptionalCDataProfileVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDataConfigurationReply.updateAvailableProfiles(cDataProfileArray, n);
                    break;
                }
                case 25: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIDataConfigurationReply.updateActiveProfile(n, n2);
                    break;
                }
                case 32: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIDataConfigurationReply.updateRoamingState(n, n3);
                    break;
                }
                case 27: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIDataConfigurationReply.updateConnectionMode(n, n4);
                    break;
                }
                case 28: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIDataConfigurationReply.updateDataRequest(n, n5);
                    break;
                }
                case 31: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIDataConfigurationReply.updateRequestSetting(n, n6, n7);
                    break;
                }
                case 37: {
                    CDataProfile cDataProfile = CDataProfileSerializer.getOptionalCDataProfile(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDataConfigurationReply.setDataProfileResponse(cDataProfile, n);
                    break;
                }
                case 35: {
                    int n = iDeserializer.getInt32();
                    CDataProfile cDataProfile = CDataProfileSerializer.getOptionalCDataProfile(iDeserializer);
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIDataConfigurationReply.automaticProfileResponse(n, cDataProfile, n8);
                    break;
                }
                case 24: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIDataConfigurationReply.setRoamingStateResponse(n);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIDataConfigurationReply.setConnectionModeResponse(n);
                    break;
                }
                case 22: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIDataConfigurationReply.setRequestSettingResponse(n);
                    break;
                }
                case 1: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIDataConfigurationReply.acceptDataRequestResponse(n);
                    break;
                }
                case 11: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIDataConfigurationReply.resetPacketCounterResponse(n);
                    break;
                }
                case 13: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIDataConfigurationReply.restoreFactorySettingsResponse(n);
                    break;
                }
                case 29: {
                    CPacketCounter cPacketCounter = CPacketCounterSerializer.getOptionalCPacketCounter(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDataConfigurationReply.updatePacketCounter(cPacketCounter, n);
                    break;
                }
                case 2: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSIDataConfigurationReply.asyncException(n, string, n9);
                    break;
                }
                case 33: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIDataConfigurationReply.yyIndication(string, string2);
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

