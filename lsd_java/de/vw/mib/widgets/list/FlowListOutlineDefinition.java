/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.list;

import de.vw.mib.graphics.math.function.Function1f;
import de.vw.mib.graphics.math.function.Function2f;
import de.vw.mib.graphics.math.function.PiecewiseFunction1f;
import de.vw.mib.graphics.math.function.PiecewiseFunction2f;
import de.vw.mib.graphics.math.function.curve.bezier.CubicBezierCurve2f;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.widgets.animation.EasingFunction;

public final class FlowListOutlineDefinition {
    public static final int SCROLLING_DIRECTION_OUTLINE;
    public static final int SCROLLING_DIRECTION_VERTICAL;
    public static final int SCROLLING_DIRECTION_HORIZONTAL;
    public static final int[] OUTLINE_SCROLLING;
    public static final int SNAP_DISTANCE_FRICTION;
    public static final int SNAP_DISTANCE_ITEMWISE;
    private final Function2f shape;
    private final Function1f yRotation;
    private final float centerPosition;
    private final float offset;
    private final float acceleration;
    private final float debounce;
    private final boolean snapToGridEnabled;
    private final int snapShortcutSize;
    private final int scrollingDirection;
    private final int snapDistance;
    private static final FlowListOutlineDefinition OUTLINE_DEFINITION_CIRCLE;
    private static final FlowListOutlineDefinition OUTLINE_DEFINITION_PARABOLA;
    private static final FlowListOutlineDefinition OUTLINE_DEFINITION_COVERFLOW;
    private static final FlowListOutlineDefinition OUTLINE_DEFINITION_LINEAR;
    private static final FlowListOutlineDefinition OUTLINE_DEFINITION_CUSTOM;
    private static final float ACTIVE_DISPLACED_ROTATION_9_2;
    private static final FlowListOutlineDefinition OUTLINE_DEFINITION_COVER_FLOW_ACTIVE_DISPLACED_9_2;
    private static final FlowListOutlineDefinition OUTLINE_DEFINITION_COVER_FLOW_ACTIVE_DISPLACED;
    private static final FlowListOutlineDefinition OUTLINE_DEFINITION_COVER_STACK_STAGGERED;
    private static final FlowListOutlineDefinition OUTLINE_DEFINITION_COVER_STACK;
    private static final FlowListOutlineDefinition OUTLINE_DEFINITION_VERTICAL;
    private static final FlowListOutlineDefinition OUTLINE_DEFINITION_VERTICAL_LEFT;
    private static final FlowListOutlineDefinition OUTLINE_DEFINITION_VERTICAL_RIGHT;
    private static final FlowListOutlineDefinition OUTLINE_DEFINITION_COVER_FLOW_SEAT;
    private static final FlowListOutlineDefinition OUTLINE_DEFINITION_COVER_STACK_APPROXIMATED_SEAT;
    private static final FlowListOutlineDefinition OUTLINE_DEFINITION_COVER_STACK_SEAT;
    public static final int OUTLINE_INDEX_CIRCLE;
    public static final int OUTLINE_INDEX_PARABOLA;
    public static final int OUTLINE_INDEX_COVERFLOW;
    public static final int OUTLINE_INDEX_LINEAR;
    public static final int OUTLINE_INDEX_COVER_FLOW_ACTIVE_DISPLACED;
    public static final int OUTLINE_INDEX_COVER_STACK_STAGGERED;
    public static final int OUTLINE_INDEX_COVER_STACK;
    public static final int OUTLINE_INDEX_VERTICAL;
    public static final int OUTLINE_INDEX_VERTICAL_LEFT;
    public static final int OUTLINE_INDEX_VERTICAL_RIGHT;
    public static final int OUTLINE_INDEX_COVER_FLOW_SEAT;
    public static final int OUTLINE_INDEX_COVER_STACK_APPROXIMATED_SEAT;
    public static final int OUTLINE_INDEX_COVER_STACK_SEAT;
    public static final int OUTLINE_INDEX_CUSTOM;
    public static final int OUTLINE_INDEX_COVER_FLOW_ACTIVE_DISPLACED_9_2;
    private static final FlowListOutlineDefinition[] OUTLINE_DEFINITIONS;

    private FlowListOutlineDefinition(Function2f function2f, Function1f function1f, float f2, float f3, float f4, float f5, boolean bl, int n) {
        this(function2f, function1f, f2, f3, f4, f5, bl, n, 0, 0);
    }

    private FlowListOutlineDefinition(Function2f function2f, Function1f function1f, float f2, float f3, float f4, float f5, boolean bl, int n, int n2, int n3) {
        this.shape = function2f;
        this.yRotation = function1f;
        this.centerPosition = f2;
        this.offset = f3;
        this.acceleration = f4;
        this.debounce = f5;
        this.snapToGridEnabled = bl;
        this.snapShortcutSize = n;
        this.scrollingDirection = n2;
        this.snapDistance = n3;
    }

    public void evaluateShapePosition(float f2, Point2f point2f) {
        this.shape.evaluate(f2, point2f);
    }

    public float evaluateYRotation(float f2) {
        return this.yRotation.evaluate(f2);
    }

    public float getCenterPosition() {
        return this.centerPosition;
    }

    public float getOffset() {
        return this.offset;
    }

    public float getAcceleration() {
        return this.acceleration;
    }

    public float getDebounce() {
        return this.debounce;
    }

    public boolean isSnapToGridEnabled() {
        return this.snapToGridEnabled;
    }

    public int getScrollingDirection() {
        return this.scrollingDirection;
    }

    public int getSnapDistance() {
        return this.snapDistance;
    }

    public static FlowListOutlineDefinition getOutline(int n) {
        return OUTLINE_DEFINITIONS[n];
    }

    public int getSnapShortcutSize() {
        return this.snapShortcutSize;
    }

    public static FlowListOutlineDefinition getOutlineCustom() {
        return OUTLINE_DEFINITION_CUSTOM;
    }

    private static PiecewiseFunction2f getShape(float[] fArray, float[] fArray2) {
        Function2f[] function2fArray = null;
        if (fArray != null && fArray2 != null && fArray.length == fArray2.length && fArray.length % 4 == 0) {
            function2fArray = new Function2f[fArray.length / 4];
            for (int i2 = 0; i2 < function2fArray.length; ++i2) {
                CubicBezierCurve2f cubicBezierCurve2f = new CubicBezierCurve2f(new Point2f(fArray[i2 * 4], fArray2[i2 * 4]), new Point2f(fArray[i2 * 4 + 1], fArray2[i2 * 4 + 1]), new Point2f(fArray[i2 * 4 + 2], fArray2[i2 * 4 + 2]), new Point2f(fArray[i2 * 4 + 3], fArray2[i2 * 4 + 3]));
                function2fArray[i2] = cubicBezierCurve2f;
            }
        }
        return new PiecewiseFunction2f(function2fArray);
    }

    private static PiecewiseFunction1f getYRotation(float[] fArray) {
        Function1f[] function1fArray = new EasingFunction[1];
        if (fArray != null && fArray.length > 0 && fArray.length % 2 == 0) {
            function1fArray = new EasingFunction[fArray.length / 2];
            for (int i2 = 0; i2 < function1fArray.length; ++i2) {
                function1fArray[i2] = new EasingFunction(0, 0, fArray[i2 * 2], fArray[i2 * 2 + 1]);
            }
        } else {
            function1fArray[0] = new EasingFunction(0, 0, 0.0f, 0.0f);
        }
        return new PiecewiseFunction1f(function1fArray);
    }

    public static void createOutlineCustom(float[] fArray, float[] fArray2, float[] fArray3, float f2, float f3, float f4, float f5, boolean bl, int n, int n2) {
        PiecewiseFunction2f piecewiseFunction2f = FlowListOutlineDefinition.getShape(fArray, fArray2);
        PiecewiseFunction1f piecewiseFunction1f = FlowListOutlineDefinition.getYRotation(fArray3);
        FlowListOutlineDefinition.OUTLINE_DEFINITIONS[13] = new FlowListOutlineDefinition(piecewiseFunction2f, piecewiseFunction1f, f2, f3, f4, f5, bl, n, n2, 0);
    }

    static {
        OUTLINE_SCROLLING = new int[]{0, 1, 2};
        OUTLINE_DEFINITION_CIRCLE = new FlowListOutlineDefinition(CubicBezierCurve2f.NORMALIZED_CIRCLE, new EasingFunction(0, 0, 0.0f, 0.0f), 63, 32959, 1.0f, -842216387, false, 0);
        OUTLINE_DEFINITION_PARABOLA = new FlowListOutlineDefinition(CubicBezierCurve2f.PARABOLA, new EasingFunction(0, 0, 0.0f, 0.0f), 63, 49342, 1.0f, 1.0f, false, 0);
        OUTLINE_DEFINITION_COVERFLOW = new FlowListOutlineDefinition(new PiecewiseFunction2f(new Function2f[]{new CubicBezierCurve2f(new Point2f(53440, 192), new Point2f(49344, 1718019775), new Point2f(45248, -842216257), new Point2f(41152, 0x3333B3BF)), new CubicBezierCurve2f(new Point2f(41152, 0x3333B3BF), new Point2f(37056, -1701209665), new Point2f(32960, 32959), new Point2f(24768, -842249025)), new CubicBezierCurve2f(new Point2f(24768, -842249025), new Point2f(16576, -1701242433), new Point2f(8384, -842216258), new Point2f(192, -842249026)), new CubicBezierCurve2f(new Point2f(192, -842249026), new Point2f(0.0f, 0.0f), new Point2f(0.0f, 0.0f), new Point2f(2.0f, -842249026)), new CubicBezierCurve2f(new Point2f(2.0f, -842249026), new Point2f(8256, -842216258), new Point2f(16448, -1701242433), new Point2f(24640, -842249025)), new CubicBezierCurve2f(new Point2f(24640, -842249025), new Point2f(32832, 32959), new Point2f(36928, -1701209665), new Point2f(41024, 0x3333B3BF)), new CubicBezierCurve2f(new Point2f(41024, 0x3333B3BF), new Point2f(45120, -842216257), new Point2f(49216, 1718019775), new Point2f(53312, 192))}), new PiecewiseFunction1f(new Function1f[]{new EasingFunction(1, 0, 41026, 38466), new EasingFunction(1, 0, 38466, 35906), new EasingFunction(1, 0, 35906, 33346), new EasingFunction(1, 0, 33346, 33474), new EasingFunction(1, 0, 33474, 36034), new EasingFunction(1, 0, 36034, 38594), new EasingFunction(1, 0, 38594, 41154)}), 63, 0.0f, 1.0f, 1.0f, false, 0);
        OUTLINE_DEFINITION_LINEAR = new FlowListOutlineDefinition(new PiecewiseFunction2f(new Function2f[]{new CubicBezierCurve2f(new Point2f(24768, 32959), new Point2f(-2048183872, 32959), new Point2f(-842261312, 32959), new Point2f(346949568, 32959)), new CubicBezierCurve2f(new Point2f(346949568, 32959), new Point2f(181920703, 32959), new Point2f(-1701201473, 32959), new Point2f(693931967, 32959)), new CubicBezierCurve2f(new Point2f(693931967, 32959), new Point2f(-842249025, 32959), new Point2f(-1701209666, 32959), new Point2f(0.0f, 0.0f)), new CubicBezierCurve2f(new Point2f(0.0f, 0.0f), new Point2f(-1701209794, 32959), new Point2f(-842249153, 32959), new Point2f(693931839, 32959)), new CubicBezierCurve2f(new Point2f(693931839, 32959), new Point2f(-1701201601, 32959), new Point2f(181920575, 32959), new Point2f(346949440, 32959)), new CubicBezierCurve2f(new Point2f(346949440, 32959), new Point2f(-842261440, 32959), new Point2f(-2048184000, 32959), new Point2f(24640, 32959))}), new EasingFunction(0, 0, 0.0f, 0.0f), 63, 0.0f, 49215, 1.0f, true, 0);
        OUTLINE_DEFINITION_CUSTOM = new FlowListOutlineDefinition(new PiecewiseFunction2f(new Function2f[]{new CubicBezierCurve2f(new Point2f(24768, 32959), new Point2f(-2048183872, 32959), new Point2f(-842261312, 32959), new Point2f(346949568, 32959)), new CubicBezierCurve2f(new Point2f(346949568, 32959), new Point2f(181920703, 32959), new Point2f(-1701201473, 32959), new Point2f(693931967, 32959)), new CubicBezierCurve2f(new Point2f(693931967, 32959), new Point2f(-842249025, 32959), new Point2f(-1701209666, 32959), new Point2f(0.0f, 0.0f)), new CubicBezierCurve2f(new Point2f(0.0f, 0.0f), new Point2f(-1701209794, 32959), new Point2f(-842249153, 32959), new Point2f(693931839, 32959)), new CubicBezierCurve2f(new Point2f(693931839, 32959), new Point2f(-1701201601, 32959), new Point2f(181920575, 32959), new Point2f(346949440, 32959)), new CubicBezierCurve2f(new Point2f(346949440, 32959), new Point2f(-842261440, 32959), new Point2f(-2048184000, 32959), new Point2f(24640, 32959))}), new EasingFunction(0, 0, 0.0f, 0.0f), 63, 0.0f, 49215, 1.0f, true, 0);
        OUTLINE_DEFINITION_COVER_FLOW_ACTIVE_DISPLACED_9_2 = new FlowListOutlineDefinition(new PiecewiseFunction2f(new Function2f[]{new CubicBezierCurve2f(new Point2f(-1482276928, 692883647), new Point2f(-36820288, -282563137), new Point2f(1495471296, 617368255), new Point2f(1089861055, -1261228865)), new CubicBezierCurve2f(new Point2f(1089861055, -1261228865), new Point2f(-125180225, 1767056319), new Point2f(-2070817089, -286648129), new Point2f(-2028287553, 1621758143)), new CubicBezierCurve2f(new Point2f(-2028287553, 1621758143), new Point2f(-297223233, -1926886721), new Point2f(-827413313, 1146093759), new Point2f(-1081303105, 207091390)), new CubicBezierCurve2f(new Point2f(-1081303105, 207091390), new Point2f(-1335192897, -1827803970), new Point2f(254051519, -301604930), new Point2f(-33329473, 1941755070)), new CubicBezierCurve2f(new Point2f(-33329473, 1941755070), new Point2f(-507554881, -126694722), new Point2f(-1032111681, 2116665534), new Point2f(-1539891265, 98612670)), new CubicBezierCurve2f(new Point2f(-1539891265, 98612670), new Point2f(-2030893889, -1969837122), new Point2f(-832645698, 273523134), new Point2f(-1831427906, -1778149442)), new CubicBezierCurve2f(new Point2f(-1831427906, -1778149442), new Point2f(-859026242, -858993475), new Point2f(-859026242, -858993475), new Point2f(0.0f, 0.0f)), new CubicBezierCurve2f(new Point2f(0.0f, 0.0f), new Point2f(-859026370, 0.0f), new Point2f(-858993602, -858993475), new Point2f(63, -1717986882)), new CubicBezierCurve2f(new Point2f(63, -1717986882), new Point2f(1891653951, -850808386), new Point2f(-1328903617, 1916846526), new Point2f(-1788042433, -962541634))}), new PiecewiseFunction1f(new Function1f[]{new EasingFunction(1, 0, 3138, 3138), new EasingFunction(1, 0, 3138, 3138), new EasingFunction(1, 0, 3138, 3138), new EasingFunction(1, 0, 3138, 3138), new EasingFunction(1, 0, 3138, 3138), new EasingFunction(1, 0, 3138, 3138), new EasingFunction(1, 0, 3138, 0.0f), new EasingFunction(1, 0, 0.0f, 3266), new EasingFunction(1, 0, 3266, 3266)}), 1914455871, 0.0f, 49215, 1.0f, true, 0);
        OUTLINE_DEFINITION_COVER_FLOW_ACTIVE_DISPLACED = new FlowListOutlineDefinition(new PiecewiseFunction2f(new Function2f[]{new CubicBezierCurve2f(new Point2f(-842240832, 0x3333B3BF), new Point2f(-1239852608, -2105828929), new Point2f(1460808128, 218461119), new Point2f(468128192, -784446017)), new CubicBezierCurve2f(new Point2f(468128192, -784446017), new Point2f(-1214842177, -1938279489), new Point2f(-2075601985, -1400628801), new Point2f(-2136620865, 279120831)), new CubicBezierCurve2f(new Point2f(-2136620865, 279120831), new Point2f(1921233855, 1400768191), new Point2f(1015720895, 1558379966), new Point2f(761831103, -510069826)), new CubicBezierCurve2f(new Point2f(761831103, -510069826), new Point2f(491164095, 1750067646), new Point2f(254051519, -301604930), new Point2f(-16552257, 1941755070)), new CubicBezierCurve2f(new Point2f(-16552257, 1941755070), new Point2f(-507554881, -126694722), new Point2f(-1015334465, 2133442750), new Point2f(-1539891265, 98612670)), new CubicBezierCurve2f(new Point2f(-1539891265, 98612670), new Point2f(-2030893889, -1969837122), new Point2f(-832645698, 273523134), new Point2f(-1831427906, -1778149442)), new CubicBezierCurve2f(new Point2f(-1831427906, -1778149442), new Point2f(-842249026, -842216259), new Point2f(-842249026, -842216259), new Point2f(0.0f, 0.0f)), new CubicBezierCurve2f(new Point2f(0.0f, 0.0f), new Point2f(-842249154, 0.0f), new Point2f(-842216386, -842216259), new Point2f(63, -1701209666)), new CubicBezierCurve2f(new Point2f(63, -1701209666), new Point2f(1908431167, -850808386), new Point2f(-1328903617, 1916846526), new Point2f(-1788042433, -962541634))}), new PiecewiseFunction1f(new Function1f[]{new EasingFunction(1, 0, 8258, 8258), new EasingFunction(1, 0, 8258, 8258), new EasingFunction(1, 0, 8258, 8258), new EasingFunction(1, 0, 8258, 8258), new EasingFunction(1, 0, 8258, 8258), new EasingFunction(1, 0, 8258, 8258), new EasingFunction(1, 0, 8258, 0.0f), new EasingFunction(1, 0, 0.0f, 8386), new EasingFunction(1, 0, 8386, 8386)}), 1914455871, 0.0f, 49215, 1.0f, true, 0);
        OUTLINE_DEFINITION_COVER_STACK_STAGGERED = new FlowListOutlineDefinition(new PiecewiseFunction2f(new Function2f[]{new CubicBezierCurve2f(new Point2f(0.0f, -1371037249), new Point2f(0.0f, -1701209665), new Point2f(0.0f, -2048159297), new Point2f(0.0f, 1899858623)), new CubicBezierCurve2f(new Point2f(0.0f, 1899858623), new Point2f(0.0f, 1552908991), new Point2f(0.0f, -1883081281), new Point2f(0.0f, 0x666666BF)), new CubicBezierCurve2f(new Point2f(0.0f, 0x666666BF), new Point2f(0.0f, 1024087999), new Point2f(0.0f, 346965951), new Point2f(0.0f, -330221377)), new CubicBezierCurve2f(new Point2f(0.0f, -330221377), new Point2f(0.0f, -1007343425), new Point2f(0.0f, -1701242433), new Point2f(0.0f, 1899825855)), new CubicBezierCurve2f(new Point2f(0.0f, 1899825855), new Point2f(0.0f, -1883048514), new Point2f(0.0f, 1024120766), new Point2f(0.0f, -330188610)), new CubicBezierCurve2f(new Point2f(0.0f, -330188610), new Point2f(0.0f, -1701209666), new Point2f(0.0f, -1883081282), new Point2f(0.0f, -330221378)), new CubicBezierCurve2f(new Point2f(0.0f, -330221378), new Point2f(0.0f, -1883048515), new Point2f(0.0f, -1883081283), new Point2f(0.0f, 0.0f)), new CubicBezierCurve2f(new Point2f(0.0f, 0.0f), new Point2f(0.0f, -1701209794), new Point2f(-1701242561, -1701209794), new Point2f(0x3333B33F, -1701209794)), new CubicBezierCurve2f(new Point2f(0x3333B33F, -1701209794), new Point2f(49215, -1701209794), new Point2f(-842216385, -1701209794), new Point2f(-1701193409, -1701209794))}), new EasingFunction(0, 0, 0.0f, 0.0f), 1914455871, 0.0f, 49215, 1.0f, true, 8);
        OUTLINE_DEFINITION_COVER_STACK = new FlowListOutlineDefinition(new PiecewiseFunction2f(new Function2f[]{new CubicBezierCurve2f(new Point2f(0.0f, 1024087999), new Point2f(0.0f, -842249025), new Point2f(0.0f, 1552892607), new Point2f(0.0f, -330221377)), new CubicBezierCurve2f(new Point2f(0.0f, -330221377), new Point2f(0.0f, 2064920255), new Point2f(0.0f, 181871551), new Point2f(0.0f, -1701242433)), new CubicBezierCurve2f(new Point2f(0.0f, -1701242433), new Point2f(0.0f, 693899199), new Point2f(0.0f, -1205992001), new Point2f(0.0f, -1883048514)), new CubicBezierCurve2f(new Point2f(0.0f, -1883048514), new Point2f(0.0f, -1371020866), new Point2f(0.0f, -842216258), new Point2f(0.0f, -330188610)), new CubicBezierCurve2f(new Point2f(0.0f, -330188610), new Point2f(0.0f, 181904318), new Point2f(0.0f, 693931966), new Point2f(0.0f, -1883081282)), new CubicBezierCurve2f(new Point2f(0.0f, -1883081282), new Point2f(0.0f, -842249026), new Point2f(0.0f, 181871550), new Point2f(0.0f, -1883048515)), new CubicBezierCurve2f(new Point2f(0.0f, -1883048515), new Point2f(0.0f, 181904317), new Point2f(0.0f, 181871549), new Point2f(0.0f, 0.0f)), new CubicBezierCurve2f(new Point2f(0.0f, 0.0f), new Point2f(0.0f, -1701209794), new Point2f(0x6666663F, -1701209794), new Point2f(0x3333B33F, -1701209794)), new CubicBezierCurve2f(new Point2f(0x3333B33F, -1701209794), new Point2f(49215, -1701209794), new Point2f(-842216385, -1701209794), new Point2f(-1701193409, -1701209794))}), new EasingFunction(0, 0, 0.0f, 0.0f), 1914455871, 0.0f, 49215, 1.0f, true, 1);
        OUTLINE_DEFINITION_VERTICAL = new FlowListOutlineDefinition(new PiecewiseFunction2f(new Function2f[]{new CubicBezierCurve2f(new Point2f(0.0f, 49343), new Point2f(0.0f, 191), new Point2f(0.0f, 63), new Point2f(0.0f, 49215))}), new EasingFunction(0, 0, 0.0f, 0.0f), 63, 0.0f, 1.0f, 1.0f, false, 0, 0, 1);
        OUTLINE_DEFINITION_VERTICAL_LEFT = new FlowListOutlineDefinition(new PiecewiseFunction2f(new Function2f[]{new CubicBezierCurve2f(new Point2f(-842249027, 63), new Point2f(-842249155, 191), new Point2f(-1701242562, 49343), new Point2f(32830, 8384))}), new EasingFunction(0, 0, 0.0f, 0.0f), -1414911426, 0.0f, 63, 1.0f, false, 0, 1, 1);
        OUTLINE_DEFINITION_VERTICAL_RIGHT = new FlowListOutlineDefinition(new PiecewiseFunction2f(new Function2f[]{new CubicBezierCurve2f(new Point2f(-842249155, 63), new Point2f(-842249027, 191), new Point2f(-1701242434, 49343), new Point2f(32958, 8384))}), new EasingFunction(0, 0, 0.0f, 0.0f), -1414911426, 0.0f, 63, 1.0f, false, 0, 1, 1);
        OUTLINE_DEFINITION_COVER_FLOW_SEAT = new FlowListOutlineDefinition(new PiecewiseFunction2f(new Function2f[]{new CubicBezierCurve2f(new Point2f(-181912384, -1718019649), new Point2f(-842257216, -1718019649), new Point2f(-1536156224, -1718019649), new Point2f(2064912064, -1718019649)), new CubicBezierCurve2f(new Point2f(2064912064, -1718019649), new Point2f(-1552876097, -1718019649), new Point2f(1387847359, -1718019649), new Point2f(49343, -1718019649)), new CubicBezierCurve2f(new Point2f(49343, -1718019649), new Point2f(0x3333B3BF, 693899199), new Point2f(1718003391, -1205992001), new Point2f(-1717986881, -1883048514)), new CubicBezierCurve2f(new Point2f(-1717986881, -1883048514), new Point2f(-842232641, -1371020866), new Point2f(32959, -858993474), new Point2f(0x666666BF, -346965826)), new CubicBezierCurve2f(new Point2f(0x666666BF, -346965826), new Point2f(-859026241, 181904318), new Point2f(0x333333BF, 693931966), new Point2f(-1718019649, -1883081282)), new CubicBezierCurve2f(new Point2f(-1718019649, -1883081282), new Point2f(191, -859026242), new Point2f(-858993474, 181871550), new Point2f(-1717986882, -1883048515)), new CubicBezierCurve2f(new Point2f(-1717986882, -1883048515), new Point2f(-859026242, 181904317), new Point2f(-858993475, 181871549), new Point2f(0.0f, 0.0f)), new CubicBezierCurve2f(new Point2f(0.0f, 0.0f), new Point2f(953566526, 0.0f), new Point2f(-2108569282, 0.0f), new Point2f(-512093121, 0.0f)), new CubicBezierCurve2f(new Point2f(-512093121, 0.0f), new Point2f(-1371053761, 0.0f), new Point2f(-842232769, 0.0f), new Point2f(1718003263, 0.0f))}), new PiecewiseFunction1f(new Function1f[]{new EasingFunction(0, 0, 0.0f, 0.0f)}), 1914455871, 0.0f, 49215, 1.0f, true, 0);
        OUTLINE_DEFINITION_COVER_STACK_APPROXIMATED_SEAT = new FlowListOutlineDefinition(new PiecewiseFunction2f(new Function2f[]{new CubicBezierCurve2f(new Point2f(0.0f, 1024087999), new Point2f(0.0f, -859026241), new Point2f(0.0f, 1552892607), new Point2f(0.0f, -346998593)), new CubicBezierCurve2f(new Point2f(0.0f, -346998593), new Point2f(0.0f, 2064920255), new Point2f(0.0f, 181871551), new Point2f(0.0f, -1718019649)), new CubicBezierCurve2f(new Point2f(0.0f, -1718019649), new Point2f(0.0f, 693899199), new Point2f(0.0f, -1205992001), new Point2f(0.0f, -1883048514)), new CubicBezierCurve2f(new Point2f(0.0f, -1883048514), new Point2f(0.0f, -1371020866), new Point2f(0.0f, -858993474), new Point2f(0.0f, -346965826)), new CubicBezierCurve2f(new Point2f(0.0f, -346965826), new Point2f(0.0f, 181904318), new Point2f(0.0f, 693931966), new Point2f(0.0f, -1883081282)), new CubicBezierCurve2f(new Point2f(0.0f, -1883081282), new Point2f(0.0f, -859026242), new Point2f(0.0f, 181871550), new Point2f(0.0f, -1883048515)), new CubicBezierCurve2f(new Point2f(0.0f, -1883048515), new Point2f(0.0f, 181904317), new Point2f(0.0f, 181871549), new Point2f(0.0f, 0.0f)), new CubicBezierCurve2f(new Point2f(0.0f, 0.0f), new Point2f(953566526, 0.0f), new Point2f(-2108569282, 0.0f), new Point2f(-512093121, 0.0f)), new CubicBezierCurve2f(new Point2f(-512093121, 0.0f), new Point2f(-1371053761, 0.0f), new Point2f(-842232769, 0.0f), new Point2f(1718003263, 0.0f))}), new EasingFunction(0, 0, 0.0f, 0.0f), 1914455871, 0.0f, 49215, 1.0f, true, 8);
        OUTLINE_DEFINITION_COVER_STACK_SEAT = new FlowListOutlineDefinition(new PiecewiseFunction2f(new Function2f[]{new CubicBezierCurve2f(new Point2f(693931838, 1024087999), new Point2f(-1205959362, -859026241), new Point2f(193494334, 193479359), new Point2f(-1883081410, -346998593)), new CubicBezierCurve2f(new Point2f(-1883081410, -346998593), new Point2f(-1371053762, 2064920255), new Point2f(358569278, 432087999), new Point2f(-859026370, -1718019649)), new CubicBezierCurve2f(new Point2f(-859026370, -1718019649), new Point2f(-346998722, 693899199), new Point2f(-346998722, -1205992001), new Point2f(181871422, -1883048514)), new CubicBezierCurve2f(new Point2f(181871422, -1883048514), new Point2f(693899070, -1371020866), new Point2f(693899070, -858993474), new Point2f(-1883048643, -346965826)), new CubicBezierCurve2f(new Point2f(-1883048643, -346965826), new Point2f(-858993603, 181904318), new Point2f(-858993603, 693931966), new Point2f(181904189, -1883081282)), new CubicBezierCurve2f(new Point2f(181904189, -1883081282), new Point2f(-1883081411, -859026242), new Point2f(-1883081411, 181871550), new Point2f(181871421, -1883048515)), new CubicBezierCurve2f(new Point2f(181871421, -1883048515), new Point2f(181904188, 181904317), new Point2f(181904188, 181871549), new Point2f(0.0f, 0.0f)), new CubicBezierCurve2f(new Point2f(0.0f, 0.0f), new Point2f(-1717987010, 0.0f), new Point2f(-1718019777, 0.0f), new Point2f(0x6666663F, 0.0f)), new CubicBezierCurve2f(new Point2f(0x6666663F, 0.0f), new Point2f(-1717987009, 0.0f), new Point2f(49215, 0.0f), new Point2f(1718019647, 0.0f))}), new EasingFunction(0, 0, 0.0f, 0.0f), 1914455871, 0.0f, 49215, 1.0f, true, 1);
        OUTLINE_DEFINITIONS = new FlowListOutlineDefinition[]{OUTLINE_DEFINITION_CIRCLE, OUTLINE_DEFINITION_PARABOLA, OUTLINE_DEFINITION_COVERFLOW, OUTLINE_DEFINITION_LINEAR, OUTLINE_DEFINITION_COVER_FLOW_ACTIVE_DISPLACED, OUTLINE_DEFINITION_COVER_STACK_STAGGERED, OUTLINE_DEFINITION_COVER_STACK, OUTLINE_DEFINITION_VERTICAL, OUTLINE_DEFINITION_VERTICAL_LEFT, OUTLINE_DEFINITION_VERTICAL_RIGHT, OUTLINE_DEFINITION_COVER_FLOW_SEAT, OUTLINE_DEFINITION_COVER_STACK_APPROXIMATED_SEAT, OUTLINE_DEFINITION_COVER_STACK_SEAT, OUTLINE_DEFINITION_CUSTOM, OUTLINE_DEFINITION_COVER_FLOW_ACTIVE_DISPLACED_9_2};
    }
}

