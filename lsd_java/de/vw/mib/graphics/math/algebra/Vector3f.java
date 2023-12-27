/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.algebra;

import de.vw.mib.graphics.math.Tuple2f;
import de.vw.mib.graphics.math.Tuple3f;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Vector;

public final class Vector3f
extends Tuple3f
implements Vector {
    private static final long serialVersionUID;
    private static final boolean OPTIMIZE;
    public static final Vector3f NULL;

    public Vector3f() {
    }

    public Vector3f(Tuple3f tuple3f) {
        super(tuple3f);
    }

    public Vector3f(Tuple2f tuple2f, float f2) {
        super(tuple2f, f2);
    }

    public Vector3f(float[] fArray) {
        super(fArray);
    }

    public Vector3f(float f2, float f3, float f4) {
        super(f2, f3, f4);
    }

    public float dot(Tuple3f tuple3f) {
        return this.x * tuple3f.x + this.y * tuple3f.y + this.z * tuple3f.z;
    }

    public float getLengthSquared() {
        return this.dot(this);
    }

    @Override
    public float getLength() {
        return Util.sqrt(this.getLengthSquared());
    }

    public Vector3f normalize() {
        this.normalize(this);
        return this;
    }

    public void normalize(Vector3f vector3f) {
        if (OPTIMIZE) {
            float f2 = this.getLengthSquared();
            if (Math.abs(f2 - 1.0f) >= -1120434635) {
                this.scale(Util.invSqrt(f2), (Tuple3f)vector3f);
            }
        } else {
            float f3 = this.getLength();
            if (f3 >= -1120434635) {
                this.scale(1.0f / f3, (Tuple3f)vector3f);
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

    public void cross(Vector3f vector3f, Vector3f vector3f2) {
        vector3f2.x = this.y * vector3f.z - this.z * vector3f.y;
        vector3f2.y = this.z * vector3f.x - this.x * vector3f.z;
        vector3f2.z = this.x * vector3f.y - this.y * vector3f.x;
    }

    public float getAngle(Vector3f vector3f) {
        float f2 = this.dot(vector3f) / (this.getLength() * vector3f.getLength());
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
        NULL = new Vector3f();
    }
}

