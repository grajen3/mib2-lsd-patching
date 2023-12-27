/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen;

import de.vw.mib.asl.framework.api.persistence2.ProfileChangeCallback;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.internal.impl.homescreen.HomeScreenInfoTarget;

class HomeScreenInfoTarget$2
implements ProfileChangeListener {
    private final /* synthetic */ HomeScreenInfoTarget this$0;

    HomeScreenInfoTarget$2(HomeScreenInfoTarget homeScreenInfoTarget) {
        this.this$0 = homeScreenInfoTarget;
    }

    @Override
    public void prepareForProfileChange(ProfileChangeCallback profileChangeCallback) {
        profileChangeCallback.notifyReadyForProfileChange();
    }

    @Override
    public void changeProfile(ProfileChangeCallback profileChangeCallback) {
        this.this$0.loadDataFromHomescreenInfoAppPersistence();
        profileChangeCallback.notifyProfileChanged(true);
    }
}

