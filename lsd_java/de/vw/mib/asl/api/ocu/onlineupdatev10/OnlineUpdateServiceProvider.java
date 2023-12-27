/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ocu.onlineupdatev10;

import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateService;
import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateServiceListener;

public interface OnlineUpdateServiceProvider {
    default public OnlineUpdateService getOnlineUpdateService() {
    }

    default public void registerOnlineUpdateServiceListener(OnlineUpdateServiceListener onlineUpdateServiceListener) {
    }

    default public void unRegisterOnlineUpdateServiceListener(OnlineUpdateServiceListener onlineUpdateServiceListener) {
    }
}

