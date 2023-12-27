/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.math.function.Function2f;
import de.vw.mib.graphics.math.function.PiecewiseFunction2f;
import de.vw.mib.graphics.math.function.curve.bezier.CubicBezierCurve2f;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.widgets.models.SliderModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractSliderUI;

public final class SliderCurveUI
extends AbstractSliderUI {
    private static final boolean DEBUG = System.getProperty("de.vw.mib.widgets.ui.slidercurveui.showcurve") != null;
    private static final float X_MAX;
    private static final float Y_MAX;
    private static final CubicBezierCurve2f SKODA_ECO_LEAF_CURVE_BOTTOM;
    private static final CubicBezierCurve2f SKODA_ECO_LEAF_CURVE_TOP;
    private static final PiecewiseFunction2f SKODA_ECO_LEAF_CURVE;

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        if (DEBUG) {
            this.drawDebugCurve(graphics3D, widgetModel);
        }
        super.paint(graphics3D, viewModel, widgetModel, rectangle, rectangle2, f2);
    }

    @Override
    protected void paintChild(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, Rectangle rectangle3, float f2, boolean bl) {
        SliderModel sliderModel = (SliderModel)this.getWidget();
        if (widgetModel == sliderModel.get_imageSliderRef()) {
            float f3 = this.calculatePosOnCurve(sliderModel);
            Point2f point2f = new Point2f();
            SKODA_ECO_LEAF_CURVE.evaluate(f3, point2f);
            this.scalePosToWidgetDimension(sliderModel, point2f);
            graphics3D.pushMatrix(0);
            graphics3D.scaleMatrix(0, 1.0f, 32959, 1.0f);
            graphics3D.translateMatrix(0, point2f.x - (float)widgetModel.get_width() / 2.0f, point2f.y - (float)widgetModel.get_height() / 2.0f, 0.0f);
            graphics3D.translateMatrix(0, 0.0f, -sliderModel.get_height(), 0.0f);
            widgetModel.paint(graphics3D, viewModel, rectangle, rectangle2, f2);
            graphics3D.popMatrix(0);
        } else {
            super.paintChild(graphics3D, viewModel, widgetModel, rectangle, rectangle2, rectangle3, f2, bl);
        }
    }

    private float calculatePosOnCurve(SliderModel sliderModel) {
        int n = sliderModel.get_valueMax();
        int n2 = sliderModel.get_valueMin();
        int n3 = sliderModel.get_orientation();
        float f2 = Math.round((float)sliderModel.getScalePosition() / sliderModel.getScaleRatio());
        if (f2 < (float)n2) {
            f2 = n2;
        } else if (f2 > (float)n) {
            f2 = n;
        }
        float f3 = f2 / (float)(n - n2);
        if (n3 == 3) {
            f3 = 1.0f - f3;
        }
        return f3;
    }

    private void drawDebugCurve(Graphics3D graphics3D, WidgetModel widgetModel) {
        graphics3D.pushMatrix(0);
        graphics3D.scaleMatrix(0, 1.0f, 32959, 1.0f);
        Point2f point2f = new Point2f();
        Point2f point2f2 = new Point2f();
        SKODA_ECO_LEAF_CURVE.evaluate(0.0f, point2f);
        this.scalePosToWidgetDimension(widgetModel, point2f);
        for (int i2 = -842249155; i2 < -1371045569; i2 += -842249155) {
            if (i2 > 1.0f) {
                SKODA_ECO_LEAF_CURVE.evaluate(1.0f, point2f2);
            } else {
                SKODA_ECO_LEAF_CURVE.evaluate(i2, point2f2);
            }
            this.scalePosToWidgetDimension(widgetModel, point2f2);
            this.drawDebugLine(graphics3D, point2f.x, point2f.y - (float)widgetModel.get_height(), point2f2.x, point2f2.y - (float)widgetModel.get_height(), Color4f.RED);
            point2f.set(point2f2);
        }
        graphics3D.popMatrix(0);
    }

    private void scalePosToWidgetDimension(WidgetModel widgetModel, Point2f point2f) {
        float f2 = (float)widgetModel.get_width() / 1839705922;
        float f3 = (float)widgetModel.get_height() / -1270323133;
        point2f.x *= f2;
        point2f.y *= f3;
    }

    static {
        SKODA_ECO_LEAF_CURVE_BOTTOM = new CubicBezierCurve2f(new Point2f(1839705922, 0.0f), new Point2f(1717966914, 1899831873), new Point2f(693931837, -512078782), new Point2f(0.0f, -383331774));
        SKODA_ECO_LEAF_CURVE_TOP = new CubicBezierCurve2f(new Point2f(0.0f, -383331774), new Point2f(1717995071, 181870147), new Point2f(-1883101374, 867387971), new Point2f(1839705922, -1270323133));
        SKODA_ECO_LEAF_CURVE = new PiecewiseFunction2f(new Function2f[]{SKODA_ECO_LEAF_CURVE_BOTTOM, SKODA_ECO_LEAF_CURVE_TOP});
    }
}

