/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombipictureserver.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.kombipictureserver.DSIKombiPictureServerReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIKombiPictureServerReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.kombipictureserver.DSIKombiPictureServer");
    private static int dynamicHandle = 0;
    private DSIKombiPictureServerReply p_DSIKombiPictureServerReply;

    public DSIKombiPictureServerReplyService(DSIKombiPictureServerReply dSIKombiPictureServerReply) {
        super(new ServiceInstanceID("ea6b5949-422e-560a-a7d3-c20920d9da4d", DSIKombiPictureServerReplyService.nextDynamicHandle(), "ce643631-ba2b-51a2-9c51-5163c3e28c2a", "dsi.kombipictureserver.DSIKombiPictureServer"));
        this.p_DSIKombiPictureServerReply = dSIKombiPictureServerReply;
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
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIKombiPictureServerReply.indicationCoverArt(l, n, n2);
                    break;
                }
                case 25: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIKombiPictureServerReply.indicationStationArt(l, n, n3);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIKombiPictureServerReply.indicationActiveCallPicture(n);
                    break;
                }
                case 34: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIKombiPictureServerReply.indicationActiveCallPictureInstance(n, n4);
                    break;
                }
                case 35: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIKombiPictureServerReply.indicationDynamicIcon(n, n5);
                    break;
                }
                case 24: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSIKombiPictureServerReply.indicationInternalAddressID(l, n);
                    break;
                }
                case 22: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSIKombiPictureServerReply.indicationAdbContactPicture(l, n);
                    break;
                }
                case 31: {
                    this.p_DSIKombiPictureServerReply.indicationPictureStreamAbilities();
                    break;
                }
                case 30: {
                    int n = iDeserializer.getInt32();
                    short s2 = iDeserializer.getInt16();
                    short s3 = iDeserializer.getInt16();
                    int n6 = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    byte[] byArray = iDeserializer.getOptionalInt8VarArray();
                    this.p_DSIKombiPictureServerReply.indicationPictureStream(n, s2, s3, n6, n7, n8, n9, byArray);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSIKombiPictureServerReply.asyncException(n, string, n10);
                    break;
                }
                case 19: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIKombiPictureServerReply.yyIndication(string, string2);
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

