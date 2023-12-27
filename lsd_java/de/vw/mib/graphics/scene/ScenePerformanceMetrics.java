/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene;

import de.vw.mib.graphics.performance.PerformanceMetrics;
import de.vw.mib.util.StringBuilder;

public final class ScenePerformanceMetrics
implements PerformanceMetrics {
    public int drawnScenes;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[drawnScenes=").append(this.drawnScenes);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void clear() {
        this.drawnScenes = 0;
    }
}

