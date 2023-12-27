/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.listener;

import de.vw.mib.collections.ints.IntObjectOptHashMap;

final class ContactsDownloadStatusListener$1
extends IntObjectOptHashMap {
    ContactsDownloadStatusListener$1() {
        this.put(0, "STATUS_UNKNOWN");
        this.put(1, "STATUS_DOWNLOADING");
        this.put(2, "STATUS_DOWNLOADED_SUCCEEDED_NAVIGABLE_CONTACTS_AVAILABLE");
        this.put(3, "STATUS_DOWNLOADED_FAILED_NO_CONTACTS");
        this.put(4, "STATUS_DOWNLOADED_FAILED_NO_NAVIGABLE_CONTACTS");
    }
}

