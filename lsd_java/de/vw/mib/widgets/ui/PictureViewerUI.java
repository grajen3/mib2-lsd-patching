/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.DynamicImageUI;

public final class PictureViewerUI
extends DynamicImageUI {
    private Rectangle clippingArea;

    @Override
    public void init() {
        super.init();
        this.clippingArea = new Rectangle();
    }

    @Override
    public void deInit() {
        super.deInit();
        this.clippingArea = null;
    }

    @Override
    protected void paintImage(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, Color4b color4b, float f2) {
        this.clippingArea.setBounds(0, 0, rectangle2.width, rectangle2.height);
        this.enableClipping(graphics3D, rectangle, this.clippingArea, rectangle2);
        super.paintImage(graphics3D, viewModel, widgetModel, rectangle, rectangle2, color4b, f2);
        this.disableClipping(graphics3D);
    }
}

