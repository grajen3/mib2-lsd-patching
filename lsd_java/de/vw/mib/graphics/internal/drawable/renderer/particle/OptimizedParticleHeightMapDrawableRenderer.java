/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.particle;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.particle.ParticleHeightMapDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$AbstractPooledDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$DrawablePool;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.particle.OptimizedParticleHeightMapDrawableRenderer$OptimizedParticleHeightMapDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.particle.ParticleHeightMapDrawableRenderer;
import de.vw.mib.graphics.internal.mesh.tesselation.PointMeshTesselator;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.internal.texture.TextureAtlas;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;

public final class OptimizedParticleHeightMapDrawableRenderer
extends AbstractSharedDrawableRenderer
implements ParticleHeightMapDrawableRenderer {
    public static final int MIN_VERTEX_TEXTURE_UNITS;
    private static final int PARTICLE_SHARED_GEOMETRY_VERTEX_COUNT;
    private static final int PARTICLE_TESSELATOR_VERTEX_COUNT;
    private PointMeshTesselator tesselator;

    public OptimizedParticleHeightMapDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics, TextureAtlas textureAtlas) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, textureAtlas, PARTICLE_SHARED_GEOMETRY_VERTEX_COUNT);
    }

    @Override
    protected VertexFormat getVertexFormat() {
        return this.getTesselator().getVertexFormat(0);
    }

    @Override
    protected int getIndexFormat() {
        return this.getTesselator().getIndexFormat();
    }

    @Override
    protected AbstractPooledDrawableRenderer$AbstractPooledDrawable createInstance(AbstractPooledDrawableRenderer$DrawablePool abstractPooledDrawableRenderer$DrawablePool) {
        return new OptimizedParticleHeightMapDrawableRenderer$OptimizedParticleHeightMapDrawable(this, (ObjectPool)abstractPooledDrawableRenderer$DrawablePool);
    }

    protected PointMeshTesselator getTesselator() {
        if (this.tesselator == null) {
            this.tesselator = new PointMeshTesselator(false, 2048);
            this.tesselator.initialize();
            Logger logger = this.getLogger();
            if (logger.isTraceEnabled(512)) {
                LogMessage logMessage = logger.trace(512);
                logMessage.append("Created ");
                logMessage.append(super.getClass().getName());
                logMessage.append(" maxVertices ").append(this.tesselator.getMaxVertexCount());
                logMessage.append(" (").append(this.tesselator.getMaxVertexCount() * this.tesselator.getVertexSize()).append(" bytes) ");
                logMessage.append(" maxIndices ").append(this.tesselator.getMaxIndexCount());
                logMessage.log();
            }
        }
        return this.tesselator;
    }

    @Override
    public ParticleHeightMapDrawable createAnimatedParticleHeightMapDrawable() {
        return (ParticleHeightMapDrawable)((Object)this.getPooledInstance());
    }

    static {
        PARTICLE_SHARED_GEOMETRY_VERTEX_COUNT = Integer.getInteger("de.vw.mib.graphics.particlerenderer.geometry.count", 2048);
    }
}

