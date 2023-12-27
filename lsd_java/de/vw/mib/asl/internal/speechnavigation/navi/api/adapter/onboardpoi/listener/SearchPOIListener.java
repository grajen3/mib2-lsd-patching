/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onboardpoi.listener;

import de.vw.mib.asl.api.navigation.poi.onboard.IOnboardPoiListElement;

public interface SearchPOIListener {
    default public void updateSearchStatus(int n, int n2, int n3, int n4) {
    }

    default public void updatePOIs(IOnboardPoiListElement[] iOnboardPoiListElementArray) {
    }
}

