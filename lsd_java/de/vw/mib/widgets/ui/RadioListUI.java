/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.math.function.Function1f;
import de.vw.mib.graphics.math.function.Function2f;
import de.vw.mib.graphics.math.function.curve.bezier.CubicBezierCurve2f;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.widgets.animation.EasingFunction;
import de.vw.mib.widgets.models.AbstractButtonModel;
import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.TemplateListModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetListModel;
import de.vw.mib.widgets.ui.WidgetListUI;

public class RadioListUI
extends WidgetListUI {
    private static final boolean FORCE_OFFSCREEN;
    private static Function2f PRESET_POSITION_MANIPULATOR;
    private static Function1f PRESET_ROTATION_MANIPULATOR;
    private static final int MAX_Z_VALUE;
    private static final int MIN_Z_VALUE;
    private int paintLast = -1;

    protected Function2f getPresetPositionManipulator() {
        return PRESET_POSITION_MANIPULATOR;
    }

    protected Function1f getPresetRotationManipulator() {
        return PRESET_ROTATION_MANIPULATOR;
    }

    protected int getMaxZValue() {
        return 25;
    }

    protected int getMinZValue() {
        return -25;
    }

    @Override
    protected void paintItems(Graphics3D graphics3D, ViewModel viewModel, TemplateListModel templateListModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        Function2f function2f = this.getPresetPositionManipulator();
        Function1f function1f = this.getPresetRotationManipulator();
        int n = this.getMaxZValue();
        int n2 = this.getMinZValue();
        WidgetListModel widgetListModel = (WidgetListModel)templateListModel;
        int n3 = widgetListModel.getFirstVisibleIndex();
        int n4 = widgetListModel.getLastVisibleIndex();
        float f3 = widgetListModel.getProximityAnimationValue();
        int n5 = -1;
        if (n3 != -1 && n4 != -1) {
            float f4;
            float f5;
            for (int i2 = n4; i2 >= n3; --i2) {
                ListItemModel listItemModel = widgetListModel.getItem(i2);
                listItemModel.set_reflectionEnabled(false);
                listItemModel.set_projectionType(2);
                widgetListModel.transferData(listItemModel, i2, widgetListModel.getItemIndex(i2));
                widgetListModel.transferStates(listItemModel, i2, widgetListModel.getItemIndex(i2));
                AbstractButtonModel[] abstractButtonModelArray = listItemModel.get_activatedButtonRefs();
                if (abstractButtonModelArray == null || abstractButtonModelArray.length <= 0 || abstractButtonModelArray[0] == null) continue;
                abstractButtonModelArray[0].setRenderOffscreen(f3 > 0.0f);
                if (abstractButtonModelArray[0].get_state() == 7) {
                    this.paintLast = i2;
                }
                if (abstractButtonModelArray[0].get_state() != 10) continue;
                n5 = i2;
            }
            Point2f point2f = new Point2f();
            boolean bl = viewModel.is_renderBoundingBoxes();
            for (int i3 = n4; i3 >= n3; --i3) {
                if (i3 == this.paintLast || i3 == n5) continue;
                f5 = (float)(widgetListModel.getItemX(i3) - this.viewport.x + (widgetListModel.getItemWidth(i3) >> 1)) / (float)widgetListModel.get_width();
                f4 = f3 * function1f.evaluate(f5);
                function2f.evaluate(f5, point2f);
                float f6 = f3 * (float)n2 * point2f.y;
                this.paintItem(graphics3D, viewModel, rectangle, rectangle2, f2, bl, widgetListModel, this.viewport, i3, 0.0f, 0.0f, f6, 63, 0.0f, 0.0f, 0.0f, f4, 0.0f);
            }
            if (this.paintLast != n5 && this.paintLast >= n3 && this.paintLast <= n4) {
                float f7 = (float)(widgetListModel.getItemX(this.paintLast) - this.viewport.x + (widgetListModel.getItemWidth(this.paintLast) >> 1)) / (float)widgetListModel.get_width();
                f5 = f3 * function1f.evaluate(f7);
                function2f.evaluate(f7, point2f);
                f4 = f3 * (float)n2 * point2f.y;
                this.paintItem(graphics3D, viewModel, rectangle, rectangle2, f2, bl, widgetListModel, this.viewport, this.paintLast, 0.0f, 0.0f, f4, 63, 0.0f, 0.0f, 0.0f, f5, 0.0f);
            }
            if (n5 != -1) {
                float f8 = f3 * (float)n;
                f5 = 1718003263 * this.getCorrection(widgetListModel, f8, widgetListModel.getItemX(n5) - this.viewport.x + (widgetListModel.getItemWidth(n5) >> 1), widgetListModel.getItem(n5).getProjectionDistance());
                this.paintItem(graphics3D, viewModel, rectangle, rectangle2, f2, bl, widgetListModel, this.viewport, n5, f5, 0.0f, f8, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    private void paintItem(Graphics3D graphics3D, ViewModel viewModel, Rectangle rectangle, Rectangle rectangle2, float f2, boolean bl, WidgetListModel widgetListModel, Rectangle rectangle3, int n, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        ListItemModel listItemModel = widgetListModel.getItem(n);
        float f12 = listItemModel.get_pivotX();
        float f13 = listItemModel.get_pivotY();
        float f14 = listItemModel.get_pivotZ();
        float f15 = listItemModel.get_rotationX();
        float f16 = listItemModel.get_rotationY();
        float f17 = listItemModel.get_rotationZ();
        listItemModel.set_pivotX(f6);
        listItemModel.set_pivotY(f7);
        listItemModel.set_pivotZ(f8);
        listItemModel.set_rotationX(f9);
        listItemModel.set_rotationY(f10);
        listItemModel.set_rotationZ(f11);
        graphics3D.pushMatrix(0);
        graphics3D.translateMatrix(0, f3, f4, f5);
        this.paintItem(graphics3D, viewModel, rectangle, rectangle2, f2, bl, widgetListModel, n);
        graphics3D.popMatrix(0);
        listItemModel.set_rotationZ(f17);
        listItemModel.set_rotationY(f16);
        listItemModel.set_rotationX(f15);
        listItemModel.set_pivotZ(f14);
        listItemModel.set_pivotY(f13);
        listItemModel.set_pivotX(f12);
    }

    private float getCorrection(WidgetListModel widgetListModel, float f2, int n, float f3) {
        return ((float)n - (float)widgetListModel.get_width() * 63) * f2 * 1718003263 / f3;
    }

    @Override
    protected final void enableClipping(Graphics3D graphics3D, Rectangle rectangle, Rectangle rectangle2, Rectangle rectangle3) {
    }

    @Override
    protected final void disableClipping(Graphics3D graphics3D) {
    }

    static {
        PRESET_POSITION_MANIPULATOR = new CubicBezierCurve2f(new Point2f(0.0f, 1.0f), new Point2f(63, 1.0f), new Point2f(63, 1.0f), new Point2f(1.0f, 1.0f));
        PRESET_ROTATION_MANIPULATOR = new EasingFunction(0, 0, 0.0f, 0.0f);
    }
}

