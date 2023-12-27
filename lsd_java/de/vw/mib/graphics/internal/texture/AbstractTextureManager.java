/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.texture;

import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.GraphicsListener;
import de.vw.mib.graphics.framebuffer.FrameBufferTexture;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.internal.AbstractResource;
import de.vw.mib.graphics.internal.texture.AbstractTextureManager$TextureCacheListener;
import de.vw.mib.graphics.internal.texture.TextureCache;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.performance.CachePerformanceMetrics;
import de.vw.mib.graphics.surface.PBufferSurface;
import de.vw.mib.graphics.texture.PBufferTexture;
import de.vw.mib.graphics.texture.Texture2D;
import de.vw.mib.graphics.texture.TextureCubeMap;
import de.vw.mib.graphics.texture.TextureFormat;
import de.vw.mib.graphics.texture.TextureManager;
import de.vw.mib.graphics.texture.TexturePerformanceMetrics;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractTextureManager
extends AbstractResource
implements TextureManager,
GraphicsListener {
    private final TexturePerformanceMetrics performanceMetrics = new TexturePerformanceMetrics();
    private final TextureCache textureCache = new TextureCache();

    public AbstractTextureManager(Graphics3D graphics3D, Logger logger) {
        super(graphics3D, logger);
        this.textureCache.addCacheListener(new AbstractTextureManager$TextureCacheListener());
        graphics3D.addListener(this);
    }

    @Override
    public void dispose() {
        Graphics3D graphics3D = this.getGraphics3D();
        graphics3D.removeListener(this);
        super.dispose();
    }

    @Override
    public final TexturePerformanceMetrics getPerformanceMetrics() {
        return this.performanceMetrics;
    }

    @Override
    public final CachePerformanceMetrics getTextureCacheUsage() {
        return new CachePerformanceMetrics(this.textureCache.size(), this.textureCache.getByteSize(), this.textureCache.getMaximumCacheSizeBytes(), this.textureCache.hits(), this.textureCache.misses());
    }

    @Override
    public abstract int getMaxTextureUnits() {
    }

    @Override
    public abstract int getMaxVertexTextureUnits() {
    }

    @Override
    public abstract int getMaxFragmentTextureUnits() {
    }

    @Override
    public abstract int getMaxCombinedTextureUnits() {
    }

    @Override
    public abstract int getMaxTextureSize() {
    }

    @Override
    public abstract int[] getCompressedTextureFormats() {
    }

    @Override
    public boolean isCompressedTextureFormatSupported(int n) {
        int[] nArray = this.getCompressedTextureFormats();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] != n) continue;
            return true;
        }
        return false;
    }

    @Override
    public abstract PBufferTexture createPBufferTexture(PBufferSurface pBufferSurface) {
    }

    @Override
    public abstract FrameBufferTexture createFrameBufferTexture(int n, int n2, int n3) {
    }

    @Override
    public final Texture2D createTexture2D(int n, int n2, int n3, int n4) {
        Dimension dimension;
        int n5 = this.getMaxTextureSize();
        if (n2 > n5 || n3 > n5) {
            throw new IllegalArgumentException(new StringBuffer().append("Image dimensions of ").append(n2).append(",").append(n3).append(" exceeds the maximum supported texture-size: ").append(n5).toString());
        }
        Dimension dimension2 = dimension = new Dimension(n2, n3);
        if (this.isTextureSizePowerOfTwoRequired()) {
            int n6 = Util.nextPowerOfTwo(n2);
            int n7 = Util.nextPowerOfTwo(n3);
            if (n6 != n2 || n7 != n3) {
                dimension2 = new Dimension(n6, n7);
            }
        }
        Texture2D texture2D = this.createTexture2D(n, TextureFormat.isCompressedFormat(n), dimension, dimension2, n4);
        return texture2D;
    }

    protected abstract boolean isTextureSizePowerOfTwoRequired() {
    }

    protected abstract Texture2D createTexture2D(int n, boolean bl, Dimension dimension, Dimension dimension2, int n2) {
    }

    @Override
    public final Texture2D getTexture2D(BufferImage bufferImage) {
        int n = bufferImage.getWidth();
        int n2 = bufferImage.getHeight();
        Texture2D texture2D = (Texture2D)this.textureCache.get(new BufferImage[]{bufferImage});
        if (texture2D == null) {
            int n3;
            Dimension dimension;
            int n4 = this.getMaxTextureSize();
            if (n > n4 || n2 > n4) {
                throw new IllegalArgumentException(new StringBuffer().append("Image dimensions of ").append(n).append(",").append(n2).append(" exceeds the maximum supported texture-size: ").append(n4).toString());
            }
            Dimension dimension2 = dimension = new Dimension(n, n2);
            if (this.isTextureSizePowerOfTwoRequired()) {
                n3 = Util.nextPowerOfTwo(n);
                int n5 = Util.nextPowerOfTwo(n2);
                if (n3 != n || n5 != n2) {
                    dimension2 = new Dimension(n3, n5);
                }
            }
            n3 = 1;
            texture2D = this.createTexture2D(bufferImage.getImageFormat(), TextureFormat.isCompressedFormat(bufferImage.getImageFormat()), dimension, dimension2, 1);
            texture2D.setContent(0, 0, 0, bufferImage);
            this.textureCache.put(new BufferImage[]{bufferImage}, texture2D);
        }
        return texture2D;
    }

    @Override
    public abstract int getMaxCubeMapTextureSize() {
    }

    @Override
    public TextureCubeMap createCubeMapTexture(int n, int n2, int n3) {
        return this.createCubeMapTexture(n, TextureFormat.isCompressedFormat(n), n2, n3);
    }

    protected abstract TextureCubeMap createCubeMapTexture(int n, boolean bl, int n2, int n3) {
    }

    @Override
    public final TextureCubeMap getCubeMapTexture(BufferImage[] bufferImageArray) {
        TextureCubeMap textureCubeMap = (TextureCubeMap)this.textureCache.get(bufferImageArray);
        if (textureCubeMap == null) {
            int n;
            int n2 = 0;
            for (n = 0; n <= 5; ++n) {
                BufferImage bufferImage = bufferImageArray[n];
                if (n == 0) {
                    n2 = bufferImage.getWidth();
                    if (n2 > this.getMaxCubeMapTextureSize()) {
                        throw new IllegalArgumentException("CubeMap face image dimension exceeds supported size");
                    }
                } else if (bufferImage.getWidth() != n2) {
                    throw new IllegalArgumentException("CubeMap face image dimensions not identical");
                }
                if (bufferImage.getWidth() != bufferImage.getHeight()) {
                    throw new IllegalArgumentException("CubeMap face image dimension not square");
                }
                if (Util.isPowerOfTwo(bufferImage.getWidth())) continue;
                throw new IllegalArgumentException("CubeMap face image dimension not power of two");
            }
            n = 1;
            textureCubeMap = this.createCubeMapTexture(bufferImageArray[0].getImageFormat(), n2, 1);
            for (int i2 = 0; i2 <= 5; ++i2) {
                textureCubeMap.setContent(i2, 0, bufferImageArray[i2]);
            }
            this.textureCache.put(bufferImageArray, textureCubeMap);
        }
        return textureCubeMap;
    }

    @Override
    public final void beginFrame(Graphics3D graphics3D) {
    }

    @Override
    public final void endFrame(Graphics3D graphics3D) {
    }

    @Override
    public final void performanceMetricsEnabledChanged(Graphics3D graphics3D, boolean bl) {
        if (bl) {
            this.performanceMetrics.clear();
        }
    }
}

