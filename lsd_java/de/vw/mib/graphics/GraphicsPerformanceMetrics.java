/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics;

import de.vw.mib.graphics.performance.PerformanceMetrics;
import de.vw.mib.util.StringBuilder;

public final class GraphicsPerformanceMetrics
implements PerformanceMetrics {
    public int drawnFrames;
    public int matrixMults;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[drawnFrames=").append(this.drawnFrames);
        stringBuilder.append(",matrixMults=").append(this.matrixMults);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void clear() {
        this.drawnFrames = 0;
        this.matrixMults = 0;
    }
}

