/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.media.DSIMediaPlayerReply;
import de.esolutions.fw.comm.dsi.media.impl.AudioStreamSerializer;
import de.esolutions.fw.comm.dsi.media.impl.CapabilitiesSerializer;
import de.esolutions.fw.comm.dsi.media.impl.EntryInfoSerializer;
import de.esolutions.fw.comm.dsi.media.impl.ListEntrySerializer;
import de.esolutions.fw.comm.dsi.media.impl.PlaybackModeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.AudioStream;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.PlaybackMode;

public class DSIMediaPlayerReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.media.DSIMediaPlayer");
    private static int dynamicHandle = 0;
    private DSIMediaPlayerReply p_DSIMediaPlayerReply;

    public DSIMediaPlayerReplyService(DSIMediaPlayerReply dSIMediaPlayerReply) {
        super(new ServiceInstanceID("0c182e4a-4267-577b-94ca-68dedb283139", DSIMediaPlayerReplyService.nextDynamicHandle(), "22bc8a7b-fd79-5e25-aedc-0b80a7f97b2f", "dsi.media.DSIMediaPlayer"));
        this.p_DSIMediaPlayerReply = dSIMediaPlayerReply;
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
                case 64: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.updateVideoFormat(n, n2);
                    break;
                }
                case 65: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.updateVideoNorm(n, n3);
                    break;
                }
                case 55: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.updateCmdBlockingMask(n, n4);
                    break;
                }
                case 56: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.updateNumVideoAngles(n, n5);
                    break;
                }
                case 61: {
                    PlaybackMode[] playbackModeArray = PlaybackModeSerializer.getOptionalPlaybackModeVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.updatePlaybackModeList(playbackModeArray, n);
                    break;
                }
                case 60: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.updatePlaybackMode(n, n6);
                    break;
                }
                case 62: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.updatePlaybackState(n, n7);
                    break;
                }
                case 50: {
                    long l = iDeserializer.getInt64();
                    long l2 = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.updateActiveMedia(l, l2, n, n8, n9);
                    break;
                }
                case 79: {
                    ListEntry[] listEntryArray = ListEntrySerializer.getOptionalListEntryVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.updatePlaybackFolder(listEntryArray, n);
                    break;
                }
                case 77: {
                    Capabilities capabilities = CapabilitiesSerializer.getOptionalCapabilities(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.updateCapabilities(capabilities, n);
                    break;
                }
                case 57: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.updatePlayPosition(l, n, n10, n11);
                    break;
                }
                case 58: {
                    int n = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.updatePlayViewSize(n, n12, n13);
                    break;
                }
                case 52: {
                    int n = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.updateActiveVideoAngle(n, n14);
                    break;
                }
                case 53: {
                    AudioStream[] audioStreamArray = AudioStreamSerializer.getOptionalAudioStreamVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.updateAudioStreamList(audioStreamArray, n);
                    break;
                }
                case 49: {
                    int n = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.updateActiveAudioStream(n, n15);
                    break;
                }
                case 63: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.updateSubtitleList(nArray, n);
                    break;
                }
                case 51: {
                    int n = iDeserializer.getInt32();
                    int n16 = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.updateActiveSubtitle(n, n16);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.responseCmdBlocked(n);
                    break;
                }
                case 23: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.responseRating(l, n);
                    break;
                }
                case 20: {
                    long l = iDeserializer.getInt64();
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIMediaPlayerReply.responseFullyQualifiedName(l, string);
                    break;
                }
                case 17: {
                    long l = iDeserializer.getInt64();
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    this.p_DSIMediaPlayerReply.responseCoverArt(l, resourceLocator);
                    break;
                }
                case 76: {
                    ListEntry[] listEntryArray = ListEntrySerializer.getOptionalListEntryVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    int n17 = iDeserializer.getInt32();
                    int n18 = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.responsePlayView(listEntryArray, n, n17, n18);
                    break;
                }
                case 75: {
                    EntryInfo entryInfo = EntryInfoSerializer.getOptionalEntryInfo(iDeserializer);
                    this.p_DSIMediaPlayerReply.responseDetailInfo(entryInfo);
                    break;
                }
                case 8: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.indicationDvdEvent(n);
                    break;
                }
                case 71: {
                    int n = iDeserializer.getInt32();
                    int n19 = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.responseSetPlaySelection(n, n19);
                    break;
                }
                case 25: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_DSIMediaPlayerReply.responseSetPlaySelectionAB(n, bl);
                    break;
                }
                case 26: {
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIMediaPlayerReply.responseSetPlaybackURL(string);
                    break;
                }
                case 27: {
                    int n = iDeserializer.getInt32();
                    int n20 = iDeserializer.getInt32();
                    int n21 = iDeserializer.getInt32();
                    int n22 = iDeserializer.getInt32();
                    int n23 = iDeserializer.getInt32();
                    int n24 = iDeserializer.getInt32();
                    int n25 = iDeserializer.getInt32();
                    int n26 = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.responseSetVideoRect(n, n20, n21, n22, n23, n24, n25, n26);
                    break;
                }
                case 21: {
                    long l = iDeserializer.getInt64();
                    boolean bl = iDeserializer.getBool();
                    this.p_DSIMediaPlayerReply.responsePlaySimilarEntry(l, bl);
                    break;
                }
                case 48: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.tempPMLRequest(n);
                    break;
                }
                case 78: {
                    ListEntry[] listEntryArray = ListEntrySerializer.getOptionalListEntryVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.updatePlaybackContentFolder(listEntryArray, n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n27 = iDeserializer.getInt32();
                    this.p_DSIMediaPlayerReply.asyncException(n, string, n27);
                    break;
                }
                case 66: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIMediaPlayerReply.yyIndication(string, string2);
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

