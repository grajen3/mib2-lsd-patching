/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.WidgetController;

public interface InactiveAreaController
extends WidgetController {
    public static final String IN_PRESS_NAME;
    public static final String OUT_PRESSED_NAME;
    public static final String OUT_RELEASED_NAME;

    default public void fire_press() {
    }

    default public void fire_pressed() {
    }

    default public void fire_released() {
    }
}

