/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.model;

import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.model.OnboardPOICategory;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;

public class OnboardPOISearchCriteria {
    public final OnboardPOICategory category;
    public final int area;
    private static final IntIntMap TAG2CRITERIA = new IntIntOptHashMap();

    public OnboardPOISearchCriteria(OnboardPOICategory onboardPOICategory, int n) {
        this.category = onboardPOICategory;
        if (TAG2CRITERIA.containsKey(n)) {
            this.area = TAG2CRITERIA.get(n);
        } else {
            this.area = 0;
            AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(", search area is invalid").toString());
        }
    }

    static {
        TAG2CRITERIA.put(0, 1);
        TAG2CRITERIA.put(1, 3);
        TAG2CRITERIA.put(2, 4);
        TAG2CRITERIA.put(3, 5);
    }
}

