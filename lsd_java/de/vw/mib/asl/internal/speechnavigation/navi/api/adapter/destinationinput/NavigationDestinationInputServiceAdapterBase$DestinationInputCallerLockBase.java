/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.locationinput.NavigationLocationinputService;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapterBase;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;

public class NavigationDestinationInputServiceAdapterBase$DestinationInputCallerLockBase {
    protected DestinationInputListener listener;
    private final NavigationLocationinputService destinationInputService;
    private int type;
    private final /* synthetic */ NavigationDestinationInputServiceAdapterBase this$0;

    public NavigationDestinationInputServiceAdapterBase$DestinationInputCallerLockBase(NavigationDestinationInputServiceAdapterBase navigationDestinationInputServiceAdapterBase, NavigationLocationinputService navigationLocationinputService) {
        this.this$0 = navigationDestinationInputServiceAdapterBase;
        this.destinationInputService = navigationLocationinputService;
        this.listener = null;
        this.type = 0;
    }

    public void acquire(DestinationInputListener destinationInputListener, int n) {
        if (this.listener != null) {
            AppLogger.warn(this, new StringBuffer().append(".aquire(..), collision caller detected: ").append(this.toString()).toString());
        }
        this.listener = destinationInputListener;
        this.type = n;
        AppLogger.info(this, new StringBuffer().append(".aquire(..), caller aquired: ").append(this.toString()).toString());
        try {
            this.destinationInputService.weakLockInput();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(this, new StringBuffer().append(".aquire(..), error calling weakLockInput: ").append(navigationServiceException.getMessage()).toString());
            this.release(1);
        }
    }

    public void release(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        if (this.listener == null) {
            AppLogger.warn(this, ".release(..), the caller has been previously released.");
            return;
        }
        AppLogger.info(this, new StringBuffer().append(".release(), caller released: ").append(this.toString()).toString());
        this.listener.setDestinationFieldResponse(n, iNavigationLocation, nArray);
        this.release();
        try {
            this.destinationInputService.unlockInput();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(this, new StringBuffer().append(".release(..),  error calling unlockInput: ").append(navigationServiceException.getMessage()).toString());
        }
    }

    public void release(int n) {
        this.release(n, null, new int[0]);
    }

    public void releaseOnLockLost() {
        AppLogger.info(this, new StringBuffer().append(".releaseOnLockLost(), release on 'lock - lost/not granted', listener: ").append(this.toString()).toString());
        this.release(1);
    }

    public void releaseOnIdle() {
        AppLogger.info(this, new StringBuffer().append(".releaseOnIdle(), release resources on 'app - idle' ").append(this.toString()).toString());
        this.release();
    }

    private void release() {
        this.listener = null;
        this.type = 0;
    }

    public boolean isAcquired() {
        return this.listener != null;
    }

    public String toString() {
        return new StringBuffer().append(super.getClass().getName()).append(", hash = ").append(this.listener.hashCode()).append(", type = ").append(this.type).toString();
    }

    public int getInputType() {
        return this.type;
    }

    public DestinationInputListener getListener() {
        return this.listener;
    }
}

