/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system.input;

import de.vw.mib.asl.api.system.input.SpaceGestureListener;

public interface SpaceGestureService {
    default public void addListener(SpaceGestureListener spaceGestureListener) {
    }

    default public void removeListener(SpaceGestureListener spaceGestureListener) {
    }

    default public boolean isCurrentSpaceGestureActivated() {
    }

    default public boolean istCurrentSpaceGestureInformationActivated() {
    }

    default public boolean isCurrentSpaceGestureSoundEffectActivated() {
    }
}

