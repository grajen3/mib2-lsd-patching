/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen;

import de.vw.mib.asl.framework.api.persistence2.ProfileChangeCallback;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.internal.impl.homescreen.HomeScreenMainTarget;

class HomeScreenMainTarget$2
implements ProfileChangeListener {
    private final /* synthetic */ HomeScreenMainTarget this$0;

    HomeScreenMainTarget$2(HomeScreenMainTarget homeScreenMainTarget) {
        this.this$0 = homeScreenMainTarget;
    }

    @Override
    public void prepareForProfileChange(ProfileChangeCallback profileChangeCallback) {
        profileChangeCallback.notifyReadyForProfileChange();
    }

    @Override
    public void changeProfile(ProfileChangeCallback profileChangeCallback) {
        this.this$0.refreshTileApps();
        profileChangeCallback.notifyProfileChanged(true);
    }
}

