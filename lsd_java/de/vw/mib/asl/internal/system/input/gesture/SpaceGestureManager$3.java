/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.input.gesture;

import de.vw.mib.asl.framework.api.persistence2.AbstractProfileChangeHandler;
import de.vw.mib.asl.internal.system.input.gesture.SpaceGestureManager;

class SpaceGestureManager$3
extends AbstractProfileChangeHandler {
    private final /* synthetic */ SpaceGestureManager this$0;

    SpaceGestureManager$3(SpaceGestureManager spaceGestureManager) {
        this.this$0 = spaceGestureManager;
    }

    @Override
    protected void changeProfile() {
        this.this$0.loadPersistenceData();
        this.notifyProfileChanged(true);
    }

    @Override
    protected void prepareForProfileChange() {
        this.notifyReadyForProfileSwitch();
    }
}

