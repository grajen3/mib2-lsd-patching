/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.DefaultPushUpController;
import de.vw.mib.widgets.event.OutEventAdapter;
import de.vw.mib.widgets.interfaces.PushUpHandler;
import de.vw.mib.widgets.models.PushUpModel;

public final class DefaultPushUpController$ButtonEventHandler
extends OutEventAdapter {
    private DefaultPushUpController controller;

    public DefaultPushUpController$ButtonEventHandler(DefaultPushUpController defaultPushUpController) {
        this.controller = defaultPushUpController;
    }

    @Override
    public void outHMIEventFired(String string) {
        PushUpHandler pushUpHandler;
        if (("released" == string || "released" == string) && 0 == ((PushUpModel)this.controller.getWidget()).get_closeMode() && null != (pushUpHandler = ((PushUpModel)this.controller.getWidget()).getPushUpHandler())) {
            pushUpHandler.close();
        }
    }
}

