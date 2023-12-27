/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.simplegridmenu;

import de.vw.mib.appadapter.simplegridmenu.SimpleGridMenuAdapter;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.ContentInformationObject;

class SimpleGridMenuAdapter$1
implements CioExecutor {
    private final /* synthetic */ SimpleGridMenuAdapter this$0;

    SimpleGridMenuAdapter$1(SimpleGridMenuAdapter simpleGridMenuAdapter) {
        this.this$0 = simpleGridMenuAdapter;
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
    }
}

