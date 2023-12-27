/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence2;

public interface ProfileChangeCallback {
    default public void notifyReadyForProfileChange() {
    }

    default public void notifyProfileChanged(boolean bl) {
    }
}

