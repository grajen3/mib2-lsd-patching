/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.phoneglobalwizardpage;

import de.vw.mib.appadapter.phoneglobalwizardpage.PhoneGlobalWizardPageAdapter;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.ContentInformationObject;
import de.vw.mib.globalsetupwizard.GlobalWizardPage;

class PhoneGlobalWizardPageAdapter$1
implements CioExecutor {
    private final /* synthetic */ PhoneGlobalWizardPageAdapter this$0;

    PhoneGlobalWizardPageAdapter$1(PhoneGlobalWizardPageAdapter phoneGlobalWizardPageAdapter) {
        this.this$0 = phoneGlobalWizardPageAdapter;
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        if ("InitGlobalWizardPage".equals(contentInformationObject.getCioIntentName())) {
            GlobalWizardPage globalWizardPage = (GlobalWizardPage)cioActionParameters.getObject("globalWizardPage");
            this.this$0.service.setGlobalWizardPage(globalWizardPage);
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }
}

