/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.surface;

import de.vw.mib.graphics.Configuration;
import de.vw.mib.graphics.ConfigurationAttributes;
import de.vw.mib.graphics.ResourceManager;
import de.vw.mib.graphics.surface.PBufferSurface;
import de.vw.mib.graphics.surface.PixmapSurface;
import de.vw.mib.graphics.surface.WindowSurface;

public interface SurfaceManager
extends ResourceManager {
    default public Configuration chooseConfiguration(ConfigurationAttributes configurationAttributes) {
    }

    default public WindowSurface createWindowSurface(Configuration configuration, int n, int n2, Object object) {
    }

    default public PixmapSurface createPixmapSurface(Configuration configuration, int n, int n2, Object object) {
    }

    default public PBufferSurface createPBufferSurface(Configuration configuration, int n, int n2) {
    }
}

