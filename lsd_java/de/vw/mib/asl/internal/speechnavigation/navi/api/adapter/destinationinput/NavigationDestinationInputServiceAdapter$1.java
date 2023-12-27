/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput;

import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.listener.GetLastDestinationAddressListener;

class NavigationDestinationInputServiceAdapter$1
implements GetLastDestinationAddressListener {
    private final /* synthetic */ DestinationInputListener val$listener;
    private final /* synthetic */ NavigationDestinationInputServiceAdapter this$0;

    NavigationDestinationInputServiceAdapter$1(NavigationDestinationInputServiceAdapter navigationDestinationInputServiceAdapter, DestinationInputListener destinationInputListener) {
        this.this$0 = navigationDestinationInputServiceAdapter;
        this.val$listener = destinationInputListener;
    }

    @Override
    public void getLastDestinationAddressResponse(int n, INavigationListElement iNavigationListElement, INavigationLocation iNavigationLocation) {
        if (n == 0) {
            if (iNavigationLocation != null && iNavigationLocation.isValid()) {
                this.onLastUsedDestinationValid(this.val$listener, iNavigationLocation);
            } else {
                this.onLastUsedDestinationInvalid(this.val$listener);
            }
        } else {
            AppLogger.error(this, ".getLastUsedDestination(..) failed");
            this.this$0.initLocationCaller.release(1);
        }
    }

    private void onLastUsedDestinationInvalid(DestinationInputListener destinationInputListener) {
        try {
            AppLogger.warn(this, ".onLastUsedDestinationInvalid(), last used destination is invalid, fallback to current navi location");
            this.setCurrentLocation(destinationInputListener, this.this$0.destinationInputService.getCurrentLocation());
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(this, new StringBuffer().append(".onLastUsedDestinationInvalid(), cannot fallback to NAVI default location: ").append(navigationServiceException.getMessage()).toString());
            this.this$0.initLocationCaller.release(1);
        }
    }

    private void onLastUsedDestinationValid(DestinationInputListener destinationInputListener, INavigationLocation iNavigationLocation) {
        this.setCurrentLocation(destinationInputListener, iNavigationLocation);
    }

    private void setCurrentLocation(DestinationInputListener destinationInputListener, INavigationLocation iNavigationLocation) {
        try {
            this.this$0.destinationInputService.setCurrentLocation(iNavigationLocation);
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(this, new StringBuffer().append(".setCurrentLocation(..) failed: ").append(navigationServiceException.getMessage()).toString());
            this.this$0.initLocationCaller.release(1);
        }
    }
}

