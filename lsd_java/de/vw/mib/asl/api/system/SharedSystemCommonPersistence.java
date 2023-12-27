/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system;

import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;

public interface SharedSystemCommonPersistence {
    default public void addProfileChangeListener(ProfileChangeListener profileChangeListener) {
    }

    default public long getBitfieldLanguagesThatWereSetBefore() {
    }

    default public int getDisplayBrigtness() {
    }

    default public boolean isAcousticTouchscreenFeedback() {
    }

    default public void setAcousticTouchscreenFeedback(boolean bl) {
    }

    default public void setBitfieldLanguagesThatWereSetBefore(long l) {
    }

    default public void setDisplayBrightness(int n) {
    }
}

