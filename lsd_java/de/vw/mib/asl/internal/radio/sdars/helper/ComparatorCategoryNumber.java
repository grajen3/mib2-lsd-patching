/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import java.util.Comparator;
import org.dsi.ifc.sdars.CategoryInfo;

public final class ComparatorCategoryNumber
implements Comparator {
    @Override
    public int compare(Object object, Object object2) {
        if (object == null || object2 == null) {
            throw new ClassCastException();
        }
        CategoryInfo categoryInfo = (CategoryInfo)object;
        CategoryInfo categoryInfo2 = (CategoryInfo)object2;
        if (categoryInfo.categoryNumber > categoryInfo2.categoryNumber) {
            return 1;
        }
        if (categoryInfo.categoryNumber < categoryInfo2.categoryNumber) {
            return -1;
        }
        return 0;
    }

    public String toString() {
        return "CategoryComparatorByNumber";
    }
}

