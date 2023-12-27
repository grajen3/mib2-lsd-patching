/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto2.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.androidauto2.DSIAndroidAuto2Reply;
import de.esolutions.fw.comm.dsi.androidauto2.impl.CallStateSerializer;
import de.esolutions.fw.comm.dsi.androidauto2.impl.PlaybackInfoSerializer;
import de.esolutions.fw.comm.dsi.androidauto2.impl.TelephonyStateSerializer;
import de.esolutions.fw.comm.dsi.androidauto2.impl.TrackDataSerializer;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.androidauto2.CallState;
import org.dsi.ifc.androidauto2.PlaybackInfo;
import org.dsi.ifc.androidauto2.TelephonyState;
import org.dsi.ifc.androidauto2.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public class DSIAndroidAuto2ReplyService
extends AbstractReplyService {
    private static /*final*/ CallContext context = CallContext.getContext("STUB.dsi.androidauto2.DSIAndroidAuto2");
    private static int dynamicHandle = 0;
    private DSIAndroidAuto2Reply p_DSIAndroidAuto2Reply;

    public DSIAndroidAuto2ReplyService(DSIAndroidAuto2Reply dSIAndroidAuto2Reply) {
        super(new ServiceInstanceID("1109a8e3-3caa-5724-b33f-de936bc4e076", DSIAndroidAuto2ReplyService.nextDynamicHandle(), "3c1002ff-1bb7-599d-83c3-6670b394036e", "dsi.androidauto2.DSIAndroidAuto2"));
        this.p_DSIAndroidAuto2Reply = dSIAndroidAuto2Reply;
    }

    private static synchronized int nextDynamicHandle() {
        int n = ++dynamicHandle;
        return n;
    }

   // @Override
    public CallContext getCallContext() {
        return context;
    }

   // @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 33: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.videoFocusRequestNotification(n, n2);
                    break;
                }
                case 31: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.videoAvailable(bl, n);
                    break;
                }
                case 3: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.audioFocusRequestNotification(n, n3);
                    break;
                }
                case 1: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.audioAvailable(n, bl, n4);
                    break;
                }
                case 34: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.voiceSessionNotification(n, n5);
                    break;
                }
                case 11: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.microphoneRequestNotification(n, n6);
                    break;
                }
                case 13: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.navFocusRequestNotification(n, n7);
                    break;
                }
                case 23: {
                    CallState[] callStateArray = CallStateSerializer.getOptionalCallStateVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.updateCallState(callStateArray, n);
                    break;
                }
                case 30: {
                    TelephonyState telephonyState = TelephonyStateSerializer.getOptionalTelephonyState(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.updateTelephonyState(telephonyState, n);
                    break;
                }
                case 27: {
                    TrackData trackData = TrackDataSerializer.getOptionalTrackData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.updateNowPlayingData(trackData, n);
                    break;
                }
                case 28: {
                    PlaybackInfo playbackInfo = PlaybackInfoSerializer.getOptionalPlaybackInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.updatePlaybackState(playbackInfo, n);
                    break;
                }
                case 29: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.updatePlayposition(n, n8);
                    break;
                }
                case 24: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.updateCoverArtUrl(resourceLocator, n);
                    break;
                }
                case 26: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.updateNavigationNextTurnEvent(string, n, n9, n10, n11, n12);
                    break;
                }
                case 25: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.updateNavigationNextTurnDistance(n, n13, n14);
                    break;
                }
                case 17: {
                    double d2 = iDeserializer.getDouble();
                    double d3 = iDeserializer.getDouble();
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.setExternalDestination(d2, d3, string, string2, n);
                    break;
                }
                case 5: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.bluetoothPairingRequest(string, n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.asyncException(n, string, n15);
                    break;
                }
                case 35: {
                    String string = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    this.p_DSIAndroidAuto2Reply.yyIndication(string, string3);
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

