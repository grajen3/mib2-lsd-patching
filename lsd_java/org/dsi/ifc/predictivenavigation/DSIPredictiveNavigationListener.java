/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.predictivenavigation;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.predictivenavigation.LikelyDestination;

public interface DSIPredictiveNavigationListener
extends DSIListener {
    default public void updateOperationMode(int n, int n2) {
    }

    default public void updateLikelyDestinations(LikelyDestination[] likelyDestinationArray, int n) {
    }

    default public void updateMaxPredictions(int n, int n2) {
    }

    default public void clearCacheResult() {
    }
}

