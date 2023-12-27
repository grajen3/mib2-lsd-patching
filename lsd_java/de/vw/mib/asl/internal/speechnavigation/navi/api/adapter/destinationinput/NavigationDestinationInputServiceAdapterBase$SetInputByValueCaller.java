/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.locationinput.NavigationLocationinputService;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapterBase;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.GetValuePartMatchesListener;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.GetValuePartMatchesListener$HouseNumberListInfo;

public class NavigationDestinationInputServiceAdapterBase$SetInputByValueCaller {
    protected GetValuePartMatchesListener listener;
    private final NavigationLocationinputService destinationInputService;
    private int type;
    private String partId;
    private GetValuePartMatchesListener$HouseNumberListInfo hnListInfo;
    private final /* synthetic */ NavigationDestinationInputServiceAdapterBase this$0;

    public NavigationDestinationInputServiceAdapterBase$SetInputByValueCaller(NavigationDestinationInputServiceAdapterBase navigationDestinationInputServiceAdapterBase, NavigationLocationinputService navigationLocationinputService) {
        this.this$0 = navigationDestinationInputServiceAdapterBase;
        this.destinationInputService = navigationLocationinputService;
        this.listener = null;
        this.hnListInfo = null;
        this.type = 0;
    }

    public void acquire(GetValuePartMatchesListener getValuePartMatchesListener, String string, int n) {
        this.partId = string;
        this.acquire(getValuePartMatchesListener, n);
    }

    public void acquire(GetValuePartMatchesListener getValuePartMatchesListener, int n) {
        if (this.listener != null) {
            AppLogger.warn(this, new StringBuffer().append(".aquire(..), collision caller detected: ").append(this.toString()).toString());
        }
        this.listener = getValuePartMatchesListener;
        this.type = n;
        AppLogger.info(this, new StringBuffer().append(".aquire(..), caller aquired: ").append(this.toString()).toString());
        try {
            this.destinationInputService.weakLockInput();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(this, new StringBuffer().append(", error calling lockInput: ").append(navigationServiceException.getMessage()).toString());
            this.release(1);
        }
    }

    public String getPartId() {
        return this.partId;
    }

    public GetValuePartMatchesListener getListener() {
        return this.listener;
    }

    public int getType() {
        return this.type;
    }

    public void release(int n, GetValuePartMatchesListener$HouseNumberListInfo getValuePartMatchesListener$HouseNumberListInfo) {
        if (this.listener == null) {
            AppLogger.warn(this, ".release(..), the caller has been previously released.");
            return;
        }
        if (this.hnListInfo == null) {
            this.hnListInfo = getValuePartMatchesListener$HouseNumberListInfo;
        } else {
            this.hnListInfo.addItems(getValuePartMatchesListener$HouseNumberListInfo.getItems());
        }
        AppLogger.info(this, new StringBuffer().append(", retrieved: ").append(this.hnListInfo.getRetrieved()).append(" from total of: ").append(this.hnListInfo.getTotal()).toString());
        if (this.hnListInfo.getTotal() <= this.hnListInfo.getRetrieved()) {
            AppLogger.info(new StringBuffer().append("caller released: ").append(this.toString()).toString());
            this.listener.getValuePartMatchesResponse(n, this.hnListInfo);
            this.release();
        }
    }

    public void releaseOnLockLost() {
        AppLogger.info(this, new StringBuffer().append(".releaseOnLockLost(), release on 'lock - lost/not granted' ").append(this.toString()).toString());
        this.release(1);
    }

    public void release(int n) {
        this.release(n, null);
    }

    public void releaseOnIdle() {
        AppLogger.info(this, new StringBuffer().append(".releaseOnIdle(), release resources on 'app - idle' ").append(this.toString()).toString());
        this.release();
    }

    private void release() {
        this.listener = null;
        this.hnListInfo = null;
        this.type = 0;
    }

    public boolean isAcquired() {
        return this.listener != null;
    }

    public String toString() {
        return new StringBuffer().append(super.getClass().getName()).append(", hash = ").append(this.listener.hashCode()).append(", type = ").append(this.type).toString();
    }
}

