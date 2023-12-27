/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.algebra;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.math.Tuple2f;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.AbstractMatrix;
import de.vw.mib.graphics.math.algebra.SingularMatrixException;
import de.vw.mib.graphics.math.algebra.Vector2f;
import de.vw.mib.util.StringBuilder;

public final class Matrix2f
extends AbstractMatrix {
    private static final long serialVersionUID;
    private static final boolean OPTIMIZE;
    private static final boolean OPTIMIZE_BYPASS;
    private static HashCodeBuilder hcb;
    private static Matrix2f TEMPMAT2;
    private static Vector2f TEMPVEC2;
    public static final int DIMENSION;
    public static final Matrix2f IDENTITY;
    private float m00;
    private float m01;
    private float m10;
    private float m11;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$math$algebra$Matrix2f;

    public Matrix2f() {
        this(false);
    }

    public Matrix2f(boolean bl) {
        if (bl) {
            this.setIdentity();
        }
    }

    public Matrix2f(Matrix2f matrix2f) {
        this();
        this.m00 = matrix2f.m00;
        this.m01 = matrix2f.m01;
        this.m10 = matrix2f.m10;
        this.m11 = matrix2f.m11;
    }

    public Matrix2f(float[] fArray) {
        this();
        if (!$assertionsDisabled && fArray.length < 4) {
            throw new AssertionError((Object)"Argument too small");
        }
        this.m00 = fArray[0];
        this.m10 = fArray[1];
        this.m01 = fArray[2];
        this.m11 = fArray[3];
    }

    @Override
    public Object clone() {
        Matrix2f matrix2f = (Matrix2f)super.clone();
        return matrix2f;
    }

    public int hashCode() {
        if (hcb == null) {
            hcb = new HashCodeBuilder();
        }
        hcb.reset();
        hcb.append(this.m00);
        hcb.append(this.m01);
        hcb.append(this.m10);
        hcb.append(this.m11);
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            Matrix2f matrix2f = (Matrix2f)object;
            if (Util.IDENTITY_EQUALS) {
                return this.m00 == matrix2f.m00 && this.m01 == matrix2f.m01 && this.m10 == matrix2f.m10 && this.m11 == matrix2f.m11;
            }
            if (Util.EXACT_EQUALS) {
                return Float.compare(this.m00, matrix2f.m00) == 0 && Float.compare(this.m01, matrix2f.m01) == 0 && Float.compare(this.m10, matrix2f.m10) == 0 && Float.compare(this.m11, matrix2f.m11) == 0;
            }
            return Util.equalsEpsilon(this.m00, matrix2f.m00) && Util.equalsEpsilon(this.m01, matrix2f.m01) && Util.equalsEpsilon(this.m10, matrix2f.m10) && Util.equalsEpsilon(this.m11, matrix2f.m11);
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[m00=").append(this.m00);
        stringBuilder.append(",m01=").append(this.m01);
        stringBuilder.append(",m10=").append(this.m10);
        stringBuilder.append(",m11=").append(this.m11);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public int getDimension() {
        return 2;
    }

    public Matrix2f set(Matrix2f matrix2f) {
        if (this != matrix2f) {
            this.m00 = matrix2f.m00;
            this.m01 = matrix2f.m01;
            this.m10 = matrix2f.m10;
            this.m11 = matrix2f.m11;
        }
        return this;
    }

    public Matrix2f set(float f2, float f3, float f4, float f5) {
        this.m00 = f2;
        this.m01 = f3;
        this.m10 = f4;
        this.m11 = f5;
        return this;
    }

    public void get(float[] fArray) {
        this.get(fArray, 0);
    }

    public void get(float[] fArray, int n) {
        if (!$assertionsDisabled && fArray.length < n + 4) {
            throw new AssertionError((Object)"Argument too small");
        }
        fArray[n++] = this.m00;
        fArray[n++] = this.m10;
        fArray[n++] = this.m01;
        fArray[n++] = this.m11;
    }

    public Matrix2f set(float[] fArray) {
        return this.set(fArray, 0);
    }

    public Matrix2f set(float[] fArray, int n) {
        if (!$assertionsDisabled && fArray.length < n + 4) {
            throw new AssertionError((Object)"Argument too small");
        }
        this.m00 = fArray[n++];
        this.m10 = fArray[n++];
        this.m01 = fArray[n++];
        this.m11 = fArray[n++];
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
                }
                throw new IllegalArgumentException();
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    public void getColumn(int n, Tuple2f tuple2f) {
        switch (n) {
            case 0: {
                tuple2f.set(this.m00, this.m10);
                break;
            }
            case 1: {
                tuple2f.set(this.m01, this.m11);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid column index");
            }
        }
    }

    public void getColumn(int n, float[] fArray) {
        if (!$assertionsDisabled && fArray.length < 2) {
            throw new AssertionError((Object)"Argument too small");
        }
        switch (n) {
            case 0: {
                fArray[0] = this.m00;
                fArray[1] = this.m10;
                break;
            }
            case 1: {
                fArray[0] = this.m01;
                fArray[1] = this.m11;
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid column index");
            }
        }
    }

    public Matrix2f setColumn(int n, Tuple2f tuple2f) {
        return this.setColumn(n, tuple2f.x, tuple2f.y);
    }

    public Matrix2f setColumn(int n, float f2, float f3) {
        switch (n) {
            case 0: {
                this.m00 = f2;
                this.m10 = f3;
                break;
            }
            case 1: {
                this.m01 = f2;
                this.m11 = f3;
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid column index");
            }
        }
        return this;
    }

    public void getRow(int n, Tuple2f tuple2f) {
        switch (n) {
            case 0: {
                tuple2f.set(this.m00, this.m01);
                break;
            }
            case 1: {
                tuple2f.set(this.m10, this.m11);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid row index");
            }
        }
    }

    public void getRow(int n, float[] fArray) {
        if (!$assertionsDisabled && fArray.length < 2) {
            throw new AssertionError((Object)"Argument too small");
        }
        switch (n) {
            case 0: {
                fArray[0] = this.m00;
                fArray[1] = this.m01;
                break;
            }
            case 1: {
                fArray[0] = this.m10;
                fArray[1] = this.m11;
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid row index");
            }
        }
    }

    public Matrix2f setRow(int n, Tuple2f tuple2f) {
        return this.setRow(n, tuple2f.x, tuple2f.y);
    }

    public Matrix2f setRow(int n, float f2, float f3) {
        switch (n) {
            case 0: {
                this.m00 = f2;
                this.m01 = f3;
                break;
            }
            case 1: {
                this.m10 = f2;
                this.m11 = f3;
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid row index");
            }
        }
        return this;
    }

    public void getDiagonal(Tuple2f tuple2f) {
        tuple2f.set(this.m00, this.m11);
    }

    public void getDiagonal(float[] fArray) {
        if (!$assertionsDisabled && fArray.length < 2) {
            throw new AssertionError((Object)"Argument too small");
        }
        fArray[0] = this.m00;
        fArray[1] = this.m11;
    }

    public Matrix2f setDiagonal(Tuple2f tuple2f) {
        return this.setDiagonal(tuple2f.x, tuple2f.y);
    }

    public Matrix2f setDiagonal(float f2, float f3) {
        this.m00 = f2;
        this.m11 = f3;
        return this;
    }

    @Override
    public boolean isZero() {
        return Util.equalsEpsilon(this.m00, 0.0f) && Util.equalsEpsilon(this.m01, 0.0f) && Util.equalsEpsilon(this.m10, 0.0f) && Util.equalsEpsilon(this.m11, 0.0f);
    }

    public Matrix2f setZero() {
        this.m00 = 0.0f;
        this.m01 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 0.0f;
        return this;
    }

    @Override
    public boolean isIdentity() {
        return this.equals(IDENTITY);
    }

    public Matrix2f setIdentity() {
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        return this;
    }

    public void neg(Matrix2f matrix2f) {
        matrix2f.m00 = -this.m00;
        matrix2f.m01 = -this.m01;
        matrix2f.m10 = -this.m10;
        matrix2f.m11 = -this.m11;
    }

    public Matrix2f neg() {
        this.neg(this);
        return this;
    }

    public void add(Matrix2f matrix2f, Matrix2f matrix2f2) {
        matrix2f2.m00 = this.m00 + matrix2f.m00;
        matrix2f2.m01 = this.m01 + matrix2f.m01;
        matrix2f2.m10 = this.m10 + matrix2f.m10;
        matrix2f2.m11 = this.m11 + matrix2f.m11;
    }

    public Matrix2f add(Matrix2f matrix2f) {
        this.add(matrix2f, this);
        return this;
    }

    public Matrix2f add(float[] fArray) {
        if (!$assertionsDisabled && fArray.length < 4) {
            throw new AssertionError((Object)"Argument too small");
        }
        this.m00 += fArray[0];
        this.m10 += fArray[1];
        this.m01 += fArray[2];
        this.m11 += fArray[3];
        return this;
    }

    public void sub(Matrix2f matrix2f, Matrix2f matrix2f2) {
        matrix2f2.m00 = this.m00 - matrix2f.m00;
        matrix2f2.m01 = this.m01 - matrix2f.m01;
        matrix2f2.m10 = this.m10 - matrix2f.m10;
        matrix2f2.m11 = this.m11 - matrix2f.m11;
    }

    public Matrix2f sub(Matrix2f matrix2f) {
        this.sub(matrix2f, this);
        return this;
    }

    public Matrix2f sub(float[] fArray) {
        if (!$assertionsDisabled && fArray.length < 4) {
            throw new AssertionError((Object)"Argument too small");
        }
        this.m00 -= fArray[0];
        this.m10 -= fArray[1];
        this.m01 -= fArray[3];
        this.m11 -= fArray[4];
        return this;
    }

    public void mul(float f2, Matrix2f matrix2f) {
        matrix2f.m00 = this.m00 * f2;
        matrix2f.m01 = this.m01 * f2;
        matrix2f.m10 = this.m10 * f2;
        matrix2f.m11 = this.m11 * f2;
    }

    public Matrix2f mul(float f2) {
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

    public void mul(Matrix2f matrix2f, Matrix2f matrix2f2) {
        if (OPTIMIZE_BYPASS) {
            if (this.isIdentity()) {
                matrix2f2.set(matrix2f);
                return;
            }
            if (matrix2f.isIdentity()) {
                matrix2f2.set(this);
                return;
            }
        }
        float f2 = this.m00 * matrix2f.m00 + this.m01 * matrix2f.m10;
        float f3 = this.m00 * matrix2f.m01 + this.m01 * matrix2f.m11;
        float f4 = this.m10 * matrix2f.m00 + this.m11 * matrix2f.m10;
        float f5 = this.m10 * matrix2f.m01 + this.m11 * matrix2f.m11;
        matrix2f2.m00 = f2;
        matrix2f2.m01 = f3;
        matrix2f2.m10 = f4;
        matrix2f2.m11 = f5;
    }

    public Matrix2f mul(Matrix2f matrix2f) {
        this.mul(matrix2f, this);
        return this;
    }

    public void mulDiag(Tuple2f tuple2f, Matrix2f matrix2f) {
        matrix2f.m00 = this.m00 * tuple2f.x;
        matrix2f.m01 = this.m01 * tuple2f.x;
        matrix2f.m10 = this.m10 * tuple2f.y;
        matrix2f.m11 = this.m11 * tuple2f.y;
    }

    @Override
    public float getDeterminant() {
        return this.m00 * this.m11 - this.m01 * this.m10;
    }

    public void invert(Matrix2f matrix2f) {
        if (OPTIMIZE_BYPASS && this.isIdentity()) {
            matrix2f.setIdentity();
            return;
        }
        float f2 = this.getDeterminant();
        if (Util.equalsEpsilon(f2, 0.0f)) {
            throw new SingularMatrixException();
        }
        f2 = 1.0f / f2;
        float f3 = f2 * this.m11;
        float f4 = f2 * this.m00;
        float f5 = -f2 * this.m01;
        float f6 = -f2 * this.m10;
        matrix2f.m00 = f3;
        matrix2f.m01 = f5;
        matrix2f.m10 = f6;
        matrix2f.m11 = f4;
    }

    public Matrix2f invert() {
        this.invert(this);
        return this;
    }

    public void transpose(Matrix2f matrix2f) {
        if (this != matrix2f) {
            float f2 = this.m00;
            float f3 = this.m01;
            float f4 = this.m10;
            float f5 = this.m11;
            matrix2f.m00 = f2;
            matrix2f.m01 = f4;
            matrix2f.m10 = f3;
            matrix2f.m11 = f5;
        } else {
            this.transpose();
        }
    }

    public Matrix2f transpose() {
        float f2 = this.m01;
        this.m01 = this.m10;
        this.m10 = f2;
        return this;
    }

    public Matrix2f scale(float[] fArray) {
        return this.scale(fArray[0], fArray[1]);
    }

    public Matrix2f scale(Tuple2f tuple2f) {
        return this.scale(tuple2f.x, tuple2f.y);
    }

    public Matrix2f scale(float f2) {
        return this.scale(f2, f2);
    }

    public Matrix2f scale(float f2, float f3) {
        if (f2 != 1.0f || f3 != 1.0f) {
            if (OPTIMIZE) {
                this.m00 *= f2;
                this.m10 *= f2;
                this.m01 *= f3;
                this.m11 *= f3;
            } else {
                this.mul(TEMPMAT2.setIdentity().setScale(f2, f3));
            }
        }
        return this;
    }

    public void getScale(Tuple2f tuple2f) {
        float f2 = Util.sqrt(this.m00 * this.m00 + this.m10 * this.m10);
        float f3 = Util.sqrt(this.m01 * this.m01 + this.m11 * this.m11);
        tuple2f.set(f2, f3);
    }

    public Matrix2f setScale(Tuple2f tuple2f) {
        return this.setScale(tuple2f.x, tuple2f.y);
    }

    public Matrix2f setScale(float f2, float f3) {
        if (OPTIMIZE_BYPASS && this.isIdentity()) {
            this.setDiagonal(f2, f3);
        } else {
            this.getColumn(0, TEMPVEC2);
            TEMPVEC2.normalize().scale(f2);
            this.setColumn(0, TEMPVEC2);
            this.getColumn(1, TEMPVEC2);
            TEMPVEC2.normalize().scale(f3);
            this.setColumn(1, TEMPVEC2);
        }
        return this;
    }

    public Matrix2f rotate(float f2) {
        if (f2 != 0.0f) {
            this.mul(TEMPMAT2.setIdentity().setRotation(f2));
        }
        return this;
    }

    public Matrix2f setRotation(float f2) {
        if (f2 != 0.0f) {
            float f3;
            float f4 = Util.sin(f2);
            this.m00 = f3 = Util.cos(f2);
            this.m10 = f4;
            this.m01 = -f4;
            this.m11 = f3;
        } else {
            this.setIdentity();
        }
        return this;
    }

    public static void interpolate(Matrix2f matrix2f, Matrix2f matrix2f2, Matrix2f matrix2f3, float f2) {
        matrix2f3.m00 = Util.interpolate(matrix2f.m00, matrix2f2.m00, f2);
        matrix2f3.m01 = Util.interpolate(matrix2f.m01, matrix2f2.m01, f2);
        matrix2f3.m10 = Util.interpolate(matrix2f.m10, matrix2f2.m10, f2);
        matrix2f3.m11 = Util.interpolate(matrix2f.m11, matrix2f2.m11, f2);
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$math$algebra$Matrix2f == null ? (class$de$vw$mib$graphics$math$algebra$Matrix2f = Matrix2f.class$("de.vw.mib.graphics.math.algebra.Matrix2f")) : class$de$vw$mib$graphics$math$algebra$Matrix2f).desiredAssertionStatus();
        OPTIMIZE = Util.OPTIMIZE;
        OPTIMIZE_BYPASS = OPTIMIZE && Util.OPTIMIZE_BYPASS;
        TEMPMAT2 = new Matrix2f();
        TEMPVEC2 = new Vector2f();
        IDENTITY = new Matrix2f(true);
    }
}

