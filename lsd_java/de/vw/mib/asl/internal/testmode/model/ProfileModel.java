/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode.model;

import de.vw.mib.asl.internal.testmode.model.Profile;
import java.util.ArrayList;
import java.util.List;

public class ProfileModel {
    private final List profiles = new ArrayList();
    private int activeProfile;

    public ProfileModel(String[] stringArray, int n) {
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            this.profiles.add(new Profile(stringArray[i2]));
        }
        this.activateProfile(n);
    }

    public void activateProfile(int n) {
        this.updateActivationState(this.activeProfile, false);
        this.updateActivationState(n, true);
        this.activeProfile = n;
    }

    public Object[] getProfiles() {
        return this.profiles.toArray();
    }

    private void updateActivationState(int n, boolean bl) {
        if (n >= 0 && n < this.profiles.size()) {
            this.getProfile(n).setActive(bl);
        }
    }

    private Profile getProfile(int n) {
        return (Profile)this.profiles.get(n);
    }
}

