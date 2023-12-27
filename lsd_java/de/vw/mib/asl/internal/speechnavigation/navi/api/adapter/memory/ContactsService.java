/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory;

import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.listener.ContactsDownloadStatusListener;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.listener.GetContactsListener;

public interface ContactsService {
    default public void getContacts(GetContactsListener getContactsListener, long[] lArray) {
    }

    default public void register(ContactsDownloadStatusListener contactsDownloadStatusListener) {
    }
}

