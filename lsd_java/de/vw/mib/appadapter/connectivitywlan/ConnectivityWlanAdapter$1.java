/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.connectivitywlan;

import de.vw.mib.appadapter.connectivitywlan.ConnectivityWlanAdapter;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.ContentInformationObject;

class ConnectivityWlanAdapter$1
implements CioExecutor {
    private final /* synthetic */ ConnectivityWlanAdapter this$0;

    ConnectivityWlanAdapter$1(ConnectivityWlanAdapter connectivityWlanAdapter) {
        this.this$0 = connectivityWlanAdapter;
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        if (contentInformationObject.getActionId() == 0) {
            CioIntent cioIntent = cioActionParameters.getCioIntent("Callback_Success");
            CioIntent cioIntent2 = cioActionParameters.getCioIntent("Callback_Cancel");
            this.this$0.apiServiceImpl.setCallbackCioIntents(cioIntent, cioIntent2);
            CioIntent cioIntent3 = ConnectivityWlanAdapter.access$000(this.this$0).getCioDictionary().getCioIntent("ShowContent", "HMI_WLAN");
            ConnectivityWlanAdapter.access$100(this.this$0).getCioDispatcher().dispatch(cioIntent3);
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }
}

