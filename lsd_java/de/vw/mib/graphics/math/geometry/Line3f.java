/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.geometry;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.math.geometry.Geometry3D;
import de.vw.mib.graphics.math.geometry.Line;
import de.vw.mib.graphics.math.geometry.Point3f;
import de.vw.mib.util.StringBuilder;

public final class Line3f
implements Line,
Geometry3D {
    private static final long serialVersionUID;
    private static HashCodeBuilder hcb;
    private Point3f origin;
    private Vector3f direction;

    public Line3f() {
        this.origin = new Point3f();
        this.direction = new Vector3f();
    }

    public Line3f(Line3f line3f) {
        this(line3f.origin, line3f.direction);
    }

    public Line3f(Point3f point3f, Vector3f vector3f) {
        this.origin = (Point3f)point3f.clone();
        this.direction = (Vector3f)vector3f.clone();
    }

    @Override
    public Object clone() {
        try {
            Line3f line3f = (Line3f)super.clone();
            line3f.origin = (Point3f)this.origin.clone();
            line3f.direction = (Vector3f)this.direction.clone();
            return line3f;
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
            Line3f line3f = (Line3f)object;
            return this.origin.equals(line3f.origin) && this.direction.equals(line3f.direction);
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

    public void set(Line3f line3f) {
        if (this != line3f) {
            this.origin.set(line3f.origin);
            this.direction.set(line3f.direction);
        }
    }

    public void getOrigin(Point3f point3f) {
        point3f.set(this.origin);
    }

    public void setOrigin(Point3f point3f) {
        this.origin.set(point3f);
    }

    public void getDirection(Vector3f vector3f) {
        vector3f.set(this.direction);
    }

    public void setDirection(Vector3f vector3f) {
        this.direction.set(vector3f);
    }

    public float getSlope() {
        throw new NotYetImplementedException();
    }

    public float getDistanceToOrigin() {
        throw new NotYetImplementedException();
    }

    public void transform(Matrix4f matrix4f, Line3f line3f) {
        throw new NotYetImplementedException();
    }

    @Override
    public void transform(Matrix4f matrix4f) {
        this.transform(matrix4f, this);
    }

    public void transform(Transform transform, Line3f line3f) {
        throw new NotYetImplementedException();
    }

    @Override
    public void transform(Transform transform) {
        this.transform(transform, this);
    }
}

