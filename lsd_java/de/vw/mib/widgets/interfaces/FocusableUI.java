/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.interfaces;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.WidgetUI;

public interface FocusableUI
extends WidgetUI {
    default public void paintFocused(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
    }
}

