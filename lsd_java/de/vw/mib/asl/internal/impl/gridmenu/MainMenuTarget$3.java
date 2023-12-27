/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.gridmenu;

import de.vw.mib.asl.framework.api.persistence2.ProfileChangeCallback;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.internal.impl.gridmenu.MainMenuTarget;

class MainMenuTarget$3
implements ProfileChangeListener {
    private final /* synthetic */ MainMenuTarget this$0;

    MainMenuTarget$3(MainMenuTarget mainMenuTarget) {
        this.this$0 = mainMenuTarget;
    }

    @Override
    public void changeProfile(ProfileChangeCallback profileChangeCallback) {
        this.this$0.reinitalizeMenu();
        profileChangeCallback.notifyProfileChanged(true);
    }

    @Override
    public void prepareForProfileChange(ProfileChangeCallback profileChangeCallback) {
        profileChangeCallback.notifyReadyForProfileChange();
    }
}

