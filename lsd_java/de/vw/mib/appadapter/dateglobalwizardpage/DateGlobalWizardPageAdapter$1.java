/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.dateglobalwizardpage;

import de.vw.mib.appadapter.dateglobalwizardpage.DateGlobalWizardPageAdapter;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.ContentInformationObject;
import de.vw.mib.globalsetupwizard.GlobalWizardPage;

class DateGlobalWizardPageAdapter$1
implements CioExecutor {
    private final /* synthetic */ DateGlobalWizardPageAdapter this$0;

    DateGlobalWizardPageAdapter$1(DateGlobalWizardPageAdapter dateGlobalWizardPageAdapter) {
        this.this$0 = dateGlobalWizardPageAdapter;
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        if ("InitGlobalWizardPage".equals(contentInformationObject.getCioIntentName())) {
            GlobalWizardPage globalWizardPage = (GlobalWizardPage)cioActionParameters.getObject("globalWizardPage");
            DateGlobalWizardPageAdapter.access$000(this.this$0).setGlobalWizardPage(globalWizardPage);
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }
}

