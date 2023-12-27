/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.math.function.Function1f;
import de.vw.mib.graphics.math.function.Function2f;
import de.vw.mib.graphics.math.function.PiecewiseFunction2f;
import de.vw.mib.graphics.math.function.curve.bezier.CubicBezierCurve2f;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.widgets.animation.EasingFunction;
import de.vw.mib.widgets.ui.RadioListUI;

public final class RadioListRotatedUI
extends RadioListUI {
    private static final Function2f PRESET_POSITION_MANIPULATOR = new PiecewiseFunction2f(new Function2f[]{new CubicBezierCurve2f(new Point2f(0.0f, -1701209794), new Point2f(32830, 16447), new Point2f(32830, 16447), new Point2f(63, 1.0f)), new CubicBezierCurve2f(new Point2f(1.0f, 63), new Point2f(16447, 16447), new Point2f(16447, 16447), new Point2f(1.0f, -1701209794))});
    private static final Function1f PRESET_ROTATION_MANIPULATOR = new EasingFunction(1, 0, 51265, 51393);
    private static final int MAX_Z_VALUE;
    private static final int MIN_Z_VALUE;

    @Override
    protected Function2f getPresetPositionManipulator() {
        return PRESET_POSITION_MANIPULATOR;
    }

    @Override
    protected Function1f getPresetRotationManipulator() {
        return PRESET_ROTATION_MANIPULATOR;
    }

    @Override
    protected int getMaxZValue() {
        return 30;
    }

    @Override
    protected int getMinZValue() {
        return -50;
    }
}

