/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory;

import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.listener.GetLastDestinationAddressListener;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.listener.LastDestinationListener;

public interface LastDestinationService {
    default public void getLastDestination(GetLastDestinationAddressListener getLastDestinationAddressListener, INavigationListElement iNavigationListElement) {
    }

    default public void getLastUsedDestination(GetLastDestinationAddressListener getLastDestinationAddressListener) {
    }

    default public INavigationListElement[] getLastDestinations() {
    }

    default public INavigationListElement getLastDestination(long l) {
    }

    default public void register(LastDestinationListener lastDestinationListener) {
    }
}

