/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image;

import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.ExifInfo;
import de.vw.mib.graphics.image.ImageInfo;
import java.util.EventListener;
import org.dsi.ifc.global.ResourceLocator;

public interface ImageLoadingListener
extends EventListener {
    default public void imageInfoAvailable(ResourceLocator resourceLocator, ImageInfo imageInfo) {
    }

    default public void imageInfoError(ResourceLocator resourceLocator, Exception exception) {
    }

    default public void exifInfoAvailable(ResourceLocator resourceLocator, int n, int[] nArray, ExifInfo exifInfo) {
    }

    default public void exifInfoError(ResourceLocator resourceLocator, int n, int[] nArray, Exception exception) {
    }

    default public void imageLoadingProgress(ResourceLocator resourceLocator, int n) {
    }

    default public void imageAvailable(ResourceLocator resourceLocator, BufferImage bufferImage) {
    }

    default public void imageError(ResourceLocator resourceLocator, Exception exception) {
    }

    default public void thumbnailImageAvailable(ResourceLocator resourceLocator, BufferImage bufferImage) {
    }

    default public void thumbnailImageError(ResourceLocator resourceLocator, Exception exception) {
    }
}

