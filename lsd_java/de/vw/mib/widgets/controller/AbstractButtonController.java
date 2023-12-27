/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.widgets.controller.AbstractWidgetController;
import de.vw.mib.widgets.controller.ButtonController;
import de.vw.mib.widgets.models.AbstractButtonModel;

public abstract class AbstractButtonController
extends AbstractWidgetController
implements ButtonController {
    public static final int HIT_TEST_TOLERANCE = Integer.getInteger("de.vw.mib.widgets.button.hittolerance", 20);
    private int handlingTouchEventShadowCounter;

    @Override
    protected void reset() {
        super.reset();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        super.deInit();
    }

    protected final boolean isHandlingTouchEvent() {
        return this.handlingTouchEventShadowCounter > 0;
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        boolean bl = false;
        if ("press".equals(string)) {
            this.fire_press();
            bl = true;
        } else if ("release".equals(string)) {
            this.fire_release();
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
        AbstractButtonModel abstractButtonModel = (AbstractButtonModel)this.getWidget();
        boolean bl = false;
        this.enableHandlingTouchEvent();
        try {
            if (!abstractButtonModel.is_visible()) return bl;
            switch (touchEvent.getType()) {
                case 1: {
                    if (!abstractButtonModel.isPressed()) {
                        if (!abstractButtonModel.isAbsPointInside(touchEvent.getX(), touchEvent.getY())) return bl;
                        this.fire_press();
                        bl = true;
                        return bl;
                    }
                    if (!abstractButtonModel.isAbsPointInside(touchEvent.getX(), touchEvent.getY())) {
                        abstractButtonModel.setPressed(false);
                        this.fire_cancelled();
                        return bl;
                    }
                    bl = true;
                    return bl;
                }
                case 3: 
                case 4: {
                    abstractButtonModel.setPressed(abstractButtonModel.isAbsPointInside(touchEvent.getX(), touchEvent.getY(), HIT_TEST_TOLERANCE));
                    return bl;
                }
                case 11: {
                    abstractButtonModel.setPressed(false);
                    this.fire_cancelled();
                    bl = true;
                    return bl;
                }
                case 0: 
                case 2: {
                    if (abstractButtonModel.isPressed() && abstractButtonModel.isAbsPointInside(touchEvent.getX(), touchEvent.getY(), HIT_TEST_TOLERANCE)) {
                        this.fire_release();
                        bl = true;
                        return bl;
                    }
                    abstractButtonModel.setPressed(false);
                    this.fire_cancelled();
                    return bl;
                }
                case 6: {
                    abstractButtonModel.setPressed(false);
                    this.fire_cancelled();
                    return bl;
                }
            }
            return bl;
        }
        finally {
            this.disableHandlingTouchEvent();
        }
    }

    protected final void disableHandlingTouchEvent() {
        --this.handlingTouchEventShadowCounter;
    }

    protected final void enableHandlingTouchEvent() {
        ++this.handlingTouchEventShadowCounter;
    }

    @Override
    public void fire_press() {
        AbstractButtonModel abstractButtonModel = (AbstractButtonModel)this.getWidget();
        abstractButtonModel.setPressed(true);
        if (abstractButtonModel.is_interactive()) {
            this.fire_pressed();
        }
    }

    @Override
    public void fire_release() {
        AbstractButtonModel abstractButtonModel = (AbstractButtonModel)this.getWidget();
        abstractButtonModel.setPressed(false);
        this.fire_released();
    }

    @Override
    public void fire_pressed() {
        this.fireHMIEvent("pressed");
    }

    @Override
    public void fire_released() {
        this.fireHMIEvent("released");
    }

    @Override
    public void fire_cancelled() {
        this.fireHMIEvent("cancelled");
    }
}

