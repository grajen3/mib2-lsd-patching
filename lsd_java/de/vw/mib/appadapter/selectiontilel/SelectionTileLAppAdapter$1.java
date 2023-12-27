/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.selectiontilel;

import de.vw.mib.appadapter.selectiontilel.SelectionTileLAppAdapter;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.ContentInformationObject;

class SelectionTileLAppAdapter$1
implements CioExecutor {
    private final /* synthetic */ SelectionTileLAppAdapter this$0;

    SelectionTileLAppAdapter$1(SelectionTileLAppAdapter selectionTileLAppAdapter) {
        this.this$0 = selectionTileLAppAdapter;
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
    }
}

