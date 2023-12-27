/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.algebra;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.math.Tuple2f;
import de.vw.mib.graphics.math.Tuple3f;
import de.vw.mib.graphics.math.Tuple4f;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.AbstractMatrix;
import de.vw.mib.graphics.math.algebra.Matrix;
import de.vw.mib.graphics.math.algebra.Matrix3f;
import de.vw.mib.graphics.math.algebra.SingularMatrixException;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.math.algebra.Vector4f;
import de.vw.mib.util.StringBuilder;

public final class Matrix4f
extends AbstractMatrix {
    private static final long serialVersionUID;
    private static final boolean OPTIMIZE;
    private static final boolean OPTIMIZE_EQUALS;
    private static final boolean OPTIMIZE_BYPASS;
    private static final boolean OPTIMIZE_SHORTCUT;
    private static HashCodeBuilder hcb;
    private static Matrix4f TEMPMAT4;
    private static Vector4f TEMPVEC4;
    public static final int DIMENSION;
    public static final Matrix4f IDENTITY;
    float m00;
    float m01;
    float m02;
    float m03;
    float m10;
    float m11;
    float m12;
    float m13;
    float m20;
    float m21;
    float m22;
    float m23;
    float m30;
    float m31;
    float m32;
    float m33;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$math$algebra$Matrix4f;

    public Matrix4f() {
        this(false);
    }

    public Matrix4f(boolean bl) {
        if (bl) {
            this.setIdentity();
        }
    }

    public Matrix4f(Matrix4f matrix4f) {
        this();
        this.m00 = matrix4f.m00;
        this.m01 = matrix4f.m01;
        this.m02 = matrix4f.m02;
        this.m03 = matrix4f.m03;
        this.m10 = matrix4f.m10;
        this.m11 = matrix4f.m11;
        this.m12 = matrix4f.m12;
        this.m13 = matrix4f.m13;
        this.m20 = matrix4f.m20;
        this.m21 = matrix4f.m21;
        this.m22 = matrix4f.m22;
        this.m23 = matrix4f.m23;
        this.m30 = matrix4f.m30;
        this.m31 = matrix4f.m31;
        this.m32 = matrix4f.m32;
        this.m33 = matrix4f.m33;
    }

    public Matrix4f(float[] fArray) {
        this();
        if (!$assertionsDisabled && fArray.length < 16) {
            throw new AssertionError((Object)"Argument too small");
        }
        this.m00 = fArray[0];
        this.m10 = fArray[1];
        this.m20 = fArray[2];
        this.m30 = fArray[3];
        this.m01 = fArray[4];
        this.m11 = fArray[5];
        this.m21 = fArray[6];
        this.m31 = fArray[7];
        this.m02 = fArray[8];
        this.m12 = fArray[9];
        this.m22 = fArray[10];
        this.m32 = fArray[11];
        this.m03 = fArray[12];
        this.m13 = fArray[13];
        this.m23 = fArray[14];
        this.m33 = fArray[15];
    }

    @Override
    public Object clone() {
        Matrix4f matrix4f = (Matrix4f)super.clone();
        return matrix4f;
    }

    public int hashCode() {
        if (hcb == null) {
            hcb = new HashCodeBuilder();
        }
        hcb.reset();
        hcb.append(this.m00);
        hcb.append(this.m01);
        hcb.append(this.m02);
        hcb.append(this.m03);
        hcb.append(this.m10);
        hcb.append(this.m11);
        hcb.append(this.m12);
        hcb.append(this.m13);
        hcb.append(this.m20);
        hcb.append(this.m21);
        hcb.append(this.m22);
        hcb.append(this.m23);
        hcb.append(this.m30);
        hcb.append(this.m31);
        hcb.append(this.m32);
        hcb.append(this.m33);
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            Matrix4f matrix4f = (Matrix4f)object;
            if (OPTIMIZE_EQUALS) {
                if (Util.IDENTITY_EQUALS) {
                    return this.m30 == matrix4f.m30 && this.m31 == matrix4f.m31 && this.m32 == matrix4f.m32 && this.m33 == matrix4f.m33 && this.m00 == matrix4f.m00 && this.m01 == matrix4f.m01 && this.m02 == matrix4f.m02 && this.m03 == matrix4f.m03 && this.m10 == matrix4f.m10 && this.m11 == matrix4f.m11 && this.m12 == matrix4f.m12 && this.m13 == matrix4f.m13 && this.m20 == matrix4f.m20 && this.m21 == matrix4f.m21 && this.m22 == matrix4f.m22 && this.m23 == matrix4f.m23;
                }
                if (Util.EXACT_EQUALS) {
                    return Float.compare(this.m30, matrix4f.m30) == 0 && Float.compare(this.m31, matrix4f.m31) == 0 && Float.compare(this.m32, matrix4f.m32) == 0 && Float.compare(this.m33, matrix4f.m33) == 0 && Float.compare(this.m00, matrix4f.m00) == 0 && Float.compare(this.m01, matrix4f.m01) == 0 && Float.compare(this.m02, matrix4f.m02) == 0 && Float.compare(this.m03, matrix4f.m03) == 0 && Float.compare(this.m10, matrix4f.m10) == 0 && Float.compare(this.m11, matrix4f.m11) == 0 && Float.compare(this.m12, matrix4f.m12) == 0 && Float.compare(this.m13, matrix4f.m13) == 0 && Float.compare(this.m20, matrix4f.m20) == 0 && Float.compare(this.m21, matrix4f.m21) == 0 && Float.compare(this.m22, matrix4f.m22) == 0 && Float.compare(this.m23, matrix4f.m23) == 0;
                }
                return Util.equalsEpsilon(this.m30, matrix4f.m30) && Util.equalsEpsilon(this.m31, matrix4f.m31) && Util.equalsEpsilon(this.m32, matrix4f.m32) && Util.equalsEpsilon(this.m33, matrix4f.m33) && Util.equalsEpsilon(this.m00, matrix4f.m00) && Util.equalsEpsilon(this.m01, matrix4f.m01) && Util.equalsEpsilon(this.m02, matrix4f.m02) && Util.equalsEpsilon(this.m03, matrix4f.m03) && Util.equalsEpsilon(this.m10, matrix4f.m10) && Util.equalsEpsilon(this.m11, matrix4f.m11) && Util.equalsEpsilon(this.m12, matrix4f.m12) && Util.equalsEpsilon(this.m13, matrix4f.m13) && Util.equalsEpsilon(this.m20, matrix4f.m20) && Util.equalsEpsilon(this.m21, matrix4f.m21) && Util.equalsEpsilon(this.m22, matrix4f.m22) && Util.equalsEpsilon(this.m23, matrix4f.m23);
            }
            if (Util.IDENTITY_EQUALS) {
                return this.m00 == matrix4f.m00 && this.m01 == matrix4f.m01 && this.m02 == matrix4f.m02 && this.m03 == matrix4f.m03 && this.m10 == matrix4f.m10 && this.m11 == matrix4f.m11 && this.m12 == matrix4f.m12 && this.m13 == matrix4f.m13 && this.m20 == matrix4f.m20 && this.m21 == matrix4f.m21 && this.m22 == matrix4f.m22 && this.m23 == matrix4f.m23 && this.m30 == matrix4f.m30 && this.m31 == matrix4f.m31 && this.m32 == matrix4f.m32 && this.m33 == matrix4f.m33;
            }
            if (Util.EXACT_EQUALS) {
                return Float.compare(this.m00, matrix4f.m00) == 0 && Float.compare(this.m01, matrix4f.m01) == 0 && Float.compare(this.m02, matrix4f.m02) == 0 && Float.compare(this.m03, matrix4f.m03) == 0 && Float.compare(this.m10, matrix4f.m10) == 0 && Float.compare(this.m11, matrix4f.m11) == 0 && Float.compare(this.m12, matrix4f.m12) == 0 && Float.compare(this.m13, matrix4f.m13) == 0 && Float.compare(this.m20, matrix4f.m20) == 0 && Float.compare(this.m21, matrix4f.m21) == 0 && Float.compare(this.m22, matrix4f.m22) == 0 && Float.compare(this.m23, matrix4f.m23) == 0 && Float.compare(this.m30, matrix4f.m30) == 0 && Float.compare(this.m31, matrix4f.m31) == 0 && Float.compare(this.m32, matrix4f.m32) == 0 && Float.compare(this.m33, matrix4f.m33) == 0;
            }
            return Util.equalsEpsilon(this.m00, matrix4f.m00) && Util.equalsEpsilon(this.m01, matrix4f.m01) && Util.equalsEpsilon(this.m02, matrix4f.m02) && Util.equalsEpsilon(this.m03, matrix4f.m03) && Util.equalsEpsilon(this.m10, matrix4f.m10) && Util.equalsEpsilon(this.m11, matrix4f.m11) && Util.equalsEpsilon(this.m12, matrix4f.m12) && Util.equalsEpsilon(this.m13, matrix4f.m13) && Util.equalsEpsilon(this.m20, matrix4f.m20) && Util.equalsEpsilon(this.m21, matrix4f.m21) && Util.equalsEpsilon(this.m22, matrix4f.m22) && Util.equalsEpsilon(this.m23, matrix4f.m23) && Util.equalsEpsilon(this.m30, matrix4f.m30) && Util.equalsEpsilon(this.m31, matrix4f.m31) && Util.equalsEpsilon(this.m32, matrix4f.m32) && Util.equalsEpsilon(this.m33, matrix4f.m33);
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[m00=").append(this.m00);
        stringBuilder.append(",m01=").append(this.m01);
        stringBuilder.append(",m02=").append(this.m02);
        stringBuilder.append(",m03=").append(this.m03);
        stringBuilder.append(",m10=").append(this.m10);
        stringBuilder.append(",m11=").append(this.m11);
        stringBuilder.append(",m12=").append(this.m12);
        stringBuilder.append(",m13=").append(this.m13);
        stringBuilder.append(",m20=").append(this.m20);
        stringBuilder.append(",m21=").append(this.m21);
        stringBuilder.append(",m22=").append(this.m22);
        stringBuilder.append(",m23=").append(this.m23);
        stringBuilder.append(",m30=").append(this.m30);
        stringBuilder.append(",m31=").append(this.m31);
        stringBuilder.append(",m32=").append(this.m32);
        stringBuilder.append(",m33=").append(this.m33);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public int getDimension() {
        return 4;
    }

    public Matrix4f set(Matrix4f matrix4f) {
        if (this != matrix4f) {
            this.m00 = matrix4f.m00;
            this.m01 = matrix4f.m01;
            this.m02 = matrix4f.m02;
            this.m03 = matrix4f.m03;
            this.m10 = matrix4f.m10;
            this.m11 = matrix4f.m11;
            this.m12 = matrix4f.m12;
            this.m13 = matrix4f.m13;
            this.m20 = matrix4f.m20;
            this.m21 = matrix4f.m21;
            this.m22 = matrix4f.m22;
            this.m23 = matrix4f.m23;
            this.m30 = matrix4f.m30;
            this.m31 = matrix4f.m31;
            this.m32 = matrix4f.m32;
            this.m33 = matrix4f.m33;
        }
        return this;
    }

    public Matrix4f set(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        this.m00 = f2;
        this.m01 = f3;
        this.m02 = f4;
        this.m03 = f5;
        this.m10 = f6;
        this.m11 = f7;
        this.m12 = f8;
        this.m13 = f9;
        this.m20 = f10;
        this.m21 = f11;
        this.m22 = f12;
        this.m23 = f13;
        this.m30 = f14;
        this.m31 = f15;
        this.m32 = f16;
        this.m33 = f17;
        return this;
    }

    public void get(float[] fArray) {
        this.get(fArray, 0);
    }

    public void get(float[] fArray, int n) {
        if (!$assertionsDisabled && fArray.length < n * 4 * 4) {
            throw new AssertionError((Object)"Argument too small");
        }
        fArray[n++] = this.m00;
        fArray[n++] = this.m10;
        fArray[n++] = this.m20;
        fArray[n++] = this.m30;
        fArray[n++] = this.m01;
        fArray[n++] = this.m11;
        fArray[n++] = this.m21;
        fArray[n++] = this.m31;
        fArray[n++] = this.m02;
        fArray[n++] = this.m12;
        fArray[n++] = this.m22;
        fArray[n++] = this.m32;
        fArray[n++] = this.m03;
        fArray[n++] = this.m13;
        fArray[n++] = this.m23;
        fArray[n++] = this.m33;
    }

    public Matrix4f set(float[] fArray) {
        return this.set(fArray, 0);
    }

    public Matrix4f set(float[] fArray, int n) {
        if (!$assertionsDisabled && fArray.length < n + 16) {
            throw new AssertionError((Object)"Argument too small");
        }
        this.m00 = fArray[n++];
        this.m10 = fArray[n++];
        this.m20 = fArray[n++];
        this.m30 = fArray[n++];
        this.m01 = fArray[n++];
        this.m11 = fArray[n++];
        this.m21 = fArray[n++];
        this.m31 = fArray[n++];
        this.m02 = fArray[n++];
        this.m12 = fArray[n++];
        this.m22 = fArray[n++];
        this.m32 = fArray[n++];
        this.m03 = fArray[n++];
        this.m13 = fArray[n++];
        this.m23 = fArray[n++];
        this.m33 = fArray[n++];
        return this;
    }

    @Override
    public float get(int n, int n2) {
        switch (n) {
            case 0: {
                switch (n2) {
                    case 0: {
                        return this.m00;
                    }
                    case 1: {
                        return this.m01;
                    }
                    case 2: {
                        return this.m02;
                    }
                    case 3: {
                        return this.m03;
                    }
                }
                throw new IllegalArgumentException();
            }
            case 1: {
                switch (n2) {
                    case 0: {
                        return this.m10;
                    }
                    case 1: {
                        return this.m11;
                    }
                    case 2: {
                        return this.m12;
                    }
                    case 3: {
                        return this.m13;
                    }
                }
                throw new IllegalArgumentException();
            }
            case 2: {
                switch (n2) {
                    case 0: {
                        return this.m20;
                    }
                    case 1: {
                        return this.m21;
                    }
                    case 2: {
                        return this.m22;
                    }
                    case 3: {
                        return this.m23;
                    }
                }
                throw new IllegalArgumentException();
            }
            case 3: {
                switch (n2) {
                    case 0: {
                        return this.m30;
                    }
                    case 1: {
                        return this.m31;
                    }
                    case 2: {
                        return this.m32;
                    }
                    case 3: {
                        return this.m33;
                    }
                }
                throw new IllegalArgumentException();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void set(int n, int n2, float f2) {
        block0 : switch (n) {
            case 0: {
                switch (n2) {
                    case 0: {
                        this.m00 = f2;
                        break block0;
                    }
                    case 1: {
                        this.m01 = f2;
                        break block0;
                    }
                    case 2: {
                        this.m02 = f2;
                        break block0;
                    }
                    case 3: {
                        this.m03 = f2;
                        break block0;
                    }
                }
                throw new IllegalArgumentException();
            }
            case 1: {
                switch (n2) {
                    case 0: {
                        this.m10 = f2;
                        break block0;
                    }
                    case 1: {
                        this.m11 = f2;
                        break block0;
                    }
                    case 2: {
                        this.m12 = f2;
                        break block0;
                    }
                    case 3: {
                        this.m13 = f2;
                        break block0;
                    }
                }
                throw new IllegalArgumentException();
            }
            case 2: {
                switch (n2) {
                    case 0: {
                        this.m20 = f2;
                        break block0;
                    }
                    case 1: {
                        this.m21 = f2;
                        break block0;
                    }
                    case 2: {
                        this.m22 = f2;
                        break block0;
                    }
                    case 3: {
                        this.m23 = f2;
                        break block0;
                    }
                }
                throw new IllegalArgumentException();
            }
            case 3: {
                switch (n2) {
                    case 0: {
                        this.m30 = f2;
                        break block0;
                    }
                    case 1: {
                        this.m31 = f2;
                        break block0;
                    }
                    case 2: {
                        this.m32 = f2;
                        break block0;
                    }
                    case 3: {
                        this.m33 = f2;
                        break block0;
                    }
                }
                throw new IllegalArgumentException();
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    public void getColumn(int n, Tuple4f tuple4f) {
        switch (n) {
            case 0: {
                tuple4f.set(this.m00, this.m10, this.m20, this.m30);
                break;
            }
            case 1: {
                tuple4f.set(this.m01, this.m11, this.m21, this.m31);
                break;
            }
            case 2: {
                tuple4f.set(this.m02, this.m12, this.m22, this.m32);
                break;
            }
            case 3: {
                tuple4f.set(this.m03, this.m13, this.m23, this.m33);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid column index");
            }
        }
    }

    public void getColumn(int n, float[] fArray) {
        if (!$assertionsDisabled && fArray.length < 4) {
            throw new AssertionError((Object)"Argument too small");
        }
        switch (n) {
            case 0: {
                fArray[0] = this.m00;
                fArray[1] = this.m10;
                fArray[2] = this.m20;
                fArray[3] = this.m30;
                break;
            }
            case 1: {
                fArray[0] = this.m01;
                fArray[1] = this.m11;
                fArray[2] = this.m21;
                fArray[3] = this.m31;
                break;
            }
            case 2: {
                fArray[0] = this.m02;
                fArray[1] = this.m12;
                fArray[2] = this.m22;
                fArray[3] = this.m32;
                break;
            }
            case 3: {
                fArray[0] = this.m03;
                fArray[1] = this.m13;
                fArray[2] = this.m23;
                fArray[3] = this.m33;
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid column index");
            }
        }
    }

    public Matrix4f setColumn(int n, Tuple4f tuple4f) {
        return this.setColumn(n, tuple4f.x, tuple4f.y, tuple4f.z, tuple4f.w);
    }

    public Matrix4f setColumn(int n, float f2, float f3, float f4, float f5) {
        switch (n) {
            case 0: {
                this.m00 = f2;
                this.m10 = f3;
                this.m20 = f4;
                this.m30 = f5;
                break;
            }
            case 1: {
                this.m01 = f2;
                this.m11 = f3;
                this.m21 = f4;
                this.m31 = f5;
                break;
            }
            case 2: {
                this.m02 = f2;
                this.m12 = f3;
                this.m22 = f4;
                this.m32 = f5;
                break;
            }
            case 3: {
                this.m03 = f2;
                this.m13 = f3;
                this.m23 = f4;
                this.m33 = f5;
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid column index");
            }
        }
        return this;
    }

    public void getRow(int n, Tuple4f tuple4f) {
        switch (n) {
            case 0: {
                tuple4f.set(this.m00, this.m01, this.m02, this.m03);
                break;
            }
            case 1: {
                tuple4f.set(this.m10, this.m11, this.m12, this.m13);
                break;
            }
            case 2: {
                tuple4f.set(this.m20, this.m21, this.m22, this.m32);
                break;
            }
            case 3: {
                tuple4f.set(this.m30, this.m31, this.m32, this.m33);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid row index");
            }
        }
    }

    public void getRow(int n, float[] fArray) {
        if (!$assertionsDisabled && fArray.length < 4) {
            throw new AssertionError((Object)"Argument too small");
        }
        switch (n) {
            case 0: {
                fArray[0] = this.m00;
                fArray[1] = this.m01;
                fArray[2] = this.m02;
                fArray[3] = this.m03;
                break;
            }
            case 1: {
                fArray[0] = this.m10;
                fArray[1] = this.m11;
                fArray[2] = this.m12;
                fArray[3] = this.m13;
                break;
            }
            case 2: {
                fArray[0] = this.m20;
                fArray[1] = this.m21;
                fArray[2] = this.m22;
                fArray[3] = this.m23;
                break;
            }
            case 3: {
                fArray[0] = this.m30;
                fArray[1] = this.m31;
                fArray[2] = this.m32;
                fArray[3] = this.m33;
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid row index");
            }
        }
    }

    public Matrix4f setRow(int n, Tuple4f tuple4f) {
        return this.setRow(n, tuple4f.x, tuple4f.y, tuple4f.z, tuple4f.w);
    }

    public Matrix4f setRow(int n, float f2, float f3, float f4, float f5) {
        switch (n) {
            case 0: {
                this.m00 = f2;
                this.m01 = f3;
                this.m02 = f4;
                this.m03 = f5;
                break;
            }
            case 1: {
                this.m10 = f2;
                this.m11 = f3;
                this.m12 = f4;
                this.m13 = f5;
                break;
            }
            case 2: {
                this.m20 = f2;
                this.m21 = f3;
                this.m22 = f4;
                this.m23 = f5;
                break;
            }
            case 3: {
                this.m30 = f2;
                this.m31 = f3;
                this.m32 = f4;
                this.m33 = f5;
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid row index");
            }
        }
        return this;
    }

    public void getDiagonal(Tuple4f tuple4f) {
        tuple4f.set(this.m00, this.m11, this.m22, this.m33);
    }

    public void getDiagonal(float[] fArray) {
        if (!$assertionsDisabled && fArray.length < 4) {
            throw new AssertionError((Object)"Argument too small");
        }
        fArray[0] = this.m00;
        fArray[1] = this.m11;
        fArray[2] = this.m22;
        fArray[3] = this.m33;
    }

    public Matrix4f setDiagonal(Tuple4f tuple4f) {
        return this.setDiagonal(tuple4f.x, tuple4f.y, tuple4f.z, tuple4f.w);
    }

    public Matrix4f setDiagonal(float f2, float f3, float f4, float f5) {
        this.m00 = f2;
        this.m11 = f3;
        this.m22 = f4;
        this.m33 = f5;
        return this;
    }

    public void getUpperLeft3x3(Matrix3f matrix3f) {
        matrix3f.m00 = this.m00;
        matrix3f.m01 = this.m01;
        matrix3f.m02 = this.m02;
        matrix3f.m10 = this.m10;
        matrix3f.m11 = this.m11;
        matrix3f.m12 = this.m12;
        matrix3f.m20 = this.m20;
        matrix3f.m21 = this.m21;
        matrix3f.m22 = this.m22;
    }

    public Matrix4f setUpperLeft3x3(Matrix3f matrix3f) {
        this.m00 = matrix3f.m00;
        this.m01 = matrix3f.m01;
        this.m02 = matrix3f.m02;
        this.m10 = matrix3f.m10;
        this.m11 = matrix3f.m11;
        this.m12 = matrix3f.m12;
        this.m20 = matrix3f.m20;
        this.m21 = matrix3f.m21;
        this.m22 = matrix3f.m22;
        return this;
    }

    @Override
    public boolean isZero() {
        return Util.equalsEpsilon(this.m00, 0.0f) && Util.equalsEpsilon(this.m01, 0.0f) && Util.equalsEpsilon(this.m02, 0.0f) && Util.equalsEpsilon(this.m03, 0.0f) && Util.equalsEpsilon(this.m10, 0.0f) && Util.equalsEpsilon(this.m11, 0.0f) && Util.equalsEpsilon(this.m12, 0.0f) && Util.equalsEpsilon(this.m13, 0.0f) && Util.equalsEpsilon(this.m20, 0.0f) && Util.equalsEpsilon(this.m21, 0.0f) && Util.equalsEpsilon(this.m22, 0.0f) && Util.equalsEpsilon(this.m23, 0.0f) && Util.equalsEpsilon(this.m30, 0.0f) && Util.equalsEpsilon(this.m31, 0.0f) && Util.equalsEpsilon(this.m32, 0.0f) && Util.equalsEpsilon(this.m33, 0.0f);
    }

    public Matrix4f setZero() {
        this.m00 = 0.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 0.0f;
        this.m12 = 0.0f;
        this.m13 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 0.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 0.0f;
        return this;
    }

    @Override
    public boolean isIdentity() {
        return this.equals(IDENTITY);
    }

    public Matrix4f setIdentity() {
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m12 = 0.0f;
        this.m13 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 1.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
        return this;
    }

    public void neg(Matrix4f matrix4f) {
        matrix4f.m00 = -this.m00;
        matrix4f.m01 = -this.m01;
        matrix4f.m02 = -this.m02;
        matrix4f.m03 = -this.m03;
        matrix4f.m10 = -this.m10;
        matrix4f.m11 = -this.m11;
        matrix4f.m12 = -this.m12;
        matrix4f.m13 = -this.m13;
        matrix4f.m20 = -this.m20;
        matrix4f.m21 = -this.m21;
        matrix4f.m22 = -this.m22;
        matrix4f.m23 = -this.m23;
        matrix4f.m30 = -this.m30;
        matrix4f.m31 = -this.m31;
        matrix4f.m32 = -this.m32;
        matrix4f.m33 = -this.m33;
    }

    public Matrix4f neg() {
        this.neg(this);
        return this;
    }

    public void add(Matrix4f matrix4f, Matrix4f matrix4f2) {
        matrix4f2.m00 = this.m00 + matrix4f.m00;
        matrix4f2.m01 = this.m01 + matrix4f.m01;
        matrix4f2.m02 = this.m02 + matrix4f.m02;
        matrix4f2.m03 = this.m03 + matrix4f.m03;
        matrix4f2.m10 = this.m10 + matrix4f.m10;
        matrix4f2.m11 = this.m11 + matrix4f.m11;
        matrix4f2.m12 = this.m12 + matrix4f.m12;
        matrix4f2.m13 = this.m13 + matrix4f.m13;
        matrix4f2.m20 = this.m20 + matrix4f.m20;
        matrix4f2.m21 = this.m21 + matrix4f.m21;
        matrix4f2.m22 = this.m22 + matrix4f.m22;
        matrix4f2.m23 = this.m23 + matrix4f.m23;
        matrix4f2.m30 = this.m30 + matrix4f.m30;
        matrix4f2.m31 = this.m31 + matrix4f.m31;
        matrix4f2.m32 = this.m32 + matrix4f.m32;
        matrix4f2.m33 = this.m33 + matrix4f.m33;
    }

    public Matrix4f add(Matrix4f matrix4f) {
        this.add(matrix4f, this);
        return this;
    }

    public Matrix4f add(float[] fArray) {
        if (!$assertionsDisabled && fArray.length < 16) {
            throw new AssertionError((Object)"Argument too small");
        }
        this.m00 += fArray[0];
        this.m10 += fArray[1];
        this.m20 += fArray[2];
        this.m30 += fArray[3];
        this.m01 += fArray[4];
        this.m11 += fArray[5];
        this.m21 += fArray[6];
        this.m31 += fArray[7];
        this.m02 += fArray[8];
        this.m12 += fArray[9];
        this.m22 += fArray[10];
        this.m32 += fArray[11];
        this.m03 += fArray[12];
        this.m13 += fArray[13];
        this.m23 += fArray[14];
        this.m33 += fArray[15];
        return this;
    }

    public void sub(Matrix4f matrix4f, Matrix4f matrix4f2) {
        matrix4f2.m00 = this.m00 - matrix4f.m00;
        matrix4f2.m01 = this.m01 - matrix4f.m01;
        matrix4f2.m02 = this.m02 - matrix4f.m02;
        matrix4f2.m03 = this.m03 - matrix4f.m03;
        matrix4f2.m10 = this.m10 - matrix4f.m10;
        matrix4f2.m11 = this.m11 - matrix4f.m11;
        matrix4f2.m12 = this.m12 - matrix4f.m12;
        matrix4f2.m13 = this.m13 - matrix4f.m13;
        matrix4f2.m20 = this.m20 - matrix4f.m20;
        matrix4f2.m21 = this.m21 - matrix4f.m21;
        matrix4f2.m22 = this.m22 - matrix4f.m22;
        matrix4f2.m23 = this.m23 - matrix4f.m23;
        matrix4f2.m30 = this.m30 - matrix4f.m30;
        matrix4f2.m31 = this.m31 - matrix4f.m31;
        matrix4f2.m32 = this.m32 - matrix4f.m32;
        matrix4f2.m33 = this.m33 - matrix4f.m33;
    }

    public Matrix4f sub(Matrix4f matrix4f) {
        this.sub(matrix4f, this);
        return this;
    }

    public Matrix4f sub(float[] fArray) {
        if (!$assertionsDisabled && fArray.length < 16) {
            throw new AssertionError((Object)"Argument too small");
        }
        this.m00 -= fArray[0];
        this.m10 -= fArray[1];
        this.m20 -= fArray[2];
        this.m30 -= fArray[3];
        this.m01 -= fArray[4];
        this.m11 -= fArray[5];
        this.m21 -= fArray[6];
        this.m31 -= fArray[7];
        this.m02 -= fArray[8];
        this.m12 -= fArray[9];
        this.m22 -= fArray[10];
        this.m32 -= fArray[11];
        this.m03 -= fArray[12];
        this.m13 -= fArray[13];
        this.m23 -= fArray[14];
        this.m33 -= fArray[15];
        return this;
    }

    public void mul(float f2, Matrix4f matrix4f) {
        matrix4f.m00 = this.m00 * f2;
        matrix4f.m01 = this.m01 * f2;
        matrix4f.m02 = this.m02 * f2;
        matrix4f.m03 = this.m03 * f2;
        matrix4f.m10 = this.m10 * f2;
        matrix4f.m11 = this.m11 * f2;
        matrix4f.m12 = this.m12 * f2;
        matrix4f.m13 = this.m13 * f2;
        matrix4f.m20 = this.m20 * f2;
        matrix4f.m21 = this.m21 * f2;
        matrix4f.m22 = this.m22 * f2;
        matrix4f.m23 = this.m23 * f2;
        matrix4f.m30 = this.m30 * f2;
        matrix4f.m31 = this.m31 * f2;
        matrix4f.m32 = this.m32 * f2;
        matrix4f.m33 = this.m33 * f2;
    }

    public Matrix4f mul(float f2) {
        this.mul(f2, this);
        return this;
    }

    public void mul(Tuple2f tuple2f, Tuple2f tuple2f2) {
        float f2 = this.m00 * tuple2f.x + this.m01 * tuple2f.y;
        float f3 = this.m10 * tuple2f.x + this.m11 * tuple2f.y;
        tuple2f2.x = f2;
        tuple2f2.y = f3;
    }

    public void mul(Tuple2f tuple2f) {
        this.mul(tuple2f, tuple2f);
    }

    public void mul(Tuple3f tuple3f, Tuple3f tuple3f2) {
        float f2 = this.m00 * tuple3f.x + this.m01 * tuple3f.y + this.m02 * tuple3f.z;
        float f3 = this.m10 * tuple3f.x + this.m11 * tuple3f.y + this.m12 * tuple3f.z;
        float f4 = this.m20 * tuple3f.x + this.m21 * tuple3f.y + this.m22 * tuple3f.z;
        tuple3f2.x = f2;
        tuple3f2.y = f3;
        tuple3f2.z = f4;
    }

    public void mul(Tuple3f tuple3f) {
        this.mul(tuple3f, tuple3f);
    }

    public void mul(Tuple4f tuple4f, Tuple4f tuple4f2) {
        float f2 = this.m00 * tuple4f.x + this.m01 * tuple4f.y + this.m02 * tuple4f.z + this.m03 * tuple4f.w;
        float f3 = this.m10 * tuple4f.x + this.m11 * tuple4f.y + this.m12 * tuple4f.z + this.m13 * tuple4f.w;
        float f4 = this.m20 * tuple4f.x + this.m21 * tuple4f.y + this.m22 * tuple4f.z + this.m23 * tuple4f.w;
        float f5 = this.m30 * tuple4f.x + this.m31 * tuple4f.y + this.m32 * tuple4f.z + this.m33 * tuple4f.w;
        tuple4f2.x = f2;
        tuple4f2.y = f3;
        tuple4f2.z = f4;
        tuple4f2.w = f5;
    }

    public void mul(Tuple4f tuple4f) {
        this.mul(tuple4f, tuple4f);
    }

    public void mul(Matrix4f matrix4f, Matrix4f matrix4f2) {
        if (OPTIMIZE_BYPASS) {
            if (this.isIdentity()) {
                matrix4f2.set(matrix4f);
                return;
            }
            if (matrix4f.isIdentity()) {
                matrix4f2.set(this);
                return;
            }
        }
        float f2 = this.m00 * matrix4f.m00 + this.m01 * matrix4f.m10 + this.m02 * matrix4f.m20 + this.m03 * matrix4f.m30;
        float f3 = this.m00 * matrix4f.m01 + this.m01 * matrix4f.m11 + this.m02 * matrix4f.m21 + this.m03 * matrix4f.m31;
        float f4 = this.m00 * matrix4f.m02 + this.m01 * matrix4f.m12 + this.m02 * matrix4f.m22 + this.m03 * matrix4f.m32;
        float f5 = this.m00 * matrix4f.m03 + this.m01 * matrix4f.m13 + this.m02 * matrix4f.m23 + this.m03 * matrix4f.m33;
        float f6 = this.m10 * matrix4f.m00 + this.m11 * matrix4f.m10 + this.m12 * matrix4f.m20 + this.m13 * matrix4f.m30;
        float f7 = this.m10 * matrix4f.m01 + this.m11 * matrix4f.m11 + this.m12 * matrix4f.m21 + this.m13 * matrix4f.m31;
        float f8 = this.m10 * matrix4f.m02 + this.m11 * matrix4f.m12 + this.m12 * matrix4f.m22 + this.m13 * matrix4f.m32;
        float f9 = this.m10 * matrix4f.m03 + this.m11 * matrix4f.m13 + this.m12 * matrix4f.m23 + this.m13 * matrix4f.m33;
        float f10 = this.m20 * matrix4f.m00 + this.m21 * matrix4f.m10 + this.m22 * matrix4f.m20 + this.m23 * matrix4f.m30;
        float f11 = this.m20 * matrix4f.m01 + this.m21 * matrix4f.m11 + this.m22 * matrix4f.m21 + this.m23 * matrix4f.m31;
        float f12 = this.m20 * matrix4f.m02 + this.m21 * matrix4f.m12 + this.m22 * matrix4f.m22 + this.m23 * matrix4f.m32;
        float f13 = this.m20 * matrix4f.m03 + this.m21 * matrix4f.m13 + this.m22 * matrix4f.m23 + this.m23 * matrix4f.m33;
        float f14 = this.m30 * matrix4f.m00 + this.m31 * matrix4f.m10 + this.m32 * matrix4f.m20 + this.m33 * matrix4f.m30;
        float f15 = this.m30 * matrix4f.m01 + this.m31 * matrix4f.m11 + this.m32 * matrix4f.m21 + this.m33 * matrix4f.m31;
        float f16 = this.m30 * matrix4f.m02 + this.m31 * matrix4f.m12 + this.m32 * matrix4f.m22 + this.m33 * matrix4f.m32;
        float f17 = this.m30 * matrix4f.m03 + this.m31 * matrix4f.m13 + this.m32 * matrix4f.m23 + this.m33 * matrix4f.m33;
        matrix4f2.m00 = f2;
        matrix4f2.m01 = f3;
        matrix4f2.m02 = f4;
        matrix4f2.m03 = f5;
        matrix4f2.m10 = f6;
        matrix4f2.m11 = f7;
        matrix4f2.m12 = f8;
        matrix4f2.m13 = f9;
        matrix4f2.m20 = f10;
        matrix4f2.m21 = f11;
        matrix4f2.m22 = f12;
        matrix4f2.m23 = f13;
        matrix4f2.m30 = f14;
        matrix4f2.m31 = f15;
        matrix4f2.m32 = f16;
        matrix4f2.m33 = f17;
    }

    public Matrix4f mul(Matrix4f matrix4f) {
        this.mul(matrix4f, this);
        return this;
    }

    public void mulDiag(Tuple4f tuple4f, Matrix4f matrix4f) {
        matrix4f.m00 = this.m00 * tuple4f.x;
        matrix4f.m01 = this.m01 * tuple4f.x;
        matrix4f.m02 = this.m02 * tuple4f.x;
        matrix4f.m03 = this.m03 * tuple4f.x;
        matrix4f.m10 = this.m10 * tuple4f.y;
        matrix4f.m11 = this.m11 * tuple4f.y;
        matrix4f.m12 = this.m12 * tuple4f.y;
        matrix4f.m13 = this.m13 * tuple4f.y;
        matrix4f.m20 = this.m20 * tuple4f.z;
        matrix4f.m21 = this.m21 * tuple4f.z;
        matrix4f.m22 = this.m22 * tuple4f.z;
        matrix4f.m23 = this.m23 * tuple4f.z;
        matrix4f.m30 = this.m30 * tuple4f.w;
        matrix4f.m31 = this.m31 * tuple4f.w;
        matrix4f.m32 = this.m32 * tuple4f.w;
        matrix4f.m33 = this.m33 * tuple4f.w;
    }

    @Override
    public float getDeterminant() {
        if (OPTIMIZE) {
            float f2 = this.m12 * this.m23 - this.m22 * this.m13;
            float f3 = this.m11 * this.m23 - this.m21 * this.m13;
            float f4 = this.m11 * this.m22 - this.m21 * this.m12;
            float f5 = this.m10 * this.m23 - this.m20 * this.m13;
            float f6 = this.m10 * this.m22 - this.m20 * this.m12;
            float f7 = this.m10 * this.m21 - this.m20 * this.m11;
            return -this.m30 * (this.m01 * f2 - this.m02 * f3 + this.m03 * f4) + this.m31 * (this.m00 * f2 - this.m02 * f5 + this.m03 * f6) - this.m32 * (this.m00 * f3 - this.m01 * f5 + this.m03 * f7) + this.m33 * (this.m00 * f4 - this.m01 * f6 + this.m02 * f7);
        }
        return (this.m00 * this.m11 - this.m01 * this.m10) * (this.m22 * this.m33 - this.m23 * this.m32) - (this.m00 * this.m12 - this.m02 * this.m10) * (this.m21 * this.m33 - this.m23 * this.m31) + (this.m00 * this.m13 - this.m03 * this.m10) * (this.m21 * this.m32 - this.m22 * this.m31) + (this.m01 * this.m12 - this.m02 * this.m11) * (this.m20 * this.m33 - this.m23 * this.m30) - (this.m01 * this.m13 - this.m03 * this.m11) * (this.m20 * this.m32 - this.m22 * this.m30) + (this.m02 * this.m13 - this.m03 * this.m12) * (this.m20 * this.m31 - this.m21 * this.m30);
    }

    public Matrix invert() {
        this.invert(this);
        return this;
    }

    private static void __gluMakeIdentity(float[] fArray) {
        fArray[0] = 1.0f;
        fArray[1] = 0.0f;
        fArray[2] = 0.0f;
        fArray[3] = 0.0f;
        fArray[4] = 0.0f;
        fArray[5] = 1.0f;
        fArray[6] = 0.0f;
        fArray[7] = 0.0f;
        fArray[8] = 0.0f;
        fArray[9] = 0.0f;
        fArray[10] = 1.0f;
        fArray[11] = 0.0f;
        fArray[12] = 0.0f;
        fArray[13] = 0.0f;
        fArray[14] = 0.0f;
        fArray[15] = 1.0f;
    }

    private static void __gluInvertMatrix(float[] fArray, float[] fArray2) {
        int n;
        int n2;
        float[][] fArray3 = new float[4][4];
        for (n2 = 0; n2 < 4; ++n2) {
            for (n = 0; n < 4; ++n) {
                fArray3[n2][n] = fArray[n2 * 4 + n];
            }
        }
        Matrix4f.__gluMakeIdentity(fArray2);
        for (n2 = 0; n2 < 4; ++n2) {
            float f2;
            int n3;
            int n4 = n2;
            for (n = n2 + 1; n < 4; ++n) {
                if (!(Math.abs(fArray3[n][n2]) > Math.abs(fArray3[n2][n2]))) continue;
                n4 = n;
            }
            if (n4 != n2) {
                for (n3 = 0; n3 < 4; ++n3) {
                    f2 = fArray3[n2][n3];
                    fArray3[n2][n3] = fArray3[n4][n3];
                    fArray3[n4][n3] = f2;
                    f2 = fArray2[n2 * 4 + n3];
                    fArray2[n2 * 4 + n3] = fArray2[n4 * 4 + n3];
                    fArray2[n4 * 4 + n3] = f2;
                }
            }
            if (fArray3[n2][n2] == 0.0f) {
                throw new SingularMatrixException();
            }
            f2 = fArray3[n2][n2];
            for (n3 = 0; n3 < 4; ++n3) {
                float[] fArray4 = fArray3[n2];
                int n5 = n3;
                fArray4[n5] = fArray4[n5] / f2;
                int n6 = n2 * 4 + n3;
                fArray2[n6] = fArray2[n6] / f2;
            }
            for (n = 0; n < 4; ++n) {
                if (n == n2) continue;
                f2 = fArray3[n][n2];
                for (n3 = 0; n3 < 4; ++n3) {
                    float[] fArray5 = fArray3[n];
                    int n7 = n3;
                    fArray5[n7] = fArray5[n7] - fArray3[n2][n3] * f2;
                    int n8 = n * 4 + n3;
                    fArray2[n8] = fArray2[n8] - fArray2[n2 * 4 + n3] * f2;
                }
            }
        }
    }

    public void invert(Matrix4f matrix4f) {
        if (OPTIMIZE_BYPASS && this.isIdentity()) {
            matrix4f.setIdentity();
            return;
        }
        if (OPTIMIZE) {
            float f2 = this.m21 * this.m32 - this.m31 * this.m22;
            float f3 = this.m11 * this.m32 - this.m31 * this.m12;
            float f4 = this.m11 * this.m22 - this.m21 * this.m12;
            float f5 = this.m01 * this.m32 - this.m31 * this.m02;
            float f6 = this.m01 * this.m22 - this.m21 * this.m02;
            float f7 = this.m01 * this.m12 - this.m11 * this.m02;
            float f8 = -this.m03 * (this.m10 * f2 - this.m20 * f3 + this.m30 * f4) + this.m13 * (this.m00 * f2 - this.m20 * f5 + this.m30 * f6) - this.m23 * (this.m00 * f3 - this.m10 * f5 + this.m30 * f7) + this.m33 * (this.m00 * f4 - this.m10 * f6 + this.m20 * f7);
            if (Util.equalsEpsilon(f8, 0.0f)) {
                throw new SingularMatrixException();
            }
            float f9 = this.m22 * this.m33 - this.m32 * this.m23;
            float f10 = this.m32 * this.m13 - this.m12 * this.m33;
            float f11 = this.m12 * this.m23 - this.m22 * this.m13;
            float f12 = this.m20 * this.m33 - this.m30 * this.m23;
            float f13 = this.m30 * this.m13 - this.m10 * this.m33;
            float f14 = this.m10 * this.m23 - this.m20 * this.m13;
            float f15 = this.m20 * this.m31 - this.m30 * this.m21;
            float f16 = this.m30 * this.m11 - this.m10 * this.m31;
            float f17 = this.m10 * this.m21 - this.m20 * this.m11;
            float f18 = this.m02 * this.m33 - this.m32 * this.m03;
            float f19 = this.m22 * this.m03 - this.m02 * this.m23;
            float f20 = this.m00 * this.m33 - this.m30 * this.m03;
            float f21 = this.m20 * this.m03 - this.m00 * this.m23;
            float f22 = this.m00 * this.m31 - this.m30 * this.m01;
            float f23 = this.m20 * this.m01 - this.m00 * this.m21;
            float f24 = this.m02 * this.m13 - this.m12 * this.m03;
            float f25 = this.m00 * this.m13 - this.m10 * this.m03;
            float f26 = this.m00 * this.m11 - this.m10 * this.m01;
            f8 = 1.0f / f8;
            float f27 = f8 * (this.m11 * f9 + this.m21 * f10 + this.m31 * f11);
            float f28 = f8 * (this.m12 * f12 + this.m22 * f13 + this.m32 * f14);
            float f29 = f8 * (this.m13 * f15 + this.m23 * f16 + this.m33 * f17);
            float f30 = f8 * (this.m10 * -f2 + this.m20 * f3 + this.m30 * -f4);
            float f31 = f8 * (this.m21 * f18 + this.m31 * f19 - this.m01 * f9);
            float f32 = f8 * (this.m22 * f20 + this.m32 * f21 - this.m02 * f12);
            float f33 = f8 * (this.m23 * f22 + this.m33 * f23 - this.m03 * f15);
            float f34 = f8 * (this.m20 * -f5 + this.m30 * f6 + this.m00 * f2);
            float f35 = f8 * (this.m31 * f24 - this.m01 * f10 - this.m11 * f18);
            float f36 = f8 * (this.m32 * f25 - this.m02 * f13 - this.m12 * f20);
            float f37 = f8 * (this.m33 * f26 - this.m03 * f16 - this.m13 * f22);
            float f38 = f8 * (this.m30 * -f7 + this.m00 * -f3 + this.m10 * f5);
            float f39 = f8 * (this.m01 * -f11 - this.m11 * f19 - this.m21 * f24);
            float f40 = f8 * (this.m02 * -f14 - this.m12 * f21 - this.m22 * f25);
            float f41 = f8 * (this.m03 * -f17 - this.m13 * f23 - this.m23 * f26);
            float f42 = f8 * (this.m00 * f4 + this.m10 * -f6 + this.m20 * f7);
            matrix4f.m00 = f27;
            matrix4f.m10 = f28;
            matrix4f.m20 = f29;
            matrix4f.m30 = f30;
            matrix4f.m01 = f31;
            matrix4f.m11 = f32;
            matrix4f.m21 = f33;
            matrix4f.m31 = f34;
            matrix4f.m02 = f35;
            matrix4f.m12 = f36;
            matrix4f.m22 = f37;
            matrix4f.m32 = f38;
            matrix4f.m03 = f39;
            matrix4f.m13 = f40;
            matrix4f.m23 = f41;
            matrix4f.m33 = f42;
        } else {
            float f43 = this.getDeterminant();
            if (Util.equalsEpsilon(f43, 0.0f)) {
                throw new SingularMatrixException();
            }
            f43 = 1.0f / f43;
            float f44 = f43 * (this.m11 * (this.m22 * this.m33 - this.m23 * this.m32) + this.m12 * (this.m23 * this.m31 - this.m21 * this.m33) + this.m13 * (this.m21 * this.m32 - this.m22 * this.m31));
            float f45 = f43 * (this.m21 * (this.m02 * this.m33 - this.m03 * this.m32) + this.m22 * (this.m03 * this.m31 - this.m01 * this.m33) + this.m23 * (this.m01 * this.m32 - this.m02 * this.m31));
            float f46 = f43 * (this.m31 * (this.m02 * this.m13 - this.m03 * this.m12) + this.m32 * (this.m03 * this.m11 - this.m01 * this.m13) + this.m33 * (this.m01 * this.m12 - this.m02 * this.m11));
            float f47 = f43 * (this.m01 * (this.m13 * this.m22 - this.m12 * this.m23) + this.m02 * (this.m11 * this.m23 - this.m13 * this.m21) + this.m03 * (this.m12 * this.m21 - this.m11 * this.m22));
            float f48 = f43 * (this.m12 * (this.m20 * this.m33 - this.m23 * this.m30) + this.m13 * (this.m22 * this.m30 - this.m20 * this.m32) + this.m10 * (this.m23 * this.m32 - this.m22 * this.m33));
            float f49 = f43 * (this.m22 * (this.m00 * this.m33 - this.m03 * this.m30) + this.m23 * (this.m02 * this.m30 - this.m00 * this.m32) + this.m20 * (this.m03 * this.m32 - this.m02 * this.m33));
            float f50 = f43 * (this.m32 * (this.m00 * this.m13 - this.m03 * this.m10) + this.m33 * (this.m02 * this.m10 - this.m00 * this.m12) + this.m30 * (this.m03 * this.m12 - this.m02 * this.m13));
            float f51 = f43 * (this.m02 * (this.m13 * this.m20 - this.m10 * this.m23) + this.m03 * (this.m10 * this.m22 - this.m12 * this.m20) + this.m00 * (this.m12 * this.m23 - this.m13 * this.m22));
            float f52 = f43 * (this.m13 * (this.m20 * this.m31 - this.m21 * this.m30) + this.m10 * (this.m21 * this.m33 - this.m23 * this.m31) + this.m11 * (this.m23 * this.m30 - this.m20 * this.m33));
            float f53 = f43 * (this.m23 * (this.m00 * this.m31 - this.m01 * this.m30) + this.m20 * (this.m01 * this.m33 - this.m03 * this.m31) + this.m21 * (this.m03 * this.m30 - this.m00 * this.m33));
            float f54 = f43 * (this.m33 * (this.m00 * this.m11 - this.m01 * this.m10) + this.m30 * (this.m01 * this.m13 - this.m03 * this.m11) + this.m31 * (this.m03 * this.m10 - this.m00 * this.m13));
            float f55 = f43 * (this.m03 * (this.m11 * this.m20 - this.m10 * this.m21) + this.m00 * (this.m13 * this.m21 - this.m11 * this.m23) + this.m01 * (this.m10 * this.m23 - this.m13 * this.m20));
            float f56 = f43 * (this.m10 * (this.m22 * this.m31 - this.m21 * this.m32) + this.m11 * (this.m20 * this.m32 - this.m22 * this.m30) + this.m12 * (this.m21 * this.m30 - this.m20 * this.m31));
            float f57 = f43 * (this.m20 * (this.m02 * this.m31 - this.m01 * this.m32) + this.m21 * (this.m00 * this.m32 - this.m02 * this.m30) + this.m22 * (this.m01 * this.m30 - this.m00 * this.m31));
            float f58 = f43 * (this.m30 * (this.m02 * this.m11 - this.m01 * this.m12) + this.m31 * (this.m00 * this.m12 - this.m02 * this.m10) + this.m32 * (this.m01 * this.m10 - this.m00 * this.m11));
            float f59 = f43 * (this.m00 * (this.m11 * this.m22 - this.m12 * this.m21) + this.m01 * (this.m12 * this.m20 - this.m10 * this.m22) + this.m02 * (this.m10 * this.m21 - this.m11 * this.m20));
            matrix4f.m00 = f44;
            matrix4f.m01 = f45;
            matrix4f.m02 = f46;
            matrix4f.m03 = f47;
            matrix4f.m10 = f48;
            matrix4f.m11 = f49;
            matrix4f.m12 = f50;
            matrix4f.m13 = f51;
            matrix4f.m20 = f52;
            matrix4f.m21 = f53;
            matrix4f.m22 = f54;
            matrix4f.m23 = f55;
            matrix4f.m30 = f56;
            matrix4f.m31 = f57;
            matrix4f.m32 = f58;
            matrix4f.m33 = f59;
        }
    }

    public void transpose(Matrix4f matrix4f) {
        if (this != matrix4f) {
            matrix4f.m00 = this.m00;
            matrix4f.m10 = this.m01;
            matrix4f.m20 = this.m02;
            matrix4f.m30 = this.m03;
            matrix4f.m01 = this.m10;
            matrix4f.m11 = this.m11;
            matrix4f.m21 = this.m12;
            matrix4f.m31 = this.m13;
            matrix4f.m02 = this.m20;
            matrix4f.m12 = this.m21;
            matrix4f.m22 = this.m22;
            matrix4f.m32 = this.m23;
            matrix4f.m03 = this.m30;
            matrix4f.m13 = this.m31;
            matrix4f.m23 = this.m32;
            matrix4f.m33 = this.m33;
        } else {
            this.transpose();
        }
    }

    public Matrix4f transpose() {
        float f2 = this.m01;
        this.m01 = this.m10;
        this.m10 = f2;
        f2 = this.m02;
        this.m02 = this.m20;
        this.m20 = f2;
        f2 = this.m03;
        this.m03 = this.m30;
        this.m30 = f2;
        f2 = this.m12;
        this.m12 = this.m21;
        this.m21 = f2;
        f2 = this.m13;
        this.m13 = this.m31;
        this.m31 = f2;
        f2 = this.m23;
        this.m23 = this.m32;
        this.m32 = f2;
        return this;
    }

    public Matrix4f scale(float[] fArray) {
        return this.scale(fArray[0], fArray[1], fArray[2]);
    }

    public Matrix4f scale(Tuple3f tuple3f) {
        return this.scale(tuple3f.x, tuple3f.y, tuple3f.z);
    }

    public Matrix4f scale(float f2) {
        return this.scale(f2, f2, f2);
    }

    public Matrix4f scale(float f2, float f3, float f4) {
        if (f2 != 1.0f || f3 != 1.0f || f4 != 1.0f) {
            if (OPTIMIZE_SHORTCUT) {
                this.m00 *= f2;
                this.m10 *= f2;
                this.m20 *= f2;
                this.m30 *= f2;
                this.m01 *= f3;
                this.m11 *= f3;
                this.m21 *= f3;
                this.m31 *= f3;
                this.m02 *= f4;
                this.m12 *= f4;
                this.m22 *= f4;
                this.m32 *= f4;
            } else {
                this.mul(TEMPMAT4.setIdentity().setScale(f2, f3, f4));
            }
        }
        return this;
    }

    public void getScale(Tuple3f tuple3f) {
        float f2 = Util.sqrt(this.m00 * this.m00 + this.m10 * this.m10 + this.m20 * this.m20);
        float f3 = Util.sqrt(this.m01 * this.m01 + this.m11 * this.m11 + this.m21 * this.m21);
        float f4 = Util.sqrt(this.m02 * this.m02 + this.m12 * this.m12 + this.m22 * this.m22);
        tuple3f.set(f2, f3, f4);
    }

    public Matrix4f setScale(Tuple3f tuple3f) {
        return this.setScale(tuple3f.x, tuple3f.y, tuple3f.z);
    }

    public Matrix4f setScale(float f2, float f3, float f4) {
        if (OPTIMIZE_BYPASS && this.isIdentity()) {
            this.setDiagonal(f2, f3, f4, this.m33);
        } else {
            this.getColumn(0, TEMPVEC4);
            TEMPVEC4.normalize().scale(f2);
            this.setColumn(0, TEMPVEC4);
            this.getColumn(1, TEMPVEC4);
            TEMPVEC4.normalize().scale(f3);
            this.setColumn(1, TEMPVEC4);
            this.getColumn(2, TEMPVEC4);
            TEMPVEC4.normalize().scale(f4);
            this.setColumn(2, TEMPVEC4);
        }
        return this;
    }

    public Matrix4f rotate(float[] fArray) {
        return this.rotate(fArray[0], fArray[1], fArray[2], fArray[3]);
    }

    public Matrix4f rotate(Vector4f vector4f) {
        return this.rotate(vector4f.w, vector4f.x, vector4f.y, vector4f.z);
    }

    public Matrix4f rotate(float f2, float f3, float f4, float f5) {
        if (f2 != 0.0f) {
            this.mul(TEMPMAT4.setIdentity().setRotation(f2, f3, f4, f5));
        }
        return this;
    }

    public Matrix4f setRotation(float f2, float f3, float f4, float f5) {
        if (f2 != 0.0f) {
            float f6 = Util.invSqrt(f3 * f3 + f4 * f4 + f5 * f5);
            float f7 = f3 * f6;
            float f8 = f4 * f6;
            float f9 = f5 * f6;
            float f10 = Util.sin(f2);
            float f11 = Util.cos(f2);
            float f12 = 1.0f - f11;
            float f13 = f3 * f5;
            float f14 = f3 * f4;
            float f15 = f4 * f5;
            float f16 = this.m00;
            float f17 = this.m11;
            float f18 = this.m22;
            this.m00 = (f12 * f7 * f7 + f11) * f16;
            this.m01 = (f12 * f14 - f10 * f9) * f17;
            this.m02 = (f12 * f13 + f10 * f8) * f18;
            this.m10 = (f12 * f14 + f10 * f9) * f16;
            this.m11 = (f12 * f8 * f8 + f11) * f17;
            this.m12 = (f12 * f15 - f10 * f7) * f18;
            this.m20 = (f12 * f13 - f10 * f8) * f16;
            this.m21 = (f12 * f15 + f10 * f7) * f17;
            this.m22 = (f12 * f9 * f9 + f11) * f18;
        } else {
            this.setIdentity3x3();
        }
        return this;
    }

    protected Matrix4f setRotationAboutAxis(float f2, float f3, float f4, float f5) {
        if (f2 != 0.0f) {
            float f6 = this.m00;
            float f7 = this.m11;
            float f8 = this.m22;
            double d2 = 1.0E-8;
            double d3 = Util.sqrt(f3 * f3 + f4 * f4 + f5 * f5);
            if (d3 >= 1.0E-8) {
                d3 = 1.0 / d3;
                double d4 = (double)f3 * d3;
                double d5 = (double)f4 * d3;
                double d6 = (double)f5 * d3;
                double d7 = Util.sin(f2);
                double d8 = Util.cos(f2);
                double d9 = 1.0 - d8;
                double d10 = f3 * f5;
                double d11 = f3 * f4;
                double d12 = f4 * f5;
                this.m00 = (float)((d9 * d4 * d4 + d8) * (double)f6);
                this.m01 = (float)((d9 * d11 - d7 * d6) * (double)f7);
                this.m02 = (float)((d9 * d10 + d7 * d5) * (double)f8);
                this.m10 = (float)((d9 * d11 + d7 * d6) * (double)f6);
                this.m11 = (float)((d9 * d5 * d5 + d8) * (double)f7);
                this.m12 = (float)((d9 * d12 - d7 * d4) * (double)f8);
                this.m20 = (float)((d9 * d10 - d7 * d5) * (double)f6);
                this.m21 = (float)((d9 * d12 + d7 * d4) * (double)f7);
                this.m22 = (float)((d9 * d6 * d6 + d8) * (double)f8);
            } else {
                this.setIdentity3x3();
            }
        } else {
            this.setIdentity3x3();
        }
        return this;
    }

    protected Matrix4f setRotationAboutAxis2(Vector3f vector3f, float f2) {
        if (f2 != 0.0f) {
            float f3 = Util.cos(f2);
            float f4 = Util.sin(f2);
            float f5 = 1.0f - f3;
            float f6 = vector3f.x;
            float f7 = vector3f.y;
            float f8 = vector3f.z;
            this.m00 = f6 * f6 * f5 + f3;
            this.m01 = f6 * f7 * f5 - f8 * f4;
            this.m02 = f6 * f8 * f5 * f7 * f4;
            this.m10 = f7 * f6 * f5 + f8 * f4;
            this.m11 = f7 * f7 * f5 + f3;
            this.m12 = f7 * f8 * f5 - f6 * f4;
            this.m20 = f6 * f8 * f5 - f7 * f4;
            this.m21 = f7 * f8 * f5 + f6 * f4;
            this.m22 = f8 * f8 * f5 + f3;
        } else {
            this.setIdentity3x3();
        }
        return this;
    }

    protected Matrix4f setRotationAboutX(float f2) {
        if (f2 != 0.0f) {
            float f3 = Util.sin(f2);
            float f4 = Util.cos(f2);
            this.m00 = 1.0f;
            this.m10 = 0.0f;
            this.m20 = 0.0f;
            this.m01 = 0.0f;
            this.m11 = f4;
            this.m12 = -f3;
            this.m02 = 0.0f;
            this.m12 = f3;
            this.m22 = f4;
        } else {
            this.setIdentity3x3();
        }
        return this;
    }

    protected Matrix4f setRotationAboutY(float f2) {
        if (f2 != 0.0f) {
            float f3;
            float f4 = Util.sin(f2);
            this.m00 = f3 = Util.cos(f2);
            this.m10 = 0.0f;
            this.m20 = -f4;
            this.m01 = 0.0f;
            this.m11 = 1.0f;
            this.m21 = 0.0f;
            this.m02 = f4;
            this.m12 = 0.0f;
            this.m22 = f3;
        } else {
            this.setIdentity3x3();
        }
        return this;
    }

    protected Matrix4f setRotationAboutZ(float f2) {
        if (f2 != 0.0f) {
            float f3;
            float f4 = Util.sin(f2);
            this.m00 = f3 = Util.cos(f2);
            this.m10 = f4;
            this.m20 = 0.0f;
            this.m01 = -f4;
            this.m11 = f3;
            this.m21 = 0.0f;
            this.m02 = 0.0f;
            this.m12 = 0.0f;
            this.m22 = 1.0f;
        } else {
            this.setIdentity3x3();
        }
        return this;
    }

    public Matrix4f setRotationAboutXYZ(float f2, float f3, float f4) {
        if (f2 != 0.0f || f3 != 0.0f || f4 != 0.0f) {
            float f5 = Util.cos(f2);
            float f6 = Util.sin(f2);
            float f7 = Util.cos(f3);
            float f8 = Util.sin(f3);
            float f9 = Util.cos(f4);
            float f10 = Util.sin(f4);
            this.m00 = f7 * f9;
            this.m01 = -f7 * f10;
            this.m02 = f8;
            this.m10 = f6 * f8 * f9 + f5 * f10;
            this.m11 = -f6 * f8 * f10 + f5 * f9;
            this.m12 = -f6 * f7;
            this.m20 = -f5 * f8 * f9 + f6 * f10;
            this.m21 = f5 * f8 * f10 + f6 * f9;
            this.m22 = f5 * f7;
        } else {
            this.setIdentity3x3();
        }
        return this;
    }

    private void setIdentity3x3() {
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m12 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 1.0f;
    }

    public Matrix4f translate(float[] fArray) {
        return this.translate(fArray[0], fArray[1], fArray[2]);
    }

    public Matrix4f translate(Vector3f vector3f) {
        return this.translate(vector3f.x, vector3f.y, vector3f.z);
    }

    public Matrix4f translate(Vector4f vector4f) {
        return this.translate(vector4f.x, vector4f.y, vector4f.z);
    }

    public Matrix4f translate(float f2, float f3, float f4) {
        if (f2 != 0.0f || f3 != 0.0f || f4 != 0.0f) {
            if (OPTIMIZE_SHORTCUT) {
                this.m03 += this.m00 * f2 + this.m01 * f3 + this.m02 * f4;
                this.m13 += this.m10 * f2 + this.m11 * f3 + this.m12 * f4;
                this.m23 += this.m20 * f2 + this.m21 * f3 + this.m22 * f4;
                this.m33 += this.m30 * f2 + this.m31 * f3 + this.m32 * f4;
            } else {
                this.mul(TEMPMAT4.setIdentity().setTranslation(f2, f3, f4));
            }
        }
        return this;
    }

    public void getTranslation(Tuple3f tuple3f) {
        tuple3f.set(this.m03, this.m13, this.m23);
    }

    public Matrix4f setTranslation(Tuple3f tuple3f) {
        return this.setTranslation(tuple3f.x, tuple3f.y, tuple3f.z);
    }

    public Matrix4f setTranslation(float f2, float f3, float f4) {
        this.m03 = f2;
        this.m13 = f3;
        this.m23 = f4;
        return this;
    }

    public static void interpolate(Matrix4f matrix4f, Matrix4f matrix4f2, Matrix4f matrix4f3, float f2) {
        matrix4f3.m00 = Util.interpolate(matrix4f.m00, matrix4f2.m00, f2);
        matrix4f3.m01 = Util.interpolate(matrix4f.m01, matrix4f2.m01, f2);
        matrix4f3.m02 = Util.interpolate(matrix4f.m02, matrix4f2.m02, f2);
        matrix4f3.m03 = Util.interpolate(matrix4f.m03, matrix4f2.m03, f2);
        matrix4f3.m10 = Util.interpolate(matrix4f.m10, matrix4f2.m10, f2);
        matrix4f3.m11 = Util.interpolate(matrix4f.m11, matrix4f2.m11, f2);
        matrix4f3.m12 = Util.interpolate(matrix4f.m12, matrix4f2.m12, f2);
        matrix4f3.m13 = Util.interpolate(matrix4f.m13, matrix4f2.m13, f2);
        matrix4f3.m20 = Util.interpolate(matrix4f.m20, matrix4f2.m20, f2);
        matrix4f3.m21 = Util.interpolate(matrix4f.m21, matrix4f2.m21, f2);
        matrix4f3.m22 = Util.interpolate(matrix4f.m22, matrix4f2.m22, f2);
        matrix4f3.m23 = Util.interpolate(matrix4f.m23, matrix4f2.m23, f2);
        matrix4f3.m30 = Util.interpolate(matrix4f.m30, matrix4f2.m30, f2);
        matrix4f3.m31 = Util.interpolate(matrix4f.m31, matrix4f2.m31, f2);
        matrix4f3.m32 = Util.interpolate(matrix4f.m32, matrix4f2.m32, f2);
        matrix4f3.m33 = Util.interpolate(matrix4f.m33, matrix4f2.m33, f2);
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$math$algebra$Matrix4f == null ? (class$de$vw$mib$graphics$math$algebra$Matrix4f = Matrix4f.class$("de.vw.mib.graphics.math.algebra.Matrix4f")) : class$de$vw$mib$graphics$math$algebra$Matrix4f).desiredAssertionStatus();
        OPTIMIZE = Util.OPTIMIZE;
        OPTIMIZE_EQUALS = OPTIMIZE && System.getProperty("de.vw.mib.graphics.math.disableoptimizematrix4equals") == null;
        OPTIMIZE_BYPASS = OPTIMIZE && Util.OPTIMIZE_BYPASS;
        OPTIMIZE_SHORTCUT = OPTIMIZE && Util.OPTIMIZE_SHORTCUT;
        TEMPMAT4 = new Matrix4f();
        TEMPVEC4 = new Vector4f();
        IDENTITY = new Matrix4f(true);
    }
}

