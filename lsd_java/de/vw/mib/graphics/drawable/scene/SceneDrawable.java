/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.drawable.scene;

import de.vw.mib.graphics.Viewport;
import de.vw.mib.graphics.drawable.Drawable;
import de.vw.mib.graphics.scene.Scene;
import de.vw.mib.graphics.scene.graph.visual.camera.CameraEntity;

public interface SceneDrawable
extends Drawable {
    public static final int RENDER_MODE_MATERIAL;
    public static final int RENDER_MODE_NO_MATERIAL;
    public static final int RENDER_MODE_NORMALS;
    public static final int RENDER_MODE_DEPTH;

    default public Scene getScene() {
    }

    default public void setScene(Scene scene) {
    }

    default public CameraEntity getCamera() {
    }

    default public void setCamera(CameraEntity cameraEntity) {
    }

    default public Viewport getViewport() {
    }

    default public void setViewport(Viewport viewport) {
    }

    default public int getRenderMode() {
    }

    default public void setRenderMode(int n) {
    }

    default public boolean isRenderBoundingVolumes() {
    }

    default public void setRenderBoundingVolumes(boolean bl) {
    }

    default public boolean isBackFaceCulling() {
    }

    default public void setBackFaceCulling(boolean bl) {
    }

    default public boolean isViewFrustumCulling() {
    }

    default public void setViewFrustumCulling(boolean bl) {
    }
}

