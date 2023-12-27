/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.shape;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.shape.ArcDrawable;
import de.vw.mib.graphics.effect.ColorEffect;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer$AbstractSharedDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.shape.ArcDrawableRenderer;
import de.vw.mib.graphics.internal.mesh.MeshBuilder;
import de.vw.mib.graphics.internal.mesh.MeshHeap;
import de.vw.mib.graphics.internal.mesh.MeshHeap$SubMesh;
import de.vw.mib.graphics.texture.Texture;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.util.StringBuilder;
import java.util.List;

final class ArcDrawableRenderer$SharedArcDrawable
extends AbstractSharedDrawableRenderer$AbstractSharedDrawable
implements ArcDrawable {
    public ArcDrawableRenderer$SharedArcDrawable(AbstractSharedDrawableRenderer abstractSharedDrawableRenderer, ObjectPool objectPool) {
        super(abstractSharedDrawableRenderer, objectPool);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics, boolean bl) {
        drawablePerformanceMetrics.allocatedArcs = drawablePerformanceMetrics.allocatedArcs + (bl ? 1 : -1);
    }

    @Override
    protected Effect createEffect(Graphics3D graphics3D) {
        return graphics3D.getEffectManager().getColorEffect();
    }

    @Override
    protected void updateEffect(Effect effect) {
        ColorEffect colorEffect = (ColorEffect)effect;
        this.updateTransformationEffect(colorEffect);
        this.updateColorEffect(colorEffect);
    }

    @Override
    protected void updateDrawingStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics) {
        ++drawablePerformanceMetrics.drawnArcs;
    }

    @Override
    protected MeshHeap$SubMesh updateMesh(Texture[] textureArray, List list) {
        Logger logger = this.getLogger();
        ArcDrawableRenderer arcDrawableRenderer = (ArcDrawableRenderer)this.getDrawableRenderer();
        MeshHeap meshHeap = arcDrawableRenderer.getMeshHeap();
        MeshHeap$SubMesh meshHeap$SubMesh = null;
        hcb.reset();
        long l = hcb.longHashCode();
        meshHeap$SubMesh = meshHeap.getSubMesh(l);
        if (meshHeap$SubMesh == null) {
            MeshBuilder meshBuilder = arcDrawableRenderer.getMeshBuilder();
            meshBuilder.beginGeometry(5, 0);
            meshBuilder.endGeometry();
            int n = meshBuilder.getVertexCount();
            meshHeap$SubMesh = meshHeap.insertSubMesh(l, 5, n);
            meshHeap$SubMesh.setVertexData(meshBuilder.getVertexArray());
            throw new NotYetImplementedException();
        }
        return meshHeap$SubMesh;
    }
}

