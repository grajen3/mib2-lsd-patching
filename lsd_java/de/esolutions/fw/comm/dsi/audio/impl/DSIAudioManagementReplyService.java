/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.audio.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.audio.DSIAudioManagementReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIAudioManagementReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.audio.DSIAudioManagement");
    private static int dynamicHandle = 0;
    private DSIAudioManagementReply p_DSIAudioManagementReply;

    public DSIAudioManagementReplyService(DSIAudioManagementReply dSIAudioManagementReply) {
        super(new ServiceInstanceID("55183b6f-9e82-5a18-bfde-ed5ae24f6c1c", DSIAudioManagementReplyService.nextDynamicHandle(), "db006bf0-acd2-5747-8415-366ba32075fe", "dsi.audio.DSIAudioManagement"));
        this.p_DSIAudioManagementReply = dSIAudioManagementReply;
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
                    this.p_DSIAudioManagementReply.errorConnection(n, n2, n3);
                    break;
                }
                case 6: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIAudioManagementReply.fadedIn(n, n4);
                    break;
                }
                case 10: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIAudioManagementReply.pauseConnection(n, n5);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIAudioManagementReply.updateActiveConnection(n, n6, n7);
                    break;
                }
                case 22: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSIAudioManagementReply.updateActiveEntertainmentConnection(n, n8, n9);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSIAudioManagementReply.startConnection(n, n10);
                    break;
                }
                case 19: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSIAudioManagementReply.stopConnection(n, n11);
                    break;
                }
                case 20: {
                    int n = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSIAudioManagementReply.updateAMAvailable(n, n12, n13);
                    break;
                }
                case 13: {
                    int n = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_DSIAudioManagementReply.responseVolumelock(n, n14, bl);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSIAudioManagementReply.asyncException(n, string, n15);
                    break;
                }
                case 23: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIAudioManagementReply.yyIndication(string, string2);
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

