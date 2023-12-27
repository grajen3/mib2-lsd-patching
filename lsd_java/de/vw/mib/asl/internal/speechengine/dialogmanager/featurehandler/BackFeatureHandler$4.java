/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.BackFeatureHandler;

class BackFeatureHandler$4
implements DialogBackHandler {
    private final /* synthetic */ BackFeatureHandler this$0;

    BackFeatureHandler$4(BackFeatureHandler backFeatureHandler) {
        this.this$0 = backFeatureHandler;
    }

    @Override
    public void restoreState() {
        if (this.this$0.logger.isTraceEnabled()) {
            this.this$0.logger.trace("Back - Backstack empty, fire main menu command.");
        }
        this.this$0.dialogManager.setState(2);
        this.this$0.dialogManager.openMainMenu(true, true);
    }

    @Override
    public boolean shouldBackPromptBePlayed() {
        return true;
    }

    public String toString() {
        return "Main Menu";
    }
}

