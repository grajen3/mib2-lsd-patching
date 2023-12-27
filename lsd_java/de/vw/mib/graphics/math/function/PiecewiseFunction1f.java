/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.function;

import de.vw.mib.graphics.math.function.Function1f;

public final class PiecewiseFunction1f
implements Function1f {
    private final Function1f[] subfunctions;

    public PiecewiseFunction1f(Function1f[] function1fArray) {
        this.subfunctions = function1fArray;
    }

    @Override
    public float evaluate(float f2) {
        float f3;
        if (f2 == 1.0f) {
            f3 = this.subfunctions[this.subfunctions.length - 1].evaluate(1.0f);
        } else {
            float f4 = f2 * (float)this.subfunctions.length;
            int n = (int)f4;
            f4 -= (float)n;
            f3 = this.subfunctions[n %= this.subfunctions.length].evaluate(f4);
        }
        return f3;
    }
}

