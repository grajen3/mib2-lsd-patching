/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.calendar.db.provider.impl;

import de.esolutions.fw.comm.asi.calendar.db.provider.VCalendarDbProvider;
import de.esolutions.fw.comm.asi.calendar.db.provider.VCalendarDbProviderC;
import de.esolutions.fw.comm.asi.calendar.db.provider.VCalendarDbProviderReply;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderProxy$1;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderProxy$2;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderProxy$3;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderProxy$4;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.ProfileInfo;
import org.dsi.ifc.calendar.VCalendar;
import org.dsi.ifc.global.DateTime;

public class VCalendarDbProviderProxy
implements VCalendarDbProvider,
VCalendarDbProviderC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.calendar.db.provider.VCalendarDbProvider");
    private Proxy proxy;

    public VCalendarDbProviderProxy(int n, VCalendarDbProviderReply vCalendarDbProviderReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("70b84daa-4b74-4908-83c0-ef7f5a885f6e", n, "612c617b-a23f-54f8-82dd-2e34540b7597", "asi.calendar.db.provider.VCalendarDbProvider");
        VCalendarDbProviderReplyService vCalendarDbProviderReplyService = new VCalendarDbProviderReplyService(vCalendarDbProviderReply);
        this.proxy = new Proxy(serviceInstanceID, vCalendarDbProviderReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void beginTransaction() {
        this.proxy.remoteCallMethod((short)2, null);
    }

    @Override
    public void commitTransaction() {
        this.proxy.remoteCallMethod((short)4, null);
    }

    @Override
    public void addEntries(int n, int n2, VCalendar[] vCalendarArray) {
        VCalendarDbProviderProxy$1 vCalendarDbProviderProxy$1 = new VCalendarDbProviderProxy$1(this, n, n2, vCalendarArray);
        this.proxy.remoteCallMethod((short)18, vCalendarDbProviderProxy$1);
    }

    @Override
    public void removeEntries(int n, int n2, long[] lArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putOptionalInt64VarArray(lArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)12, genericSerializable);
    }

    @Override
    public void removeProfile(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    @Override
    public void removeAll() {
        this.proxy.remoteCallMethod((short)10, null);
    }

    @Override
    public void getVersion() {
        this.proxy.remoteCallMethod((short)8, null);
    }

    @Override
    public void setActiveProfiles(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    @Override
    public void forceGetDataResult(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putEnum(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    @Override
    public void setCalendarConfig(CalendarConfig calendarConfig) {
        VCalendarDbProviderProxy$2 vCalendarDbProviderProxy$2 = new VCalendarDbProviderProxy$2(this, calendarConfig);
        this.proxy.remoteCallMethod((short)29, vCalendarDbProviderProxy$2);
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
        this.proxy.remoteCallMethod((short)21, genericSerializable);
    }

    @Override
    public void insertProfile(ProfileInfo profileInfo) {
        VCalendarDbProviderProxy$3 vCalendarDbProviderProxy$3 = new VCalendarDbProviderProxy$3(this, profileInfo);
        this.proxy.remoteCallMethod((short)31, vCalendarDbProviderProxy$3);
    }

    @Override
    public void getCalendarEntry(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)23, genericSerializable);
    }

    @Override
    public void getCalendarSummaries(DateTime dateTime, DateTime dateTime2) {
        VCalendarDbProviderProxy$4 vCalendarDbProviderProxy$4 = new VCalendarDbProviderProxy$4(this, dateTime, dateTime2);
        this.proxy.remoteCallMethod((short)25, vCalendarDbProviderProxy$4);
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
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }
}

