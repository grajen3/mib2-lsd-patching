/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.listener;

import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.listener.ContactsDownloadStatusListener$1;
import de.vw.mib.collections.ints.IntObjectOptHashMap;

public interface ContactsDownloadStatusListener {
    public static final int STATUS_UNKNOWN;
    public static final int STATUS_DOWNLOADING;
    public static final int STATUS_DOWNLOADED_SUCCEEDED_NAVIGABLE_CONTACTS_AVAILABLE;
    public static final int STATUS_DOWNLOADED_FAILED_NO_CONTACTS;
    public static final int STATUS_DOWNLOADED_FAILED_NO_NAVIGABLE_CONTACTS;
    public static final IntObjectOptHashMap STATUS_DOWNLOAD_MAP;

    default public void onDownloadStatus(int n) {
    }

    static {
        STATUS_DOWNLOAD_MAP = new ContactsDownloadStatusListener$1();
    }
}

