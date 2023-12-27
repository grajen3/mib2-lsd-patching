/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink;

import de.vw.mib.asl.api.navigation.AbstractASLNavigationServicesListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;

public final class ASLNavigationServicesListener
extends AbstractASLNavigationServicesListener {
    private boolean navServiceAvailable = false;
    private boolean guidanceState = false;
    private int contactCapacity = 0;

    @Override
    public void updateContactCapacity(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("ASLNavigationServicesListener : updateContactCapacity() = ").append(n).log();
        }
        this.contactCapacity = n;
    }

    @Override
    public void updateGuidanceActive(boolean bl) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append("ASLNavigationServicesListener : updateGuidanceActive() = ").append(bl).log();
            }
            this.guidanceState = bl;
            TLinkServiceManager.getServiceManager().getGuiControllerMain().updateRouteGuidanceState(this.guidanceState);
            if (!this.guidanceState) {
                ServiceManager.aslPropertyManager.valueChangedString(138420992, "");
                ServiceManager.aslPropertyManager.valueChangedString(121643776, "");
                TLinkServiceManager.getServiceManager().getGuiControllerMovies().setMovieTheatersSearchArea(0);
                TLinkServiceManager.getServiceManager().getGuiControllerMovies().setMoviesSearchArea(0);
                TLinkServiceManager.getServiceManager().getGuiControllerFuel().setFuelStationSearchArea(0);
                TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setFuelStationSearchArea(0);
                TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setMovieTheatersSearchArea(0);
                TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setMoviesSearchArea(0);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void updateServiceAvailable(boolean bl) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("ASLNavigationServicesListener : updateServiceAvailable() = ").append(bl).log();
        }
        this.navServiceAvailable = bl;
    }

    public boolean isNavServiceAvailable() {
        return this.navServiceAvailable;
    }

    public boolean isGuidanceStateActive() {
        return this.guidanceState;
    }

    public int getContactCapacity() {
        return this.contactCapacity;
    }
}

