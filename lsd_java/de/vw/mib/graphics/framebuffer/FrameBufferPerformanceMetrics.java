/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.framebuffer;

import de.vw.mib.graphics.performance.PerformanceMetrics;
import de.vw.mib.util.StringBuilder;

public final class FrameBufferPerformanceMetrics
implements PerformanceMetrics {
    public int allocatedFrameBuffers;
    public int allocatedRenderBuffers;
    public int allocatedRenderBuffersSizeBytes;
    public int frameBufferBinds;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[allocatedFrameBuffers=").append(this.allocatedFrameBuffers);
        stringBuilder.append(",allocatedRenderBuffers=").append(this.allocatedRenderBuffers);
        stringBuilder.append(",allocatedRenderBuffersSizeBytes=").append(this.allocatedRenderBuffersSizeBytes);
        stringBuilder.append(",frameBufferBinds=").append(this.frameBufferBinds);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void clear() {
        this.frameBufferBinds = 0;
    }
}

