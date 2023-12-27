/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.controller.AbstractButtonController;
import de.vw.mib.widgets.models.AbstractButtonModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.ContainerUI;

public abstract class AbstractButtonUI
extends ContainerUI {
    private static final boolean SHOW_BUTTON_TOUCH_AREA = System.getProperty("de.vw.mib.widgets.button.toucharea") != null;

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        super.paint(graphics3D, viewModel, widgetModel, rectangle, rectangle2, f2);
        if (SHOW_BUTTON_TOUCH_AREA) {
            this.paintButtonTouchArea(graphics3D, viewModel, widgetModel, rectangle, rectangle2, f2);
        }
    }

    protected void paintButtonTouchArea(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        AbstractButtonModel abstractButtonModel = (AbstractButtonModel)this.getWidget();
        if (abstractButtonModel.isPressed()) {
            Insets insets = abstractButtonModel.get_touchInsets();
            int n = insets.left;
            int n2 = insets.top;
            int n3 = abstractButtonModel.get_width() - insets.left - insets.right;
            int n4 = abstractButtonModel.get_height() - insets.top - insets.bottom;
            this.drawDebugLine(graphics3D, n, n2, n3 + n - 1, n2, Color4f.GREEN);
            this.drawDebugLine(graphics3D, n, n4 + n2 - 1, n3 + n - 1, n4 + n2 - 1, Color4f.GREEN);
            this.drawDebugLine(graphics3D, n, n2, n, n4 + n2 - 1, Color4f.GREEN);
            this.drawDebugLine(graphics3D, n3 + n - 1, n2, n3 + n - 1, n4 + n2 - 1, Color4f.GREEN);
            int n5 = AbstractButtonController.HIT_TEST_TOLERANCE;
            this.drawDebugLine(graphics3D, n -= n5, n2 -= n5, (n3 += 2 * n5) + n - 1, n2, Color4f.RED);
            this.drawDebugLine(graphics3D, n, (n4 += 2 * n5) + n2 - 1, n3 + n - 1, n4 + n2 - 1, Color4f.RED);
            this.drawDebugLine(graphics3D, n, n2, n, n4 + n2 - 1, Color4f.RED);
            this.drawDebugLine(graphics3D, n3 + n - 1, n2, n3 + n - 1, n4 + n2 - 1, Color4f.RED);
            this.drawDebugText(graphics3D, n, n2 + 12, new StringBuffer().append("T: ").append(n5).toString());
        }
    }
}

