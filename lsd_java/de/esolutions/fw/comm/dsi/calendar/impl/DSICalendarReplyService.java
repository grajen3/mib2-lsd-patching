/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.calendar.DSICalendarReply;
import de.esolutions.fw.comm.dsi.calendar.impl.CalendarConfigSerializer;
import de.esolutions.fw.comm.dsi.calendar.impl.CalendarEntrySerializer;
import de.esolutions.fw.comm.dsi.calendar.impl.CalendarSummarySerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.CalendarEntry;
import org.dsi.ifc.calendar.CalendarSummary;

public class DSICalendarReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.calendar.DSICalendar");
    private static int dynamicHandle = 0;
    private DSICalendarReply p_DSICalendarReply;

    public DSICalendarReplyService(DSICalendarReply dSICalendarReply) {
        super(new ServiceInstanceID("b0c956ce-2978-5f05-a1c0-1c800024a427", DSICalendarReplyService.nextDynamicHandle(), "6a609309-2671-5e07-ae85-f93f7f5634b3", "dsi.calendar.DSICalendar"));
        this.p_DSICalendarReply = dSICalendarReply;
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
                case 22: {
                    int n = iDeserializer.getInt32();
                    CalendarSummary[] calendarSummaryArray = CalendarSummarySerializer.getOptionalCalendarSummaryVarArray(iDeserializer);
                    this.p_DSICalendarReply.getCalendarSummariesResult(n, calendarSummaryArray);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    CalendarEntry calendarEntry = CalendarEntrySerializer.getOptionalCalendarEntry(iDeserializer);
                    this.p_DSICalendarReply.getCalendarEntryResult(n, calendarEntry);
                    break;
                }
                case 25: {
                    long l = iDeserializer.getInt64();
                    this.p_DSICalendarReply.indicateAlarm(l);
                    break;
                }
                case 28: {
                    int n = iDeserializer.getInt32();
                    this.p_DSICalendarReply.setCalendarConfigResult(n);
                    break;
                }
                case 20: {
                    int n = iDeserializer.getInt32();
                    CalendarConfig calendarConfig = CalendarConfigSerializer.getOptionalCalendarConfig(iDeserializer);
                    this.p_DSICalendarReply.getCalendarConfigResult(n, calendarConfig);
                    break;
                }
                case 27: {
                    int n = iDeserializer.getInt32();
                    this.p_DSICalendarReply.setAlarmRepeatResult(n);
                    break;
                }
                case 19: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    this.p_DSICalendarReply.getAlarmRepeatResult(n, l);
                    break;
                }
                case 23: {
                    int n = iDeserializer.getInt32();
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    this.p_DSICalendarReply.getEmailAddressesResult(n, stringArray);
                    break;
                }
                case 24: {
                    int n = iDeserializer.getInt32();
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    this.p_DSICalendarReply.getTelephoneNumbersResult(n, stringArray);
                    break;
                }
                case 26: {
                    int n = iDeserializer.getInt32();
                    this.p_DSICalendarReply.insertProfileResult(n);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getInt32();
                    this.p_DSICalendarReply.deleteProfileResult(n);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSICalendarReply.asyncException(n, string, n2);
                    break;
                }
                case 29: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSICalendarReply.yyIndication(string, string2);
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

