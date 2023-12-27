/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.online.DSIOnlineTrafficReply;
import de.esolutions.fw.comm.dsi.online.impl.FCDPositionSerializer;
import de.esolutions.fw.comm.dsi.online.impl.LocatablePositionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.online.FCDPosition;
import org.dsi.ifc.online.LocatablePosition;

public class DSIOnlineTrafficReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.online.DSIOnlineTraffic");
    private static int dynamicHandle = 0;
    private DSIOnlineTrafficReply p_DSIOnlineTrafficReply;

    public DSIOnlineTrafficReplyService(DSIOnlineTrafficReply dSIOnlineTrafficReply) {
        super(new ServiceInstanceID("a6541574-206f-51ef-b0df-9f6f80e9edfb", DSIOnlineTrafficReplyService.nextDynamicHandle(), "a94f3724-0361-547e-b190-41d13b2282ad", "dsi.online.DSIOnlineTraffic"));
        this.p_DSIOnlineTrafficReply = dSIOnlineTrafficReply;
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
                    this.p_DSIOnlineTrafficReply.updateConsumerReady(n, n2);
                    break;
                }
                case 24: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIOnlineTrafficReply.updateWantOnlineTrafficData(n, n3);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getInt32();
                    LocatablePosition[] locatablePositionArray = LocatablePositionSerializer.getOptionalLocatablePositionVarArray(iDeserializer);
                    this.p_DSIOnlineTrafficReply.getNewDataResult(n, locatablePositionArray);
                    break;
                }
                case 21: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineTrafficReply.setNewDataResult(string, n);
                    break;
                }
                case 20: {
                    this.p_DSIOnlineTrafficReply.getNewSession();
                    break;
                }
                case 22: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineTrafficReply.setTimeoutForFallbackResult(n);
                    break;
                }
                case 19: {
                    FCDPosition fCDPosition = FCDPositionSerializer.getOptionalFCDPosition(iDeserializer);
                    this.p_DSIOnlineTrafficReply.getNewFCDInformationResult(fCDPosition);
                    break;
                }
                case 17: {
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIOnlineTrafficReply.getInventoryResult(string);
                    break;
                }
                case 26: {
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIOnlineTrafficReply.getDownloadFileResult(string);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIOnlineTrafficReply.asyncException(n, string, n4);
                    break;
                }
                case 25: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIOnlineTrafficReply.yyIndication(string, string2);
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

