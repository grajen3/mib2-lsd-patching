/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory;

import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.NavigationMemoryServiceAdapterBase;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.listener.ContactsDownloadStatusListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class NavigationMemoryServiceAdapterBase$DownloadContactsStatus {
    private int allPhoneContactsCount = 0;
    private int allNavigableContactsCount = 0;
    private int currentContactsDownloadStatus = 0;
    private final List listeners = new ArrayList();
    private final /* synthetic */ NavigationMemoryServiceAdapterBase this$0;

    public NavigationMemoryServiceAdapterBase$DownloadContactsStatus(NavigationMemoryServiceAdapterBase navigationMemoryServiceAdapterBase) {
        this.this$0 = navigationMemoryServiceAdapterBase;
    }

    public void register(ContactsDownloadStatusListener contactsDownloadStatusListener) {
        this.listeners.add(contactsDownloadStatusListener);
    }

    public int getStatus() {
        return this.currentContactsDownloadStatus;
    }

    public void updateDownloadStatus(int n) {
        ListIterator listIterator = this.listeners.listIterator();
        block4: while (listIterator.hasNext()) {
            ContactsDownloadStatusListener contactsDownloadStatusListener = (ContactsDownloadStatusListener)listIterator.next();
            switch (n) {
                case 0: {
                    this.currentContactsDownloadStatus = 0;
                    contactsDownloadStatusListener.onDownloadStatus(0);
                    continue block4;
                }
                case 1: 
                case 2: 
                case 3: 
                case 6: {
                    this.currentContactsDownloadStatus = 1;
                    contactsDownloadStatusListener.onDownloadStatus(1);
                    continue block4;
                }
            }
            this.updateImportStatus(this.allPhoneContactsCount, this.allNavigableContactsCount);
        }
    }

    public void updateImportStatus() {
        this.updateImportStatus(this.allPhoneContactsCount, this.allNavigableContactsCount);
    }

    public void updateImportStatus(int n, int n2) {
        this.allPhoneContactsCount = n;
        this.allNavigableContactsCount = n2;
        AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(".updateImportStatus( ").append("allPhoneContacts = ").append(n).append(", ").append("allNavigableContacts = ").append(n2).append(" )").toString());
        ListIterator listIterator = this.listeners.listIterator();
        while (listIterator.hasNext()) {
            ContactsDownloadStatusListener contactsDownloadStatusListener = (ContactsDownloadStatusListener)listIterator.next();
            if (n == 0 && n2 == 0) {
                this.currentContactsDownloadStatus = 3;
                contactsDownloadStatusListener.onDownloadStatus(3);
                continue;
            }
            if (n > 0 && n2 == 0) {
                this.currentContactsDownloadStatus = 4;
                contactsDownloadStatusListener.onDownloadStatus(4);
                continue;
            }
            if (n2 <= 0) continue;
            this.currentContactsDownloadStatus = 2;
            contactsDownloadStatusListener.onDownloadStatus(2);
        }
    }
}

