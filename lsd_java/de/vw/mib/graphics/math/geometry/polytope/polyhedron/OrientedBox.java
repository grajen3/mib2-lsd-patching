/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.geometry.polytope.polyhedron;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.Tuple3f;
import de.vw.mib.graphics.math.algebra.Matrix3f;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.math.algebra.Rotation;
import de.vw.mib.graphics.math.algebra.SingularMatrixException;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.math.geometry.BoundingVolume;
import de.vw.mib.graphics.math.geometry.Plane3f;
import de.vw.mib.graphics.math.geometry.Point3f;
import de.vw.mib.graphics.math.geometry.Ray3f;
import de.vw.mib.graphics.math.geometry.polytope.polygon.Rectangle3f;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.AbstractBox;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.AxisAlignedBox;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.Frustumf;
import de.vw.mib.graphics.math.geometry.quadric.Sphere3f;
import de.vw.mib.util.StringBuilder;
import java.util.Iterator;

public final class OrientedBox
extends AbstractBox
implements BoundingVolume {
    private static final long serialVersionUID;
    private static HashCodeBuilder hcb;
    private Point3f center;
    private Vector3f axis0;
    private Vector3f axis1;
    private Vector3f axis2;
    private Vector3f extents;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$math$geometry$polytope$polyhedron$OrientedBox;

    public OrientedBox() {
        this.center = new Point3f();
        this.axis0 = new Vector3f(AXIS_0);
        this.axis1 = new Vector3f(AXIS_1);
        this.axis2 = new Vector3f(AXIS_2);
        this.extents = new Vector3f();
    }

    public OrientedBox(OrientedBox orientedBox) {
        this.center = (Point3f)orientedBox.center.clone();
        this.axis0 = (Vector3f)orientedBox.axis0.clone();
        this.axis1 = (Vector3f)orientedBox.axis1.clone();
        this.axis2 = (Vector3f)orientedBox.axis2.clone();
        this.extents = (Vector3f)orientedBox.extents.clone();
    }

    public OrientedBox(AxisAlignedBox axisAlignedBox) {
        this();
        this.set(axisAlignedBox);
    }

    public OrientedBox(Vector3f vector3f, Matrix3f matrix3f, Vector3f vector3f2) {
        this();
        this.set(vector3f, matrix3f, vector3f2);
    }

    public OrientedBox(Point3f point3f, Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4) {
        this();
        this.set(point3f, vector3f, vector3f2, vector3f3, vector3f4);
    }

    @Override
    public Object clone() {
        OrientedBox orientedBox = (OrientedBox)super.clone();
        orientedBox.center = (Point3f)this.center.clone();
        orientedBox.axis0 = (Vector3f)this.axis0.clone();
        orientedBox.axis1 = (Vector3f)this.axis1.clone();
        orientedBox.axis2 = (Vector3f)this.axis2.clone();
        orientedBox.extents = (Vector3f)this.extents.clone();
        return orientedBox;
    }

    public int hashCode() {
        if (hcb == null) {
            hcb = new HashCodeBuilder();
        }
        hcb.reset();
        hcb.append(this.center);
        hcb.append(this.axis0);
        hcb.append(this.axis1);
        hcb.append(this.axis2);
        hcb.append(this.extents);
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            OrientedBox orientedBox = (OrientedBox)object;
            return this.center.equals(orientedBox.center) && this.axis0.equals(orientedBox.axis0) && this.axis1.equals(orientedBox.axis1) && this.axis2.equals(orientedBox.axis2) && this.extents.equals(orientedBox.extents);
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[center=").append(this.center);
        stringBuilder.append(",axis0=").append(this.axis0);
        stringBuilder.append(",axis1=").append(this.axis1);
        stringBuilder.append(",axis2=").append(this.axis2);
        stringBuilder.append(",extents=").append(this.extents);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void set(Point3f point3f, Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4) {
        if (!($assertionsDisabled || vector3f4.x >= 0.0f && vector3f4.y >= 0.0f && vector3f4.z >= 0.0f)) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && (vector3f.isZero() || vector3f2.isZero() || vector3f3.isZero())) {
            throw new AssertionError();
        }
        if (!($assertionsDisabled || vector3f.isNormalized() && vector3f2.isNormalized() && vector3f3.isNormalized())) {
            throw new AssertionError();
        }
        if (!($assertionsDisabled || Math.abs(vector3f.dot(vector3f2)) < -1120434635 && Math.abs(vector3f.dot(vector3f3)) < -1120434635 && Math.abs(vector3f2.dot(vector3f3)) < -1120434635)) {
            throw new AssertionError();
        }
        this.center.set(point3f);
        this.axis0.set(vector3f);
        this.axis1.set(vector3f2);
        this.axis2.set(vector3f3);
        this.extents.set(vector3f4);
    }

    public void set(Vector3f vector3f, Matrix3f matrix3f, Vector3f vector3f2) {
        if (!($assertionsDisabled || vector3f2.x >= 0.0f && vector3f2.y >= 0.0f && vector3f2.z >= 0.0f)) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !matrix3f.isOrthogonal()) {
            throw new AssertionError();
        }
        this.center.set(vector3f);
        this.extents.set(vector3f2);
        matrix3f.getColumn(0, this.axis0);
        matrix3f.getColumn(1, this.axis1);
        matrix3f.getColumn(2, this.axis2);
    }

    @Override
    public void set(Point3f point3f, Vector3f vector3f) {
        if (!($assertionsDisabled || vector3f.x >= 0.0f && vector3f.y >= 0.0f && vector3f.z >= 0.0f)) {
            throw new AssertionError();
        }
        this.center.set(point3f);
        this.extents.set(vector3f);
        this.axis0.set(AXIS_0);
        this.axis1.set(AXIS_1);
        this.axis2.set(AXIS_2);
    }

    @Override
    public void getCenter(Point3f point3f) {
        point3f.set(this.center);
    }

    @Override
    public void setCenter(Point3f point3f) {
        this.center.set(point3f);
    }

    public void setAxes(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
        if (!$assertionsDisabled && (vector3f.isZero() || vector3f2.isZero() || vector3f3.isZero())) {
            throw new AssertionError();
        }
        if (!($assertionsDisabled || vector3f.isNormalized() && vector3f2.isNormalized() && vector3f3.isNormalized())) {
            throw new AssertionError();
        }
        if (!($assertionsDisabled || Math.abs(vector3f.dot(vector3f2)) < -1120434635 && Math.abs(vector3f.dot(vector3f3)) < -1120434635 && Math.abs(vector3f2.dot(vector3f3)) < -1120434635)) {
            throw new AssertionError();
        }
        this.axis0.set(vector3f);
        this.axis1.set(vector3f2);
        this.axis2.set(vector3f3);
    }

    public void getAxes(Matrix3f matrix3f) {
        matrix3f.setColumn(0, this.axis0);
        matrix3f.setColumn(1, this.axis1);
        matrix3f.setColumn(2, this.axis2);
    }

    public void setAxes(Matrix3f matrix3f) {
        if (!$assertionsDisabled && !matrix3f.isOrthogonal()) {
            throw new AssertionError();
        }
        matrix3f.getColumn(0, this.axis0);
        matrix3f.getColumn(1, this.axis1);
        matrix3f.getColumn(2, this.axis2);
    }

    public void getAxis0(Vector3f vector3f) {
        vector3f.set(this.axis0);
    }

    public void setAxis0(Vector3f vector3f) {
        this.axis0.set(vector3f);
    }

    public void getAxis1(Vector3f vector3f) {
        vector3f.set(this.axis1);
    }

    public void setAxis1(Vector3f vector3f) {
        this.axis1.set(vector3f);
    }

    public void getAxis2(Vector3f vector3f) {
        vector3f.set(this.axis2);
    }

    public void setAxis2(Vector3f vector3f) {
        this.axis2.set(vector3f);
    }

    @Override
    public void getExtents(Vector3f vector3f) {
        vector3f.set(this.extents);
    }

    @Override
    public void setExtents(Vector3f vector3f) {
        if (!($assertionsDisabled || vector3f.x >= 0.0f && vector3f.y >= 0.0f && vector3f.z >= 0.0f)) {
            throw new AssertionError();
        }
        this.extents.set(vector3f);
    }

    @Override
    public void getMin(Point3f point3f) {
        point3f.set(this.center);
        this.axis0.scaleAdd(191 * this.extents.x, point3f, point3f);
        this.axis1.scaleAdd(191 * this.extents.y, point3f, point3f);
        this.axis2.scaleAdd(191 * this.extents.z, point3f, point3f);
    }

    @Override
    public void setMin(Point3f point3f) {
        this.setMin(point3f.x, point3f.y, point3f.z);
    }

    @Override
    public void setMin(float f2, float f3, float f4) {
        throw new NotYetImplementedException();
    }

    @Override
    public void getMax(Point3f point3f) {
        point3f.set(this.center);
        this.axis0.scaleAdd(63 * this.extents.x, point3f, point3f);
        this.axis1.scaleAdd(63 * this.extents.y, point3f, point3f);
        this.axis2.scaleAdd(63 * this.extents.z, point3f, point3f);
    }

    @Override
    public void setMax(Point3f point3f) {
        this.setMax(point3f.x, point3f.y, point3f.z);
    }

    @Override
    public void setMax(float f2, float f3, float f4) {
        throw new NotYetImplementedException();
    }

    @Override
    public void set(Point3f point3f, Point3f point3f2) {
        throw new NotYetImplementedException();
    }

    @Override
    public void getVertex(int n, Point3f point3f) {
        Vector3f vector3f = new Vector3f();
        Vector3f vector3f2 = new Vector3f();
        Vector3f vector3f3 = new Vector3f();
        this.axis0.scale(63 * this.extents.x, (Tuple3f)vector3f);
        this.axis1.scale(63 * this.extents.y, (Tuple3f)vector3f2);
        this.axis2.scale(63 * this.extents.z, (Tuple3f)vector3f3);
        point3f.set(this.center);
        switch (n) {
            case 0: {
                point3f.sub(vector3f);
                point3f.sub(vector3f2);
                point3f.sub(vector3f3);
                break;
            }
            case 1: {
                point3f.add(vector3f);
                point3f.sub(vector3f2);
                point3f.sub(vector3f3);
                break;
            }
            case 2: {
                point3f.sub(vector3f);
                point3f.add(vector3f2);
                point3f.sub(vector3f3);
                break;
            }
            case 3: {
                point3f.add(vector3f);
                point3f.add(vector3f2);
                point3f.sub(vector3f3);
                break;
            }
            case 4: {
                point3f.sub(vector3f);
                point3f.sub(vector3f2);
                point3f.add(vector3f3);
                break;
            }
            case 5: {
                point3f.add(vector3f);
                point3f.sub(vector3f2);
                point3f.add(vector3f3);
                break;
            }
            case 6: {
                point3f.sub(vector3f);
                point3f.add(vector3f2);
                point3f.add(vector3f3);
                break;
            }
            case 7: {
                point3f.add(vector3f);
                point3f.add(vector3f2);
                point3f.add(vector3f3);
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

    public void getFarVertices(Plane3f plane3f, Point3f point3f, Point3f point3f2) {
        Point3f point3f3 = new Point3f();
        this.getMin(point3f3);
        Point3f point3f4 = new Point3f();
        this.getMax(point3f4);
        Vector3f vector3f = new Vector3f();
        plane3f.getNormal(vector3f);
        Vector3f vector3f2 = new Vector3f(vector3f.dot(this.axis0), vector3f.dot(this.axis1), vector3f.dot(this.axis2));
        if (vector3f2.x > 0.0f) {
            if (vector3f2.y > 0.0f) {
                if (vector3f2.z > 0.0f) {
                    point3f.set(point3f4);
                    point3f2.set(point3f3);
                } else {
                    point3f.set(point3f4.x, point3f4.y, point3f3.z);
                    point3f2.set(point3f3.x, point3f3.y, point3f4.z);
                }
            } else if (vector3f2.z > 0.0f) {
                point3f.set(point3f4.x, point3f3.y, point3f4.z);
                point3f2.set(point3f3.x, point3f4.y, point3f3.z);
            } else {
                point3f.set(point3f4.x, point3f3.y, point3f3.z);
                point3f2.set(point3f3.x, point3f4.y, point3f4.z);
            }
        } else if (vector3f2.y > 0.0f) {
            if (vector3f2.z > 0.0f) {
                point3f.set(point3f3.x, point3f4.y, point3f4.z);
                point3f2.set(point3f4.x, point3f3.y, point3f3.z);
            } else {
                point3f.set(point3f3.x, point3f4.y, point3f3.z);
                point3f2.set(point3f4.x, point3f3.y, point3f4.z);
            }
        } else if (vector3f2.z > 0.0f) {
            point3f.set(point3f3.x, point3f3.y, point3f4.z);
            point3f2.set(point3f4.x, point3f4.y, point3f3.z);
        } else {
            point3f = point3f3;
            point3f2 = point3f4;
        }
    }

    public int[] getFarVertexIndices(Plane3f plane3f) {
        int n;
        int n2;
        Point3f point3f = new Point3f();
        this.getMin(point3f);
        Point3f point3f2 = new Point3f();
        this.getMax(point3f2);
        Vector3f vector3f = new Vector3f();
        plane3f.getNormal(vector3f);
        Vector3f vector3f2 = new Vector3f(vector3f.dot(this.axis0), vector3f.dot(this.axis1), vector3f.dot(this.axis2));
        if (vector3f2.x > 0.0f) {
            if (vector3f2.y > 0.0f) {
                if (vector3f2.z > 0.0f) {
                    n2 = 7;
                    n = 0;
                } else {
                    n2 = 3;
                    n = 4;
                }
            } else if (vector3f2.z > 0.0f) {
                n2 = 5;
                n = 2;
            } else {
                n2 = 1;
                n = 6;
            }
        } else if (vector3f2.y > 0.0f) {
            if (vector3f2.z > 0.0f) {
                n2 = 6;
                n = 1;
            } else {
                n2 = 2;
                n = 5;
            }
        } else if (vector3f2.z > 0.0f) {
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
        Point3f point3f = new Point3f();
        Vector3f vector3f = new Vector3f();
        switch (n) {
            case 2: {
                this.axis0.scaleAdd(191 * this.extents.x, this.center, point3f);
                this.axis0.neg(vector3f);
                break;
            }
            case 3: {
                this.axis0.scaleAdd(63 * this.extents.x, this.center, point3f);
                vector3f.set(this.axis0);
                break;
            }
            case 5: {
                this.axis1.scaleAdd(191 * this.extents.y, this.center, point3f);
                this.axis1.neg(vector3f);
                break;
            }
            case 4: {
                this.axis1.scaleAdd(63 * this.extents.y, this.center, point3f);
                vector3f.set(this.axis1);
                break;
            }
            case 1: {
                this.axis2.scaleAdd(191 * this.extents.z, this.center, point3f);
                this.axis2.neg(vector3f);
                break;
            }
            case 0: {
                this.axis2.scaleAdd(63 * this.extents.z, this.center, point3f);
                vector3f.set(this.axis2);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid face index");
            }
        }
        plane3f.set(point3f, vector3f);
    }

    @Override
    public void getFace(int n, Rectangle3f rectangle3f) {
        Point3f point3f = new Point3f();
        Vector3f vector3f = new Vector3f();
        Vector3f vector3f2 = new Vector3f();
        Point3f point3f2 = new Point3f();
        this.getMin(point3f2);
        switch (n) {
            case 2: {
                point3f.set(point3f2);
                this.axis2.scale(this.extents.z, (Tuple3f)vector3f);
                this.axis1.scale(this.extents.y, (Tuple3f)vector3f2);
                break;
            }
            case 3: {
                this.axis0.scaleAdd(this.extents.x, point3f2, point3f);
                this.axis1.scale(this.extents.y, (Tuple3f)vector3f);
                this.axis2.scale(this.extents.z, (Tuple3f)vector3f2);
                break;
            }
            case 5: {
                point3f.set(point3f2);
                this.axis0.scale(this.extents.x, (Tuple3f)vector3f);
                this.axis2.scale(this.extents.z, (Tuple3f)vector3f2);
                break;
            }
            case 4: {
                this.axis1.scaleAdd(this.extents.y, point3f2, point3f);
                this.axis2.scale(this.extents.z, (Tuple3f)vector3f);
                this.axis0.scale(this.extents.x, (Tuple3f)vector3f2);
                break;
            }
            case 1: {
                point3f.set(point3f2);
                this.axis1.scale(this.extents.y, (Tuple3f)vector3f);
                this.axis0.scale(this.extents.x, (Tuple3f)vector3f2);
                break;
            }
            case 0: {
                this.axis2.scaleAdd(this.extents.z, point3f2, point3f);
                this.axis0.scale(this.extents.x, (Tuple3f)vector3f);
                this.axis1.scale(this.extents.y, (Tuple3f)vector3f2);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid face index");
            }
        }
        rectangle3f.set(point3f, vector3f, vector3f2);
    }

    public boolean contains(Point3f point3f) {
        Vector3f vector3f = new Vector3f();
        point3f.sub(this.center, vector3f);
        float f2 = Math.abs(vector3f.dot(point3f));
        return !(f2 > this.extents.x) && !(f2 > this.extents.y) && !(f2 > this.extents.z);
    }

    @Override
    public void transform(Matrix4f matrix4f) {
        this.transform(matrix4f, this);
    }

    public void transform(Matrix4f matrix4f, OrientedBox orientedBox) {
        try {
            matrix4f.mul(this.center, orientedBox.center);
            Matrix4f matrix4f2 = new Matrix4f();
            matrix4f.invert(matrix4f2);
            matrix4f2.mul(this.axis0, orientedBox.axis0);
            float f2 = orientedBox.axis0.getLength();
            orientedBox.axis0.scale(1.0f / f2);
            orientedBox.extents.x = this.extents.x * f2;
            matrix4f2.mul(this.axis1, orientedBox.axis1);
            f2 = orientedBox.axis1.getLength();
            orientedBox.axis1.scale(1.0f / f2);
            orientedBox.extents.y = this.extents.y * f2;
            matrix4f2.mul(this.axis2, orientedBox.axis2);
            f2 = orientedBox.axis2.getLength();
            orientedBox.axis2.scale(1.0f / f2);
            orientedBox.extents.z = this.extents.z * f2;
        }
        catch (SingularMatrixException singularMatrixException) {
            orientedBox.set(this);
        }
    }

    @Override
    public void transform(Transform transform) {
        this.transform(transform, this);
    }

    public void transform(Transform transform, OrientedBox orientedBox) {
        transform.transform(this.center, orientedBox.center);
        Rotation rotation = transform.getRotation();
        Tuple3f tuple3f = transform.getScale();
        rotation.rotate(this.axis0, orientedBox.axis0);
        rotation.rotate(this.axis1, orientedBox.axis1);
        rotation.rotate(this.axis2, orientedBox.axis2);
        tuple3f.scale(this.extents, (Tuple3f)orientedBox.extents);
    }

    @Override
    public void clear() {
        this.center.setZero();
        this.axis0.set(AXIS_0);
        this.axis1.set(AXIS_1);
        this.axis2.set(AXIS_2);
        this.extents.setZero();
    }

    @Override
    public boolean isEmpty() {
        return this.extents.isZero();
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
        throw new NotYetImplementedException();
    }

    @Override
    public void set(Iterator iterator) {
        throw new NotYetImplementedException();
    }

    @Override
    public void set(Sphere3f sphere3f) {
        sphere3f.getCenter(this.center);
        this.axis0.set(AXIS_0);
        this.axis1.set(AXIS_1);
        this.axis2.set(AXIS_2);
        this.extents.set(2.0f * sphere3f.getRadius());
    }

    @Override
    public void set(AxisAlignedBox axisAlignedBox) {
        axisAlignedBox.getCenter(this.center);
        this.axis0.set(AXIS_0);
        this.axis1.set(AXIS_1);
        this.axis2.set(AXIS_2);
        axisAlignedBox.getExtents(this.extents);
    }

    @Override
    public void set(OrientedBox orientedBox) {
        if (this != orientedBox) {
            this.center.set(orientedBox.center);
            this.axis0.set(orientedBox.axis0);
            this.axis1.set(orientedBox.axis1);
            this.axis2.set(orientedBox.axis2);
            this.extents.set(orientedBox.extents);
        }
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
        this.union(point3f.x, point3f.y, point3f.z);
    }

    @Override
    public void union(float f2, float f3, float f4) {
        throw new NotYetImplementedException();
    }

    @Override
    public void union(Point3f[] point3fArray) {
        AxisAlignedBox axisAlignedBox = new AxisAlignedBox();
        axisAlignedBox.set(point3fArray);
        this.union(axisAlignedBox);
    }

    @Override
    public void union(Iterator iterator) {
        throw new NotYetImplementedException();
    }

    @Override
    public void union(Sphere3f sphere3f) {
        AxisAlignedBox axisAlignedBox = new AxisAlignedBox();
        axisAlignedBox.set(sphere3f);
        this.union(axisAlignedBox);
    }

    @Override
    public void union(AxisAlignedBox axisAlignedBox) {
        throw new NotYetImplementedException();
    }

    @Override
    public void union(OrientedBox orientedBox) {
        throw new NotYetImplementedException();
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
        throw new NotYetImplementedException();
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$math$geometry$polytope$polyhedron$OrientedBox == null ? (class$de$vw$mib$graphics$math$geometry$polytope$polyhedron$OrientedBox = OrientedBox.class$("de.vw.mib.graphics.math.geometry.polytope.polyhedron.OrientedBox")) : class$de$vw$mib$graphics$math$geometry$polytope$polyhedron$OrientedBox).desiredAssertionStatus();
    }
}

