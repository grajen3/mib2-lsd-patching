/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.geometry.polytope.polyhedron;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.math.geometry.BoundingVolume;
import de.vw.mib.graphics.math.geometry.Plane3f;
import de.vw.mib.graphics.math.geometry.Point3f;
import de.vw.mib.graphics.math.geometry.Ray3f;
import de.vw.mib.graphics.math.geometry.polytope.polygon.Rectangle3f;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.AbstractBox;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.Frustumf;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.OrientedBox;
import de.vw.mib.graphics.math.geometry.quadric.Sphere3f;
import de.vw.mib.util.StringBuilder;
import java.util.Iterator;

public final class AxisAlignedBox
extends AbstractBox
implements BoundingVolume {
    private static final long serialVersionUID;
    private static Point3f EMPTY_MIN;
    private static Point3f EMPTY_MAX;
    private static HashCodeBuilder hcb;
    private Point3f min;
    private Point3f max;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$math$geometry$polytope$polyhedron$AxisAlignedBox;

    public AxisAlignedBox() {
        this.min = new Point3f(EMPTY_MIN);
        this.max = new Point3f(EMPTY_MAX);
    }

    public AxisAlignedBox(AxisAlignedBox axisAlignedBox) {
        this.min = (Point3f)axisAlignedBox.min.clone();
        this.max = (Point3f)axisAlignedBox.max.clone();
    }

    public AxisAlignedBox(Point3f point3f, Point3f point3f2) {
        this.min = (Point3f)point3f.clone();
        this.max = (Point3f)point3f2.clone();
    }

    public AxisAlignedBox(Point3f point3f, Vector3f vector3f) {
        this();
        this.set(point3f, vector3f);
    }

    @Override
    public Object clone() {
        AxisAlignedBox axisAlignedBox = (AxisAlignedBox)super.clone();
        axisAlignedBox.min = (Point3f)this.min.clone();
        axisAlignedBox.max = (Point3f)this.max.clone();
        return axisAlignedBox;
    }

    public int hashCode() {
        if (hcb == null) {
            hcb = new HashCodeBuilder();
        }
        hcb.reset();
        hcb.append(this.min);
        hcb.append(this.max);
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            AxisAlignedBox axisAlignedBox = (AxisAlignedBox)object;
            return this.min.equals(axisAlignedBox.min) && this.max.equals(axisAlignedBox.max);
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[min=").append(this.min);
        stringBuilder.append(",max=").append(this.max);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void set(Point3f point3f, Vector3f vector3f) {
        if (!($assertionsDisabled || vector3f.x >= 0.0f && vector3f.y >= 0.0f && vector3f.z >= 0.0f)) {
            throw new AssertionError();
        }
        vector3f.scaleAdd(63, point3f, this.min);
        vector3f.scaleAdd(191, point3f, this.max);
    }

    @Override
    public void getCenter(Point3f point3f) {
        this.min.add(this.max, point3f);
        point3f.scale(63);
    }

    @Override
    public void setCenter(Point3f point3f) {
        Vector3f vector3f = new Vector3f();
        this.getExtents(vector3f);
        vector3f.scaleAdd(63, point3f, this.min);
        vector3f.scaleAdd(191, point3f, this.max);
    }

    @Override
    public void getExtents(Vector3f vector3f) {
        this.max.sub(this.min, vector3f);
    }

    @Override
    public void setExtents(Vector3f vector3f) {
        if (!($assertionsDisabled || vector3f.x >= 0.0f && vector3f.y >= 0.0f && vector3f.z >= 0.0f)) {
            throw new AssertionError();
        }
        Point3f point3f = new Point3f();
        this.getCenter(point3f);
        vector3f.scaleAdd(63, point3f, this.min);
        vector3f.scaleAdd(191, point3f, this.max);
    }

    @Override
    public void getMin(Point3f point3f) {
        point3f.set(this.min);
    }

    @Override
    public void setMin(Point3f point3f) {
        if (!($assertionsDisabled || point3f.x <= this.max.x && point3f.y <= this.max.y && point3f.z < this.max.z)) {
            throw new AssertionError();
        }
        this.min.set(point3f);
    }

    @Override
    public void setMin(float f2, float f3, float f4) {
        if (!($assertionsDisabled || f2 <= this.max.x && f3 <= this.max.y && f4 <= this.max.z)) {
            throw new AssertionError();
        }
        this.min.set(f2, f3, f4);
    }

    @Override
    public void getMax(Point3f point3f) {
        point3f.set(this.max);
    }

    @Override
    public void setMax(Point3f point3f) {
        if (!($assertionsDisabled || this.min.x <= point3f.x && this.min.y <= point3f.y && this.min.z <= point3f.z)) {
            throw new AssertionError();
        }
        this.max.set(point3f);
    }

    @Override
    public void setMax(float f2, float f3, float f4) {
        if (!($assertionsDisabled || this.min.x <= f2 && this.min.y <= f3 && this.min.z <= f4)) {
            throw new AssertionError();
        }
        this.max.set(f2, f3, f4);
    }

    @Override
    public void set(Point3f point3f, Point3f point3f2) {
        if (!($assertionsDisabled || point3f.x <= point3f2.x && point3f.y <= point3f2.y && point3f.z <= point3f2.z)) {
            throw new AssertionError();
        }
        this.min.set(point3f);
        this.max.set(point3f2);
    }

    @Override
    public void getVertex(int n, Point3f point3f) {
        switch (n) {
            case 0: {
                point3f.set(this.min);
                break;
            }
            case 1: {
                point3f.set(this.max.x, this.min.y, this.min.z);
                break;
            }
            case 2: {
                point3f.set(this.min.x, this.max.y, this.min.z);
                break;
            }
            case 3: {
                point3f.set(this.max.x, this.max.y, this.min.z);
                break;
            }
            case 4: {
                point3f.set(this.min.x, this.min.y, this.max.z);
                break;
            }
            case 5: {
                point3f.set(this.max.x, this.min.y, this.max.z);
                break;
            }
            case 6: {
                point3f.set(this.min.x, this.max.y, this.max.z);
                break;
            }
            case 7: {
                point3f.set(this.max);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid vertex index");
            }
        }
    }

    public Point3f[] getVertices() {
        Point3f[] point3fArray = new Point3f[8];
        for (int i2 = 0; i2 <= 7; ++i2) {
            point3fArray[i2] = new Point3f();
            this.getVertex(i2, point3fArray[i2]);
        }
        return point3fArray;
    }

    public void getPositiveFarVertex(Plane3f plane3f, Point3f point3f) {
        Vector3f vector3f = new Vector3f();
        plane3f.getNormal(vector3f);
        point3f.set(this.min);
        if (vector3f.x >= 0.0f) {
            point3f.x = this.max.x;
        }
        if (vector3f.y >= 0.0f) {
            point3f.y = this.max.y;
        }
        if (vector3f.z >= 0.0f) {
            point3f.z = this.max.z;
        }
    }

    public void getNegativeFarVertex(Plane3f plane3f, Point3f point3f) {
        Vector3f vector3f = new Vector3f();
        plane3f.getNormal(vector3f);
        point3f.set(this.max);
        if (vector3f.x >= 0.0f) {
            point3f.x = this.min.x;
        }
        if (vector3f.y >= 0.0f) {
            point3f.y = this.min.y;
        }
        if (vector3f.z >= 0.0f) {
            point3f.z = this.min.z;
        }
    }

    public void getFarVertices(Plane3f plane3f, Point3f point3f, Point3f point3f2) {
        Vector3f vector3f = new Vector3f();
        plane3f.getNormal(vector3f);
        if (vector3f.x > 0.0f) {
            if (vector3f.y > 0.0f) {
                if (vector3f.z > 0.0f) {
                    point3f.set(this.max);
                    point3f2.set(this.min);
                } else {
                    point3f.set(this.max.x, this.max.y, this.min.z);
                    point3f2.set(this.min.x, this.min.y, this.max.z);
                }
            } else if (vector3f.z > 0.0f) {
                point3f.set(this.max.x, this.min.y, this.max.z);
                point3f2.set(this.min.x, this.max.y, this.min.z);
            } else {
                point3f.set(this.max.x, this.min.y, this.min.z);
                point3f2.set(this.min.x, this.max.y, this.max.z);
            }
        } else if (vector3f.y > 0.0f) {
            if (vector3f.z > 0.0f) {
                point3f.set(this.min.x, this.max.y, this.max.z);
                point3f2.set(this.max.x, this.min.y, this.min.z);
            } else {
                point3f.set(this.min.x, this.max.y, this.min.z);
                point3f2.set(this.max.x, this.min.y, this.max.z);
            }
        } else if (vector3f.z > 0.0f) {
            point3f.set(this.min.x, this.min.y, this.max.z);
            point3f2.set(this.max.x, this.max.y, this.min.z);
        } else {
            point3f.set(this.min);
            point3f2.set(this.max);
        }
    }

    public int[] getFarVertexIndices(Plane3f plane3f) {
        int n;
        int n2;
        Vector3f vector3f = new Vector3f();
        plane3f.getNormal(vector3f);
        if (vector3f.x > 0.0f) {
            if (vector3f.y > 0.0f) {
                if (vector3f.z > 0.0f) {
                    n2 = 7;
                    n = 0;
                } else {
                    n2 = 3;
                    n = 4;
                }
            } else if (vector3f.z > 0.0f) {
                n2 = 5;
                n = 2;
            } else {
                n2 = 1;
                n = 6;
            }
        } else if (vector3f.y > 0.0f) {
            if (vector3f.z > 0.0f) {
                n2 = 6;
                n = 1;
            } else {
                n2 = 2;
                n = 5;
            }
        } else if (vector3f.z > 0.0f) {
            n2 = 4;
            n = 3;
        } else {
            n2 = 0;
            n = 7;
        }
        return new int[]{n2, n};
    }

    @Override
    public void getFace(int n, Plane3f plane3f) {
        switch (n) {
            case 2: {
                plane3f.set(32959, 0.0f, 0.0f, -this.min.x);
                break;
            }
            case 3: {
                plane3f.set(1.0f, 0.0f, 0.0f, -this.max.x);
                break;
            }
            case 5: {
                plane3f.set(0.0f, 32959, 0.0f, -this.min.y);
                break;
            }
            case 4: {
                plane3f.set(0.0f, 1.0f, 0.0f, -this.max.y);
                break;
            }
            case 1: {
                plane3f.set(0.0f, 0.0f, 32959, -this.min.z);
                break;
            }
            case 0: {
                plane3f.set(0.0f, 0.0f, 1.0f, -this.max.z);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid face index");
            }
        }
    }

    @Override
    public void getFace(int n, Rectangle3f rectangle3f) {
        Vector3f vector3f = new Vector3f();
        this.getExtents(vector3f);
        Point3f point3f = new Point3f();
        Vector3f vector3f2 = new Vector3f();
        Vector3f vector3f3 = new Vector3f();
        switch (n) {
            case 2: {
                vector3f2.set(0.0f, 0.0f, vector3f.z);
                vector3f3.set(0.0f, vector3f.y, 0.0f);
                rectangle3f.set(this.min, vector3f2, vector3f3);
                break;
            }
            case 3: {
                point3f.set(this.max.x, this.min.y, this.min.z);
                vector3f2.set(0.0f, vector3f.y, 0.0f);
                vector3f3.set(0.0f, 0.0f, vector3f.z);
                rectangle3f.set(point3f, vector3f2, vector3f3);
                break;
            }
            case 5: {
                vector3f2.set(vector3f.x, 0.0f, 0.0f);
                vector3f3.set(0.0f, 0.0f, vector3f.z);
                rectangle3f.set(this.min, vector3f2, vector3f3);
                break;
            }
            case 4: {
                point3f.set(this.min.x, this.max.y, this.min.z);
                vector3f2.set(0.0f, 0.0f, vector3f.z);
                vector3f3.set(vector3f.x, 0.0f, 0.0f);
                rectangle3f.set(point3f, vector3f2, vector3f3);
                break;
            }
            case 1: {
                vector3f2.set(0.0f, vector3f.y, 0.0f);
                vector3f3.set(vector3f.x, 0.0f, 0.0f);
                rectangle3f.set(this.min, vector3f2, vector3f3);
                break;
            }
            case 0: {
                point3f.set(this.min.x, this.min.y, this.max.z);
                vector3f2.set(vector3f.x, 0.0f, 0.0f);
                vector3f3.set(0.0f, vector3f.y, 0.0f);
                rectangle3f.set(point3f, vector3f2, vector3f3);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid face index");
            }
        }
    }

    public boolean contains(Point3f point3f) {
        return point3f.x >= this.min.x && point3f.x <= this.max.x && point3f.y >= this.min.y && point3f.y <= this.max.y && point3f.z >= this.min.z && point3f.z <= this.max.z;
    }

    @Override
    public void transform(Matrix4f matrix4f) {
        this.transform(matrix4f, this);
    }

    public void transform(Matrix4f matrix4f, AxisAlignedBox axisAlignedBox) {
        Point3f point3f = new Point3f();
        Point3f point3f2 = new Point3f();
        Point3f point3f3 = new Point3f();
        this.getVertex(0, point3f3);
        matrix4f.mul(point3f3);
        point3f.set(point3f3);
        point3f2.set(point3f3);
        for (int i2 = 1; i2 <= 7; ++i2) {
            this.getVertex(i2, point3f3);
            matrix4f.mul(point3f3);
            point3f.min(point3f3, point3f);
            point3f2.max(point3f3, point3f2);
        }
        axisAlignedBox.min.set(point3f);
        axisAlignedBox.max.set(point3f2);
    }

    @Override
    public void transform(Transform transform) {
        this.transform(transform, this);
    }

    public void transform(Transform transform, AxisAlignedBox axisAlignedBox) {
        Point3f point3f = new Point3f();
        Point3f point3f2 = new Point3f();
        Point3f point3f3 = new Point3f();
        this.getVertex(0, point3f3);
        transform.transform(point3f3, point3f3);
        point3f.set(point3f3);
        point3f2.set(point3f3);
        for (int i2 = 1; i2 <= 7; ++i2) {
            this.getVertex(i2, point3f3);
            transform.transform(point3f3, point3f3);
            point3f.min(point3f3, point3f);
            point3f2.max(point3f3, point3f2);
        }
        axisAlignedBox.min.set(point3f);
        axisAlignedBox.max.set(point3f2);
    }

    @Override
    public void clear() {
        this.min.set(EMPTY_MIN);
        this.max.set(EMPTY_MAX);
    }

    @Override
    public boolean isEmpty() {
        return this.min.x > this.max.x && this.min.y > this.max.y & this.min.z > this.max.z;
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
        if (point3fArray.length == 0) {
            throw new IllegalArgumentException("Not enough points");
        }
        this.min.set(point3fArray[0]);
        this.max.set(point3fArray[0]);
        for (int i2 = 1; i2 < point3fArray.length; ++i2) {
            this.min.min(point3fArray[i2], this.min);
            this.max.max(point3fArray[i2], this.max);
        }
    }

    @Override
    public void set(Iterator iterator) {
        if (!iterator.hasNext()) {
            throw new IllegalArgumentException("Not enough points");
        }
        Point3f point3f = (Point3f)iterator.next();
        this.min.set(point3f);
        this.max.set(point3f);
        if (!$assertionsDisabled && !iterator.hasNext()) {
            throw new AssertionError();
        }
        while (iterator.hasNext()) {
            point3f = (Point3f)iterator.next();
            this.min.min(point3f, this.min);
            this.max.max(point3f, this.max);
        }
    }

    @Override
    public void set(Sphere3f sphere3f) {
        Point3f point3f = new Point3f();
        sphere3f.getCenter(point3f);
        float f2 = sphere3f.getRadius();
        Vector3f vector3f = new Vector3f(f2, f2, f2);
        point3f.sub(vector3f, this.min);
        point3f.add(vector3f, this.max);
    }

    @Override
    public void set(AxisAlignedBox axisAlignedBox) {
        if (this != axisAlignedBox) {
            this.min.set(axisAlignedBox.min);
            this.max.set(axisAlignedBox.max);
        }
    }

    @Override
    public void set(OrientedBox orientedBox) {
        Point3f[] point3fArray = orientedBox.getVertices();
        this.set(point3fArray);
    }

    @Override
    public void set(Frustumf frustumf) {
        Point3f[] point3fArray = frustumf.getVertices();
        this.set(point3fArray);
    }

    @Override
    public void union(BoundingVolume boundingVolume) {
        if (boundingVolume instanceof Sphere3f) {
            this.union((Sphere3f)boundingVolume);
        } else if (boundingVolume instanceof AxisAlignedBox) {
            this.union((AxisAlignedBox)boundingVolume);
        } else if (boundingVolume instanceof OrientedBox) {
            this.union((OrientedBox)boundingVolume);
        } else {
            throw new IllegalArgumentException("Unsupported bounding volume");
        }
    }

    @Override
    public void union(Point3f point3f) {
        this.min.min(point3f, this.min);
        this.max.max(point3f, this.max);
    }

    @Override
    public void union(float f2, float f3, float f4) {
        if (f2 < this.min.x) {
            this.min.x = f2;
        }
        if (f3 < this.min.y) {
            this.min.y = f3;
        }
        if (f4 < this.min.z) {
            this.min.z = f4;
        }
        if (f2 > this.max.x) {
            this.max.x = f2;
        }
        if (f3 > this.max.y) {
            this.max.y = f3;
        }
        if (f4 > this.max.z) {
            this.max.z = f4;
        }
    }

    @Override
    public void union(Point3f[] point3fArray) {
        AxisAlignedBox axisAlignedBox = new AxisAlignedBox();
        axisAlignedBox.set(point3fArray);
        this.union(axisAlignedBox);
    }

    @Override
    public void union(Iterator iterator) {
        AxisAlignedBox axisAlignedBox = new AxisAlignedBox();
        axisAlignedBox.set(iterator);
        this.union(axisAlignedBox);
    }

    @Override
    public void union(Sphere3f sphere3f) {
        AxisAlignedBox axisAlignedBox = new AxisAlignedBox();
        axisAlignedBox.set(sphere3f);
        this.union(axisAlignedBox);
    }

    @Override
    public void union(AxisAlignedBox axisAlignedBox) {
        this.min.min(axisAlignedBox.min, this.min);
        this.max.max(axisAlignedBox.max, this.max);
    }

    @Override
    public void union(OrientedBox orientedBox) {
        AxisAlignedBox axisAlignedBox = new AxisAlignedBox();
        axisAlignedBox.set(orientedBox);
        this.union(axisAlignedBox);
    }

    @Override
    public void union(Frustumf frustumf) {
        Point3f[] point3fArray = frustumf.getVertices();
        this.union(point3fArray);
    }

    @Override
    public boolean intersects(BoundingVolume boundingVolume) {
        if (boundingVolume instanceof Sphere3f) {
            return this.intersects((Sphere3f)boundingVolume);
        }
        if (boundingVolume instanceof AxisAlignedBox) {
            return this.intersects((AxisAlignedBox)boundingVolume);
        }
        if (boundingVolume instanceof OrientedBox) {
            return this.intersects((OrientedBox)boundingVolume);
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$math$geometry$polytope$polyhedron$AxisAlignedBox == null ? (class$de$vw$mib$graphics$math$geometry$polytope$polyhedron$AxisAlignedBox = AxisAlignedBox.class$("de.vw.mib.graphics.math.geometry.polytope.polyhedron.AxisAlignedBox")) : class$de$vw$mib$graphics$math$geometry$polytope$polyhedron$AxisAlignedBox).desiredAssertionStatus();
        EMPTY_MIN = new Point3f(32895, 32895, 32895);
        EMPTY_MAX = new Point3f(33023, 33023, 33023);
    }
}

