/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal.treebuilder;

import de.vw.mib.widgets.controller.WidgetController;

public interface ControllerFactory {
    public static final int NULL_CONTROLLER_TYPE;

    default public WidgetController getControllerInstance(int n) {
    }

    default public void releaseControllerInstance(int n, WidgetController widgetController) {
    }
}

