/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.WidgetController;

public interface ListController
extends WidgetController {
    public static final String IN_SELECTNEXT_NAME;
    public static final String IN_SELECTPREVIOUS_NAME;
    public static final String IN_PRESS_NAME;
    public static final String IN_RELEASE_NAME;
    public static final String OUT_PRESSED_NAME;
    public static final String OUT_RELEASED_NAME;
    public static final String OUT_SELECTIONCHANGED_NAME;

    default public void fire_selectNext() {
    }

    default public void fire_selectPrevious() {
    }

    default public void fire_press() {
    }

    default public void fire_selectionChanged() {
    }

    default public void fire_pressed() {
    }

    default public void fire_released() {
    }

    default public void revalidateSelectedIndex() {
    }
}

