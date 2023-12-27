/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.comparator;

import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import java.util.Comparator;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class ComparatorMovies
implements Comparator {
    private static ComparatorMovies comparatorMovies = null;

    private ComparatorMovies() {
    }

    public static ComparatorMovies getComparator() {
        if (comparatorMovies == null) {
            comparatorMovies = new ComparatorMovies();
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
        return this.compareNames(genericPropertyContainer, genericPropertyContainer2);
    }

    private int compareNames(GenericPropertyContainer genericPropertyContainer, GenericPropertyContainer genericPropertyContainer2) {
        String string = GenericPropertyUtility.getString(830996736, 0, genericPropertyContainer);
        String string2 = GenericPropertyUtility.getString(830996736, 0, genericPropertyContainer2);
        if (null == string || null == string2) {
            return 0;
        }
        return string.compareToIgnoreCase(string2);
    }
}

