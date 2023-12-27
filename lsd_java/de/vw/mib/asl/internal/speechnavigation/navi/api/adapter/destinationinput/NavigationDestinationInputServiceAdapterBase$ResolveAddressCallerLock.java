/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.locationinput.NavigationLocationinputService;
import de.vw.mib.asl.api.navigation.memory.INavigationContactAddress;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapterBase;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.ResolveAddressListener;

public class NavigationDestinationInputServiceAdapterBase$ResolveAddressCallerLock {
    private final NavigationLocationinputService destinationInputService;
    private ResolveAddressListener listener;
    private INavigationContactAddress address;
    private final /* synthetic */ NavigationDestinationInputServiceAdapterBase this$0;

    public NavigationDestinationInputServiceAdapterBase$ResolveAddressCallerLock(NavigationDestinationInputServiceAdapterBase navigationDestinationInputServiceAdapterBase, NavigationLocationinputService navigationLocationinputService) {
        this.this$0 = navigationDestinationInputServiceAdapterBase;
        this.destinationInputService = navigationLocationinputService;
        this.listener = null;
    }

    public void acquire(ResolveAddressListener resolveAddressListener, INavigationContactAddress iNavigationContactAddress) {
        if (this.listener != null) {
            AppLogger.warn(new StringBuffer().append("collision caller detected: ").append(this.toString()).toString());
        }
        this.listener = resolveAddressListener;
        this.address = iNavigationContactAddress;
        AppLogger.info(new StringBuffer().append("caller aquired: ").append(this.toString()).toString());
        try {
            this.destinationInputService.weakLockInput();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(this, new StringBuffer().append(", error calling weakLockInput: ").append(navigationServiceException.getMessage()).toString());
            this.release(null);
        }
    }

    public void release(INavigationLocation[] iNavigationLocationArray) {
        if (this.listener == null) {
            AppLogger.warn(this, ".release(..), the caller has been previously released.");
            return;
        }
        if (iNavigationLocationArray == null || iNavigationLocationArray.length == 0) {
            this.listener.resolveAddressResult(1, null);
        } else {
            boolean bl = false;
            for (int i2 = 0; i2 < iNavigationLocationArray.length; ++i2) {
                if (iNavigationLocationArray[i2] != null) {
                    if (iNavigationLocationArray[i2].isValid()) {
                        this.listener.resolveAddressResult(0, iNavigationLocationArray[i2]);
                        bl = true;
                        break;
                    }
                    AppLogger.error(this, new StringBuffer().append(", cannot resolve the address: ").append(this.address).toString() == null ? "null" : new StringBuffer().append(this.address.toString()).append(" to location: ").append(iNavigationLocationArray[i2].toString()).toString());
                    continue;
                }
                AppLogger.error(this, new StringBuffer().append(", cannot resolve the address: ").append(this.address).toString() == null ? "null" : new StringBuffer().append(this.address.toString()).append(" to location: null").toString());
            }
            if (!bl) {
                this.listener.resolveAddressResult(1, null);
            }
        }
        AppLogger.info(this, new StringBuffer().append("caller released: ").append(this.toString()).toString());
        this.release();
        try {
            this.destinationInputService.unlockInput();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(this, new StringBuffer().append(", error calling unlockInput: ").append(navigationServiceException.getMessage()).toString());
        }
    }

    public void releaseOnIdle() {
        AppLogger.info(this, new StringBuffer().append(".release(), release resources on 'app - idle' ").append(this.toString()).toString());
        this.release();
    }

    private void release() {
        this.listener = null;
    }

    public boolean isAcquired() {
        return this.listener != null;
    }

    public ResolveAddressListener getListener() {
        return this.listener;
    }

    public INavigationContactAddress getAddress() {
        return this.address;
    }

    public String toString() {
        return new StringBuffer().append(super.getClass().getName()).append(", hash = ").append(this.listener.hashCode()).append(", type = ").append(this.address.toString()).toString();
    }
}

