/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.DefaultControlBarController;
import de.vw.mib.widgets.event.OutEventAdapter;
import de.vw.mib.widgets.models.ControlBarModel;
import de.vw.mib.widgets.models.InactiveAreaModel;

class DefaultControlBarController$InactiveAreaListener
extends OutEventAdapter {
    private final /* synthetic */ DefaultControlBarController this$0;

    public DefaultControlBarController$InactiveAreaListener(DefaultControlBarController defaultControlBarController) {
        this.this$0 = defaultControlBarController;
    }

    @Override
    public void outHMIEventFired(String string) {
        ControlBarModel controlBarModel = this.this$0.getControlBar();
        InactiveAreaModel inactiveAreaModel = controlBarModel.get_inactiveAreaRef();
        this.this$0.hideAllPushups();
        this.this$0.hideInactiveArea();
        this.this$0.setPushUpVisibility(false);
        controlBarModel.setCurrentActiveWidget(null);
        inactiveAreaModel.unFocus();
        inactiveAreaModel.getController().removeOutEventListener(this);
    }
}

