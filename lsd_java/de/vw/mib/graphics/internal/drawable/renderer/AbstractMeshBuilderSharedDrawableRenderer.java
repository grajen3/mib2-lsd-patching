/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$AbstractPooledDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$DrawablePool;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.mesh.MeshBuilder;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.internal.texture.TextureAtlas;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;

public abstract class AbstractMeshBuilderSharedDrawableRenderer
extends AbstractSharedDrawableRenderer {
    private final int maxElementVertexCount;
    private final int maxElementIndexCount;
    private MeshBuilder meshBuilder;

    public AbstractMeshBuilderSharedDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics, TextureAtlas textureAtlas, int n, int n2, int n3, int n4) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, textureAtlas, n, n3);
        this.maxElementVertexCount = n2;
        this.maxElementIndexCount = n4;
    }

    public AbstractMeshBuilderSharedDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics, TextureAtlas textureAtlas, int n, int n2) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, textureAtlas, n);
        this.maxElementVertexCount = n2;
        this.maxElementIndexCount = 0;
    }

    @Override
    protected abstract VertexFormat getVertexFormat() {
    }

    @Override
    protected abstract int getIndexFormat() {
    }

    @Override
    protected abstract AbstractPooledDrawableRenderer$AbstractPooledDrawable createInstance(AbstractPooledDrawableRenderer$DrawablePool abstractPooledDrawableRenderer$DrawablePool) {
    }

    public final MeshBuilder getMeshBuilder() {
        if (this.meshBuilder == null) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.getVertexFormat());
            this.meshBuilder = this.maxElementIndexCount > 0 ? new MeshBuilder(arrayList, this.maxElementVertexCount, this.getIndexFormat(), this.maxElementIndexCount) : new MeshBuilder(arrayList, this.maxElementVertexCount);
        }
        return this.meshBuilder;
    }
}

