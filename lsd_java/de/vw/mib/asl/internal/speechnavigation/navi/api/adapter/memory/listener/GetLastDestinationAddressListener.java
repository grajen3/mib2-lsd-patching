/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.listener;

import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.api.navigation.INavigationLocation;

public interface GetLastDestinationAddressListener {
    default public void getLastDestinationAddressResponse(int n, INavigationListElement iNavigationListElement, INavigationLocation iNavigationLocation) {
    }
}

