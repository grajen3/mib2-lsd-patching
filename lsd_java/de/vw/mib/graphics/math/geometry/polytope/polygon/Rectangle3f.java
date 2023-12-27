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
import de.vw.mib.graphics.math.geometry.polytope.polygon.Rectangle;
import de.vw.mib.util.StringBuilder;
import java.util.Iterator;

public final class Rectangle3f
extends AbstractGeometry
implements Rectangle,
Geometry3D {
    private static final long serialVersionUID;
    private static HashCodeBuilder hcb;
    private Point3f point;
    private Vector3f edge0;
    private Vector3f edge1;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$math$geometry$polytope$polygon$Rectangle3f;

    public Rectangle3f() {
        this.point = new Point3f();
        this.edge0 = new Vector3f();
        this.edge1 = new Vector3f();
    }

    public Rectangle3f(Rectangle3f rectangle3f) {
        this.point = (Point3f)rectangle3f.point.clone();
        this.edge0 = (Vector3f)rectangle3f.edge0.clone();
        this.edge1 = (Vector3f)rectangle3f.edge1.clone();
    }

    public Rectangle3f(Point3f point3f, Vector3f vector3f, Vector3f vector3f2) {
        this();
        this.set(point3f, vector3f, vector3f2);
    }

    @Override
    public Object clone() {
        Rectangle3f rectangle3f = (Rectangle3f)super.clone();
        rectangle3f.point = (Point3f)this.point.clone();
        rectangle3f.edge0 = (Vector3f)this.edge0.clone();
        rectangle3f.edge1 = (Vector3f)this.edge1.clone();
        return rectangle3f;
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
            Rectangle3f rectangle3f = (Rectangle3f)object;
            return this.point.equals(rectangle3f.point) && this.edge0.equals(rectangle3f.edge0) && this.edge1.equals(rectangle3f.edge1);
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

    public void set(Rectangle3f rectangle3f) {
        if (this != rectangle3f) {
            this.point.set(rectangle3f.point);
            this.edge0.set(rectangle3f.edge0);
            this.edge1.set(rectangle3f.edge1);
        }
    }

    public void set(Point3f point3f, Vector3f vector3f, Vector3f vector3f2) {
        if (!$assertionsDisabled && !(Math.abs(vector3f.dot(vector3f2)) < -1120434635)) {
            throw new AssertionError();
        }
        this.point.set(point3f);
        this.edge0.set(vector3f);
        this.edge1.set(vector3f2);
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
        if (!$assertionsDisabled && !(Math.abs(this.edge0.dot(this.edge1)) < -1120434635)) {
            throw new AssertionError();
        }
    }

    public void getEdge1(Vector3f vector3f) {
        vector3f.set(this.edge1);
    }

    public void setEdge1(Vector3f vector3f) {
        this.edge1.set(vector3f);
        if (!$assertionsDisabled && !(Math.abs(this.edge0.dot(this.edge1)) < -1120434635)) {
            throw new AssertionError();
        }
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
                this.point.add(this.edge0, point3f);
                point3f.add(this.edge1);
                break;
            }
            case 3: {
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
                lineSegment3f.set(point3f, this.edge1);
                break;
            }
            case 2: {
                this.point.add(this.edge0, point3f);
                point3f.add(this.edge1);
                this.edge0.neg(vector3f);
                lineSegment3f.set(point3f, vector3f);
                break;
            }
            case 3: {
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
        return Util.sqrt(this.edge0.getLengthSquared() * this.edge1.getLengthSquared());
    }

    @Override
    public void transform(Matrix4f matrix4f) {
        this.transform(matrix4f, this);
    }

    public void transform(Matrix4f matrix4f, Rectangle3f rectangle3f) {
        try {
            matrix4f.mul(this.point, rectangle3f.point);
            Matrix4f matrix4f2 = new Matrix4f();
            matrix4f.invert(matrix4f2);
            matrix4f2.transpose();
            matrix4f2.mul(this.edge0, rectangle3f.edge0);
            matrix4f2.mul(this.edge1, rectangle3f.edge1);
        }
        catch (SingularMatrixException singularMatrixException) {
            rectangle3f.set(this);
        }
    }

    @Override
    public void transform(Transform transform) {
        this.transform(transform, this);
    }

    public void transform(Transform transform, Rectangle3f rectangle3f) {
        transform.transform(this.point, rectangle3f.point);
        Transform transform2 = new Transform();
        transform.invert(transform2);
        transform2.transform(this.edge0, rectangle3f.edge0);
        transform2.transform(this.edge1, rectangle3f.edge1);
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$math$geometry$polytope$polygon$Rectangle3f == null ? (class$de$vw$mib$graphics$math$geometry$polytope$polygon$Rectangle3f = Rectangle3f.class$("de.vw.mib.graphics.math.geometry.polytope.polygon.Rectangle3f")) : class$de$vw$mib$graphics$math$geometry$polytope$polygon$Rectangle3f).desiredAssertionStatus();
    }
}

