/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.texture;

import de.vw.mib.util.StringBuilder;

public final class TextureFormat {
    public static final int FORMAT_ALPHA8;
    public static final int FORMAT_LUMINANCE8;
    public static final int FORMAT_LUMINANCE8_ALPHA8;
    public static final int FORMAT_RGB565;
    public static final int FORMAT_RGBA5551;
    public static final int FORMAT_RGBA4;
    public static final int FORMAT_RGB8;
    public static final int FORMAT_RGBA8;
    public static final int FORMAT_COMPRESSED_S3TC_RGB_DXT1;
    public static final int FORMAT_COMPRESSED_S3TC_RGBA_DXT1;
    public static final int FORMAT_COMPRESSED_S3TC_RGBA_DXT3;
    public static final int FORMAT_COMPRESSED_S3TC_RGBA_DXT5;
    public static final int FORMAT_COMPRESSED_ETC_RGB8;
    public static final int FORMAT_COMPRESSED_PVRTC_RGB_4BPPV1;
    public static final int FORMAT_COMPRESSED_PVRTC_RGB_2BPPV1;
    public static final int FORMAT_COMPRESSED_PVRTC_RGBA_4BPPV1;
    public static final int FORMAT_COMPRESSED_PVRTC_RGBA_2BPPV1;
    public static final int FORMAT_COMPRESSED_3DC_RGB_X;
    public static final int FORMAT_COMPRESSED_3DC_RGB_XY;
    public static final int FORMAT_COMPRESSED_ATC_RGB;
    public static final int FORMAT_COMPRESSED_ATC_RGBA_EXPLICIT_ALPHA;
    public static final int FORMAT_COMPRESSED_ATC_RGBA_INTERPOLATED_ALPHA;
    public static final int FORMAT_COMPRESSED_ASTC_RGBA_4X4;
    public static final int FORMAT_COMPRESSED_ASTC_RGBA_5X4;
    public static final int FORMAT_COMPRESSED_ASTC_RGBA_5X5;
    public static final int FORMAT_COMPRESSED_ASTC_RGBA_6X5;
    public static final int FORMAT_COMPRESSED_ASTC_RGBA_6X6;
    public static final int FORMAT_COMPRESSED_ASTC_RGBA_8X5;
    public static final int FORMAT_COMPRESSED_ASTC_RGBA_8X6;
    public static final int FORMAT_COMPRESSED_ASTC_RGBA_8X8;
    public static final int FORMAT_COMPRESSED_ASTC_RGBA_10X5;
    public static final int FORMAT_COMPRESSED_ASTC_RGBA_10X6;
    public static final int FORMAT_COMPRESSED_ASTC_RGBA_10X8;
    public static final int FORMAT_COMPRESSED_ASTC_RGBA_10X10;
    public static final int FORMAT_COMPRESSED_ASTC_RGBA_12X10;
    public static final int FORMAT_COMPRESSED_ASTC_RGBA_12X12;
    public static final int FORMAT_COMPRESSED_ASTC_SRGB8_ALPHA8_4X4;
    public static final int FORMAT_COMPRESSED_ASTC_SRGB8_ALPHA8_5X4;
    public static final int FORMAT_COMPRESSED_ASTC_SRGB8_ALPHA8_5X5;
    public static final int FORMAT_COMPRESSED_ASTC_SRGB8_ALPHA8_6X5;
    public static final int FORMAT_COMPRESSED_ASTC_SRGB8_ALPHA8_6X6;
    public static final int FORMAT_COMPRESSED_ASTC_SRGB8_ALPHA8_8X5;
    public static final int FORMAT_COMPRESSED_ASTC_SRGB8_ALPHA8_8X6;
    public static final int FORMAT_COMPRESSED_ASTC_SRGB8_ALPHA8_8X8;
    public static final int FORMAT_COMPRESSED_ASTC_SRGB8_ALPHA8_10X5;
    public static final int FORMAT_COMPRESSED_ASTC_SRGB8_ALPHA8_10X6;
    public static final int FORMAT_COMPRESSED_ASTC_SRGB8_ALPHA8_10X8;
    public static final int FORMAT_COMPRESSED_ASTC_SRGB8_ALPHA8_10X10;
    public static final int FORMAT_COMPRESSED_ASTC_SRGB8_ALPHA8_12X10;
    public static final int FORMAT_COMPRESSED_ASTC_SRGB8_ALPHA8_12X12;
    public final int textureFormat;
    public final int width;
    public final int height;

    public TextureFormat(int n, int n2, int n3) {
        this.textureFormat = n;
        this.width = n2;
        this.height = n3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[textureFormat=0x").append(Integer.toHexString(this.textureFormat));
        stringBuilder.append(",width=").append(this.width);
        stringBuilder.append(",height=").append(this.height);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static int getTexelSize(int n) {
        switch (n) {
            case 4096: 
            case 4608: {
                return 1;
            }
            case 4097: 
            case 4352: 
            case 4353: 
            case 4354: {
                return 2;
            }
            case 4355: {
                return 3;
            }
            case 4356: {
                return 4;
            }
        }
        throw new IllegalArgumentException("Invalid texture format");
    }

    public static int getTextureSize(int n, int n2, int n3) {
        int n4 = n2 * n3;
        return TextureFormat.getTexelSize(n) * n4;
    }

    public static boolean isCompressedFormat(int n) {
        switch (n) {
            case 4096: 
            case 4097: 
            case 4352: 
            case 4353: 
            case 4354: 
            case 4355: 
            case 4356: 
            case 4608: {
                return false;
            }
            case 33776: 
            case 33777: 
            case 33778: 
            case 33779: 
            case 34798: 
            case 34809: 
            case 34810: 
            case 35840: 
            case 35841: 
            case 35842: 
            case 35843: 
            case 35986: 
            case 35997: 
            case 36196: 
            case 37808: 
            case 37809: 
            case 37810: 
            case 37811: 
            case 37812: 
            case 37813: 
            case 37814: 
            case 37815: 
            case 37816: 
            case 37819: 
            case 37820: 
            case 37821: 
            case 37840: 
            case 37841: 
            case 37842: 
            case 37843: 
            case 37844: 
            case 37845: 
            case 37846: 
            case 37847: 
            case 37848: 
            case 37849: 
            case 37850: 
            case 37851: 
            case 37852: 
            case 37853: 
            case 605033: 
            case 605034: {
                return true;
            }
        }
        throw new IllegalArgumentException("Invalid texture format");
    }
}

