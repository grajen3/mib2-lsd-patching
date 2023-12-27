/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.navhomeadressglobalwizardpage.cio;

import de.vw.mib.appadapter.navhomeadressglobalwizardpage.modelapi.HomeAdressInputService;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.ContentInformationObject;
import de.vw.mib.globalsetupwizard.GlobalWizardPage;

public class NavHomeAdressGlobalWizardPageCioExecutor
implements CioExecutor {
    private static final int INIT_GLOBAL_WIZARD_PAGE;
    public static final int CALLBACK_FROM_CCP_SUCCESS;
    public static final int CALLBACK_FROM_CCP_ERROR;
    public static final int CALLBACK_FROM_DESTINPUT_SUCCESS;
    public static final int CALLBACK_FROM_DESTINPUT_ERROR;
    public static final int CALLBACK_FROM_DESTINPUT_CANCEL;
    private HomeAdressInputService service;
    private GlobalWizardPage page;

    public void registerService(HomeAdressInputService homeAdressInputService) {
        this.service = homeAdressInputService;
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        switch (contentInformationObject.getActionId()) {
            case 0: {
                this.page = (GlobalWizardPage)cioActionParameters.getObject("globalWizardPage");
                break;
            }
            case 100: 
            case 101: {
                this.service.callbackFromSetCCP(contentInformationObject.getActionId(), this.page);
                break;
            }
            case 200: 
            case 201: 
            case 202: {
                this.service.callbackFromEnterAddress(contentInformationObject.getActionId(), this.page);
                break;
            }
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        switch (contentInformationObject.getActionId()) {
            case 0: {
                return false;
            }
            case 100: {
                return false;
            }
            case 101: {
                return false;
            }
            case 200: {
                return false;
            }
            case 201: {
                return false;
            }
            case 202: {
                return false;
            }
        }
        return false;
    }
}

