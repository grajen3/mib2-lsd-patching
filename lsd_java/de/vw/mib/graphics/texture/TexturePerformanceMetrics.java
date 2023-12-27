/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.texture;

import de.vw.mib.graphics.performance.PerformanceMetrics;
import de.vw.mib.util.StringBuilder;

public final class TexturePerformanceMetrics
implements PerformanceMetrics {
    public int allocatedTextures2D;
    public int allocatedTextures2DSizeBytes;
    public int allocatedTextures3D;
    public int allocatedTextures3DSizeBytes;
    public int allocatedCubeMapTextures;
    public int allocatedCubeMapTexturesSizeBytes;
    public int allocatedPBufferTextures;
    public int allocatedPBufferTexturesSizeBytes;
    public int allocatedFrameBufferMapTextures;
    public int allocatedFrameBufferTexturesSizeBytes;
    public int textureBinds;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[allocatedTextures2D=").append(this.allocatedTextures2D);
        stringBuilder.append(",allocatedTextures2DSizeBytes=").append(this.allocatedTextures2DSizeBytes);
        stringBuilder.append(",allocatedTextures3D=").append(this.allocatedTextures3D);
        stringBuilder.append(",allocatedTextures3DSizeBytes=").append(this.allocatedTextures3DSizeBytes);
        stringBuilder.append(",allocatedCubeMapTextures=").append(this.allocatedCubeMapTextures);
        stringBuilder.append(",allocatedCubeMapTexturesSizeBytes=").append(this.allocatedCubeMapTexturesSizeBytes);
        stringBuilder.append(",allocatedPBufferTextures=").append(this.allocatedPBufferTextures);
        stringBuilder.append(",allocatedPBufferTexturesSizeBytes=").append(this.allocatedPBufferTexturesSizeBytes);
        stringBuilder.append(",allocatedFrameBufferMapTextures=").append(this.allocatedFrameBufferMapTextures);
        stringBuilder.append(",allocatedFrameBufferTexturesSizeBytes=").append(this.allocatedFrameBufferTexturesSizeBytes);
        stringBuilder.append(",textureBinds=").append(this.textureBinds);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void clear() {
        this.textureBinds = 0;
    }
}

