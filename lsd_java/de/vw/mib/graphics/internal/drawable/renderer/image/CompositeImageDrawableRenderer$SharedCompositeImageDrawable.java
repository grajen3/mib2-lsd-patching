/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.image;

import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.image.CompositeImageDrawable;
import de.vw.mib.graphics.drawable.image.ImageDrawable;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.effect.image.ImageCompositionEffect;
import de.vw.mib.graphics.effect.image.ImageTransformationEffect;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.ScaleImage;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.image.CompositeImageDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.image.ImageDrawableRenderer$SharedImageDrawable;
import de.vw.mib.graphics.internal.mesh.MeshBuilder;
import de.vw.mib.graphics.internal.mesh.MeshHeap;
import de.vw.mib.graphics.internal.mesh.MeshHeap$SubMesh;
import de.vw.mib.graphics.internal.texture.TextureAtlas;
import de.vw.mib.graphics.internal.texture.TextureAtlas$SubTexture;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.texture.Texture;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.util.StringBuilder;
import java.util.List;

public class CompositeImageDrawableRenderer$SharedCompositeImageDrawable
extends ImageDrawableRenderer$SharedImageDrawable
implements ImageDrawable,
CompositeImageDrawable {
    protected static final int IMAGE_0_TEXTURE_SAMPLER;
    protected static final int IMAGE_1_TEXTURE_SAMPLER;
    private final BufferImage[] images;
    private final Matrix4f imageTransformation;
    protected final boolean enableGenericTexcoords;

    public CompositeImageDrawableRenderer$SharedCompositeImageDrawable(AbstractSharedDrawableRenderer abstractSharedDrawableRenderer, ObjectPool objectPool) {
        this(abstractSharedDrawableRenderer, objectPool, false);
    }

    protected CompositeImageDrawableRenderer$SharedCompositeImageDrawable(AbstractSharedDrawableRenderer abstractSharedDrawableRenderer, ObjectPool objectPool, boolean bl) {
        super(abstractSharedDrawableRenderer, objectPool);
        this.enableGenericTexcoords = bl;
        this.images = new BufferImage[2];
        this.imageTransformation = new Matrix4f(true);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",images=").append(this.images);
        stringBuilder.append(",imageTransformation=").append(this.imageTransformation);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        for (int i2 = 0; i2 < this.images.length; ++i2) {
            if (this.images[i2] == null) continue;
            this.images[i2].dispose();
            this.images[i2] = null;
        }
        this.imageTransformation.setIdentity();
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics, boolean bl) {
        drawablePerformanceMetrics.allocatedCompositeImages = drawablePerformanceMetrics.allocatedCompositeImages + (bl ? 1 : -1);
    }

    @Override
    protected Effect createEffect(Graphics3D graphics3D) {
        return graphics3D.getEffectManager().getImageCompositionEffect();
    }

    @Override
    public final BufferImage getImage() {
        return this.images[0];
    }

    @Override
    public final void setImage(BufferImage bufferImage) {
        if (this.images[0] == null || !this.images[0].equals(bufferImage)) {
            if (this.images[0] != null) {
                this.images[0].dispose();
            }
            bufferImage.reference();
            this.images[0] = bufferImage;
            this.invalidateGeometry();
        }
    }

    @Override
    public final BufferImage getImage(int n) {
        return this.images[n];
    }

    @Override
    public final void setImage(int n, BufferImage bufferImage) {
        if (this.images[n] == null && bufferImage != null || this.images[n] != null && !this.images[n].equals(bufferImage)) {
            if (this.images[n] != null) {
                this.images[n].dispose();
            }
            if (bufferImage != null) {
                bufferImage.reference();
            }
            this.images[n] = bufferImage;
            this.invalidateGeometry();
        }
    }

    @Override
    public final Matrix4f getImageTransformation() {
        return this.imageTransformation;
    }

    @Override
    public final void setImageTransformation(Matrix4f matrix4f) {
        if (!this.imageTransformation.equals(matrix4f)) {
            this.imageTransformation.set(matrix4f);
        }
    }

    protected final BufferImage[] getImages() {
        return this.images;
    }

    @Override
    protected void updateEffect(Effect effect) {
        ImageCompositionEffect imageCompositionEffect = (ImageCompositionEffect)effect;
        this.updateTransformationEffect(imageCompositionEffect);
        this.updateColorEffect(imageCompositionEffect);
        this.updateImageEffect(imageCompositionEffect);
        this.updateImageBlendingEffect(imageCompositionEffect);
        this.updateImageTransformationEffect(imageCompositionEffect);
        this.updateImageCompositionEffect(imageCompositionEffect);
    }

    @Override
    protected final void updateImageTransformationEffect(ImageTransformationEffect imageTransformationEffect) {
        imageTransformationEffect.setImageTransformation(this.imageTransformation);
    }

    @Override
    protected final void updateImageCompositionEffect(ImageCompositionEffect imageCompositionEffect) {
        for (int i2 = 0; i2 < this.images.length; ++i2) {
            imageCompositionEffect.setImageSampler(i2, this.images[i2] != null ? i2 : -1);
        }
    }

    @Override
    protected void updateDrawingStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics) {
        ++drawablePerformanceMetrics.drawnImages;
    }

    @Override
    protected MeshHeap$SubMesh updateMesh(Texture[] textureArray, List list) {
        long l;
        if (this.getDestinationWidth() <= 0 || this.getDestinationHeight() <= 0) {
            return null;
        }
        Logger logger = this.getLogger();
        CompositeImageDrawableRenderer compositeImageDrawableRenderer = (CompositeImageDrawableRenderer)this.getDrawableRenderer();
        int n = this.images[0].getWidth();
        int n2 = this.images[0].getHeight();
        int n3 = 0;
        while (++n3 < this.images.length && this.images[n3] != null && n == this.images[n3].getWidth() && n2 == this.images[n3].getHeight()) {
        }
        TextureAtlas textureAtlas = compositeImageDrawableRenderer.getTextureAtlas();
        boolean bl = this.hasFiltering();
        TextureAtlas$SubTexture[] textureAtlas$SubTextureArray = new TextureAtlas$SubTexture[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            textureAtlas$SubTextureArray[i2] = textureAtlas.getSubTexture(this.images[i2], bl);
        }
        MeshHeap meshHeap = compositeImageDrawableRenderer.getMeshHeap();
        MeshHeap$SubMesh meshHeap$SubMesh = meshHeap.getSubMesh(l = CompositeImageDrawableRenderer$SharedCompositeImageDrawable.calculateMeshKey(textureAtlas$SubTextureArray, this.getSourceX(), this.getSourceY(), this.getSourceWidth(), this.getSourceHeight(), this.getDestinationX(), this.getDestinationY(), this.getDestinationWidth(), this.getDestinationHeight(), null));
        if (meshHeap$SubMesh == null) {
            int n4;
            MeshBuilder meshBuilder = compositeImageDrawableRenderer.getMeshBuilder();
            Texture[] textureArray2 = new Texture[n3];
            Dimension[] dimensionArray = new Dimension[n3];
            Rectangle[] rectangleArray = new Rectangle[n3];
            for (n4 = 0; n4 < textureAtlas$SubTextureArray.length; ++n4) {
                textureArray2[n4] = textureAtlas$SubTextureArray[n4].getTexture();
                dimensionArray[n4] = textureArray2[n4].getSize();
                rectangleArray[n4] = textureAtlas$SubTextureArray[n4].getRectangle();
            }
            if (this.getSourceWidth() > n) {
                LogMessage logMessage = logger.warn(512);
                logMessage.append(super.getClass().getName());
                logMessage.append(".update() image ").append(this.images).append(": sourceWidth ").append(this.getSourceWidth());
                logMessage.append(" > imageWidth ").append(n).append(" - clamping to imageWidth").log();
                this.setSourceWidth(n);
            }
            if (this.getSourceHeight() > n2) {
                LogMessage logMessage = logger.warn(512);
                logMessage.append(super.getClass().getName());
                logMessage.append(".update() image ").append(this.images).append(": sourceHeight ").append(this.getSourceHeight());
                logMessage.append(" > imageHeight ").append(n2).append(" - clamping to imageHeight").log();
                this.setSourceHeight(n2);
            }
            meshBuilder.beginGeometry(6, 0);
            n4 = this.getDestinationX();
            int n5 = this.getDestinationY();
            int n6 = n4 + this.getDestinationWidth();
            int n7 = n5 + this.getDestinationHeight();
            float[] fArray = new float[n3];
            float[] fArray2 = new float[n3];
            float[] fArray3 = new float[n3];
            float[] fArray4 = new float[n3];
            for (int i3 = 0; i3 < n3; ++i3) {
                fArray[i3] = ((float)(rectangleArray[i3].x + this.getSourceX()) + AbstractSharedDrawableRenderer.TEXEL_CENTER_OFFSET) / (float)dimensionArray[i3].width;
                fArray2[i3] = ((float)(rectangleArray[i3].y + this.getSourceY()) + AbstractSharedDrawableRenderer.TEXEL_CENTER_OFFSET) / (float)dimensionArray[i3].height;
                fArray3[i3] = ((float)(rectangleArray[i3].x + this.getSourceX() + this.getSourceWidth()) - AbstractSharedDrawableRenderer.TEXEL_CENTER_OFFSET) / (float)dimensionArray[i3].width;
                fArray4[i3] = ((float)(rectangleArray[i3].y + this.getSourceY() + this.getSourceHeight()) - AbstractSharedDrawableRenderer.TEXEL_CENTER_OFFSET) / (float)dimensionArray[i3].height;
            }
            float f2 = (float)this.getSourceX() / (float)rectangleArray[0].width;
            float f3 = (float)this.getSourceY() / (float)rectangleArray[0].height;
            float f4 = (float)(this.getSourceX() + this.getSourceWidth()) / (float)rectangleArray[0].width;
            float f5 = (float)(this.getSourceY() + this.getSourceHeight()) / (float)rectangleArray[0].height;
            meshBuilder.beginVertex();
            meshBuilder.setVertexPosition(n4, n5);
            meshBuilder.setVertexTextureCoordinate(0, fArray[0], fArray2[0]);
            if (this.enableGenericTexcoords) {
                meshBuilder.setVertexTextureCoordinate(1, f2, f3);
            } else if (n3 > 1) {
                meshBuilder.setVertexTextureCoordinate(1, fArray[1], fArray2[1]);
            }
            meshBuilder.endVertex();
            meshBuilder.beginVertex();
            meshBuilder.setVertexPosition(n4, n7);
            meshBuilder.setVertexTextureCoordinate(0, fArray[0], fArray4[0]);
            if (this.enableGenericTexcoords) {
                meshBuilder.setVertexTextureCoordinate(1, f2, f5);
            } else if (n3 > 1) {
                meshBuilder.setVertexTextureCoordinate(1, fArray[1], fArray4[1]);
            }
            meshBuilder.endVertex();
            meshBuilder.beginVertex();
            meshBuilder.setVertexPosition(n6, n7);
            meshBuilder.setVertexTextureCoordinate(0, fArray3[0], fArray4[0]);
            if (this.enableGenericTexcoords) {
                meshBuilder.setVertexTextureCoordinate(1, f4, f5);
            } else if (n3 > 1) {
                meshBuilder.setVertexTextureCoordinate(1, fArray3[1], fArray4[1]);
            }
            meshBuilder.endVertex();
            meshBuilder.beginVertex();
            meshBuilder.setVertexPosition(n6, n5);
            meshBuilder.setVertexTextureCoordinate(0, fArray3[0], fArray2[0]);
            if (this.enableGenericTexcoords) {
                meshBuilder.setVertexTextureCoordinate(1, f4, f3);
            } else if (n3 > 1) {
                meshBuilder.setVertexTextureCoordinate(1, fArray3[1], fArray2[1]);
            }
            meshBuilder.endVertex();
            meshBuilder.endGeometry();
            n4 = meshBuilder.getVertexCount();
            meshHeap$SubMesh = meshHeap.insertSubMesh(l, 6, n4);
            meshHeap$SubMesh.setVertexData(meshBuilder.getVertexArray());
        }
        for (int i4 = 0; i4 < n3; ++i4) {
            textureArray[i4] = textureAtlas$SubTextureArray[i4].getTexture();
            list.add(textureAtlas$SubTextureArray[i4]);
        }
        return meshHeap$SubMesh;
    }

    protected static final long calculateMeshKey(TextureAtlas$SubTexture[] textureAtlas$SubTextureArray, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, ScaleImage scaleImage) {
        hcb.reset();
        for (int i2 = 0; i2 < textureAtlas$SubTextureArray.length; ++i2) {
            hcb.append(textureAtlas$SubTextureArray[i2].getId());
        }
        hcb.append(n);
        hcb.append(n2);
        hcb.append(n3);
        hcb.append(n4);
        hcb.append(n5);
        hcb.append(n6);
        hcb.append(n7);
        hcb.append(n8);
        hcb.append(scaleImage);
        return hcb.longHashCode();
    }
}

