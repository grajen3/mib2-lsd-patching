/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.navigation.impl;

import de.vw.mib.has.HASBaseContainerFactory;
import de.vw.mib.has.HASDatapool;
import generated.de.vw.mib.has.containers.AddressContainer;
import generated.de.vw.mib.has.containers.GuidanceRemainingContainer;
import generated.de.vw.mib.has.containers.LastDestinationsContainer;
import generated.de.vw.mib.has.contexts.impl.AbstractContextProperties;
import generated.de.vw.mib.has.contexts.navigation.NavigationProperties;

public class NavigationPropertiesImpl
extends AbstractContextProperties
implements NavigationProperties {
    public NavigationPropertiesImpl(HASDatapool hASDatapool, HASBaseContainerFactory hASBaseContainerFactory) {
        super(hASDatapool, hASBaseContainerFactory);
    }

    @Override
    public void updateLocation(AddressContainer addressContainer) {
        this.updateProperty(1, addressContainer);
    }

    @Override
    public void updateGuidanceState(int n) {
        this.updateProperty(7, 7, n);
    }

    @Override
    public void updateGuidanceDestination(AddressContainer addressContainer) {
        this.updateProperty(8, addressContainer);
    }

    @Override
    public void updateHeading(int n) {
        this.updateProperty(20, 9, n);
    }

    @Override
    public void updateGuidanceRemaining(GuidanceRemainingContainer guidanceRemainingContainer) {
        this.updateProperty(24, guidanceRemainingContainer);
    }

    @Override
    public void updateLastDestinations(LastDestinationsContainer lastDestinationsContainer) {
        this.updateProperty(29, lastDestinationsContainer);
    }
}

