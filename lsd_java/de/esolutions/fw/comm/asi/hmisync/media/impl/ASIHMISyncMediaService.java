/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaReply;
import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaS;
import de.esolutions.fw.comm.asi.hmisync.media.MediaBrowserSelectionData;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaBrowserSelectionDataSerializer;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaSourceSlotSerializer;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncMediaService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.media.ASIHMISyncMedia");
    private ASIHMISyncMediaS p_ASIHMISyncMedia;

    public ASIHMISyncMediaService(int n, ASIHMISyncMediaS aSIHMISyncMediaS) {
        super(new ServiceInstanceID("848d4459-b390-4cdf-b374-6d4783690a1b", n, "ec49cac0-e751-57fe-b753-0d3e4dc75d6e", "asi.hmisync.media.ASIHMISyncMedia"));
        this.p_ASIHMISyncMedia = aSIHMISyncMediaS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new ASIHMISyncMediaReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 0: {
                    MediaSourceSlot mediaSourceSlot = MediaSourceSlotSerializer.getOptionalMediaSourceSlot(iDeserializer);
                    MediaBrowserSelectionData mediaBrowserSelectionData = MediaBrowserSelectionDataSerializer.getOptionalMediaBrowserSelectionData(iDeserializer);
                    this.p_ASIHMISyncMedia.activate(mediaSourceSlot, mediaBrowserSelectionData, (ASIHMISyncMediaReplyProxy)iProxyFrontend);
                    break;
                }
                case 11: {
                    this.p_ASIHMISyncMedia.resume((ASIHMISyncMediaReplyProxy)iProxyFrontend);
                    break;
                }
                case 6: {
                    this.p_ASIHMISyncMedia.pause((ASIHMISyncMediaReplyProxy)iProxyFrontend);
                    break;
                }
                case 19: {
                    byte by = iDeserializer.getInt8();
                    this.p_ASIHMISyncMedia.skip(by, (ASIHMISyncMediaReplyProxy)iProxyFrontend);
                    break;
                }
                case 12: {
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMedia.seek(bl, (ASIHMISyncMediaReplyProxy)iProxyFrontend);
                    break;
                }
                case 36: {
                    this.p_ASIHMISyncMedia.stopSeek((ASIHMISyncMediaReplyProxy)iProxyFrontend);
                    break;
                }
                case 5: {
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMedia.mix(bl, (ASIHMISyncMediaReplyProxy)iProxyFrontend);
                    break;
                }
                case 7: {
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMedia.repeatTitle(bl, (ASIHMISyncMediaReplyProxy)iProxyFrontend);
                    break;
                }
                case 39: {
                    this.p_ASIHMISyncMedia.toggleRepeatState((ASIHMISyncMediaReplyProxy)iProxyFrontend);
                    break;
                }
                case 40: {
                    this.p_ASIHMISyncMedia.toggleShuffleState((ASIHMISyncMediaReplyProxy)iProxyFrontend);
                    break;
                }
                case 13: {
                    long l = iDeserializer.getInt64();
                    this.p_ASIHMISyncMedia.setEntry(l, (ASIHMISyncMediaReplyProxy)iProxyFrontend);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncMedia.setTimePosition(n, (ASIHMISyncMediaReplyProxy)iProxyFrontend);
                    break;
                }
                case 20: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_ASIHMISyncMedia.touchEvent(n, n2, n3, n4, n5, (ASIHMISyncMediaReplyProxy)iProxyFrontend);
                    break;
                }
                case 4: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncMedia.executeDvdVideoCommand(n, (ASIHMISyncMediaReplyProxy)iProxyFrontend);
                    break;
                }
                case 8: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    int n6 = iDeserializer.getInt32();
                    this.p_ASIHMISyncMedia.requestPlayList(n, l, n6, (ASIHMISyncMediaReplyProxy)iProxyFrontend);
                    break;
                }
                case 17: {
                    MediaBrowserSelectionData mediaBrowserSelectionData = MediaBrowserSelectionDataSerializer.getOptionalMediaBrowserSelectionData(iDeserializer);
                    this.p_ASIHMISyncMedia.setPlaySelection(mediaBrowserSelectionData, (ASIHMISyncMediaReplyProxy)iProxyFrontend);
                    break;
                }
                case 33: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncMedia.playMoreFrom(l, n, (ASIHMISyncMediaReplyProxy)iProxyFrontend);
                    break;
                }
                case 14: {
                    this.p_ASIHMISyncMedia.setNotification((ASIHMISyncMediaReplyProxy)iProxyFrontend);
                    break;
                }
                case 16: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncMedia.setNotification(l, (ASIHMISyncMediaReply)((ASIHMISyncMediaReplyProxy)iProxyFrontend));
                    break;
                }
                case 15: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncMedia.setNotification(lArray, (ASIHMISyncMediaReply)((ASIHMISyncMediaReplyProxy)iProxyFrontend));
                    break;
                }
                case 1: {
                    this.p_ASIHMISyncMedia.clearNotification((ASIHMISyncMediaReplyProxy)iProxyFrontend);
                    break;
                }
                case 3: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncMedia.clearNotification(l, (ASIHMISyncMediaReply)((ASIHMISyncMediaReplyProxy)iProxyFrontend));
                    break;
                }
                case 2: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncMedia.clearNotification(lArray, (ASIHMISyncMediaReply)((ASIHMISyncMediaReplyProxy)iProxyFrontend));
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

