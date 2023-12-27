/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.appadapter.list;

import de.vw.mib.app.appadapter.list.AppAdapterList;
import de.vw.mib.app.appadapter.list.AppAdapterListUpdateEvent;

public interface AppAdapterListUpdateListener {
    default public void onAppAdapterListChanged(AppAdapterList appAdapterList, AppAdapterListUpdateEvent appAdapterListUpdateEvent) {
    }
}

