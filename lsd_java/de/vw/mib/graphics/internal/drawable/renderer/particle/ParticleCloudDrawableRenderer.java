/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.particle;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.particle.ParticleCloudDrawable;
import de.vw.mib.graphics.drawable.particle.ParticleGridDrawable;
import de.vw.mib.graphics.drawable.particle.ParticleSphereDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$AbstractPooledDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$DrawablePool;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.particle.ParticleCloudDrawableRenderer$SharedParticleCloudDrawable;
import de.vw.mib.graphics.internal.mesh.tesselation.PointMeshTesselator;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;

public final class ParticleCloudDrawableRenderer
extends AbstractSharedDrawableRenderer {
    private static final int PARTICLE_SHARED_GEOMETRY_VERTEX_COUNT = Integer.getInteger("de.vw.mib.graphics.particlerenderer.geometry.count", 1024);
    private static final int PARTICLE_TESSELATOR_VERTEX_COUNT;
    private PointMeshTesselator tesselator;

    public ParticleCloudDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, null, PARTICLE_SHARED_GEOMETRY_VERTEX_COUNT);
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
        return new ParticleCloudDrawableRenderer$SharedParticleCloudDrawable(this, (ObjectPool)abstractPooledDrawableRenderer$DrawablePool);
    }

    protected PointMeshTesselator getTesselator() {
        if (this.tesselator == null) {
            this.tesselator = new PointMeshTesselator(false, 256);
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

    public ParticleCloudDrawable createParticleCloudDrawable() {
        return (ParticleCloudDrawable)((Object)this.getPooledInstance());
    }

    public ParticleGridDrawable createParticlerGridDrawable() {
        throw new NotYetImplementedException();
    }

    public ParticleSphereDrawable createParticleSphereDrawable() {
        throw new NotYetImplementedException();
    }
}

