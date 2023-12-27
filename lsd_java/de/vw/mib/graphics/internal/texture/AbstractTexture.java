/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.texture;

import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.internal.AbstractResource;
import de.vw.mib.graphics.texture.Texture;
import de.vw.mib.graphics.texture.TextureFormat;
import de.vw.mib.graphics.texture.TextureManager;
import de.vw.mib.graphics.texture.TexturePerformanceMetrics;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;

public abstract class AbstractTexture
extends AbstractResource
implements Texture {
    private final TextureManager textureManager;
    private final int type;
    private final int textureFormat;
    private final boolean compressed;
    private final Dimension size;
    private final Dimension sizePowerTwo;
    private final float powerToScaleFactorX;
    private final float powerToScaleFactorY;
    private final int levels;
    private int minFilter;
    private int magFilter;
    private int mipFilter;
    private int wrapS;
    private int wrapT;

    public AbstractTexture(Graphics3D graphics3D, Logger logger, TextureManager textureManager, int n, int n2, boolean bl, Dimension dimension, Dimension dimension2, int n3) {
        super(graphics3D, logger);
        this.textureManager = textureManager;
        this.type = n;
        this.textureFormat = n2;
        this.compressed = bl;
        this.size = dimension;
        this.sizePowerTwo = dimension2;
        this.powerToScaleFactorX = (float)dimension.width / (float)dimension2.width;
        this.powerToScaleFactorY = (float)dimension.height / (float)dimension2.height;
        this.levels = n3;
        this.minFilter = 1;
        this.magFilter = 1;
        this.mipFilter = 0;
        this.wrapS = 0;
        this.wrapT = 0;
        this.updateAllocationStatistics(textureManager.getPerformanceMetrics(), true);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append(",textureFormat=0x").append(Integer.toHexString(this.textureFormat));
        stringBuilder.append(",size=").append(this.size);
        stringBuilder.append(",sizePowerTwo=").append(this.sizePowerTwo);
        stringBuilder.append("[powerToScaleFactorX=").append(this.powerToScaleFactorX);
        stringBuilder.append(",powerToScaleFactorY=").append(this.powerToScaleFactorY);
        stringBuilder.append(",levels=").append(this.levels);
        stringBuilder.append(",minFilter=").append(this.minFilter);
        stringBuilder.append(",magFilter=").append(this.magFilter);
        stringBuilder.append(",mipFilter=").append(this.mipFilter);
        stringBuilder.append(",wrapS=").append(this.wrapS);
        stringBuilder.append(",wrapT=").append(this.wrapT);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        this.updateAllocationStatistics(this.textureManager.getPerformanceMetrics(), false);
        super.dispose();
    }

    protected final void updateAllocationStatistics(TexturePerformanceMetrics texturePerformanceMetrics, boolean bl) {
        int n = this.getByteSize();
        switch (this.type) {
            case 0: {
                texturePerformanceMetrics.allocatedTextures2D = texturePerformanceMetrics.allocatedTextures2D + (bl ? 1 : -1);
                texturePerformanceMetrics.allocatedTextures2DSizeBytes = texturePerformanceMetrics.allocatedTextures2DSizeBytes + (bl ? n : -n);
                break;
            }
            case 1: {
                texturePerformanceMetrics.allocatedTextures3D = texturePerformanceMetrics.allocatedTextures3D + (bl ? 1 : -1);
                texturePerformanceMetrics.allocatedTextures3DSizeBytes = texturePerformanceMetrics.allocatedTextures3DSizeBytes + (bl ? n : -n);
                break;
            }
            case 2: {
                texturePerformanceMetrics.allocatedCubeMapTextures = texturePerformanceMetrics.allocatedCubeMapTextures + (bl ? 1 : -1);
                texturePerformanceMetrics.allocatedCubeMapTexturesSizeBytes = texturePerformanceMetrics.allocatedCubeMapTexturesSizeBytes + (bl ? n : -n);
                break;
            }
            case 3: {
                texturePerformanceMetrics.allocatedPBufferTextures = texturePerformanceMetrics.allocatedPBufferTextures + (bl ? 1 : -1);
                texturePerformanceMetrics.allocatedPBufferTexturesSizeBytes = texturePerformanceMetrics.allocatedPBufferTexturesSizeBytes + (bl ? n : -n);
                break;
            }
            case 4: {
                texturePerformanceMetrics.allocatedFrameBufferMapTextures = texturePerformanceMetrics.allocatedFrameBufferMapTextures + (bl ? 1 : -1);
                texturePerformanceMetrics.allocatedFrameBufferTexturesSizeBytes = texturePerformanceMetrics.allocatedFrameBufferTexturesSizeBytes + (bl ? n : -n);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid texture type");
            }
        }
    }

    @Override
    public int getByteSize() {
        int n = TextureFormat.getTextureSize(this.textureFormat, this.getSizePowerTwo().width, this.getSizePowerTwo().height);
        return n * this.getLevels();
    }

    protected final TextureManager getTextureManager() {
        return this.textureManager;
    }

    @Override
    public final int getType() {
        return this.type;
    }

    @Override
    public final int getTextureFormat() {
        return this.textureFormat;
    }

    @Override
    public final boolean isCompressed() {
        return this.compressed;
    }

    @Override
    public final Dimension getSize() {
        return this.size;
    }

    @Override
    public final Dimension getSizePowerTwo() {
        return this.sizePowerTwo;
    }

    @Override
    public final float getPowerTwoScaleFactorX() {
        return this.powerToScaleFactorX;
    }

    @Override
    public final float getPowerTwoScaleFactorY() {
        return this.powerToScaleFactorY;
    }

    @Override
    public final boolean isScaledToPowerTwo() {
        return this.powerToScaleFactorX != 1.0f || this.powerToScaleFactorY != 1.0f;
    }

    @Override
    public final int getLevels() {
        return this.levels;
    }

    @Override
    public final boolean hasMipMaps() {
        return this.levels > 1;
    }

    @Override
    public abstract void generateMipMaps() {
    }

    @Override
    public abstract boolean isReadable() {
    }

    @Override
    public final int getMinFilter() {
        return this.minFilter;
    }

    @Override
    public final int getMagFilter() {
        return this.magFilter;
    }

    @Override
    public final int getMipFilter() {
        return this.mipFilter;
    }

    @Override
    public final void setFilter(int n, int n2, int n3) {
        if (this.minFilter != n || this.magFilter != n2 || this.mipFilter != n3) {
            this.minFilter = n;
            this.magFilter = n2;
            this.mipFilter = n3;
            this.filteringChanged();
        }
    }

    protected void filteringChanged() {
    }

    @Override
    public final int getWrapS() {
        return this.wrapS;
    }

    @Override
    public final void setWrapS(int n) {
        if (this.wrapS != n) {
            this.wrapS = n;
            this.wrappingChanged();
        }
    }

    @Override
    public final int getWrapT() {
        return this.wrapT;
    }

    @Override
    public final void setWrapT(int n) {
        if (this.wrapT != n) {
            this.wrapT = n;
            this.wrappingChanged();
        }
    }

    @Override
    public final void setWrap(int n, int n2) {
        if (this.wrapS != n || this.wrapT != n2) {
            this.wrapS = n;
            this.wrapT = n2;
            this.filteringChanged();
        }
    }

    protected void wrappingChanged() {
    }

    protected final void bind() {
        Graphics3D graphics3D = this.getGraphics3D();
        if (graphics3D.arePerformanceMetricsEnabled()) {
            TexturePerformanceMetrics texturePerformanceMetrics = this.getTextureManager().getPerformanceMetrics();
            ++texturePerformanceMetrics.textureBinds;
        }
    }
}

