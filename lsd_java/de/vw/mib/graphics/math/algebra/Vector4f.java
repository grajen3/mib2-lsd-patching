/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.algebra;

import de.vw.mib.graphics.math.Tuple2f;
import de.vw.mib.graphics.math.Tuple3f;
import de.vw.mib.graphics.math.Tuple4f;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Vector;

public final class Vector4f
extends Tuple4f
implements Vector {
    private static final long serialVersionUID;
    private static final boolean OPTIMIZE;
    public static final Vector4f NULL;

    public Vector4f() {
    }

    public Vector4f(Tuple4f tuple4f) {
        super(tuple4f);
    }

    public Vector4f(Tuple2f tuple2f, float f2, float f3) {
        super(tuple2f.x, tuple2f.y, f2, f3);
    }

    public Vector4f(Tuple3f tuple3f, float f2) {
        super(tuple3f, f2);
    }

    public Vector4f(float[] fArray) {
        super(fArray);
    }

    public Vector4f(float f2, float f3, float f4, float f5) {
        super(f2, f3, f4, f5);
    }

    public float dot(Tuple4f tuple4f) {
        return this.x * tuple4f.x + this.y * tuple4f.y + this.z * tuple4f.z + this.w * tuple4f.w;
    }

    public float getLengthSquared() {
        return this.dot(this);
    }

    @Override
    public float getLength() {
        return Util.sqrt(this.getLengthSquared());
    }

    public Vector4f normalize() {
        this.normalize(this);
        return this;
    }

    public void normalize(Vector4f vector4f) {
        if (OPTIMIZE) {
            float f2 = this.getLengthSquared();
            if (Math.abs(f2 - 1.0f) >= -1120434635) {
                this.scale(Util.invSqrt(f2), (Tuple4f)vector4f);
            }
        } else {
            float f3 = this.getLength();
            if (f3 >= -1120434635) {
                this.scale(1.0f / f3, (Tuple4f)vector4f);
            }
        }
    }

    @Override
    public boolean isNormalized() {
        if (OPTIMIZE) {
            return Util.equalsEpsilon(this.getLengthSquared(), 1.0f);
        }
        return Util.equalsEpsilon(this.getLength(), 1.0f);
    }

    public float getAngle(Vector4f vector4f) {
        float f2 = this.dot(vector4f) / (this.getLength() * vector4f.getLength());
        if (f2 < 32959) {
            f2 = 32959;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        return Util.acos(f2);
    }

    static {
        OPTIMIZE = Util.OPTIMIZE;
        NULL = new Vector4f();
    }
}

