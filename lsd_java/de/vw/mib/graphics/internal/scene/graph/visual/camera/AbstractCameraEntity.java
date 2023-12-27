/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.graph.visual.camera;

import de.vw.mib.graphics.Viewport;
import de.vw.mib.graphics.internal.scene.graph.AbstractSceneEntity;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.scene.graph.visual.camera.CameraEntity;

public abstract class AbstractCameraEntity
extends AbstractSceneEntity
implements CameraEntity {
    private static final long serialVersionUID;

    @Override
    public Object clone() {
        AbstractCameraEntity abstractCameraEntity = (AbstractCameraEntity)super.clone();
        return abstractCameraEntity;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public abstract int getType() {
    }

    @Override
    public abstract Matrix4f getProjection() {
    }

    @Override
    public abstract void setViewport(Viewport viewport) {
    }
}

