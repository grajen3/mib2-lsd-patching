/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.shape;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.shape.PolyLineDrawable;
import de.vw.mib.graphics.effect.ColorEffect;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.internal.InsufficientSpaceException;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer$AbstractSharedDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.shape.LineDrawableRenderer;
import de.vw.mib.graphics.internal.mesh.MeshHeap;
import de.vw.mib.graphics.internal.mesh.MeshHeap$SubMesh;
import de.vw.mib.graphics.internal.mesh.tesselation.LineMeshTesselator;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.graphics.math.geometry.Point3f;
import de.vw.mib.graphics.texture.Texture;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.util.StringBuilder;
import java.util.Arrays;
import java.util.List;

final class LineDrawableRenderer$SharedLineDrawable
extends AbstractSharedDrawableRenderer$AbstractSharedDrawable
implements PolyLineDrawable {
    private static final float DEFAULT_STROKE_WIDTH;
    private static final boolean DEFAULT_CLOSED;
    private float strokeWidth = 1.0f;
    private Point2f[] coordinates2D;
    private Point3f[] coordinates3D;
    private boolean closed = false;

    public LineDrawableRenderer$SharedLineDrawable(AbstractSharedDrawableRenderer abstractSharedDrawableRenderer, ObjectPool objectPool) {
        super(abstractSharedDrawableRenderer, objectPool);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",strokeWidth=").append(this.strokeWidth);
        stringBuilder.append(",coordinates2D=").append(this.coordinates2D);
        stringBuilder.append(",coordinates3D=").append(this.coordinates3D);
        stringBuilder.append(",closed=").append(this.closed);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        this.strokeWidth = 1.0f;
        this.coordinates2D = null;
        this.coordinates3D = null;
        this.closed = false;
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics, boolean bl) {
        drawablePerformanceMetrics.allocatedPolyLines = drawablePerformanceMetrics.allocatedPolyLines + (bl ? 1 : -1);
    }

    @Override
    protected Effect createEffect(Graphics3D graphics3D) {
        return graphics3D.getEffectManager().getColorEffect();
    }

    @Override
    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    @Override
    public void setStrokeWidth(float f2) {
        if (this.strokeWidth != f2) {
            this.strokeWidth = f2;
        }
    }

    @Override
    public Point2f[] getCoordinates2D() {
        return this.coordinates2D;
    }

    @Override
    public void setCoordinates2D(Point2f[] point2fArray) {
        if (!Arrays.equals(this.coordinates2D, point2fArray)) {
            int n;
            if (this.coordinates2D == null || this.coordinates2D.length != point2fArray.length) {
                this.coordinates2D = new Point2f[point2fArray.length];
                for (n = 0; n < this.coordinates2D.length; ++n) {
                    this.coordinates2D[n] = new Point2f();
                }
            }
            for (n = 0; n < point2fArray.length; ++n) {
                this.coordinates2D[n].set(point2fArray[n]);
            }
            this.coordinates3D = null;
            this.invalidateGeometry();
        }
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
            this.coordinates2D = null;
            this.invalidateGeometry();
        }
    }

    @Override
    public boolean isClosed() {
        return this.closed;
    }

    @Override
    public void setClosed(boolean bl) {
        if (this.closed != bl) {
            this.closed = bl;
            this.invalidateGeometry();
        }
    }

    @Override
    protected void updateEffect(Effect effect) {
        ColorEffect colorEffect = (ColorEffect)effect;
        this.updateTransformationEffect(colorEffect);
        this.updateColorEffect(colorEffect);
        Graphics3D graphics3D = this.getGraphics3D();
        graphics3D.setLineWidth(this.strokeWidth);
    }

    @Override
    protected void updateDrawingStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics) {
        ++drawablePerformanceMetrics.drawnPolyLines;
    }

    @Override
    protected MeshHeap$SubMesh updateMesh(Texture[] textureArray, List list) {
        Logger logger = this.getLogger();
        LineDrawableRenderer lineDrawableRenderer = (LineDrawableRenderer)this.getDrawableRenderer();
        MeshHeap meshHeap = lineDrawableRenderer.getMeshHeap();
        boolean bl = this.coordinates2D != null;
        MeshHeap$SubMesh meshHeap$SubMesh = null;
        hcb.reset();
        hcb.append(this.closed);
        hcb.append(bl);
        hcb.append(bl ? this.coordinates2D.length : this.coordinates3D.length);
        if (bl) {
            hcb.append(this.coordinates2D);
        } else {
            hcb.append(this.coordinates3D);
        }
        long l = hcb.longHashCode();
        meshHeap$SubMesh = meshHeap.getSubMesh(l);
        if (meshHeap$SubMesh == null) {
            LineMeshTesselator lineMeshTesselator = lineDrawableRenderer.getTesselator();
            try {
                if (bl) {
                    lineMeshTesselator.tesselateLineMesh(this.coordinates2D, this.closed);
                } else {
                    lineMeshTesselator.tesselateLineMesh(this.coordinates3D, this.closed);
                }
                meshHeap$SubMesh = meshHeap.insertSubMesh(l, lineMeshTesselator.getPrimitiveType(), lineMeshTesselator.getVertexCount());
                meshHeap$SubMesh.setVertexData(lineMeshTesselator.getVertexArray(0));
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

