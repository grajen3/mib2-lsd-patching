/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.timer.Timer;
import de.vw.mib.widgets.controller.AbstractSliderController;
import de.vw.mib.widgets.controller.DefaultSliderController$1;
import de.vw.mib.widgets.controller.SliderController;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.AbstractSliderModel;
import de.vw.mib.widgets.models.SliderModel;

public final class DefaultSliderController
extends AbstractSliderController
implements SliderController {
    private static final String TIMER_NAME;
    private Timer eventTimer;
    private boolean manualValueChangeDeactivated;

    @Override
    protected void reset() {
        super.reset();
        this.eventTimer = null;
        this.manualValueChangeDeactivated = false;
    }

    @Override
    public void init() {
        super.init();
        this.valueRequested = 128;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        SliderModel sliderModel = (SliderModel)this.getWidget();
        if (!sliderModel.is_progressMode()) {
            return super.consumeTouchEvent(touchEvent);
        }
        return true;
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        SliderModel sliderModel = (SliderModel)this.getWidget();
        if (!sliderModel.is_progressMode()) {
            boolean bl = super.consumeHMIEvent(hMIEvent, string);
            if (string == "abortManualValueChange") {
                this.fire_abortManualValueChange();
                bl = true;
            }
            return bl;
        }
        return true;
    }

    private void initEventTimer() {
        SliderModel sliderModel = (SliderModel)this.getWidget();
        this.eventTimer = ServiceManager.timerManager.createTimer("DefaultSliderController.EventTimer", sliderModel.get_fireEventTimer(), true, new DefaultSliderController$1(this, sliderModel), ServiceManager.eventDispatcher);
    }

    void stopEventTimer() {
        if (this.eventTimeRunning) {
            this.eventTimer.stop();
            this.eventTimeRunning = false;
        }
    }

    @Override
    public void fire_stepDown() {
        super.fire_stepDown();
        this.valueRequested = 128;
        if (this.controllerValueHelper >= ((SliderModel)this.getWidget()).get_valueMin()) {
            this.fire_valueChanged();
        }
    }

    @Override
    public void fire_stepUp() {
        super.fire_stepUp();
        this.valueRequested = 128;
        if (this.controllerValueHelper <= ((SliderModel)this.getWidget()).get_valueMax()) {
            this.fire_valueChanged();
        }
    }

    @Override
    public void fire_press() {
        super.fire_press();
        SliderModel sliderModel = (SliderModel)this.getWidget();
        sliderModel.setPositionOnScrollbarButton(this.clickedX, this.clickedY);
        boolean bl = sliderModel.is_valueChangeInstantly();
        this.trace(new StringBuffer().append(".fire_press();; posOnSbButton: ").append(sliderModel.getPositionOnScrollbarButton()).append(", valueChangeInstantly: ").append(bl).append(", valueChangeOnlyOnRelease: ").append(sliderModel.is_valueChangeOnlyOnRelease()).toString());
        this.controllerValueHelper = sliderModel.updatePosition(this.clickedX, this.clickedY, false);
        if (bl) {
            sliderModel.updateProgressImageGeometry();
        }
        if (!sliderModel.is_valueChangeOnlyOnRelease() && !this.eventTimeRunning) {
            this.initEventTimer();
            this.eventTimer.start();
            this.eventTimeRunning = true;
        }
        sliderModel.stopValueChangeShadowTimer(false);
    }

    @Override
    public void fire_drag() {
        SliderModel sliderModel = (SliderModel)this.getWidget();
        if (!this.manualValueChangeDeactivated && sliderModel.isPressed()) {
            this.controllerValueHelper = sliderModel.updatePosition(this.clickedX, this.clickedY, false);
            if (sliderModel.is_valueChangeInstantly()) {
                sliderModel.updateProgressImageGeometry();
            }
            this.trace(new StringBuffer().append(".fire_drag();; controllerValueHelper: ").append(this.controllerValueHelper).append(", eventTimeRunning: ").append(this.eventTimeRunning).toString());
            if (!sliderModel.is_valueChangeOnlyOnRelease() && !this.eventTimeRunning) {
                this.fire_valueChanged();
            }
        } else {
            sliderModel.setPressed(false);
        }
    }

    @Override
    public void fire_release() {
        SliderModel sliderModel = (SliderModel)this.getWidget();
        this.stopEventTimer();
        if (!this.manualValueChangeDeactivated && sliderModel.isPressed()) {
            this.controllerValueHelper = sliderModel.updatePosition(this.clickedX, this.clickedY, true);
            if (sliderModel.is_valueChangeInstantly()) {
                sliderModel.updateProgressImageGeometry();
            }
            this.trace(new StringBuffer().append(".fire_release();; controllerValueHelper: ").append(this.controllerValueHelper).append(", eventTimeRunning: ").append(this.eventTimeRunning).toString());
            this.fire_valueChanged();
        }
        this.manualValueChangeDeactivated = false;
        this.valueRequested = 128;
        super.fire_release();
    }

    @Override
    public void fire_cancelled() {
        this.stopEventTimer();
        this.manualValueChangeDeactivated = false;
        super.fire_cancelled();
    }

    @Override
    public void fire_abortManualValueChange() {
        AbstractSliderModel abstractSliderModel = (AbstractSliderModel)this.getWidget();
        if (abstractSliderModel.isPressed()) {
            this.stopEventTimer();
            this.manualValueChangeDeactivated = true;
            abstractSliderModel.setPressed(false);
        }
    }

    @Override
    public void fire_valueChanged() {
        SliderModel sliderModel = (SliderModel)this.getWidget();
        this.trace(new StringBuffer().append(".fire_valueChanged();; controllerValueHelper: ").append(this.controllerValueHelper).append(", valueRequested: ").append(this.valueRequested).append(", slider.oldValue: ").append(sliderModel.get_value()).toString());
        if (this.controllerValueHelper != this.valueRequested) {
            this.fireIntegerEvent("valueChanged", this.controllerValueHelper);
            this.valueRequested = this.controllerValueHelper;
            sliderModel.stopValueChangeShadowTimer(false);
            sliderModel.set_value(this.controllerValueHelper);
            sliderModel.startValueChangeShadowTimer();
        }
    }
}

