/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.comparator;

import de.vw.mib.asl.internal.travellink.comparator.ComparatorDate;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import java.util.Comparator;
import org.dsi.ifc.travellink.GenericPropertyContainer;
import org.dsi.ifc.travellink.TravelLinkDate;

public final class ComparatorSportsGamesStartingTime
implements Comparator {
    private static ComparatorSportsGamesStartingTime comparatorSportsGameList = null;

    private ComparatorSportsGamesStartingTime() {
    }

    public static ComparatorSportsGamesStartingTime getComparator() {
        if (comparatorSportsGameList == null) {
            comparatorSportsGameList = new ComparatorSportsGamesStartingTime();
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
        return ComparatorDate.getComparator().compare(travelLinkDate, travelLinkDate2);
    }
}

