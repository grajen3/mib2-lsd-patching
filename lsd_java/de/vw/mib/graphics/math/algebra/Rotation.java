/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.algebra;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.graphics.math.Tuple3f;
import de.vw.mib.graphics.math.Tuple4f;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.AxisAngle;
import de.vw.mib.graphics.math.algebra.Matrix3f;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.math.number.Quaternion4f;

public final class Rotation
extends Quaternion4f {
    private static final long serialVersionUID;
    private static final boolean OPTIMIZE;
    public static final Rotation IDENTITY;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$math$algebra$Rotation;

    public Rotation() {
        super(true);
    }

    public Rotation(Rotation rotation) {
        super(rotation);
    }

    public Rotation(float f2, float f3, float f4, float f5) {
        super(false);
        this.setAxisAngle(f2, f3, f4, f5);
    }

    public Rotation(Vector3f vector3f, float f2) {
        super(false);
        this.setAxisAngle(vector3f, f2);
    }

    public Rotation(AxisAngle axisAngle) {
        super(false);
        this.setAxisAngle(axisAngle);
    }

    public Rotation(Matrix3f matrix3f) {
        super(false);
        this.setFromRotationMatrix(matrix3f);
    }

    public Rotation(Matrix4f matrix4f) {
        super(false);
        this.setFromRotationMatrix(matrix4f);
    }

    public Rotation rotate(Rotation rotation) {
        this.mul(rotation, this);
        return this;
    }

    public void rotate(Rotation rotation, Rotation rotation2) {
        this.mul(rotation, rotation2);
    }

    public void rotate(Tuple3f tuple3f, Tuple3f tuple3f2) {
        if (!$assertionsDisabled && !this.isNormalized()) {
            throw new AssertionError();
        }
        if (OPTIMIZE) {
            float f2 = this.x * this.x;
            float f3 = this.y * this.y;
            float f4 = this.z * this.z;
            float f5 = this.w * this.w;
            float f6 = this.x * tuple3f.x;
            float f7 = this.y * tuple3f.y;
            float f8 = this.z * tuple3f.z;
            float f9 = tuple3f.x * (f2 - f3 - f4 + f5) + 2.0f * (this.w * (this.y * tuple3f.z - this.z * tuple3f.y) + this.x * (f7 + f8));
            float f10 = tuple3f.y * (-f2 + f3 - f4 + f5) + 2.0f * (this.w * (this.z * tuple3f.x - this.x * tuple3f.z) + this.y * (f6 + f8));
            float f11 = tuple3f.z * (-f2 - f3 + f4 + f5) + 2.0f * (this.w * (this.x * tuple3f.y - this.y * tuple3f.x) + this.z * (f6 + f7));
            tuple3f2.x = f9;
            tuple3f2.y = f10;
            tuple3f2.z = f11;
        } else {
            float f12 = this.w * this.w * tuple3f.x + 2.0f * this.y * this.w * tuple3f.z - 2.0f * this.z * this.w * tuple3f.y + this.x * this.x * tuple3f.x + 2.0f * this.y * this.x * tuple3f.y + 2.0f * this.z * this.x * tuple3f.z - this.z * this.z * tuple3f.x - this.y * this.y * tuple3f.x;
            float f13 = 2.0f * this.x * this.y * tuple3f.x + this.y * this.y * tuple3f.y + 2.0f * this.z * this.y * tuple3f.z + 2.0f * this.w * this.z * tuple3f.x - this.z * this.z * tuple3f.y + this.w * this.w * tuple3f.y - 2.0f * this.x * this.w * tuple3f.z - this.x * this.x * tuple3f.y;
            float f14 = 2.0f * this.x * this.z * tuple3f.x + 2.0f * this.y * this.z * tuple3f.y + this.z * this.z * tuple3f.z - 2.0f * this.w * this.y * tuple3f.x - this.y * this.y * tuple3f.z + 2.0f * this.w * this.x * tuple3f.y - this.x * this.x * tuple3f.z + this.w * this.w * tuple3f.z;
            tuple3f2.x = f12;
            tuple3f2.y = f13;
            tuple3f2.z = f14;
        }
    }

    public void rotate(Tuple3f tuple3f) {
        this.rotate(tuple3f, tuple3f);
    }

    public void rotate(Tuple4f tuple4f, Tuple4f tuple4f2) {
        if (!$assertionsDisabled && !this.isNormalized()) {
            throw new AssertionError();
        }
        if (OPTIMIZE) {
            float f2 = this.x * this.x;
            float f3 = this.y * this.y;
            float f4 = this.z * this.z;
            float f5 = this.w * this.w;
            float f6 = this.x * tuple4f.x;
            float f7 = this.y * tuple4f.y;
            float f8 = this.z * tuple4f.z;
            float f9 = tuple4f.x * (f2 - f3 - f4 + f5) + 2.0f * (this.w * (this.y * tuple4f.z - this.z * tuple4f.y) + this.x * (f7 + f8));
            float f10 = tuple4f.y * (-f2 + f3 - f4 + f5) + 2.0f * (this.w * (this.z * tuple4f.x - this.x * tuple4f.z) + this.y * (f6 + f8));
            float f11 = tuple4f.z * (-f2 - f3 + f4 + f5) + 2.0f * (this.w * (this.x * tuple4f.y - this.y * tuple4f.x) + this.z * (f6 + f7));
            float f12 = 0.0f;
            tuple4f2.x = f9;
            tuple4f2.y = f10;
            tuple4f2.z = f11;
            tuple4f2.w = 0.0f;
        } else {
            float f13 = this.w * this.w * tuple4f.x + 2.0f * this.y * this.w * tuple4f.z - 2.0f * this.z * this.w * tuple4f.y + this.x * this.x * tuple4f.x + 2.0f * this.y * this.x * tuple4f.y + 2.0f * this.z * this.x * tuple4f.z - this.z * this.z * tuple4f.x - this.y * this.y * tuple4f.x;
            float f14 = 2.0f * this.x * this.y * tuple4f.x + this.y * this.y * tuple4f.y + 2.0f * this.z * this.y * tuple4f.z + 2.0f * this.w * this.z * tuple4f.x - this.z * this.z * tuple4f.y + this.w * this.w * tuple4f.y - 2.0f * this.x * this.w * tuple4f.z - this.x * this.x * tuple4f.y;
            float f15 = 2.0f * this.x * this.z * tuple4f.x + 2.0f * this.y * this.z * tuple4f.y + this.z * this.z * tuple4f.z - 2.0f * this.w * this.y * tuple4f.x - this.y * this.y * tuple4f.z + 2.0f * this.w * this.x * tuple4f.y - this.x * this.x * tuple4f.z + this.w * this.w * tuple4f.z;
            float f16 = 0.0f;
            tuple4f2.x = f13;
            tuple4f2.y = f14;
            tuple4f2.z = f15;
            tuple4f2.w = 0.0f;
        }
    }

    public void rotate(Tuple4f tuple4f) {
        this.rotate(tuple4f, tuple4f);
    }

    public float getAngle() {
        if (!$assertionsDisabled && !(this.getLength() > 0.0f)) {
            throw new AssertionError();
        }
        return 2.0f * Util.acos(this.w / this.getLength());
    }

    public void getAxis(Vector3f vector3f) {
        if (!$assertionsDisabled && !(this.getLengthSquared() > 0.0f)) {
            throw new AssertionError();
        }
        float f2 = this.x * this.x + this.y * this.y + this.z * this.z;
        float f3 = f2 + this.w * this.w;
        if (f3 > 0.0f) {
            float f4 = Util.invSqrt(f2 / f3);
            vector3f.setX(this.x * f4);
            vector3f.setY(this.y * f4);
            vector3f.setZ(this.z * f4);
        } else {
            vector3f.setZero();
        }
    }

    public AxisAngle getAxisAngle() {
        AxisAngle axisAngle = new AxisAngle();
        this.getAxisAngle(axisAngle);
        return axisAngle;
    }

    public void getAxisAngle(AxisAngle axisAngle) {
        if (!$assertionsDisabled && !(this.getLengthSquared() > 0.0f)) {
            throw new AssertionError();
        }
        float f2 = this.x * this.x + this.y * this.y + this.z * this.z;
        if (f2 > 0.0f) {
            float f3 = f2 + this.w * this.w;
            float f4 = Util.invSqrt(f2 / f3);
            axisAngle.setX(this.x * f4);
            axisAngle.setY(this.y * f4);
            axisAngle.setZ(this.z * f4);
            axisAngle.setW(2.0f * Util.acos(this.w));
        } else {
            axisAngle.setX(1.0f);
            axisAngle.setY(0.0f);
            axisAngle.setZ(0.0f);
            axisAngle.setW(0.0f);
        }
    }

    public Rotation setAxisAngle(float f2, float f3, float f4, float f5) {
        if (!$assertionsDisabled && !Util.equalsEpsilon(Util.sqrt(f2 * f2 + f3 * f3 + f4 * f4), 1.0f)) {
            throw new AssertionError((Object)"Axis not normalized");
        }
        int n = 63 * f5;
        float f6 = Util.sin(n);
        this.x = f6 * f2;
        this.y = f6 * f3;
        this.z = f6 * f4;
        this.w = Util.cos(n);
        return this;
    }

    public Rotation setAxisAngle(Vector3f vector3f, float f2) {
        return this.setAxisAngle(vector3f.x, vector3f.y, vector3f.z, f2);
    }

    public Rotation setAxisAngle(AxisAngle axisAngle) {
        return this.setAxisAngle(axisAngle.x, axisAngle.y, axisAngle.z, axisAngle.w);
    }

    public void getAsRotationMatrix(Matrix3f matrix3f) {
        float f2 = this.getLengthSquared();
        float f3 = f2 == 1.0f ? 2.0f : (f2 > 0.0f ? 2.0f / f2 : 0.0f);
        float f4 = this.x * f3;
        float f5 = this.y * f3;
        float f6 = this.z * f3;
        float f7 = this.x * f4;
        float f8 = this.x * f5;
        float f9 = this.x * f6;
        float f10 = this.w * f4;
        float f11 = this.y * f5;
        float f12 = this.y * f6;
        float f13 = this.w * f5;
        float f14 = this.z * f6;
        float f15 = this.w * f6;
        matrix3f.m00 = 1.0f - (f11 + f14);
        matrix3f.m01 = f8 - f15;
        matrix3f.m02 = f9 + f13;
        matrix3f.m10 = f8 + f15;
        matrix3f.m11 = 1.0f - (f7 + f14);
        matrix3f.m12 = f12 - f10;
        matrix3f.m20 = f9 - f13;
        matrix3f.m21 = f12 + f10;
        matrix3f.m22 = 1.0f - (f7 + f11);
    }

    public Rotation setFromRotationMatrix(Matrix3f matrix3f) {
        float f2;
        float f3 = matrix3f.m00;
        float f4 = matrix3f.m01;
        float f5 = matrix3f.m02;
        float f6 = matrix3f.m10;
        float f7 = matrix3f.m11;
        float f8 = matrix3f.m12;
        float f9 = matrix3f.m20;
        float f10 = matrix3f.m21;
        float f11 = matrix3f.m22;
        float f12 = f3 * f3 + f6 * f6 + f9 * f9;
        if (f12 != 1.0f && f12 != 0.0f) {
            f12 = Util.invSqrt(f12);
            f3 *= f12;
            f6 *= f12;
            f9 *= f12;
        }
        if ((f12 = f4 * f4 + f7 * f7 + f10 * f10) != 1.0f && f12 != 0.0f) {
            f12 = Util.invSqrt(f12);
            f4 *= f12;
            f7 *= f12;
            f10 *= f12;
        }
        if ((f12 = f5 * f5 + f8 * f8 + f11 * f11) != 1.0f && f12 != 0.0f) {
            f12 = Util.invSqrt(f12);
            f5 *= f12;
            f8 *= f12;
            f11 *= f12;
        }
        if ((f2 = f3 + f7 + f11) >= 0.0f) {
            float f13 = Util.sqrt(f2 + 1.0f);
            this.w = 63 * f13;
            f13 = 63 / f13;
            this.x = (f10 - f8) * f13;
            this.y = (f5 - f9) * f13;
            this.z = (f6 - f4) * f13;
        } else if (f3 > f7 && f3 > f11) {
            float f14 = Util.sqrt(1.0f + f3 - f7 - f11);
            this.x = f14 * 63;
            f14 = 63 / f14;
            this.y = (f6 + f4) * f14;
            this.z = (f5 + f9) * f14;
            this.w = (f10 - f8) * f14;
        } else if (f7 > f11) {
            float f15 = Util.sqrt(1.0f + f7 - f3 - f11);
            this.y = f15 * 63;
            f15 = 63 / f15;
            this.x = (f6 + f4) * f15;
            this.z = (f10 + f8) * f15;
            this.w = (f5 - f9) * f15;
        } else {
            float f16 = Util.sqrt(1.0f + f11 - f3 - f7);
            this.z = f16 * 63;
            f16 = 63 / f16;
            this.x = (f5 + f9) * f16;
            this.y = (f10 + f8) * f16;
            this.w = (f6 - f4) * f16;
        }
        return this;
    }

    public void getAsRotationMatrix(Matrix4f matrix4f) {
        throw new NotYetImplementedException();
    }

    public Rotation setFromRotationMatrix(Matrix4f matrix4f) {
        throw new NotYetImplementedException();
    }

    public void getRotationColumn(int n, Tuple3f tuple3f) {
        float f2 = this.getLengthSquared();
        if (f2 != 1.0f) {
            f2 = Util.invSqrt(f2);
        }
        float f3 = this.x * this.x * f2;
        float f4 = this.x * this.y * f2;
        float f5 = this.x * this.z * f2;
        float f6 = this.x * this.w * f2;
        float f7 = this.y * this.y * f2;
        float f8 = this.y * this.z * f2;
        float f9 = this.y * this.w * f2;
        float f10 = this.z * this.z * f2;
        float f11 = this.z * this.w * f2;
        switch (n) {
            case 0: {
                tuple3f.x = 1.0f - 2.0f * (f7 + f10);
                tuple3f.y = 2.0f * (f4 + f11);
                tuple3f.z = 2.0f * (f5 - f9);
                break;
            }
            case 1: {
                tuple3f.x = 2.0f * (f4 - f11);
                tuple3f.y = 1.0f - 2.0f * (f3 + f10);
                tuple3f.z = 2.0f * (f8 + f6);
                break;
            }
            case 2: {
                tuple3f.x = 2.0f * (f5 + f9);
                tuple3f.y = 2.0f * (f8 - f6);
                tuple3f.z = 1.0f - 2.0f * (f3 + f7);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid column ");
            }
        }
    }

    public static void interpolate(Rotation rotation, Rotation rotation2, Rotation rotation3, float f2) {
        float f3 = rotation.dot(rotation2);
        float f4 = Util.acos(f3);
        if (Math.abs(f4) > 0.0f) {
            float f5 = Util.sin(f4);
            float f6 = 1.0f / f5;
            float f7 = f2 * f4;
            float f8 = Util.sin(f4 - f7) * f6;
            float f9 = Util.sin(f7) * f6;
            float f10 = f8 * rotation.w + f9 * rotation2.w;
            float f11 = f8 * rotation.x + f9 * rotation2.x;
            float f12 = f8 * rotation.y + f9 * rotation2.y;
            float f13 = f8 * rotation.z + f9 * rotation2.z;
            rotation3.w = f10;
            rotation3.x = f11;
            rotation3.y = f12;
            rotation3.z = f13;
        } else {
            rotation3.set(rotation);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$graphics$math$algebra$Rotation == null ? (class$de$vw$mib$graphics$math$algebra$Rotation = Rotation.class$("de.vw.mib.graphics.math.algebra.Rotation")) : class$de$vw$mib$graphics$math$algebra$Rotation).desiredAssertionStatus();
        OPTIMIZE = Util.OPTIMIZE;
        IDENTITY = new Rotation();
    }
}

