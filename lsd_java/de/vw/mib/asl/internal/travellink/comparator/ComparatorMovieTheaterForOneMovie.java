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

public final class ComparatorMovieTheaterForOneMovie
implements Comparator {
    private static ComparatorMovieTheaterForOneMovie comparatorMovies = null;

    private ComparatorMovieTheaterForOneMovie() {
    }

    public static ComparatorMovieTheaterForOneMovie getComparator() {
        if (comparatorMovies == null) {
            comparatorMovies = new ComparatorMovieTheaterForOneMovie();
        }
        return comparatorMovies;
    }

    @Override
    public int compare(Object object, Object object2) {
        if (null == object || null == object2 || !(object instanceof GenericPropertyContainer) || !(object2 instanceof GenericPropertyContainer)) {
            return 0;
        }
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        GenericPropertyContainer genericPropertyContainer2 = (GenericPropertyContainer)object2;
        switch (TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getListSortOrderForMoviesResult()) {
            case 0: {
                int n = this.compareNames(genericPropertyContainer, genericPropertyContainer2);
                if (0 != n) {
                    return n;
                }
                n = this.compareDistances(genericPropertyContainer, genericPropertyContainer2);
                if (0 != n) {
                    return n;
                }
                return this.compareTimes(genericPropertyContainer, genericPropertyContainer2);
            }
            case 2: {
                int n = this.compareDistances(genericPropertyContainer, genericPropertyContainer2);
                if (0 != n) {
                    return n;
                }
                n = this.compareTimes(genericPropertyContainer, genericPropertyContainer2);
                if (0 != n) {
                    return n;
                }
                return this.compareNames(genericPropertyContainer, genericPropertyContainer2);
            }
            case 1: {
                int n = this.compareTimes(genericPropertyContainer, genericPropertyContainer2);
                if (0 != n) {
                    return n;
                }
                n = this.compareDistances(genericPropertyContainer, genericPropertyContainer2);
                if (0 != n) {
                    return n;
                }
                return this.compareNames(genericPropertyContainer, genericPropertyContainer2);
            }
        }
        return 0;
    }

    private int compareNames(GenericPropertyContainer genericPropertyContainer, GenericPropertyContainer genericPropertyContainer2) {
        String string = GenericPropertyUtility.getString(126288128, 0, genericPropertyContainer);
        String string2 = GenericPropertyUtility.getString(126288128, 0, genericPropertyContainer2);
        if (null == string || null == string2) {
            return 0;
        }
        return string.compareToIgnoreCase(string2);
    }

    private int compareDistances(GenericPropertyContainer genericPropertyContainer, GenericPropertyContainer genericPropertyContainer2) {
        int n = GenericPropertyUtility.getInt(143065344, 0, genericPropertyContainer);
        int n2 = GenericPropertyUtility.getInt(143065344, 0, genericPropertyContainer2);
        return n - n2;
    }

    private int compareTimes(GenericPropertyContainer genericPropertyContainer, GenericPropertyContainer genericPropertyContainer2) {
        TravelLinkDate[] travelLinkDateArray = GenericPropertyUtility.getDateArray(193396992, genericPropertyContainer);
        TravelLinkDate[] travelLinkDateArray2 = GenericPropertyUtility.getDateArray(210174208, genericPropertyContainer);
        TravelLinkDate[] travelLinkDateArray3 = GenericPropertyUtility.getDateArray(193396992, genericPropertyContainer2);
        TravelLinkDate[] travelLinkDateArray4 = GenericPropertyUtility.getDateArray(210174208, genericPropertyContainer2);
        TravelLinkDate travelLinkDate = TLinkServiceManager.getServiceManager().getTravelLinkDateUtility().getfirstMovieShowTime(travelLinkDateArray, travelLinkDateArray2);
        TravelLinkDate travelLinkDate2 = TLinkServiceManager.getServiceManager().getTravelLinkDateUtility().getfirstMovieShowTime(travelLinkDateArray3, travelLinkDateArray4);
        return ComparatorDate.getComparator().compare(travelLinkDate, travelLinkDate2);
    }
}

