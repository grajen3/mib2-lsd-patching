/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.dateglobalwizardpage.modelapi;

import de.vw.mib.globalsetupwizard.GlobalWizardPage;
import generated.de.vw.mib.appadapter.dateglobalwizardpage.InformationModelApiService;

public class InformationModelApiServiceImpl
implements InformationModelApiService {
    private GlobalWizardPage globalWizardPage;

    @Override
    public void _mda_setupPageReady() {
        if (this.globalWizardPage != null) {
            this.globalWizardPage.markAsFinished();
        }
    }

    public void setGlobalWizardPage(GlobalWizardPage globalWizardPage) {
        this.globalWizardPage = globalWizardPage;
    }
}

