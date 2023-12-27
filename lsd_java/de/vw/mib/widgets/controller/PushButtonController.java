/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.ButtonController;

public interface PushButtonController
extends ButtonController {
    public static final String OUT_LONGPRESSED_NAME;
    public static final String OUT_LONGRELEASED_NAME;
    public static final String OUT_CANCELLEDLONGPRESS_NAME;

    default public void fire_longPressed() {
    }

    default public void fire_longReleased() {
    }

    default public void fire_cancelledLongpress() {
    }
}

