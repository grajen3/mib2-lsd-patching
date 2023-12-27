/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.comparator;

import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.comparator.ComparatorDate;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import java.util.Comparator;
import org.dsi.ifc.travellink.GenericPropertyContainer;
import org.dsi.ifc.travellink.TravelLinkDate;

public final class ComparatorMovieShowTimes
implements Comparator {
    private static ComparatorMovieShowTimes comparatorShowTimes = null;

    private ComparatorMovieShowTimes() {
    }

    public static ComparatorMovieShowTimes getComparator() {
        if (comparatorShowTimes == null) {
            comparatorShowTimes = new ComparatorMovieShowTimes();
        }
        return comparatorShowTimes;
    }

    @Override
    public int compare(Object object, Object object2) {
        if (null == object || null == object2 || !(object instanceof GenericPropertyContainer) || !(object2 instanceof GenericPropertyContainer)) {
            return 0;
        }
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        GenericPropertyContainer genericPropertyContainer2 = (GenericPropertyContainer)object2;
        int n = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getListSortOrderForMovieTheaterShowTimes();
        if (0 == TLinkServiceManager.getServiceManager().getCurrentViewId()) {
            n = 1;
        }
        switch (n) {
            case 0: {
                int n2 = this.compareNames(genericPropertyContainer, genericPropertyContainer2);
                if (0 != n2) {
                    return n2;
                }
                return this.compareTimes(genericPropertyContainer, genericPropertyContainer2);
            }
            case 1: {
                int n3 = this.compareTimes(genericPropertyContainer, genericPropertyContainer2);
                if (0 != n3) {
                    return n3;
                }
                return this.compareNames(genericPropertyContainer, genericPropertyContainer2);
            }
        }
        return 0;
    }

    private int compareNames(GenericPropertyContainer genericPropertyContainer, GenericPropertyContainer genericPropertyContainer2) {
        String string = GenericPropertyUtility.getString(-813235968, 0, genericPropertyContainer);
        String string2 = GenericPropertyUtility.getString(-813235968, 0, genericPropertyContainer2);
        if (null == string || null == string2) {
            return 0;
        }
        return string.compareToIgnoreCase(string2);
    }

    private int compareTimes(GenericPropertyContainer genericPropertyContainer, GenericPropertyContainer genericPropertyContainer2) {
        TravelLinkDate[] travelLinkDateArray = GenericPropertyUtility.getDateArray(-746127104, genericPropertyContainer);
        TravelLinkDate[] travelLinkDateArray2 = GenericPropertyUtility.getDateArray(-729349888, genericPropertyContainer);
        TravelLinkDate[] travelLinkDateArray3 = GenericPropertyUtility.getDateArray(-746127104, genericPropertyContainer2);
        TravelLinkDate[] travelLinkDateArray4 = GenericPropertyUtility.getDateArray(-729349888, genericPropertyContainer2);
        TravelLinkDate travelLinkDate = TLinkServiceManager.getServiceManager().getTravelLinkDateUtility().getfirstMovieShowTime(travelLinkDateArray, travelLinkDateArray2);
        TravelLinkDate travelLinkDate2 = TLinkServiceManager.getServiceManager().getTravelLinkDateUtility().getfirstMovieShowTime(travelLinkDateArray3, travelLinkDateArray4);
        return ComparatorDate.getComparator().compare(travelLinkDate, travelLinkDate2);
    }
}

