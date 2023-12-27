/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput;

import de.vw.mib.asl.api.navigation.locationinput.NavigationLocationinputService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapterBase;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapterBase$DestinationInputCallerLockBase;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;

public class NavigationDestinationInputServiceAdapterBase$SelectInputTypeCallerLock
extends NavigationDestinationInputServiceAdapterBase$DestinationInputCallerLockBase {
    private String partId;
    private final /* synthetic */ NavigationDestinationInputServiceAdapterBase this$0;

    public NavigationDestinationInputServiceAdapterBase$SelectInputTypeCallerLock(NavigationDestinationInputServiceAdapterBase navigationDestinationInputServiceAdapterBase, NavigationLocationinputService navigationLocationinputService) {
        this.this$0 = navigationDestinationInputServiceAdapterBase;
        super(navigationDestinationInputServiceAdapterBase, navigationLocationinputService);
    }

    @Override
    public void acquire(DestinationInputListener destinationInputListener, int n) {
        this.acquire(destinationInputListener, null, n);
    }

    public void acquire(DestinationInputListener destinationInputListener, String string, int n) {
        this.setPartId(string);
        super.acquire(destinationInputListener, n);
    }

    public String getPartId() {
        return this.partId;
    }

    public void setPartId(String string) {
        this.partId = string;
    }
}

