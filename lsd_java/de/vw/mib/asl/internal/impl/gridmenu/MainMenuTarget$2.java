/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.gridmenu;

import de.vw.mib.asl.internal.impl.gridmenu.MainMenuTarget;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioRegistrationListener;

class MainMenuTarget$2
implements CioRegistrationListener {
    private final /* synthetic */ MainMenuTarget this$0;

    MainMenuTarget$2(MainMenuTarget mainMenuTarget) {
        this.this$0 = mainMenuTarget;
    }

    @Override
    public void cioRegistered(String string, CioIntent cioIntent) {
        if ("GridMenuAction".equals(cioIntent.getUsage())) {
            this.this$0.addGridMenuEntryIntent(cioIntent);
        }
    }

    @Override
    public void cioUnregistered(String string, CioIntent cioIntent) {
        if ("GridMenuAction".equals(cioIntent.getUsage())) {
            this.this$0.removeGridMenuEntryIntent(cioIntent);
        }
    }
}

