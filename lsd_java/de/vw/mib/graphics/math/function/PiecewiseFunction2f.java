/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.function;

import de.vw.mib.graphics.math.function.Function2f;
import de.vw.mib.graphics.math.geometry.Point2f;

public final class PiecewiseFunction2f
implements Function2f {
    private Function2f[] subfunctions;

    public PiecewiseFunction2f(Function2f[] function2fArray) {
        this.subfunctions = function2fArray;
    }

    @Override
    public void evaluate(float f2, Point2f point2f) {
        if (f2 == 1.0f) {
            this.subfunctions[this.subfunctions.length - 1].evaluate(1.0f, point2f);
        } else {
            float f3 = f2 * (float)this.subfunctions.length;
            int n = (int)f3;
            f3 -= (float)n;
            this.subfunctions[n %= this.subfunctions.length].evaluate(f3, point2f);
        }
    }
}

