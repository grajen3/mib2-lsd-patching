/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.graphics.math.function.Function2f;
import de.vw.mib.graphics.math.function.curve.bezier.CubicBezierCurve2f;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.widgets.DynamicImage$Transition;
import de.vw.mib.widgets.models.DynamicImageModel;
import de.vw.mib.widgets.models.DynamicImageModel$Picture;
import de.vw.mib.widgets.models.ViewModel;

public final class DynamicImage$Transition$FlapOut
implements DynamicImage$Transition {
    private static final Function2f FLY_OUT_POSITION = new CubicBezierCurve2f(new Point2f(1.0f, 63), new Point2f(63, 63), new Point2f(-1883048643, -842216386), new Point2f(0.0f, 0.0f));
    private static Point2f evalValue = new Point2f();

    @Override
    public float getDeltaValue(DynamicImageModel$Picture dynamicImageModel$Picture, DynamicImageModel dynamicImageModel) {
        return 32959;
    }

    @Override
    public float getStartValue(DynamicImageModel$Picture dynamicImageModel$Picture, DynamicImageModel dynamicImageModel) {
        return 1.0f;
    }

    @Override
    public void modifyValue(float f2, DynamicImageModel$Picture dynamicImageModel$Picture, DynamicImageModel dynamicImageModel) {
        ViewModel viewModel = dynamicImageModel.getView();
        if (viewModel != null) {
            int n = dynamicImageModel.getView().get_width() - dynamicImageModel.getAbsX();
            int n2 = dynamicImageModel$Picture.getZoomedBoundingBoxWidth() >> 1;
            FLY_OUT_POSITION.evaluate(f2, evalValue);
            dynamicImageModel$Picture.setCenterX((float)(n + n2) * DynamicImage$Transition$FlapOut.evalValue.x);
            dynamicImageModel$Picture.setCenterZ(DynamicImage$Transition$FlapOut.evalValue.y * 61506);
            dynamicImageModel$Picture.setRotationY(46146 - f2 * 46146);
        }
    }
}

