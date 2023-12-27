/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.WidgetController;

public interface ScrollableTextController
extends WidgetController {
    public static final String IN_SCROLLUP_NAME;
    public static final String IN_SCROLLDOWN_NAME;

    default public void fire_scrollUp() {
    }

    default public void fire_scrollDown() {
    }
}

