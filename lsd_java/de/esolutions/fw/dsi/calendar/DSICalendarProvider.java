/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.calendar;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.calendar.DSICalendarReply;
import de.esolutions.fw.comm.dsi.calendar.impl.DSICalendarProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.DSICalendar;
import org.dsi.ifc.calendar.ProfileInfo;
import org.dsi.ifc.global.DateTime;
import org.osgi.framework.BundleContext;

public class DSICalendarProvider
extends AbstractProvider
implements DSICalendar {
    private static final int[] attributeIDs = new int[0];
    private DSICalendarProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$calendar$DSICalendar;

    public DSICalendarProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$calendar$DSICalendar == null ? (class$org$dsi$ifc$calendar$DSICalendar = DSICalendarProvider.class$("org.dsi.ifc.calendar.DSICalendar")) : class$org$dsi$ifc$calendar$DSICalendar).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSICalendarProxy(this.instance, (DSICalendarReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void getCalendarSummaries(DateTime dateTime, DateTime dateTime2) {
        try {
            this.proxy.getCalendarSummaries(dateTime, dateTime2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getCalendarEntry(long l) {
        try {
            this.proxy.getCalendarEntry(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCalendarConfig(CalendarConfig calendarConfig) {
        try {
            this.proxy.setCalendarConfig(calendarConfig);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getCalendarConfig(long l) {
        try {
            this.proxy.getCalendarConfig(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAlarm(long l, long l2) {
        try {
            this.proxy.setAlarm(l, l2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getAlarm(long l) {
        try {
            this.proxy.getAlarm(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getEmailAddresses(long l) {
        try {
            this.proxy.getEmailAddresses(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getTelephoneNumbers(long l) {
        try {
            this.proxy.getTelephoneNumbers(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void insertProfile(ProfileInfo profileInfo) {
        try {
            this.proxy.insertProfile(profileInfo);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteProfile(long l) {
        try {
            this.proxy.deleteProfile(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int[] nArray) {
        try {
            this.proxy.setNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int n) {
        try {
            this.proxy.setNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification() {
        try {
            this.proxy.setNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int[] nArray) {
        try {
            this.proxy.clearNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int n) {
        try {
            this.proxy.clearNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification() {
        try {
            this.proxy.clearNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void yySet(String string, String string2) {
        try {
            this.proxy.yySet(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

