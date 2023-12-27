/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence2;

import de.vw.mib.asl.framework.api.persistence2.ProfileChangeCallback;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;

public abstract class AbstractProfileChangeHandler
implements ProfileChangeListener {
    private ProfileChangeCallback callback;

    @Override
    public void prepareForProfileChange(ProfileChangeCallback profileChangeCallback) {
        this.callback = profileChangeCallback;
        this.prepareForProfileChange();
    }

    @Override
    public void changeProfile(ProfileChangeCallback profileChangeCallback) {
        this.callback = profileChangeCallback;
        this.changeProfile();
    }

    public final void notifyReadyForProfileSwitch() {
        this.callback.notifyReadyForProfileChange();
    }

    public final void notifyProfileChanged(boolean bl) {
        this.callback.notifyProfileChanged(bl);
    }

    protected abstract void prepareForProfileChange() {
    }

    protected abstract void changeProfile() {
    }
}

