/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.selectiontiles;

import de.vw.mib.appadapter.selectiontiles.SelectionTileSAppAdapter;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.ContentInformationObject;

class SelectionTileSAppAdapter$1
implements CioExecutor {
    private final /* synthetic */ SelectionTileSAppAdapter this$0;

    SelectionTileSAppAdapter$1(SelectionTileSAppAdapter selectionTileSAppAdapter) {
        this.this$0 = selectionTileSAppAdapter;
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
    }
}

