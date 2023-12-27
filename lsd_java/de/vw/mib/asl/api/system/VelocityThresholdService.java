/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system;

import de.vw.mib.asl.api.system.VelocityThresholdListener;

public interface VelocityThresholdService {
    default public void addListener(VelocityThresholdListener velocityThresholdListener) {
    }

    default public void removeListener(VelocityThresholdListener velocityThresholdListener) {
    }

    default public boolean isThresholdExceeded() {
    }
}

