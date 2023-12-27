/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.WidgetController;
import de.vw.mib.widgets.models.ButtonModel;

public interface GenericCarAdjusterController
extends WidgetController {
    default public void updateButtonListener(ButtonModel[] buttonModelArray) {
    }
}

