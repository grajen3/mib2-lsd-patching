/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal;

import de.vw.mib.graphics.Configuration;
import de.vw.mib.graphics.ConfigurationAttributes;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.GraphicsManager;
import de.vw.mib.graphics.internal.ServiceManager;
import de.vw.mib.graphics.surface.PBufferSurface;
import de.vw.mib.graphics.surface.PixmapSurface;
import de.vw.mib.graphics.surface.Surface;
import de.vw.mib.graphics.surface.WindowSurface;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;

public abstract class AbstractGraphicsManager
implements GraphicsManager {
    private static final String VRAM_SIZE_MIB;
    private final Logger logger;
    private final int vramSizeBytes;

    public AbstractGraphicsManager(LoggerFactory loggerFactory) {
        this.logger = loggerFactory.getLogger(256);
        int n = 4096;
        int n2 = Integer.getInteger("de.vw.mib.graphics.videoramsizemib", ServiceManager.configurationManager.getGraphicsVideoRAMSizeMiB());
        this.vramSizeBytes = n2 * 4096;
        this.logger.normal(64).append("Limiting available video memory (VRAM) size to ").append(n2).append("MiB").log();
    }

    protected Logger getLogger() {
        return this.logger;
    }

    protected final int getVideoRAMSizeBytes() {
        return this.vramSizeBytes;
    }

    @Override
    public abstract Configuration chooseConfiguration(ConfigurationAttributes configurationAttributes) {
    }

    @Override
    public abstract WindowSurface createWindowSurface(Configuration configuration, Object object) {
    }

    @Override
    public abstract PixmapSurface createPixmapSurface(Configuration configuration, Object object) {
    }

    @Override
    public abstract PBufferSurface createPBufferSurface(Configuration configuration, int n, int n2) {
    }

    @Override
    public abstract Graphics3D createGraphics(Configuration configuration, Surface surface) {
    }

    @Override
    public abstract Graphics3D cloneGraphics(Graphics3D graphics3D) {
    }

    @Override
    public abstract boolean isGraphicsBound(Graphics3D graphics3D, Surface surface) {
    }

    @Override
    public abstract void bindGraphics(Graphics3D graphics3D, Surface surface) {
    }

    @Override
    public abstract void unbindGraphics(Graphics3D graphics3D) {
    }

    @Override
    public abstract void beginFrame(Graphics3D graphics3D) {
    }

    @Override
    public abstract void endFrame(Graphics3D graphics3D) {
    }

    @Override
    public abstract void swapBuffers(Graphics3D graphics3D) {
    }
}

