/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.ButtonController;

public interface PuckController
extends ButtonController {
    public static final String IN_STEPDOWN_NAME;
    public static final String IN_STEPUP_NAME;
    public static final String OUT_VALUECHANGED_NAME;

    default public void fire_stepDown() {
    }

    default public void fire_stepUp() {
    }

    default public void fire_drag() {
    }

    default public void fire_valueChanged() {
    }
}

