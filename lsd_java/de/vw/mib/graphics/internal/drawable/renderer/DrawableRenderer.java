/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer;

import de.vw.mib.graphics.Resource;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.log4mib.Logger;

public interface DrawableRenderer
extends Resource {
    default public Logger getLogger() {
    }

    default public GraphicsState getGraphicsState() {
    }

    default public DrawablePerformanceMetrics getPerformanceMetrics() {
    }
}

