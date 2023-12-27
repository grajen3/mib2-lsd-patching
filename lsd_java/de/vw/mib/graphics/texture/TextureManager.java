/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.texture;

import de.vw.mib.graphics.ResourceManager;
import de.vw.mib.graphics.framebuffer.FrameBufferTexture;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.performance.CachePerformanceMetrics;
import de.vw.mib.graphics.surface.PBufferSurface;
import de.vw.mib.graphics.texture.PBufferTexture;
import de.vw.mib.graphics.texture.Texture2D;
import de.vw.mib.graphics.texture.TextureCubeMap;
import de.vw.mib.graphics.texture.TexturePerformanceMetrics;

public interface TextureManager
extends ResourceManager {
    default public TexturePerformanceMetrics getPerformanceMetrics() {
    }

    default public CachePerformanceMetrics getTextureCacheUsage() {
    }

    default public int getMaxVertexTextureUnits() {
    }

    default public int getMaxFragmentTextureUnits() {
    }

    default public int getMaxCombinedTextureUnits() {
    }

    default public int getMaxTextureUnits() {
    }

    default public int getMaxTextureSize() {
    }

    default public int[] getCompressedTextureFormats() {
    }

    default public boolean isCompressedTextureFormatSupported(int n) {
    }

    default public PBufferTexture createPBufferTexture(PBufferSurface pBufferSurface) {
    }

    default public FrameBufferTexture createFrameBufferTexture(int n, int n2, int n3) {
    }

    default public Texture2D createTexture2D(int n, int n2, int n3, int n4) {
    }

    default public Texture2D getTexture2D(BufferImage bufferImage) {
    }

    default public int getMaxCubeMapTextureSize() {
    }

    default public TextureCubeMap createCubeMapTexture(int n, int n2, int n3) {
    }

    default public TextureCubeMap getCubeMapTexture(BufferImage[] bufferImageArray) {
    }
}

