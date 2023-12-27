/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.speechengine.vde.Capabilities;
import org.dsi.ifc.global.ResourceLocator;

public interface CurrentLocationListener {
    default public void onCountryChanged(INavigationLocation iNavigationLocation, Capabilities capabilities) {
    }

    default public void onCountryFlagChanged(INavigationLocation iNavigationLocation, ResourceLocator resourceLocator) {
    }
}

