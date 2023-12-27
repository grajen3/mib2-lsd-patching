/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.TouchAreaController;
import de.vw.mib.widgets.controller.WidgetController;

public interface CanvasController
extends WidgetController,
TouchAreaController {
    public static final String IN_UPDATESCREENSHOT_NAME;
    public static final String IN_SCREENSHOTPREPARED_NAME;
    public static final String OUT_PREPARESCREENSHOT_NAME;
    public static final String OUT_SCREENSHOTCREATED_NAME;

    default public void fire_prepareScreenshot() {
    }

    default public void fire_screenshotCreated() {
    }
}

