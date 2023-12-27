/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.geometry.polytope.polygon;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.math.algebra.SingularMatrixException;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.math.geometry.AbstractGeometry;
import de.vw.mib.graphics.math.geometry.Geometry3D;
import de.vw.mib.graphics.math.geometry.LineSegment3f;
import de.vw.mib.graphics.math.geometry.Point3f;
import de.vw.mib.graphics.math.geometry.polytope.polygon.Triangle;
import de.vw.mib.util.StringBuilder;
import java.util.Iterator;

public final class Triangle3f
extends AbstractGeometry
implements Triangle,
Geometry3D {
    private static final long serialVersionUID;
    private static HashCodeBuilder hcb;
    private Point3f point;
    private Vector3f edge0;
    private Vector3f edge1;

    public Triangle3f() {
        this.point = new Point3f();
        this.edge0 = new Vector3f();
        this.edge1 = new Vector3f();
    }

    public Triangle3f(Triangle3f triangle3f) {
        this.point = (Point3f)triangle3f.point.clone();
        this.edge0 = (Vector3f)triangle3f.edge0.clone();
        this.edge1 = (Vector3f)triangle3f.edge1.clone();
    }

    public Triangle3f(Point3f point3f, Vector3f vector3f, Vector3f vector3f2) {
        this();
        this.set(point3f, vector3f, vector3f2);
    }

    public Triangle3f(Point3f point3f, Point3f point3f2, Point3f point3f3) {
        this();
        this.set(point3f, point3f2, point3f3);
    }

    @Override
    public Object clone() {
        Triangle3f triangle3f = (Triangle3f)super.clone();
        triangle3f.point = (Point3f)this.point.clone();
        triangle3f.edge0 = (Vector3f)this.edge0.clone();
        triangle3f.edge1 = (Vector3f)this.edge1.clone();
        return triangle3f;
    }

    public int hashCode() {
        if (hcb == null) {
            hcb = new HashCodeBuilder();
        }
        hcb.reset();
        hcb.append(this.point);
        hcb.append(this.edge0);
        hcb.append(this.edge1);
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            Triangle3f triangle3f = (Triangle3f)object;
            return this.point.equals(triangle3f.point) && this.edge0.equals(triangle3f.edge0) && this.edge1.equals(triangle3f.edge1);
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[point=").append(this.point);
        stringBuilder.append(",edge0=").append(this.edge0);
        stringBuilder.append(",edge1=").append(this.edge1);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void set(Triangle3f triangle3f) {
        if (this != triangle3f) {
            this.point.set(triangle3f.point);
            this.edge0.set(triangle3f.edge0);
            this.edge1.set(triangle3f.edge1);
        }
    }

    public void set(Point3f point3f, Vector3f vector3f, Vector3f vector3f2) {
        this.point.set(point3f);
        this.edge0.set(vector3f);
        this.edge1.set(vector3f2);
    }

    public void set(Point3f point3f, Point3f point3f2, Point3f point3f3) {
        this.point.set(point3f);
        point3f2.sub(this.point, this.edge0);
        point3f3.sub(this.point, this.edge1);
    }

    public void getPoint(Point3f point3f) {
        point3f.set(this.point);
    }

    public void setPoint(Point3f point3f) {
        this.point.set(point3f);
    }

    public void getEdge0(Vector3f vector3f) {
        vector3f.set(this.edge0);
    }

    public void setEdge0(Vector3f vector3f) {
        this.edge0.set(vector3f);
    }

    public void getEdge1(Vector3f vector3f) {
        vector3f.set(this.edge1);
    }

    public void setEdge1(Vector3f vector3f) {
        this.edge1.set(vector3f);
    }

    public void getVertex0(Point3f point3f) {
        point3f.set(this.point);
    }

    public void setVertex0(Point3f point3f) {
        this.point.set(point3f);
    }

    public void getVertex1(Point3f point3f) {
        this.point.add(this.edge0, point3f);
    }

    public void setVertex1(Point3f point3f) {
        point3f.sub(this.point, this.edge0);
    }

    public void getVertex2(Point3f point3f) {
        this.point.add(this.edge1, point3f);
    }

    public void setVertex2(Point3f point3f) {
        point3f.sub(this.point, this.edge1);
    }

    public void getVertex(int n, Point3f point3f) {
        switch (n) {
            case 0: {
                point3f.set(this.point);
                break;
            }
            case 1: {
                this.point.add(this.edge0, point3f);
                break;
            }
            case 2: {
                this.point.add(this.edge1, point3f);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid vertex index");
            }
        }
    }

    public Iterator getVertices() {
        throw new NotYetImplementedException();
    }

    public void getEdge(int n, LineSegment3f lineSegment3f) {
        Point3f point3f = new Point3f();
        Vector3f vector3f = new Vector3f();
        switch (n) {
            case 0: {
                lineSegment3f.set(this.point, this.edge0);
                break;
            }
            case 1: {
                this.point.add(this.edge0, point3f);
                this.edge1.sub(this.edge0, vector3f);
                lineSegment3f.set(point3f, vector3f);
                break;
            }
            case 2: {
                this.point.add(this.edge1, point3f);
                this.edge1.neg(vector3f);
                lineSegment3f.set(point3f, vector3f);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid vertex index");
            }
        }
    }

    public Iterator getEdges() {
        throw new NotYetImplementedException();
    }

    @Override
    public float getArea() {
        float f2 = this.edge0.getLength() * this.edge1.getLength();
        float f3 = Util.acos(this.edge0.dot(this.edge1) / f2);
        return f2 * Util.sin(f3) / 2.0f;
    }

    @Override
    public void transform(Matrix4f matrix4f) {
        this.transform(matrix4f, this);
    }

    public void transform(Matrix4f matrix4f, Triangle3f triangle3f) {
        try {
            matrix4f.mul(this.point, triangle3f.point);
            Matrix4f matrix4f2 = new Matrix4f();
            matrix4f.invert(matrix4f2);
            matrix4f2.transpose();
            matrix4f2.mul(this.edge0, triangle3f.edge0);
            matrix4f2.mul(this.edge1, triangle3f.edge1);
        }
        catch (SingularMatrixException singularMatrixException) {
            triangle3f.set(this);
        }
    }

    @Override
    public void transform(Transform transform) {
        this.transform(transform, this);
    }

    public void transform(Transform transform, Triangle3f triangle3f) {
        transform.transform(this.point, triangle3f.point);
        Transform transform2 = new Transform();
        transform.invert(transform2);
        transform2.transform(this.edge0, triangle3f.edge0);
        transform2.transform(this.edge1, triangle3f.edge1);
    }
}

