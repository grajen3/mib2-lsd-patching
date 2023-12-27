/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.kombifastlist.DSIFastListScrollingAudioReply;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.ArrayHeaderSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.kombifastlist.ArrayHeader;

public class DSIFastListScrollingAudioReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.kombifastlist.DSIFastListScrollingAudio");
    private static int dynamicHandle = 0;
    private DSIFastListScrollingAudioReply p_DSIFastListScrollingAudioReply;

    public DSIFastListScrollingAudioReplyService(DSIFastListScrollingAudioReply dSIFastListScrollingAudioReply) {
        super(new ServiceInstanceID("97acfc92-c952-5fc4-91b8-cf398b82e563", DSIFastListScrollingAudioReplyService.nextDynamicHandle(), "f7381f54-95fb-5d0f-ae7c-8848533e7e3f", "dsi.kombifastlist.DSIFastListScrollingAudio"));
        this.p_DSIFastListScrollingAudioReply = dSIFastListScrollingAudioReply;
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
                case 4: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    int n5 = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSIFastListScrollingAudioReply.indicationMediaBrowser(n, n2, n3, n4, l, n5, n6, n7, n8, n9, n10);
                    break;
                }
                case 6: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl2 = iDeserializer.getBool();
                    this.p_DSIFastListScrollingAudioReply.indicationNotifyCommonListPUSH(bl, bl2);
                    break;
                }
                case 8: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl3 = iDeserializer.getBool();
                    this.p_DSIFastListScrollingAudioReply.indicationNotifyReceptionListPUSH(bl, bl3);
                    break;
                }
                case 7: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl4 = iDeserializer.getBool();
                    this.p_DSIFastListScrollingAudioReply.indicationNotifyCurrentListSizeAudio(bl, bl4);
                    break;
                }
                case 5: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    ArrayHeader[] arrayHeaderArray = ArrayHeaderSerializer.getOptionalArrayHeaderVarArray(iDeserializer);
                    this.p_DSIFastListScrollingAudioReply.indicationMediaBrowserJobs(n, n11, n12, arrayHeaderArray);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSIFastListScrollingAudioReply.asyncException(n, string, n13);
                    break;
                }
                case 23: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIFastListScrollingAudioReply.yyIndication(string, string2);
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

