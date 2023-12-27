/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.DefaultControlBarController;
import de.vw.mib.widgets.event.OutEventAdapter;

class DefaultControlBarController$ButtonListener
extends OutEventAdapter {
    private final /* synthetic */ DefaultControlBarController this$0;

    public DefaultControlBarController$ButtonListener(DefaultControlBarController defaultControlBarController) {
        this.this$0 = defaultControlBarController;
    }

    @Override
    public void outHMIEventFired(String string) {
        if (string == "released") {
            this.this$0.managePushupActivation(DefaultControlBarController.access$000(this.this$0).getUtilizedWidget());
        }
    }
}

