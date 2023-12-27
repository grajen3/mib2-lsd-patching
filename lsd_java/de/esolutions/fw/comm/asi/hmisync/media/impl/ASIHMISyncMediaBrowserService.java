/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaBrowserReply;
import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaBrowserS;
import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaEntrySerializer;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaSourceSlotSerializer;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncMediaBrowserService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.media.ASIHMISyncMediaBrowser");
    private ASIHMISyncMediaBrowserS p_ASIHMISyncMediaBrowser;

    public ASIHMISyncMediaBrowserService(int n, ASIHMISyncMediaBrowserS aSIHMISyncMediaBrowserS) {
        super(new ServiceInstanceID("04780aa8-9662-4220-9900-4a1e11586d28", n, "8f2aa3cc-0c22-5ffa-83d3-4e78162cf3e6", "asi.hmisync.media.ASIHMISyncMediaBrowser"));
        this.p_ASIHMISyncMediaBrowser = aSIHMISyncMediaBrowserS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new ASIHMISyncMediaBrowserReplyProxy();
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
                    this.p_ASIHMISyncMediaBrowser.activate(mediaSourceSlot, (ASIHMISyncMediaBrowserReplyProxy)iProxyFrontend);
                    break;
                }
                case 6: {
                    this.p_ASIHMISyncMediaBrowser.deactivate((ASIHMISyncMediaBrowserReplyProxy)iProxyFrontend);
                    break;
                }
                case 11: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncMediaBrowser.setBrowseMode(n, (ASIHMISyncMediaBrowserReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    MediaEntry[] mediaEntryArray = MediaEntrySerializer.getOptionalMediaEntryVarArray(iDeserializer);
                    this.p_ASIHMISyncMediaBrowser.changeFolder(mediaEntryArray, (ASIHMISyncMediaBrowserReplyProxy)iProxyFrontend);
                    break;
                }
                case 1: {
                    int n = iDeserializer.getInt32();
                    MediaEntry mediaEntry = MediaEntrySerializer.getOptionalMediaEntry(iDeserializer);
                    this.p_ASIHMISyncMediaBrowser.addSelection(n, mediaEntry, (ASIHMISyncMediaBrowserReplyProxy)iProxyFrontend);
                    break;
                }
                case 7: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    int n2 = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_ASIHMISyncMediaBrowser.requestList(n, l, n2, n3, (ASIHMISyncMediaBrowserReplyProxy)iProxyFrontend);
                    break;
                }
                case 12: {
                    this.p_ASIHMISyncMediaBrowser.setNotification((ASIHMISyncMediaBrowserReplyProxy)iProxyFrontend);
                    break;
                }
                case 14: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncMediaBrowser.setNotification(l, (ASIHMISyncMediaBrowserReply)((ASIHMISyncMediaBrowserReplyProxy)iProxyFrontend));
                    break;
                }
                case 13: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncMediaBrowser.setNotification(lArray, (ASIHMISyncMediaBrowserReply)((ASIHMISyncMediaBrowserReplyProxy)iProxyFrontend));
                    break;
                }
                case 3: {
                    this.p_ASIHMISyncMediaBrowser.clearNotification((ASIHMISyncMediaBrowserReplyProxy)iProxyFrontend);
                    break;
                }
                case 5: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncMediaBrowser.clearNotification(l, (ASIHMISyncMediaBrowserReply)((ASIHMISyncMediaBrowserReplyProxy)iProxyFrontend));
                    break;
                }
                case 4: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncMediaBrowser.clearNotification(lArray, (ASIHMISyncMediaBrowserReply)((ASIHMISyncMediaBrowserReplyProxy)iProxyFrontend));
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

