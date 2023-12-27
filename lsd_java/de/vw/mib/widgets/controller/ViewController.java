/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.WidgetController;

public interface ViewController
extends WidgetController {
    public static final String OUT_VIEWENTERED_NAME;
    public static final String OUT_VIEWREENTERED_NAME;
    public static final String OUT_VIEWLEFT_NAME;
    public static final String OUT_SWIPELEFT_NAME;
    public static final String OUT_SWIPERIGHT_NAME;

    default public void fire_viewEntered() {
    }

    default public void fire_viewReEntered() {
    }

    default public void fire_viewLeft() {
    }

    default public void fire_swipeLeft() {
    }

    default public void fire_swipeRight() {
    }
}

