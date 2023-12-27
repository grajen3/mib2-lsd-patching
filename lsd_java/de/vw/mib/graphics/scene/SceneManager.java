/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene;

import de.vw.mib.graphics.ResourceManager;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.mesh.Mesh;
import de.vw.mib.graphics.performance.CachePerformanceMetrics;
import de.vw.mib.graphics.scene.Scene;
import de.vw.mib.graphics.scene.ScenePerformanceMetrics;
import de.vw.mib.graphics.scene.renderer.SceneRenderer;

public interface SceneManager
extends ResourceManager {
    default public ScenePerformanceMetrics getPerformanceMetrics() {
    }

    default public CachePerformanceMetrics getSceneCacheUsage() {
    }

    default public Scene createBVHScene() {
    }

    default public SceneRenderer getSceneRenderer() {
    }

    default public Scene createScene(boolean bl, boolean bl2) {
    }

    default public Scene createSceneFromMesh(Mesh mesh, Effect effect, boolean bl, boolean bl2) {
    }

    default public Scene getScene(int n) {
    }
}

