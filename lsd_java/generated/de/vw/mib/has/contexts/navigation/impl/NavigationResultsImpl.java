/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.navigation.impl;

import de.vw.mib.has.HASBaseContainerFactory;
import de.vw.mib.has.HASContextResults;
import generated.de.vw.mib.has.containers.AddressContainer;
import generated.de.vw.mib.has.containers.ImportGPXResultContainer;
import generated.de.vw.mib.has.containers.StartGuidanceResultContainer;
import generated.de.vw.mib.has.contexts.impl.AbstractContextResults;
import generated.de.vw.mib.has.contexts.navigation.NavigationResults;

public class NavigationResultsImpl
extends AbstractContextResults
implements NavigationResults {
    public NavigationResultsImpl(HASContextResults hASContextResults, HASBaseContainerFactory hASBaseContainerFactory) {
        super(hASContextResults, hASBaseContainerFactory);
    }

    @Override
    public void saveDestinationResult(int n, int n2) {
        this.callResult(n, 1, n2);
    }

    @Override
    public void startGuidanceResult(int n, int n2, StartGuidanceResultContainer startGuidanceResultContainer) {
        this.callResult(n, 2, n2, startGuidanceResultContainer);
    }

    @Override
    public void addStopOverResult(int n, int n2) {
        this.callResult(n, 3, n2);
    }

    @Override
    public void resolveAddressResult(int n, int n2, AddressContainer addressContainer) {
        this.callResult(n, 5, n2, addressContainer);
    }

    @Override
    public void stopGuidanceResult(int n, int n2) {
        this.callResult(n, 9, n2);
    }

    @Override
    public void resolveLastDestinationResult(int n, int n2, AddressContainer addressContainer) {
        this.callResult(n, 20, n2, addressContainer);
    }

    @Override
    public void importGPXResult(int n, int n2, ImportGPXResultContainer importGPXResultContainer) {
        this.callResult(n, 38, n2, importGPXResultContainer);
    }
}

