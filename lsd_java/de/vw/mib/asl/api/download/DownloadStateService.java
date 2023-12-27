/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.download;

import de.vw.mib.asl.api.download.DownloadStateListener;

public interface DownloadStateService {
    public static final int DOWNLOAD_STATE_OK;
    public static final int DWONLOAD_STATE_CANCELLED;
    public static final int DWONLOAD_STATE_ERROR;
    public static final int DOWNLOAD_STATE_NOT_INIT;

    default public int getDownloadProgressState() {
    }

    default public void addListener(DownloadStateListener downloadStateListener) {
    }

    default public void removeListener(DownloadStateListener downloadStateListener) {
    }
}

