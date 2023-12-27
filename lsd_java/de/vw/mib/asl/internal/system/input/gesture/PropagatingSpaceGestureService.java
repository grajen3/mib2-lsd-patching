/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.input.gesture;

import de.vw.mib.asl.api.system.input.SpaceGestureService;

public interface PropagatingSpaceGestureService
extends SpaceGestureService {
    default public void applyCurrentSpaceGestureValue(boolean bl) {
    }

    default public void applyCurrentSpaceGestureInformationValue(boolean bl) {
    }

    default public void applyCurrentSpaceGestureSoundEffectValue(boolean bl) {
    }
}

