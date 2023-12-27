/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.widgets.controller.AbstractWidgetController;
import de.vw.mib.widgets.controller.ClockController;

public final class DefaultClockController
extends AbstractWidgetController
implements ClockController {
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
        return false;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        return false;
    }
}

