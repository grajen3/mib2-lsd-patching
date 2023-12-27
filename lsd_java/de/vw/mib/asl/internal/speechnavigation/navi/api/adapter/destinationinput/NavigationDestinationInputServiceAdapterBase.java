/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput;

import de.vw.mib.asl.api.navigation.locationinput.IHnrFlags;
import de.vw.mib.asl.api.navigation.locationinput.NavigationLocationinputListenerAdapter;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapterBase$1;

public class NavigationDestinationInputServiceAdapterBase
extends NavigationLocationinputListenerAdapter {
    protected int houseNumberComputedFieldType = 136;
    protected boolean hasPointLocations = false;
    protected IHnrFlags houseNumberOptions = new NavigationDestinationInputServiceAdapterBase$1(this);

    @Override
    public void updateInputActive(boolean bl) {
    }
}

