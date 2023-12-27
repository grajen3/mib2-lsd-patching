/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.texture;

import de.vw.mib.cache.Cacheable;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Resource;

public interface Texture
extends Resource,
Cacheable {
    public static final int TEXTURE_TYPE_2D;
    public static final int TEXTURE_TYPE_3D;
    public static final int TEXTURE_TYPE_CUBE_MAP;
    public static final int TEXTURE_TYPE_PBUFFER;
    public static final int TEXTURE_TYPE_FRAMEBUFFER;
    public static final int TEXTURE_TYPE_COUNT;
    public static final int TEXTURE_WRAP_REPEAT;
    public static final int TEXTURE_WRAP_CLAMP_TO_EDGE;
    public static final int TEXTURE_WRAP_MIRRORED_REPEAT;
    public static final int TEXTURE_FILTER_NONE;
    public static final int TEXTURE_FILTER_NEAREST;
    public static final int TEXTURE_FILTER_LINEAR;
    public static final int TEXTURE_ADDRESS_GENERATION_MODE_REFLECTION_MAP;
    public static final int TEXTURE_ADDRESS_GENERATION_MODE_NORMAL_MAP;

    default public int getType() {
    }

    default public int getTextureFormat() {
    }

    default public boolean isCompressed() {
    }

    default public Dimension getSize() {
    }

    default public Dimension getSizePowerTwo() {
    }

    default public float getPowerTwoScaleFactorX() {
    }

    default public float getPowerTwoScaleFactorY() {
    }

    default public boolean isScaledToPowerTwo() {
    }

    default public int getLevels() {
    }

    default public boolean hasMipMaps() {
    }

    default public void generateMipMaps() {
    }

    default public boolean isReadable() {
    }

    default public int getMinFilter() {
    }

    default public int getMagFilter() {
    }

    default public int getMipFilter() {
    }

    default public void setFilter(int n, int n2, int n3) {
    }

    default public int getWrapS() {
    }

    default public void setWrapS(int n) {
    }

    default public int getWrapT() {
    }

    default public void setWrapT(int n) {
    }

    default public void setWrap(int n, int n2) {
    }
}

