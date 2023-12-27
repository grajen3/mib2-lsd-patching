/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics;

import de.vw.mib.graphics.Graphics3D;

public interface GraphicsListener {
    default public void beginFrame(Graphics3D graphics3D) {
    }

    default public void endFrame(Graphics3D graphics3D) {
    }

    default public void performanceMetricsEnabledChanged(Graphics3D graphics3D, boolean bl) {
    }
}

