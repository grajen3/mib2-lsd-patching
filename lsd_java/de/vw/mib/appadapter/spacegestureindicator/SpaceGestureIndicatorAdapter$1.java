/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.spacegestureindicator;

import de.vw.mib.appadapter.spacegestureindicator.SpaceGestureIndicatorAdapter;
import de.vw.mib.asl.api.system.input.SpaceGestureAdapter;

class SpaceGestureIndicatorAdapter$1
extends SpaceGestureAdapter {
    private final /* synthetic */ SpaceGestureIndicatorAdapter this$0;

    SpaceGestureIndicatorAdapter$1(SpaceGestureIndicatorAdapter spaceGestureIndicatorAdapter) {
        this.this$0 = spaceGestureIndicatorAdapter;
    }

    @Override
    public void onSpaceGestureInformationChanged(boolean bl) {
        if (bl) {
            this.this$0.processSpaceGestureActivated();
        } else {
            this.this$0.disableSpaceGestureIndicator();
        }
    }

    @Override
    public void onSpaceGestureChanged(boolean bl) {
        if (bl) {
            this.this$0.processSpaceGestureActivated();
        } else {
            this.this$0.disableSpaceGestureIndicator();
        }
    }
}

