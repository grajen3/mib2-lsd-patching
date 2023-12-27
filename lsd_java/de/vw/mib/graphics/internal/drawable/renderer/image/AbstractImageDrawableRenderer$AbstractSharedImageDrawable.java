/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.image;

import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.image.ImageBaseDrawable;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.effect.image.ImageEffect;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer$AbstractSharedDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.image.AbstractImageDrawableRenderer;
import de.vw.mib.graphics.internal.mesh.MeshBuilder;
import de.vw.mib.graphics.internal.mesh.MeshHeap;
import de.vw.mib.graphics.internal.mesh.MeshHeap$SubMesh;
import de.vw.mib.graphics.internal.texture.TextureAtlas$SubTexture;
import de.vw.mib.graphics.texture.Texture;
import de.vw.mib.graphics.texture.Texture2D;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.util.StringBuilder;
import java.util.List;

public abstract class AbstractImageDrawableRenderer$AbstractSharedImageDrawable
extends AbstractSharedDrawableRenderer$AbstractSharedDrawable
implements ImageBaseDrawable {
    protected static final int IMAGE_TEXTURE_SAMPLER;
    private static final int DEFAULT_IMAGE_FILTER;
    private BufferImage image;
    private int imageFilter = 0;
    private int sourceX;
    private int sourceY;
    private int sourceWidth;
    private int sourceHeight;
    private int destX;
    private int destY;
    private int destWidth;
    private int destHeight;

    public AbstractImageDrawableRenderer$AbstractSharedImageDrawable(AbstractSharedDrawableRenderer abstractSharedDrawableRenderer, ObjectPool objectPool) {
        super(abstractSharedDrawableRenderer, objectPool);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",image=").append(this.image);
        stringBuilder.append(",imageFilterMode=").append(this.imageFilter);
        stringBuilder.append(",sourceX=").append(this.sourceX);
        stringBuilder.append(",sourceY=").append(this.sourceY);
        stringBuilder.append(",sourceWidth=").append(this.sourceWidth);
        stringBuilder.append(",sourceHeight=").append(this.sourceHeight);
        stringBuilder.append(",destX=").append(this.destX);
        stringBuilder.append(",destY=").append(this.destY);
        stringBuilder.append(",destWidth=").append(this.destWidth);
        stringBuilder.append(",destHeight=").append(this.destHeight);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        if (this.image != null) {
            this.image.dispose();
            this.image = null;
        }
        this.imageFilter = 0;
        this.sourceX = 0;
        this.sourceY = 0;
        this.sourceWidth = 0;
        this.sourceHeight = 0;
        this.destX = 0;
        this.destY = 0;
        this.destWidth = 0;
        this.destHeight = 0;
        super.dispose();
    }

    @Override
    protected abstract Effect createEffect(Graphics3D graphics3D) {
    }

    @Override
    public BufferImage getImage() {
        return this.image;
    }

    @Override
    public void setImage(BufferImage bufferImage) {
        if (this.image == null || !this.image.equals(bufferImage)) {
            if (this.image != null) {
                this.image.dispose();
            }
            bufferImage.reference();
            this.image = bufferImage;
            this.invalidateGeometry();
        }
    }

    @Override
    public final int getImageFilter() {
        return this.imageFilter;
    }

    @Override
    public final void setImageFilter(int n) {
        this.imageFilter = n;
    }

    protected final boolean hasFiltering() {
        switch (this.imageFilter) {
            case 0: {
                return false;
            }
            case 1: {
                return true;
            }
        }
        throw new IllegalArgumentException("Invalid image filter mode");
    }

    public final int getSourceX() {
        return this.sourceX;
    }

    public final void setSourceX(int n) {
        if (this.sourceX != n) {
            this.sourceX = n;
            this.invalidateGeometry();
        }
    }

    public final int getSourceY() {
        return this.sourceY;
    }

    public final void setSourceY(int n) {
        if (this.sourceY != n) {
            this.sourceY = n;
            this.invalidateGeometry();
        }
    }

    public final int getSourceWidth() {
        return this.sourceWidth;
    }

    public final void setSourceWidth(int n) {
        if (this.sourceWidth != n) {
            this.sourceWidth = n;
            this.invalidateGeometry();
        }
    }

    public final int getSourceHeight() {
        return this.sourceHeight;
    }

    public final void setSourceHeight(int n) {
        if (this.sourceHeight != n) {
            this.sourceHeight = n;
            this.invalidateGeometry();
        }
    }

    public final int getDestinationX() {
        return this.destX;
    }

    public final void setDestinationX(int n) {
        if (this.destX != n) {
            this.destX = n;
            this.invalidateGeometry();
        }
    }

    public final int getDestinationY() {
        return this.destY;
    }

    public final void setDestinationY(int n) {
        if (this.destY != n) {
            this.destY = n;
            this.invalidateGeometry();
        }
    }

    public final int getDestinationWidth() {
        return this.destWidth;
    }

    public final void setDestinationWidth(int n) {
        if (this.destWidth != n) {
            this.destWidth = n;
            this.invalidateGeometry();
        }
    }

    public final int getDestinationHeight() {
        return this.destHeight;
    }

    public final void setDestinationHeight(int n) {
        if (this.destHeight != n) {
            this.destHeight = n;
            this.invalidateGeometry();
        }
    }

    @Override
    protected void updateTexture(int n, Texture texture) {
        super.updateTexture(n, texture);
        int n2 = AbstractImageDrawableRenderer$AbstractSharedImageDrawable.mapFilter(this.imageFilter);
        texture.setFilter(n2, n2, 0);
    }

    private static int mapFilter(int n) {
        switch (n) {
            case 0: {
                return 1;
            }
            case 1: {
                return 2;
            }
        }
        throw new IllegalArgumentException("Invalid image filter mode");
    }

    @Override
    protected void updateEffect(Effect effect) {
        ImageEffect imageEffect = (ImageEffect)effect;
        this.updateTransformationEffect(imageEffect);
        this.updateColorEffect(imageEffect);
        this.updateImageEffect(imageEffect);
    }

    protected final void updateImageEffect(ImageEffect imageEffect) {
        imageEffect.setImageSampler(0);
    }

    @Override
    protected abstract void updateDrawingStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics) {
    }

    @Override
    protected MeshHeap$SubMesh updateMesh(Texture[] textureArray, List list) {
        long l;
        if (this.destWidth <= 0 || this.destHeight <= 0) {
            return null;
        }
        Logger logger = this.getLogger();
        AbstractImageDrawableRenderer abstractImageDrawableRenderer = (AbstractImageDrawableRenderer)this.getDrawableRenderer();
        TextureAtlas$SubTexture textureAtlas$SubTexture = abstractImageDrawableRenderer.getTextureAtlas().getSubTexture(this.image, this.hasFiltering());
        MeshHeap meshHeap = abstractImageDrawableRenderer.getMeshHeap();
        MeshHeap$SubMesh meshHeap$SubMesh = meshHeap.getSubMesh(l = AbstractImageDrawableRenderer$AbstractSharedImageDrawable.calculateMeshKey(textureAtlas$SubTexture, this.sourceX, this.sourceY, this.sourceWidth, this.sourceHeight, this.destX, this.destY, this.destWidth, this.destHeight));
        if (meshHeap$SubMesh == null) {
            MeshBuilder meshBuilder = abstractImageDrawableRenderer.getMeshBuilder();
            Texture2D texture2D = textureAtlas$SubTexture.getTexture();
            Dimension dimension = texture2D.getSize();
            Rectangle rectangle = textureAtlas$SubTexture.getRectangle();
            meshBuilder.beginGeometry(6, 0);
            int n = this.destX;
            int n2 = this.destY;
            int n3 = n + this.destWidth;
            int n4 = n2 + this.destHeight;
            float f2 = ((float)(rectangle.x + this.sourceX) + AbstractSharedDrawableRenderer.TEXEL_CENTER_OFFSET) / (float)dimension.width;
            float f3 = ((float)(rectangle.y + this.sourceY) + AbstractSharedDrawableRenderer.TEXEL_CENTER_OFFSET) / (float)dimension.height;
            float f4 = ((float)(rectangle.x + this.sourceX + this.sourceWidth) - AbstractSharedDrawableRenderer.TEXEL_CENTER_OFFSET) / (float)dimension.width;
            float f5 = ((float)(rectangle.y + this.sourceY + this.sourceHeight) - AbstractSharedDrawableRenderer.TEXEL_CENTER_OFFSET) / (float)dimension.height;
            meshBuilder.beginVertex();
            meshBuilder.setVertexPosition(n, n2);
            meshBuilder.setVertexTextureCoordinate(0, f2, f3);
            meshBuilder.endVertex();
            meshBuilder.beginVertex();
            meshBuilder.setVertexPosition(n, n4);
            meshBuilder.setVertexTextureCoordinate(0, f2, f5);
            meshBuilder.endVertex();
            meshBuilder.beginVertex();
            meshBuilder.setVertexPosition(n3, n4);
            meshBuilder.setVertexTextureCoordinate(0, f4, f5);
            meshBuilder.endVertex();
            meshBuilder.beginVertex();
            meshBuilder.setVertexPosition(n3, n2);
            meshBuilder.setVertexTextureCoordinate(0, f4, f3);
            meshBuilder.endVertex();
            meshBuilder.endGeometry();
            n = meshBuilder.getVertexCount();
            meshHeap$SubMesh = meshHeap.insertSubMesh(l, 6, n);
            meshHeap$SubMesh.setVertexData(meshBuilder.getVertexArray());
        }
        if (textureAtlas$SubTexture != null) {
            textureArray[0] = textureAtlas$SubTexture.getTexture();
            list.add(textureAtlas$SubTexture);
        }
        return meshHeap$SubMesh;
    }

    protected static final long calculateMeshKey(TextureAtlas$SubTexture textureAtlas$SubTexture, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        hcb.reset();
        hcb.append(textureAtlas$SubTexture.getId());
        hcb.append(n);
        hcb.append(n2);
        hcb.append(n3);
        hcb.append(n4);
        hcb.append(n5);
        hcb.append(n6);
        hcb.append(n7);
        hcb.append(n8);
        return hcb.longHashCode();
    }
}

