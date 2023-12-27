/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.calendar.db.provider.impl;

import de.esolutions.fw.comm.asi.calendar.db.provider.VCalendarDbProviderReply;
import de.esolutions.fw.comm.asi.calendar.db.provider.VersionInfo;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VersionInfoSerializer;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.calendar.impl.CalendarConfigSerializer;
import de.esolutions.fw.comm.dsi.calendar.impl.VEventSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.VEvent;

public class VCalendarDbProviderReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.calendar.db.provider.VCalendarDbProvider");
    private static int dynamicHandle = 0;
    private VCalendarDbProviderReply p_VCalendarDbProviderReply;

    public VCalendarDbProviderReplyService(VCalendarDbProviderReply vCalendarDbProviderReply) {
        super(new ServiceInstanceID("958eeab9-87d2-470a-b62e-bd9bdd6070f6", VCalendarDbProviderReplyService.nextDynamicHandle(), "c499e56b-0fd0-59f4-9181-c70e221b3299", "asi.calendar.db.provider.VCalendarDbProvider"));
        this.p_VCalendarDbProviderReply = vCalendarDbProviderReply;
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
                case 3: {
                    int n = iDeserializer.getEnum();
                    this.p_VCalendarDbProviderReply.beginTransactionResult(n);
                    break;
                }
                case 5: {
                    int n = iDeserializer.getEnum();
                    this.p_VCalendarDbProviderReply.commitTransactionResult(n);
                    break;
                }
                case 1: {
                    int n = iDeserializer.getEnum();
                    this.p_VCalendarDbProviderReply.addEntriesResult(n);
                    break;
                }
                case 13: {
                    int n = iDeserializer.getEnum();
                    this.p_VCalendarDbProviderReply.removeEntriesResult(n);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getEnum();
                    this.p_VCalendarDbProviderReply.removeProfileResult(n);
                    break;
                }
                case 11: {
                    int n = iDeserializer.getEnum();
                    this.p_VCalendarDbProviderReply.removeAllResult(n);
                    break;
                }
                case 9: {
                    VersionInfo[] versionInfoArray = VersionInfoSerializer.getOptionalVersionInfoVarArray(iDeserializer);
                    this.p_VCalendarDbProviderReply.getVersionResult(versionInfoArray);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getEnum();
                    this.p_VCalendarDbProviderReply.setActiveProfilesResult(n);
                    break;
                }
                case 6: {
                    this.p_VCalendarDbProviderReply.forceGetData();
                    break;
                }
                case 30: {
                    int n = iDeserializer.getEnum();
                    this.p_VCalendarDbProviderReply.setCalendarConfigResult(n);
                    break;
                }
                case 22: {
                    int n = iDeserializer.getEnum();
                    CalendarConfig calendarConfig = CalendarConfigSerializer.getOptionalCalendarConfig(iDeserializer);
                    this.p_VCalendarDbProviderReply.getCalendarConfigResult(n, calendarConfig);
                    break;
                }
                case 28: {
                    int n = iDeserializer.getEnum();
                    this.p_VCalendarDbProviderReply.insertProfileResult(n);
                    break;
                }
                case 24: {
                    int n = iDeserializer.getEnum();
                    VEvent vEvent = VEventSerializer.getOptionalVEvent(iDeserializer);
                    this.p_VCalendarDbProviderReply.getCalendarEntryResult(n, vEvent);
                    break;
                }
                case 26: {
                    int n = iDeserializer.getEnum();
                    VEvent[] vEventArray = VEventSerializer.getOptionalVEventVarArray(iDeserializer);
                    this.p_VCalendarDbProviderReply.getCalendarSummariesResult(n, vEventArray);
                    break;
                }
                case 20: {
                    int n = iDeserializer.getEnum();
                    this.p_VCalendarDbProviderReply.deleteProfileResult(n);
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

