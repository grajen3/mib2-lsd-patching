/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.radio.DSITunerAnnouncementReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSITunerAnnouncementReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.radio.DSITunerAnnouncement");
    private static int dynamicHandle = 0;
    private DSITunerAnnouncementReply p_DSITunerAnnouncementReply;

    public DSITunerAnnouncementReplyService(DSITunerAnnouncementReply dSITunerAnnouncementReply) {
        super(new ServiceInstanceID("f2e4c623-f478-5fd5-8be4-378eb42ad970", DSITunerAnnouncementReplyService.nextDynamicHandle(), "374db20a-d48b-5b4c-b320-ecdb9ee9f9a4", "dsi.radio.DSITunerAnnouncement"));
        this.p_DSITunerAnnouncementReply = dSITunerAnnouncementReply;
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
                case 10: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSITunerAnnouncementReply.updateFilter(n, n2);
                    break;
                }
                case 9: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSITunerAnnouncementReply.updateAvailability(n, n3);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSITunerAnnouncementReply.updateStatus(n, n4);
                    break;
                }
                case 11: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSITunerAnnouncementReply.updateStationName(string, n, l, n5);
                    break;
                }
                case 1: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSITunerAnnouncementReply.asyncException(n, string, n6);
                    break;
                }
                case 13: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSITunerAnnouncementReply.yyIndication(string, string2);
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

