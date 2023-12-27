/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory;

import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.NavigationMemoryServiceAdapterBase;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.listener.GetLastDestinationAddressListener;

public class NavigationMemoryServiceAdapterBase$GetLastDestinationCallerLock {
    private GetLastDestinationAddressListener listener = null;
    private INavigationListElement element;
    private final /* synthetic */ NavigationMemoryServiceAdapterBase this$0;

    public NavigationMemoryServiceAdapterBase$GetLastDestinationCallerLock(NavigationMemoryServiceAdapterBase navigationMemoryServiceAdapterBase) {
        this.this$0 = navigationMemoryServiceAdapterBase;
    }

    public void acquire(GetLastDestinationAddressListener getLastDestinationAddressListener, INavigationListElement iNavigationListElement) {
        if (this.listener != null) {
            AppLogger.warn(new StringBuffer().append("collision caller detected: ").append(this.toString()).toString());
        }
        this.listener = getLastDestinationAddressListener;
        this.element = iNavigationListElement;
        AppLogger.info(new StringBuffer().append("caller aquired: ").append(this.toString()).toString());
    }

    public void release(int n, INavigationListElement iNavigationListElement) {
        this.release(n, iNavigationListElement, null);
    }

    public void release(int n, INavigationListElement iNavigationListElement, INavigationLocation iNavigationLocation) {
        this.listener.getLastDestinationAddressResponse(n, iNavigationListElement, iNavigationLocation);
        this.release();
    }

    private void release() {
        AppLogger.info(new StringBuffer().append("caller released: ").append(this.toString()).toString());
        this.listener = null;
    }

    public boolean isAcquired() {
        return this.listener != null;
    }

    public String toString() {
        return new StringBuffer().append(super.getClass().getName()).append(" - ").append(this.listener.hashCode()).append(" - ").append(this.element.getTitle()).append(" : ").append(this.element.getId()).toString();
    }
}

