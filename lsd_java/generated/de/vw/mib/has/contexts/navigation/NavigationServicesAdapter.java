/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.navigation;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.AddressContainer;
import generated.de.vw.mib.has.containers.ImportGPXDataContainer;
import generated.de.vw.mib.has.containers.LastDestinationContainer;
import generated.de.vw.mib.has.contexts.navigation.NavigationServices;

public class NavigationServicesAdapter
implements NavigationServices {
    @Override
    public void actionRequest(int n, int n2, HASContainer hASContainer) {
        switch (n2) {
            case 1: {
                this.saveDestination(n, (AddressContainer)hASContainer);
                break;
            }
            case 2: {
                this.startGuidance(n, (AddressContainer)hASContainer);
                break;
            }
            case 3: {
                this.addStopOver(n, (AddressContainer)hASContainer);
                break;
            }
            case 5: {
                this.resolveAddress(n, (AddressContainer)hASContainer);
                break;
            }
            case 9: {
                this.stopGuidance(n);
                break;
            }
            case 20: {
                this.resolveLastDestination(n, (LastDestinationContainer)hASContainer);
                break;
            }
            case 38: {
                this.importGPX(n, (ImportGPXDataContainer)hASContainer);
                break;
            }
            default: {
                throw HASException.invalidActionRequest(n2);
            }
        }
    }

    @Override
    public void propertyRequest(int n) {
        switch (n) {
            case 1: {
                this.getLocation();
                break;
            }
            case 7: {
                this.getGuidanceState();
                break;
            }
            case 8: {
                this.getGuidanceDestination();
                break;
            }
            case 20: {
                this.getHeading();
                break;
            }
            case 24: {
                this.getGuidanceRemaining();
                break;
            }
            case 29: {
                this.getLastDestinations();
                break;
            }
            default: {
                throw HASException.invalidPropertyRequest(n);
            }
        }
    }

    @Override
    public void saveDestination(int n, AddressContainer addressContainer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void startGuidance(int n, AddressContainer addressContainer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addStopOver(int n, AddressContainer addressContainer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void resolveAddress(int n, AddressContainer addressContainer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void stopGuidance(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void resolveLastDestination(int n, LastDestinationContainer lastDestinationContainer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void importGPX(int n, ImportGPXDataContainer importGPXDataContainer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getLocation() {
    }

    @Override
    public void getGuidanceState() {
    }

    @Override
    public void getGuidanceDestination() {
    }

    @Override
    public void getHeading() {
    }

    @Override
    public void getGuidanceRemaining() {
    }

    @Override
    public void getLastDestinations() {
    }
}

