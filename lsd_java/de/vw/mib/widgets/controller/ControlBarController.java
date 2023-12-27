/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.ListController;

public interface ControlBarController
extends ListController {
    public static final String OUT_PUSHUPOPENED_NAME;
    public static final String OUT_PUSHUPOPENEDDETAILED_NAME;
    public static final String OUT_PUSHUPOPENEDBYBUTTON_NAME;
    public static final String OUT_PUSHUPCLOSED_NAME;

    default public void fire_pushUpOpened() {
    }

    default public void fire_pushUpOpenedDetailed() {
    }

    default public void fire_pushUpOpenedByButton() {
    }

    default public void fire_pushUpClosed() {
    }
}

