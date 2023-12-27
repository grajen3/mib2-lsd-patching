/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.comparator;

import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import java.util.Comparator;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class ComparatorString
implements Comparator {
    private static ComparatorString comparatorString = null;
    private static int key = -1;

    private ComparatorString() {
    }

    public static ComparatorString getComparator(int n) {
        if (comparatorString == null) {
            comparatorString = new ComparatorString();
        }
        key = n;
        return comparatorString;
    }

    @Override
    public int compare(Object object, Object object2) {
        if (key == -1 || null == object || null == object2 || !(object instanceof GenericPropertyContainer) || !(object2 instanceof GenericPropertyContainer)) {
            return 0;
        }
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        GenericPropertyContainer genericPropertyContainer2 = (GenericPropertyContainer)object2;
        int n = this.compareString(genericPropertyContainer, genericPropertyContainer2);
        return n;
    }

    private int compareString(GenericPropertyContainer genericPropertyContainer, GenericPropertyContainer genericPropertyContainer2) {
        String string = GenericPropertyUtility.getString(key, 0, genericPropertyContainer);
        String string2 = GenericPropertyUtility.getString(key, 0, genericPropertyContainer2);
        if (null == string || null == string2) {
            return 0;
        }
        return string.compareToIgnoreCase(string2);
    }
}

