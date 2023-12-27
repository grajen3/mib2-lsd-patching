/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navfleetservices.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.navfleetservices.DSINavFleetServicesReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSINavFleetServicesReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.navfleetservices.DSINavFleetServices");
    private static int dynamicHandle = 0;
    private DSINavFleetServicesReply p_DSINavFleetServicesReply;

    public DSINavFleetServicesReplyService(DSINavFleetServicesReply dSINavFleetServicesReply) {
        super(new ServiceInstanceID("e2564039-c9a4-5e5b-ab31-a7a4c6b9b02a", DSINavFleetServicesReplyService.nextDynamicHandle(), "2a330eab-ac67-5335-971f-efda96983bd9", "dsi.navfleetservices.DSINavFleetServices"));
        this.p_DSINavFleetServicesReply = dSINavFleetServicesReply;
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
                case 14: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavFleetServicesReply.setVZOTrackerStateResult(n);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavFleetServicesReply.setVZODownloadStateResult(n);
                    break;
                }
                case 7: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavFleetServicesReply.setLGITrackerStateResult(n);
                    break;
                }
                case 5: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINavFleetServicesReply.setLGIDownloadStateResult(n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSINavFleetServicesReply.asyncException(n, string, n2);
                    break;
                }
                case 15: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSINavFleetServicesReply.yyIndication(string, string2);
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

