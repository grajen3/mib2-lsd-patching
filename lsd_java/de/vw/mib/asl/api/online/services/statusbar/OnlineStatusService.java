/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.online.services.statusbar;

import de.vw.mib.asl.api.online.services.statusbar.OnlineStatusListener;

public interface OnlineStatusService {
    default public void registerOnlineStatusListener(OnlineStatusListener onlineStatusListener) {
    }

    default public void unregisterOnlineStatusListener(OnlineStatusListener onlineStatusListener) {
    }
}

