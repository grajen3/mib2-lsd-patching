/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.geometry;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.math.algebra.Matrix3f;
import de.vw.mib.graphics.math.algebra.Vector2f;
import de.vw.mib.graphics.math.geometry.Geometry2D;
import de.vw.mib.graphics.math.geometry.LineSegment;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.util.StringBuilder;

public final class LineSegment2f
implements LineSegment,
Geometry2D {
    private static final long serialVersionUID;
    private static HashCodeBuilder hcb;
    private Point2f origin;
    private Vector2f direction;

    public LineSegment2f() {
        this.origin = new Point2f();
        this.direction = new Vector2f();
    }

    public LineSegment2f(LineSegment2f lineSegment2f) {
        this(lineSegment2f.origin, lineSegment2f.direction);
    }

    public LineSegment2f(Point2f point2f, Vector2f vector2f) {
        this.origin = (Point2f)point2f.clone();
        this.direction = (Vector2f)vector2f.clone();
    }

    @Override
    public Object clone() {
        try {
            LineSegment2f lineSegment2f = (LineSegment2f)super.clone();
            lineSegment2f.origin = (Point2f)this.origin.clone();
            lineSegment2f.direction = (Vector2f)this.direction.clone();
            return lineSegment2f;
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
        hcb.append(this.origin);
        hcb.append(this.direction);
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            LineSegment2f lineSegment2f = (LineSegment2f)object;
            return this.origin.equals(lineSegment2f.origin) && this.direction.equals(lineSegment2f.direction);
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[origin=").append(this.origin);
        stringBuilder.append(",direction=").append(this.direction);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void set(LineSegment2f lineSegment2f) {
        if (this != lineSegment2f) {
            this.origin.set(lineSegment2f.origin);
            this.direction.set(lineSegment2f.direction);
        }
    }

    public void set(Point2f point2f, Vector2f vector2f) {
        this.origin.set(point2f);
        this.direction.set(vector2f);
    }

    public void getOrigin(Point2f point2f) {
        point2f.set(this.origin);
    }

    public void setOrigin(Point2f point2f) {
        this.origin.set(point2f);
    }

    public void getDirection(Vector2f vector2f) {
        vector2f.set(this.direction);
    }

    public void setDirection(Vector2f vector2f) {
        this.direction.set(vector2f);
    }

    public float getLength() {
        return this.direction.getLength();
    }

    public float getSlope() {
        throw new NotYetImplementedException();
    }

    public float getDistanceToOrigin() {
        throw new NotYetImplementedException();
    }

    public void transform(Matrix3f matrix3f, LineSegment2f lineSegment2f) {
        throw new NotYetImplementedException();
    }

    @Override
    public void transform(Matrix3f matrix3f) {
        this.transform(matrix3f, this);
    }
}

