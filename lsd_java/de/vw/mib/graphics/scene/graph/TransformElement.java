/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.graph;

import de.vw.mib.graphics.math.Tuple3f;
import de.vw.mib.graphics.math.algebra.AxisAngle;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.util.StringBuilder;

public final class TransformElement {
    public static final int TRANSFORM_TYPE_TRS;
    public static final int TRANSFORM_TYPE_TRANSLATION;
    public static final int TRANSFORM_TYPE_ROTATION;
    public static final int TRANSFORM_TYPE_SCALE;
    public static final int TRANSFORM_TYPE_MATRIX;
    private final int type;
    private final Vector3f translation;
    private final AxisAngle rotation;
    private final Tuple3f scale;
    private final Matrix4f matrix;

    protected TransformElement(int n, Vector3f vector3f, AxisAngle axisAngle, Tuple3f tuple3f, Matrix4f matrix4f) {
        this.type = n;
        this.translation = vector3f;
        this.rotation = axisAngle;
        this.scale = tuple3f;
        this.matrix = matrix4f;
    }

    public TransformElement(Vector3f vector3f) {
        this(1, vector3f, null, null, null);
    }

    public TransformElement(AxisAngle axisAngle) {
        this(2, null, axisAngle, null, null);
    }

    public TransformElement(Tuple3f tuple3f) {
        this(3, null, null, tuple3f, null);
    }

    public TransformElement(Vector3f vector3f, AxisAngle axisAngle, Tuple3f tuple3f) {
        this(0, vector3f, axisAngle, tuple3f, null);
    }

    public TransformElement(Matrix4f matrix4f) {
        this(4, null, null, null, matrix4f);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",type=").append(this.type);
        stringBuilder.append(",translation=").append(this.translation);
        stringBuilder.append(",rotation=").append(this.rotation);
        stringBuilder.append(",scale=").append(this.scale);
        stringBuilder.append(",matrix=").append(this.matrix);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int getType() {
        return this.type;
    }

    public Matrix4f getMatrix() {
        return this.matrix;
    }

    public Vector3f getTranslation() {
        return this.translation;
    }

    public AxisAngle getRotation() {
        return this.rotation;
    }

    public Tuple3f getScale() {
        return this.scale;
    }
}

