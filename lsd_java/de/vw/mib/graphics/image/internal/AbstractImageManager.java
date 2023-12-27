/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image.internal;

import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.image.ImageLoadingListener;
import de.vw.mib.graphics.image.ImageManager;
import de.vw.mib.graphics.image.ImagePerformanceMetrics;
import de.vw.mib.graphics.image.ScaleImage;
import de.vw.mib.graphics.performance.CachePerformanceMetrics;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractImageManager
implements ImageManager {
    @Override
    public void dispose() {
    }

    @Override
    public final ImagePerformanceMetrics getPerformanceMetrics() {
        return new ImagePerformanceMetrics();
    }

    @Override
    public abstract void preloadImageFromCurrentSkin(Image image) {
    }

    @Override
    public abstract void preloadImagesFromCurrentSkin(Image[] imageArray) {
    }

    @Override
    public abstract void preloadImageFromCurrentSkin(ScaleImage scaleImage) {
    }

    @Override
    public abstract void preloadImageFromCommonSkin(String string) {
    }

    @Override
    public abstract void preloadCarSpecificImageFromCommonSkin(String string) {
    }

    @Override
    public abstract BufferImage getImageFromCurrentSkin(Image image) {
    }

    @Override
    public abstract BufferImage getImageFromCurrentSkin(ScaleImage scaleImage) {
    }

    @Override
    public abstract BufferImage getSecondaryImageFromCurrentSkin(ScaleImage scaleImage) {
    }

    @Override
    public abstract BufferImage getImageFromCommonSkin(String string) {
    }

    @Override
    public abstract void getImageInfoFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener) {
    }

    @Override
    public abstract void getImageFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener, boolean bl) {
    }

    @Override
    public abstract void getImageFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener, boolean bl, int n) {
    }

    @Override
    public abstract void cancelGetImageFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener) {
    }

    @Override
    public abstract void getThumbnailImageFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener) {
    }

    @Override
    public abstract void cancelGetThumbnailImageFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener) {
    }

    @Override
    public abstract void getExifInfoFromResource(ResourceLocator resourceLocator, int n, int[] nArray, ImageLoadingListener imageLoadingListener) {
    }

    @Override
    public abstract void flushSkinImageCache() {
    }

    @Override
    public abstract void flushDynamicImageCache() {
    }

    @Override
    public abstract CachePerformanceMetrics getSkinImageCacheUsage() {
    }

    @Override
    public abstract CachePerformanceMetrics getDynamicImageCacheUsage() {
    }
}

