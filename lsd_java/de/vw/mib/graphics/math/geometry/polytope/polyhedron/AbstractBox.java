/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.geometry.polytope.polyhedron;

import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.math.geometry.AbstractGeometry;
import de.vw.mib.graphics.math.geometry.Plane3f;
import de.vw.mib.graphics.math.geometry.Point3f;
import de.vw.mib.graphics.math.geometry.polytope.polygon.Rectangle3f;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.Box;

public abstract class AbstractBox
extends AbstractGeometry
implements Box {
    private static final long serialVersionUID;
    protected static final Vector3f AXIS_0;
    protected static final Vector3f AXIS_1;
    protected static final Vector3f AXIS_2;

    @Override
    public Object clone() {
        AbstractBox abstractBox = (AbstractBox)super.clone();
        return abstractBox;
    }

    @Override
    public final float getVolume() {
        Vector3f vector3f = new Vector3f();
        this.getExtents(vector3f);
        return vector3f.x * vector3f.y * vector3f.z;
    }

    @Override
    public abstract void set(Point3f point3f, Vector3f vector3f) {
    }

    @Override
    public abstract void getCenter(Point3f point3f) {
    }

    @Override
    public abstract void setCenter(Point3f point3f) {
    }

    @Override
    public abstract void getExtents(Vector3f vector3f) {
    }

    @Override
    public abstract void setExtents(Vector3f vector3f) {
    }

    @Override
    public abstract void getMin(Point3f point3f) {
    }

    @Override
    public abstract void setMin(Point3f point3f) {
    }

    @Override
    public abstract void setMin(float f2, float f3, float f4) {
    }

    @Override
    public abstract void getMax(Point3f point3f) {
    }

    @Override
    public abstract void setMax(Point3f point3f) {
    }

    @Override
    public abstract void setMax(float f2, float f3, float f4) {
    }

    @Override
    public abstract void set(Point3f point3f, Point3f point3f2) {
    }

    @Override
    public abstract void getVertex(int n, Point3f point3f) {
    }

    @Override
    public abstract void getFace(int n, Plane3f plane3f) {
    }

    @Override
    public abstract void getFace(int n, Rectangle3f rectangle3f) {
    }

    @Override
    public abstract void transform(Matrix4f matrix4f) {
    }

    @Override
    public abstract void transform(Transform transform) {
    }

    static {
        AXIS_0 = new Vector3f(1.0f, 0.0f, 0.0f);
        AXIS_1 = new Vector3f(0.0f, 1.0f, 0.0f);
        AXIS_2 = new Vector3f(0.0f, 0.0f, 1.0f);
    }
}

