/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.kombifastlist.DSIFastListScrollingTelephoneReply;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.ArrayHeaderSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.kombifastlist.ArrayHeader;

public class DSIFastListScrollingTelephoneReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.kombifastlist.DSIFastListScrollingTelephone");
    private static int dynamicHandle = 0;
    private DSIFastListScrollingTelephoneReply p_DSIFastListScrollingTelephoneReply;

    public DSIFastListScrollingTelephoneReplyService(DSIFastListScrollingTelephoneReply dSIFastListScrollingTelephoneReply) {
        super(new ServiceInstanceID("b879c465-3f6c-5dad-8c9a-1c4f77696967", DSIFastListScrollingTelephoneReplyService.nextDynamicHandle(), "0d2d503d-cd11-52a4-b8cd-6c1d2c09795a", "dsi.kombifastlist.DSIFastListScrollingTelephone"));
        this.p_DSIFastListScrollingTelephoneReply = dSIFastListScrollingTelephoneReply;
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
                case 8: {
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
                    this.p_DSIFastListScrollingTelephoneReply.indicationPhonebook(n, n2, n3, n4, l, n5, n6, n7, n8, n9, n10);
                    break;
                }
                case 4: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSIFastListScrollingTelephoneReply.indicationGetInitialsTelephone(n, n11, n12, n13);
                    break;
                }
                case 7: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl2 = iDeserializer.getBool();
                    this.p_DSIFastListScrollingTelephoneReply.indicationNotifyFavoriteListPush(bl, bl2);
                    break;
                }
                case 5: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl3 = iDeserializer.getBool();
                    this.p_DSIFastListScrollingTelephoneReply.indicationNotifyCombinedNumbersPush(bl, bl3);
                    break;
                }
                case 6: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl4 = iDeserializer.getBool();
                    this.p_DSIFastListScrollingTelephoneReply.indicationNotifyCurrentListSizeTelephone(bl, bl4);
                    break;
                }
                case 9: {
                    int n = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    ArrayHeader[] arrayHeaderArray = ArrayHeaderSerializer.getOptionalArrayHeaderVarArray(iDeserializer);
                    this.p_DSIFastListScrollingTelephoneReply.indicationPhonebookJobs(n, n14, n15, arrayHeaderArray);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n16 = iDeserializer.getInt32();
                    this.p_DSIFastListScrollingTelephoneReply.asyncException(n, string, n16);
                    break;
                }
                case 25: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIFastListScrollingTelephoneReply.yyIndication(string, string2);
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

