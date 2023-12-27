/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.PushButtonController;

public interface ToggleButtonController
extends PushButtonController {
    public static final String OUT_ACTIVATED_NAME;
    public static final String OUT_DEACTIVATED_NAME;

    default public void fire_activated() {
    }

    default public void fire_deactivated() {
    }
}

