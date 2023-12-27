/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.WidgetController;

public interface PreviewLineController
extends WidgetController {
    public static final String IN_SHOWHISTORY_NAME;
    public static final String IN_SHOWPREVIEW_NAME;
    public static final String IN_SHOWRESULT_NAME;

    default public void fire_hideAll() {
    }

    default public void fire_showHistory() {
    }

    default public void fire_showPreview() {
    }

    default public void fire_showResult() {
    }
}

