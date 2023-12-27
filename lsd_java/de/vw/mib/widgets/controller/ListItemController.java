/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.WidgetController;
import de.vw.mib.widgets.event.OutEventListener;

public interface ListItemController
extends WidgetController {
    public static final String OUT_BUTTONPRESSED_NAME;
    public static final String OUT_BUTTONRELEASED_NAME;
    public static final String OUT_BUTTONLONGPRESSED_NAME;
    public static final String OUT_BUTTONLONGRELEASED_NAME;
    public static final String OUT_BUTTONCANCELLED_NAME;
    public static final String OUT_ITEMDRAGGED_NAME;
    public static final String OUT_ITEMDROPPED_NAME;
    public static final String OUT_ITEMTRIGGERFAILED_NAME;

    default public void setQueueOutEventsEnabled(boolean bl) {
    }

    default public void dispatchQueuedOutEvents() {
    }

    default public void discardQueuedOutEvents() {
    }

    default public OutEventListener getListItemEventHandler() {
    }

    default public void fire_buttonPressed() {
    }

    default public void fire_buttonReleased() {
    }

    default public void fire_buttonLongPressed() {
    }

    default public void fire_buttonLongReleased() {
    }

    default public void fire_buttonCancelled() {
    }

    default public void fire_itemDragged() {
    }

    default public void fire_itemDropped() {
    }

    default public void fire_itemTriggerFailed() {
    }
}

