/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.input;

import de.vw.mib.asl.internal.system.abtfeatures.DsiKeyPanelListenerAdapter;
import de.vw.mib.asl.internal.system.input.TouchInputDeviceImpl;

class TouchInputDeviceImpl$1
extends DsiKeyPanelListenerAdapter {
    private boolean isTouchInputActive;
    private boolean blockTouchUpdates = false;
    private final /* synthetic */ TouchInputDeviceImpl this$0;

    TouchInputDeviceImpl$1(TouchInputDeviceImpl touchInputDeviceImpl) {
        this.this$0 = touchInputDeviceImpl;
    }

    @Override
    public void updateGesture2(int n, int n2, int n3, boolean bl, int n4, int n5, int n6, int n7, int n8, int n9) {
        if (this.blockTouchUpdates) {
            return;
        }
        if (n == 13) {
            if (n2 == 4) {
                this.isTouchInputActive = true;
                TouchInputDeviceImpl.access$000(this.this$0).trace("Registered GESTURE_PRESS.");
            } else if (n2 == 8) {
                this.isTouchInputActive = true;
                TouchInputDeviceImpl.access$000(this.this$0).trace("Registered GESTURE_PRESS2.");
            } else if (n2 == 1) {
                this.isTouchInputActive = false;
                TouchInputDeviceImpl.access$000(this.this$0).trace("Registered GESTURE_TAP.");
            } else if (n2 == 3) {
                this.isTouchInputActive = false;
                TouchInputDeviceImpl.access$000(this.this$0).trace("Registered GESTURE_RELEASE.");
            }
        }
        n6 = this.this$0.scaleParameterForTwoFingerGesture(n2, n6);
        this.this$0.updateTouchInput(n2, n3, (int)((float)n4 * this.this$0.getScaleX()), (int)((float)n5 * this.this$0.getScaleY()), n6, n7, n8 * TouchInputDeviceImpl.UPDATE_GESTURE2_TIME_SCALE_FACTOR);
    }

    @Override
    public void updateKey2(int n, int n2, int n3, int n4, int n5) {
        if (n2 == 16 && !this.isTouchInputActive) {
            if (n3 == 1) {
                TouchInputDeviceImpl.access$000(this.this$0).trace("Received RRE pressed event. Block touch updates now.");
                this.blockTouchUpdates = true;
            } else {
                TouchInputDeviceImpl.access$000(this.this$0).trace("Received RRE non-pressed event. Touch updates no longer blocked.");
                this.blockTouchUpdates = false;
            }
        }
    }
}

