/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.globalsetupwizard.api.impl;

import de.vw.mib.asl.api.globalsetupwizard.ASLGlobalSetupWizardAPI;
import de.vw.mib.asl.api.globalsetupwizard.wizard.WizardService;
import de.vw.mib.asl.internal.globalsetupwizard.GlobalSetupWizardServices;

public class ASLGlobalSetupWizardAPIImpl
implements ASLGlobalSetupWizardAPI {
    private GlobalSetupWizardServices services;

    @Override
    public WizardService getWizardService() {
        if (this.services == null) {
            return null;
        }
        return this.services.getWizardService();
    }

    public void injectGlobalSetupWizardServices(GlobalSetupWizardServices globalSetupWizardServices) {
        this.services = globalSetupWizardServices;
    }
}

