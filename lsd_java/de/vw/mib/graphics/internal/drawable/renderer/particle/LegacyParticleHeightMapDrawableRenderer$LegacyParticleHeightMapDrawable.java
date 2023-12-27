/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.particle;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.particle.ParticleHeightMapDrawable;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.effect.particle.BlurredParticleEffect;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.UnsupportedImageFormatException;
import de.vw.mib.graphics.image.UnsupportedImageSizeException;
import de.vw.mib.graphics.internal.InsufficientSpaceException;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer$AbstractSharedDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.particle.LegacyParticleHeightMapDrawableRenderer;
import de.vw.mib.graphics.internal.mesh.MeshBuilder;
import de.vw.mib.graphics.internal.mesh.MeshHeap;
import de.vw.mib.graphics.internal.mesh.MeshHeap$SubMesh;
import de.vw.mib.graphics.math.Tuple4f;
import de.vw.mib.graphics.math.algebra.Vector2f;
import de.vw.mib.graphics.texture.Texture;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.util.StringBuilder;
import java.nio.ByteBuffer;
import java.util.List;

final class LegacyParticleHeightMapDrawableRenderer$LegacyParticleHeightMapDrawable
extends AbstractSharedDrawableRenderer$AbstractSharedDrawable
implements ParticleHeightMapDrawable {
    private BufferImage animationStartMap1;
    private BufferImage animationStartMap2;
    private BufferImage animationEndMap1;
    private BufferImage animationEndMap2;
    private Color4f tintColor = new Color4f(Color4f.BLACK_TRANSPARENT);
    private byte[] animationStartData1;
    private byte[] animationStartData2;
    private byte[] animationEndData1;
    private byte[] animationEndData2;
    private Tuple4f[] attributeStartValues;
    private Tuple4f[] attributeEndValues;
    private Tuple4f[] attributeAnimationValues;
    private Vector2f geometryCenter = new Vector2f();

    public LegacyParticleHeightMapDrawableRenderer$LegacyParticleHeightMapDrawable(AbstractSharedDrawableRenderer abstractSharedDrawableRenderer, ObjectPool objectPool) {
        super(abstractSharedDrawableRenderer, objectPool);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",animationStartMap1=").append(this.animationStartMap1);
        stringBuilder.append(",animationStartMap2=").append(this.animationStartMap2);
        stringBuilder.append(",animationEndMap1=").append(this.animationEndMap1);
        stringBuilder.append(",animationEndMap2=").append(this.animationEndMap2);
        stringBuilder.append(",tintColor=").append(this.tintColor);
        stringBuilder.append(",geometryCenter=").append(this.geometryCenter);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        this.tintColor.set(Color4f.BLACK_TRANSPARENT);
        if (this.animationEndMap2 != null) {
            this.animationEndMap2.dispose();
            this.animationEndMap2 = null;
        }
        if (this.animationEndMap1 != null) {
            this.animationEndMap1.dispose();
            this.animationEndMap1 = null;
        }
        if (this.animationStartMap2 != null) {
            this.animationStartMap2.dispose();
            this.animationStartMap2 = null;
        }
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
        return graphics3D.getEffectManager().getBlurredParticleEffect();
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
    protected void updateEffect(Effect effect) {
        BlurredParticleEffect blurredParticleEffect = (BlurredParticleEffect)effect;
        this.updateTransformationEffect(blurredParticleEffect);
        this.updateColorEffect(blurredParticleEffect);
        this.updateBlurredParticleEffect(blurredParticleEffect);
    }

    protected void updateBlurredParticleEffect(BlurredParticleEffect blurredParticleEffect) {
        blurredParticleEffect.setTintColor(this.tintColor);
        blurredParticleEffect.setGeometryCenter(this.geometryCenter);
        if (this.attributeStartValues != null) {
            blurredParticleEffect.setAttributeStartValues(this.attributeStartValues);
        }
        if (this.attributeEndValues != null) {
            blurredParticleEffect.setAttributeEndValues(this.attributeEndValues);
        }
        if (this.attributeAnimationValues != null) {
            blurredParticleEffect.setAttributeAnimationValues(this.attributeAnimationValues);
        }
    }

    @Override
    protected void updateDrawingStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics) {
        ++drawablePerformanceMetrics.drawnParticleHeightMaps;
    }

    @Override
    protected MeshHeap$SubMesh updateMesh(Texture[] textureArray, List list) {
        Logger logger = this.getLogger();
        LegacyParticleHeightMapDrawableRenderer legacyParticleHeightMapDrawableRenderer = (LegacyParticleHeightMapDrawableRenderer)this.getDrawableRenderer();
        MeshHeap meshHeap = legacyParticleHeightMapDrawableRenderer.getMeshHeap();
        int n = this.animationStartMap1.getWidth();
        int n2 = this.animationStartMap1.getHeight();
        int n3 = this.animationStartMap1.getWidth();
        int n4 = this.animationStartMap1.getHeight();
        hcb.reset();
        hcb.append(n);
        hcb.append(n2);
        hcb.append(n3);
        hcb.append(n4);
        hcb.append(this.animationStartMap1.getId());
        hcb.append(this.animationStartMap2.getId());
        hcb.append(this.animationEndMap1.getId());
        hcb.append(this.animationEndMap2.getId());
        long l = hcb.longHashCode();
        MeshHeap$SubMesh meshHeap$SubMesh = meshHeap.getSubMesh(l);
        if (meshHeap$SubMesh == null) {
            int n5 = n3 * n4;
            MeshBuilder meshBuilder = legacyParticleHeightMapDrawableRenderer.getMeshBuilder();
            if (n5 > meshBuilder.getMaxVertices()) {
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
            ByteBuffer byteBuffer = this.animationStartMap1.getBuffer();
            ByteBuffer byteBuffer2 = this.animationStartMap2.getBuffer();
            ByteBuffer byteBuffer3 = this.animationEndMap1.getBuffer();
            ByteBuffer byteBuffer4 = this.animationEndMap2.getBuffer();
            boolean bl = true;
            if (this.animationStartData1 == null || this.animationStartData1.length < byteBuffer.capacity()) {
                this.animationStartData1 = new byte[byteBuffer.capacity()];
            }
            if (this.animationStartData2 == null || this.animationStartData2.length < byteBuffer2.capacity()) {
                this.animationStartData2 = new byte[byteBuffer2.capacity()];
            }
            if (this.animationEndData1 == null || this.animationEndData1.length < byteBuffer3.capacity()) {
                this.animationEndData1 = new byte[byteBuffer3.capacity()];
            }
            if (this.animationEndData2 == null || this.animationEndData2.length < byteBuffer4.capacity()) {
                this.animationEndData2 = new byte[byteBuffer4.capacity()];
            }
            byteBuffer.rewind();
            byteBuffer.get(this.animationStartData1);
            byteBuffer2.rewind();
            byteBuffer2.get(this.animationStartData2);
            byteBuffer3.rewind();
            byteBuffer3.get(this.animationEndData1);
            byteBuffer4.rewind();
            byteBuffer4.get(this.animationEndData2);
            meshBuilder.beginGeometry(0, 0);
            float f2 = n / n3;
            float f3 = n2 / n4;
            int n7 = 4;
            int n8 = 0;
            for (int i2 = 0; i2 < n4; ++i2) {
                for (int i3 = 0; i3 < n3; ++i3) {
                    float f4 = (float)i3 * f2;
                    float f5 = (float)i2 * f3;
                    float f6 = 0.0f;
                    int n9 = LegacyParticleHeightMapDrawableRenderer$LegacyParticleHeightMapDrawable.getPixelABGR(this.animationStartData1, n8);
                    int n10 = LegacyParticleHeightMapDrawableRenderer$LegacyParticleHeightMapDrawable.getPixelABGR(this.animationStartData2, n8);
                    int n11 = LegacyParticleHeightMapDrawableRenderer$LegacyParticleHeightMapDrawable.getPixelABGR(this.animationEndData1, n8);
                    int n12 = LegacyParticleHeightMapDrawableRenderer$LegacyParticleHeightMapDrawable.getPixelABGR(this.animationEndData2, n8);
                    meshBuilder.beginVertex();
                    meshBuilder.setVertexPosition(f4, f5, 0.0f);
                    meshBuilder.setVertexColor(1, n9);
                    meshBuilder.setVertexColor(2, n10);
                    meshBuilder.setVertexColor(3, n11);
                    meshBuilder.setVertexColor(4, n12);
                    meshBuilder.endVertex();
                    n8 += 4;
                }
            }
            meshBuilder.endGeometry();
            int n13 = meshBuilder.getVertexCount();
            meshHeap$SubMesh = meshHeap.insertSubMesh(l, 0, n13);
            meshHeap$SubMesh.setVertexData(meshBuilder.getVertexArray());
        }
        return meshHeap$SubMesh;
    }

    private static int getPixelABGR(byte[] byArray, int n) {
        int n2 = byArray[n + 0] & 0xFF;
        int n3 = byArray[n + 1] & 0xFF;
        int n4 = byArray[n + 2] & 0xFF;
        int n5 = byArray[n + 3] & 0xFF;
        return n5 << 24 | n4 << 16 | n3 << 8 | n2;
    }
}

