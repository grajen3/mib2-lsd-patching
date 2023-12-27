/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image.internal;

import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.image.ImageLoadingListener;
import de.vw.mib.graphics.image.ScaleImage;
import de.vw.mib.graphics.image.internal.AbstractImageManager;
import de.vw.mib.graphics.performance.CachePerformanceMetrics;
import java.io.IOException;
import org.dsi.ifc.global.ResourceLocator;

public class ImageManagerStub
extends AbstractImageManager {
    @Override
    public void preloadImageFromCurrentSkin(Image image) {
    }

    @Override
    public void preloadImagesFromCurrentSkin(Image[] imageArray) {
    }

    @Override
    public void preloadImageFromCurrentSkin(ScaleImage scaleImage) {
    }

    @Override
    public void preloadImageFromCommonSkin(String string) {
    }

    @Override
    public void preloadCarSpecificImageFromCommonSkin(String string) {
    }

    @Override
    public BufferImage getImageFromCurrentSkin(Image image) {
        throw new IOException("Not implemented");
    }

    @Override
    public BufferImage getImageFromCurrentSkin(ScaleImage scaleImage) {
        throw new IOException("Not implemented");
    }

    @Override
    public BufferImage getImageFromCommonSkin(String string) {
        throw new IOException("Not implemented");
    }

    @Override
    public void getImageInfoFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener) {
    }

    @Override
    public void getImageFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener, boolean bl) {
    }

    @Override
    public void getImageFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener, boolean bl, int n) {
    }

    @Override
    public void cancelGetImageFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener) {
    }

    @Override
    public void getThumbnailImageFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener) {
    }

    @Override
    public void cancelGetThumbnailImageFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener) {
    }

    @Override
    public void getExifInfoFromResource(ResourceLocator resourceLocator, int n, int[] nArray, ImageLoadingListener imageLoadingListener) {
    }

    @Override
    public void flushSkinImageCache() {
    }

    @Override
    public void flushDynamicImageCache() {
    }

    @Override
    public CachePerformanceMetrics getSkinImageCacheUsage() {
        return null;
    }

    @Override
    public CachePerformanceMetrics getDynamicImageCacheUsage() {
        return null;
    }

    @Override
    public BufferImage getSecondaryImageFromCurrentSkin(ScaleImage scaleImage) {
        return null;
    }
}

