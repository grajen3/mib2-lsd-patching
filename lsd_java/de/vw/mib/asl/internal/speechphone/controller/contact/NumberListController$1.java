/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller.contact;

import de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackHandler;
import de.vw.mib.asl.internal.speechphone.controller.contact.NumberListController;

class NumberListController$1
implements DialogBackHandler {
    private final /* synthetic */ NumberListController this$0;

    NumberListController$1(NumberListController numberListController) {
        this.this$0 = numberListController;
    }

    @Override
    public boolean shouldBackPromptBePlayed() {
        return true;
    }

    @Override
    public void restoreState() {
        this.this$0.selectedContactHandler.reset();
        this.this$0.serviceFunctions.sendHMIEvent(-676775168);
    }

    public String toString() {
        return "Contact Detail View after resetting loctype and index";
    }
}

