/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.download;

import de.vw.mib.asl.api.download.DownloadStateService;

public interface ASLDownloadAPI {
    default public boolean swdlHighOmitPowerStateChangeIndicationUntilStartSwdlWasCalled() {
    }

    default public boolean getCurrentCustomerDownloadActivityState() {
    }

    default public DownloadStateService getDownloadStateService() {
    }
}

