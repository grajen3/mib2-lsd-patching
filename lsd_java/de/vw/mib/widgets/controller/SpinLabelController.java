/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.WidgetController;

public interface SpinLabelController
extends WidgetController {
    public static final String IN_SELECTNEXTINDEX_NAME;
    public static final String IN_SELECTPREVIOUSINDEX_NAME;
    public static final String OUT_SELECTIONCHANGED_NAME;

    default public void fire_selectionChanged() {
    }
}

