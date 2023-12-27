/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.RotationEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.widgets.controller.AbstractButtonController;
import de.vw.mib.widgets.controller.PuckController;
import de.vw.mib.widgets.models.AbstractSliderModel;

public abstract class AbstractSliderController
extends AbstractButtonController
implements PuckController {
    private int DEFAULT_ROTATION_TICKS = 1;
    private int rotationTick;
    protected boolean eventTimeRunning;
    protected int clickedX;
    protected int clickedY;
    protected int controllerValueHelper;
    protected int valueRequested;

    @Override
    protected void reset() {
        super.reset();
        this.eventTimeRunning = false;
        this.clickedX = -1;
        this.clickedY = -1;
    }

    @Override
    public void init() {
        super.init();
        this.rotationTick = this.DEFAULT_ROTATION_TICKS;
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        boolean bl = false;
        this.rotationTick = null != hMIEvent && hMIEvent.getType() == 16 ? ((RotationEvent)hMIEvent).getTicks() : 1;
        if ("stepDown" == string) {
            this.fire_stepDown();
            bl = true;
        } else if ("stepUp" == string) {
            this.fire_stepUp();
            bl = true;
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        AbstractSliderModel abstractSliderModel = (AbstractSliderModel)this.getWidget();
        boolean bl = false;
        this.enableHandlingTouchEvent();
        try {
            if (!abstractSliderModel.is_interactive()) return bl;
            if (!abstractSliderModel.is_visible()) return bl;
            this.clickedX = touchEvent.getX();
            this.clickedY = touchEvent.getY();
            this.trace(new StringBuffer().append(".consumeTouchEvent(), ").append(touchEvent).toString());
            switch (touchEvent.getType()) {
                case 1: {
                    this.fire_press();
                    bl = true;
                    return bl;
                }
                case 11: {
                    abstractSliderModel.setPressed(false);
                    this.fire_cancelled();
                    bl = true;
                    return bl;
                }
                case 0: 
                case 2: {
                    this.fire_release();
                    bl = true;
                    return bl;
                }
                case 3: 
                case 4: {
                    this.fire_drag();
                    bl = true;
                    return bl;
                }
            }
            return bl;
        }
        finally {
            this.disableHandlingTouchEvent();
        }
    }

    @Override
    public void fire_stepDown() {
        AbstractSliderModel abstractSliderModel = (AbstractSliderModel)this.getWidget();
        this.controllerValueHelper = abstractSliderModel.get_value() - abstractSliderModel.get_step() * this.rotationTick;
        if (this.controllerValueHelper < abstractSliderModel.get_valueMin() && abstractSliderModel.is_wrapFlag()) {
            this.controllerValueHelper = abstractSliderModel.get_valueMax();
        }
        if (this.controllerValueHelper >= abstractSliderModel.get_valueMin()) {
            abstractSliderModel.setScalePosition(Math.round((float)(this.controllerValueHelper - abstractSliderModel.get_valueMin()) * abstractSliderModel.getScaleRatio()));
        }
    }

    @Override
    public void fire_stepUp() {
        AbstractSliderModel abstractSliderModel = (AbstractSliderModel)this.getWidget();
        this.controllerValueHelper = abstractSliderModel.get_value() + abstractSliderModel.get_step() * this.rotationTick;
        if (this.controllerValueHelper > abstractSliderModel.get_valueMax() && abstractSliderModel.is_wrapFlag()) {
            this.controllerValueHelper = abstractSliderModel.get_valueMin();
        }
        if (this.controllerValueHelper <= abstractSliderModel.get_valueMax()) {
            abstractSliderModel.setScalePosition(Math.round((float)(this.controllerValueHelper - abstractSliderModel.get_valueMin()) * abstractSliderModel.getScaleRatio()));
        }
    }

    @Override
    public abstract void fire_drag() {
    }

    @Override
    public void fire_cancelled() {
        super.fire_cancelled();
    }

    @Override
    public abstract void fire_valueChanged() {
    }

    protected void trace(String string) {
        if (LOGGER.isTraceEnabled(16)) {
            String string2 = this.getWidget().getQualifiedName();
            String string3 = new StringBuffer().append(string2).append(" - Controller").toString();
            LOGGER.trace(16).append(string3).append(string).log();
        }
    }
}

