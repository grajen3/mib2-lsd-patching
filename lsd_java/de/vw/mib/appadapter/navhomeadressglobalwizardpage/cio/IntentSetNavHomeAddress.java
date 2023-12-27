/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.navhomeadressglobalwizardpage.cio;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.appadapter.navhomeadressglobalwizardpage.NavHomeAdressGlobalWizardPageAdapter;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioIntentChangeListener;
import de.vw.mib.cio.CioParametersCreator;

public class IntentSetNavHomeAddress {
    private static final String CALLBACK_SUCCESS;
    private static final String CALLBACK_FAILURE;
    private static final String CALLBACK_CANCEL;
    public static final String USAGE_CCP;
    public static final String USAGE_INPUT;
    private AppAdapterSystemServices systemServices = NavHomeAdressGlobalWizardPageAdapter.getSystemServices();
    private CioIntent intent;
    private CioIntentChangeListener listener;
    private CioIntent successbackintent;
    private CioIntent errorbackintent;
    private CioIntent cancelbackintent;

    public IntentSetNavHomeAddress(String string, CioIntent cioIntent, CioIntent cioIntent2, CioIntent cioIntent3) {
        this.intent = this.systemServices.getCioDictionary().getCioIntent("SetNavHomeAddress", string);
        this.successbackintent = cioIntent;
        this.errorbackintent = cioIntent2;
        this.cancelbackintent = cioIntent3;
    }

    public void addCioIntentChangeListener(CioIntentChangeListener cioIntentChangeListener) {
        if (cioIntentChangeListener != null) {
            if (this.listener != null) {
                this.removeCioIntentChangeListener();
            }
            this.listener = cioIntentChangeListener;
            this.intent.addCioIntentChangeListener(cioIntentChangeListener);
        }
    }

    public void removeCioIntentChangeListener() {
        if (this.listener != null) {
            this.intent.removeCioIntentChangeListener(this.listener);
            this.listener = null;
        }
    }

    public boolean isIntentAvailable() {
        return this.intent.isAvailable();
    }

    public boolean createAndDispatch() {
        CioParametersCreator cioParametersCreator = this.systemServices.getCioFactory().createActionParameters(this.intent);
        cioParametersCreator.setCioIntent("Callback_Success", this.successbackintent);
        cioParametersCreator.setCioIntent("Callback_Failure", this.errorbackintent);
        cioParametersCreator.setCioIntent("Callback_Cancel", this.cancelbackintent);
        CioActionParameters cioActionParameters = cioParametersCreator.finishActionParams();
        this.systemServices.getCioDispatcher().dispatch(this.intent, cioActionParameters);
        return true;
    }

    public boolean equalsIntent(CioIntent cioIntent) {
        return this.intent == cioIntent;
    }
}

