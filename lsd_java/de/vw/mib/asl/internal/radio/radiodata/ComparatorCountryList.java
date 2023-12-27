/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.radiodata;

import de.vw.mib.asl.internal.radio.transformer.RadioCountryListCollector;
import java.util.Comparator;

public final class ComparatorCountryList
implements Comparator {
    private static ComparatorCountryList comparatorCountryList = null;

    private ComparatorCountryList() {
    }

    public static ComparatorCountryList getComparator() {
        if (comparatorCountryList == null) {
            comparatorCountryList = new ComparatorCountryList();
        }
        return comparatorCountryList;
    }

    @Override
    public int compare(Object object, Object object2) {
        if (null == object || null == object2) {
            return 0;
        }
        RadioCountryListCollector radioCountryListCollector = (RadioCountryListCollector)object;
        RadioCountryListCollector radioCountryListCollector2 = (RadioCountryListCollector)object2;
        if (radioCountryListCollector.guiListItemPosition > radioCountryListCollector2.guiListItemPosition) {
            return 1;
        }
        if (radioCountryListCollector.guiListItemPosition < radioCountryListCollector2.guiListItemPosition) {
            return -1;
        }
        if (null == radioCountryListCollector.countryRegionName || null == radioCountryListCollector2.countryRegionName) {
            return 0;
        }
        return radioCountryListCollector.countryRegionName.compareToIgnoreCase(radioCountryListCollector2.countryRegionName);
    }
}

