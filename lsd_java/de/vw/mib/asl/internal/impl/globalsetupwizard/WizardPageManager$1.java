/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.globalsetupwizard;

import de.vw.mib.asl.internal.impl.globalsetupwizard.WizardPageManager;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.globalsetupwizard.GlobalWizardPage;
import de.vw.mib.log4mib.Logger;

class WizardPageManager$1
implements GlobalWizardPage {
    private final /* synthetic */ CioIntent val$cioIntent;
    private final /* synthetic */ Logger val$internalLogger;
    private final /* synthetic */ WizardPageManager this$0;

    WizardPageManager$1(WizardPageManager wizardPageManager, CioIntent cioIntent, Logger logger) {
        this.this$0 = wizardPageManager;
        this.val$cioIntent = cioIntent;
        this.val$internalLogger = logger;
    }

    @Override
    public void showPage() {
        this.this$0.activateCertainPage(this.val$cioIntent.getCioIntentId());
        this.this$0.updateModel();
        this.this$0.showWizard();
    }

    @Override
    public void markAsFinished() {
        this.this$0.wizardPersistence.storeFinishedState(this.val$cioIntent.getCioIntentId(), true);
        this.this$0.updateProgressList();
    }

    @Override
    public void goToNextPage() {
        if (this.this$0.checkIsActivePage(this.val$cioIntent)) {
            this.this$0.activateToNextPage();
            this.this$0.updateModel();
        } else {
            this.val$internalLogger.warn(2048, new StringBuffer().append("[WizardPageManager] Ignoring goToNextPage by page ").append(this.val$cioIntent.getCioIntentId()).append(" since it is not active.").toString());
        }
    }
}

