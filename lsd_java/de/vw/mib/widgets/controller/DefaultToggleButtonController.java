/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.DefaultPushButtonController;
import de.vw.mib.widgets.controller.ToggleButtonController;
import de.vw.mib.widgets.models.ButtonModel;

public class DefaultToggleButtonController
extends DefaultPushButtonController
implements ToggleButtonController {
    @Override
    protected void reset() {
        super.reset();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void fire_release() {
        super.fire_release();
        ButtonModel buttonModel = (ButtonModel)this.getWidget();
        if (buttonModel.is_interactive()) {
            boolean bl = buttonModel.is_activated();
            buttonModel.set_activated(!bl);
            if (buttonModel.is_activated()) {
                this.fire_activated();
            } else {
                this.fire_deactivated();
            }
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

