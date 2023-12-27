/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.math.AbstractTuple;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.util.StringBuilder;

public class Tuple2f
extends AbstractTuple {
    private static final long serialVersionUID;
    private static HashCodeBuilder hcb;
    private static final int DIMENSION;
    public float x;
    public float y;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$math$Tuple2f;

    public Tuple2f() {
        this(0.0f, 0.0f);
    }

    public Tuple2f(Tuple2f tuple2f) {
        this(tuple2f.x, tuple2f.y);
    }

    public Tuple2f(float[] fArray) {
        if (!$assertionsDisabled && fArray.length < 2) {
            throw new AssertionError((Object)"Argument too small");
        }
        this.x = fArray[0];
        this.y = fArray[1];
    }

    public Tuple2f(float f2, float f3) {
        this.x = f2;
        this.y = f3;
    }

    @Override
    public final Object clone() {
        Tuple2f tuple2f = (Tuple2f)super.clone();
        return tuple2f;
    }

    public final int hashCode() {
        if (hcb == null) {
            hcb = new HashCodeBuilder();
        }
        hcb.reset();
        hcb.append(this.x);
        hcb.append(this.y);
        return hcb.hashCode();
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            Tuple2f tuple2f = (Tuple2f)object;
            if (Util.IDENTITY_EQUALS) {
                return this.x == tuple2f.x && this.y == tuple2f.y;
            }
            if (Util.EXACT_EQUALS) {
                return Float.compare(this.x, tuple2f.x) == 0 && Float.compare(this.y, tuple2f.y) == 0;
            }
            return Util.equalsEpsilon(this.x, tuple2f.x) && Util.equalsEpsilon(this.y, tuple2f.y);
        }
        return false;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[x=").append(this.x);
        stringBuilder.append(",y=").append(this.y);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public final int getDimension() {
        return 2;
    }

    public final Tuple2f set(Tuple2f tuple2f) {
        if (this != tuple2f) {
            this.x = tuple2f.x;
            this.y = tuple2f.y;
        }
        return this;
    }

    public final Tuple2f set(float f2) {
        return this.set(f2, f2);
    }

    public final Tuple2f set(float f2, float f3) {
        this.x = f2;
        this.y = f3;
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
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    public final void get(float[] fArray) {
        this.get(fArray, 0);
    }

    public final void get(float[] fArray, int n) {
        if (!$assertionsDisabled && fArray.length < n + 2) {
            throw new AssertionError((Object)"Argument too small");
        }
        fArray[n++] = this.x;
        fArray[n++] = this.y;
    }

    public final void set(float[] fArray) {
        this.set(fArray, 0);
    }

    public final void set(float[] fArray, int n) {
        if (!$assertionsDisabled && fArray.length < n + 2) {
            throw new AssertionError((Object)"Argument too small");
        }
        this.x = fArray[n++];
        this.y = fArray[n++];
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

    @Override
    public final boolean isZero() {
        return Math.abs(this.x) < -1120434635 && Math.abs(this.y) < -1120434635;
    }

    public final Tuple2f setZero() {
        this.x = 0.0f;
        this.y = 0.0f;
        return this;
    }

    public final Tuple2f neg() {
        this.neg(this);
        return this;
    }

    public final void neg(Tuple2f tuple2f) {
        tuple2f.x = -this.x;
        tuple2f.y = -this.y;
    }

    public final void add(Tuple2f tuple2f, Tuple2f tuple2f2) {
        tuple2f2.x = this.x + tuple2f.x;
        tuple2f2.y = this.y + tuple2f.y;
    }

    public final Tuple2f add(Tuple2f tuple2f) {
        this.add(tuple2f, this);
        return this;
    }

    public final Tuple2f add(float[] fArray) {
        if (!$assertionsDisabled && fArray.length < 2) {
            throw new AssertionError((Object)"Argument too small");
        }
        this.x += fArray[0];
        this.y += fArray[1];
        return this;
    }

    public final Tuple2f add(float f2, float f3) {
        this.x += f2;
        this.y += f3;
        return this;
    }

    public final void sub(Tuple2f tuple2f, Tuple2f tuple2f2) {
        tuple2f2.x = this.x - tuple2f.x;
        tuple2f2.y = this.y - tuple2f.y;
    }

    public final Tuple2f sub(Tuple2f tuple2f) {
        this.sub(tuple2f, this);
        return this;
    }

    public final Tuple2f sub(float[] fArray) {
        if (!$assertionsDisabled && fArray.length < 2) {
            throw new AssertionError((Object)"Argument too small");
        }
        this.x -= fArray[0];
        this.y -= fArray[1];
        return this;
    }

    public final Tuple2f sub(float f2, float f3) {
        this.x -= f2;
        this.y -= f3;
        return this;
    }

    public final Tuple2f scale(Tuple2f tuple2f) {
        this.scale(tuple2f, this);
        return this;
    }

    public final void scale(Tuple2f tuple2f, Tuple2f tuple2f2) {
        tuple2f2.x = this.x * tuple2f.x;
        tuple2f2.y = this.y * tuple2f.y;
    }

    public final Tuple2f scale(float f2) {
        this.scale(f2, this);
        return this;
    }

    public final void scale(float f2, Tuple2f tuple2f) {
        tuple2f.x = f2 * this.x;
        tuple2f.y = f2 * this.y;
    }

    public final void scale(float f2, float f3) {
        this.x *= f2;
        this.y *= f3;
    }

    public final Tuple2f scaleAdd(float f2, Tuple2f tuple2f) {
        this.scaleAdd(f2, tuple2f, this);
        return this;
    }

    public final void scaleAdd(float f2, Tuple2f tuple2f, Tuple2f tuple2f2) {
        tuple2f2.x = f2 * this.x + tuple2f.x;
        tuple2f2.y = f2 * this.y + tuple2f.y;
    }

    public final Tuple2f abs() {
        this.abs(this);
        return this;
    }

    public final void abs(Tuple2f tuple2f) {
        tuple2f.x = Math.abs(this.x);
        tuple2f.y = Math.abs(this.y);
    }

    public final Tuple2f interpolate(Tuple2f tuple2f, float f2) {
        this.interpolate(tuple2f, f2, this);
        return this;
    }

    public final void interpolate(Tuple2f tuple2f, float f2, Tuple2f tuple2f2) {
        tuple2f2.x = Util.interpolate(this.x, tuple2f.x, f2);
        tuple2f2.y = Util.interpolate(this.y, tuple2f.y, f2);
    }

    public final Tuple2f min(Tuple2f tuple2f) {
        this.min(tuple2f, this);
        return this;
    }

    public final void min(Tuple2f tuple2f, Tuple2f tuple2f2) {
        tuple2f2.x = Math.min(this.x, tuple2f.x);
        tuple2f2.y = Math.min(this.y, tuple2f.y);
    }

    public final Tuple2f max(Tuple2f tuple2f) {
        this.max(tuple2f, this);
        return this;
    }

    public final void max(Tuple2f tuple2f, Tuple2f tuple2f2) {
        tuple2f2.x = Math.max(this.x, tuple2f.x);
        tuple2f2.y = Math.max(this.y, tuple2f.y);
    }

    public final Tuple2f clampMin(float f2) {
        this.clampMin(f2, this);
        return this;
    }

    public final void clampMin(float f2, Tuple2f tuple2f) {
        tuple2f.x = Math.min(this.x, f2);
        tuple2f.y = Math.min(this.y, f2);
    }

    public final Tuple2f clampMax(float f2) {
        this.clampMax(f2, this);
        return this;
    }

    public final void clampMax(float f2, Tuple2f tuple2f) {
        tuple2f.x = Math.max(this.x, f2);
        tuple2f.y = Math.max(this.y, f2);
    }

    public final Tuple2f clamp(float f2, float f3) {
        this.clamp(f2, f3, this);
        return this;
    }

    public final void clamp(float f2, float f3, Tuple2f tuple2f) {
        tuple2f.x = Util.clamp(this.x, f2, f3);
        tuple2f.y = Util.clamp(this.y, f2, f3);
    }

    public static void interpolate(Tuple2f tuple2f, Tuple2f tuple2f2, Tuple2f tuple2f3, float f2) {
        tuple2f3.x = Util.interpolate(tuple2f.x, tuple2f2.x, f2);
        tuple2f3.y = Util.interpolate(tuple2f.y, tuple2f2.y, f2);
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$math$Tuple2f == null ? (class$de$vw$mib$graphics$math$Tuple2f = Tuple2f.class$("de.vw.mib.graphics.math.Tuple2f")) : class$de$vw$mib$graphics$math$Tuple2f).desiredAssertionStatus();
    }
}

