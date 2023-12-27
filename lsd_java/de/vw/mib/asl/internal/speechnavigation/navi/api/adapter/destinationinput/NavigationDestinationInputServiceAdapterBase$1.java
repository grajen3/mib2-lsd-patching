/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput;

import de.vw.mib.asl.api.navigation.locationinput.IHnrFlags;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapterBase;

class NavigationDestinationInputServiceAdapterBase$1
implements IHnrFlags {
    private final /* synthetic */ NavigationDestinationInputServiceAdapterBase this$0;

    NavigationDestinationInputServiceAdapterBase$1(NavigationDestinationInputServiceAdapterBase navigationDestinationInputServiceAdapterBase) {
        this.this$0 = navigationDestinationInputServiceAdapterBase;
    }

    @Override
    public boolean isHousenumberUnique() {
        return true;
    }

    @Override
    public boolean isHousenumberNone() {
        return false;
    }

    @Override
    public boolean isHousenumberMatchesFound() {
        return false;
    }

    @Override
    public boolean isHousenumberAlternatives() {
        return false;
    }
}

