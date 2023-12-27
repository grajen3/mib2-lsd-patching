/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.DefaultGenericCarAdjusterController;
import de.vw.mib.widgets.event.OutEventAdapter;
import de.vw.mib.widgets.models.GenericCarAdjusterModel;

public final class DefaultGenericCarAdjusterController$ButtonEventHandler
extends OutEventAdapter {
    private DefaultGenericCarAdjusterController controller;
    private int buttonIndex;

    public DefaultGenericCarAdjusterController$ButtonEventHandler(DefaultGenericCarAdjusterController defaultGenericCarAdjusterController, int n) {
        this.controller = defaultGenericCarAdjusterController;
        this.buttonIndex = n;
    }

    @Override
    public void outHMIEventFired(String string) {
        if (string == "released") {
            GenericCarAdjusterModel genericCarAdjusterModel = (GenericCarAdjusterModel)this.controller.getWidget();
            genericCarAdjusterModel.setActiveButtonIdx(this.buttonIndex);
        }
    }
}

