/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics;

import de.vw.mib.graphics.Configuration;
import de.vw.mib.graphics.ConfigurationAttributes;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.ResourceManager;
import de.vw.mib.graphics.surface.PBufferSurface;
import de.vw.mib.graphics.surface.PixmapSurface;
import de.vw.mib.graphics.surface.Surface;
import de.vw.mib.graphics.surface.WindowSurface;

public interface GraphicsManager
extends ResourceManager {
    default public Configuration chooseConfiguration(ConfigurationAttributes configurationAttributes) {
    }

    default public WindowSurface createWindowSurface(Configuration configuration, Object object) {
    }

    default public PixmapSurface createPixmapSurface(Configuration configuration, Object object) {
    }

    default public PBufferSurface createPBufferSurface(Configuration configuration, int n, int n2) {
    }

    default public Graphics3D createGraphics(Configuration configuration, Surface surface) {
    }

    default public Graphics3D cloneGraphics(Graphics3D graphics3D) {
    }

    default public boolean isGraphicsBound(Graphics3D graphics3D, Surface surface) {
    }

    default public void bindGraphics(Graphics3D graphics3D, Surface surface) {
    }

    default public void unbindGraphics(Graphics3D graphics3D) {
    }

    default public void beginFrame(Graphics3D graphics3D) {
    }

    default public void endFrame(Graphics3D graphics3D) {
    }

    default public void swapBuffers(Graphics3D graphics3D) {
    }
}

