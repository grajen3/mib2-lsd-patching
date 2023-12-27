/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.viewmanager;

import de.vw.mib.viewmanager.internal.ViewHandler;
import de.vw.mib.widgets.View;
import de.vw.mib.widgets.models.WidgetModel;

public interface DesktopDiag {
    default public ViewHandler getCurrentViewHandler() {
    }

    default public String getCurrentViewName() {
    }

    default public View[] getCurrentViews() {
    }

    default public WidgetModel findWidgetAt(int n, int n2) {
    }
}

