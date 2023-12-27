/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.comparator;

import de.vw.mib.asl.internal.travellink.comparator.ComparatorSportsGamesStartingTime;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import java.util.Comparator;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class ComparatorSportsGamesStatus
implements Comparator {
    private static ComparatorSportsGamesStatus comparatorGameStatus = null;

    private ComparatorSportsGamesStatus() {
    }

    public static ComparatorSportsGamesStatus getComparator() {
        if (comparatorGameStatus == null) {
            comparatorGameStatus = new ComparatorSportsGamesStatus();
        }
        return comparatorGameStatus;
    }

    @Override
    public int compare(Object object, Object object2) {
        if (null == object || null == object2 || !(object instanceof GenericPropertyContainer) || !(object2 instanceof GenericPropertyContainer)) {
            return 0;
        }
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        GenericPropertyContainer genericPropertyContainer2 = (GenericPropertyContainer)object2;
        return this.compareGameStatus(genericPropertyContainer, genericPropertyContainer2);
    }

    private int compareGameStatus(GenericPropertyContainer genericPropertyContainer, GenericPropertyContainer genericPropertyContainer2) {
        int n;
        int n2 = GenericPropertyUtility.getInt(345310208, 0, genericPropertyContainer);
        if (n2 == (n = GenericPropertyUtility.getInt(345310208, 0, genericPropertyContainer2))) {
            return ComparatorSportsGamesStartingTime.getComparator().compare(genericPropertyContainer, genericPropertyContainer2);
        }
        if (n2 == 2) {
            return -1;
        }
        if (n == 2) {
            return 1;
        }
        if (n2 == 0) {
            return -1;
        }
        if (n == 0) {
            return 1;
        }
        if (n2 == 3) {
            return -1;
        }
        if (n == 3) {
            return 1;
        }
        return 1;
    }
}

