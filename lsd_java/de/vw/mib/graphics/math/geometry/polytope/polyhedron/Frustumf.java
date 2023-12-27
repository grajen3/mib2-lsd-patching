/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.geometry.polytope.polyhedron;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.math.geometry.AbstractGeometry;
import de.vw.mib.graphics.math.geometry.BoundingVolume;
import de.vw.mib.graphics.math.geometry.Plane3f;
import de.vw.mib.graphics.math.geometry.Point3f;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.AxisAlignedBox;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.Frustum;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.OrientedBox;
import de.vw.mib.graphics.math.geometry.quadric.Sphere3f;
import de.vw.mib.util.StringBuilder;
import java.util.Arrays;
import java.util.Iterator;

public final class Frustumf
extends AbstractGeometry
implements Frustum {
    private static final long serialVersionUID;
    private static HashCodeBuilder hcb;
    private Plane3f[] planes;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$math$geometry$polytope$polyhedron$Frustumf;

    public Frustumf() {
        this.planes = new Plane3f[6];
        for (int i2 = 0; i2 < this.planes.length; ++i2) {
            this.planes[i2] = new Plane3f();
        }
    }

    public Frustumf(Frustumf frustumf) {
        this(frustumf.planes);
    }

    public Frustumf(Plane3f[] plane3fArray) {
        if (plane3fArray.length < 6) {
            throw new IllegalArgumentException("Invalid number of planes");
        }
        this.planes = new Plane3f[6];
        for (int i2 = 0; i2 < this.planes.length; ++i2) {
            this.planes[i2] = (Plane3f)plane3fArray[i2].clone();
        }
    }

    @Override
    public Object clone() {
        Frustumf frustumf = (Frustumf)super.clone();
        frustumf.planes = new Plane3f[6];
        for (int i2 = 0; i2 < this.planes.length; ++i2) {
            frustumf.planes[i2] = (Plane3f)this.planes[i2].clone();
        }
        return frustumf;
    }

    public int hashCode() {
        if (hcb == null) {
            hcb = new HashCodeBuilder();
        }
        hcb.reset();
        hcb.append(this.planes);
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            Frustumf frustumf = (Frustumf)object;
            return super.equals(frustumf) && Arrays.equals(this.planes, frustumf.planes);
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[planes=").append(this.planes);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public float getVolume() {
        throw new NotYetImplementedException();
    }

    public void set(Frustumf frustumf) {
        if (this != frustumf) {
            for (int i2 = 0; i2 < this.planes.length; ++i2) {
                this.planes[i2].set(frustumf.planes[i2]);
            }
        }
    }

    public void set(Plane3f[] plane3fArray) {
        if (plane3fArray.length < 6) {
            throw new IllegalArgumentException("Invalid number of planes");
        }
        if (!$assertionsDisabled && !plane3fArray[1].isParallelTo(plane3fArray[0])) {
            throw new AssertionError();
        }
        for (int i2 = 0; i2 < this.planes.length; ++i2) {
            this.planes[i2].set(plane3fArray[i2]);
        }
    }

    public Plane3f getFace(int n) {
        if (!$assertionsDisabled && n >= 6) {
            throw new AssertionError();
        }
        return this.planes[n];
    }

    public Iterator getFaces() {
        throw new NotYetImplementedException();
    }

    public void setFace(int n, Plane3f plane3f) {
        if (!$assertionsDisabled && n >= 6) {
            throw new AssertionError();
        }
        this.planes[n].set(plane3f);
        if (!$assertionsDisabled && !this.planes[1].isParallelTo(this.planes[0])) {
            throw new AssertionError();
        }
    }

    public void setVertices(Point3f[] point3fArray) {
        if (point3fArray.length < 8) {
            throw new IllegalArgumentException("Invalid number of points");
        }
        this.planes[2].set(point3fArray[0], point3fArray[4], point3fArray[6]);
        this.planes[3].set(point3fArray[1], point3fArray[3], point3fArray[7]);
        this.planes[5].set(point3fArray[4], point3fArray[0], point3fArray[1]);
        this.planes[4].set(point3fArray[6], point3fArray[7], point3fArray[3]);
        this.planes[1].set(point3fArray[2], point3fArray[3], point3fArray[1]);
        this.planes[0].set(point3fArray[6], point3fArray[4], point3fArray[5]);
    }

    public void getVertex(int n, Point3f point3f) {
        switch (n) {
            case 0: {
                Plane3f.intersectionPoint(this.planes[2], this.planes[5], this.planes[1], point3f);
                break;
            }
            case 1: {
                Plane3f.intersectionPoint(this.planes[3], this.planes[5], this.planes[1], point3f);
                break;
            }
            case 2: {
                Plane3f.intersectionPoint(this.planes[2], this.planes[4], this.planes[1], point3f);
                break;
            }
            case 3: {
                Plane3f.intersectionPoint(this.planes[3], this.planes[4], this.planes[1], point3f);
                break;
            }
            case 4: {
                Plane3f.intersectionPoint(this.planes[2], this.planes[5], this.planes[0], point3f);
                break;
            }
            case 5: {
                Plane3f.intersectionPoint(this.planes[3], this.planes[5], this.planes[0], point3f);
                break;
            }
            case 6: {
                Plane3f.intersectionPoint(this.planes[2], this.planes[4], this.planes[0], point3f);
                break;
            }
            case 7: {
                Plane3f.intersectionPoint(this.planes[3], this.planes[4], this.planes[0], point3f);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid point index");
            }
        }
    }

    public Point3f[] getVertices() {
        Point3f[] point3fArray = new Point3f[8];
        for (int i2 = 0; i2 < 8; ++i2) {
            point3fArray[i2] = new Point3f();
            this.getVertex(i2, point3fArray[i2]);
        }
        return point3fArray;
    }

    public boolean contains(Point3f point3f) {
        for (int i2 = 0; i2 < this.planes.length; ++i2) {
            if (this.planes[i2].getSide(point3f) != -1) continue;
            return false;
        }
        return true;
    }

    public int getIntersection(BoundingVolume boundingVolume) {
        if (boundingVolume instanceof Sphere3f) {
            return this.getIntersection((Sphere3f)boundingVolume);
        }
        if (boundingVolume instanceof AxisAlignedBox) {
            return this.getIntersection((AxisAlignedBox)boundingVolume);
        }
        if (boundingVolume instanceof OrientedBox) {
            return this.getIntersection((OrientedBox)boundingVolume);
        }
        throw new IllegalArgumentException("Unsupported bounding volume");
    }

    public int getIntersection(Sphere3f sphere3f) {
        int n = 0;
        Point3f point3f = new Point3f();
        sphere3f.getCenter(point3f);
        float f2 = sphere3f.getRadius();
        for (int i2 = 0; i2 < this.planes.length; ++i2) {
            Plane3f plane3f = this.getFace(i2);
            float f3 = plane3f.getSignedDistance(point3f);
            if (f3 < -f2) {
                return 2;
            }
            if (!(Math.abs(f3) < f2)) continue;
            n = 1;
        }
        return n;
    }

    public int getIntersection(AxisAlignedBox axisAlignedBox) {
        int n = 0;
        Point3f point3f = new Point3f();
        Point3f point3f2 = new Point3f();
        for (int i2 = 0; i2 < this.planes.length; ++i2) {
            Plane3f plane3f = this.getFace(i2);
            axisAlignedBox.getPositiveFarVertex(plane3f, point3f);
            axisAlignedBox.getNegativeFarVertex(plane3f, point3f2);
            if (plane3f.getSide(point3f) == -1) {
                return 2;
            }
            if (plane3f.getSide(point3f2) != -1) continue;
            n = 1;
        }
        return n;
    }

    public int getIntersection(OrientedBox orientedBox) {
        int n = 0;
        Point3f point3f = new Point3f();
        Point3f point3f2 = new Point3f();
        for (int i2 = 0; i2 < this.planes.length; ++i2) {
            Plane3f plane3f = this.getFace(i2);
            orientedBox.getFarVertices(plane3f, point3f, point3f2);
            if (plane3f.getSignedDistance(point3f) < 0.0f) {
                return 2;
            }
            if (!(plane3f.getSignedDistance(point3f2) < 0.0f)) continue;
            n = 1;
        }
        return n;
    }

    @Override
    public void transform(Matrix4f matrix4f) {
        this.transform(matrix4f, this);
    }

    public void transform(Matrix4f matrix4f, Frustumf frustumf) {
        throw new NotYetImplementedException();
    }

    @Override
    public void transform(Transform transform) {
        this.transform(transform, this);
    }

    public void transform(Transform transform, Frustumf frustumf) {
        for (int i2 = 0; i2 < this.planes.length; ++i2) {
            this.planes[i2].transform(transform, frustumf.planes[i2]);
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$math$geometry$polytope$polyhedron$Frustumf == null ? (class$de$vw$mib$graphics$math$geometry$polytope$polyhedron$Frustumf = Frustumf.class$("de.vw.mib.graphics.math.geometry.polytope.polyhedron.Frustumf")) : class$de$vw$mib$graphics$math$geometry$polytope$polyhedron$Frustumf).desiredAssertionStatus();
    }
}

