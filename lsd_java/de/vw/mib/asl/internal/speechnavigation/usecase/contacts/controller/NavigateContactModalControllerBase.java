/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.contacts.controller;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.messenger.slot.SlotStateConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.common.SpeechServices;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.ContactsService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.NavigationMemoryServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.listener.ContactsDownloadStatusListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationModalControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.collections.ints.IntObjectOptHashMap;

public abstract class NavigateContactModalControllerBase
extends ApplicationModalControllerBase
implements SlotStateConsumer,
ContactsDownloadStatusListener {
    private int naviImportStatus = 0;
    private int slotStatus = -1;
    protected final ContactsService contactsService;
    private static final IntObjectOptHashMap COMPILATION_RESULT_MAP = new IntObjectOptHashMap();
    private static final IntObjectOptHashMap COMPILATION_STATUS_MAP = new IntObjectOptHashMap();

    public NavigateContactModalControllerBase() {
        SpeechServices.getSlotStateService().register(81, this);
        this.contactsService = NavigationMemoryServiceAdapter.getContactsService();
        this.contactsService.register(this);
    }

    @Override
    protected void checkPrerequisites() {
        super.checkPrerequisites();
        this.checkGrammarCompilationStatus();
    }

    @Override
    public void onDownloadStatus(int n) {
        this.naviImportStatus = n;
        AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(".onDownloadStatus( importStatus = ").append((String)ContactsDownloadStatusListener.STATUS_DOWNLOAD_MAP.get(n)).append(" )").toString());
        if (this.naviImportStatus == 0) {
            Framework.updateUIValue(1795699712, 0);
            AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(", IMPORT_STATUS = IMPORT_STATUS__C0_IMPORT_NOT_STARTED ").toString());
        } else if (this.naviImportStatus == 1) {
            Framework.updateUIValue(1795699712, 1);
            AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(", IMPORT_STATUS = IMPORT_STATUS__C1_IMPORT_IN_PROGRESS ").toString());
        } else {
            Framework.updateUIValue(1795699712, 2);
            AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(", IMPORT_STATUS = IMPORT_STATUS__C2_IMPORT_FINISHED ").toString());
        }
    }

    @Override
    public void onSlotStateChanged(int n, int n2) {
        this.slotStatus = n2;
        AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(".onSlotStateChanged( ").append("slotId = ").append(n).append(", slotStatus = ").append((String)COMPILATION_STATUS_MAP.get(n2)).append(" ) ").toString());
        Framework.updateUIValue(1812476928, n2);
        if (this.slotStatus == 2 || this.slotStatus == 5 || this.slotStatus == 3 || this.slotStatus == -1) {
            Framework.updateUIValue(1778922496, 0);
            AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(", COMPILATION_RESULT = COMPILATION_RESULT__C0_NO_CONTACTS_SPEAKABLE ").toString());
        } else if (this.slotStatus == 1) {
            Framework.updateUIValue(1778922496, 2);
            AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(", COMPILATION_RESULT = COMPILATION_RESULT__C2_ALL_CONTACTS_SPEAKABLE ").toString());
        } else if (this.slotStatus == 4) {
            Framework.updateUIValue(1778922496, 1);
            AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(", COMPILATION_RESULT = COMPILATION_RESULT__C1_SOME_CONTACTS_SPEAKABLE ").toString());
        }
    }

    protected void checkGrammarCompilationStatus() {
        if (this.slotStatus == 2) {
            this.onCompilationActive();
            throw new NavigationServiceException(" grammar compilation is active ");
        }
        if (this.slotStatus == 5) {
            this.onCompilationFailed();
            throw new NavigationServiceException(" grammar compilation failed ");
        }
        if (this.slotStatus == 3) {
            this.onCompilationFailed();
            throw new NavigationServiceException(" slot is NOT available");
        }
        this.checkImportStatus();
    }

    protected void checkImportStatus() {
        if (this.naviImportStatus == 0) {
            this.onNoContactsAvailable();
            throw new NavigationServiceException(" import is not started or media disconnected ");
        }
        if (this.naviImportStatus == 1) {
            this.onImportActive();
            throw new NavigationServiceException(" import is in progress ");
        }
        if (this.naviImportStatus == 3) {
            this.onNoContactsAvailable();
            throw new NavigationServiceException(" imported list is empty, no contacts available ");
        }
        if (this.naviImportStatus == 4) {
            this.onNoNavigableContactsAvailable();
            throw new NavigationServiceException(" imported list is empty, no navigable contacts available ");
        }
    }

    private void onImportActive() {
        Framework.fireUIEvent(-486001664);
    }

    private void onCompilationActive() {
        Framework.fireUIEvent(-469224448);
    }

    private void onCompilationFailed() {
        Framework.fireUIEvent(-418892800);
    }

    private void onNoContactsAvailable() {
        Framework.fireUIEvent(-435670016);
    }

    private void onNoNavigableContactsAvailable() {
        Framework.fireUIEvent(-452447232);
    }

    static {
        COMPILATION_STATUS_MAP.put(0, "COMPILATION_STATUS__C0_SLOT_STATUS_UNKNOWN");
        COMPILATION_STATUS_MAP.put(1, "COMPILATION_STATUS__C1_SLOT_STATUS_AVAILABLE");
        COMPILATION_STATUS_MAP.put(2, "COMPILATION_STATUS__C2_SLOT_STATUS_COMPILING");
        COMPILATION_STATUS_MAP.put(3, "COMPILATION_STATUS__C3_SLOT_STATUS_UNAVAILABLE");
        COMPILATION_STATUS_MAP.put(4, "COMPILATION_STATUS__C4_SLOT_STATUS_PARTIAL_COMPILATION_FAILURE");
        COMPILATION_STATUS_MAP.put(5, "COMPILATION_STATUS__C5_SLOT_STATUS_COMPILATION_FAILURE");
        COMPILATION_RESULT_MAP.put(0, "COMPILATION_RESULT__C0_NO_CONTACTS_SPEAKABLE");
        COMPILATION_RESULT_MAP.put(1, "COMPILATION_RESULT__C1_SOME_CONTACTS_SPEAKABLE");
        COMPILATION_RESULT_MAP.put(2, "COMPILATION_RESULT__C2_ALL_CONTACTS_SPEAKABLE");
    }
}

