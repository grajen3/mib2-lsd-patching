/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.androidauto.DSIAndroidAutoReply;
import de.esolutions.fw.comm.dsi.androidauto.impl.AppStateRequestSerializer;
import de.esolutions.fw.comm.dsi.androidauto.impl.AppStateSerializer;
import de.esolutions.fw.comm.dsi.androidauto.impl.CallStateSerializer;
import de.esolutions.fw.comm.dsi.androidauto.impl.PlaybackInfoSerializer;
import de.esolutions.fw.comm.dsi.androidauto.impl.ResourceRequestSerializer;
import de.esolutions.fw.comm.dsi.androidauto.impl.ResourceSerializer;
import de.esolutions.fw.comm.dsi.androidauto.impl.TelephonyStateSerializer;
import de.esolutions.fw.comm.dsi.androidauto.impl.TrackDataSerializer;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.androidauto.AppState;
import org.dsi.ifc.androidauto.AppStateRequest;
import org.dsi.ifc.androidauto.CallState;
import org.dsi.ifc.androidauto.PlaybackInfo;
import org.dsi.ifc.androidauto.Resource;
import org.dsi.ifc.androidauto.ResourceRequest;
import org.dsi.ifc.androidauto.TelephonyState;
import org.dsi.ifc.androidauto.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public class DSIAndroidAutoReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.androidauto.DSIAndroidAuto");
    private static int dynamicHandle = 0;
    private DSIAndroidAutoReply p_DSIAndroidAutoReply;

    public DSIAndroidAutoReplyService(DSIAndroidAutoReply dSIAndroidAutoReply) {
        super(new ServiceInstanceID("4b8132b6-9c15-536c-897e-0843cc6a6f3d", DSIAndroidAutoReplyService.nextDynamicHandle(), "e4cf600b-682a-591f-bebd-4b8ed93ce25d", "dsi.androidauto.DSIAndroidAuto"));
        this.p_DSIAndroidAutoReply = dSIAndroidAutoReply;
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
                case 33: {
                    Resource[] resourceArray = ResourceSerializer.getOptionalResourceVarArray(iDeserializer);
                    AppState[] appStateArray = AppStateSerializer.getOptionalAppStateVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAndroidAutoReply.setMode(resourceArray, appStateArray, n);
                    break;
                }
                case 30: {
                    ResourceRequest[] resourceRequestArray = ResourceRequestSerializer.getOptionalResourceRequestVarArray(iDeserializer);
                    AppStateRequest[] appStateRequestArray = AppStateRequestSerializer.getOptionalAppStateRequestVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAndroidAutoReply.requestModeChange(resourceRequestArray, appStateRequestArray, n);
                    break;
                }
                case 19: {
                    CallState[] callStateArray = CallStateSerializer.getOptionalCallStateVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAndroidAutoReply.updateCallState(callStateArray, n);
                    break;
                }
                case 26: {
                    TelephonyState telephonyState = TelephonyStateSerializer.getOptionalTelephonyState(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAndroidAutoReply.updateTelephonyState(telephonyState, n);
                    break;
                }
                case 22: {
                    TrackData trackData = TrackDataSerializer.getOptionalTrackData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAndroidAutoReply.updateNowPlayingData(trackData, n);
                    break;
                }
                case 23: {
                    PlaybackInfo playbackInfo = PlaybackInfoSerializer.getOptionalPlaybackInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAndroidAutoReply.updatePlaybackState(playbackInfo, n);
                    break;
                }
                case 24: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIAndroidAutoReply.updatePlayposition(n, n2);
                    break;
                }
                case 20: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAndroidAutoReply.updateCoverArtUrl(resourceLocator, n);
                    break;
                }
                case 39: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIAndroidAutoReply.updateNavigationNextTurnEvent(string, n, n3, n4, n5, n6);
                    break;
                }
                case 38: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIAndroidAutoReply.updateNavigationNextTurnDistance(n, n7, n8);
                    break;
                }
                case 36: {
                    double d2 = iDeserializer.getDouble();
                    double d3 = iDeserializer.getDouble();
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIAndroidAutoReply.setExternalDestination(d2, d3, string, string2);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSIAndroidAutoReply.asyncException(n, string, n9);
                    break;
                }
                case 28: {
                    String string = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    this.p_DSIAndroidAutoReply.yyIndication(string, string3);
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

