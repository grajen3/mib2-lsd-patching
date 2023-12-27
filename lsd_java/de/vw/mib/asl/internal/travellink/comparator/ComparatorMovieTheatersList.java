/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.comparator;

import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import java.util.Comparator;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class ComparatorMovieTheatersList
implements Comparator {
    private static ComparatorMovieTheatersList comparatorTheatersList = null;

    private ComparatorMovieTheatersList() {
    }

    public static ComparatorMovieTheatersList getComparator() {
        if (comparatorTheatersList == null) {
            comparatorTheatersList = new ComparatorMovieTheatersList();
        }
        return comparatorTheatersList;
    }

    @Override
    public int compare(Object object, Object object2) {
        if (null == object || null == object2 || !(object instanceof GenericPropertyContainer) || !(object2 instanceof GenericPropertyContainer)) {
            return 0;
        }
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        GenericPropertyContainer genericPropertyContainer2 = (GenericPropertyContainer)object2;
        switch (TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getListSortOrderForMovieTheaterResult()) {
            case 0: {
                int n = this.compareNames(genericPropertyContainer, genericPropertyContainer2);
                if (0 != n) {
                    return n;
                }
                return this.compareDistances(genericPropertyContainer, genericPropertyContainer2);
            }
            case 1: {
                int n = this.compareDistances(genericPropertyContainer, genericPropertyContainer2);
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
}

