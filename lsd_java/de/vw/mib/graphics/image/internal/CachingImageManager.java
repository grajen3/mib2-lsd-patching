/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image.internal;

import de.vw.mib.cache.Cache;
import de.vw.mib.cache.LRUCache;
import de.vw.mib.cache.policies.MaximumObjectCountCachingPolicy;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.image.ImageLoadingListener;
import de.vw.mib.graphics.image.ScaleImage;
import de.vw.mib.graphics.image.UnsupportedImageTypeException;
import de.vw.mib.graphics.image.internal.AbstractImageManager;
import de.vw.mib.graphics.image.internal.DynamicImageLoader;
import de.vw.mib.graphics.image.internal.ImageCache;
import de.vw.mib.graphics.image.internal.ServiceManager;
import de.vw.mib.graphics.image.internal.SkinImageLoader;
import de.vw.mib.graphics.image.internal.SkinImagePreloader;
import de.vw.mib.graphics.image.spi.NativeImage;
import de.vw.mib.graphics.image.spi.NativeUnsupportedImageTypeException;
import de.vw.mib.graphics.performance.CachePerformanceMetrics;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import java.io.IOException;
import org.dsi.ifc.global.ResourceLocator;

public final class CachingImageManager
extends AbstractImageManager {
    private static final String IMAGECACHE_SIZE_MIB;
    private static final boolean IMAGE_PRELOADING;
    private final Logger logger;
    private final ImageCache skinImageCache;
    private SkinImagePreloader skinImagePreloader;
    private SkinImageLoader skinImageLoader;
    private static final int DYNAMICIMAGEINFO_CACHE_CAPACITY;
    private static final int DYNAMICIMAGEEXIF_CACHE_CAPACITY;
    private final ImageCache dynamicImageCache;
    private final Cache dynamicImageInfoCache;
    private final Cache dynamicImageExifInfoCache;
    private final DynamicImageLoader dynamicImageLoader;

    CachingImageManager(LoggerFactory loggerFactory) {
        this.logger = loggerFactory.getLogger(256);
        int n = 4096;
        int n2 = Integer.getInteger("de.vw.mib.graphics.image.imagecachesizemib", ServiceManager.configurationManager.getGraphicsImageCacheSizeMiB());
        int n3 = n2 * 4096;
        int n4 = n3 / 4 * 3;
        this.skinImageCache = new ImageCache(this.logger, n4);
        if (IMAGE_PRELOADING) {
            this.skinImagePreloader = new SkinImagePreloader(this.logger, this.skinImageCache);
        }
        this.skinImageLoader = new SkinImageLoader(this.logger, this.skinImageCache, this.skinImagePreloader);
        int n5 = n3 / 4 * 1;
        this.dynamicImageCache = new ImageCache(this.logger, n5);
        this.dynamicImageInfoCache = new LRUCache(new MaximumObjectCountCachingPolicy(100), true);
        this.dynamicImageExifInfoCache = new LRUCache(new MaximumObjectCountCachingPolicy(100), true);
        this.dynamicImageLoader = new DynamicImageLoader(this.logger, this.dynamicImageCache, this.dynamicImageInfoCache, this.dynamicImageExifInfoCache);
        this.logger.normal(16384).append("Limiting image cache size to ").append(n2).append("MiB (").append(n4).append(" bytes for skin images and ").append(n5).append(" bytes for dynamic images)").log();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void preloadImageFromCurrentSkin(Image image) {
        if (image != null) {
            this.preloadImageFromCurrentSkin(image.getCurrentImage());
        }
    }

    @Override
    public void preloadImagesFromCurrentSkin(Image[] imageArray) {
        if (imageArray != null) {
            for (int i2 = 0; i2 < imageArray.length; ++i2) {
                this.preloadImageFromCurrentSkin(imageArray[i2]);
            }
        }
    }

    @Override
    public void preloadImageFromCurrentSkin(ScaleImage scaleImage) {
        if (IMAGE_PRELOADING) {
            if (this.logger.isTraceEnabled(16384)) {
                LogMessage logMessage = this.logger.trace(16384);
                logMessage.append("preloadImageFromCurrentSkin(scaleImage=");
                logMessage.append(scaleImage);
                logMessage.append(")");
                logMessage.log();
            }
            if (scaleImage.hasFileIdentifier()) {
                this.skinImagePreloader.preloadImageFromSkin(ServiceManager.configurationManager.getCurrentSkinId(), scaleImage.getFileIdentifier());
            } else {
                this.skinImagePreloader.preloadImageFromSkin(ServiceManager.configurationManager.getCurrentSkinId(), scaleImage.getImageId());
            }
        }
    }

    @Override
    public void preloadImageFromCommonSkin(String string) {
        if (IMAGE_PRELOADING) {
            if (this.logger.isTraceEnabled(16384)) {
                LogMessage logMessage = this.logger.trace(16384);
                logMessage.append("preloadImageFromCommonSkin(filename=");
                logMessage.append(string);
                logMessage.append(")");
                logMessage.log();
            }
            this.skinImagePreloader.preloadImageFromSkin(ServiceManager.configurationManager.getCommonSkinId(), string);
        }
    }

    @Override
    public void preloadCarSpecificImageFromCommonSkin(String string) {
        if (IMAGE_PRELOADING) {
            if (this.logger.isTraceEnabled(16384)) {
                LogMessage logMessage = this.logger.trace(16384);
                logMessage.append("preloadCarSpecificImageFromCommonSkin(filename=");
                logMessage.append(string);
                logMessage.append(")");
                logMessage.log();
            }
            this.skinImagePreloader.preloadImageFromSkin(ServiceManager.configurationManager.getCommonSkinId(), string);
        }
    }

    @Override
    public BufferImage getImageFromCurrentSkin(Image image) {
        return this.getImageFromCurrentSkin(image.getCurrentImage());
    }

    @Override
    public BufferImage getImageFromCurrentSkin(ScaleImage scaleImage) {
        if (this.logger.isTraceEnabled(16384)) {
            LogMessage logMessage = this.logger.trace(16384);
            logMessage.append("getImageFromCurrentSkin(scaleImage=");
            logMessage.append(scaleImage);
            logMessage.append(")");
            logMessage.log();
        }
        if (scaleImage.hasFileIdentifier()) {
            return this.skinImageLoader.getImageFromSkin(ServiceManager.configurationManager.getCurrentSkinId(), scaleImage.getFileIdentifier());
        }
        return this.skinImageLoader.getImageFromSkin(ServiceManager.configurationManager.getCurrentSkinId(), scaleImage.getImageId());
    }

    @Override
    public BufferImage getSecondaryImageFromCurrentSkin(ScaleImage scaleImage) {
        if (this.logger.isTraceEnabled(16384)) {
            LogMessage logMessage = this.logger.trace(16384);
            logMessage.append("getImageFromCurrentSkin(scaleImage=");
            logMessage.append(scaleImage);
            logMessage.append(")");
            logMessage.log();
        }
        if (scaleImage.hasFileIdentifier2()) {
            return this.skinImageLoader.getImageFromSkin(ServiceManager.configurationManager.getCurrentSkinId(), scaleImage.getFileIdentifier2());
        }
        return this.skinImageLoader.getImageFromSkin(ServiceManager.configurationManager.getCurrentSkinId(), scaleImage.getImageId2());
    }

    @Override
    public BufferImage getImageFromCommonSkin(String string) {
        if (this.logger.isTraceEnabled(16384)) {
            LogMessage logMessage = this.logger.trace(16384);
            logMessage.append("getImageFromCurrentSkin(filename=");
            logMessage.append(string);
            logMessage.append(")");
            logMessage.log();
        }
        return this.skinImageLoader.getImageFromCommonSkin(string);
    }

    @Override
    public void getImageInfoFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener) {
        if (this.logger.isTraceEnabled(16384)) {
            LogMessage logMessage = this.logger.trace(16384);
            logMessage.append("getImageInfoFromResource(resource=");
            logMessage.append(resourceLocator);
            logMessage.append(")");
            logMessage.log();
        }
        this.dynamicImageLoader.getImageInfoFromResource(resourceLocator, imageLoadingListener);
    }

    @Override
    public void getImageFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener, boolean bl) {
        this.getImageFromResource(resourceLocator, imageLoadingListener, bl, 1);
    }

    @Override
    public void getImageFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener, boolean bl, int n) {
        if (this.logger.isTraceEnabled(16384)) {
            LogMessage logMessage = this.logger.trace(16384);
            logMessage.append("getImageFromResource(resource=");
            logMessage.append(resourceLocator);
            logMessage.append(",reportProgress=").append(bl);
            logMessage.append(",scaleDenom=").append(n);
            logMessage.append(")");
            logMessage.log();
        }
        this.dynamicImageLoader.getImageFromResource(resourceLocator, imageLoadingListener, bl, n);
    }

    @Override
    public void cancelGetImageFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener) {
        if (this.logger.isTraceEnabled(16384)) {
            LogMessage logMessage = this.logger.trace(16384);
            logMessage.append("cancelGetImageFromResource(resource=");
            logMessage.append(resourceLocator);
            logMessage.append(")");
            logMessage.log();
        }
        this.dynamicImageLoader.cancelLoadImage(resourceLocator, imageLoadingListener);
    }

    @Override
    public void getThumbnailImageFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener) {
        if (this.logger.isTraceEnabled(16384)) {
            LogMessage logMessage = this.logger.trace(16384);
            logMessage.append("getThumbnailImageFromResource(resource=");
            logMessage.append(resourceLocator);
            logMessage.append(")");
            logMessage.log();
        }
        this.dynamicImageLoader.getThumbnailImageFromResource(resourceLocator, imageLoadingListener);
    }

    @Override
    public void cancelGetThumbnailImageFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener) {
        if (this.logger.isTraceEnabled(16384)) {
            LogMessage logMessage = this.logger.trace(16384);
            logMessage.append("cancelGetThumbnailImageFromResource(resource=");
            logMessage.append(resourceLocator);
            logMessage.append(")");
            logMessage.log();
        }
        this.dynamicImageLoader.cancelLoadThumbnailImage(resourceLocator, imageLoadingListener);
    }

    @Override
    public void getExifInfoFromResource(ResourceLocator resourceLocator, int n, int[] nArray, ImageLoadingListener imageLoadingListener) {
        if (this.logger.isTraceEnabled(16384)) {
            LogMessage logMessage = this.logger.trace(16384);
            logMessage.append("getExifInfoFromResource(resource=");
            logMessage.append(resourceLocator);
            logMessage.append(",ifd=");
            logMessage.append(n);
            logMessage.append(",tags=");
            logMessage.append(nArray);
            logMessage.append(")");
            logMessage.log();
        }
        this.dynamicImageLoader.getExifInfoFromResource(resourceLocator, n, nArray, imageLoadingListener);
    }

    public void save(String string, BufferImage bufferImage) {
        Object object;
        if (this.logger.isTraceEnabled(16384)) {
            object = this.logger.trace(16384);
            object.append("save(filename=");
            object.append(string);
            object.append(",image=");
            object.append(bufferImage);
            object.append(")");
            object.log();
        }
        try {
            object = new NativeImage(bufferImage.getBuffer(), bufferImage.getWidth(), bufferImage.getHeight(), bufferImage.getImageFormat());
            ServiceManager.imageSPI.saveImageToFile(string, 4, (NativeImage)object);
        }
        catch (NativeUnsupportedImageTypeException nativeUnsupportedImageTypeException) {
            throw new UnsupportedImageTypeException(nativeUnsupportedImageTypeException.getMessage());
        }
        catch (IOException iOException) {
            throw iOException;
        }
    }

    @Override
    public CachePerformanceMetrics getSkinImageCacheUsage() {
        return new CachePerformanceMetrics(this.skinImageCache.size(), this.skinImageCache.getByteSize(), this.skinImageCache.getMaximumCacheSizeBytes(), this.skinImageCache.hits(), this.skinImageCache.misses());
    }

    @Override
    public CachePerformanceMetrics getDynamicImageCacheUsage() {
        return new CachePerformanceMetrics(this.dynamicImageCache.size(), this.dynamicImageCache.getByteSize(), this.dynamicImageCache.getMaximumCacheSizeBytes(), this.dynamicImageCache.hits(), this.dynamicImageCache.misses());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void flushSkinImageCache() {
        if (IMAGE_PRELOADING) {
            ImageCache imageCache = this.skinImageCache;
            synchronized (imageCache) {
                this.skinImageCache.clear();
            }
        } else {
            this.skinImageCache.clear();
        }
    }

    @Override
    public void flushDynamicImageCache() {
        this.dynamicImageLoader.resetCaches();
    }

    static {
        IMAGE_PRELOADING = System.getProperty("de.vw.mib.graphics.image.preloading") != null;
    }
}

