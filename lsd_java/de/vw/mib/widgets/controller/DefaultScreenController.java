/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.ProximityEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.widgets.controller.DefaultViewController;
import de.vw.mib.widgets.controller.ScreenController;
import de.vw.mib.widgets.internal.ServiceManager;

public class DefaultScreenController
extends DefaultViewController
implements ScreenController {
    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        super.deInit();
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        boolean bl = super.consumeTouchEvent(touchEvent);
        switch (touchEvent.getType()) {
            case 1: 
            case 6: {
                if (!bl) break;
                this.playPressTone();
                break;
            }
        }
        return bl;
    }

    @Override
    public boolean consumeProximityEvent(ProximityEvent proximityEvent) {
        return super.consumeProximityEvent(proximityEvent);
    }

    private void playPressTone() {
        if (ServiceManager.soundWaveplayer != null) {
            ServiceManager.soundWaveplayer.playButtonPressedTone();
        } else {
            LOGGER.warn(1, "SoundWaveplayer service not available");
        }
    }
}

