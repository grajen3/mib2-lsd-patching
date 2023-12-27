/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.comparator;

import java.util.Comparator;
import org.dsi.ifc.travellink.TravelLinkDate;

public final class ComparatorDate
implements Comparator {
    private static ComparatorDate comparatorDate = null;

    private ComparatorDate() {
    }

    public static ComparatorDate getComparator() {
        if (comparatorDate == null) {
            comparatorDate = new ComparatorDate();
        }
        return comparatorDate;
    }

    @Override
    public int compare(Object object, Object object2) {
        if (null == object && null == object2) {
            return 0;
        }
        if (null == object && null != object2) {
            return 1;
        }
        if (null != object && null == object2) {
            return -1;
        }
        if (null == object || null == object2 || !(object instanceof TravelLinkDate) || !(object2 instanceof TravelLinkDate)) {
            return 0;
        }
        TravelLinkDate travelLinkDate = (TravelLinkDate)object;
        TravelLinkDate travelLinkDate2 = (TravelLinkDate)object2;
        if (travelLinkDate.getYear() != travelLinkDate2.getYear()) {
            return travelLinkDate.getYear() - travelLinkDate2.getYear();
        }
        if (travelLinkDate.getMonth() != travelLinkDate2.getMonth()) {
            return travelLinkDate.getMonth() - travelLinkDate2.getMonth();
        }
        if (travelLinkDate.getDay() != travelLinkDate2.getDay()) {
            return travelLinkDate.getDay() - travelLinkDate2.getDay();
        }
        if (travelLinkDate.getHour() != travelLinkDate2.getHour()) {
            return travelLinkDate.getHour() - travelLinkDate2.getHour();
        }
        if (travelLinkDate.getMinute() != travelLinkDate2.getMinute()) {
            return travelLinkDate.getMinute() - travelLinkDate2.getMinute();
        }
        if (travelLinkDate.getSecond() != travelLinkDate2.getSecond()) {
            return travelLinkDate.getSecond() - travelLinkDate2.getSecond();
        }
        return 0;
    }
}

