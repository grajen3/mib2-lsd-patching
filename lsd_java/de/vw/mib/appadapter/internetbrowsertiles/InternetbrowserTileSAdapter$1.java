/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.internetbrowsertiles;

import de.vw.mib.appadapter.internetbrowsertiles.InternetbrowserTileSAdapter;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.ContentInformationObject;

class InternetbrowserTileSAdapter$1
implements CioExecutor {
    private final /* synthetic */ InternetbrowserTileSAdapter this$0;

    InternetbrowserTileSAdapter$1(InternetbrowserTileSAdapter internetbrowserTileSAdapter) {
        this.this$0 = internetbrowserTileSAdapter;
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        switch (contentInformationObject.getActionId()) {
            case 1: {
                CioIntent cioIntent = InternetbrowserTileSAdapter.access$000(this.this$0).getCioDictionary().getCioIntent("ShowContent", "HMI_INTERNETBROWSER");
                InternetbrowserTileSAdapter.access$100(this.this$0).getCioDispatcher().dispatch(cioIntent);
                break;
            }
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }
}

