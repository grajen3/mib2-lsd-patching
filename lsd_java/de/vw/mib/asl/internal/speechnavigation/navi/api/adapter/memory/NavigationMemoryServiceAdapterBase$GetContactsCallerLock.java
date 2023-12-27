/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory;

import de.vw.mib.asl.api.navigation.memory.INavigationContact;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.NavigationMemoryServiceAdapterBase;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.listener.GetContactsListener;

public class NavigationMemoryServiceAdapterBase$GetContactsCallerLock {
    private GetContactsListener listener = null;
    private long[] ids;
    private final /* synthetic */ NavigationMemoryServiceAdapterBase this$0;

    public NavigationMemoryServiceAdapterBase$GetContactsCallerLock(NavigationMemoryServiceAdapterBase navigationMemoryServiceAdapterBase) {
        this.this$0 = navigationMemoryServiceAdapterBase;
    }

    public void acquire(GetContactsListener getContactsListener, long[] lArray) {
        if (this.listener != null) {
            AppLogger.warn(new StringBuffer().append("collision caller detected: ").append(this.toString()).toString());
        }
        this.listener = getContactsListener;
        this.ids = lArray;
        AppLogger.info(new StringBuffer().append("caller aquired: ").append(this.toString()).toString());
    }

    public void release(int n, INavigationContact[] iNavigationContactArray) {
        this.listener.getContactsResponse(n, iNavigationContactArray);
        this.release();
    }

    public void release(int n) {
        this.release(n, null);
    }

    private void release() {
        AppLogger.info(new StringBuffer().append("caller released: ").append(this.toString()).toString());
        this.listener = null;
    }

    public boolean isAcquired() {
        return this.listener != null;
    }

    public String toString() {
        return new StringBuffer().append(super.getClass().getName()).append(" - ").append(this.listener.hashCode()).append(" - ").append(this.ids.toString()).toString();
    }
}

