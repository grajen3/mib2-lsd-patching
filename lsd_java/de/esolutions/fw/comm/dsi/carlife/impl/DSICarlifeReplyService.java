/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlife.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carlife.DSICarlifeReply;
import de.esolutions.fw.comm.dsi.carlife.impl.AppStateSerializer;
import de.esolutions.fw.comm.dsi.carlife.impl.CallStateSerializer;
import de.esolutions.fw.comm.dsi.carlife.impl.DeviceInfoSerializer;
import de.esolutions.fw.comm.dsi.carlife.impl.PlaybackInfoSerializer;
import de.esolutions.fw.comm.dsi.carlife.impl.PlaymodeInfoSerializer;
import de.esolutions.fw.comm.dsi.carlife.impl.ResourceSerializer;
import de.esolutions.fw.comm.dsi.carlife.impl.TrackDataSerializer;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.CallState;
import org.dsi.ifc.carlife.DeviceInfo;
import org.dsi.ifc.carlife.PlaybackInfo;
import org.dsi.ifc.carlife.PlaymodeInfo;
import org.dsi.ifc.carlife.Resource;
import org.dsi.ifc.carlife.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public class DSICarlifeReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.carlife.DSICarlife");
    private static int dynamicHandle = 0;
    private DSICarlifeReply p_DSICarlifeReply;

    public DSICarlifeReplyService(DSICarlifeReply dSICarlifeReply) {
        super(new ServiceInstanceID("c032514d-43a6-5c21-9026-4b110dd7075c", DSICarlifeReplyService.nextDynamicHandle(), "7fc18f96-446f-5fb2-8dab-8fa8ec3dfd7c", "dsi.carlife.DSICarlife"));
        this.p_DSICarlifeReply = dSICarlifeReply;
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
                    Resource[] resourceArray = ResourceSerializer.getOptionalResourceVarArray(iDeserializer);
                    AppState[] appStateArray = AppStateSerializer.getOptionalAppStateVarArray(iDeserializer);
                    this.p_DSICarlifeReply.responseSetMode(resourceArray, appStateArray);
                    break;
                }
                case 17: {
                    CallState callState = CallStateSerializer.getOptionalCallState(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarlifeReply.updateCallState(callState, n);
                    break;
                }
                case 21: {
                    TrackData trackData = TrackDataSerializer.getOptionalTrackData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarlifeReply.updateNowPlayingData(trackData, n);
                    break;
                }
                case 22: {
                    PlaybackInfo playbackInfo = PlaybackInfoSerializer.getOptionalPlaybackInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarlifeReply.updatePlaybackState(playbackInfo, n);
                    break;
                }
                case 23: {
                    PlaymodeInfo playmodeInfo = PlaymodeInfoSerializer.getOptionalPlaymodeInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarlifeReply.updatePlaymodeState(playmodeInfo, n);
                    break;
                }
                case 24: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSICarlifeReply.updatePlayposition(n, n2);
                    break;
                }
                case 18: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarlifeReply.updateCoverArtUrl(resourceLocator, n);
                    break;
                }
                case 20: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSICarlifeReply.updateNavigationNextTurnInfo(string, n, n3, n4, n5, n6);
                    break;
                }
                case 19: {
                    DeviceInfo deviceInfo = DeviceInfoSerializer.getOptionalDeviceInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarlifeReply.updateDeviceInfo(deviceInfo, n);
                    break;
                }
                case 8: {
                    Resource[] resourceArray = ResourceSerializer.getOptionalResourceVarArray(iDeserializer);
                    AppState[] appStateArray = AppStateSerializer.getOptionalAppStateVarArray(iDeserializer);
                    this.p_DSICarlifeReply.requestModeChange(resourceArray, appStateArray);
                    break;
                }
                case 27: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarlifeReply.updateVideoAvailable(bl, n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSICarlifeReply.asyncException(n, string, n7);
                    break;
                }
                case 25: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSICarlifeReply.yyIndication(string, string2);
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

