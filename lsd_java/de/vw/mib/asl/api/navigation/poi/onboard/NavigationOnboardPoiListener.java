/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.poi.onboard;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.poi.onboard.IOnboardPoiListElement;

public interface NavigationOnboardPoiListener {
    default public void updateLock(boolean bl) {
    }

    default public void updateSearchStatus(int n, int n2, int n3) {
    }

    default public void valueListBlock(IOnboardPoiListElement[] iOnboardPoiListElementArray, int n) {
    }

    default public void resolveEntryResult(INavigationLocation iNavigationLocation) {
    }

    default public void poiListEntryChanged(IOnboardPoiListElement iOnboardPoiListElement) {
    }
}

