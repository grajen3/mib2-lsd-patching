/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.input.gesture;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.system.input.gesture.SpaceGestureManager;

class SpaceGestureManager$2
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ SpaceGestureManager this$0;

    SpaceGestureManager$2(SpaceGestureManager spaceGestureManager) {
        this.this$0 = spaceGestureManager;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.this$0.performFactoryReset();
        factoryResetCallback.notifyResetDone();
    }
}

