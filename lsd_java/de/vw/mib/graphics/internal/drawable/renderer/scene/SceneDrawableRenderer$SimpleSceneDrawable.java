/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.scene;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Viewport;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.scene.SceneDrawable;
import de.vw.mib.graphics.effect.EffectException;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$AbstractPooledDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.scene.SceneDrawableRenderer;
import de.vw.mib.graphics.material.Material;
import de.vw.mib.graphics.scene.Scene;
import de.vw.mib.graphics.scene.graph.visual.camera.CameraEntity;
import de.vw.mib.graphics.scene.renderer.SceneRenderer;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.util.StringBuilder;

public final class SceneDrawableRenderer$SimpleSceneDrawable
extends AbstractPooledDrawableRenderer$AbstractPooledDrawable
implements SceneDrawable {
    private static Material NO_MATERIAL = new Material();
    private Scene scene;
    private CameraEntity camera;
    private Viewport viewport;
    private int renderMode;
    private boolean renderBoundingVolumes;
    private boolean backFaceCulling;
    private boolean viewFrustumCulling;

    public SceneDrawableRenderer$SimpleSceneDrawable(SceneDrawableRenderer sceneDrawableRenderer, ObjectPool objectPool) {
        super(sceneDrawableRenderer, objectPool);
        SceneRenderer sceneRenderer = this.getSceneRenderer();
        this.renderMode = 0;
        this.backFaceCulling = sceneRenderer.isBackFaceCulling();
        this.viewFrustumCulling = sceneRenderer.isViewFrustumCulling();
    }

    @Override
    public void dispose() {
        if (this.scene != null) {
            this.scene.dispose();
            this.scene = null;
        }
        this.camera = null;
        this.viewport.set(0, 0, 0, 0, 0.0f, 0.0f);
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics, boolean bl) {
        drawablePerformanceMetrics.allocatedScenes = drawablePerformanceMetrics.allocatedScenes + (bl ? 1 : -1);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",scene=").append(this.scene);
        stringBuilder.append(",camera=").append(this.camera);
        stringBuilder.append(",viewport=").append(this.viewport);
        stringBuilder.append(",renderMode=").append(this.renderMode);
        stringBuilder.append(",renderBoundingVolumes=").append(this.renderBoundingVolumes);
        stringBuilder.append(",backFaceCulling=").append(this.backFaceCulling);
        stringBuilder.append(",viewFrustumCulling=").append(this.viewFrustumCulling);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private SceneRenderer getSceneRenderer() {
        Graphics3D graphics3D = this.getGraphics3D();
        return graphics3D.getSceneManager().getSceneRenderer();
    }

    @Override
    public Scene getScene() {
        return this.scene;
    }

    @Override
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    @Override
    public CameraEntity getCamera() {
        return this.camera;
    }

    @Override
    public void setCamera(CameraEntity cameraEntity) {
        this.camera = cameraEntity;
    }

    @Override
    public Viewport getViewport() {
        return this.viewport;
    }

    @Override
    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

    @Override
    public int getRenderMode() {
        return this.renderMode;
    }

    @Override
    public void setRenderMode(int n) {
        this.renderMode = n;
    }

    @Override
    public boolean isRenderBoundingVolumes() {
        return this.renderBoundingVolumes;
    }

    @Override
    public void setRenderBoundingVolumes(boolean bl) {
        this.renderBoundingVolumes = bl;
    }

    @Override
    public boolean isBackFaceCulling() {
        return this.backFaceCulling;
    }

    @Override
    public void setBackFaceCulling(boolean bl) {
        this.backFaceCulling = bl;
    }

    @Override
    public boolean isViewFrustumCulling() {
        return this.viewFrustumCulling;
    }

    @Override
    public void setViewFrustumCulling(boolean bl) {
        this.viewFrustumCulling = bl;
    }

    @Override
    public void draw() {
        Graphics3D graphics3D = this.getGraphics3D();
        Logger logger = this.getLogger();
        try {
            SceneRenderer sceneRenderer = this.getSceneRenderer();
            sceneRenderer.setCamera(this.camera);
            sceneRenderer.setViewport(this.viewport);
            switch (this.renderMode) {
                case 1: {
                    sceneRenderer.setOverrideEffect(null);
                    sceneRenderer.setOverrideMaterial(NO_MATERIAL);
                    break;
                }
                case 2: {
                    sceneRenderer.setOverrideEffect(graphics3D.getEffectManager().getNormalVisualizationEffect());
                    sceneRenderer.setOverrideMaterial(null);
                    break;
                }
                case 3: {
                    sceneRenderer.setOverrideEffect(graphics3D.getEffectManager().getDepthVisualizationEffect());
                    sceneRenderer.setOverrideMaterial(null);
                    break;
                }
                default: {
                    sceneRenderer.setOverrideEffect(null);
                    sceneRenderer.setOverrideMaterial(null);
                }
            }
            sceneRenderer.setRenderBoundingVolumes(this.renderBoundingVolumes);
            sceneRenderer.setBackFaceCulling(this.backFaceCulling);
            sceneRenderer.setViewFrustumCulling(this.viewFrustumCulling);
            sceneRenderer.render(this.scene);
            super.draw();
        }
        catch (EffectException effectException) {
            LogMessage logMessage = logger.error(512);
            logMessage.append(super.getClass().getName());
            logMessage.append(".draw() unrecoverable effect error:");
            logMessage.attachThrowable(effectException);
            logMessage.log();
        }
    }

    @Override
    protected void updateDrawingStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics) {
        ++drawablePerformanceMetrics.drawnScenes;
    }
}

