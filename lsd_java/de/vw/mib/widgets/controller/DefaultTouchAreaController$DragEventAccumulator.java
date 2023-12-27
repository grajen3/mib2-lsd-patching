/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.DefaultTouchAreaController;
import de.vw.mib.widgets.controller.DefaultTouchAreaController$EventAccumulator;

class DefaultTouchAreaController$DragEventAccumulator
extends DefaultTouchAreaController$EventAccumulator {
    private final /* synthetic */ DefaultTouchAreaController this$0;

    public DefaultTouchAreaController$DragEventAccumulator(DefaultTouchAreaController defaultTouchAreaController, String string) {
        this.this$0 = defaultTouchAreaController;
        super(defaultTouchAreaController, string);
    }

    @Override
    public void accumulateEvent(int n, int n2, int n3, int n4) {
        int n5 = this.this$0.getDragThreshold();
        int n6 = this.this$0.getDragThresholdMode();
        int n7 = n;
        int n8 = n2;
        switch (n6) {
            case 0: {
                this.this$0.dragThresholdExceeded = this.this$0.dragThresholdExceeded | Math.abs(this.this$0.initialTouchPoint.x - n) + Math.abs(this.this$0.initialTouchPoint.y - n2) > n5;
                break;
            }
            case 1: {
                this.this$0.dragThresholdExceededHorizontally = this.this$0.dragThresholdExceededHorizontally | Math.abs(this.this$0.initialTouchPoint.x - n) > n5;
                this.this$0.dragThresholdExceededVertically = this.this$0.dragThresholdExceededVertically | Math.abs(this.this$0.initialTouchPoint.y - n2) > n5;
                this.this$0.dragThresholdExceeded = this.this$0.dragThresholdExceeded | (this.this$0.dragThresholdExceededHorizontally || this.this$0.dragThresholdExceededVertically);
                if (this.this$0.dragThresholdExceededHorizontally) {
                    n7 = n;
                } else {
                    n7 = this.this$0.initialTouchPoint.x;
                    n3 = 0;
                }
                if (this.this$0.dragThresholdExceededVertically) {
                    n8 = n2;
                    break;
                }
                n8 = this.this$0.initialTouchPoint.y;
                n4 = 0;
                break;
            }
            default: {
                this.this$0.dragThresholdExceeded = true;
            }
        }
        if (this.this$0.dragThresholdExceeded) {
            this.this$0.stopLongPressTimer();
            super.accumulateEvent(n7, n8, n3, n4);
        }
    }
}

