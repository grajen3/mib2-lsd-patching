/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.DefaultToggleButtonController;
import de.vw.mib.widgets.controller.RadioButtonController;
import de.vw.mib.widgets.models.ButtonModel;

public final class DefaultRadioButtonController
extends DefaultToggleButtonController
implements RadioButtonController {
    @Override
    protected void reset() {
        super.reset();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void fire_press() {
        super.fire_press();
    }

    @Override
    public void fire_release() {
        super.fire_release();
        ButtonModel buttonModel = (ButtonModel)this.getWidget();
        if (buttonModel.is_interactive() && !buttonModel.is_activated()) {
            buttonModel.set_activated(true);
            this.fire_activated();
        }
    }

    @Override
    public void fire_activated() {
        this.fireHMIEvent("activated");
    }

    @Override
    public void fire_deactivated() {
        this.fireHMIEvent("deactivated");
    }
}

