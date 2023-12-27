/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.internal.AbstractResource;
import de.vw.mib.graphics.internal.scene.SceneFactory;
import de.vw.mib.graphics.internal.scene.graph.spatial.bvh.BVHScene;
import de.vw.mib.graphics.internal.scene.renderer.GraphicsSceneRenderer;
import de.vw.mib.graphics.mesh.Mesh;
import de.vw.mib.graphics.performance.CachePerformanceMetrics;
import de.vw.mib.graphics.scene.Scene;
import de.vw.mib.graphics.scene.SceneManager;
import de.vw.mib.graphics.scene.ScenePerformanceMetrics;
import de.vw.mib.graphics.scene.renderer.SceneRenderer;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractSceneManager
extends AbstractResource
implements SceneManager {
    private final ScenePerformanceMetrics performanceMetrics = new ScenePerformanceMetrics();
    private final SceneFactory sceneFactory = new SceneFactory();
    private GraphicsSceneRenderer renderer;

    public AbstractSceneManager(Graphics3D graphics3D, Logger logger) {
        super(graphics3D, logger);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public final ScenePerformanceMetrics getPerformanceMetrics() {
        return this.performanceMetrics;
    }

    @Override
    public abstract CachePerformanceMetrics getSceneCacheUsage() {
    }

    @Override
    public final Scene createBVHScene() {
        return new BVHScene(this.getGraphics3D(), this.getLogger(), this);
    }

    @Override
    public final SceneRenderer getSceneRenderer() {
        if (this.renderer == null) {
            this.renderer = new GraphicsSceneRenderer(this.getGraphics3D(), this.getLogger());
        }
        return this.renderer;
    }

    @Override
    public final Scene createScene(boolean bl, boolean bl2) {
        return this.sceneFactory.createScene(this.getGraphics3D(), bl, bl2);
    }

    @Override
    public final Scene createSceneFromMesh(Mesh mesh, Effect effect, boolean bl, boolean bl2) {
        return this.sceneFactory.createSceneFromMesh(this.getGraphics3D(), mesh, effect, bl, bl2);
    }

    @Override
    public abstract Scene getScene(int n) {
    }
}

