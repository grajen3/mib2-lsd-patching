/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaBrowserReply;
import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaEntrySerializer;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaSourceSlotSerializer;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncMediaBrowserReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.media.ASIHMISyncMediaBrowser");
    private static int dynamicHandle = 0;
    private ASIHMISyncMediaBrowserReply p_ASIHMISyncMediaBrowserReply;

    public ASIHMISyncMediaBrowserReplyService(ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        super(new ServiceInstanceID("d77696f4-48c5-4b8c-9855-fe17f312507c", ASIHMISyncMediaBrowserReplyService.nextDynamicHandle(), "45baad1f-9553-5ee9-b624-8c7cb4344305", "asi.hmisync.media.ASIHMISyncMediaBrowser"));
        this.p_ASIHMISyncMediaBrowserReply = aSIHMISyncMediaBrowserReply;
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
                case 9: {
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaBrowserReply.responseChangeFolder(bl);
                    break;
                }
                case 8: {
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaBrowserReply.responseAddSelection(bl);
                    break;
                }
                case 10: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    MediaEntry[] mediaEntryArray = MediaEntrySerializer.getOptionalMediaEntryVarArray(iDeserializer);
                    this.p_ASIHMISyncMediaBrowserReply.responseList(bl, n, mediaEntryArray);
                    break;
                }
                case 15: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaBrowserReply.updateASIVersion(string, bl);
                    break;
                }
                case 23: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaBrowserReply.updateRequestIDs(sArray, bl);
                    break;
                }
                case 22: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaBrowserReply.updateReplyIDs(sArray, bl);
                    break;
                }
                case 16: {
                    MediaSourceSlot mediaSourceSlot = MediaSourceSlotSerializer.getOptionalMediaSourceSlot(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaBrowserReply.updateActiveSlot(mediaSourceSlot, bl);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaBrowserReply.updateBrowseMode(n, bl);
                    break;
                }
                case 19: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl2 = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaBrowserReply.updateDatabaseMode(bl, bl2);
                    break;
                }
                case 21: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl3 = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaBrowserReply.updateRawMode(bl, bl3);
                    break;
                }
                case 17: {
                    MediaEntry[] mediaEntryArray = MediaEntrySerializer.getOptionalMediaEntryVarArray(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaBrowserReply.updateBrowseFolder(mediaEntryArray, bl);
                    break;
                }
                case 20: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMediaBrowserReply.updateListSize(n, bl);
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

