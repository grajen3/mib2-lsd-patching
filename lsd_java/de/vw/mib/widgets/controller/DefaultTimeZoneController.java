/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.widgets.controller.AbstractWidgetController;
import de.vw.mib.widgets.controller.TimeZoneController;
import de.vw.mib.widgets.models.TimeZoneModel;

public final class DefaultTimeZoneController
extends AbstractWidgetController
implements TimeZoneController {
    @Override
    protected void reset() {
        super.reset();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        if (string == "setNextTimeZone") {
            this.fire_setNextTimeZone();
        } else if (string == "setPrevTimeZone") {
            this.fire_setPrevTimeZone();
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        boolean bl = false;
        switch (touchEvent.getType()) {
            case 3: 
            case 4: {
                if (0 >= touchEvent.getGestureParam1()) {
                    this.fire_nextTimeZone();
                } else {
                    this.fire_prevTimeZone();
                }
                bl = true;
                break;
            }
            case 2: {
                bl = true;
                break;
            }
            case 11: {
                bl = true;
                break;
            }
            case 0: {
                bl = true;
                break;
            }
        }
        return bl;
    }

    @Override
    public void fire_setNextTimeZone() {
        TimeZoneModel timeZoneModel = (TimeZoneModel)this.getWidget();
        int n = timeZoneModel.get_activeTimezone();
        timeZoneModel.set_activeTimezone(n + 1);
    }

    @Override
    public void fire_setPrevTimeZone() {
        TimeZoneModel timeZoneModel = (TimeZoneModel)this.getWidget();
        int n = timeZoneModel.get_activeTimezone();
        timeZoneModel.set_activeTimezone(n - 1);
    }

    @Override
    public void fire_nextTimeZone() {
        this.fireHMIEvent("nextTimeZone");
    }

    @Override
    public void fire_prevTimeZone() {
        this.fireHMIEvent("prevTimeZone");
    }
}

