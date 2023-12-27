/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.comparator;

import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import java.util.Comparator;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class ComparatorFuelList
implements Comparator {
    private static ComparatorFuelList comparatorFuelList = null;

    private ComparatorFuelList() {
    }

    public static ComparatorFuelList getComparator() {
        if (comparatorFuelList == null) {
            comparatorFuelList = new ComparatorFuelList();
        }
        return comparatorFuelList;
    }

    @Override
    public int compare(Object object, Object object2) {
        if (null == object || null == object2 || !(object instanceof GenericPropertyContainer) || !(object2 instanceof GenericPropertyContainer)) {
            return 0;
        }
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        GenericPropertyContainer genericPropertyContainer2 = (GenericPropertyContainer)object2;
        switch (TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getFuelStationListSortOrder()) {
            case 0: {
                int n = this.compareNames(genericPropertyContainer, genericPropertyContainer2);
                if (0 != n) {
                    return n;
                }
                n = this.compareDistances(genericPropertyContainer, genericPropertyContainer2);
                if (0 != n) {
                    return n;
                }
                return this.comparePrices(genericPropertyContainer, genericPropertyContainer2);
            }
            case 2: {
                int n = this.compareDistances(genericPropertyContainer, genericPropertyContainer2);
                if (0 != n) {
                    return n;
                }
                n = this.comparePrices(genericPropertyContainer, genericPropertyContainer2);
                if (0 != n) {
                    return n;
                }
                return this.compareNames(genericPropertyContainer, genericPropertyContainer2);
            }
            case 1: {
                int n = this.comparePrices(genericPropertyContainer, genericPropertyContainer2);
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
        String string = GenericPropertyUtility.getString(597755648, 0, genericPropertyContainer);
        String string2 = GenericPropertyUtility.getString(597755648, 0, genericPropertyContainer2);
        if (null == string || null == string2) {
            return 0;
        }
        return string.compareToIgnoreCase(string2);
    }

    private int compareDistances(GenericPropertyContainer genericPropertyContainer, GenericPropertyContainer genericPropertyContainer2) {
        int n = GenericPropertyUtility.getInt(614532864, 0, genericPropertyContainer);
        int n2 = GenericPropertyUtility.getInt(614532864, 0, genericPropertyContainer2);
        return n - n2;
    }

    private int comparePrices(GenericPropertyContainer genericPropertyContainer, GenericPropertyContainer genericPropertyContainer2) {
        float f2;
        float f3 = GenericPropertyUtility.getFloat(648087296, 0, genericPropertyContainer);
        if (0.0f < f3 - (f2 = GenericPropertyUtility.getFloat(648087296, 0, genericPropertyContainer2))) {
            return 1;
        }
        if (0.0f > f3 - f2) {
            return -1;
        }
        return 0;
    }
}

