/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.algebra;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.math.Tuple2f;
import de.vw.mib.graphics.math.Tuple3f;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.AbstractMatrix;
import de.vw.mib.graphics.math.algebra.SingularMatrixException;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.util.StringBuilder;

public final class Matrix3f
extends AbstractMatrix {
    private static final long serialVersionUID;
    private static final boolean OPTIMIZE;
    private static final boolean OPTIMIZE_BYPASS;
    private static final boolean OPTIMIZE_SHORTCUT;
    private static HashCodeBuilder hcb;
    private static Matrix3f TEMPMAT3;
    private static Vector3f TEMPVEC3;
    public static final int DIMENSION;
    public static final Matrix3f IDENTITY;
    float m00;
    float m01;
    float m02;
    float m10;
    float m11;
    float m12;
    float m20;
    float m21;
    float m22;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$math$algebra$Matrix3f;

    public Matrix3f() {
        this(false);
    }

    public Matrix3f(boolean bl) {
        if (bl) {
            this.setIdentity();
        }
    }

    public Matrix3f(Matrix3f matrix3f) {
        this();
        this.m00 = matrix3f.m00;
        this.m01 = matrix3f.m01;
        this.m02 = matrix3f.m02;
        this.m10 = matrix3f.m10;
        this.m11 = matrix3f.m11;
        this.m12 = matrix3f.m12;
        this.m20 = matrix3f.m20;
        this.m21 = matrix3f.m21;
        this.m22 = matrix3f.m22;
    }

    public Matrix3f(float[] fArray) {
        this();
        if (!$assertionsDisabled && fArray.length < 9) {
            throw new AssertionError((Object)"Argument too small");
        }
        this.m00 = fArray[0];
        this.m10 = fArray[1];
        this.m20 = fArray[2];
        this.m01 = fArray[3];
        this.m11 = fArray[4];
        this.m21 = fArray[5];
        this.m02 = fArray[6];
        this.m12 = fArray[7];
        this.m22 = fArray[8];
    }

    @Override
    public Object clone() {
        Matrix3f matrix3f = (Matrix3f)super.clone();
        return matrix3f;
    }

    public int hashCode() {
        if (hcb == null) {
            hcb = new HashCodeBuilder();
        }
        hcb.reset();
        hcb.append(this.m00);
        hcb.append(this.m01);
        hcb.append(this.m02);
        hcb.append(this.m10);
        hcb.append(this.m11);
        hcb.append(this.m12);
        hcb.append(this.m20);
        hcb.append(this.m21);
        hcb.append(this.m22);
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            Matrix3f matrix3f = (Matrix3f)object;
            if (Util.IDENTITY_EQUALS) {
                return this.m00 == matrix3f.m00 && this.m01 == matrix3f.m01 && this.m02 == matrix3f.m02 && this.m10 == matrix3f.m10 && this.m11 == matrix3f.m11 && this.m12 == matrix3f.m12 && this.m20 == matrix3f.m20 && this.m21 == matrix3f.m21 && this.m22 == matrix3f.m22;
            }
            if (Util.EXACT_EQUALS) {
                return Float.compare(this.m00, matrix3f.m00) == 0 && Float.compare(this.m01, matrix3f.m01) == 0 && Float.compare(this.m02, matrix3f.m02) == 0 && Float.compare(this.m10, matrix3f.m10) == 0 && Float.compare(this.m11, matrix3f.m11) == 0 && Float.compare(this.m12, matrix3f.m12) == 0 && Float.compare(this.m20, matrix3f.m20) == 0 && Float.compare(this.m21, matrix3f.m21) == 0 && Float.compare(this.m22, matrix3f.m22) == 0;
            }
            return Util.equalsEpsilon(this.m00, matrix3f.m00) && Util.equalsEpsilon(this.m01, matrix3f.m01) && Util.equalsEpsilon(this.m02, matrix3f.m02) && Util.equalsEpsilon(this.m10, matrix3f.m10) && Util.equalsEpsilon(this.m11, matrix3f.m11) && Util.equalsEpsilon(this.m12, matrix3f.m12) && Util.equalsEpsilon(this.m20, matrix3f.m20) && Util.equalsEpsilon(this.m21, matrix3f.m21) && Util.equalsEpsilon(this.m22, matrix3f.m22);
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[m00=").append(this.m00);
        stringBuilder.append(",m01=").append(this.m01);
        stringBuilder.append(",m02=").append(this.m02);
        stringBuilder.append(",m10=").append(this.m10);
        stringBuilder.append(",m11=").append(this.m11);
        stringBuilder.append(",m12=").append(this.m12);
        stringBuilder.append(",m20=").append(this.m20);
        stringBuilder.append(",m21=").append(this.m21);
        stringBuilder.append(",m22=").append(this.m22);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public int getDimension() {
        return 3;
    }

    public Matrix3f set(Matrix3f matrix3f) {
        if (this != matrix3f) {
            this.m00 = matrix3f.m00;
            this.m01 = matrix3f.m01;
            this.m02 = matrix3f.m02;
            this.m10 = matrix3f.m10;
            this.m11 = matrix3f.m11;
            this.m12 = matrix3f.m12;
            this.m20 = matrix3f.m20;
            this.m21 = matrix3f.m21;
            this.m22 = matrix3f.m22;
        }
        return this;
    }

    public Matrix3f set(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.m00 = f2;
        this.m01 = f3;
        this.m02 = f4;
        this.m10 = f5;
        this.m11 = f6;
        this.m12 = f7;
        this.m20 = f8;
        this.m21 = f9;
        this.m22 = f10;
        return this;
    }

    public void get(float[] fArray) {
        this.get(fArray, 0);
    }

    public void get(float[] fArray, int n) {
        if (!$assertionsDisabled && fArray.length < n + 9) {
            throw new AssertionError((Object)"Argument too small");
        }
        fArray[n++] = this.m00;
        fArray[n++] = this.m10;
        fArray[n++] = this.m20;
        fArray[n++] = this.m01;
        fArray[n++] = this.m11;
        fArray[n++] = this.m21;
        fArray[n++] = this.m02;
        fArray[n++] = this.m12;
        fArray[n++] = this.m22;
    }

    public Matrix3f set(float[] fArray) {
        return this.set(fArray, 0);
    }

    public Matrix3f set(float[] fArray, int n) {
        if (!$assertionsDisabled && fArray.length < n + 9) {
            throw new AssertionError((Object)"Argument too small");
        }
        this.m00 = fArray[n++];
        this.m10 = fArray[n++];
        this.m20 = fArray[n++];
        this.m01 = fArray[n++];
        this.m11 = fArray[n++];
        this.m21 = fArray[n++];
        this.m02 = fArray[n++];
        this.m12 = fArray[n++];
        this.m22 = fArray[n++];
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
                }
                throw new IllegalArgumentException();
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    public void getColumn(int n, Tuple3f tuple3f) {
        switch (n) {
            case 0: {
                tuple3f.set(this.m00, this.m10, this.m20);
                break;
            }
            case 1: {
                tuple3f.set(this.m01, this.m11, this.m21);
                break;
            }
            case 2: {
                tuple3f.set(this.m02, this.m12, this.m22);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid column index");
            }
        }
    }

    public void getColumn(int n, float[] fArray) {
        if (!$assertionsDisabled && fArray.length < 3) {
            throw new AssertionError((Object)"Argument too small");
        }
        switch (n) {
            case 0: {
                fArray[0] = this.m00;
                fArray[1] = this.m10;
                fArray[2] = this.m20;
                break;
            }
            case 1: {
                fArray[0] = this.m01;
                fArray[1] = this.m11;
                fArray[2] = this.m21;
                break;
            }
            case 2: {
                fArray[0] = this.m02;
                fArray[1] = this.m12;
                fArray[2] = this.m22;
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid column index");
            }
        }
    }

    public Matrix3f setColumn(int n, Tuple3f tuple3f) {
        return this.setColumn(n, tuple3f.x, tuple3f.y, tuple3f.z);
    }

    public Matrix3f setColumn(int n, float f2, float f3, float f4) {
        switch (n) {
            case 0: {
                this.m00 = f2;
                this.m10 = f3;
                this.m20 = f4;
                break;
            }
            case 1: {
                this.m01 = f2;
                this.m11 = f3;
                this.m21 = f4;
                break;
            }
            case 2: {
                this.m02 = f2;
                this.m12 = f3;
                this.m22 = f4;
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid column index");
            }
        }
        return this;
    }

    public void getRow(int n, Tuple3f tuple3f) {
        switch (n) {
            case 0: {
                tuple3f.set(this.m00, this.m01, this.m02);
                break;
            }
            case 1: {
                tuple3f.set(this.m10, this.m11, this.m12);
                break;
            }
            case 2: {
                tuple3f.set(this.m20, this.m21, this.m22);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid row index");
            }
        }
    }

    public void getRow(int n, float[] fArray) {
        if (!$assertionsDisabled && fArray.length < 3) {
            throw new AssertionError((Object)"Argument too small");
        }
        switch (n) {
            case 0: {
                fArray[0] = this.m00;
                fArray[1] = this.m01;
                fArray[2] = this.m02;
                break;
            }
            case 1: {
                fArray[0] = this.m10;
                fArray[1] = this.m11;
                fArray[2] = this.m12;
                break;
            }
            case 2: {
                fArray[0] = this.m20;
                fArray[1] = this.m21;
                fArray[2] = this.m22;
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid row index");
            }
        }
    }

    public Matrix3f setRow(int n, Tuple3f tuple3f) {
        return this.setRow(n, tuple3f.x, tuple3f.y, tuple3f.z);
    }

    public Matrix3f setRow(int n, float f2, float f3, float f4) {
        switch (n) {
            case 0: {
                this.m00 = f2;
                this.m01 = f3;
                this.m02 = f4;
                break;
            }
            case 1: {
                this.m10 = f2;
                this.m11 = f3;
                this.m12 = f4;
                break;
            }
            case 2: {
                this.m20 = f2;
                this.m21 = f3;
                this.m22 = f4;
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid row index");
            }
        }
        return this;
    }

    public void getDiagonal(Tuple3f tuple3f) {
        tuple3f.set(this.m00, this.m11, this.m22);
    }

    public void getDiagonal(float[] fArray) {
        if (!$assertionsDisabled && fArray.length < 3) {
            throw new AssertionError((Object)"Argument too small");
        }
        fArray[0] = this.m00;
        fArray[1] = this.m11;
        fArray[2] = this.m22;
    }

    public Matrix3f setDiagonal(Tuple3f tuple3f) {
        return this.setDiagonal(tuple3f.x, tuple3f.y, tuple3f.z);
    }

    public Matrix3f setDiagonal(float f2, float f3, float f4) {
        this.m00 = f2;
        this.m11 = f3;
        this.m22 = f4;
        return this;
    }

    @Override
    public boolean isZero() {
        return Util.equalsEpsilon(this.m00, 0.0f) && Util.equalsEpsilon(this.m01, 0.0f) && Util.equalsEpsilon(this.m02, 0.0f) && Util.equalsEpsilon(this.m10, 0.0f) && Util.equalsEpsilon(this.m11, 0.0f) && Util.equalsEpsilon(this.m12, 0.0f) && Util.equalsEpsilon(this.m20, 0.0f) && Util.equalsEpsilon(this.m21, 0.0f) && Util.equalsEpsilon(this.m22, 0.0f);
    }

    public Matrix3f setZero() {
        this.m00 = 0.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 0.0f;
        this.m12 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 0.0f;
        return this;
    }

    @Override
    public boolean isIdentity() {
        return this.equals(IDENTITY);
    }

    public Matrix3f setIdentity() {
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m12 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 1.0f;
        return this;
    }

    public void neg(Matrix3f matrix3f) {
        matrix3f.m00 = -this.m00;
        matrix3f.m01 = -this.m01;
        matrix3f.m02 = -this.m02;
        matrix3f.m10 = -this.m10;
        matrix3f.m11 = -this.m11;
        matrix3f.m12 = -this.m12;
        matrix3f.m20 = -this.m20;
        matrix3f.m21 = -this.m21;
        matrix3f.m22 = -this.m22;
    }

    public Matrix3f neg() {
        this.neg(this);
        return this;
    }

    public void add(Matrix3f matrix3f, Matrix3f matrix3f2) {
        matrix3f2.m00 = this.m00 + matrix3f.m00;
        matrix3f2.m01 = this.m01 + matrix3f.m01;
        matrix3f2.m02 = this.m02 + matrix3f.m02;
        matrix3f2.m10 = this.m10 + matrix3f.m10;
        matrix3f2.m11 = this.m11 + matrix3f.m11;
        matrix3f2.m12 = this.m12 + matrix3f.m12;
        matrix3f2.m20 = this.m20 + matrix3f.m20;
        matrix3f2.m21 = this.m21 + matrix3f.m21;
        matrix3f2.m22 = this.m22 + matrix3f.m22;
    }

    public Matrix3f add(Matrix3f matrix3f) {
        this.add(matrix3f, this);
        return this;
    }

    public Matrix3f add(float[] fArray) {
        if (!$assertionsDisabled && fArray.length < 9) {
            throw new AssertionError((Object)"Argument too small");
        }
        this.m00 += fArray[0];
        this.m10 += fArray[1];
        this.m20 += fArray[2];
        this.m01 += fArray[3];
        this.m11 += fArray[4];
        this.m21 += fArray[5];
        this.m02 += fArray[6];
        this.m12 += fArray[7];
        this.m22 += fArray[8];
        return this;
    }

    public void sub(Matrix3f matrix3f, Matrix3f matrix3f2) {
        matrix3f2.m00 = this.m00 - matrix3f.m00;
        matrix3f2.m01 = this.m01 - matrix3f.m01;
        matrix3f2.m02 = this.m02 - matrix3f.m02;
        matrix3f2.m10 = this.m10 - matrix3f.m10;
        matrix3f2.m11 = this.m11 - matrix3f.m11;
        matrix3f2.m12 = this.m12 - matrix3f.m12;
        matrix3f2.m20 = this.m20 - matrix3f.m20;
        matrix3f2.m21 = this.m21 - matrix3f.m21;
        matrix3f2.m22 = this.m22 - matrix3f.m22;
    }

    public Matrix3f sub(Matrix3f matrix3f) {
        this.sub(matrix3f, this);
        return this;
    }

    public Matrix3f sub(float[] fArray) {
        if (!$assertionsDisabled && fArray.length < 9) {
            throw new AssertionError((Object)"Argument too small");
        }
        this.m00 -= fArray[0];
        this.m10 -= fArray[1];
        this.m20 -= fArray[2];
        this.m01 -= fArray[3];
        this.m11 -= fArray[4];
        this.m21 -= fArray[5];
        this.m02 -= fArray[6];
        this.m12 -= fArray[7];
        this.m22 -= fArray[8];
        return this;
    }

    public void mul(float f2, Matrix3f matrix3f) {
        matrix3f.m00 = this.m00 * f2;
        matrix3f.m01 = this.m01 * f2;
        matrix3f.m02 = this.m02 * f2;
        matrix3f.m10 = this.m10 * f2;
        matrix3f.m11 = this.m11 * f2;
        matrix3f.m12 = this.m12 * f2;
        matrix3f.m20 = this.m20 * f2;
        matrix3f.m21 = this.m21 * f2;
        matrix3f.m22 = this.m22 * f2;
    }

    public Matrix3f mul(float f2) {
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

    public void mul(Matrix3f matrix3f, Matrix3f matrix3f2) {
        if (OPTIMIZE_BYPASS) {
            if (this.isIdentity()) {
                matrix3f2.set(matrix3f);
                return;
            }
            if (matrix3f.isIdentity()) {
                matrix3f2.set(this);
                return;
            }
        }
        float f2 = this.m00 * matrix3f.m00 + this.m01 * matrix3f.m10 + this.m02 * matrix3f.m20;
        float f3 = this.m00 * matrix3f.m01 + this.m01 * matrix3f.m11 + this.m02 * matrix3f.m21;
        float f4 = this.m00 * matrix3f.m02 + this.m01 * matrix3f.m12 + this.m02 * matrix3f.m22;
        float f5 = this.m10 * matrix3f.m00 + this.m11 * matrix3f.m10 + this.m12 * matrix3f.m20;
        float f6 = this.m10 * matrix3f.m01 + this.m11 * matrix3f.m11 + this.m12 * matrix3f.m21;
        float f7 = this.m10 * matrix3f.m02 + this.m11 * matrix3f.m12 + this.m12 * matrix3f.m22;
        float f8 = this.m20 * matrix3f.m00 + this.m21 * matrix3f.m10 + this.m22 * matrix3f.m20;
        float f9 = this.m20 * matrix3f.m01 + this.m21 * matrix3f.m11 + this.m22 * matrix3f.m21;
        float f10 = this.m20 * matrix3f.m02 + this.m21 * matrix3f.m12 + this.m22 * matrix3f.m22;
        matrix3f2.m00 = f2;
        matrix3f2.m01 = f3;
        matrix3f2.m02 = f4;
        matrix3f2.m10 = f5;
        matrix3f2.m11 = f6;
        matrix3f2.m12 = f7;
        matrix3f2.m20 = f8;
        matrix3f2.m21 = f9;
        matrix3f2.m22 = f10;
    }

    public Matrix3f mul(Matrix3f matrix3f) {
        this.mul(matrix3f, this);
        return this;
    }

    public void mulDiag(Tuple3f tuple3f, Matrix3f matrix3f) {
        matrix3f.m00 = this.m00 * tuple3f.x;
        matrix3f.m01 = this.m01 * tuple3f.x;
        matrix3f.m02 = this.m02 * tuple3f.x;
        matrix3f.m10 = this.m10 * tuple3f.y;
        matrix3f.m11 = this.m11 * tuple3f.y;
        matrix3f.m12 = this.m12 * tuple3f.y;
        matrix3f.m20 = this.m20 * tuple3f.z;
        matrix3f.m21 = this.m21 * tuple3f.z;
        matrix3f.m22 = this.m22 * tuple3f.z;
    }

    @Override
    public float getDeterminant() {
        return this.m00 * (this.m11 * this.m22 - this.m21 * this.m12) - this.m01 * (this.m10 * this.m22 - this.m20 * this.m12) + this.m02 * (this.m10 * this.m21 - this.m20 * this.m11);
    }

    public void invert(Matrix3f matrix3f) {
        if (OPTIMIZE_BYPASS && this.isIdentity()) {
            matrix3f.setIdentity();
            return;
        }
        if (OPTIMIZE) {
            float f2 = this.m11 * this.m22 - this.m21 * this.m12;
            float f3 = this.m20 * this.m12 - this.m10 * this.m22;
            float f4 = this.m10 * this.m21 - this.m20 * this.m11;
            float f5 = this.m00 * f2 + this.m01 * f3 + this.m02 * f4;
            if (Util.equalsEpsilon(f5, 0.0f)) {
                throw new SingularMatrixException();
            }
            f5 = 1.0f / f5;
            float f6 = f5 * f2;
            float f7 = f5 * f3;
            float f8 = f5 * f4;
            float f9 = f5 * (this.m21 * this.m02 - this.m01 * this.m22);
            float f10 = f5 * (this.m00 * this.m22 - this.m20 * this.m02);
            float f11 = f5 * (this.m20 * this.m01 - this.m00 * this.m21);
            float f12 = f5 * (this.m01 * this.m12 - this.m11 * this.m02);
            float f13 = f5 * (this.m10 * this.m02 - this.m00 * this.m12);
            float f14 = f5 * (this.m00 * this.m11 - this.m10 * this.m01);
            matrix3f.m00 = f6;
            matrix3f.m01 = f9;
            matrix3f.m02 = f12;
            matrix3f.m10 = f7;
            matrix3f.m11 = f10;
            matrix3f.m12 = f13;
            matrix3f.m20 = f8;
            matrix3f.m21 = f11;
            matrix3f.m22 = f14;
        } else {
            float f15 = this.getDeterminant();
            if (Util.equalsEpsilon(f15, 0.0f)) {
                throw new SingularMatrixException();
            }
            f15 = 1.0f / f15;
            float f16 = f15 * (this.m11 * this.m22 - this.m12 * this.m21);
            float f17 = f15 * (this.m02 * this.m21 - this.m01 * this.m22);
            float f18 = f15 * (this.m01 * this.m12 - this.m02 * this.m11);
            float f19 = f15 * (this.m12 * this.m20 - this.m10 * this.m22);
            float f20 = f15 * (this.m00 * this.m22 - this.m02 * this.m20);
            float f21 = f15 * (this.m02 * this.m10 - this.m00 * this.m12);
            float f22 = f15 * (this.m10 * this.m21 - this.m11 * this.m20);
            float f23 = f15 * (this.m01 * this.m20 - this.m00 * this.m21);
            float f24 = f15 * (this.m00 * this.m11 - this.m01 * this.m10);
            matrix3f.m00 = f16;
            matrix3f.m01 = f17;
            matrix3f.m02 = f18;
            matrix3f.m10 = f19;
            matrix3f.m11 = f20;
            matrix3f.m12 = f21;
            matrix3f.m20 = f22;
            matrix3f.m21 = f23;
            matrix3f.m22 = f24;
        }
    }

    public Matrix3f invert() {
        this.invert(this);
        return this;
    }

    public void transpose(Matrix3f matrix3f) {
        if (this != matrix3f) {
            matrix3f.m00 = this.m00;
            matrix3f.m01 = this.m10;
            matrix3f.m02 = this.m20;
            matrix3f.m10 = this.m01;
            matrix3f.m11 = this.m11;
            matrix3f.m12 = this.m21;
            matrix3f.m20 = this.m02;
            matrix3f.m21 = this.m12;
            matrix3f.m22 = this.m22;
        } else {
            this.transpose();
        }
    }

    public Matrix3f transpose() {
        float f2 = this.m01;
        this.m01 = this.m10;
        this.m10 = f2;
        f2 = this.m02;
        this.m02 = this.m20;
        this.m20 = f2;
        f2 = this.m12;
        this.m12 = this.m21;
        this.m21 = f2;
        return this;
    }

    public Matrix3f scale(float[] fArray) {
        return this.scale(fArray[0], fArray[1], fArray[2]);
    }

    public Matrix3f scale(Tuple3f tuple3f) {
        return this.scale(tuple3f.x, tuple3f.y, tuple3f.z);
    }

    public Matrix3f scale(float f2) {
        return this.scale(f2, f2, f2);
    }

    public Matrix3f scale(float f2, float f3, float f4) {
        if (f2 != 1.0f || f3 != 1.0f || f4 != 1.0f) {
            if (OPTIMIZE_SHORTCUT) {
                this.m00 *= f2;
                this.m10 *= f2;
                this.m20 *= f2;
                this.m01 *= f3;
                this.m11 *= f3;
                this.m21 *= f3;
                this.m02 *= f4;
                this.m12 *= f4;
                this.m22 *= f4;
            } else {
                this.mul(TEMPMAT3.setIdentity().setScale(f2, f3, f4));
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

    public Matrix3f setScale(Tuple3f tuple3f) {
        return this.setScale(tuple3f.x, tuple3f.y, tuple3f.z);
    }

    public Matrix3f setScale(float f2, float f3, float f4) {
        if (OPTIMIZE_BYPASS && this.isIdentity()) {
            this.setDiagonal(f2, f3, f4);
        } else {
            this.getColumn(0, TEMPVEC3);
            TEMPVEC3.normalize().scale(f2);
            this.setColumn(0, TEMPVEC3);
            this.getColumn(1, TEMPVEC3);
            TEMPVEC3.normalize().scale(f3);
            this.setColumn(1, TEMPVEC3);
            this.getColumn(2, TEMPVEC3);
            TEMPVEC3.normalize().scale(f4);
            this.setColumn(2, TEMPVEC3);
        }
        return this;
    }

    public Matrix3f rotate(float f2, float f3, float f4, float f5) {
        if (f2 != 0.0f) {
            this.mul(TEMPMAT3.setIdentity().setRotation(f2, f3, f4, f5));
        }
        return this;
    }

    public Matrix3f setRotation(float f2, float f3, float f4, float f5) {
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
            this.setIdentity();
        }
        return this;
    }

    protected Matrix3f setRotationAboutAxis(float f2, float f3, float f4, float f5) {
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
                this.m00 = (float)((d9 * d4 * d4 + d8) * (double)f7);
                this.m01 = (float)((d9 * d11 - d7 * d6) * (double)f7);
                this.m02 = (float)((d9 * d10 + d7 * d5) * (double)f8);
                this.m10 = (float)((d9 * d11 + d7 * d6) * (double)f6);
                this.m11 = (float)((d9 * d5 * d5 + d8) * (double)f7);
                this.m12 = (float)((d9 * d12 - d7 * d4) * (double)f8);
                this.m20 = (float)((d9 * d10 - d7 * d5) * (double)f6);
                this.m21 = (float)((d9 * d12 + d7 * d4) * (double)f7);
                this.m22 = (float)((d9 * d6 * d6 + d8) * (double)f8);
            } else {
                this.setIdentity();
            }
        } else {
            this.setIdentity();
        }
        return this;
    }

    protected Matrix3f setRotationAboutAxis2(Vector3f vector3f, float f2) {
        if (f2 != 0.0f) {
            float f3 = Util.cos(f2);
            float f4 = Util.sin(f2);
            float f5 = 1.0f - f3;
            float f6 = vector3f.getX();
            float f7 = vector3f.getY();
            float f8 = vector3f.getZ();
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
            this.setIdentity();
        }
        return this;
    }

    protected Matrix3f setRotationAboutX(float f2) {
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
            this.setIdentity();
        }
        return this;
    }

    protected Matrix3f setRotationAboutY(float f2) {
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
            this.setIdentity();
        }
        return this;
    }

    protected Matrix3f setRotationAboutZ(float f2) {
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
            this.setIdentity();
        }
        return this;
    }

    public Matrix3f setRotationAboutXYZ(float f2, float f3, float f4) {
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
            this.setIdentity();
        }
        return this;
    }

    public static void interpolate(Matrix3f matrix3f, Matrix3f matrix3f2, Matrix3f matrix3f3, float f2) {
        matrix3f3.m00 = Util.interpolate(matrix3f.m00, matrix3f2.m00, f2);
        matrix3f3.m01 = Util.interpolate(matrix3f.m01, matrix3f2.m01, f2);
        matrix3f3.m02 = Util.interpolate(matrix3f.m02, matrix3f2.m02, f2);
        matrix3f3.m10 = Util.interpolate(matrix3f.m10, matrix3f2.m10, f2);
        matrix3f3.m11 = Util.interpolate(matrix3f.m11, matrix3f2.m11, f2);
        matrix3f3.m12 = Util.interpolate(matrix3f.m12, matrix3f2.m12, f2);
        matrix3f3.m20 = Util.interpolate(matrix3f.m20, matrix3f2.m20, f2);
        matrix3f3.m21 = Util.interpolate(matrix3f.m21, matrix3f2.m21, f2);
        matrix3f3.m22 = Util.interpolate(matrix3f.m22, matrix3f2.m22, f2);
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$math$algebra$Matrix3f == null ? (class$de$vw$mib$graphics$math$algebra$Matrix3f = Matrix3f.class$("de.vw.mib.graphics.math.algebra.Matrix3f")) : class$de$vw$mib$graphics$math$algebra$Matrix3f).desiredAssertionStatus();
        OPTIMIZE = Util.OPTIMIZE;
        OPTIMIZE_BYPASS = OPTIMIZE && Util.OPTIMIZE_BYPASS;
        OPTIMIZE_SHORTCUT = OPTIMIZE && Util.OPTIMIZE_SHORTCUT;
        TEMPMAT3 = new Matrix3f();
        TEMPVEC3 = new Vector3f();
        IDENTITY = new Matrix3f(true);
    }
}

