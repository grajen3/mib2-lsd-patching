/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.DefaultSliderController;
import de.vw.mib.widgets.models.SliderModel;

class DefaultSliderController$1
implements Runnable {
    private final /* synthetic */ SliderModel val$slider;
    private final /* synthetic */ DefaultSliderController this$0;

    DefaultSliderController$1(DefaultSliderController defaultSliderController, SliderModel sliderModel) {
        this.this$0 = defaultSliderController;
        this.val$slider = sliderModel;
    }

    @Override
    public void run() {
        if (this.this$0.eventTimeRunning) {
            boolean bl = this.val$slider.isPressed();
            this.this$0.trace(new StringBuffer().append(" - eventTimer; eventTimeRunning: ").append(this.this$0.eventTimeRunning).append(" pressed: ").append(bl).toString());
            if (!bl) {
                this.this$0.stopEventTimer();
            } else {
                this.this$0.fire_valueChanged();
            }
        }
    }
}

