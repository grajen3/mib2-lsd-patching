/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.widgets.controller.AbstractWidgetController;
import de.vw.mib.widgets.controller.InactiveAreaController;
import de.vw.mib.widgets.controller.WidgetController;
import de.vw.mib.widgets.interfaces.Focusable;
import de.vw.mib.widgets.models.InactiveAreaModel;

public final class DefaultInactiveAreaController
extends AbstractWidgetController
implements InactiveAreaController {
    @Override
    public int getTouchForwardingMode() {
        return 0;
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        boolean bl = false;
        InactiveAreaModel inactiveAreaModel = (InactiveAreaModel)this.getWidget();
        if (inactiveAreaModel.is_visible() && "press".equals(string)) {
            this.fire_press();
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        InactiveAreaModel inactiveAreaModel = (InactiveAreaModel)this.getWidget();
        boolean bl = false;
        if (inactiveAreaModel.is_visible()) {
            if (inactiveAreaModel.isEventForwarding()) {
                WidgetController widgetController;
                Focusable focusable = inactiveAreaModel.getFocusedWidget();
                WidgetController widgetController2 = widgetController = focusable != null ? focusable.getController() : null;
                if (widgetController != null) {
                    bl = widgetController.consumeTouchEvent(touchEvent);
                }
            }
            if (!bl) {
                switch (touchEvent.getType()) {
                    case 1: 
                    case 6: {
                        if (!inactiveAreaModel.isAbsPointInsideTouchableArea(touchEvent.getX(), touchEvent.getY())) break;
                        this.fire_press();
                        bl = true;
                        break;
                    }
                    case 0: 
                    case 2: {
                        if (!inactiveAreaModel.isAbsPointInsideTouchableArea(touchEvent.getX(), touchEvent.getY())) break;
                        this.fire_release();
                        bl = true;
                        break;
                    }
                }
            }
        }
        return bl;
    }

    @Override
    public void fire_press() {
        this.fire_pressed();
    }

    public void fire_release() {
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
}

