/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.globalsetupwizard;

import de.vw.mib.asl.framework.api.startupv7r.startupstate.StartupStateListener;
import de.vw.mib.asl.internal.impl.globalsetupwizard.WizardPageManager;

class WizardPageManager$4
implements StartupStateListener {
    private final /* synthetic */ WizardPageManager this$0;

    WizardPageManager$4(WizardPageManager wizardPageManager) {
        this.this$0 = wizardPageManager;
    }

    @Override
    public void onStartupStateChanged(int n) {
        if (n == 2) {
            this.this$0.startGlobalWizardPages();
        }
    }
}

