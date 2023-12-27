/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.proxy;

import de.vw.mib.reflection.AbstractProxy;
import de.vw.mib.reflection.InvocationHandler;
import de.vw.mib.reflection.RuntimeUtil;
import de.vw.mib.reflection.pool.ObjArrayPool;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.DSICalendar;
import org.dsi.ifc.calendar.DSICalendarExchange;
import org.dsi.ifc.calendar.ProfileInfo;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.global.ResourceLocator;

public final class LR5dc61c1c0
extends AbstractProxy
implements DSICalendarExchange,
DSICalendar {
    private static final Method[] JMS = new Method[27];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5dc61c1c0(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void parseICal(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR5dc61c1c0.gjm(0, "org.dsi.ifc.calendar.DSICalendarExchange", 1841477522, -633848249), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void parseICalDirectory(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR5dc61c1c0.gjm(1, "org.dsi.ifc.calendar.DSICalendarExchange", -889731525, -633848249), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void exportICal(int n, int n2, long[] lArray, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = lArray;
            objectArray[3] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5dc61c1c0.gjm(2, "org.dsi.ifc.calendar.DSICalendarExchange", -296586740, 1162062397), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void importICal(ResourceLocator[] resourceLocatorArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = resourceLocatorArray;
            this.h.invoke(this, LR5dc61c1c0.gjm(3, "org.dsi.ifc.calendar.DSICalendarExchange", 1599252350, -591118422), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void abortExport() {
        try {
            this.h.invoke(this, LR5dc61c1c0.gjm(4, "org.dsi.ifc.calendar.DSICalendarExchange", 2030147823, 17), 4, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = dSIListener;
            this.h.invoke(this, LR5dc61c1c0.gjm(5, "org.dsi.ifc.calendar.DSICalendarExchange", -501696838, -904616957), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = dSIListener;
            this.h.invoke(this, LR5dc61c1c0.gjm(6, "org.dsi.ifc.calendar.DSICalendarExchange", -501696838, 1805755651), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = dSIListener;
            this.h.invoke(this, LR5dc61c1c0.gjm(7, "org.dsi.ifc.calendar.DSICalendarExchange", -501696838, -864245041), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = dSIListener;
            this.h.invoke(this, LR5dc61c1c0.gjm(8, "org.dsi.ifc.calendar.DSICalendarExchange", 1300919239, -904616957), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = dSIListener;
            this.h.invoke(this, LR5dc61c1c0.gjm(9, "org.dsi.ifc.calendar.DSICalendarExchange", 1300919239, 1805755651), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = dSIListener;
            this.h.invoke(this, LR5dc61c1c0.gjm(10, "org.dsi.ifc.calendar.DSICalendarExchange", 1300919239, -864245041), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getCalendarSummaries(DateTime dateTime, DateTime dateTime2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dateTime;
            objectArray[1] = dateTime2;
            this.h.invoke(this, LR5dc61c1c0.gjm(11, "org.dsi.ifc.calendar.DSICalendar", -442829180, 701215674), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getCalendarEntry(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR5dc61c1c0.gjm(12, "org.dsi.ifc.calendar.DSICalendar", -1825377744, -238538240), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setCalendarConfig(CalendarConfig calendarConfig) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = calendarConfig;
            this.h.invoke(this, LR5dc61c1c0.gjm(13, "org.dsi.ifc.calendar.DSICalendar", -1749292111, 523438510), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getCalendarConfig(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR5dc61c1c0.gjm(14, "org.dsi.ifc.calendar.DSICalendar", -1957431831, -238538240), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAlarm(long l, long l2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(l2);
            this.h.invoke(this, LR5dc61c1c0.gjm(15, "org.dsi.ifc.calendar.DSICalendar", -2076330670, 1372686599), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getAlarm(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR5dc61c1c0.gjm(16, "org.dsi.ifc.calendar.DSICalendar", 270739316, -238538240), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getEmailAddresses(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR5dc61c1c0.gjm(17, "org.dsi.ifc.calendar.DSICalendar", -781284017, -238538240), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getTelephoneNumbers(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR5dc61c1c0.gjm(18, "org.dsi.ifc.calendar.DSICalendar", -1861257448, -238538240), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void insertProfile(ProfileInfo profileInfo) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = profileInfo;
            this.h.invoke(this, LR5dc61c1c0.gjm(19, "org.dsi.ifc.calendar.DSICalendar", 630133199, 572016507), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void deleteProfile(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR5dc61c1c0.gjm(20, "org.dsi.ifc.calendar.DSICalendar", -201893407, -238538240), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }
}

