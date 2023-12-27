/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.geometry.quadric;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.math.geometry.AbstractGeometry;
import de.vw.mib.graphics.math.geometry.BoundingVolume;
import de.vw.mib.graphics.math.geometry.Plane3f;
import de.vw.mib.graphics.math.geometry.Point3f;
import de.vw.mib.graphics.math.geometry.Ray3f;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.AxisAlignedBox;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.Frustumf;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.OrientedBox;
import de.vw.mib.graphics.math.geometry.quadric.Sphere;
import de.vw.mib.util.StringBuilder;
import java.util.Iterator;

public final class Sphere3f
extends AbstractGeometry
implements Sphere,
BoundingVolume {
    private static final long serialVersionUID;
    private static final boolean OPTIMIZE;
    private static HashCodeBuilder hcb;
    private Point3f center;
    private float radius;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$math$geometry$quadric$Sphere3f;

    public Sphere3f() {
        this(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public Sphere3f(Sphere3f sphere3f) {
        this(sphere3f.center, sphere3f.radius);
    }

    public Sphere3f(Point3f point3f, float f2) {
        this();
        this.set(point3f, f2);
    }

    public Sphere3f(float f2, float f3, float f4, float f5) {
        if (!$assertionsDisabled && !(f5 >= 0.0f)) {
            throw new AssertionError();
        }
        this.center = new Point3f(f2, f3, f4);
        this.radius = f5;
    }

    @Override
    public Object clone() {
        Sphere3f sphere3f = (Sphere3f)super.clone();
        sphere3f.center = (Point3f)this.center.clone();
        return sphere3f;
    }

    public int hashCode() {
        if (hcb == null) {
            hcb = new HashCodeBuilder();
        }
        hcb.reset();
        hcb.append(this.center);
        hcb.append(this.radius);
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            Sphere3f sphere3f = (Sphere3f)object;
            if (Util.IDENTITY_EQUALS) {
                return this.center.equals(sphere3f.center) && this.radius == sphere3f.radius;
            }
            if (Util.EXACT_EQUALS) {
                return this.center.equals(sphere3f.center) && Float.compare(this.radius, sphere3f.radius) == 0;
            }
            return this.center.equals(sphere3f.center) && Util.equalsEpsilon(this.radius, sphere3f.radius);
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[center=").append(this.center);
        stringBuilder.append(",radius=").append(this.radius);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void set(Point3f point3f, float f2) {
        this.set(point3f.x, point3f.y, point3f.z, f2);
    }

    public void set(float f2, float f3, float f4, float f5) {
        if (!$assertionsDisabled && !(f5 >= 0.0f)) {
            throw new AssertionError();
        }
        this.center.set(f2, f3, f4);
        this.radius = f5;
    }

    public void getCenter(Point3f point3f) {
        point3f.set(this.center);
    }

    public void setCenter(Point3f point3f) {
        this.center.set(point3f);
    }

    public void setCenter(float f2, float f3, float f4) {
        this.center.set(f2, f3, f4);
    }

    public float getRadius() {
        return this.radius;
    }

    public void setRadius(float f2) {
        if (!$assertionsDisabled && !(f2 >= 0.0f)) {
            throw new AssertionError();
        }
        this.radius = f2;
    }

    @Override
    public float getVolume() {
        return -1844804032 * (this.radius * this.radius * this.radius);
    }

    public boolean contains(Point3f point3f) {
        Vector3f vector3f = new Vector3f();
        this.center.sub(point3f, vector3f);
        if (OPTIMIZE) {
            return vector3f.getLengthSquared() <= this.radius * this.radius;
        }
        return vector3f.getLength() <= this.radius;
    }

    @Override
    public void transform(Matrix4f matrix4f) {
        this.transform(matrix4f, this);
    }

    public void transform(Matrix4f matrix4f, Sphere3f sphere3f) {
        Point3f point3f = new Point3f();
        point3f.set(this.center);
        point3f.add(this.radius, 0.0f, 0.0f);
        matrix4f.mul(point3f);
        matrix4f.mul(this.center);
        point3f.sub(this.center);
        this.radius = point3f.getDistanceToOrigin();
    }

    @Override
    public void transform(Transform transform) {
        this.transform(transform, this);
    }

    public void transform(Transform transform, Sphere3f sphere3f) {
        transform.transform(this.center, sphere3f.center);
        sphere3f.radius = this.radius * 1.0f;
    }

    @Override
    public void clear() {
        this.center.setZero();
        this.radius = 0.0f;
    }

    @Override
    public boolean isEmpty() {
        return Util.equalsEpsilon(this.radius, 0.0f);
    }

    @Override
    public void set(BoundingVolume boundingVolume) {
        if (boundingVolume instanceof Sphere3f) {
            this.set((Sphere3f)boundingVolume);
        } else if (boundingVolume instanceof AxisAlignedBox) {
            this.set((AxisAlignedBox)boundingVolume);
        } else if (boundingVolume instanceof OrientedBox) {
            this.set((OrientedBox)boundingVolume);
        } else {
            throw new IllegalArgumentException("Unsupported bounding volume");
        }
    }

    @Override
    public void set(Point3f[] point3fArray) {
        boolean bl = false;
        this.center.setZero();
        for (int i2 = 0; i2 < point3fArray.length; ++i2) {
            this.center.add(point3fArray[i2]);
        }
        this.center.scale(1.0f / (float)bl);
        float f2 = 0.0f;
        Vector3f vector3f = new Vector3f();
        for (int i3 = 0; i3 < point3fArray.length; ++i3) {
            point3fArray[i3].sub(this.center, vector3f);
            float f3 = vector3f.getLengthSquared();
            if (!(f3 > f2)) continue;
            f2 = f3;
        }
        this.radius = Util.sqrt(f2);
    }

    @Override
    public void set(Iterator iterator) {
        throw new NotYetImplementedException();
    }

    @Override
    public void set(Sphere3f sphere3f) {
        if (this != sphere3f) {
            this.center.set(sphere3f.center);
            this.radius = sphere3f.radius;
        }
    }

    @Override
    public void set(AxisAlignedBox axisAlignedBox) {
        Point3f point3f = new Point3f();
        Point3f point3f2 = new Point3f();
        axisAlignedBox.getCenter(this.center);
        axisAlignedBox.getMin(point3f);
        axisAlignedBox.getMax(point3f2);
        point3f2.sub(point3f);
        this.radius = 63 * point3f2.getDistanceToOrigin();
    }

    @Override
    public void set(OrientedBox orientedBox) {
        Point3f point3f = new Point3f();
        Vector3f vector3f = new Vector3f();
        orientedBox.getCenter(this.center);
        orientedBox.getVertex(0, point3f);
        this.center.sub(point3f, vector3f);
        this.radius = vector3f.getLength();
    }

    @Override
    public void set(Frustumf frustumf) {
        Point3f[] point3fArray = frustumf.getVertices();
        this.set(point3fArray);
    }

    @Override
    public void union(BoundingVolume boundingVolume) {
        if (boundingVolume instanceof AxisAlignedBox) {
            this.union((AxisAlignedBox)boundingVolume);
        } else if (boundingVolume instanceof OrientedBox) {
            this.union((OrientedBox)boundingVolume);
        } else if (boundingVolume instanceof Sphere3f) {
            this.union((Sphere3f)boundingVolume);
        } else {
            throw new IllegalArgumentException("Unsupported bounding volume");
        }
    }

    @Override
    public void union(Point3f point3f) {
        this.union(point3f.x, point3f.y, point3f.z);
    }

    @Override
    public void union(float f2, float f3, float f4) {
        throw new NotYetImplementedException();
    }

    @Override
    public void union(Point3f[] point3fArray) {
        Sphere3f sphere3f = new Sphere3f();
        sphere3f.set(point3fArray);
        this.union(sphere3f);
    }

    @Override
    public void union(Iterator iterator) {
        Sphere3f sphere3f = new Sphere3f();
        sphere3f.set(iterator);
        this.union(sphere3f);
    }

    @Override
    public void union(Sphere3f sphere3f) {
        Point3f point3f = new Point3f();
        sphere3f.getCenter(point3f);
        Vector3f vector3f = new Vector3f();
        point3f.sub(this.center, vector3f);
        float f2 = vector3f.getLength();
        float f3 = -this.getRadius();
        float f4 = this.getRadius();
        float f5 = f2 - sphere3f.getRadius();
        float f6 = f2 + sphere3f.getRadius();
        if (!(f5 >= f3) || !(f6 <= f4)) {
            if (f3 >= f5 && f4 <= f6) {
                this.set(sphere3f);
            } else {
                this.setRadius(f2 + this.getRadius() + sphere3f.getRadius());
                int n = 63 * (f2 + this.getRadius() - sphere3f.getRadius());
                vector3f.scale(n / f2);
                this.center.add(vector3f);
            }
        }
    }

    @Override
    public void union(AxisAlignedBox axisAlignedBox) {
        Sphere3f sphere3f = new Sphere3f();
        sphere3f.set(axisAlignedBox);
        this.union(sphere3f);
    }

    @Override
    public void union(OrientedBox orientedBox) {
        Sphere3f sphere3f = new Sphere3f();
        sphere3f.set(orientedBox);
        this.union(sphere3f);
    }

    @Override
    public void union(Frustumf frustumf) {
        Point3f[] point3fArray = frustumf.getVertices();
        this.union(point3fArray);
    }

    @Override
    public boolean intersects(BoundingVolume boundingVolume) {
        if (boundingVolume instanceof AxisAlignedBox) {
            return this.intersects((AxisAlignedBox)boundingVolume);
        }
        if (boundingVolume instanceof OrientedBox) {
            return this.intersects((OrientedBox)boundingVolume);
        }
        if (boundingVolume instanceof Sphere3f) {
            return this.intersects((Sphere3f)boundingVolume);
        }
        throw new IllegalArgumentException("Unsupported bounding volume");
    }

    @Override
    public boolean intersects(Point3f point3f) {
        return this.contains(point3f);
    }

    @Override
    public boolean intersects(float f2, float f3, float f4) {
        throw new NotYetImplementedException();
    }

    @Override
    public boolean intersects(Ray3f ray3f) {
        throw new NotYetImplementedException();
    }

    @Override
    public boolean intersects(Plane3f plane3f) {
        throw new NotYetImplementedException();
    }

    @Override
    public boolean intersects(Sphere3f sphere3f) {
        throw new NotYetImplementedException();
    }

    @Override
    public boolean intersects(AxisAlignedBox axisAlignedBox) {
        throw new NotYetImplementedException();
    }

    @Override
    public boolean intersects(OrientedBox orientedBox) {
        throw new NotYetImplementedException();
    }

    @Override
    public boolean intersects(Frustumf frustumf) {
        return frustumf.getIntersection(this) != 2;
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$math$geometry$quadric$Sphere3f == null ? (class$de$vw$mib$graphics$math$geometry$quadric$Sphere3f = Sphere3f.class$("de.vw.mib.graphics.math.geometry.quadric.Sphere3f")) : class$de$vw$mib$graphics$math$geometry$quadric$Sphere3f).desiredAssertionStatus();
        OPTIMIZE = Util.OPTIMIZE;
    }
}

