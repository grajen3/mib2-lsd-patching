/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.albumbrowser.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.albumbrowser.DSIAlbumBrowserReply;
import de.esolutions.fw.comm.dsi.albumbrowser.impl.AlbumEntryInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.albumbrowser.AlbumEntryInfo;

public class DSIAlbumBrowserReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.albumbrowser.DSIAlbumBrowser");
    private static int dynamicHandle = 0;
    private DSIAlbumBrowserReply p_DSIAlbumBrowserReply;

    public DSIAlbumBrowserReplyService(DSIAlbumBrowserReply dSIAlbumBrowserReply) {
        super(new ServiceInstanceID("11bb0e6e-82d5-5623-848e-eeb35a1a5bb1", DSIAlbumBrowserReplyService.nextDynamicHandle(), "7b023b24-ce3d-579c-b971-3ace26adedfb", "dsi.albumbrowser.DSIAlbumBrowser"));
        this.p_DSIAlbumBrowserReply = dSIAlbumBrowserReply;
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
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIAlbumBrowserReply.updateBrowserState(n, n2);
                    break;
                }
                case 24: {
                    AlbumEntryInfo albumEntryInfo = AlbumEntryInfoSerializer.getOptionalAlbumEntryInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAlbumBrowserReply.updateFocusedEntry(albumEntryInfo, n);
                    break;
                }
                case 25: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAlbumBrowserReply.updateListPosition(l, n);
                    break;
                }
                case 26: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAlbumBrowserReply.updateNumEntries(l, n);
                    break;
                }
                case 27: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIAlbumBrowserReply.updateScrollMode(n, n3);
                    break;
                }
                case 8: {
                    long l = iDeserializer.getInt64();
                    this.p_DSIAlbumBrowserReply.selectAlbum(l);
                    break;
                }
                case 21: {
                    long l = iDeserializer.getInt64();
                    long l2 = iDeserializer.getInt64();
                    this.p_DSIAlbumBrowserReply.albumIdxForFID(l, l2);
                    break;
                }
                case 22: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIAlbumBrowserReply.asyncException(n, string, n4);
                    break;
                }
                case 28: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIAlbumBrowserReply.yyIndication(string, string2);
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

