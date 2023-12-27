/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.globalsetupwizard;

import de.vw.mib.asl.framework.api.persistence2.ProfileChangeCallback;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.internal.impl.globalsetupwizard.WizardPageManager;

class WizardPageManager$2
implements ProfileChangeListener {
    private final /* synthetic */ WizardPageManager this$0;

    WizardPageManager$2(WizardPageManager wizardPageManager) {
        this.this$0 = wizardPageManager;
    }

    @Override
    public void prepareForProfileChange(ProfileChangeCallback profileChangeCallback) {
        profileChangeCallback.notifyReadyForProfileChange();
    }

    @Override
    public void changeProfile(ProfileChangeCallback profileChangeCallback) {
        this.this$0.loadDataFromGlobalSetupWizardPersistence();
        profileChangeCallback.notifyProfileChanged(true);
    }
}

