/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.geometry;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.math.algebra.Matrix3f;
import de.vw.mib.graphics.math.algebra.Vector2f;
import de.vw.mib.graphics.math.geometry.Geometry2D;
import de.vw.mib.graphics.math.geometry.Line;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.util.StringBuilder;

public final class Line2f
implements Line,
Geometry2D {
    private static final long serialVersionUID;
    private static HashCodeBuilder hcb;
    private Point2f origin;
    private Vector2f direction;

    public Line2f() {
        this.origin = new Point2f();
        this.direction = new Vector2f();
    }

    public Line2f(Line2f line2f) {
        this(line2f.origin, line2f.direction);
    }

    public Line2f(Point2f point2f, Vector2f vector2f) {
        this.origin = (Point2f)point2f.clone();
        this.direction = (Vector2f)vector2f.clone();
    }

    @Override
    public Object clone() {
        try {
            Line2f line2f = (Line2f)super.clone();
            line2f.origin = (Point2f)this.origin.clone();
            line2f.direction = (Vector2f)this.direction.clone();
            return line2f;
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
            Line2f line2f = (Line2f)object;
            return this.origin.equals(line2f.origin) && this.direction.equals(line2f.direction);
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

    public void set(Line2f line2f) {
        if (this != line2f) {
            this.origin.set(line2f.origin);
            this.direction.set(line2f.direction);
        }
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

    public float getSlope() {
        throw new NotYetImplementedException();
    }

    public float getDistanceToOrigin() {
        throw new NotYetImplementedException();
    }

    public void transform(Matrix3f matrix3f, Line2f line2f) {
        throw new NotYetImplementedException();
    }

    @Override
    public void transform(Matrix3f matrix3f) {
        this.transform(matrix3f, this);
    }
}

