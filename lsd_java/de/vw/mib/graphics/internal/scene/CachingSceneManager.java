/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.internal.ServiceManager;
import de.vw.mib.graphics.internal.scene.AbstractSceneManager;
import de.vw.mib.graphics.internal.scene.SceneCache;
import de.vw.mib.graphics.performance.CachePerformanceMetrics;
import de.vw.mib.graphics.scene.Scene;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;

public final class CachingSceneManager
extends AbstractSceneManager {
    private final SceneCache sceneCache = new SceneCache();

    public CachingSceneManager(Graphics3D graphics3D, Logger logger) {
        super(graphics3D, logger);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public CachePerformanceMetrics getSceneCacheUsage() {
        return new CachePerformanceMetrics(this.sceneCache.size(), this.sceneCache.getByteSize(), this.sceneCache.getMaximumCacheSizeBytes(), this.sceneCache.hits(), this.sceneCache.misses());
    }

    @Override
    public Scene getScene(int n) {
        long l = n;
        Scene scene = (Scene)this.sceneCache.get(l);
        return scene;
    }

    private static String getModelContentFileName() {
        StringBuilder stringBuilder = new StringBuilder(256);
        if (ServiceManager.configurationManager != null) {
            int n = ServiceManager.configurationManager.getCommonSkinId();
            stringBuilder.append(ServiceManager.configurationManager.getSkinPath(n));
            stringBuilder.append("/");
        }
        stringBuilder.append("models.mcf");
        return stringBuilder.toString();
    }
}

