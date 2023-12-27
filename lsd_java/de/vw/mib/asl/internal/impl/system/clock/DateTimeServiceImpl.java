/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.clock;

import de.vw.mib.asl.api.system.clock.DateTimeListener;
import de.vw.mib.asl.internal.impl.system.clock.PropagatingDateTimeService;
import de.vw.mib.asl.internal.system.util.Preconditions;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;

public class DateTimeServiceImpl
implements PropagatingDateTimeService {
    private final Set listeners = new HashSet();
    private ClockDate clockDate = new ClockDate();
    private ClockTime clockTime = new ClockTime();
    private GregorianCalendar calendar = new GregorianCalendar();

    @Override
    public void addListener(DateTimeListener dateTimeListener) {
        Preconditions.checkArgumentNotNull(dateTimeListener);
        this.listeners.add(dateTimeListener);
    }

    @Override
    public void removeListener(DateTimeListener dateTimeListener) {
        this.listeners.remove(dateTimeListener);
    }

    @Override
    public void applyCurrentDate(ClockDate clockDate) {
        Preconditions.checkArgumentNotNull(clockDate);
        this.clockDate = clockDate;
        this.storeDate(clockDate);
        this.notifyDateListeners(clockDate);
    }

    @Override
    public void applyCurrentTime(ClockTime clockTime) {
        Preconditions.checkArgumentNotNull(clockTime);
        this.clockTime = clockTime;
        this.storeTime(clockTime);
        this.notifyTimeListeners(clockTime);
    }

    @Override
    public GregorianCalendar getGregorianCalendar() {
        return this.calendar;
    }

    private void notifyDateListeners(ClockDate clockDate) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            DateTimeListener dateTimeListener = (DateTimeListener)iterator.next();
            dateTimeListener.updateDate(clockDate.year, clockDate.month, clockDate.day);
        }
    }

    private void notifyTimeListeners(ClockTime clockTime) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            DateTimeListener dateTimeListener = (DateTimeListener)iterator.next();
            dateTimeListener.updateTime(clockTime.hours, clockTime.minutes, clockTime.seconds);
        }
    }

    private void storeDate(ClockDate clockDate) {
        this.calendar = this.createGregorianCalendar(this.clockTime, clockDate);
    }

    private void storeTime(ClockTime clockTime) {
        this.calendar = this.createGregorianCalendar(clockTime, this.clockDate);
    }

    private GregorianCalendar createGregorianCalendar(ClockTime clockTime, ClockDate clockDate) {
        return new GregorianCalendar(clockDate.year, clockDate.month - 1, clockDate.day, clockTime.hours, clockTime.minutes, clockTime.seconds);
    }
}

