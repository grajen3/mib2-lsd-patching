/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.navigation;

import de.vw.mib.has.HASContextProperties;
import generated.de.vw.mib.has.containers.AddressContainer;
import generated.de.vw.mib.has.containers.GuidanceRemainingContainer;
import generated.de.vw.mib.has.containers.LastDestinationsContainer;

public interface NavigationProperties
extends HASContextProperties {
    default public void updateLocation(AddressContainer addressContainer) {
    }

    default public void updateGuidanceState(int n) {
    }

    default public void updateGuidanceDestination(AddressContainer addressContainer) {
    }

    default public void updateHeading(int n) {
    }

    default public void updateGuidanceRemaining(GuidanceRemainingContainer guidanceRemainingContainer) {
    }

    default public void updateLastDestinations(LastDestinationsContainer lastDestinationsContainer) {
    }
}

