/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.graph.visual.camera;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.Camera;
import de.vw.mib.graphics.Viewport;
import de.vw.mib.graphics.internal.scene.graph.visual.camera.AbstractCameraEntity;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.scene.graph.visual.camera.OrthographicCamera;
import de.vw.mib.graphics.scene.graph.visual.camera.PerspectiveCamera;
import de.vw.mib.util.StringBuilder;

public final class UnpooledCameraEntity
extends AbstractCameraEntity
implements OrthographicCamera,
PerspectiveCamera {
    private static final long serialVersionUID;
    private static HashCodeBuilder hcb;
    private final int type;
    private float near;
    private float far;
    private float aspectRatio;
    private float fov;
    private float left;
    private float right;
    private float top;
    private float bottom;

    public UnpooledCameraEntity(int n) {
        this.type = n;
    }

    @Override
    public Object clone() {
        UnpooledCameraEntity unpooledCameraEntity = (UnpooledCameraEntity)super.clone();
        return unpooledCameraEntity;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",nearClip=").append(this.near);
        stringBuilder.append(",farClip=").append(this.far);
        stringBuilder.append(",aspectRatio=").append(this.aspectRatio);
        stringBuilder.append(",fov=").append(this.fov);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public void setViewport(Viewport viewport) {
        this.setAspectRatio((float)viewport.getWidth() / (float)viewport.getHeight());
    }

    @Override
    public void lookAt(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
        throw new NotYetImplementedException();
    }

    @Override
    public Matrix4f getProjection() {
        Matrix4f matrix4f = new Matrix4f();
        switch (this.type) {
            case 0: {
                break;
            }
            case 1: {
                Camera.setOrtographicProjection(matrix4f, this.left, this.right, this.bottom, this.top, this.near, this.far);
                break;
            }
            case 2: {
                Camera.setPerspectiveProjection(matrix4f, this.fov, this.aspectRatio, this.near, this.far);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid camera type");
            }
        }
        return matrix4f;
    }

    @Override
    public float getNear() {
        return this.near;
    }

    @Override
    public void setNear(float f2) {
        this.near = f2;
    }

    @Override
    public float getFar() {
        return this.far;
    }

    @Override
    public void setFar(float f2) {
        this.far = f2;
    }

    @Override
    public float getAspectRatio() {
        return this.aspectRatio;
    }

    @Override
    public void setAspectRatio(float f2) {
        this.aspectRatio = f2;
    }

    @Override
    public float getFieldOfView() {
        return this.fov;
    }

    @Override
    public void setFieldOfView(float f2) {
        this.fov = f2;
    }

    @Override
    public float getLeft() {
        return this.left;
    }

    @Override
    public void setLeft(float f2) {
        this.left = f2;
    }

    @Override
    public float getRight() {
        return this.right;
    }

    @Override
    public void setRight(float f2) {
        this.right = f2;
    }

    @Override
    public float getTop() {
        return this.top;
    }

    @Override
    public void setTop(float f2) {
        this.top = f2;
    }

    @Override
    public float getBottom() {
        return this.bottom;
    }

    @Override
    public void setBottom(float f2) {
        this.bottom = f2;
    }
}

