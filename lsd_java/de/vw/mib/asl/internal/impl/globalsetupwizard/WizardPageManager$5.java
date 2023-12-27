/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.globalsetupwizard;

import de.vw.mib.asl.internal.impl.globalsetupwizard.WizardPageManager;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioRegistrationListener;

class WizardPageManager$5
implements CioRegistrationListener {
    private final /* synthetic */ WizardPageManager this$0;

    WizardPageManager$5(WizardPageManager wizardPageManager) {
        this.this$0 = wizardPageManager;
    }

    @Override
    public void cioUnregistered(String string, CioIntent cioIntent) {
        this.this$0.retrievePages();
        this.this$0.wizardPersistence.removePageIntent(cioIntent);
    }

    @Override
    public void cioRegistered(String string, CioIntent cioIntent) {
        this.this$0.retrievePages();
        this.this$0.addWizardPage(cioIntent);
    }
}

