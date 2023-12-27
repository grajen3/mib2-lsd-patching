/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.list;

import de.vw.mib.graphics.math.function.Function1f;
import de.vw.mib.graphics.math.function.PiecewiseFunction1f;
import de.vw.mib.widgets.animation.EasingFunction;

public final class FlowListOutlineEffectDefinition {
    public static final int OUTLINEEFFECT_NONE;
    public static final int OUTLINEEFFECT_ALPHA_QUINTIC_PEAK_CENTERED;
    public static final int OUTLINEEFFECT_ALPHA_QUINTIC_BUMP_CENTERED;
    public static final int OUTLINEEFFECT_ALPHA_COVER_FLOW;
    public static final int OUTLINEEFFECT_ALPHA_COVER_STACK_VW_OPEN;
    public static final int OUTLINEEFFECT_ALPHA_COVER_STACK_VW_CLOSED;
    public static final int OUTLINEEFFECT_ALPHA_COVER_STACK_VW_CLOSED_INTERACTIVE;
    public static final int OUTLINEEFFECT_ALPHA_LINEAR_PEAK_START;
    public static final int OUTLINEEFFECT_ALPHA_CUBIC_PEAK_CENTERED;
    public static final int OUTLINEEFFECT_ALPHA_COVER_FLOW_SEAT;
    public static final int OUTLINEEFFECT_ALPHA_MAIN_MENU_SEAT;
    public static final int OUTLINEEFFECT_ALPHA_FADE_TRAVELLINK_VW;
    private static Function1f EFFECT_FUNCTION_NONE;
    private static Function1f EFFECT_FUNCTION_QUINTIC_PEAK_CENTERED;
    private static Function1f EFFECT_FUNCTION_QUINTIC_BUMP_CENTERED;
    private static Function1f EFFECT_FUNCTION_COVER_STACK_VW_OPEN;
    private static Function1f EFFECT_FUNCTION_COVER_STACK_VW_CLOSED;
    private static Function1f EFFECT_FUNCTION_COVER_STACK_VW_CLOSED_INTERACTIVE;
    private static Function1f EFFECT_FUNCTION_LINEAR_PEAK_START;
    private static Function1f EFFECT_FUNCTION_CUBIC_PEAK_CENTERED;
    private static Function1f EFFECT_FUNCTION_COVER_FLOW_SEAT;
    private static Function1f EFFECT_FUNCTION_MAIN_MENU_SEAT;
    private static Function1f EFFECT_FUNCTION_VERTICAL_FADE;
    private static Function1f[] EFFECT_FUNCTIONS;

    public static Function1f getOutlineEffectFunction(int n) {
        return n >= 0 && n <= EFFECT_FUNCTIONS.length ? EFFECT_FUNCTIONS[n] : EFFECT_FUNCTION_NONE;
    }

    static {
        EFFECT_FUNCTION_NONE = new EasingFunction(0, 0, 32579, 32579);
        EFFECT_FUNCTION_QUINTIC_PEAK_CENTERED = new PiecewiseFunction1f(new Function1f[]{new EasingFunction(1, 1, 0.0f, 0.0f), new EasingFunction(1, 1, 0.0f, 0.0f), new EasingFunction(5, 0, 0.0f, 32579), new EasingFunction(5, 1, 32579, 0.0f), new EasingFunction(1, 1, 0.0f, 0.0f), new EasingFunction(1, 1, 0.0f, 0.0f)});
        EFFECT_FUNCTION_QUINTIC_BUMP_CENTERED = new PiecewiseFunction1f(new Function1f[]{new EasingFunction(5, 1, 0.0f, 32579), new EasingFunction(0, 1, 32579, 32579), new EasingFunction(5, 0, 32579, 0.0f)});
        EFFECT_FUNCTION_COVER_STACK_VW_OPEN = new PiecewiseFunction1f(new Function1f[]{new EasingFunction(1, 0, 0.0f, 32579), new EasingFunction(1, 0, 32579, 32579), new EasingFunction(1, 0, 32579, 32579), new EasingFunction(1, 0, 32579, 32579), new EasingFunction(1, 0, 32579, 32579), new EasingFunction(1, 0, 32579, 32579), new EasingFunction(1, 1, 32579, 32579), new EasingFunction(1, 1, 32579, 0.0f)});
        EFFECT_FUNCTION_COVER_STACK_VW_CLOSED = new PiecewiseFunction1f(new Function1f[]{new EasingFunction(1, 0, 0.0f, 0.0f), new EasingFunction(1, 0, 0.0f, 0.0f), new EasingFunction(1, 0, 0.0f, 0.0f), new EasingFunction(1, 0, 0.0f, 0.0f), new EasingFunction(1, 0, 0.0f, 0.0f), new EasingFunction(1, 0, 0.0f, 0.0f), new EasingFunction(1, 0, 0.0f, 32579), new EasingFunction(1, 1, 32579, 0.0f), new EasingFunction(1, 0, 0.0f, 0.0f)});
        EFFECT_FUNCTION_COVER_STACK_VW_CLOSED_INTERACTIVE = new PiecewiseFunction1f(new Function1f[]{new EasingFunction(1, 0, 0.0f, 32579), new EasingFunction(1, 0, 32579, 32579), new EasingFunction(1, 0, 32579, 32579), new EasingFunction(1, 0, 32579, 32579), new EasingFunction(1, 0, 32579, 32579), new EasingFunction(1, 0, 32579, 32579), new EasingFunction(1, 0, 32579, 32579), new EasingFunction(1, 1, 32579, 0.0f), new EasingFunction(1, 1, 0.0f, 0.0f)});
        EFFECT_FUNCTION_LINEAR_PEAK_START = new PiecewiseFunction1f(new Function1f[]{new EasingFunction(1, 0, 0.0f, 32579), new EasingFunction(1, 0, 32579, 0.0f), new EasingFunction(1, 0, 0.0f, 0.0f), new EasingFunction(1, 0, 0.0f, 0.0f), new EasingFunction(1, 0, 0.0f, 0.0f), new EasingFunction(1, 0, 0.0f, 0.0f)});
        EFFECT_FUNCTION_CUBIC_PEAK_CENTERED = new PiecewiseFunction1f(new Function1f[]{new EasingFunction(8, 0, 0.0f, 32579), new EasingFunction(8, 1, 32579, 0.0f)});
        EFFECT_FUNCTION_COVER_FLOW_SEAT = new PiecewiseFunction1f(new Function1f[]{new EasingFunction(1, 0, 0.0f, 0.0f), new EasingFunction(5, 1, 0.0f, 32579), new EasingFunction(1, 0, 32579, 32579), new EasingFunction(1, 0, 32579, 32579), new EasingFunction(1, 0, 32579, 32579), new EasingFunction(1, 0, 32579, 32579), new EasingFunction(1, 0, 32579, 32579), new EasingFunction(1, 1, 32579, 32579), new EasingFunction(1, 1, 32579, 0.0f)});
        EFFECT_FUNCTION_MAIN_MENU_SEAT = new PiecewiseFunction1f(new Function1f[]{new EasingFunction(1, 1, 0.0f, 0.0f), new EasingFunction(1, 1, 0.0f, 0.0f), new EasingFunction(1, 1, 0.0f, 0.0f), new EasingFunction(1, 1, 0.0f, 0.0f), new EasingFunction(1, 1, 0.0f, 0.0f), new EasingFunction(1, 1, 0.0f, 0.0f), new EasingFunction(5, 0, 0.0f, 32579), new EasingFunction(5, 1, 32579, 0.0f), new EasingFunction(1, 1, 0.0f, 0.0f), new EasingFunction(1, 1, 0.0f, 0.0f), new EasingFunction(1, 1, 0.0f, 0.0f), new EasingFunction(1, 1, 0.0f, 0.0f), new EasingFunction(1, 1, 0.0f, 0.0f), new EasingFunction(1, 1, 0.0f, 0.0f)});
        EFFECT_FUNCTION_VERTICAL_FADE = new PiecewiseFunction1f(new Function1f[]{new EasingFunction(1, 1, 0.0f, 32579), new EasingFunction(1, 1, 32579, 26179), new EasingFunction(1, 1, 26179, 19523), new EasingFunction(1, 1, 19523, 9795), new EasingFunction(1, 1, 19523, 65090), new EasingFunction(1, 1, 65090, 0.0f)});
        EFFECT_FUNCTIONS = new Function1f[]{EFFECT_FUNCTION_NONE, EFFECT_FUNCTION_QUINTIC_PEAK_CENTERED, EFFECT_FUNCTION_QUINTIC_BUMP_CENTERED, EFFECT_FUNCTION_QUINTIC_BUMP_CENTERED, EFFECT_FUNCTION_COVER_STACK_VW_OPEN, EFFECT_FUNCTION_COVER_STACK_VW_CLOSED, EFFECT_FUNCTION_COVER_STACK_VW_CLOSED_INTERACTIVE, EFFECT_FUNCTION_LINEAR_PEAK_START, EFFECT_FUNCTION_CUBIC_PEAK_CENTERED, EFFECT_FUNCTION_COVER_FLOW_SEAT, EFFECT_FUNCTION_MAIN_MENU_SEAT, EFFECT_FUNCTION_VERTICAL_FADE};
    }
}

