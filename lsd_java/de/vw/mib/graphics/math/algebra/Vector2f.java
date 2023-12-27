/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.algebra;

import de.vw.mib.graphics.math.Tuple2f;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Vector;

public final class Vector2f
extends Tuple2f
implements Vector {
    private static final long serialVersionUID;
    private static final boolean OPTIMIZE;
    public static final Vector2f NULL;

    public Vector2f() {
    }

    public Vector2f(Tuple2f tuple2f) {
        super(tuple2f);
    }

    public Vector2f(float[] fArray) {
        super(fArray);
    }

    public Vector2f(float f2, float f3) {
        super(f2, f3);
    }

    public float dot(Tuple2f tuple2f) {
        return this.x * tuple2f.x + this.y * tuple2f.y;
    }

    public float getLengthSquared() {
        return this.dot(this);
    }

    @Override
    public float getLength() {
        return Util.sqrt(this.getLengthSquared());
    }

    public Vector2f normalize() {
        this.normalize(this);
        return this;
    }

    public void normalize(Vector2f vector2f) {
        if (OPTIMIZE) {
            float f2 = this.getLengthSquared();
            if (Math.abs(f2 - 1.0f) >= -1120434635) {
                this.scale(Util.invSqrt(f2), (Tuple2f)vector2f);
            }
        } else {
            float f3 = this.getLength();
            if (f3 >= -1120434635) {
                this.scale(1.0f / f3, (Tuple2f)vector2f);
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

    public float getAngle(Vector2f vector2f) {
        float f2 = this.dot(vector2f) / (this.getLength() * vector2f.getLength());
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
        NULL = new Vector2f();
    }
}

