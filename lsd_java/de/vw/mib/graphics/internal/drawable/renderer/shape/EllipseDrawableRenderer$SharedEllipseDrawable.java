/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.shape;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.shape.EllipseDrawable;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.effect.gradient.RadialGradientEffect;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer$AbstractSharedDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.shape.EllipseDrawableRenderer;
import de.vw.mib.graphics.internal.mesh.MeshBuilder;
import de.vw.mib.graphics.internal.mesh.MeshHeap;
import de.vw.mib.graphics.internal.mesh.MeshHeap$SubMesh;
import de.vw.mib.graphics.texture.Texture;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.util.StringBuilder;
import java.util.List;

final class EllipseDrawableRenderer$SharedEllipseDrawable
extends AbstractSharedDrawableRenderer$AbstractSharedDrawable
implements EllipseDrawable {
    private int x;
    private int y;
    private int width;
    private int height;

    public EllipseDrawableRenderer$SharedEllipseDrawable(AbstractSharedDrawableRenderer abstractSharedDrawableRenderer, ObjectPool objectPool) {
        super(abstractSharedDrawableRenderer, objectPool);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",x=").append(this.x);
        stringBuilder.append(",y=").append(this.y);
        stringBuilder.append(",width=").append(this.width);
        stringBuilder.append(",height=").append(this.height);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics, boolean bl) {
        drawablePerformanceMetrics.allocatedEllipses = drawablePerformanceMetrics.allocatedEllipses + (bl ? 1 : -1);
    }

    @Override
    protected Effect createEffect(Graphics3D graphics3D) {
        return graphics3D.getEffectManager().getRadialGradientEffect();
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public void setX(int n) {
        if (this.x != n) {
            this.x = n;
            this.invalidateGeometry();
        }
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setY(int n) {
        if (this.y != n) {
            this.y = n;
            this.invalidateGeometry();
        }
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public void setWidth(int n) {
        if (this.width != n) {
            this.width = n;
            this.invalidateGeometry();
        }
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setHeight(int n) {
        if (this.height != n) {
            this.height = n;
            this.invalidateGeometry();
        }
    }

    @Override
    public void set(int n, int n2, int n3, int n4) {
        if (this.x != n || this.y != n2 || this.width != n3 || this.height != n4) {
            this.x = n;
            this.y = n2;
            this.width = n3;
            this.height = n4;
            this.invalidateGeometry();
        }
    }

    @Override
    public void set(Rectangle rectangle) {
        if (this.x != rectangle.x || this.y != rectangle.y || this.width != rectangle.width || this.height != rectangle.height) {
            this.x = rectangle.x;
            this.y = rectangle.y;
            this.width = rectangle.width;
            this.height = rectangle.height;
            this.invalidateGeometry();
        }
    }

    @Override
    protected void updateEffect(Effect effect) {
        RadialGradientEffect radialGradientEffect = (RadialGradientEffect)effect;
        this.updateTransformationEffect(radialGradientEffect);
        this.updateColorEffect(radialGradientEffect);
        this.updateRadialGradientEffect(radialGradientEffect);
    }

    protected void updateRadialGradientEffect(RadialGradientEffect radialGradientEffect) {
        radialGradientEffect.setCenter(EllipseDrawableRenderer.ELLIPSE_CENTER);
        radialGradientEffect.setOuterRadius(63);
        radialGradientEffect.setInnerRadius(-842249155);
        radialGradientEffect.setGradientColor(EllipseDrawableRenderer.ELLIPSE_COLOR);
    }

    @Override
    protected void updateDrawingStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics) {
        ++drawablePerformanceMetrics.drawnEllipses;
    }

    @Override
    protected MeshHeap$SubMesh updateMesh(Texture[] textureArray, List list) {
        MeshHeap$SubMesh meshHeap$SubMesh = null;
        if (this.width > 0 && this.height > 0) {
            long l;
            Logger logger = this.getLogger();
            EllipseDrawableRenderer ellipseDrawableRenderer = (EllipseDrawableRenderer)this.getDrawableRenderer();
            MeshHeap meshHeap = ellipseDrawableRenderer.getMeshHeap();
            meshHeap$SubMesh = meshHeap.getSubMesh(l = EllipseDrawableRenderer$SharedEllipseDrawable.calculateMeshKey(this.x, this.y, this.width, this.height));
            if (meshHeap$SubMesh == null) {
                MeshBuilder meshBuilder = ellipseDrawableRenderer.getMeshBuilder();
                meshBuilder.beginGeometry(6, 0);
                int n = this.x;
                int n2 = this.y;
                int n3 = n + this.width;
                int n4 = n2 + this.height;
                float f2 = 0.0f;
                float f3 = 0.0f;
                float f4 = 1.0f;
                float f5 = 1.0f;
                meshBuilder.beginVertex();
                meshBuilder.setVertexPosition(n, n2);
                meshBuilder.setVertexTextureCoordinate(0, 0.0f, 0.0f);
                meshBuilder.endVertex();
                meshBuilder.beginVertex();
                meshBuilder.setVertexPosition(n, n4);
                meshBuilder.setVertexTextureCoordinate(0, 0.0f, 1.0f);
                meshBuilder.endVertex();
                meshBuilder.beginVertex();
                meshBuilder.setVertexPosition(n3, n4);
                meshBuilder.setVertexTextureCoordinate(0, 1.0f, 1.0f);
                meshBuilder.endVertex();
                meshBuilder.beginVertex();
                meshBuilder.setVertexPosition(n3, n2);
                meshBuilder.setVertexTextureCoordinate(0, 1.0f, 0.0f);
                meshBuilder.endVertex();
                meshBuilder.endGeometry();
                n = meshBuilder.getVertexCount();
                meshHeap$SubMesh = meshHeap.insertSubMesh(l, 6, n);
                meshHeap$SubMesh.setVertexData(meshBuilder.getVertexArray());
            }
        }
        return meshHeap$SubMesh;
    }

    protected static long calculateMeshKey(int n, int n2, int n3, int n4) {
        hcb.reset();
        hcb.append(n);
        hcb.append(n2);
        hcb.append(n3);
        hcb.append(n4);
        return hcb.longHashCode();
    }
}

