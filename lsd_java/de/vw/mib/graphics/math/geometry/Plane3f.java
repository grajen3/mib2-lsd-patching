/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.geometry;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.Tuple4f;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.math.algebra.Vector4f;
import de.vw.mib.graphics.math.geometry.Geometry3D;
import de.vw.mib.graphics.math.geometry.Plane;
import de.vw.mib.graphics.math.geometry.Point3f;
import de.vw.mib.util.StringBuilder;

public final class Plane3f
implements Plane,
Geometry3D {
    private static final long serialVersionUID;
    private static HashCodeBuilder hcb;
    private static final boolean OPTIMIZE;
    public static final int SIDE_POSITIVE;
    public static final int SIDE_COPLANAR;
    public static final int SIDE_NEGATIVE;
    private Vector3f normal;
    private float offset;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$math$geometry$Plane3f;

    public Plane3f() {
        this.normal = new Vector3f();
        this.offset = 0.0f;
    }

    public Plane3f(Plane3f plane3f) {
        this.normal = (Vector3f)plane3f.normal.clone();
        this.offset = plane3f.offset;
    }

    public Plane3f(Vector3f vector3f, float f2) {
        this();
        this.set(vector3f, f2);
    }

    public Plane3f(Point3f point3f, Vector3f vector3f) {
        this();
        this.set(point3f, vector3f);
    }

    public Plane3f(float f2, float f3, float f4, float f5) {
        this();
        this.set(f2, f3, f4, f5);
    }

    public Plane3f(Point3f point3f, Point3f point3f2, Point3f point3f3) {
        this();
        this.set(point3f, point3f2, point3f3);
    }

    @Override
    public Object clone() {
        try {
            Plane3f plane3f = (Plane3f)super.clone();
            plane3f.normal = (Vector3f)this.normal.clone();
            return plane3f;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    public int hashCode() {
        if (hcb == null) {
            hcb = new HashCodeBuilder();
        }
        hcb.reset();
        hcb.append(this.normal);
        hcb.append(this.offset);
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            Plane3f plane3f = (Plane3f)object;
            if (Util.IDENTITY_EQUALS) {
                return this.normal.equals(plane3f.normal) && this.offset == plane3f.offset;
            }
            if (Util.EXACT_EQUALS) {
                return this.normal.equals(plane3f.normal) && Float.compare(this.offset, plane3f.offset) == 0;
            }
            return this.normal.equals(plane3f.normal) && Util.equalsEpsilon(this.offset, plane3f.offset);
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[normal=").append(this.normal);
        stringBuilder.append(",offset=").append(this.offset);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void set(Vector3f vector3f, float f2) {
        if (!$assertionsDisabled && vector3f.isZero()) {
            throw new AssertionError();
        }
        this.normal.set(vector3f);
        this.offset = f2;
        this.normalize();
    }

    public void get(Tuple4f tuple4f) {
        tuple4f.set(this.normal, -this.offset);
    }

    public void set(Vector4f vector4f) {
        this.set(vector4f.x, vector4f.y, vector4f.z, vector4f.w);
    }

    public void set(float f2, float f3, float f4, float f5) {
        this.normal.x = f2;
        this.normal.y = f3;
        this.normal.z = f4;
        this.offset = -f5;
        if (!$assertionsDisabled && this.normal.isZero()) {
            throw new AssertionError();
        }
        this.normalize();
    }

    public void set(Point3f point3f, Vector3f vector3f) {
        if (!$assertionsDisabled && vector3f.isZero()) {
            throw new AssertionError();
        }
        this.normal.set(vector3f);
        this.offset = vector3f.dot(point3f);
        this.normalize();
    }

    public void set(Point3f point3f, Point3f point3f2, Point3f point3f3) {
        Vector3f vector3f = new Vector3f();
        Vector3f vector3f2 = new Vector3f();
        point3f2.sub(point3f, vector3f);
        point3f3.sub(point3f, vector3f2);
        vector3f.cross(vector3f2, this.normal);
        if (!$assertionsDisabled && this.normal.isZero()) {
            throw new AssertionError();
        }
        this.offset = this.normal.dot(new Vector3f(point3f));
        this.normalize();
    }

    public void set(Plane3f plane3f) {
        if (this != plane3f) {
            this.normal.set(plane3f.normal);
            this.offset = plane3f.offset;
        }
    }

    public void getNormal(Vector3f vector3f) {
        vector3f.set(this.normal);
    }

    public void setNormal(Vector3f vector3f) {
        if (!$assertionsDisabled && vector3f.isZero()) {
            throw new AssertionError();
        }
        this.normal.set(vector3f);
        this.normal.normalize();
    }

    public float getOffset() {
        return this.offset;
    }

    public void setOffset(float f2) {
        this.offset = f2;
    }

    public int getSide(Point3f point3f) {
        float f2 = this.getSignedDistance(point3f);
        if (f2 > 0.0f) {
            return 1;
        }
        if (f2 < 0.0f) {
            return -1;
        }
        return 0;
    }

    public float getDistanceToOrigin() {
        return Math.abs(this.offset);
    }

    public float getSignedDistance(Point3f point3f) {
        if (!$assertionsDisabled && !this.isNormalized()) {
            throw new AssertionError();
        }
        return this.normal.dot(point3f) - this.offset;
    }

    public float getDistance(Point3f point3f) {
        return Math.abs(this.getSignedDistance(point3f));
    }

    private void normalize() {
        if (OPTIMIZE) {
            float f2 = this.normal.getLengthSquared();
            if (Math.abs(f2 - 1.0f) >= -1120434635) {
                f2 = Util.invSqrt(f2);
                this.normal.scale(f2);
                this.offset *= f2;
            }
        } else {
            float f3 = this.normal.getLength();
            if (f3 >= -1120434635) {
                f3 = 1.0f / f3;
                this.normal.scale(f3);
                this.offset *= f3;
            }
        }
    }

    public boolean isNormalized() {
        return this.normal.isNormalized();
    }

    public boolean isParallelTo(Plane3f plane3f) {
        Vector3f vector3f = new Vector3f();
        this.normal.cross(plane3f.normal, vector3f);
        return vector3f.isZero();
    }

    public static void intersectionPoint(Plane3f plane3f, Plane3f plane3f2, Plane3f plane3f3, Point3f point3f) {
        throw new NotYetImplementedException();
    }

    public void transform(Matrix4f matrix4f, Plane3f plane3f) {
        throw new NotYetImplementedException();
    }

    @Override
    public void transform(Matrix4f matrix4f) {
        this.transform(matrix4f, this);
    }

    public void transform(Transform transform, Plane3f plane3f) {
        Vector3f vector3f = new Vector3f();
        transform.transform(this.normal, vector3f);
        vector3f.scale(this.offset);
        transform.getRotation().rotate(this.normal, plane3f.normal);
        plane3f.offset = plane3f.normal.dot(vector3f);
    }

    @Override
    public void transform(Transform transform) {
        this.transform(transform, this);
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$math$geometry$Plane3f == null ? (class$de$vw$mib$graphics$math$geometry$Plane3f = Plane3f.class$("de.vw.mib.graphics.math.geometry.Plane3f")) : class$de$vw$mib$graphics$math$geometry$Plane3f).desiredAssertionStatus();
        OPTIMIZE = Util.OPTIMIZE;
    }
}

