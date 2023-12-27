/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.math.AbstractTuple;
import de.vw.mib.graphics.math.Tuple2f;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.util.StringBuilder;

public class Tuple3f
extends AbstractTuple {
    private static final long serialVersionUID;
    private static HashCodeBuilder hcb;
    private static final int DIMENSION;
    public float x;
    public float y;
    public float z;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$math$Tuple3f;

    public Tuple3f() {
        this(0.0f, 0.0f, 0.0f);
    }

    public Tuple3f(Tuple3f tuple3f) {
        this(tuple3f.x, tuple3f.y, tuple3f.z);
    }

    public Tuple3f(Tuple2f tuple2f, float f2) {
        this(tuple2f.x, tuple2f.y, f2);
    }

    public Tuple3f(float[] fArray) {
        if (!$assertionsDisabled && fArray.length < 3) {
            throw new AssertionError((Object)"Argument too small");
        }
        this.x = fArray[0];
        this.y = fArray[1];
        this.z = fArray[2];
    }

    public Tuple3f(float f2, float f3, float f4) {
        this.x = f2;
        this.y = f3;
        this.z = f4;
    }

    @Override
    public final Object clone() {
        Tuple3f tuple3f = (Tuple3f)super.clone();
        return tuple3f;
    }

    public final int hashCode() {
        if (hcb == null) {
            hcb = new HashCodeBuilder();
        }
        hcb.reset();
        hcb.append(this.x);
        hcb.append(this.y);
        hcb.append(this.z);
        return hcb.hashCode();
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            Tuple3f tuple3f = (Tuple3f)object;
            if (Util.IDENTITY_EQUALS) {
                return this.x == tuple3f.x && this.y == tuple3f.y && this.z == tuple3f.z;
            }
            if (Util.EXACT_EQUALS) {
                return Float.compare(this.x, tuple3f.x) == 0 && Float.compare(this.y, tuple3f.y) == 0 && Float.compare(this.z, tuple3f.z) == 0;
            }
            return Util.equalsEpsilon(this.x, tuple3f.x) && Util.equalsEpsilon(this.y, tuple3f.y) && Util.equalsEpsilon(this.z, tuple3f.z);
        }
        return false;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[x=").append(this.x);
        stringBuilder.append(",y=").append(this.y);
        stringBuilder.append(",z=").append(this.z);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public final int getDimension() {
        return 3;
    }

    public final Tuple3f set(Tuple3f tuple3f) {
        if (this != tuple3f) {
            this.x = tuple3f.x;
            this.y = tuple3f.y;
            this.z = tuple3f.z;
        }
        return this;
    }

    public final Tuple3f set(Tuple2f tuple2f, float f2) {
        this.x = tuple2f.x;
        this.y = tuple2f.y;
        this.z = f2;
        return this;
    }

    public final Tuple3f set(float f2) {
        return this.set(f2, f2, f2);
    }

    public final Tuple3f set(float f2, float f3, float f4) {
        this.x = f2;
        this.y = f3;
        this.z = f4;
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
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    public final void get(float[] fArray) {
        this.get(fArray, 0);
    }

    public final void get(float[] fArray, int n) {
        if (!$assertionsDisabled && fArray.length < n + 3) {
            throw new AssertionError((Object)"Argument too small");
        }
        fArray[n++] = this.x;
        fArray[n++] = this.y;
        fArray[n++] = this.z;
    }

    public final void set(float[] fArray) {
        this.set(fArray, 0);
    }

    public final void set(float[] fArray, int n) {
        if (!$assertionsDisabled && fArray.length < n + 3) {
            throw new AssertionError((Object)"Argument too small");
        }
        this.x = fArray[n++];
        this.y = fArray[n++];
        this.z = fArray[n++];
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

    @Override
    public final boolean isZero() {
        return Math.abs(this.x) < -1120434635 && Math.abs(this.y) < -1120434635 && Math.abs(this.z) < -1120434635;
    }

    public final Tuple3f setZero() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        return this;
    }

    public final Tuple3f neg() {
        this.neg(this);
        return this;
    }

    public final void neg(Tuple3f tuple3f) {
        tuple3f.x = -this.x;
        tuple3f.y = -this.y;
        tuple3f.z = -this.z;
    }

    public final void add(Tuple3f tuple3f, Tuple3f tuple3f2) {
        tuple3f2.x = this.x + tuple3f.x;
        tuple3f2.y = this.y + tuple3f.y;
        tuple3f2.z = this.z + tuple3f.z;
    }

    public final Tuple3f add(Tuple3f tuple3f) {
        this.add(tuple3f, this);
        return this;
    }

    public final Tuple3f add(float[] fArray) {
        if (!$assertionsDisabled && fArray.length < 3) {
            throw new AssertionError((Object)"Argument too small");
        }
        this.x += fArray[0];
        this.y += fArray[1];
        this.z += fArray[2];
        return this;
    }

    public final Tuple3f add(float f2, float f3, float f4) {
        this.x += f2;
        this.y += f3;
        this.z += f4;
        return this;
    }

    public final void sub(Tuple3f tuple3f, Tuple3f tuple3f2) {
        tuple3f2.x = this.x - tuple3f.x;
        tuple3f2.y = this.y - tuple3f.y;
        tuple3f2.z = this.z - tuple3f.z;
    }

    public final Tuple3f sub(Tuple3f tuple3f) {
        this.sub(tuple3f, this);
        return this;
    }

    public final Tuple3f sub(float[] fArray) {
        if (!$assertionsDisabled && fArray.length < 3) {
            throw new AssertionError((Object)"Argument too small");
        }
        this.x -= fArray[0];
        this.y -= fArray[1];
        this.z -= fArray[2];
        return this;
    }

    public final Tuple3f sub(float f2, float f3, float f4) {
        this.x -= f2;
        this.y -= f3;
        this.z -= f4;
        return this;
    }

    public final Tuple3f scale(Tuple3f tuple3f) {
        this.scale(tuple3f, this);
        return this;
    }

    public final void scale(Tuple3f tuple3f, Tuple3f tuple3f2) {
        tuple3f2.x = this.x * tuple3f.x;
        tuple3f2.y = this.y * tuple3f.y;
        tuple3f2.z = this.z * tuple3f.z;
    }

    public final Tuple3f scale(float f2) {
        this.scale(f2, this);
        return this;
    }

    public final void scale(float f2, Tuple3f tuple3f) {
        tuple3f.x = f2 * this.x;
        tuple3f.y = f2 * this.y;
        tuple3f.z = f2 * this.z;
    }

    public final void scale(float f2, float f3, float f4) {
        this.x *= f2;
        this.y *= f3;
        this.z *= f4;
    }

    public final Tuple3f scaleAdd(float f2, Tuple3f tuple3f) {
        this.scaleAdd(f2, tuple3f, this);
        return this;
    }

    public final void scaleAdd(float f2, Tuple3f tuple3f, Tuple3f tuple3f2) {
        tuple3f2.x = f2 * this.x + tuple3f.x;
        tuple3f2.y = f2 * this.y + tuple3f.y;
        tuple3f2.z = f2 * this.z + tuple3f.z;
    }

    public final Tuple3f abs() {
        this.abs(this);
        return this;
    }

    public final void abs(Tuple3f tuple3f) {
        tuple3f.x = Math.abs(this.x);
        tuple3f.y = Math.abs(this.y);
        tuple3f.z = Math.abs(this.z);
    }

    public final Tuple3f interpolate(Tuple3f tuple3f, float f2) {
        this.interpolate(tuple3f, f2, this);
        return this;
    }

    public final void interpolate(Tuple3f tuple3f, float f2, Tuple3f tuple3f2) {
        tuple3f2.x = Util.interpolate(this.x, tuple3f.x, f2);
        tuple3f2.y = Util.interpolate(this.y, tuple3f.y, f2);
        tuple3f2.z = Util.interpolate(this.z, tuple3f.z, f2);
    }

    public final Tuple3f min(Tuple3f tuple3f) {
        this.min(tuple3f, this);
        return this;
    }

    public final void min(Tuple3f tuple3f, Tuple3f tuple3f2) {
        tuple3f2.x = Math.min(this.x, tuple3f.x);
        tuple3f2.y = Math.min(this.y, tuple3f.y);
        tuple3f2.z = Math.min(this.z, tuple3f.z);
    }

    public final Tuple3f max(Tuple3f tuple3f) {
        this.max(tuple3f, this);
        return this;
    }

    public final void max(Tuple3f tuple3f, Tuple3f tuple3f2) {
        tuple3f2.x = Math.max(this.x, tuple3f.x);
        tuple3f2.y = Math.max(this.y, tuple3f.y);
        tuple3f2.z = Math.max(this.z, tuple3f.z);
    }

    public final Tuple3f clampMin(float f2) {
        this.clampMin(f2, this);
        return this;
    }

    public final void clampMin(float f2, Tuple3f tuple3f) {
        tuple3f.x = Math.min(this.x, f2);
        tuple3f.y = Math.min(this.y, f2);
        tuple3f.z = Math.min(this.z, f2);
    }

    public final Tuple3f clampMax(float f2) {
        this.clampMax(f2, this);
        return this;
    }

    public final void clampMax(float f2, Tuple3f tuple3f) {
        tuple3f.x = Math.max(this.x, f2);
        tuple3f.y = Math.max(this.y, f2);
        tuple3f.z = Math.max(this.z, f2);
    }

    public final Tuple3f clamp(float f2, float f3) {
        this.clamp(f2, f3, this);
        return this;
    }

    public final void clamp(float f2, float f3, Tuple3f tuple3f) {
        tuple3f.x = Util.clamp(this.x, f2, f3);
        tuple3f.y = Util.clamp(this.y, f2, f3);
        tuple3f.z = Util.clamp(this.z, f2, f3);
    }

    public static void interpolate(Tuple3f tuple3f, Tuple3f tuple3f2, Tuple3f tuple3f3, float f2) {
        tuple3f3.x = Util.interpolate(tuple3f.x, tuple3f2.x, f2);
        tuple3f3.y = Util.interpolate(tuple3f.y, tuple3f2.y, f2);
        tuple3f3.z = Util.interpolate(tuple3f.z, tuple3f2.z, f2);
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$math$Tuple3f == null ? (class$de$vw$mib$graphics$math$Tuple3f = Tuple3f.class$("de.vw.mib.graphics.math.Tuple3f")) : class$de$vw$mib$graphics$math$Tuple3f).desiredAssertionStatus();
    }
}

