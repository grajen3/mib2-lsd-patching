/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.number;

import de.vw.mib.graphics.math.Tuple4f;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.math.number.Quaternion;

public class Quaternion4f
extends Tuple4f
implements Quaternion {
    private static final long serialVersionUID;
    private static final boolean OPTIMIZE;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$math$number$Quaternion4f;

    public Quaternion4f() {
        this(false);
    }

    public Quaternion4f(boolean bl) {
        if (bl) {
            this.setIdentity();
        }
    }

    public Quaternion4f(Quaternion4f quaternion4f) {
        super(quaternion4f);
    }

    public Quaternion4f(float[] fArray) {
        super(fArray);
    }

    public Quaternion4f(float f2, float f3, float f4, float f5) {
        super(f2, f3, f4, f5);
    }

    public final float getReal() {
        return this.w;
    }

    public final void getImaginary(Vector3f vector3f) {
        vector3f.set(this.x, this.y, this.z);
    }

    @Override
    public final boolean isIdentity() {
        return Util.equalsEpsilon(this.x, 0.0f) && Util.equalsEpsilon(this.y, 0.0f) && Util.equalsEpsilon(this.z, 0.0f) && Util.equalsEpsilon(this.w, 1.0f);
    }

    public final Quaternion4f setIdentity() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.w = 1.0f;
        return this;
    }

    public final Quaternion4f mul(Quaternion4f quaternion4f) {
        this.mul(quaternion4f, this);
        return this;
    }

    public final void mul(Quaternion4f quaternion4f, Quaternion4f quaternion4f2) {
        float f2 = this.w * quaternion4f.x + this.x * quaternion4f.w + this.y * quaternion4f.z - this.z * quaternion4f.y;
        float f3 = this.w * quaternion4f.y - this.x * quaternion4f.z + this.y * quaternion4f.w + this.z * quaternion4f.x;
        float f4 = this.w * quaternion4f.z + this.x * quaternion4f.y - this.y * quaternion4f.x + this.z * quaternion4f.w;
        float f5 = this.w * quaternion4f.w - this.x * quaternion4f.x - this.y * quaternion4f.y - this.z * quaternion4f.z;
        quaternion4f2.x = f2;
        quaternion4f2.y = f3;
        quaternion4f2.z = f4;
        quaternion4f2.w = f5;
    }

    public final float dot(Quaternion4f quaternion4f) {
        return this.x * quaternion4f.x + this.y * quaternion4f.y + this.z * quaternion4f.z + this.w * quaternion4f.w;
    }

    protected final float getLengthSquared() {
        return this.dot(this);
    }

    @Override
    public final float getLength() {
        return Util.sqrt(this.getLengthSquared());
    }

    public final Quaternion4f normalize() {
        this.normalize(this);
        return this;
    }

    public final void normalize(Quaternion4f quaternion4f) {
        if (OPTIMIZE) {
            float f2 = this.getLengthSquared();
            if (!Util.equalsEpsilon(f2, 1.0f)) {
                this.scale(Util.invSqrt(f2), (Tuple4f)quaternion4f);
            }
        } else {
            float f3 = this.getLength();
            if (f3 >= -1120434635) {
                this.scale(1.0f / f3, (Tuple4f)quaternion4f);
            }
        }
    }

    @Override
    public final boolean isNormalized() {
        if (OPTIMIZE) {
            return Util.equalsEpsilon(this.getLengthSquared(), 1.0f);
        }
        return Util.equalsEpsilon(this.getLength(), 1.0f);
    }

    public final Quaternion4f conjugate() {
        this.conjugate(this);
        return this;
    }

    public final void conjugate(Quaternion4f quaternion4f) {
        quaternion4f.x = -this.x;
        quaternion4f.y = -this.y;
        quaternion4f.z = -this.z;
        quaternion4f.w = this.w;
    }

    public final Quaternion4f invert() {
        this.invert(this);
        return this;
    }

    public final void invert(Quaternion4f quaternion4f) {
        if (!$assertionsDisabled && this.isZero()) {
            throw new AssertionError();
        }
        float f2 = this.getLengthSquared();
        this.conjugate(quaternion4f);
        if (OPTIMIZE) {
            if (!Util.equalsEpsilon(f2, 1.0f)) {
                quaternion4f.scale(1.0f / f2);
            }
        } else if (this.isNormalized()) {
            quaternion4f.scale(1.0f / f2);
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$math$number$Quaternion4f == null ? (class$de$vw$mib$graphics$math$number$Quaternion4f = Quaternion4f.class$("de.vw.mib.graphics.math.number.Quaternion4f")) : class$de$vw$mib$graphics$math$number$Quaternion4f).desiredAssertionStatus();
        OPTIMIZE = Util.OPTIMIZE;
    }
}

