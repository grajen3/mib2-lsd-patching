/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.country;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.speechengine.vde.Capabilities;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.DestinationInputService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.CurrentLocationListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationVariant;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationVariantImpl;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import org.dsi.ifc.global.ResourceLocator;

public class DestinationInputCountryUpdater
implements CurrentLocationListener {
    private final DestinationInputService destinationInputService = NavigationDestinationInputServiceAdapter.getService();
    protected final ApplicationVariant variantService = new ApplicationVariantImpl();

    public void registerOnLocationChanges() {
        this.destinationInputService.registerOnCountryChanges(this);
    }

    public void onCurrentLocationChanged(INavigationLocation iNavigationLocation, Capabilities capabilities) {
    }

    @Override
    public void onCountryFlagChanged(INavigationLocation iNavigationLocation, ResourceLocator resourceLocator) {
        if (resourceLocator != null) {
            Framework.getPropertyManager().valueChangedResourceLocator(-1912065024, resourceLocator);
        }
    }

    @Override
    public void onCountryChanged(INavigationLocation iNavigationLocation, Capabilities capabilities) {
        if (this.variantService.isNARVariant()) {
            this.destinationInputService.requestCountryIcon(iNavigationLocation);
        }
    }
}

