/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.widgets.controller.AbstractWidgetController;
import de.vw.mib.widgets.controller.DefaultGenericCarAdjusterController$ButtonEventHandler;
import de.vw.mib.widgets.controller.GenericCarAdjusterController;
import de.vw.mib.widgets.models.ButtonModel;
import de.vw.mib.widgets.models.GenericCarAdjusterModel;

public class DefaultGenericCarAdjusterController
extends AbstractWidgetController
implements GenericCarAdjusterController {
    private DefaultGenericCarAdjusterController$ButtonEventHandler[] buttonEventHandler;

    @Override
    protected void reset() {
        super.reset();
        this.buttonEventHandler = null;
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

    @Override
    public void updateButtonListener(ButtonModel[] buttonModelArray) {
        ButtonModel[] buttonModelArray2;
        GenericCarAdjusterModel genericCarAdjusterModel = (GenericCarAdjusterModel)this.getWidget();
        if (buttonModelArray != null) {
            for (int i2 = buttonModelArray.length - 1; i2 >= 0; --i2) {
                if (buttonModelArray[i2] == null) continue;
                buttonModelArray[i2].getController().removeOutEventListener(this.buttonEventHandler[i2]);
            }
        }
        if ((buttonModelArray2 = genericCarAdjusterModel.get_buttonRefs()) != null) {
            this.buttonEventHandler = new DefaultGenericCarAdjusterController$ButtonEventHandler[buttonModelArray2.length];
            for (int i3 = buttonModelArray2.length - 1; i3 >= 0; --i3) {
                if (buttonModelArray2[i3] == null) continue;
                this.buttonEventHandler[i3] = new DefaultGenericCarAdjusterController$ButtonEventHandler(this, i3);
                if (buttonModelArray2[i3].getController() == null) continue;
                buttonModelArray2[i3].getController().addOutEventListener(this.buttonEventHandler[i3]);
            }
        }
    }
}

