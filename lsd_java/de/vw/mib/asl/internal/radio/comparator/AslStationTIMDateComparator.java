/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.comparator;

import java.util.Comparator;
import java.util.GregorianCalendar;
import org.dsi.ifc.radio.TIMMessage;

public final class AslStationTIMDateComparator
implements Comparator {
    public static final AslStationTIMDateComparator INSTANCE = new AslStationTIMDateComparator();

    private AslStationTIMDateComparator() {
    }

    @Override
    public int compare(Object object, Object object2) {
        TIMMessage tIMMessage = (TIMMessage)object;
        TIMMessage tIMMessage2 = (TIMMessage)object2;
        GregorianCalendar gregorianCalendar = new GregorianCalendar(tIMMessage.recordTimeYear, tIMMessage.recordTimeMonth, tIMMessage.recordTimeDay, tIMMessage.recordTimeHour, tIMMessage.recordTimeMinutes, tIMMessage.recordTimeSeconds);
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(tIMMessage2.recordTimeYear, tIMMessage2.recordTimeMonth, tIMMessage2.recordTimeDay, tIMMessage2.recordTimeHour, tIMMessage2.recordTimeMinutes, tIMMessage2.recordTimeSeconds);
        if (gregorianCalendar.after(gregorianCalendar2)) {
            return -1;
        }
        if (gregorianCalendar2.after(gregorianCalendar)) {
            return 1;
        }
        return 0;
    }
}

