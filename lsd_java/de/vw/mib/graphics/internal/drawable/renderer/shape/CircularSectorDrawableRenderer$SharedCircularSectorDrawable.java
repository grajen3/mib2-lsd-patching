/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.shape;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.shape.CircularSectorDrawable;
import de.vw.mib.graphics.effect.ColorEffect;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.internal.InsufficientSpaceException;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer$AbstractSharedDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.shape.CircularSectorDrawableRenderer;
import de.vw.mib.graphics.internal.mesh.MeshHeap;
import de.vw.mib.graphics.internal.mesh.MeshHeap$SubMesh;
import de.vw.mib.graphics.internal.mesh.tesselation.CircularSectorMeshTesselator;
import de.vw.mib.graphics.texture.Texture;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.util.StringBuilder;
import java.util.List;

final class CircularSectorDrawableRenderer$SharedCircularSectorDrawable
extends AbstractSharedDrawableRenderer$AbstractSharedDrawable
implements CircularSectorDrawable {
    private float radius;
    private float startAngle;
    private float endAngle;
    private int slices;

    public CircularSectorDrawableRenderer$SharedCircularSectorDrawable(AbstractSharedDrawableRenderer abstractSharedDrawableRenderer, ObjectPool objectPool) {
        super(abstractSharedDrawableRenderer, objectPool);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",radius=").append(this.radius);
        stringBuilder.append(",startAngle=").append(this.startAngle);
        stringBuilder.append(",endAngle=").append(this.endAngle);
        stringBuilder.append(",slices=").append(this.slices);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        this.radius = 0.0f;
        this.startAngle = 0.0f;
        this.endAngle = 0.0f;
        this.slices = 0;
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics, boolean bl) {
        drawablePerformanceMetrics.allocatedCircularSectors = drawablePerformanceMetrics.allocatedCircularSectors + (bl ? 1 : -1);
    }

    @Override
    protected Effect createEffect(Graphics3D graphics3D) {
        return graphics3D.getEffectManager().getColorEffect();
    }

    @Override
    public float getRadius() {
        return this.radius;
    }

    @Override
    public void setRadius(float f2) {
        if (this.radius != f2) {
            this.radius = f2;
            this.invalidateGeometry();
        }
    }

    @Override
    public float getStartAngle() {
        return this.startAngle;
    }

    @Override
    public void setStartAngle(float f2) {
        if (this.startAngle != f2) {
            this.startAngle = f2;
            this.invalidateGeometry();
        }
    }

    @Override
    public float getEndAngle() {
        return this.endAngle;
    }

    @Override
    public void setEndAngle(float f2) {
        if (this.endAngle != f2) {
            this.endAngle = f2;
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
        ++drawablePerformanceMetrics.drawnCircularSectors;
    }

    @Override
    protected MeshHeap$SubMesh updateMesh(Texture[] textureArray, List list) {
        Logger logger = this.getLogger();
        CircularSectorDrawableRenderer circularSectorDrawableRenderer = (CircularSectorDrawableRenderer)this.getDrawableRenderer();
        MeshHeap meshHeap = circularSectorDrawableRenderer.getMeshHeap();
        hcb.reset();
        hcb.append(this.radius);
        hcb.append(this.startAngle);
        hcb.append(this.endAngle);
        hcb.append(this.slices);
        long l = hcb.longHashCode();
        MeshHeap$SubMesh meshHeap$SubMesh = meshHeap.getSubMesh(l);
        if (meshHeap$SubMesh == null) {
            CircularSectorMeshTesselator circularSectorMeshTesselator = circularSectorDrawableRenderer.getTesselator();
            try {
                circularSectorMeshTesselator.tesselateCircularSectorMesh(this.radius, this.startAngle, this.endAngle, this.slices);
                meshHeap$SubMesh = meshHeap.insertSubMesh(l, circularSectorMeshTesselator.getPrimitiveType(), circularSectorMeshTesselator.getVertexCount());
                meshHeap$SubMesh.setVertexData(circularSectorMeshTesselator.getVertexArray(0));
            }
            catch (InsufficientSpaceException insufficientSpaceException) {
                LogMessage logMessage = logger.error(512);
                logMessage.append(super.getClass().getName());
                logMessage.append(".update() geometry too large: ").append(insufficientSpaceException.getRequiredWidth()).append("x").append(insufficientSpaceException.getRequiredHeight()).log();
            }
        }
        return meshHeap$SubMesh;
    }
}

