/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput;

import de.vw.mib.asl.api.navigation.locationinput.NavigationLocationinputService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapterBase;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapterBase$DestinationInputCallerLockBase;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.ViewModelItem;

public class NavigationDestinationInputServiceAdapterBase$SelectEntryByIndexCaller
extends NavigationDestinationInputServiceAdapterBase$DestinationInputCallerLockBase {
    private ViewModelItem partId;
    private final /* synthetic */ NavigationDestinationInputServiceAdapterBase this$0;

    public NavigationDestinationInputServiceAdapterBase$SelectEntryByIndexCaller(NavigationDestinationInputServiceAdapterBase navigationDestinationInputServiceAdapterBase, NavigationLocationinputService navigationLocationinputService) {
        this.this$0 = navigationDestinationInputServiceAdapterBase;
        super(navigationDestinationInputServiceAdapterBase, navigationLocationinputService);
    }

    @Override
    public void acquire(DestinationInputListener destinationInputListener, int n) {
        this.acquire(destinationInputListener, null, n);
    }

    public void acquire(DestinationInputListener destinationInputListener, ViewModelItem viewModelItem, int n) {
        this.setPartId(viewModelItem);
        super.acquire(destinationInputListener, n);
    }

    public ViewModelItem getPartId() {
        return this.partId;
    }

    public void setPartId(ViewModelItem viewModelItem) {
        this.partId = viewModelItem;
    }
}

