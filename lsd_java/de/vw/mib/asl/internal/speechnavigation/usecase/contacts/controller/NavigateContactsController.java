/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.contacts.controller;

import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.genericevents.EventGeneric;

public class NavigateContactsController
implements ModelEventConsumer,
RecognizedEventConsumer {
    public static final int RESUME_CMD_NAVIGATE_CONTACTS;
    public static final int CMD_DLG_STATE_AGAIN_NBEST_CONTACT;
    public static final int CMD_DLG_ENTER_CONTACT_AGAIN;

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1640039: {
                this.onNavigateContacts();
                break;
            }
            default: {
                AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(", unhandle generic event ").append(n).toString());
            }
        }
    }

    @Override
    public void onRecognizedEvent(int n) {
        if (n == -1629408448 || n == -1646185664) {
            this.onChooseContactAgain();
        } else {
            AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(", unhandle recognition event ").append(n).toString());
        }
    }

    private void onNavigateContacts() {
        Framework.fireUIEvent(-636996608);
    }

    public static void navigateContacts() {
        Framework.fireEvent(1728452864);
    }

    private void onChooseContactAgain() {
        this.notifyChooseContactAgain();
    }

    private void notifyChooseContactAgain() {
        Framework.fireUIEvent(-586664960);
    }
}

