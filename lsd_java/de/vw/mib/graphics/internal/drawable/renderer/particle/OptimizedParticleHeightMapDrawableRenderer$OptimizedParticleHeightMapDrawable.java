/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.particle;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.particle.ParticleHeightMapDrawable;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.effect.particle.BlurredParticleHeightMapEffect;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.UnsupportedImageFormatException;
import de.vw.mib.graphics.image.UnsupportedImageSizeException;
import de.vw.mib.graphics.internal.InsufficientSpaceException;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer$AbstractSharedDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.particle.OptimizedParticleHeightMapDrawableRenderer;
import de.vw.mib.graphics.internal.mesh.MeshHeap;
import de.vw.mib.graphics.internal.mesh.MeshHeap$SubMesh;
import de.vw.mib.graphics.internal.mesh.tesselation.PointMeshTesselator;
import de.vw.mib.graphics.internal.texture.TextureAtlas$SubTexture;
import de.vw.mib.graphics.math.Tuple4f;
import de.vw.mib.graphics.math.algebra.Vector2f;
import de.vw.mib.graphics.math.algebra.Vector4f;
import de.vw.mib.graphics.texture.Texture;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.util.StringBuilder;
import java.util.List;

final class OptimizedParticleHeightMapDrawableRenderer$OptimizedParticleHeightMapDrawable
extends AbstractSharedDrawableRenderer$AbstractSharedDrawable
implements ParticleHeightMapDrawable {
    private static final int ANIMATION_START_MAP1_SAMPLER;
    private static final int ANIMATION_START_MAP2_SAMPLER;
    private static final int ANIMATION_END_MAP1_SAMPLER;
    private static final int ANIMATION_END_MAP2_SAMPLER;
    private BufferImage animationStartMap1;
    private final Tuple4f animationStartMap1Rect = new Vector4f();
    private BufferImage animationStartMap2;
    private final Tuple4f animationStartMap2Rect = new Vector4f();
    private BufferImage animationEndMap1;
    private final Tuple4f animationEndMap1Rect = new Vector4f();
    private BufferImage animationEndMap2;
    private final Tuple4f animationEndMap2Rect = new Vector4f();
    private Tuple4f[] attributeStartValues;
    private Tuple4f[] attributeEndValues;
    private Tuple4f[] attributeAnimationValues;
    private final Color4f tintColor = new Color4f(Color4f.BLACK_TRANSPARENT);
    private final Vector2f geometryCenter = new Vector2f();

    public OptimizedParticleHeightMapDrawableRenderer$OptimizedParticleHeightMapDrawable(AbstractSharedDrawableRenderer abstractSharedDrawableRenderer, ObjectPool objectPool) {
        super(abstractSharedDrawableRenderer, objectPool);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",animationStartMap1=").append(this.animationStartMap1);
        stringBuilder.append(",animationStartMap1Rect=").append(this.animationStartMap1Rect);
        stringBuilder.append(",animationStartMap2=").append(this.animationStartMap2);
        stringBuilder.append(",animationStartMap2Rect=").append(this.animationStartMap2Rect);
        stringBuilder.append(",animationEndMap1=").append(this.animationEndMap1);
        stringBuilder.append(",animationEndMap1Rect=").append(this.animationEndMap1Rect);
        stringBuilder.append(",animationEndMap2=").append(this.animationEndMap2);
        stringBuilder.append(",animationEndMap2Rect=").append(this.animationEndMap2Rect);
        stringBuilder.append(",tintColor=").append(this.tintColor);
        stringBuilder.append(",geometryCenter=").append(this.geometryCenter);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        this.tintColor.set(Color4f.BLACK_TRANSPARENT);
        this.animationEndMap2Rect.setZero();
        if (this.animationEndMap2 != null) {
            this.animationEndMap2.dispose();
            this.animationEndMap2 = null;
        }
        this.animationEndMap1Rect.setZero();
        if (this.animationEndMap1 != null) {
            this.animationEndMap1.dispose();
            this.animationEndMap1 = null;
        }
        this.animationStartMap2Rect.setZero();
        if (this.animationStartMap2 != null) {
            this.animationStartMap2.dispose();
            this.animationStartMap2 = null;
        }
        this.animationStartMap1Rect.setZero();
        if (this.animationStartMap1 != null) {
            this.animationStartMap1.dispose();
            this.animationStartMap1 = null;
        }
        this.attributeStartValues = null;
        this.attributeEndValues = null;
        this.attributeAnimationValues = null;
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics, boolean bl) {
        drawablePerformanceMetrics.allocatedParticleHeightMaps = drawablePerformanceMetrics.allocatedParticleHeightMaps + (bl ? 1 : -1);
    }

    @Override
    protected Effect createEffect(Graphics3D graphics3D) {
        return graphics3D.getEffectManager().getBlurredParticleHeightMapEffect();
    }

    @Override
    public BufferImage getAnimationStartMap1() {
        return this.animationStartMap1;
    }

    @Override
    public void setAnimationStartMap1(BufferImage bufferImage) {
        if (this.animationStartMap1 == null || !this.animationStartMap1.equals(bufferImage)) {
            if (this.animationStartMap1 != null) {
                this.animationStartMap1.dispose();
            }
            bufferImage.reference();
            this.animationStartMap1 = bufferImage;
            this.geometryCenter.set((float)this.animationStartMap1.getWidth() / 2.0f, (float)this.animationStartMap1.getHeight() / 2.0f);
            this.invalidateGeometry();
        }
    }

    @Override
    public BufferImage getAnimationStartMap2() {
        return this.animationStartMap2;
    }

    @Override
    public void setAnimationStartMap2(BufferImage bufferImage) {
        if (this.animationStartMap2 == null || !this.animationStartMap2.equals(bufferImage)) {
            if (this.animationStartMap2 != null) {
                this.animationStartMap2.dispose();
            }
            bufferImage.reference();
            this.animationStartMap2 = bufferImage;
            this.invalidateGeometry();
        }
    }

    @Override
    public BufferImage getAnimationEndMap1() {
        return this.animationEndMap1;
    }

    @Override
    public void setAnimationEndMap1(BufferImage bufferImage) {
        if (this.animationEndMap1 == null || !this.animationEndMap1.equals(bufferImage)) {
            if (this.animationEndMap1 != null) {
                this.animationEndMap1.dispose();
            }
            bufferImage.reference();
            this.animationEndMap1 = bufferImage;
            this.invalidateGeometry();
        }
    }

    @Override
    public BufferImage getAnimationEndMap2() {
        return this.animationEndMap2;
    }

    @Override
    public void setAnimationEndMap2(BufferImage bufferImage) {
        if (this.animationEndMap2 == null || !this.animationEndMap2.equals(bufferImage)) {
            if (this.animationEndMap2 != null) {
                this.animationEndMap2.dispose();
            }
            bufferImage.reference();
            this.animationEndMap2 = bufferImage;
            this.invalidateGeometry();
        }
    }

    @Override
    public Color4f getTintColor() {
        return this.tintColor;
    }

    @Override
    public void setTintColor(Color4f color4f) {
        if (!this.tintColor.equals(color4f)) {
            this.tintColor.set(color4f);
        }
    }

    @Override
    public Tuple4f[] getAttributeStartValues() {
        return this.attributeStartValues;
    }

    @Override
    public void setAttributeStartValues(Tuple4f[] tuple4fArray) {
        this.attributeStartValues = tuple4fArray;
    }

    @Override
    public Tuple4f[] getAttributeEndValues() {
        return this.attributeEndValues;
    }

    @Override
    public void setAttributeEndValues(Tuple4f[] tuple4fArray) {
        this.attributeEndValues = tuple4fArray;
    }

    @Override
    public Tuple4f[] getAttributeAnimationValues() {
        return this.attributeAnimationValues;
    }

    @Override
    public void setAttributeAnimationValues(Tuple4f[] tuple4fArray) {
        this.attributeAnimationValues = tuple4fArray;
    }

    @Override
    protected void updateEffect(Effect effect) {
        BlurredParticleHeightMapEffect blurredParticleHeightMapEffect = (BlurredParticleHeightMapEffect)effect;
        this.updateTransformationEffect(blurredParticleHeightMapEffect);
        this.updateColorEffect(blurredParticleHeightMapEffect);
        this.updateBlurredParticleHeightMapEffect(blurredParticleHeightMapEffect);
    }

    protected void updateBlurredParticleHeightMapEffect(BlurredParticleHeightMapEffect blurredParticleHeightMapEffect) {
        blurredParticleHeightMapEffect.setAnimationStartMap1Sampler(0);
        blurredParticleHeightMapEffect.setAnimationStartMap1Rect(this.animationStartMap1Rect);
        blurredParticleHeightMapEffect.setAnimationStartMap2Sampler(1);
        blurredParticleHeightMapEffect.setAnimationStartMap2Rect(this.animationStartMap2Rect);
        blurredParticleHeightMapEffect.setAnimationEndMap1Sampler(2);
        blurredParticleHeightMapEffect.setAnimationEndMap1Rect(this.animationEndMap1Rect);
        blurredParticleHeightMapEffect.setAnimationEndMap2Sampler(3);
        blurredParticleHeightMapEffect.setAnimationEndMap2Rect(this.animationEndMap2Rect);
        blurredParticleHeightMapEffect.setGeometryCenter(this.geometryCenter);
        if (this.attributeStartValues != null) {
            blurredParticleHeightMapEffect.setAttributeStartValues(this.attributeStartValues);
        }
        if (this.attributeEndValues != null) {
            blurredParticleHeightMapEffect.setAttributeEndValues(this.attributeEndValues);
        }
        if (this.attributeAnimationValues != null) {
            blurredParticleHeightMapEffect.setAttributeAnimationValues(this.attributeAnimationValues);
        }
        blurredParticleHeightMapEffect.setTintColor(this.tintColor);
    }

    @Override
    protected void updateDrawingStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics) {
        ++drawablePerformanceMetrics.drawnParticleHeightMaps;
    }

    @Override
    protected MeshHeap$SubMesh updateMesh(Texture[] textureArray, List list) {
        Logger logger = this.getLogger();
        OptimizedParticleHeightMapDrawableRenderer optimizedParticleHeightMapDrawableRenderer = (OptimizedParticleHeightMapDrawableRenderer)this.getDrawableRenderer();
        MeshHeap meshHeap = optimizedParticleHeightMapDrawableRenderer.getMeshHeap();
        int n = this.animationStartMap1.getWidth();
        int n2 = this.animationStartMap1.getHeight();
        int n3 = this.animationStartMap1.getWidth();
        int n4 = this.animationStartMap1.getHeight();
        TextureAtlas$SubTexture textureAtlas$SubTexture = optimizedParticleHeightMapDrawableRenderer.getTextureAtlas().getSubTexture(this.animationStartMap1);
        OptimizedParticleHeightMapDrawableRenderer$OptimizedParticleHeightMapDrawable.setSubTextureRectangle(this.animationStartMap1Rect, textureAtlas$SubTexture, n, n2);
        TextureAtlas$SubTexture textureAtlas$SubTexture2 = optimizedParticleHeightMapDrawableRenderer.getTextureAtlas().getSubTexture(this.animationStartMap2);
        OptimizedParticleHeightMapDrawableRenderer$OptimizedParticleHeightMapDrawable.setSubTextureRectangle(this.animationStartMap2Rect, textureAtlas$SubTexture2, n, n2);
        TextureAtlas$SubTexture textureAtlas$SubTexture3 = optimizedParticleHeightMapDrawableRenderer.getTextureAtlas().getSubTexture(this.animationEndMap1);
        OptimizedParticleHeightMapDrawableRenderer$OptimizedParticleHeightMapDrawable.setSubTextureRectangle(this.animationEndMap1Rect, textureAtlas$SubTexture3, n, n2);
        TextureAtlas$SubTexture textureAtlas$SubTexture4 = optimizedParticleHeightMapDrawableRenderer.getTextureAtlas().getSubTexture(this.animationEndMap2);
        OptimizedParticleHeightMapDrawableRenderer$OptimizedParticleHeightMapDrawable.setSubTextureRectangle(this.animationEndMap2Rect, textureAtlas$SubTexture4, n, n2);
        long l = OptimizedParticleHeightMapDrawableRenderer$OptimizedParticleHeightMapDrawable.calculateMeshKey(n, n2, n3, n4, textureAtlas$SubTexture, textureAtlas$SubTexture2, textureAtlas$SubTexture3, textureAtlas$SubTexture4);
        MeshHeap$SubMesh meshHeap$SubMesh = meshHeap.getSubMesh(l);
        if (meshHeap$SubMesh == null) {
            int n5 = n3 * n4;
            PointMeshTesselator pointMeshTesselator = optimizedParticleHeightMapDrawableRenderer.getTesselator();
            if (n5 > pointMeshTesselator.getMaxVertexCount()) {
                throw new InsufficientSpaceException(n, n2);
            }
            int n6 = 4356;
            if (this.animationStartMap1.getImageFormat() != 4356) {
                throw new UnsupportedImageFormatException(this.animationStartMap1.getImageFormat());
            }
            if (this.animationStartMap2.getImageFormat() != 4356) {
                throw new UnsupportedImageFormatException(this.animationStartMap2.getImageFormat());
            }
            if (this.animationEndMap1.getImageFormat() != 4356) {
                throw new UnsupportedImageFormatException(this.animationEndMap1.getImageFormat());
            }
            if (this.animationEndMap2.getImageFormat() != 4356) {
                throw new UnsupportedImageFormatException(this.animationEndMap2.getImageFormat());
            }
            if (this.animationStartMap2.getWidth() != n3 || this.animationStartMap2.getHeight() != n4) {
                throw new UnsupportedImageSizeException(this.animationStartMap2.getWidth(), this.animationStartMap2.getHeight());
            }
            if (this.animationEndMap1.getWidth() != n3 || this.animationEndMap1.getHeight() != n4) {
                throw new UnsupportedImageSizeException(this.animationEndMap1.getWidth(), this.animationEndMap1.getHeight());
            }
            if (this.animationEndMap2.getWidth() != n3 || this.animationEndMap2.getHeight() != n4) {
                throw new UnsupportedImageSizeException(this.animationEndMap2.getWidth(), this.animationEndMap2.getHeight());
            }
            pointMeshTesselator.tesselateUniformPointGridMesh(n, n2, n3, n4);
            meshHeap$SubMesh = meshHeap.insertSubMesh(l, pointMeshTesselator.getPrimitiveType(), pointMeshTesselator.getVertexCount());
            meshHeap$SubMesh.setVertexData(pointMeshTesselator.getVertexArray(0));
        }
        textureArray[0] = textureAtlas$SubTexture.getTexture();
        list.add(textureAtlas$SubTexture);
        textureArray[1] = textureAtlas$SubTexture2.getTexture();
        list.add(textureAtlas$SubTexture2);
        textureArray[2] = textureAtlas$SubTexture3.getTexture();
        list.add(textureAtlas$SubTexture3);
        textureArray[3] = textureAtlas$SubTexture4.getTexture();
        list.add(textureAtlas$SubTexture4);
        return meshHeap$SubMesh;
    }

    protected static long calculateMeshKey(int n, int n2, int n3, int n4, TextureAtlas$SubTexture textureAtlas$SubTexture, TextureAtlas$SubTexture textureAtlas$SubTexture2, TextureAtlas$SubTexture textureAtlas$SubTexture3, TextureAtlas$SubTexture textureAtlas$SubTexture4) {
        hcb.reset();
        hcb.append(n);
        hcb.append(n2);
        hcb.append(n3);
        hcb.append(n4);
        hcb.append(textureAtlas$SubTexture.getId());
        hcb.append(textureAtlas$SubTexture2.getId());
        hcb.append(textureAtlas$SubTexture3.getId());
        hcb.append(textureAtlas$SubTexture4.getId());
        return hcb.longHashCode();
    }
}

