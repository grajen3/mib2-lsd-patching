/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.util;

import de.vw.mib.graphics.Viewport;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.math.algebra.SingularMatrixException;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.math.algebra.Vector4f;

public final class Util {
    private Util() {
    }

    public static Vector4f unproject(Matrix4f matrix4f, Matrix4f matrix4f2, Viewport viewport, float f2, float f3, float f4) {
        Matrix4f matrix4f3 = new Matrix4f();
        Vector4f vector4f = new Vector4f();
        Vector4f vector4f2 = new Vector4f();
        try {
            matrix4f2.mul(matrix4f, matrix4f3);
            matrix4f3.invert();
            vector4f.set(f2, f3, f4, 1.0f);
            vector4f.setX((vector4f.getX() - (float)viewport.getX()) / (float)viewport.getWidth());
            vector4f.setY((vector4f.getY() - (float)viewport.getY()) / (float)viewport.getHeight());
            vector4f.setX(vector4f.getX() * 2.0f - 1.0f);
            vector4f.setY(vector4f.getY() * 2.0f - 1.0f);
            vector4f.setZ(vector4f.getZ() * 2.0f - 1.0f);
            matrix4f3.mul(vector4f, vector4f2);
            if (vector4f2.getZ() == 0.0f) {
                vector4f2.setZero();
                return vector4f2;
            }
            vector4f2.scale(vector4f2.getZ());
        }
        catch (SingularMatrixException singularMatrixException) {
            vector4f2.setZero();
        }
        return vector4f2;
    }

    public static Vector4f[] unprojectRay(int n, int n2, Matrix4f matrix4f, Matrix4f matrix4f2, Viewport viewport) {
        Vector4f vector4f = Util.unproject(matrix4f, matrix4f2, viewport, n, n2, viewport.getNear());
        Vector4f vector4f2 = Util.unproject(matrix4f, matrix4f2, viewport, n, n2, viewport.getFar());
        return new Vector4f[]{vector4f, vector4f2};
    }

    public static boolean intersectBillboard(Vector3f[] vector3fArray, Vector3f vector3f, Vector3f vector3f2, float f2) {
        Vector3f vector3f3 = vector3f2;
        vector3f3.sub(vector3f);
        Vector3f vector3f4 = new Vector3f(vector3fArray[1]);
        vector3f4.sub(vector3fArray[0]);
        Vector3f vector3f5 = new Vector3f(vector3fArray[3]);
        vector3f5.sub(vector3fArray[0]);
        Vector3f vector3f6 = new Vector3f();
        vector3f3.cross(vector3f5, vector3f6);
        double d2 = vector3f4.dot(vector3f6);
        if (Math.abs(d2) < (double)f2) {
            return false;
        }
        Vector3f vector3f7 = new Vector3f(vector3f);
        vector3f7.sub(vector3fArray[0]);
        double d3 = (double)vector3f7.dot(vector3f6) / d2;
        if (d3 < 0.0 || d3 > 1.0) {
            return false;
        }
        Vector3f vector3f8 = new Vector3f();
        vector3f7.cross(vector3f4, vector3f8);
        double d4 = (double)vector3f3.dot(vector3f8) / d2;
        if (d4 < 0.0 || d4 > 1.0) {
            return false;
        }
        if (d3 + d4 > 1.0) {
            Vector3f vector3f9 = new Vector3f(vector3fArray[1]);
            vector3f9.sub(vector3fArray[2]);
            Vector3f vector3f10 = new Vector3f(vector3fArray[3]);
            vector3f10.sub(vector3fArray[2]);
            Vector3f vector3f11 = new Vector3f();
            vector3f3.cross(vector3f10, vector3f11);
            double d5 = vector3f9.dot(vector3f11);
            if (Math.abs(d5) < (double)f2) {
                return false;
            }
            Vector3f vector3f12 = new Vector3f(vector3f);
            vector3f12.sub(vector3fArray[2]);
            double d6 = (double)vector3f12.dot(vector3f11) / d5;
            if (d6 < 0.0) {
                return false;
            }
            Vector3f vector3f13 = new Vector3f();
            vector3f12.cross(vector3f9, vector3f13);
            double d7 = (double)vector3f3.dot(vector3f13) / d5;
            if (d7 < 0.0) {
                return false;
            }
        }
        return true;
    }
}

