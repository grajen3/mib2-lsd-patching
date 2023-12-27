/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.shape;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.shape.CircleGraphDrawable;
import de.vw.mib.graphics.effect.ColorEffect;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.internal.InsufficientSpaceException;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer$AbstractSharedDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.shape.CircleGraphDrawableRenderer;
import de.vw.mib.graphics.internal.mesh.MeshHeap;
import de.vw.mib.graphics.internal.mesh.MeshHeap$SubMesh;
import de.vw.mib.graphics.internal.mesh.tesselation.CircleGraphMeshTesselator;
import de.vw.mib.graphics.texture.Texture;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.util.StringBuilder;
import java.util.Arrays;
import java.util.List;

final class CircleGraphDrawableRenderer$SharedCircleGraphDrawable
extends AbstractSharedDrawableRenderer$AbstractSharedDrawable
implements CircleGraphDrawable {
    private float[] sectorRadii;
    private float offset;
    private int slices;

    public CircleGraphDrawableRenderer$SharedCircleGraphDrawable(AbstractSharedDrawableRenderer abstractSharedDrawableRenderer, ObjectPool objectPool) {
        super(abstractSharedDrawableRenderer, objectPool);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",sectorRadii=").append(this.sectorRadii);
        stringBuilder.append(",offset=").append(this.offset);
        stringBuilder.append(",slices=").append(this.slices);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        this.sectorRadii = null;
        this.offset = 0.0f;
        this.slices = 0;
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics, boolean bl) {
        drawablePerformanceMetrics.allocatedCircleGraphs = drawablePerformanceMetrics.allocatedCircleGraphs + (bl ? 1 : -1);
    }

    @Override
    protected Effect createEffect(Graphics3D graphics3D) {
        return graphics3D.getEffectManager().getColorEffect();
    }

    @Override
    public float[] getSectorRadii() {
        return this.sectorRadii;
    }

    @Override
    public void setSectorRadii(float[] fArray) {
        if (!Arrays.equals(this.sectorRadii, fArray)) {
            if (this.sectorRadii == null || this.sectorRadii.length != fArray.length) {
                this.sectorRadii = new float[fArray.length];
            }
            System.arraycopy((Object)fArray, 0, (Object)this.sectorRadii, 0, this.sectorRadii.length);
            this.invalidateGeometry();
        }
    }

    @Override
    public float getOffset() {
        return this.offset;
    }

    @Override
    public void setOffset(float f2) {
        if (this.offset != f2) {
            this.offset = f2;
            this.invalidateGeometry();
        }
    }

    @Override
    public int getSlices() {
        return this.slices;
    }

    @Override
    public void setSlices(int n) {
        if (this.slices != n) {
            this.slices = n;
            this.invalidateGeometry();
        }
    }

    @Override
    protected void updateEffect(Effect effect) {
        ColorEffect colorEffect = (ColorEffect)effect;
        this.updateTransformationEffect(colorEffect);
        this.updateColorEffect(colorEffect);
    }

    @Override
    protected void updateDrawingStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics) {
        ++drawablePerformanceMetrics.drawnCircleGraphs;
    }

    @Override
    protected MeshHeap$SubMesh updateMesh(Texture[] textureArray, List list) {
        Logger logger = this.getLogger();
        CircleGraphDrawableRenderer circleGraphDrawableRenderer = (CircleGraphDrawableRenderer)this.getDrawableRenderer();
        MeshHeap meshHeap = circleGraphDrawableRenderer.getMeshHeap();
        hcb.reset();
        hcb.append(this.sectorRadii.length);
        hcb.append(this.sectorRadii);
        hcb.append(this.offset);
        hcb.append(this.slices);
        long l = hcb.longHashCode();
        MeshHeap$SubMesh meshHeap$SubMesh = meshHeap.getSubMesh(l);
        if (meshHeap$SubMesh == null) {
            CircleGraphMeshTesselator circleGraphMeshTesselator = circleGraphDrawableRenderer.getTesselator();
            try {
                circleGraphMeshTesselator.tesselateCircleGraphMesh(this.sectorRadii, this.offset, this.slices);
                meshHeap$SubMesh = meshHeap.insertSubMesh(l, circleGraphMeshTesselator.getPrimitiveType(), circleGraphMeshTesselator.getVertexCount());
                meshHeap$SubMesh.setVertexData(circleGraphMeshTesselator.getVertexArray(0));
            }
            catch (InsufficientSpaceException insufficientSpaceException) {
                LogMessage logMessage = logger.error(512);
                logMessage.append(super.getClass().getName());
                logMessage.append("() geometry too large: ").append(insufficientSpaceException.getRequiredWidth()).append("x").append(insufficientSpaceException.getRequiredHeight()).log();
            }
        }
        return meshHeap$SubMesh;
    }
}

