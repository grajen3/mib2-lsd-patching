/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system.clock;

import de.vw.mib.asl.api.system.clock.DateTimeListener;
import java.util.GregorianCalendar;

public interface DateTimeService {
    default public GregorianCalendar getGregorianCalendar() {
    }

    default public void addListener(DateTimeListener dateTimeListener) {
    }

    default public void removeListener(DateTimeListener dateTimeListener) {
    }
}

