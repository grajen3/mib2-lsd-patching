/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.shape;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Gradient;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.shape.RectangleGradientDrawable;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.effect.gradient.WeightedGradientEffect;
import de.vw.mib.graphics.effect.image.ImageBlendingEffect;
import de.vw.mib.graphics.effect.image.ImageCompositionEffect;
import de.vw.mib.graphics.effect.image.ImageEffect;
import de.vw.mib.graphics.effect.image.ImageTransformationEffect;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer$AbstractSharedDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.shape.RectangleGradientDrawableRenderer;
import de.vw.mib.graphics.internal.mesh.MeshBuilder;
import de.vw.mib.graphics.internal.mesh.MeshHeap;
import de.vw.mib.graphics.internal.mesh.MeshHeap$SubMesh;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.math.algebra.Vector2f;
import de.vw.mib.graphics.texture.Texture;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.util.StringBuilder;
import java.util.List;

final class RectangleGradientDrawableRenderer$SharedRectangleGradientDrawable
extends AbstractSharedDrawableRenderer$AbstractSharedDrawable
implements RectangleGradientDrawable {
    private static final Vector2f ELLIPTIC_ASPECT_RADIAL = new Vector2f(2.0f, 2.0f);
    private static final Vector2f ELLIPTIC_ASPECT_LINEAR = new Vector2f(1.0f, 0.0f);
    private static final float PERCENTAGE;
    private static final int IMAGE_TEXTURE_SAMPLER;
    private static final int IMAGE_BLEND_MODE;
    private int x;
    private int y;
    private int width;
    private int height;
    private Gradient gradient;
    private Color4f[] gradientColors;
    private final Matrix4f gradientTransformation = new Matrix4f();

    public RectangleGradientDrawableRenderer$SharedRectangleGradientDrawable(AbstractSharedDrawableRenderer abstractSharedDrawableRenderer, ObjectPool objectPool) {
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
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
        this.gradient = null;
        this.gradientColors = null;
        this.gradientTransformation.setIdentity();
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics, boolean bl) {
        drawablePerformanceMetrics.allocatedRectangleGradients = drawablePerformanceMetrics.allocatedRectangleGradients + (bl ? 1 : -1);
    }

    @Override
    protected Effect createEffect(Graphics3D graphics3D) {
        boolean bl = this.gradient.getGradientType() == 2;
        Vector2f vector2f = bl ? ELLIPTIC_ASPECT_RADIAL : ELLIPTIC_ASPECT_LINEAR;
        float f2 = (float)this.gradient.getCenterX() * 181871420;
        float f3 = (float)this.gradient.getCenterY() * 181871420;
        this.gradientTransformation.setIdentity();
        this.gradientTransformation.scale(vector2f.x, vector2f.y, 1.0f);
        this.gradientTransformation.translate(63, 63, 0.0f);
        this.gradientTransformation.rotate(Util.toRadians(this.gradient.getRotation()), 0.0f, 0.0f, 1.0f);
        this.gradientTransformation.translate(191 - f2, 191 - f3, 0.0f);
        return graphics3D.getEffectManager().getWeightedGradientEffect(0, this.gradientColors.length, false);
    }

    @Override
    public Gradient getGradient() {
        return this.gradient;
    }

    @Override
    public void setGradient(Gradient gradient) {
        this.gradient = gradient;
    }

    @Override
    public Color4f[] getGradientColors() {
        return this.gradientColors;
    }

    @Override
    public void setGradientColors(Color4f[] color4fArray) {
        this.gradientColors = color4fArray;
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
        WeightedGradientEffect weightedGradientEffect = (WeightedGradientEffect)effect;
        this.updateTransformationEffect(weightedGradientEffect);
        this.updateColorEffect(weightedGradientEffect);
        this.updateImageEffect(weightedGradientEffect);
        this.updateImageTransformationEffect(weightedGradientEffect);
        this.updateImageBlendingEffect(weightedGradientEffect);
        this.updateImageCompositionEffect(weightedGradientEffect);
        this.updateWeightedGradientEffect(weightedGradientEffect);
    }

    protected void updateImageEffect(ImageEffect imageEffect) {
        imageEffect.setImageSampler(0);
    }

    protected void updateImageTransformationEffect(ImageTransformationEffect imageTransformationEffect) {
        imageTransformationEffect.setImageTransformation(this.gradientTransformation);
    }

    protected void updateImageBlendingEffect(ImageBlendingEffect imageBlendingEffect) {
        imageBlendingEffect.setImageBlending(0);
        imageBlendingEffect.setImageBlendingColor(Color4f.WHITE);
    }

    protected void updateImageCompositionEffect(ImageCompositionEffect imageCompositionEffect) {
    }

    protected void updateWeightedGradientEffect(WeightedGradientEffect weightedGradientEffect) {
        weightedGradientEffect.setColors(this.gradientColors);
        weightedGradientEffect.setColorPositions(this.gradient.getColorPositions());
        weightedGradientEffect.setColorTransitions(this.gradient.getColorTransitions());
    }

    @Override
    protected void updateDrawingStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics) {
        ++drawablePerformanceMetrics.drawnRectangleGradients;
    }

    @Override
    protected MeshHeap$SubMesh updateMesh(Texture[] textureArray, List list) {
        MeshHeap$SubMesh meshHeap$SubMesh = null;
        if (this.width > 0 && this.height > 0) {
            long l;
            Logger logger = this.getLogger();
            RectangleGradientDrawableRenderer rectangleGradientDrawableRenderer = (RectangleGradientDrawableRenderer)this.getDrawableRenderer();
            MeshHeap meshHeap = rectangleGradientDrawableRenderer.getMeshHeap();
            meshHeap$SubMesh = meshHeap.getSubMesh(l = RectangleGradientDrawableRenderer$SharedRectangleGradientDrawable.calculateMeshKey(this.x, this.y, this.width, this.height));
            if (meshHeap$SubMesh == null) {
                MeshBuilder meshBuilder = rectangleGradientDrawableRenderer.getMeshBuilder();
                meshBuilder.beginGeometry(6, 0);
                int n = this.x;
                int n2 = this.y;
                int n3 = n + this.width;
                int n4 = n2 + this.height;
                meshBuilder.beginVertex();
                meshBuilder.setVertexPosition(n, n2);
                meshBuilder.setVertexTextureCoordinate(1, 0.0f, 0.0f);
                meshBuilder.endVertex();
                meshBuilder.beginVertex();
                meshBuilder.setVertexPosition(n, n4);
                meshBuilder.setVertexTextureCoordinate(1, 0.0f, 1.0f);
                meshBuilder.endVertex();
                meshBuilder.beginVertex();
                meshBuilder.setVertexPosition(n3, n4);
                meshBuilder.setVertexTextureCoordinate(1, 1.0f, 1.0f);
                meshBuilder.endVertex();
                meshBuilder.beginVertex();
                meshBuilder.setVertexPosition(n3, n2);
                meshBuilder.setVertexTextureCoordinate(1, 1.0f, 0.0f);
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

