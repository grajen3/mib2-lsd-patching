/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.calendar.db.provider.impl;

import de.esolutions.fw.comm.asi.calendar.db.provider.VCalendarDbProviderS;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.calendar.impl.CalendarConfigSerializer;
import de.esolutions.fw.comm.dsi.calendar.impl.ProfileInfoSerializer;
import de.esolutions.fw.comm.dsi.calendar.impl.VCalendarSerializer;
import de.esolutions.fw.comm.dsi.global.impl.DateTimeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.ProfileInfo;
import org.dsi.ifc.calendar.VCalendar;
import org.dsi.ifc.global.DateTime;

public class VCalendarDbProviderService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.calendar.db.provider.VCalendarDbProvider");
    private VCalendarDbProviderS p_VCalendarDbProvider;

    public VCalendarDbProviderService(int n, VCalendarDbProviderS vCalendarDbProviderS) {
        super(new ServiceInstanceID("70b84daa-4b74-4908-83c0-ef7f5a885f6e", n, "612c617b-a23f-54f8-82dd-2e34540b7597", "asi.calendar.db.provider.VCalendarDbProvider"));
        this.p_VCalendarDbProvider = vCalendarDbProviderS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new VCalendarDbProviderReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 2: {
                    this.p_VCalendarDbProvider.beginTransaction((VCalendarDbProviderReplyProxy)iProxyFrontend);
                    break;
                }
                case 4: {
                    this.p_VCalendarDbProvider.commitTransaction((VCalendarDbProviderReplyProxy)iProxyFrontend);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    VCalendar[] vCalendarArray = VCalendarSerializer.getOptionalVCalendarVarArray(iDeserializer);
                    this.p_VCalendarDbProvider.addEntries(n, n2, vCalendarArray, (VCalendarDbProviderReplyProxy)iProxyFrontend);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    long[] lArray = iDeserializer.getOptionalInt64VarArray();
                    this.p_VCalendarDbProvider.removeEntries(n, n3, lArray, (VCalendarDbProviderReplyProxy)iProxyFrontend);
                    break;
                }
                case 14: {
                    int n = iDeserializer.getInt32();
                    this.p_VCalendarDbProvider.removeProfile(n, (VCalendarDbProviderReplyProxy)iProxyFrontend);
                    break;
                }
                case 10: {
                    this.p_VCalendarDbProvider.removeAll((VCalendarDbProviderReplyProxy)iProxyFrontend);
                    break;
                }
                case 8: {
                    this.p_VCalendarDbProvider.getVersion((VCalendarDbProviderReplyProxy)iProxyFrontend);
                    break;
                }
                case 16: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_VCalendarDbProvider.setActiveProfiles(nArray, (VCalendarDbProviderReplyProxy)iProxyFrontend);
                    break;
                }
                case 7: {
                    int n = iDeserializer.getEnum();
                    this.p_VCalendarDbProvider.forceGetDataResult(n, (VCalendarDbProviderReplyProxy)iProxyFrontend);
                    break;
                }
                case 29: {
                    CalendarConfig calendarConfig = CalendarConfigSerializer.getOptionalCalendarConfig(iDeserializer);
                    this.p_VCalendarDbProvider.setCalendarConfig(calendarConfig, (VCalendarDbProviderReplyProxy)iProxyFrontend);
                    break;
                }
                case 21: {
                    long l = iDeserializer.getInt64();
                    this.p_VCalendarDbProvider.getCalendarConfig(l, (VCalendarDbProviderReplyProxy)iProxyFrontend);
                    break;
                }
                case 31: {
                    ProfileInfo profileInfo = ProfileInfoSerializer.getOptionalProfileInfo(iDeserializer);
                    this.p_VCalendarDbProvider.insertProfile(profileInfo, (VCalendarDbProviderReplyProxy)iProxyFrontend);
                    break;
                }
                case 23: {
                    long l = iDeserializer.getUInt64();
                    this.p_VCalendarDbProvider.getCalendarEntry(l, (VCalendarDbProviderReplyProxy)iProxyFrontend);
                    break;
                }
                case 25: {
                    DateTime dateTime = DateTimeSerializer.getOptionalDateTime(iDeserializer);
                    DateTime dateTime2 = DateTimeSerializer.getOptionalDateTime(iDeserializer);
                    this.p_VCalendarDbProvider.getCalendarSummaries(dateTime, dateTime2, (VCalendarDbProviderReplyProxy)iProxyFrontend);
                    break;
                }
                case 19: {
                    long l = iDeserializer.getInt64();
                    this.p_VCalendarDbProvider.deleteProfile(l, (VCalendarDbProviderReplyProxy)iProxyFrontend);
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

