/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.phone.callback;

public interface ContactlistUpdates {
    public static final int STATUS_DOWNLOADING;
    public static final int STATUS_EMPTY;
    public static final int STATUS_PHONENUMBERS;
    public static final int STATUS_HOLLOW;

    default public void onDownloadStatus(int n) {
    }
}

