/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.models.ButtonModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractButtonUI;

public class ButtonUI
extends AbstractButtonUI {
    @Override
    protected void paintButtonTouchArea(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        ButtonModel buttonModel = (ButtonModel)widgetModel;
        if (buttonModel.is_visible() && buttonModel.hasVertices()) {
            int n;
            int n2;
            int n3;
            int n4;
            Point[] pointArray = buttonModel.get_vertices();
            Point point = pointArray[0];
            Point point2 = null;
            graphics3D.resetMatrix(0);
            for (n4 = 0; n4 < pointArray.length; ++n4) {
                if (point2 == null) {
                    point2 = pointArray[n4];
                    continue;
                }
                n3 = point2.x;
                n2 = point2.y;
                n = pointArray[n4].x;
                int n5 = pointArray[n4].y;
                this.drawDebugLine(graphics3D, n3, n2, n, n5, Color4f.MAGENTA);
                point2 = pointArray[n4];
            }
            if (point2 != null) {
                n4 = point2.x;
                n3 = point2.y;
                n2 = point.x;
                n = point.y;
                this.drawDebugLine(graphics3D, n4, n3, n2, n, Color4f.MAGENTA);
            }
        } else {
            super.paintButtonTouchArea(graphics3D, viewModel, widgetModel, rectangle, rectangle2, f2);
        }
    }
}

