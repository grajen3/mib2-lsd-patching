/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image;

public final class ImageFormat {
    public static final int FORMAT_GRAYSCALE8;
    public static final int FORMAT_GRAYSCALE8_ALPHA8;
    public static final int FORMAT_GRAYSCALE16;
    public static final int FORMAT_RGB565;
    public static final int FORMAT_RGBA5551;
    public static final int FORMAT_RGBA4;
    public static final int FORMAT_RGB8;
    public static final int FORMAT_RGBA8;
    public static final int FORMAT_RGBA16F;
    public static final int FORMAT_RGBA32F;
    public static final int FORMAT_COMPRESSED_S3TC_RGB_DXT1;
    public static final int FORMAT_COMPRESSED_S3TC_RGBA_DXT1;
    public static final int FORMAT_COMPRESSED_S3TC_RGBA_DXT3;
    public static final int FORMAT_COMPRESSED_S3TC_RGBA_DXT5;
    public static final int FORMAT_COMPRESSED_ETC_RGB8;
    public static final int FORMAT_COMPRESSED_3DC_RGB_X;
    public static final int FORMAT_COMPRESSED_3DC_RGB_XY;
    public static final int FORMAT_COMPRESSED_PVRTC_RGB_4BPPV1;
    public static final int FORMAT_COMPRESSED_PVRTC_RGB_2BPPV1;
    public static final int FORMAT_COMPRESSED_PVRTC_RGBA_4BPPV1;
    public static final int FORMAT_COMPRESSED_PVRTC_RGBA_2BPPV1;
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

    private ImageFormat() {
    }

    public static int getImageSize(int n, int n2, int n3) {
        int n4 = n2 * n3;
        switch (n) {
            case 4096: {
                return 1 * n4;
            }
            case 4097: 
            case 4098: 
            case 4352: 
            case 4353: 
            case 4354: {
                return 2 * n4;
            }
            case 4355: {
                return 3 * n4;
            }
            case 4356: {
                return 4 * n4;
            }
            case 4357: {
                return 8 * n4;
            }
            case 4358: {
                return 16 * n4;
            }
        }
        throw new IllegalStateException("Invalid image format");
    }
}

