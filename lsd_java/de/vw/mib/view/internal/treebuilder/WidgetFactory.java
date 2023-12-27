/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal.treebuilder;

import de.vw.mib.widgets.models.WidgetModel;

public interface WidgetFactory {
    public static final int CLONEABLE_MARKER;

    default public WidgetModel getWidgetInstance(int n) {
    }

    default public void releaseWidgetInstance(int n, WidgetModel widgetModel) {
    }
}

