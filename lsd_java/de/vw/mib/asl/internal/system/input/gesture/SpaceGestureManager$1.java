/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.input.gesture;

import de.vw.mib.asl.internal.system.input.gesture.SpaceGestureManager;
import de.vw.mib.configuration.FeatureFlagValueChangeReceiver;

class SpaceGestureManager$1
implements FeatureFlagValueChangeReceiver {
    private final /* synthetic */ SpaceGestureManager this$0;

    SpaceGestureManager$1(SpaceGestureManager spaceGestureManager) {
        this.this$0 = spaceGestureManager;
    }

    @Override
    public void receiveFeatureFlagValue(int n, boolean bl) {
        SpaceGestureManager.access$000(this.this$0);
    }
}

