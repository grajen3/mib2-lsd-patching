/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.geometry.polytope.polygon;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Matrix3f;
import de.vw.mib.graphics.math.algebra.SingularMatrixException;
import de.vw.mib.graphics.math.algebra.Vector2f;
import de.vw.mib.graphics.math.geometry.AbstractGeometry;
import de.vw.mib.graphics.math.geometry.Geometry2D;
import de.vw.mib.graphics.math.geometry.LineSegment2f;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.graphics.math.geometry.polytope.polygon.Rectangle;
import de.vw.mib.util.StringBuilder;
import java.util.Iterator;

public final class Rectangle2f
extends AbstractGeometry
implements Rectangle,
Geometry2D {
    private static final long serialVersionUID;
    private static HashCodeBuilder hcb;
    private Point2f point;
    private Vector2f edge0;
    private Vector2f edge1;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$math$geometry$polytope$polygon$Rectangle2f;

    public Rectangle2f() {
        this.point = new Point2f();
        this.edge0 = new Vector2f();
        this.edge1 = new Vector2f();
    }

    public Rectangle2f(Rectangle2f rectangle2f) {
        this.point = (Point2f)rectangle2f.point.clone();
        this.edge0 = (Vector2f)rectangle2f.edge0.clone();
        this.edge1 = (Vector2f)rectangle2f.edge1.clone();
    }

    public Rectangle2f(Point2f point2f, Vector2f vector2f, Vector2f vector2f2) {
        this();
        this.set(point2f, vector2f, vector2f2);
    }

    @Override
    public Object clone() {
        Rectangle2f rectangle2f = (Rectangle2f)super.clone();
        rectangle2f.point = (Point2f)this.point.clone();
        rectangle2f.edge0 = (Vector2f)this.edge0.clone();
        rectangle2f.edge1 = (Vector2f)this.edge1.clone();
        return rectangle2f;
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
            Rectangle2f rectangle2f = (Rectangle2f)object;
            return this.point.equals(rectangle2f.point) && this.edge0.equals(rectangle2f.edge0) && this.edge1.equals(rectangle2f.edge1);
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

    public void set(Rectangle2f rectangle2f) {
        if (this != rectangle2f) {
            this.point.set(rectangle2f.point);
            this.edge0.set(rectangle2f.edge0);
            this.edge1.set(rectangle2f.edge1);
        }
    }

    public void set(Point2f point2f, Vector2f vector2f, Vector2f vector2f2) {
        if (!$assertionsDisabled && !(Math.abs(vector2f.dot(vector2f2)) < -1120434635)) {
            throw new AssertionError();
        }
        this.point.set(point2f);
        this.edge0.set(vector2f);
        this.edge1.set(vector2f2);
    }

    public void getPoint(Point2f point2f) {
        point2f.set(this.point);
    }

    public void setPoint(Point2f point2f) {
        this.point.set(point2f);
    }

    public void getEdge0(Vector2f vector2f) {
        vector2f.set(this.edge0);
    }

    public void setEdge0(Vector2f vector2f) {
        this.edge0.set(vector2f);
        if (!$assertionsDisabled && !(Math.abs(this.edge0.dot(this.edge1)) < -1120434635)) {
            throw new AssertionError();
        }
    }

    public void getEdge1(Vector2f vector2f) {
        vector2f.set(this.edge1);
    }

    public void setEdge1(Vector2f vector2f) {
        this.edge1.set(vector2f);
        if (!$assertionsDisabled && !(Math.abs(this.edge0.dot(this.edge1)) < -1120434635)) {
            throw new AssertionError();
        }
    }

    public void getVertex(int n, Point2f point2f) {
        switch (n) {
            case 0: {
                point2f.set(this.point);
                break;
            }
            case 1: {
                this.point.add(this.edge0, point2f);
                break;
            }
            case 2: {
                this.point.add(this.edge0, point2f);
                point2f.add(this.edge1);
                break;
            }
            case 3: {
                this.point.add(this.edge1, point2f);
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

    public void getEdge(int n, LineSegment2f lineSegment2f) {
        Point2f point2f = new Point2f();
        Vector2f vector2f = new Vector2f();
        switch (n) {
            case 0: {
                lineSegment2f.set(this.point, this.edge0);
                break;
            }
            case 1: {
                this.point.add(this.edge0, point2f);
                lineSegment2f.set(point2f, this.edge1);
                break;
            }
            case 2: {
                this.point.add(this.edge0, point2f);
                point2f.add(this.edge1);
                this.edge0.neg(vector2f);
                lineSegment2f.set(point2f, vector2f);
                break;
            }
            case 3: {
                this.point.add(this.edge1, point2f);
                this.edge1.neg(vector2f);
                lineSegment2f.set(point2f, vector2f);
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
    public void transform(Matrix3f matrix3f) {
        this.transform(matrix3f, this);
    }

    public void transform(Matrix3f matrix3f, Rectangle2f rectangle2f) {
        try {
            matrix3f.mul(this.point, rectangle2f.point);
            Matrix3f matrix3f2 = new Matrix3f();
            matrix3f.invert(matrix3f2);
            matrix3f2.transpose();
            matrix3f2.mul(this.edge0, rectangle2f.edge0);
            matrix3f2.mul(this.edge1, rectangle2f.edge1);
        }
        catch (SingularMatrixException singularMatrixException) {
            rectangle2f.set(this);
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$math$geometry$polytope$polygon$Rectangle2f == null ? (class$de$vw$mib$graphics$math$geometry$polytope$polygon$Rectangle2f = Rectangle2f.class$("de.vw.mib.graphics.math.geometry.polytope.polygon.Rectangle2f")) : class$de$vw$mib$graphics$math$geometry$polytope$polygon$Rectangle2f).desiredAssertionStatus();
    }
}

