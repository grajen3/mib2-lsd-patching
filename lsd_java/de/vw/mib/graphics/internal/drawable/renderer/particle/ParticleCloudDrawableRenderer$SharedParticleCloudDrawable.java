/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.particle;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.particle.ParticleCloudDrawable;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.effect.particle.ParticleEffect;
import de.vw.mib.graphics.internal.InsufficientSpaceException;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer$AbstractSharedDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.particle.ParticleCloudDrawableRenderer;
import de.vw.mib.graphics.internal.mesh.MeshHeap;
import de.vw.mib.graphics.internal.mesh.MeshHeap$SubMesh;
import de.vw.mib.graphics.internal.mesh.tesselation.PointMeshTesselator;
import de.vw.mib.graphics.math.geometry.Point3f;
import de.vw.mib.graphics.texture.Texture;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.util.StringBuilder;
import java.util.Arrays;
import java.util.List;

final class ParticleCloudDrawableRenderer$SharedParticleCloudDrawable
extends AbstractSharedDrawableRenderer$AbstractSharedDrawable
implements ParticleCloudDrawable {
    private Point3f[] coordinates3D;
    private float particleSize;

    public ParticleCloudDrawableRenderer$SharedParticleCloudDrawable(AbstractSharedDrawableRenderer abstractSharedDrawableRenderer, ObjectPool objectPool) {
        super(abstractSharedDrawableRenderer, objectPool);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",coordinates3D=").append(this.coordinates3D);
        stringBuilder.append(",particleSize=").append(this.particleSize);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        this.coordinates3D = null;
        this.particleSize = 0.0f;
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics, boolean bl) {
        drawablePerformanceMetrics.allocatedParticleClouds = drawablePerformanceMetrics.allocatedParticleClouds + (bl ? 1 : -1);
    }

    @Override
    protected Effect createEffect(Graphics3D graphics3D) {
        return graphics3D.getEffectManager().getParticleEffect();
    }

    @Override
    public Point3f[] getCoordinates3D() {
        return this.coordinates3D;
    }

    @Override
    public void setCoordinates3D(Point3f[] point3fArray) {
        if (!Arrays.equals(this.coordinates3D, point3fArray)) {
            int n;
            if (this.coordinates3D == null || this.coordinates3D.length != point3fArray.length) {
                this.coordinates3D = new Point3f[point3fArray.length];
                for (n = 0; n < this.coordinates3D.length; ++n) {
                    this.coordinates3D[n] = new Point3f();
                }
            }
            for (n = 0; n < point3fArray.length; ++n) {
                this.coordinates3D[n].set(point3fArray[n]);
            }
            this.invalidateGeometry();
        }
    }

    @Override
    public float getParticleSize() {
        return this.particleSize;
    }

    @Override
    public void setParticleSize(float f2) {
        if (this.particleSize != f2) {
            this.particleSize = f2;
        }
    }

    @Override
    protected void updateEffect(Effect effect) {
        ParticleEffect particleEffect = (ParticleEffect)effect;
        this.updateTransformationEffect(particleEffect);
        this.updateColorEffect(particleEffect);
        this.updateParticleEffect(particleEffect);
    }

    protected void updateParticleEffect(ParticleEffect particleEffect) {
        Graphics3D graphics3D = this.getGraphics3D();
        graphics3D.setPointSize(this.particleSize);
    }

    @Override
    protected void updateDrawingStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics) {
        ++drawablePerformanceMetrics.drawnParticleClouds;
    }

    @Override
    protected MeshHeap$SubMesh updateMesh(Texture[] textureArray, List list) {
        Logger logger = this.getLogger();
        ParticleCloudDrawableRenderer particleCloudDrawableRenderer = (ParticleCloudDrawableRenderer)this.getDrawableRenderer();
        MeshHeap meshHeap = particleCloudDrawableRenderer.getMeshHeap();
        MeshHeap$SubMesh meshHeap$SubMesh = null;
        hcb.reset();
        hcb.append(this.coordinates3D.length);
        hcb.append(this.coordinates3D);
        long l = hcb.longHashCode();
        meshHeap$SubMesh = meshHeap.getSubMesh(l);
        if (meshHeap$SubMesh == null) {
            PointMeshTesselator pointMeshTesselator = particleCloudDrawableRenderer.getTesselator();
            try {
                pointMeshTesselator.tesselatePointMesh(this.coordinates3D);
                meshHeap$SubMesh = meshHeap.insertSubMesh(l, pointMeshTesselator.getPrimitiveType(), pointMeshTesselator.getVertexCount());
                meshHeap$SubMesh.setVertexData(pointMeshTesselator.getVertexArray(0));
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

