/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.navigation;

import de.vw.mib.has.HASContextResults;
import generated.de.vw.mib.has.containers.AddressContainer;
import generated.de.vw.mib.has.containers.ImportGPXResultContainer;
import generated.de.vw.mib.has.containers.StartGuidanceResultContainer;

public interface NavigationResults
extends HASContextResults {
    default public void saveDestinationResult(int n, int n2) {
    }

    default public void startGuidanceResult(int n, int n2, StartGuidanceResultContainer startGuidanceResultContainer) {
    }

    default public void addStopOverResult(int n, int n2) {
    }

    default public void resolveAddressResult(int n, int n2, AddressContainer addressContainer) {
    }

    default public void stopGuidanceResult(int n, int n2) {
    }

    default public void resolveLastDestinationResult(int n, int n2, AddressContainer addressContainer) {
    }

    default public void importGPXResult(int n, int n2, ImportGPXResultContainer importGPXResultContainer) {
    }
}

