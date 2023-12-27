/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaReply;
import de.esolutions.fw.comm.asi.hmisync.media.MediaActiveSourceState;
import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaPlayTime;
import de.esolutions.fw.comm.asi.hmisync.media.MediaPlaylistState;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaActiveSourceStateSerializer;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaEntrySerializer;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaPlayTimeSerializer;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaPlaylistStateSerializer;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaSourceSlotSerializer;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncMediaReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.media.ASIHMISyncMedia");
    private static int dynamicHandle = 0;
    private ASIHMISyncMediaReply p_ASIHMISyncMediaReply;

    public ASIHMISyncMediaReplyService(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        super(new ServiceInstanceID("d4078ff5-09f8-41d6-bc52-9680f105aea0", ASIHMISyncMediaReplyService.nextDynamicHandle(), "bfc935bd-08a4-581a-85b9-c997454d068b", "asi.hmisync.media.ASIHMISyncMedia"));
        this.p_ASIHMISyncMediaReply = aSIHMISyncMediaReply;
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
                case 35: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncMediaReply.indicationCmdBlocked(n);
                    break;
                }
                case 9: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    MediaEntry[] mediaEntryArray = MediaEntrySerializer.getOptionalMediaEntryVarArray(iDeserializer);
                    this.p_ASIHMISyncMediaReply.responsePlayList(bl, n, mediaEntryArray);
                    break;
                }
                case 10: {
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaReply.responseSetPlaySelection(bl);
                    break;
                }
                case 34: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_ASIHMISyncMediaReply.responsePlayMoreFrom(l, n, n2);
                    break;
                }
                case 21: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaReply.updateASIVersion(string, bl);
                    break;
                }
                case 32: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaReply.updateRequestIDs(sArray, bl);
                    break;
                }
                case 31: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaReply.updateReplyIDs(sArray, bl);
                    break;
                }
                case 30: {
                    MediaSourceSlot[] mediaSourceSlotArray = MediaSourceSlotSerializer.getOptionalMediaSourceSlotVarArray(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaReply.updateSourceList(mediaSourceSlotArray, bl);
                    break;
                }
                case 22: {
                    MediaActiveSourceState mediaActiveSourceState = MediaActiveSourceStateSerializer.getOptionalMediaActiveSourceState(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaReply.updateActiveSlotState(mediaActiveSourceState, bl);
                    break;
                }
                case 27: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaReply.updatePlaybackState(n, bl);
                    break;
                }
                case 23: {
                    MediaPlaylistState mediaPlaylistState = MediaPlaylistStateSerializer.getOptionalMediaPlaylistState(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaReply.updateListState(mediaPlaylistState, bl);
                    break;
                }
                case 38: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaReply.updatePlayerCapabilities(n, bl);
                    break;
                }
                case 24: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl2 = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaReply.updateMix(bl, bl2);
                    break;
                }
                case 29: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl3 = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaReply.updateRepeatTitle(bl, bl3);
                    break;
                }
                case 41: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaReply.updateRepeatState(n, bl);
                    break;
                }
                case 42: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaReply.updateShuffleState(n, bl);
                    break;
                }
                case 28: {
                    MediaEntry mediaEntry = MediaEntrySerializer.getOptionalMediaEntry(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaReply.updatePlayingTrack(mediaEntry, bl);
                    break;
                }
                case 25: {
                    MediaPlayTime mediaPlayTime = MediaPlayTimeSerializer.getOptionalMediaPlayTime(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaReply.updatePlayPosition(mediaPlayTime, bl);
                    break;
                }
                case 26: {
                    MediaEntry[] mediaEntryArray = MediaEntrySerializer.getOptionalMediaEntryVarArray(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaReply.updatePlaybackFolder(mediaEntryArray, bl);
                    break;
                }
                case 37: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaReply.updatePlaybackPossible(n, bl);
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

