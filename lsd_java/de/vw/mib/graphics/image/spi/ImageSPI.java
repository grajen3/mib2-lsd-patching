/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image.spi;

import de.vw.mib.graphics.image.spi.NativeImage;
import de.vw.mib.graphics.image.spi.NativeImageHeader;
import de.vw.mib.graphics.image.spi.NativeImageLoadingListener;
import java.nio.ByteBuffer;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;

public interface ImageSPI {
    public static final String DEFAULT_CONTENTFILE_NAME;
    public static final int EXIF_IFD_0;
    public static final int EXIF_IFD_1;
    public static final int EXIF_IFD_EXIF;
    public static final int EXIF_IFD_GPS;
    public static final int EXIF_IFD_INTEROPERABILITY;

    default public void setContentFileForSkin(int n, String string) {
    }

    default public NativeImage loadImageFromSkin(int n, int n2) {
    }

    default public NativeImage loadImageFromSkin(int n, String string) {
    }

    default public NativeImageHeader getImageHeaderFromResource(ResourceLocator resourceLocator) {
    }

    default public NativeImage loadImageFromResource(ResourceLocator resourceLocator, int n, NativeImageLoadingListener nativeImageLoadingListener) {
    }

    default public NativeImage loadImageRegionFromResource(ResourceLocator resourceLocator, int n, int n2, int n3, int n4, NativeImageLoadingListener nativeImageLoadingListener) {
    }

    default public NativeImage loadThumbnailImageFromResource(ResourceLocator resourceLocator) {
    }

    default public void releaseImage(ByteBuffer byteBuffer) {
    }

    default public Map getExifTagsFromResource(ResourceLocator resourceLocator, int n, int[] nArray) {
    }

    default public void saveImageToFile(String string, int n, NativeImage nativeImage) {
    }
}

