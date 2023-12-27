/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.globalsetupwizard;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.impl.globalsetupwizard.WizardPageManager;

class WizardPageManager$3
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ WizardPageManager this$0;

    WizardPageManager$3(WizardPageManager wizardPageManager) {
        this.this$0 = wizardPageManager;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.this$0.processRevertWizardPages();
        factoryResetCallback.notifyResetDone();
    }
}

