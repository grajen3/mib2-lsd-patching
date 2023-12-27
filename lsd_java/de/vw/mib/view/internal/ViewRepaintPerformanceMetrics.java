/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.graphics.performance.PerformanceMetrics;
import de.vw.mib.util.StringBuilder;

public final class ViewRepaintPerformanceMetrics
implements PerformanceMetrics {
    public long setupStartTime;
    public long setupEndTime;
    public long repaintStartTime;
    public long repaintEndTime;
    public long flushStartTime;
    public long flushEndTime;
    public long swapStartTime;
    public long swapEndTime;
    public long lastFrameStartTime;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[setupStartTime=").append(this.setupStartTime);
        stringBuilder.append(",setupEndTime=").append(this.setupEndTime);
        stringBuilder.append(",repaintStartTime=").append(this.repaintStartTime);
        stringBuilder.append(",repaintEndTime=").append(this.repaintEndTime);
        stringBuilder.append(",flushStartTime=").append(this.flushStartTime);
        stringBuilder.append(",flushEndTime=").append(this.flushEndTime);
        stringBuilder.append(",swapStartTime=").append(this.swapStartTime);
        stringBuilder.append(",swapStartTime=").append(this.swapStartTime);
        stringBuilder.append(",lastFrameStartTime=").append(this.lastFrameStartTime);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

