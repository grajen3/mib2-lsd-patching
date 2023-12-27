/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.phonetiles;

import de.vw.mib.appadapter.phonetiles.PhoneTileSAdapter;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.ContentInformationObject;

class PhoneTileSAdapter$1
implements CioExecutor {
    private final /* synthetic */ PhoneTileSAdapter this$0;

    PhoneTileSAdapter$1(PhoneTileSAdapter phoneTileSAdapter) {
        this.this$0 = phoneTileSAdapter;
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        switch (contentInformationObject.getActionId()) {
            case 1: {
                CioIntent cioIntent = PhoneTileSAdapter.access$000(this.this$0).getCioDictionary().getCioIntent("ShowContent", "HMI_PHONE");
                PhoneTileSAdapter.access$100(this.this$0).getCioDispatcher().dispatch(cioIntent);
                break;
            }
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }
}

