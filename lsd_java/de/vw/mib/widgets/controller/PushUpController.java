/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.WidgetController;

public interface PushUpController
extends WidgetController {
    public static final String IN_OPEN_NAME;
    public static final String IN_CLOSE_NAME;

    default public boolean fire_open() {
    }

    default public boolean fire_close() {
    }
}

