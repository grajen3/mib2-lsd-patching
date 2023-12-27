/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence2;

import de.vw.mib.asl.framework.api.persistence2.ProfileChangeCallback;

public interface ProfileChangeListener {
    default public void prepareForProfileChange(ProfileChangeCallback profileChangeCallback) {
    }

    default public void changeProfile(ProfileChangeCallback profileChangeCallback) {
    }
}

