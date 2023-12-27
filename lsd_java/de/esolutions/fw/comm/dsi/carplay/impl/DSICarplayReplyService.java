/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carplay.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carplay.DSICarplayReply;
import de.esolutions.fw.comm.dsi.carplay.impl.AppStateSerializer;
import de.esolutions.fw.comm.dsi.carplay.impl.CallStateSerializer;
import de.esolutions.fw.comm.dsi.carplay.impl.DeviceInfoSerializer;
import de.esolutions.fw.comm.dsi.carplay.impl.PlaybackInfoSerializer;
import de.esolutions.fw.comm.dsi.carplay.impl.ResourceSerializer;
import de.esolutions.fw.comm.dsi.carplay.impl.TelephonyStateSerializer;
import de.esolutions.fw.comm.dsi.carplay.impl.TrackDataSerializer;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.CallState;
import org.dsi.ifc.carplay.DeviceInfo;
import org.dsi.ifc.carplay.PlaybackInfo;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.TelephonyState;
import org.dsi.ifc.carplay.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public class DSICarplayReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.carplay.DSICarplay");
    private static int dynamicHandle = 0;
    private DSICarplayReply p_DSICarplayReply;

    public DSICarplayReplyService(DSICarplayReply dSICarplayReply) {
        super(new ServiceInstanceID("da412c88-5342-52b3-9176-facb675e1711", DSICarplayReplyService.nextDynamicHandle(), "366c0fdd-ac39-51f8-b0d4-a55cea6de432", "dsi.carplay.DSICarplay"));
        this.p_DSICarplayReply = dSICarplayReply;
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
                    Resource[] resourceArray = ResourceSerializer.getOptionalResourceVarArray(iDeserializer);
                    AppState[] appStateArray = AppStateSerializer.getOptionalAppStateVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarplayReply.updateMode(resourceArray, appStateArray, n);
                    break;
                }
                case 37: {
                    Resource[] resourceArray = ResourceSerializer.getOptionalResourceVarArray(iDeserializer);
                    AppState[] appStateArray = AppStateSerializer.getOptionalAppStateVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarplayReply.responseModeChange(resourceArray, appStateArray, n);
                    break;
                }
                case 8: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarplayReply.requestBTDeactivation(string, n);
                    break;
                }
                case 41: {
                    DeviceInfo deviceInfo = DeviceInfoSerializer.getOptionalDeviceInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarplayReply.updateDeviceInfo(deviceInfo, n);
                    break;
                }
                case 40: {
                    CallState[] callStateArray = CallStateSerializer.getOptionalCallStateVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarplayReply.updateCallState(callStateArray, n);
                    break;
                }
                case 28: {
                    TelephonyState telephonyState = TelephonyStateSerializer.getOptionalTelephonyState(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarplayReply.updateTelephonyState(telephonyState, n);
                    break;
                }
                case 24: {
                    TrackData trackData = TrackDataSerializer.getOptionalTrackData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarplayReply.updateNowPlayingData(trackData, n);
                    break;
                }
                case 25: {
                    PlaybackInfo playbackInfo = PlaybackInfoSerializer.getOptionalPlaybackInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarplayReply.updatePlaybackState(playbackInfo, n);
                    break;
                }
                case 26: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSICarplayReply.updatePlayposition(n, n2);
                    break;
                }
                case 21: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarplayReply.updateCoverArtUrl(resourceLocator, n);
                    break;
                }
                case 29: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSICarplayReply.updateTextInputState(n, n3);
                    break;
                }
                case 36: {
                    int n = iDeserializer.getInt32();
                    double d2 = iDeserializer.getDouble();
                    this.p_DSICarplayReply.duckAudio(n, d2);
                    break;
                }
                case 35: {
                    int n = iDeserializer.getInt32();
                    this.p_DSICarplayReply.unduckAudio(n);
                    break;
                }
                case 33: {
                    this.p_DSICarplayReply.oemAppSelected();
                    break;
                }
                case 44: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSICarplayReply.updateMainAudioType(n, n4);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSICarplayReply.asyncException(n, string, n5);
                    break;
                }
                case 30: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSICarplayReply.yyIndication(string, string2);
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

