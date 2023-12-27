/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.comparator;

import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import java.util.Comparator;
import org.dsi.ifc.travellink.GenericPropertyContainer;
import org.dsi.ifc.travellink.TravelLinkDate;

public final class ComparatorSportsGamesFinishedTime
implements Comparator {
    private static ComparatorSportsGamesFinishedTime comparatorSportsGameList = null;

    private ComparatorSportsGamesFinishedTime() {
    }

    public static ComparatorSportsGamesFinishedTime getComparator() {
        if (comparatorSportsGameList == null) {
            comparatorSportsGameList = new ComparatorSportsGamesFinishedTime();
        }
        return comparatorSportsGameList;
    }

    @Override
    public int compare(Object object, Object object2) {
        if (null == object || null == object2 || !(object instanceof GenericPropertyContainer) || !(object2 instanceof GenericPropertyContainer)) {
            return 0;
        }
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        GenericPropertyContainer genericPropertyContainer2 = (GenericPropertyContainer)object2;
        return this.compareDate(genericPropertyContainer, genericPropertyContainer2);
    }

    private int compareDate(GenericPropertyContainer genericPropertyContainer, GenericPropertyContainer genericPropertyContainer2) {
        TravelLinkDate travelLinkDate = GenericPropertyUtility.getDate(362087424, 0, genericPropertyContainer);
        TravelLinkDate travelLinkDate2 = GenericPropertyUtility.getDate(362087424, 0, genericPropertyContainer2);
        if (null == travelLinkDate || null == travelLinkDate2) {
            return 0;
        }
        return this.compareAndSortDateInDescendingOrder(travelLinkDate, travelLinkDate2);
    }

    public int compareAndSortDateInDescendingOrder(Object object, Object object2) {
        if (null == object || null == object2 || !(object instanceof TravelLinkDate) || !(object2 instanceof TravelLinkDate)) {
            return 0;
        }
        TravelLinkDate travelLinkDate = (TravelLinkDate)object;
        TravelLinkDate travelLinkDate2 = (TravelLinkDate)object2;
        if (travelLinkDate.getYear() != travelLinkDate2.getYear()) {
            return travelLinkDate2.getYear() - travelLinkDate.getYear();
        }
        if (travelLinkDate.getMonth() != travelLinkDate2.getMonth()) {
            return travelLinkDate2.getMonth() - travelLinkDate.getMonth();
        }
        if (travelLinkDate.getDay() != travelLinkDate2.getDay()) {
            return travelLinkDate2.getDay() - travelLinkDate.getDay();
        }
        if (travelLinkDate.getHour() != travelLinkDate2.getHour()) {
            return travelLinkDate2.getHour() - travelLinkDate.getHour();
        }
        if (travelLinkDate.getMinute() != travelLinkDate2.getMinute()) {
            return travelLinkDate2.getMinute() - travelLinkDate.getMinute();
        }
        if (travelLinkDate.getSecond() != travelLinkDate2.getSecond()) {
            return travelLinkDate2.getSecond() - travelLinkDate.getSecond();
        }
        return 0;
    }
}

