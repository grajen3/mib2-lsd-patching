/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.tunerautostoreglobalwizardpage;

import de.vw.mib.appadapter.tunerautostoreglobalwizardpage.TunerAutostoreGlobalWizardPageAdapter;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.ContentInformationObject;
import de.vw.mib.globalsetupwizard.GlobalWizardPage;

class TunerAutostoreGlobalWizardPageAdapter$1
implements CioExecutor {
    private final /* synthetic */ TunerAutostoreGlobalWizardPageAdapter this$0;

    TunerAutostoreGlobalWizardPageAdapter$1(TunerAutostoreGlobalWizardPageAdapter tunerAutostoreGlobalWizardPageAdapter) {
        this.this$0 = tunerAutostoreGlobalWizardPageAdapter;
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        if ("InitGlobalWizardPage".equals(contentInformationObject.getCioIntentName())) {
            GlobalWizardPage globalWizardPage = (GlobalWizardPage)cioActionParameters.getObject("globalWizardPage");
            TunerAutostoreGlobalWizardPageAdapter.access$000(this.this$0).setGlobalWizardPage(globalWizardPage);
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }
}

