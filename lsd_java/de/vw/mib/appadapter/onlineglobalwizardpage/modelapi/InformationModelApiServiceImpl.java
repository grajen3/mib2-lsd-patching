/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.onlineglobalwizardpage.modelapi;

import de.vw.mib.appadapter.onlineglobalwizardpage.OnlineGlobalWizardPageAdapter;
import de.vw.mib.globalsetupwizard.GlobalWizardPage;
import generated.de.vw.mib.appadapter.onlineglobalwizardpage.InformationModelApiService;

public final class InformationModelApiServiceImpl
implements InformationModelApiService {
    private final OnlineGlobalWizardPageAdapter adapter;
    private GlobalWizardPage page;

    public InformationModelApiServiceImpl(OnlineGlobalWizardPageAdapter onlineGlobalWizardPageAdapter) {
        this.adapter = onlineGlobalWizardPageAdapter;
    }

    @Override
    public void _mda_onlineGlobalWizardEnterOnlineWizard() {
        this.adapter.showConnectivitySetup();
    }

    @Override
    public void _mda_onlineGlobalWizardSetupPageReady() {
        this.page.markAsFinished();
    }

    public void setGlobalWizardPage(GlobalWizardPage globalWizardPage) {
        this.page = globalWizardPage;
    }

    public void cancel() {
        this.adapter.showGlobalSetupWizard();
    }

    public void success() {
        this.page.markAsFinished();
        this.adapter.showGlobalSetupWizard();
    }
}

