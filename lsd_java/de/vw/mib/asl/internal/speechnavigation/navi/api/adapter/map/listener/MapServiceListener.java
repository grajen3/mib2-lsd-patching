/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.map.listener;

import de.vw.mib.asl.api.navigation.INavigationLocation;

public interface MapServiceListener {
    default public void showAddressOnMapResponse(int n, INavigationLocation iNavigationLocation) {
    }
}

