/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.input.internal;

import de.vw.mib.input.InputManagerListener;
import de.vw.mib.input.internal.InputManagerImpl;

final class InputManagerImpl$ProximityGestureSuppressor
implements InputManagerListener {
    private final /* synthetic */ InputManagerImpl this$0;

    public InputManagerImpl$ProximityGestureSuppressor(InputManagerImpl inputManagerImpl) {
        this.this$0 = inputManagerImpl;
    }

    @Override
    public void userInteractionStarted(int n, int n2) {
        if (n == 1) {
            this.suspendProximitySwipeDetection();
        } else if (n == 2) {
            this.resumeProximitySwipeDetection();
        }
    }

    @Override
    public void userInteractionStopped(int n, int n2) {
    }

    private void suspendProximitySwipeDetection() {
        if (this.this$0.proximityInputDeviceHandler != null) {
            this.this$0.proximityInputDeviceHandler.suspendSwipeDetection();
        }
    }

    private void resumeProximitySwipeDetection() {
        if (this.this$0.proximityInputDeviceHandler != null) {
            this.this$0.proximityInputDeviceHandler.resumeSwipeDetection();
        }
    }
}

