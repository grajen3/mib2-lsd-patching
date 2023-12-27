/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal.treebuilder;

import de.vw.mib.widgets.ui.WidgetUI;

public interface UIFactory {
    public static final int NULL_UI_TYPE;

    default public WidgetUI getUIInstance(int n) {
    }

    default public void releaseUIInstance(int n, WidgetUI widgetUI) {
    }
}

