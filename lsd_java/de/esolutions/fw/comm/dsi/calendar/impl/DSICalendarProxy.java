/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.calendar.DSICalendar;
import de.esolutions.fw.comm.dsi.calendar.DSICalendarC;
import de.esolutions.fw.comm.dsi.calendar.DSICalendarReply;
import de.esolutions.fw.comm.dsi.calendar.impl.DSICalendarProxy$1;
import de.esolutions.fw.comm.dsi.calendar.impl.DSICalendarProxy$2;
import de.esolutions.fw.comm.dsi.calendar.impl.DSICalendarProxy$3;
import de.esolutions.fw.comm.dsi.calendar.impl.DSICalendarReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.ProfileInfo;
import org.dsi.ifc.global.DateTime;

public class DSICalendarProxy
implements DSICalendar,
DSICalendarC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.calendar.DSICalendar");
    private Proxy proxy;

    public DSICalendarProxy(int n, DSICalendarReply dSICalendarReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("5c0563ff-8a75-5511-84b2-0b56a0851ca8", n, "685452f9-a1ab-5606-b2bc-9547e11679fb", "dsi.calendar.DSICalendar");
        DSICalendarReplyService dSICalendarReplyService = new DSICalendarReplyService(dSICalendarReply);
        this.proxy = new Proxy(serviceInstanceID, dSICalendarReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void getCalendarSummaries(DateTime dateTime, DateTime dateTime2) {
        DSICalendarProxy$1 dSICalendarProxy$1 = new DSICalendarProxy$1(this, dateTime, dateTime2);
        this.proxy.remoteCallMethod((short)7, dSICalendarProxy$1);
    }

    @Override
    public void getCalendarEntry(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    @Override
    public void setCalendarConfig(CalendarConfig calendarConfig) {
        DSICalendarProxy$2 dSICalendarProxy$2 = new DSICalendarProxy$2(this, calendarConfig);
        this.proxy.remoteCallMethod((short)12, dSICalendarProxy$2);
    }

    @Override
    public void getCalendarConfig(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void setAlarm(long l, long l2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
            genericSerializable.putInt64(l2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    @Override
    public void getAlarm(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void getEmailAddresses(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    @Override
    public void getTelephoneNumbers(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    @Override
    public void insertProfile(ProfileInfo profileInfo) {
        DSICalendarProxy$3 dSICalendarProxy$3 = new DSICalendarProxy$3(this, profileInfo);
        this.proxy.remoteCallMethod((short)30, dSICalendarProxy$3);
    }

    @Override
    public void deleteProfile(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    @Override
    public void setNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    @Override
    public void setNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)15, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)13, null);
    }

    @Override
    public void clearNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)1, genericSerializable);
    }

    @Override
    public void clearNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)2, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)0, null);
    }

    @Override
    public void yySet(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }
}

