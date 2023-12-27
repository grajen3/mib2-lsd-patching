/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.calendar.db.provider.impl;

import de.esolutions.fw.comm.asi.calendar.db.provider.VCalendarDbProviderReply;
import de.esolutions.fw.comm.asi.calendar.db.provider.VersionInfo;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderReplyProxy$1;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderReplyProxy$10;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderReplyProxy$11;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderReplyProxy$12;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderReplyProxy$13;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderReplyProxy$14;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderReplyProxy$15;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderReplyProxy$2;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderReplyProxy$3;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderReplyProxy$4;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderReplyProxy$5;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderReplyProxy$6;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderReplyProxy$7;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderReplyProxy$8;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderReplyProxy$9;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.VEvent;

public class VCalendarDbProviderReplyProxy
implements VCalendarDbProviderReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.calendar.db.provider.VCalendarDbProvider");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public VCalendarDbProviderReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("958eeab9-87d2-470a-b62e-bd9bdd6070f6", -1, "c499e56b-0fd0-59f4-9181-c70e221b3299", "asi.calendar.db.provider.VCalendarDbProvider");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void beginTransactionResult(int n) {
        VCalendarDbProviderReplyProxy$1 vCalendarDbProviderReplyProxy$1 = new VCalendarDbProviderReplyProxy$1(this, n);
        this.proxy.remoteCallMethod((short)3, vCalendarDbProviderReplyProxy$1);
    }

    @Override
    public void commitTransactionResult(int n) {
        VCalendarDbProviderReplyProxy$2 vCalendarDbProviderReplyProxy$2 = new VCalendarDbProviderReplyProxy$2(this, n);
        this.proxy.remoteCallMethod((short)5, vCalendarDbProviderReplyProxy$2);
    }

    @Override
    public void addEntriesResult(int n) {
        VCalendarDbProviderReplyProxy$3 vCalendarDbProviderReplyProxy$3 = new VCalendarDbProviderReplyProxy$3(this, n);
        this.proxy.remoteCallMethod((short)1, vCalendarDbProviderReplyProxy$3);
    }

    @Override
    public void removeEntriesResult(int n) {
        VCalendarDbProviderReplyProxy$4 vCalendarDbProviderReplyProxy$4 = new VCalendarDbProviderReplyProxy$4(this, n);
        this.proxy.remoteCallMethod((short)13, vCalendarDbProviderReplyProxy$4);
    }

    @Override
    public void removeProfileResult(int n) {
        VCalendarDbProviderReplyProxy$5 vCalendarDbProviderReplyProxy$5 = new VCalendarDbProviderReplyProxy$5(this, n);
        this.proxy.remoteCallMethod((short)15, vCalendarDbProviderReplyProxy$5);
    }

    @Override
    public void removeAllResult(int n) {
        VCalendarDbProviderReplyProxy$6 vCalendarDbProviderReplyProxy$6 = new VCalendarDbProviderReplyProxy$6(this, n);
        this.proxy.remoteCallMethod((short)11, vCalendarDbProviderReplyProxy$6);
    }

    @Override
    public void getVersionResult(VersionInfo[] versionInfoArray) {
        VCalendarDbProviderReplyProxy$7 vCalendarDbProviderReplyProxy$7 = new VCalendarDbProviderReplyProxy$7(this, versionInfoArray);
        this.proxy.remoteCallMethod((short)9, vCalendarDbProviderReplyProxy$7);
    }

    @Override
    public void setActiveProfilesResult(int n) {
        VCalendarDbProviderReplyProxy$8 vCalendarDbProviderReplyProxy$8 = new VCalendarDbProviderReplyProxy$8(this, n);
        this.proxy.remoteCallMethod((short)17, vCalendarDbProviderReplyProxy$8);
    }

    @Override
    public void forceGetData() {
        VCalendarDbProviderReplyProxy$9 vCalendarDbProviderReplyProxy$9 = new VCalendarDbProviderReplyProxy$9(this);
        this.proxy.remoteCallMethod((short)6, vCalendarDbProviderReplyProxy$9);
    }

    @Override
    public void setCalendarConfigResult(int n) {
        VCalendarDbProviderReplyProxy$10 vCalendarDbProviderReplyProxy$10 = new VCalendarDbProviderReplyProxy$10(this, n);
        this.proxy.remoteCallMethod((short)30, vCalendarDbProviderReplyProxy$10);
    }

    @Override
    public void getCalendarConfigResult(int n, CalendarConfig calendarConfig) {
        VCalendarDbProviderReplyProxy$11 vCalendarDbProviderReplyProxy$11 = new VCalendarDbProviderReplyProxy$11(this, n, calendarConfig);
        this.proxy.remoteCallMethod((short)22, vCalendarDbProviderReplyProxy$11);
    }

    @Override
    public void insertProfileResult(int n) {
        VCalendarDbProviderReplyProxy$12 vCalendarDbProviderReplyProxy$12 = new VCalendarDbProviderReplyProxy$12(this, n);
        this.proxy.remoteCallMethod((short)28, vCalendarDbProviderReplyProxy$12);
    }

    @Override
    public void getCalendarEntryResult(int n, VEvent vEvent) {
        VCalendarDbProviderReplyProxy$13 vCalendarDbProviderReplyProxy$13 = new VCalendarDbProviderReplyProxy$13(this, n, vEvent);
        this.proxy.remoteCallMethod((short)24, vCalendarDbProviderReplyProxy$13);
    }

    @Override
    public void getCalendarSummariesResult(int n, VEvent[] vEventArray) {
        VCalendarDbProviderReplyProxy$14 vCalendarDbProviderReplyProxy$14 = new VCalendarDbProviderReplyProxy$14(this, n, vEventArray);
        this.proxy.remoteCallMethod((short)26, vCalendarDbProviderReplyProxy$14);
    }

    @Override
    public void deleteProfileResult(int n) {
        VCalendarDbProviderReplyProxy$15 vCalendarDbProviderReplyProxy$15 = new VCalendarDbProviderReplyProxy$15(this, n);
        this.proxy.remoteCallMethod((short)20, vCalendarDbProviderReplyProxy$15);
    }
}

