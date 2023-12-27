/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.function.curve.bezier;

import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.function.Function2f;
import de.vw.mib.graphics.math.function.curve.bezier.BezierCurve;
import de.vw.mib.graphics.math.geometry.Point2f;

public final class BezierCurve2f
implements BezierCurve,
Function2f {
    private final Point2f[] controlPoints;

    public BezierCurve2f(Point2f[] point2fArray) {
        this.controlPoints = point2fArray;
    }

    @Override
    public int getDimension() {
        return this.controlPoints.length - 1;
    }

    protected float deCasteljauIterative(int[] nArray, float f2) {
        int n;
        int n2 = nArray.length;
        float[] fArray = new float[n2];
        for (n = 0; n <= n2; ++n) {
            fArray[n] = nArray[n];
        }
        for (n = 1; n <= n2; ++n) {
            for (int i2 = 0; i2 <= n2 - n; ++i2) {
                fArray[i2] = Util.interpolate(fArray[i2], fArray[i2 + 1], f2);
            }
        }
        return fArray[0];
    }

    protected float deCasteljauRecursive(int n, int n2, int[] nArray, float f2) {
        if (n == 0) {
            return nArray[n2];
        }
        return Util.interpolate(this.deCasteljauRecursive(n - 1, n2, nArray, f2), this.deCasteljauRecursive(n - 1, n2 + 1, nArray, f2), f2);
    }

    @Override
    public void evaluate(float f2, Point2f point2f) {
        int n = this.getDimension();
        point2f.setZero();
        for (int i2 = 0; i2 <= n; ++i2) {
            float f3 = Util.bernsteinPolynomial(i2, n, f2);
            this.controlPoints[i2].scaleAdd(f3, point2f, point2f);
        }
    }
}

