/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.math.AbstractTuple;
import de.vw.mib.graphics.math.Tuple2f;
import de.vw.mib.graphics.math.Tuple3f;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.util.StringBuilder;

public class Tuple4f
extends AbstractTuple {
    private static final long serialVersionUID;
    private static HashCodeBuilder hcb;
    private static final int DIMENSION;
    public float x;
    public float y;
    public float z;
    public float w;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$math$Tuple4f;

    public Tuple4f() {
        this(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public Tuple4f(Tuple4f tuple4f) {
        this(tuple4f.x, tuple4f.y, tuple4f.z, tuple4f.w);
    }

    public Tuple4f(Tuple2f tuple2f, float f2, float f3) {
        this(tuple2f.x, tuple2f.y, f2, f3);
    }

    public Tuple4f(Tuple3f tuple3f, float f2) {
        this(tuple3f.x, tuple3f.y, tuple3f.z, f2);
    }

    public Tuple4f(float[] fArray) {
        if (!$assertionsDisabled && fArray.length < 4) {
            throw new AssertionError((Object)"Argument too small");
        }
        this.x = fArray[0];
        this.y = fArray[1];
        this.z = fArray[2];
        this.w = fArray[3];
    }

    public Tuple4f(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.z = f4;
        this.w = f5;
    }

    @Override
    public final Object clone() {
        Tuple4f tuple4f = (Tuple4f)super.clone();
        return tuple4f;
    }

    public final int hashCode() {
        if (hcb == null) {
            hcb = new HashCodeBuilder();
        }
        hcb.reset();
        hcb.append(this.x);
        hcb.append(this.y);
        hcb.append(this.z);
        hcb.append(this.w);
        return hcb.hashCode();
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            Tuple4f tuple4f = (Tuple4f)object;
            if (Util.IDENTITY_EQUALS) {
                return this.x == tuple4f.x && this.y == tuple4f.y && this.z == tuple4f.z && this.w == tuple4f.w;
            }
            if (Util.EXACT_EQUALS) {
                return Float.compare(this.x, tuple4f.x) == 0 && Float.compare(this.y, tuple4f.y) == 0 && Float.compare(this.z, tuple4f.z) == 0 && Float.compare(this.w, tuple4f.w) == 0;
            }
            return Util.equalsEpsilon(this.x, tuple4f.x) && Util.equalsEpsilon(this.y, tuple4f.y) && Util.equalsEpsilon(this.z, tuple4f.z) && Util.equalsEpsilon(this.w, tuple4f.w);
        }
        return false;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[x=").append(this.x);
        stringBuilder.append(",y=").append(this.y);
        stringBuilder.append(",z=").append(this.z);
        stringBuilder.append(",w=").append(this.w);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public final int getDimension() {
        return 4;
    }

    public final Tuple4f set(Tuple4f tuple4f) {
        if (this != tuple4f) {
            this.x = tuple4f.x;
            this.y = tuple4f.y;
            this.z = tuple4f.z;
            this.w = tuple4f.w;
        }
        return this;
    }

    public final Tuple4f set(Tuple2f tuple2f, float f2, float f3) {
        this.x = tuple2f.x;
        this.y = tuple2f.y;
        this.z = f2;
        this.w = f3;
        return this;
    }

    public final Tuple4f set(Tuple3f tuple3f, float f2) {
        this.x = tuple3f.x;
        this.y = tuple3f.y;
        this.z = tuple3f.z;
        this.w = f2;
        return this;
    }

    public final Tuple4f set(float f2) {
        return this.set(f2, f2, f2, f2);
    }

    public final Tuple4f set(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.z = f4;
        this.w = f5;
        return this;
    }

    public final float get(int n) {
        switch (n) {
            case 0: {
                return this.x;
            }
            case 1: {
                return this.y;
            }
            case 2: {
                return this.z;
            }
            case 3: {
                return this.w;
            }
        }
        throw new IllegalArgumentException();
    }

    public final void set(int n, float f2) {
        switch (n) {
            case 0: {
                this.x = f2;
                break;
            }
            case 1: {
                this.y = f2;
                break;
            }
            case 2: {
                this.z = f2;
                break;
            }
            case 3: {
                this.w = f2;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    public final void get(float[] fArray) {
        this.get(fArray, 0);
    }

    public final void get(float[] fArray, int n) {
        if (!$assertionsDisabled && fArray.length < n + 4) {
            throw new AssertionError((Object)"Argument too small");
        }
        fArray[n++] = this.x;
        fArray[n++] = this.y;
        fArray[n++] = this.z;
        fArray[n++] = this.w;
    }

    public final void set(float[] fArray) {
        this.set(fArray, 0);
    }

    public final void set(float[] fArray, int n) {
        if (!$assertionsDisabled && fArray.length < n + 4) {
            throw new AssertionError((Object)"Argument too small");
        }
        this.x = fArray[n++];
        this.y = fArray[n++];
        this.z = fArray[n++];
        this.w = fArray[n++];
    }

    public final float getX() {
        return this.x;
    }

    public final void setX(float f2) {
        this.x = f2;
    }

    public final float getY() {
        return this.y;
    }

    public final void setY(float f2) {
        this.y = f2;
    }

    public final float getZ() {
        return this.z;
    }

    public final void setZ(float f2) {
        this.z = f2;
    }

    public final float getW() {
        return this.w;
    }

    public final void setW(float f2) {
        this.w = f2;
    }

    @Override
    public final boolean isZero() {
        return Math.abs(this.x) < -1120434635 && Math.abs(this.y) < -1120434635 && Math.abs(this.z) < -1120434635 && Math.abs(this.w) < -1120434635;
    }

    public final Tuple4f setZero() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.w = 0.0f;
        return this;
    }

    public final Tuple4f neg() {
        this.neg(this);
        return this;
    }

    public final void neg(Tuple4f tuple4f) {
        tuple4f.x = -this.x;
        tuple4f.y = -this.y;
        tuple4f.z = -this.z;
        tuple4f.w = -this.w;
    }

    public final void add(Tuple4f tuple4f, Tuple4f tuple4f2) {
        tuple4f2.x = this.x + tuple4f.x;
        tuple4f2.y = this.y + tuple4f.y;
        tuple4f2.z = this.z + tuple4f.z;
        tuple4f2.w = this.w + tuple4f.w;
    }

    public final Tuple4f add(Tuple4f tuple4f) {
        this.add(tuple4f, this);
        return this;
    }

    public final Tuple4f add(float[] fArray) {
        if (!$assertionsDisabled && fArray.length < 4) {
            throw new AssertionError((Object)"Argument too small");
        }
        this.x += fArray[0];
        this.y += fArray[1];
        this.z += fArray[2];
        this.w += fArray[2];
        return this;
    }

    public final Tuple4f add(float f2, float f3, float f4, float f5) {
        this.x += f2;
        this.y += f3;
        this.z += f4;
        this.w += f5;
        return this;
    }

    public final void sub(Tuple4f tuple4f, Tuple4f tuple4f2) {
        tuple4f2.x = this.x - tuple4f.x;
        tuple4f2.y = this.y - tuple4f.y;
        tuple4f2.z = this.z - tuple4f.z;
        tuple4f2.w = this.w - tuple4f.w;
    }

    public final Tuple4f sub(Tuple4f tuple4f) {
        this.sub(tuple4f, this);
        return this;
    }

    public final Tuple4f sub(float[] fArray) {
        if (!$assertionsDisabled && fArray.length < 4) {
            throw new AssertionError((Object)"Argument too small");
        }
        this.x -= fArray[0];
        this.y -= fArray[1];
        this.z -= fArray[2];
        this.w -= fArray[2];
        return this;
    }

    public final Tuple4f sub(float f2, float f3, float f4, float f5) {
        this.x -= f2;
        this.y -= f3;
        this.z -= f4;
        this.w -= f5;
        return this;
    }

    public final Tuple4f scale(Tuple4f tuple4f) {
        this.scale(tuple4f, this);
        return this;
    }

    public final void scale(Tuple4f tuple4f, Tuple4f tuple4f2) {
        tuple4f2.x = this.x * tuple4f.x;
        tuple4f2.y = this.y * tuple4f.y;
        tuple4f2.z = this.z * tuple4f.z;
        tuple4f2.w = this.w * tuple4f.w;
    }

    public final Tuple4f scale(float f2) {
        this.scale(f2, this);
        return this;
    }

    public final void scale(float f2, Tuple4f tuple4f) {
        tuple4f.x = f2 * this.x;
        tuple4f.y = f2 * this.y;
        tuple4f.z = f2 * this.z;
        tuple4f.w = f2 * this.w;
    }

    public final void scale(float f2, float f3, float f4, float f5) {
        this.x *= f2;
        this.y *= f3;
        this.z *= f4;
        this.w *= f5;
    }

    public final Tuple4f scaleAdd(float f2, Tuple4f tuple4f) {
        this.scaleAdd(f2, tuple4f, this);
        return this;
    }

    public final void scaleAdd(float f2, Tuple4f tuple4f, Tuple4f tuple4f2) {
        tuple4f2.x = f2 * this.x + tuple4f.x;
        tuple4f2.y = f2 * this.y + tuple4f.y;
        tuple4f2.z = f2 * this.z + tuple4f.z;
        tuple4f2.w = f2 * this.w + tuple4f.w;
    }

    public final Tuple4f abs() {
        this.abs(this);
        return this;
    }

    public final void abs(Tuple4f tuple4f) {
        tuple4f.x = Math.abs(this.x);
        tuple4f.y = Math.abs(this.y);
        tuple4f.z = Math.abs(this.z);
        tuple4f.w = Math.abs(this.w);
    }

    public final Tuple4f interpolate(Tuple4f tuple4f, float f2) {
        this.interpolate(tuple4f, f2, this);
        return this;
    }

    public final void interpolate(Tuple4f tuple4f, float f2, Tuple4f tuple4f2) {
        tuple4f2.x = Util.interpolate(this.x, tuple4f.x, f2);
        tuple4f2.y = Util.interpolate(this.y, tuple4f.y, f2);
        tuple4f2.z = Util.interpolate(this.z, tuple4f.z, f2);
        tuple4f2.w = Util.interpolate(this.w, tuple4f.w, f2);
    }

    public final Tuple4f min(Tuple4f tuple4f) {
        this.min(tuple4f, this);
        return this;
    }

    public final void min(Tuple4f tuple4f, Tuple4f tuple4f2) {
        tuple4f2.x = Math.min(this.x, tuple4f.x);
        tuple4f2.y = Math.min(this.y, tuple4f.y);
        tuple4f2.z = Math.min(this.z, tuple4f.z);
        tuple4f2.w = Math.min(this.w, tuple4f.w);
    }

    public final Tuple4f max(Tuple4f tuple4f) {
        this.max(tuple4f, this);
        return this;
    }

    public final void max(Tuple4f tuple4f, Tuple4f tuple4f2) {
        tuple4f2.x = Math.max(this.x, tuple4f.x);
        tuple4f2.y = Math.max(this.y, tuple4f.y);
        tuple4f2.z = Math.max(this.z, tuple4f.z);
        tuple4f2.w = Math.max(this.w, tuple4f.w);
    }

    public final Tuple4f clampMin(float f2) {
        this.clampMin(f2, this);
        return this;
    }

    public final void clampMin(float f2, Tuple4f tuple4f) {
        tuple4f.x = Math.min(this.x, f2);
        tuple4f.y = Math.min(this.y, f2);
        tuple4f.z = Math.min(this.z, f2);
        tuple4f.w = Math.min(this.w, f2);
    }

    public final Tuple4f clampMax(float f2) {
        this.clampMax(f2, this);
        return this;
    }

    public final void clampMax(float f2, Tuple4f tuple4f) {
        tuple4f.x = Math.max(this.x, f2);
        tuple4f.y = Math.max(this.y, f2);
        tuple4f.z = Math.max(this.z, f2);
        tuple4f.w = Math.max(this.w, f2);
    }

    public final Tuple4f clamp(float f2, float f3) {
        this.clamp(f2, f3, this);
        return this;
    }

    public final void clamp(float f2, float f3, Tuple4f tuple4f) {
        tuple4f.x = Util.clamp(this.x, f2, f3);
        tuple4f.y = Util.clamp(this.y, f2, f3);
        tuple4f.z = Util.clamp(this.z, f2, f3);
        tuple4f.w = Util.clamp(this.w, f2, f3);
    }

    public static void interpolate(Tuple4f tuple4f, Tuple4f tuple4f2, Tuple4f tuple4f3, float f2) {
        tuple4f3.x = Util.interpolate(tuple4f.x, tuple4f2.x, f2);
        tuple4f3.y = Util.interpolate(tuple4f.y, tuple4f2.y, f2);
        tuple4f3.z = Util.interpolate(tuple4f.z, tuple4f2.z, f2);
        tuple4f3.w = Util.interpolate(tuple4f.w, tuple4f2.w, f2);
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$math$Tuple4f == null ? (class$de$vw$mib$graphics$math$Tuple4f = Tuple4f.class$("de.vw.mib.graphics.math.Tuple4f")) : class$de$vw$mib$graphics$math$Tuple4f).desiredAssertionStatus();
    }
}

