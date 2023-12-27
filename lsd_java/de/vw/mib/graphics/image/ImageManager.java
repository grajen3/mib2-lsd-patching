/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image;

import de.vw.mib.graphics.ResourceManager;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.image.ImageLoadingListener;
import de.vw.mib.graphics.image.ImagePerformanceMetrics;
import de.vw.mib.graphics.image.ScaleImage;
import de.vw.mib.graphics.performance.CachePerformanceMetrics;
import org.dsi.ifc.global.ResourceLocator;

public interface ImageManager
extends ResourceManager {
    default public ImagePerformanceMetrics getPerformanceMetrics() {
    }

    default public void preloadImageFromCurrentSkin(Image image) {
    }

    default public void preloadImagesFromCurrentSkin(Image[] imageArray) {
    }

    default public void preloadImageFromCurrentSkin(ScaleImage scaleImage) {
    }

    default public void preloadImageFromCommonSkin(String string) {
    }

    default public void preloadCarSpecificImageFromCommonSkin(String string) {
    }

    default public BufferImage getImageFromCurrentSkin(Image image) {
    }

    default public BufferImage getImageFromCurrentSkin(ScaleImage scaleImage) {
    }

    default public BufferImage getSecondaryImageFromCurrentSkin(ScaleImage scaleImage) {
    }

    default public BufferImage getImageFromCommonSkin(String string) {
    }

    default public void getImageInfoFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener) {
    }

    default public void getImageFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener, boolean bl) {
    }

    default public void getImageFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener, boolean bl, int n) {
    }

    default public void cancelGetImageFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener) {
    }

    default public void getThumbnailImageFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener) {
    }

    default public void cancelGetThumbnailImageFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener) {
    }

    default public void getExifInfoFromResource(ResourceLocator resourceLocator, int n, int[] nArray, ImageLoadingListener imageLoadingListener) {
    }

    default public void flushSkinImageCache() {
    }

    default public void flushDynamicImageCache() {
    }

    default public CachePerformanceMetrics getSkinImageCacheUsage() {
    }

    default public CachePerformanceMetrics getDynamicImageCacheUsage() {
    }
}

