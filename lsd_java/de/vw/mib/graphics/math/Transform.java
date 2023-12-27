/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.math.Tuple3f;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.AxisAngle;
import de.vw.mib.graphics.math.algebra.Matrix3f;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.math.algebra.Rotation;
import de.vw.mib.graphics.math.algebra.SingularMatrixException;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.util.StringBuilder;
import java.io.Serializable;

public final class Transform
implements Cloneable,
Serializable {
    private static final long serialVersionUID;
    public static final Transform IDENTITY;
    private static final boolean OPTIMIZE;
    private static final boolean OPTIMIZE_BYPASS;
    private static final boolean OPTIMIZE_SHORTCUT;
    private static final Tuple3f TRANSLATE_IDENTITY;
    private static final Rotation ROTATE_IDENTITY;
    private static final Tuple3f SCALE_IDENTITY;
    private static HashCodeBuilder hcb;
    private static final Transform TEMPTHIS;
    private static final Transform TEMPARG;
    private static final Vector3f TEMPVEC3;
    private static final Matrix3f TEMPMAT3;
    private static final Matrix4f TEMPMAT4;
    private static final Rotation TEMPROT;
    private Tuple3f translation;
    private Rotation rotation;
    private Tuple3f scale;
    private Matrix4f matrix;
    private boolean matrixValid;

    public Transform() {
        this.translation = new Tuple3f(0.0f, 0.0f, 0.0f);
        this.rotation = new Rotation();
        this.scale = new Tuple3f(1.0f, 1.0f, 1.0f);
        this.matrix = null;
        this.matrixValid = false;
    }

    public Transform(Transform transform) {
        this.translation = (Tuple3f)transform.translation.clone();
        this.rotation = (Rotation)transform.rotation.clone();
        this.scale = (Tuple3f)transform.scale.clone();
        this.matrix = null;
        this.matrixValid = false;
    }

    public Transform(Matrix4f matrix4f) {
        this();
        this.setFromMatrix(matrix4f);
    }

    public Object clone() {
        try {
            Transform transform = (Transform)super.clone();
            transform.translation = (Tuple3f)this.translation.clone();
            transform.rotation = (Rotation)this.rotation.clone();
            transform.scale = (Tuple3f)this.scale.clone();
            transform.matrix = null;
            transform.matrixValid = false;
            return transform;
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
        hcb.append(this.translation);
        hcb.append(this.rotation);
        hcb.append(this.scale);
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            Transform transform = (Transform)object;
            if (!this.translation.equals(transform.translation)) {
                return false;
            }
            if (!this.rotation.equals(transform.rotation)) {
                return false;
            }
            return this.scale.equals(transform.scale);
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[translation=").append(this.translation);
        stringBuilder.append(",rotation=").append(this.rotation);
        stringBuilder.append(",scale=").append(this.scale);
        stringBuilder.append(",matrix=").append(this.getAsMatrix());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public Transform set(Transform transform) {
        if (this != transform) {
            this.translation.set(transform.translation);
            this.rotation.set(transform.rotation);
            this.scale.set(transform.scale);
            if (this.matrix != null && transform.matrixValid) {
                this.matrix.set(transform.matrix);
                this.matrixValid = transform.matrixValid;
            } else {
                this.matrixValid = false;
            }
        }
        return this;
    }

    public boolean isIdentity() {
        return this.translation.isZero() && this.rotation.isIdentity() && this.scale.equals(SCALE_IDENTITY);
    }

    public Transform setIdentity() {
        this.translation.setZero();
        this.rotation.setIdentity();
        this.scale.set(SCALE_IDENTITY);
        this.matrixValid = false;
        return this;
    }

    public Tuple3f getTranslation() {
        return this.translation;
    }

    public void getTranslation(Tuple3f tuple3f) {
        tuple3f.set(this.translation);
    }

    public Transform setTranslation(Tuple3f tuple3f) {
        this.translation.set(tuple3f);
        this.matrixValid = false;
        return this;
    }

    public Transform setTranslation(float f2, float f3, float f4) {
        this.translation.set(f2, f3, f4);
        this.matrixValid = false;
        return this;
    }

    public Rotation getRotation() {
        return this.rotation;
    }

    public void getRotation(Matrix3f matrix3f) {
        this.rotation.getAsRotationMatrix(matrix3f);
    }

    public void getRotation(Rotation rotation) {
        rotation.set(this.rotation);
    }

    public Transform setRotation(Matrix3f matrix3f) {
        this.rotation.setFromRotationMatrix(matrix3f);
        this.matrixValid = false;
        return this;
    }

    public Transform setRotation(AxisAngle axisAngle) {
        this.rotation.setAxisAngle(axisAngle);
        this.matrixValid = false;
        return this;
    }

    public Transform setRotation(float f2, float f3, float f4, float f5) {
        this.rotation.setAxisAngle(f3, f4, f5, f2);
        this.matrixValid = false;
        return this;
    }

    public Transform setRotation(Rotation rotation) {
        this.rotation.set(rotation);
        this.matrixValid = false;
        return this;
    }

    public Tuple3f getScale() {
        return this.scale;
    }

    public void getScale(Tuple3f tuple3f) {
        tuple3f.set(this.scale);
    }

    public Transform setScale(Tuple3f tuple3f) {
        this.scale.set(tuple3f);
        this.matrixValid = false;
        return this;
    }

    public Transform setScale(float f2, float f3, float f4) {
        this.scale.set(f2, f3, f4);
        this.matrixValid = false;
        return this;
    }

    public Transform setScale(float f2) {
        this.scale.set(f2);
        this.matrixValid = false;
        return this;
    }

    public Matrix4f getAsMatrix() {
        if (this.matrix == null) {
            this.matrix = new Matrix4f();
            this.matrixValid = false;
        }
        if (!this.matrixValid) {
            this.matrix.setIdentity();
            this.rotation.getAsRotationMatrix(TEMPMAT3);
            this.matrix.setUpperLeft3x3(TEMPMAT3);
            this.matrix.setTranslation(this.translation);
            this.matrix.setScale(this.scale);
            this.matrixValid = true;
        }
        return this.matrix;
    }

    public Transform setFromMatrix(Matrix4f matrix4f) {
        if (OPTIMIZE_BYPASS && matrix4f.isIdentity()) {
            return this.setIdentity();
        }
        matrix4f.getTranslation(this.translation);
        matrix4f.getUpperLeft3x3(TEMPMAT3);
        this.rotation.setFromRotationMatrix(TEMPMAT3);
        matrix4f.getScale(this.scale);
        this.matrixValid = false;
        return this;
    }

    public void transform(Transform transform, Transform transform2) {
        if (OPTIMIZE_BYPASS) {
            if (this.isIdentity()) {
                transform2.set(transform);
                return;
            }
            if (transform.isIdentity()) {
                transform2.set(this);
                return;
            }
        }
        this.scale.scale(transform.translation, transform2.translation);
        this.rotation.rotate(transform2.translation);
        transform2.translation.add(this.translation);
        this.rotation.mul(transform.rotation, transform2.rotation);
        this.scale.scale(transform.scale, transform2.scale);
        transform2.matrixValid = false;
    }

    public Transform transform(Transform transform) {
        if (OPTIMIZE_BYPASS) {
            if (this.isIdentity()) {
                this.set(transform);
                return this;
            }
            if (transform.isIdentity()) {
                return this;
            }
        }
        TEMPTHIS.set(this).transform(transform, this);
        return this;
    }

    public void transform(Tuple3f tuple3f, Tuple3f tuple3f2) {
        this.scale.scale(tuple3f, tuple3f2);
        this.rotation.rotate(tuple3f2);
        tuple3f2.add(this.translation);
    }

    public void invert(Transform transform) {
        if (OPTIMIZE_BYPASS && this.isIdentity()) {
            transform.setIdentity();
            return;
        }
        try {
            TEMPMAT4.set(this.getAsMatrix()).invert();
            transform.setFromMatrix(TEMPMAT4);
        }
        catch (SingularMatrixException singularMatrixException) {
            transform.setIdentity();
        }
    }

    public Transform transform(Matrix4f matrix4f) {
        this.transform(TEMPARG.setIdentity().setFromMatrix(matrix4f));
        return this;
    }

    public Transform translate(float f2, float f3, float f4) {
        if (f2 != 0.0f || f3 != 0.0f || f4 != 0.0f) {
            if (OPTIMIZE_SHORTCUT) {
                this.translation.add(f2, f3, f4);
            } else {
                this.transform(TEMPARG.setIdentity().setTranslation(f2, f3, f4));
            }
        }
        return this;
    }

    public Transform translate(Vector3f vector3f) {
        if (vector3f.x != 0.0f || vector3f.y != 0.0f || vector3f.z != 0.0f) {
            if (OPTIMIZE_SHORTCUT) {
                this.translation.add(vector3f);
            } else {
                this.transform(TEMPARG.setIdentity().setTranslation(vector3f));
            }
        }
        return this;
    }

    public Transform rotate(float f2, float f3, float f4, float f5) {
        if (f2 != 0.0f) {
            if (OPTIMIZE_SHORTCUT) {
                this.rotation.mul(TEMPROT.setAxisAngle(f3, f4, f5, f2));
            } else {
                this.transform(TEMPARG.setIdentity().setRotation(f2, f3, f4, f5));
            }
        }
        return this;
    }

    public Transform rotate(Matrix3f matrix3f) {
        if (!matrix3f.isIdentity()) {
            if (OPTIMIZE_SHORTCUT) {
                this.rotation.mul(TEMPROT.setFromRotationMatrix(matrix3f));
            } else {
                this.transform(TEMPARG.setIdentity().setRotation(matrix3f));
            }
        }
        return this;
    }

    public Transform rotate(Rotation rotation) {
        if (!rotation.isIdentity()) {
            if (OPTIMIZE_SHORTCUT) {
                this.rotation.mul(rotation);
            } else {
                this.transform(TEMPARG.setIdentity().setRotation(rotation));
            }
        }
        return this;
    }

    public Transform scale(float f2, float f3, float f4) {
        if (f2 != 1.0f || f3 != 1.0f || f4 != 1.0f) {
            if (OPTIMIZE_SHORTCUT) {
                this.scale.scale(TEMPVEC3.set(f2, f3, f4));
            } else {
                this.transform(TEMPARG.setIdentity().setScale(f2, f3, f4));
            }
        }
        return this;
    }

    public Transform scale(Tuple3f tuple3f) {
        if (tuple3f.x != 1.0f || tuple3f.y != 1.0f || tuple3f.z != 1.0f) {
            if (OPTIMIZE_SHORTCUT) {
                this.scale.scale(tuple3f);
            } else {
                this.transform(TEMPARG.setIdentity().setScale(tuple3f));
            }
        }
        return this;
    }

    public void interpolate(Transform transform, Transform transform2, float f2) {
        Rotation.interpolate(this.rotation, transform.rotation, transform2.rotation, f2);
        Tuple3f.interpolate(this.translation, transform.translation, transform2.translation, f2);
        Tuple3f.interpolate(this.scale, transform.scale, transform2.scale, f2);
    }

    public Transform interpolate(Transform transform, float f2) {
        this.interpolate(transform, this, f2);
        return this;
    }

    public static void interpolate(Transform transform, Transform transform2, Transform transform3, float f2) {
        transform.interpolate(transform2, transform3, f2);
    }

    static {
        IDENTITY = new Transform();
        OPTIMIZE = Util.OPTIMIZE;
        OPTIMIZE_BYPASS = OPTIMIZE && Util.OPTIMIZE_BYPASS;
        OPTIMIZE_SHORTCUT = false;
        TRANSLATE_IDENTITY = new Tuple3f(0.0f, 0.0f, 0.0f);
        ROTATE_IDENTITY = Rotation.IDENTITY;
        SCALE_IDENTITY = new Tuple3f(1.0f, 1.0f, 1.0f);
        TEMPTHIS = new Transform();
        TEMPARG = new Transform();
        TEMPVEC3 = new Vector3f();
        TEMPMAT3 = new Matrix3f();
        TEMPMAT4 = new Matrix4f();
        TEMPROT = new Rotation();
    }
}

