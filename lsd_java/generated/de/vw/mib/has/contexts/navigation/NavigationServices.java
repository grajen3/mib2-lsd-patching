/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.navigation;

import de.vw.mib.has.HASContextServices;
import generated.de.vw.mib.has.containers.AddressContainer;
import generated.de.vw.mib.has.containers.ImportGPXDataContainer;
import generated.de.vw.mib.has.containers.LastDestinationContainer;

public interface NavigationServices
extends HASContextServices {
    default public void saveDestination(int n, AddressContainer addressContainer) {
    }

    default public void startGuidance(int n, AddressContainer addressContainer) {
    }

    default public void addStopOver(int n, AddressContainer addressContainer) {
    }

    default public void resolveAddress(int n, AddressContainer addressContainer) {
    }

    default public void stopGuidance(int n) {
    }

    default public void resolveLastDestination(int n, LastDestinationContainer lastDestinationContainer) {
    }

    default public void importGPX(int n, ImportGPXDataContainer importGPXDataContainer) {
    }

    default public void getLocation() {
    }

    default public void getGuidanceState() {
    }

    default public void getGuidanceDestination() {
    }

    default public void getHeading() {
    }

    default public void getGuidanceRemaining() {
    }

    default public void getLastDestinations() {
    }
}

