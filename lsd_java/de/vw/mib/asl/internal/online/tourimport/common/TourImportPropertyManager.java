/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.tourimport.common;

public class TourImportPropertyManager {
    private int tourMemoryCapacity = -1;
    private int toursAvailable = -1;
    private boolean isDownloadAllowed = true;
    private boolean isDownloadActive;
    private int importResult = -1;
    private int _requestedTours;

    public int getImportResult() {
        return this.importResult;
    }

    public void setImportResult(int n) {
        this.importResult = n;
    }

    public boolean isDownloadActive() {
        return this.isDownloadActive;
    }

    public void setDownloadActive(boolean bl) {
        this.isDownloadActive = bl;
    }

    public boolean isDownloadAllowed() {
        return this.isDownloadAllowed;
    }

    public void setDownloadAllowed(boolean bl) {
        this.isDownloadAllowed = bl;
    }

    public int getTourMemoryCapacity() {
        return this.tourMemoryCapacity;
    }

    public void setTourMemoryCapacity(int n) {
        this.tourMemoryCapacity = n;
    }

    public int getToursAvailable() {
        return this.toursAvailable;
    }

    public void setToursAvailable(int n) {
        this.toursAvailable = n;
    }

    public int getRequestedTours() {
        return this._requestedTours;
    }

    public void setRequestedTours(int n) {
        this._requestedTours = n;
    }
}

