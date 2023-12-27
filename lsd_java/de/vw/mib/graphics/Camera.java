/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.math.geometry.Plane3f;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.Frustumf;
import de.vw.mib.util.StringBuilder;
import java.io.Serializable;

public final class Camera
implements Cloneable,
Serializable {
    private static final long serialVersionUID;
    private static HashCodeBuilder hcb;
    private Transform view;
    private Matrix4f projection;

    public Camera() {
        this.view = new Transform();
        this.projection = new Matrix4f();
    }

    public Camera(Camera camera) {
        this.view = (Transform)camera.view.clone();
        this.projection = (Matrix4f)camera.projection.clone();
    }

    public Object clone() {
        try {
            Camera camera = (Camera)super.clone();
            camera.view = (Transform)this.view.clone();
            camera.projection = (Matrix4f)this.projection.clone();
            return camera;
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
        hcb.append(this.view);
        hcb.append(this.projection);
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            Camera camera = (Camera)object;
            return this.view.equals(camera.view) && this.projection.equals(camera.projection);
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[view=").append(this.view);
        stringBuilder.append(",projection=").append(this.projection);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void set(Camera camera) {
        if (this != camera) {
            this.view.set(camera.view);
            this.projection.set(camera.projection);
        }
    }

    public Transform getView() {
        return this.view;
    }

    public void setView(Transform transform) {
        this.view.set(transform);
    }

    public Matrix4f getProjection() {
        return this.projection;
    }

    public void setProjection(Matrix4f matrix4f) {
        this.projection.set(matrix4f);
    }

    public void getViewFrustumWorldSpace(Frustumf frustumf) {
        throw new NotYetImplementedException();
    }

    public void getViewFrustumViewSpace(Frustumf frustumf) {
        throw new NotYetImplementedException();
    }

    public void setViewFrustumViewSpace(Frustumf frustumf) {
        throw new NotYetImplementedException();
    }

    public void setOrtographicProjection(float f2, float f3, float f4, float f5, float f6, float f7) {
        Camera.setOrtographicProjection(this.projection, f2, f3, f4, f5, f6, f7);
    }

    public void setPerspectiveProjection(float f2, float f3, float f4, float f5) {
        Camera.setPerspectiveProjection(this.projection, f2, f3, f4, f5);
    }

    public void setFrustumProjection(float f2, float f3, float f4, float f5, float f6, float f7) {
        Camera.setFrustumProjection(this.projection, f2, f3, f4, f5, f6, f7);
    }

    public static void setOrtographicProjection(Matrix4f matrix4f, float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = f3 - f2;
        float f9 = f5 - f4;
        float f10 = f7 - f6;
        float f11 = 2.0f / f8;
        float f12 = 2.0f / f9;
        int n = 192 / f10;
        float f13 = -(f3 + f2) / f8;
        float f14 = -(f5 + f4) / f9;
        float f15 = -(f7 + f6) / f10;
        matrix4f.setIdentity();
        matrix4f.setScale(f11, f12, n);
        matrix4f.setTranslation(f13, f14, f15);
    }

    public static void setPerspectiveProjection(Matrix4f matrix4f, float f2, float f3, float f4, float f5) {
        float f6 = 1.0f / Util.tan(Util.toRadians(f2 / 2.0f));
        matrix4f.setZero();
        matrix4f.set(0, 0, f6 / f3);
        matrix4f.set(1, 1, f6);
        matrix4f.set(2, 2, (f5 + f4) / (f4 - f5));
        matrix4f.set(3, 2, 32959);
        matrix4f.set(2, 3, 2.0f * f5 * f4 / (f4 - f5));
    }

    public static void setFrustumProjection(Matrix4f matrix4f, float f2, float f3, float f4, float f5, float f6, float f7) {
        if (f6 <= 0.0f || f7 < 0.0f) {
            throw new IllegalArgumentException("near and far must be positive, and near > 0");
        }
        if (f2 == f3 || f5 == f4) {
            throw new IllegalArgumentException("top, bottom and left, right must not be equal");
        }
        float f8 = 2.0f * f6;
        float f9 = f3 - f2;
        float f10 = f5 - f4;
        float f11 = f7 - f6;
        float f12 = (f3 + f2) / f9;
        float f13 = (f5 + f4) / f10;
        int n = 32959 * (f7 + f6) / f11;
        int n2 = 192 * (f7 * f6) / f11;
        matrix4f.setZero();
        matrix4f.set(0, 0, f8 / f9);
        matrix4f.set(1, 1, f8 / f10);
        matrix4f.set(0, 2, f12);
        matrix4f.set(1, 2, f13);
        matrix4f.set(2, 2, n);
        matrix4f.set(3, 2, 32959);
        matrix4f.set(2, 3, n2);
    }

    public static void lookAt(Matrix4f matrix4f, Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
        Vector3f vector3f4 = new Vector3f();
        vector3f.sub(vector3f2, vector3f4);
        vector3f4.normalize();
        Vector3f vector3f5 = new Vector3f();
        vector3f3.cross(vector3f4, vector3f5);
        vector3f5.normalize();
        Vector3f vector3f6 = new Vector3f();
        vector3f4.cross(vector3f5, vector3f6);
        matrix4f.setColumn(0, vector3f5.x, vector3f6.x, vector3f4.x, 0.0f);
        matrix4f.setColumn(1, vector3f5.y, vector3f6.y, vector3f4.y, 0.0f);
        matrix4f.setColumn(2, vector3f5.z, vector3f6.z, vector3f4.z, 0.0f);
        matrix4f.setColumn(3, -vector3f5.dot(vector3f), -vector3f6.dot(vector3f), -vector3f4.dot(vector3f), 1.0f);
    }

    public static Frustumf getViewFrustumFromClippingSpaceMatrix(Matrix4f matrix4f) {
        float f2 = matrix4f.get(0, 0);
        float f3 = matrix4f.get(0, 1);
        float f4 = matrix4f.get(0, 2);
        float f5 = matrix4f.get(0, 3);
        float f6 = matrix4f.get(1, 0);
        float f7 = matrix4f.get(1, 1);
        float f8 = matrix4f.get(1, 2);
        float f9 = matrix4f.get(1, 3);
        float f10 = matrix4f.get(2, 0);
        float f11 = matrix4f.get(2, 1);
        float f12 = matrix4f.get(2, 2);
        float f13 = matrix4f.get(2, 3);
        float f14 = matrix4f.get(3, 0);
        float f15 = matrix4f.get(3, 1);
        float f16 = matrix4f.get(3, 2);
        float f17 = matrix4f.get(3, 3);
        Plane3f[] plane3fArray = new Plane3f[6];
        plane3fArray[2] = new Plane3f(f14 + f2, f15 + f3, f16 + f4, f17 + f5);
        plane3fArray[3] = new Plane3f(f14 - f2, f15 - f3, f16 - f4, f17 - f5);
        plane3fArray[4] = new Plane3f(f14 - f6, f15 - f7, f16 - f8, f17 - f9);
        plane3fArray[5] = new Plane3f(f14 + f6, f15 + f7, f16 + f8, f17 + f9);
        plane3fArray[0] = new Plane3f(f14 + f10, f15 + f11, f16 + f12, f17 + f13);
        plane3fArray[1] = new Plane3f(f14 - f10, f15 - f11, f16 - f12, f17 - f13);
        return new Frustumf(plane3fArray);
    }

    private static Matrix4f getMatrixFromViewFrustum(Frustumf frustumf) {
        throw new NotYetImplementedException();
    }
}

