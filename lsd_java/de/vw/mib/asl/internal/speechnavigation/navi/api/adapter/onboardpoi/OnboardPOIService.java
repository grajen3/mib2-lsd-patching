/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onboardpoi;

import de.vw.mib.asl.api.navigation.poi.onboard.IOnboardPoiListElement;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onboardpoi.listener.ResolvePOIAddressListener;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onboardpoi.listener.SearchPOIListener;

public interface OnboardPOIService {
    public static final int POISEARCHSTATUS_INVALID;
    public static final int POISEARCHSTATUS_CANCELED;
    public static final int POISEARCHSTATUS_RUNNING;
    public static final int POISEARCHSTATUS_FINISHED;

    default public void startSearch(SearchPOIListener searchPOIListener, long l, int n) {
    }

    default public void stopSearch() {
    }

    default public void resolveEntry(ResolvePOIAddressListener resolvePOIAddressListener, IOnboardPoiListElement iOnboardPoiListElement) {
    }

    default public void release() {
    }
}

