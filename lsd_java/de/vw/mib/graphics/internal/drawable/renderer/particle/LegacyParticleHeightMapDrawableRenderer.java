/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.particle;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.particle.ParticleHeightMapDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractMeshBuilderSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$AbstractPooledDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$DrawablePool;
import de.vw.mib.graphics.internal.drawable.renderer.particle.LegacyParticleHeightMapDrawableRenderer$LegacyParticleHeightMapDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.particle.ParticleHeightMapDrawableRenderer;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.internal.texture.TextureAtlas;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;

public final class LegacyParticleHeightMapDrawableRenderer
extends AbstractMeshBuilderSharedDrawableRenderer
implements ParticleHeightMapDrawableRenderer {
    private static final int PARTICLE_SHARED_GEOMETRY_VERTEX_COUNT = Integer.getInteger("de.vw.mib.graphics.particlerenderer.geometry.count", 2048);
    private static final int PARTICLE_POSITIONS_ELEMENT_TYPE;
    private static final int PARTICLE_POSITIONS_ELEMENT_SIZE;
    private static final int PARTICLE_ANIMATION_START1_ELEMENT_TYPE;
    private static final int PARTICLE_ANIMATION_START1_ELEMENT_SIZE;
    private static final int PARTICLE_ANIMATION_START2_ELEMENT_TYPE;
    private static final int PARTICLE_ANIMATION_START2_ELEMENT_SIZE;
    private static final int PARTICLE_ANIMATION_END1_ELEMENT_TYPE;
    private static final int PARTICLE_ANIMATION_END1_ELEMENT_SIZE;
    private static final int PARTICLE_ANIMATION_END2_ELEMENT_TYPE;
    private static final int PARTICLE_ANIMATION_END2_ELEMENT_SIZE;
    private static final int PARTICLE_PRIMITIVE_TYPE;
    private static final int ANIMATION_START1_SET;
    private static final int ANIMATION_START2_SET;
    private static final int ANIMATION_END1_SET;
    private static final int ANIMATION_END2_SET;

    public LegacyParticleHeightMapDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics, TextureAtlas textureAtlas) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, textureAtlas, PARTICLE_SHARED_GEOMETRY_VERTEX_COUNT, PARTICLE_SHARED_GEOMETRY_VERTEX_COUNT);
    }

    @Override
    protected VertexFormat getVertexFormat() {
        VertexFormat vertexFormat = new VertexFormat();
        vertexFormat.addVertexAttribute(3, 3, 0);
        vertexFormat.addVertexAttribute(0, 4, 2, 1);
        vertexFormat.addVertexAttribute(0, 4, 2, 2);
        vertexFormat.addVertexAttribute(0, 4, 2, 3);
        vertexFormat.addVertexAttribute(0, 4, 2, 4);
        return vertexFormat;
    }

    @Override
    protected int getIndexFormat() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected AbstractPooledDrawableRenderer$AbstractPooledDrawable createInstance(AbstractPooledDrawableRenderer$DrawablePool abstractPooledDrawableRenderer$DrawablePool) {
        return new LegacyParticleHeightMapDrawableRenderer$LegacyParticleHeightMapDrawable(this, (ObjectPool)abstractPooledDrawableRenderer$DrawablePool);
    }

    @Override
    public ParticleHeightMapDrawable createAnimatedParticleHeightMapDrawable() {
        return (ParticleHeightMapDrawable)((Object)this.getPooledInstance());
    }
}

