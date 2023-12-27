/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput;

import de.vw.mib.asl.api.navigation.locationinput.NavigationLocationinputService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapterBase;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapterBase$DestinationInputCallerLockBase;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;

public class NavigationDestinationInputServiceAdapterBase$InitializeLocationCallerLock
extends NavigationDestinationInputServiceAdapterBase$DestinationInputCallerLockBase {
    private final /* synthetic */ NavigationDestinationInputServiceAdapterBase this$0;

    public NavigationDestinationInputServiceAdapterBase$InitializeLocationCallerLock(NavigationDestinationInputServiceAdapterBase navigationDestinationInputServiceAdapterBase, NavigationLocationinputService navigationLocationinputService) {
        this.this$0 = navigationDestinationInputServiceAdapterBase;
        super(navigationDestinationInputServiceAdapterBase, navigationLocationinputService);
    }

    public void acquire(DestinationInputListener destinationInputListener) {
        super.acquire(destinationInputListener, 0);
    }
}

