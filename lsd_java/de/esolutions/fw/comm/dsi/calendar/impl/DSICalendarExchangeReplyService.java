/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.calendar.DSICalendarExchangeReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSICalendarExchangeReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.calendar.DSICalendarExchange");
    private static int dynamicHandle = 0;
    private DSICalendarExchangeReply p_DSICalendarExchangeReply;

    public DSICalendarExchangeReplyService(DSICalendarExchangeReply dSICalendarExchangeReply) {
        super(new ServiceInstanceID("e882d2fd-a102-5e1e-a0c9-3bdc5c9ef453", DSICalendarExchangeReplyService.nextDynamicHandle(), "cab46280-5cc8-5c9e-8fc8-8b0ef1c6c895", "dsi.calendar.DSICalendarExchange"));
        this.p_DSICalendarExchangeReply = dSICalendarExchangeReply;
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
                case 16: {
                    int n = iDeserializer.getInt32();
                    this.p_DSICalendarExchangeReply.parseICalResult(n);
                    break;
                }
                case 15: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSICalendarExchangeReply.parseICalDirectoryResult(nArray);
                    break;
                }
                case 13: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_DSICalendarExchangeReply.exportICalResult(n, string);
                    break;
                }
                case 14: {
                    int n = iDeserializer.getInt32();
                    long[] lArray = iDeserializer.getOptionalInt64VarArray();
                    int n2 = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_DSICalendarExchangeReply.finishExportResult(n, lArray, n2, string);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSICalendarExchangeReply.asyncException(n, string, n3);
                    break;
                }
                case 17: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSICalendarExchangeReply.yyIndication(string, string2);
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

