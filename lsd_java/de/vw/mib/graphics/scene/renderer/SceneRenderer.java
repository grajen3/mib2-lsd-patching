/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.renderer;

import de.vw.mib.graphics.Resource;
import de.vw.mib.graphics.Viewport;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.material.Material;
import de.vw.mib.graphics.scene.Scene;
import de.vw.mib.graphics.scene.graph.visual.camera.CameraEntity;

public interface SceneRenderer
extends Resource {
    default public CameraEntity getCamera() {
    }

    default public void setCamera(CameraEntity cameraEntity) {
    }

    default public Viewport getViewport() {
    }

    default public void setViewport(Viewport viewport) {
    }

    default public Effect getOverrideEfect() {
    }

    default public void setOverrideEffect(Effect effect) {
    }

    default public Material getOverrideMaterial() {
    }

    default public void setOverrideMaterial(Material material) {
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

    default public void render(Scene scene) {
    }
}

