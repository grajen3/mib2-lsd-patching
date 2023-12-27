/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.widgets.controller.DefaultViewController;
import de.vw.mib.widgets.controller.PopupViewController;

public final class DefaultPopupViewController
extends DefaultViewController
implements PopupViewController {
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
        return super.consumeHMIEvent(hMIEvent, string);
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        return super.consumeTouchEvent(touchEvent);
    }
}

