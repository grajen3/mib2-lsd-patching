/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.DefaultListItemController;
import de.vw.mib.widgets.event.OutEventAdapter;

public final class DefaultListItemController$ListItemEventHandler
extends OutEventAdapter {
    private DefaultListItemController controller;

    public DefaultListItemController$ListItemEventHandler(DefaultListItemController defaultListItemController) {
        this.controller = defaultListItemController;
    }

    @Override
    public void outListItemEventFired(String string, int n, int n2, int n3, int n4, String string2, long l) {
        this.controller.prepareEventParameter(n4, string2);
        if (string == "buttonPressed") {
            this.controller.fire_buttonPressed();
        } else if (string == "buttonReleased") {
            this.controller.fire_buttonReleased();
        } else if (string == "buttonLongPressed") {
            this.controller.fire_buttonLongPressed();
        } else if (string == "buttonLongReleased") {
            this.controller.fire_buttonLongReleased();
        }
    }

    @Override
    public void outHMIEventFired(String string) {
        if (string == "pressed") {
            this.controller.fire_buttonPressed();
        } else if (string == "released") {
            this.controller.fire_buttonReleased();
        } else if (string == "longPressed") {
            this.controller.fire_buttonLongPressed();
        } else if (string == "longReleased") {
            this.controller.fire_buttonLongReleased();
        } else if (string == "cancelledLongpress") {
            this.controller.fire_buttonCancelled();
        } else if (string == "cancelled") {
            this.controller.fire_buttonCancelled();
        }
    }
}

