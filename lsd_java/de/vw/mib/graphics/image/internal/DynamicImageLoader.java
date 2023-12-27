/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image.internal;

import de.vw.mib.cache.Cache;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.ImageInfo;
import de.vw.mib.graphics.image.ImageLoadingListener;
import de.vw.mib.graphics.image.InvalidImageFormatException;
import de.vw.mib.graphics.image.UnsupportedImageTypeException;
import de.vw.mib.graphics.image.internal.DynamicImageLoader$ImageRequest;
import de.vw.mib.graphics.image.internal.DynamicImageLoader$ImageRequestPool;
import de.vw.mib.graphics.image.internal.DynamicImageLoader$NativeImageLoadingAdapter;
import de.vw.mib.graphics.image.internal.ExifInfo;
import de.vw.mib.graphics.image.internal.ImageCache;
import de.vw.mib.graphics.image.internal.ImageLoader;
import de.vw.mib.graphics.image.internal.ServiceManager;
import de.vw.mib.graphics.image.spi.NativeImage;
import de.vw.mib.graphics.image.spi.NativeImageHeader;
import de.vw.mib.graphics.image.spi.NativeInvalidImageFormatException;
import de.vw.mib.graphics.image.spi.NativeUnsupportedImageTypeException;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.MIBRunnable;
import de.vw.mib.threads.MIBThread;
import de.vw.mib.threads.util.Queue;
import de.vw.mib.util.Util;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;

public final class DynamicImageLoader
implements MIBRunnable,
ImageLoader {
    private static final int INITIAL_QUEUE_CAPACITY;
    private static final int IMAGEREQUEST_POOL_MAXIMUM_CAPACITY;
    private final Logger logger;
    private final ImageCache imageCache;
    private final Cache infoCache;
    private final Cache exifInformationCache;
    private final Queue pendingImageRequests;
    private final DynamicImageLoader$ImageRequestPool imageRequestPool;
    private final HashCodeBuilder hcb;
    private MIBThread thread;
    private int cachingSessionId;

    public DynamicImageLoader(Logger logger, ImageCache imageCache, Cache cache, Cache cache2) {
        this.logger = logger;
        this.cachingSessionId = 0;
        this.imageCache = imageCache;
        this.infoCache = cache;
        this.exifInformationCache = cache2;
        this.pendingImageRequests = new Queue(50);
        this.imageRequestPool = new DynamicImageLoader$ImageRequestPool(20);
        this.hcb = new HashCodeBuilder();
        ServiceManager.threadManager.createThread(6, this).start();
    }

    public void die() {
        this.thread.stop();
    }

    @Override
    public void setThread(MIBThread mIBThread) {
        this.thread = mIBThread;
        this.pendingImageRequests.setThread(mIBThread);
    }

    @Override
    public void threadDeathDetected() {
        this.logger.fatal(4, "Thread deatch detected!");
    }

    @Override
    public void timeoutDetected() {
        this.logger.fatal(4, "Timeout detected!");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void resetCaches() {
        Object object;
        ++this.cachingSessionId;
        if (this.logger.isTraceEnabled(16384)) {
            object = this.logger.trace(16384);
            object.append("clearing dynamic image/exif/info cache");
            object.log();
        }
        object = this.imageCache;
        synchronized (object) {
            this.imageCache.clear();
        }
        object = this.infoCache;
        synchronized (object) {
            this.infoCache.clear();
        }
        object = this.exifInformationCache;
        synchronized (object) {
            this.exifInformationCache.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void operate() {
        DynamicImageLoader$ImageRequest dynamicImageLoader$ImageRequest;
        Queue queue = this.pendingImageRequests;
        synchronized (queue) {
            if (this.pendingImageRequests.isEmpty()) {
                this.thread.suspend();
                return;
            }
            dynamicImageLoader$ImageRequest = (DynamicImageLoader$ImageRequest)this.pendingImageRequests.poll();
        }
        try {
            switch (dynamicImageLoader$ImageRequest.getRequestType()) {
                case 0: {
                    this.processLoadImageInfo(dynamicImageLoader$ImageRequest);
                    break;
                }
                case 1: {
                    this.processLoadImage(dynamicImageLoader$ImageRequest);
                    break;
                }
                case 2: {
                    this.processLoadThumbnail(dynamicImageLoader$ImageRequest);
                    break;
                }
                case 3: {
                    this.processLoadExifInfo(dynamicImageLoader$ImageRequest);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid image load request type");
                }
            }
        }
        catch (Exception exception) {
            LogMessage logMessage = this.logger.error(4);
            logMessage.append("Caught Excepion while processing request type: '").append(dynamicImageLoader$ImageRequest.getRequestType()).append("' for resource").append(dynamicImageLoader$ImageRequest.getResource()).attachThrowable(exception).log();
        }
        this.imageRequestPool.releaseObject(dynamicImageLoader$ImageRequest);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void processLoadImageInfo(DynamicImageLoader$ImageRequest dynamicImageLoader$ImageRequest) {
        ImageInfo imageInfo = null;
        try {
            long l = dynamicImageLoader$ImageRequest.getHashCode();
            Object object = this.infoCache;
            synchronized (object) {
                imageInfo = (ImageInfo)this.infoCache.get(l);
            }
            if (imageInfo == null) {
                long l2;
                object = this.logger.isTraceEnabled(4) ? this.logger.trace(4) : null;
                boolean bl = object != null && this.logger.isTraceEnabled(128);
                NativeImageHeader nativeImageHeader = null;
                long l3 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
                nativeImageHeader = ServiceManager.imageSPI.getImageHeaderFromResource(dynamicImageLoader$ImageRequest.getResource());
                long l4 = l2 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
                if (nativeImageHeader != null) {
                    imageInfo = new ImageInfo(nativeImageHeader);
                    if (object != null) {
                        object.append("getImageInfoFromResource(").append(dynamicImageLoader$ImageRequest.getResource()).append(")");
                        if (bl) {
                            object.append(": ").append(l2 - l3).append("\u00b5s");
                        }
                        object.log();
                    }
                    Cache cache = this.infoCache;
                    synchronized (cache) {
                        this.infoCache.put(l, imageInfo);
                    }
                } else {
                    object = this.logger.error(4);
                    object.append("getImageInfoFromResource(").append(dynamicImageLoader$ImageRequest.getResource()).append(") = null").log();
                    throw new IOException("ImageSPI.getImageInfoFromResource() == null");
                }
            }
            dynamicImageLoader$ImageRequest.getListener().imageInfoAvailable(dynamicImageLoader$ImageRequest.getResource(), imageInfo);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            dynamicImageLoader$ImageRequest.getListener().imageInfoError(dynamicImageLoader$ImageRequest.getResource(), illegalArgumentException);
        }
        catch (NativeInvalidImageFormatException nativeInvalidImageFormatException) {
            dynamicImageLoader$ImageRequest.getListener().imageInfoError(dynamicImageLoader$ImageRequest.getResource(), new InvalidImageFormatException(nativeInvalidImageFormatException.getMessage()));
        }
        catch (NativeUnsupportedImageTypeException nativeUnsupportedImageTypeException) {
            dynamicImageLoader$ImageRequest.getListener().imageInfoError(dynamicImageLoader$ImageRequest.getResource(), new UnsupportedImageTypeException(nativeUnsupportedImageTypeException.getMessage()));
        }
        catch (IOException iOException) {
            dynamicImageLoader$ImageRequest.getListener().imageInfoError(dynamicImageLoader$ImageRequest.getResource(), iOException);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void processLoadImage(DynamicImageLoader$ImageRequest dynamicImageLoader$ImageRequest) {
        BufferImage bufferImage = null;
        try {
            long l = dynamicImageLoader$ImageRequest.getHashCode();
            Object object = this.imageCache;
            synchronized (object) {
                bufferImage = (BufferImage)this.imageCache.get(l);
            }
            if (bufferImage == null) {
                long l2;
                object = this.logger.isTraceEnabled(4) ? this.logger.trace(4) : null;
                boolean bl = object != null && this.logger.isTraceEnabled(128);
                NativeImage nativeImage = null;
                DynamicImageLoader$NativeImageLoadingAdapter dynamicImageLoader$NativeImageLoadingAdapter = dynamicImageLoader$ImageRequest.isReportProgress() ? new DynamicImageLoader$NativeImageLoadingAdapter(dynamicImageLoader$ImageRequest) : null;
                long l3 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
                nativeImage = ServiceManager.imageSPI.loadImageFromResource(dynamicImageLoader$ImageRequest.getResource(), dynamicImageLoader$ImageRequest.getScaleDenom(), dynamicImageLoader$NativeImageLoadingAdapter);
                long l4 = l2 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
                if (nativeImage != null) {
                    bufferImage = new BufferImage(l, nativeImage.getBuffer(), nativeImage.getFormat(), nativeImage.getWidth(), nativeImage.getHeight());
                    if (object != null) {
                        object.append("loadImageFromResource('").append(dynamicImageLoader$ImageRequest.getResource()).append("') = ").append(bufferImage.getWidth()).append("x").append(bufferImage.getHeight()).append(" Format ").append(bufferImage.getImageFormat()).append(" = ").append(bufferImage.getByteSize()).append(" bytes");
                        if (bl) {
                            object.append(": ").append(l2 - l3).append("\u00b5s");
                        }
                        object.log();
                    }
                    ImageCache imageCache = this.imageCache;
                    synchronized (imageCache) {
                        this.imageCache.put(l, bufferImage);
                    }
                } else {
                    object = this.logger.error(4);
                    object.append("loadImageFromResource(").append(dynamicImageLoader$ImageRequest.getResource()).append(") = null").log();
                    throw new IOException("ImageSPI.loadImageFromResource() == null");
                }
            }
            dynamicImageLoader$ImageRequest.getListener().imageAvailable(dynamicImageLoader$ImageRequest.getResource(), bufferImage);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            dynamicImageLoader$ImageRequest.getListener().imageError(dynamicImageLoader$ImageRequest.getResource(), illegalArgumentException);
        }
        catch (NativeInvalidImageFormatException nativeInvalidImageFormatException) {
            dynamicImageLoader$ImageRequest.getListener().imageError(dynamicImageLoader$ImageRequest.getResource(), new InvalidImageFormatException(nativeInvalidImageFormatException.getMessage()));
        }
        catch (NativeUnsupportedImageTypeException nativeUnsupportedImageTypeException) {
            dynamicImageLoader$ImageRequest.getListener().imageError(dynamicImageLoader$ImageRequest.getResource(), new UnsupportedImageTypeException(nativeUnsupportedImageTypeException.getMessage()));
        }
        catch (IOException iOException) {
            dynamicImageLoader$ImageRequest.getListener().imageError(dynamicImageLoader$ImageRequest.getResource(), iOException);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void processLoadThumbnail(DynamicImageLoader$ImageRequest dynamicImageLoader$ImageRequest) {
        BufferImage bufferImage = null;
        try {
            long l = dynamicImageLoader$ImageRequest.getHashCode();
            Object object = this.imageCache;
            synchronized (object) {
                bufferImage = (BufferImage)this.imageCache.get(l);
            }
            if (bufferImage == null) {
                long l2;
                object = this.logger.isTraceEnabled(4) ? this.logger.trace(4) : null;
                boolean bl = object != null && this.logger.isTraceEnabled(128);
                NativeImage nativeImage = null;
                long l3 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
                nativeImage = ServiceManager.imageSPI.loadThumbnailImageFromResource(dynamicImageLoader$ImageRequest.getResource());
                long l4 = l2 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
                if (nativeImage != null) {
                    bufferImage = new BufferImage(l, nativeImage.getBuffer(), nativeImage.getFormat(), nativeImage.getWidth(), nativeImage.getHeight());
                    if (object != null) {
                        object.append("getThumbnailImageFromResource('").append(dynamicImageLoader$ImageRequest.getResource()).append("') = ").append(bufferImage.getWidth()).append("x").append(bufferImage.getHeight()).append(" Format ").append(bufferImage.getImageFormat()).append(" = ").append(bufferImage.getByteSize()).append(" bytes");
                        if (bl) {
                            object.append(": ").append(l2 - l3).append("\u00b5s");
                        }
                        object.log();
                    }
                    ImageCache imageCache = this.imageCache;
                    synchronized (imageCache) {
                        this.imageCache.put(l, bufferImage);
                    }
                } else {
                    object = this.logger.error(4);
                    object.append("getThumbnailImageFromResource(").append(dynamicImageLoader$ImageRequest.getResource()).append(") = null").log();
                    throw new IOException("ImageSPI.getThumbnailImageFromResource() == null");
                }
            }
            dynamicImageLoader$ImageRequest.getListener().thumbnailImageAvailable(dynamicImageLoader$ImageRequest.getResource(), bufferImage);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            dynamicImageLoader$ImageRequest.getListener().thumbnailImageError(dynamicImageLoader$ImageRequest.getResource(), illegalArgumentException);
        }
        catch (NativeInvalidImageFormatException nativeInvalidImageFormatException) {
            dynamicImageLoader$ImageRequest.getListener().thumbnailImageError(dynamicImageLoader$ImageRequest.getResource(), new InvalidImageFormatException(nativeInvalidImageFormatException.getMessage()));
        }
        catch (NativeUnsupportedImageTypeException nativeUnsupportedImageTypeException) {
            dynamicImageLoader$ImageRequest.getListener().thumbnailImageError(dynamicImageLoader$ImageRequest.getResource(), new UnsupportedImageTypeException(nativeUnsupportedImageTypeException.getMessage()));
        }
        catch (IOException iOException) {
            dynamicImageLoader$ImageRequest.getListener().thumbnailImageError(dynamicImageLoader$ImageRequest.getResource(), iOException);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void processLoadExifInfo(DynamicImageLoader$ImageRequest dynamicImageLoader$ImageRequest) {
        ExifInfo exifInfo = null;
        try {
            long l = dynamicImageLoader$ImageRequest.getHashCode();
            Object object = this.exifInformationCache;
            synchronized (object) {
                exifInfo = (ExifInfo)this.exifInformationCache.get(l);
            }
            if (exifInfo == null || !exifInfo.containsExifValues(dynamicImageLoader$ImageRequest.getTags())) {
                long l2;
                object = this.logger.isTraceEnabled(4) ? this.logger.trace(4) : null;
                boolean bl = object != null && this.logger.isTraceEnabled(128);
                Map map = null;
                long l3 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
                map = ServiceManager.imageSPI.getExifTagsFromResource(dynamicImageLoader$ImageRequest.getResource(), dynamicImageLoader$ImageRequest.getIfd(), dynamicImageLoader$ImageRequest.getTags());
                long l4 = l2 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
                if (object != null) {
                    object.append("getExifInfoFromResource(").append(dynamicImageLoader$ImageRequest.getResource()).append(")");
                    if (bl) {
                        object.append(": ").append(l2 - l3).append("\u00b5s");
                    }
                    object.log();
                }
                if (exifInfo == null) {
                    exifInfo = new ExifInfo(dynamicImageLoader$ImageRequest.getIfd(), dynamicImageLoader$ImageRequest.getTags(), map);
                } else {
                    exifInfo.addAllExifValues(map, dynamicImageLoader$ImageRequest.getTags());
                }
                Cache cache = this.exifInformationCache;
                synchronized (cache) {
                    this.exifInformationCache.put(l, exifInfo);
                }
                if (map == null) {
                    object = this.logger.error(4);
                    object.append("getExifDataFromResource(").append(dynamicImageLoader$ImageRequest.getResource()).append(") = null").log();
                    throw new IOException("ImageSPI.getExifFromResource() == null");
                }
            }
            dynamicImageLoader$ImageRequest.getListener().exifInfoAvailable(dynamicImageLoader$ImageRequest.getResource(), dynamicImageLoader$ImageRequest.getIfd(), dynamicImageLoader$ImageRequest.getTags(), exifInfo);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            dynamicImageLoader$ImageRequest.getListener().exifInfoError(dynamicImageLoader$ImageRequest.getResource(), dynamicImageLoader$ImageRequest.getIfd(), dynamicImageLoader$ImageRequest.getTags(), illegalArgumentException);
        }
        catch (NativeInvalidImageFormatException nativeInvalidImageFormatException) {
            dynamicImageLoader$ImageRequest.getListener().exifInfoError(dynamicImageLoader$ImageRequest.getResource(), dynamicImageLoader$ImageRequest.getIfd(), dynamicImageLoader$ImageRequest.getTags(), new InvalidImageFormatException(nativeInvalidImageFormatException.getMessage()));
        }
        catch (NativeUnsupportedImageTypeException nativeUnsupportedImageTypeException) {
            dynamicImageLoader$ImageRequest.getListener().exifInfoError(dynamicImageLoader$ImageRequest.getResource(), dynamicImageLoader$ImageRequest.getIfd(), dynamicImageLoader$ImageRequest.getTags(), new UnsupportedImageTypeException(nativeUnsupportedImageTypeException.getMessage()));
        }
        catch (IOException iOException) {
            dynamicImageLoader$ImageRequest.getListener().exifInfoError(dynamicImageLoader$ImageRequest.getResource(), dynamicImageLoader$ImageRequest.getIfd(), dynamicImageLoader$ImageRequest.getTags(), iOException);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void getImageInfoFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener) {
        long l = DynamicImageLoader.calculateHashCode(this.hcb, resourceLocator, this.cachingSessionId);
        ImageInfo imageInfo = null;
        Cache cache = this.infoCache;
        synchronized (cache) {
            imageInfo = (ImageInfo)this.infoCache.get(l);
        }
        if (imageInfo != null) {
            imageLoadingListener.imageInfoAvailable(resourceLocator, imageInfo);
        } else {
            this.addRequest(0, resourceLocator, imageLoadingListener, false, 1, 0, null, l);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void getImageFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener, boolean bl, int n) {
        long l = DynamicImageLoader.calculateHashCode(this.hcb, resourceLocator, false, n, this.cachingSessionId);
        BufferImage bufferImage = null;
        ImageCache imageCache = this.imageCache;
        synchronized (imageCache) {
            bufferImage = (BufferImage)this.imageCache.get(l);
        }
        if (bufferImage != null) {
            imageLoadingListener.imageAvailable(resourceLocator, bufferImage);
        } else {
            this.addRequest(1, resourceLocator, imageLoadingListener, bl, n, 0, null, l);
        }
    }

    public void cancelLoadImage(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener) {
        this.cancelImageRequest(1, resourceLocator, imageLoadingListener);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void getThumbnailImageFromResource(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener) {
        long l = DynamicImageLoader.calculateHashCode(this.hcb, resourceLocator, false, 1, this.cachingSessionId);
        BufferImage bufferImage = null;
        ImageCache imageCache = this.imageCache;
        synchronized (imageCache) {
            bufferImage = (BufferImage)this.imageCache.get(l);
        }
        if (bufferImage != null) {
            imageLoadingListener.imageAvailable(resourceLocator, bufferImage);
        } else {
            this.addRequest(2, resourceLocator, imageLoadingListener, false, 1, 0, null, l);
        }
    }

    public void cancelLoadThumbnailImage(ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener) {
        this.cancelImageRequest(2, resourceLocator, imageLoadingListener);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void getExifInfoFromResource(ResourceLocator resourceLocator, int n, int[] nArray, ImageLoadingListener imageLoadingListener) {
        long l = DynamicImageLoader.calculateHashCode(this.hcb, resourceLocator, n, this.cachingSessionId);
        ExifInfo exifInfo = null;
        Cache cache = this.exifInformationCache;
        synchronized (cache) {
            exifInfo = (ExifInfo)this.exifInformationCache.get(l);
        }
        if (exifInfo != null && exifInfo.containsExifValues(nArray)) {
            imageLoadingListener.exifInfoAvailable(resourceLocator, n, nArray, exifInfo);
        } else {
            this.addRequest(3, resourceLocator, imageLoadingListener, false, 1, n, nArray, l);
        }
    }

    private void addRequest(int n, ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener, boolean bl, int n2, int n3, int[] nArray, long l) {
        DynamicImageLoader$ImageRequest dynamicImageLoader$ImageRequest = (DynamicImageLoader$ImageRequest)this.imageRequestPool.borrowObject();
        dynamicImageLoader$ImageRequest.setRequestType(n);
        dynamicImageLoader$ImageRequest.setResource(resourceLocator);
        dynamicImageLoader$ImageRequest.setListener(imageLoadingListener);
        dynamicImageLoader$ImageRequest.setReportProgress(bl);
        dynamicImageLoader$ImageRequest.setScaleDenom(n2);
        dynamicImageLoader$ImageRequest.setIfd(n3);
        dynamicImageLoader$ImageRequest.setTags(nArray);
        dynamicImageLoader$ImageRequest.setHashCode(l);
        this.pendingImageRequests.add(dynamicImageLoader$ImageRequest);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void cancelImageRequest(int n, ResourceLocator resourceLocator, ImageLoadingListener imageLoadingListener) {
        Queue queue = this.pendingImageRequests;
        synchronized (queue) {
            Iterator iterator = this.pendingImageRequests.iterator();
            while (iterator.hasNext()) {
                DynamicImageLoader$ImageRequest dynamicImageLoader$ImageRequest = (DynamicImageLoader$ImageRequest)iterator.next();
                if (dynamicImageLoader$ImageRequest.getRequestType() != n || dynamicImageLoader$ImageRequest.getResource() != resourceLocator || dynamicImageLoader$ImageRequest.getListener() != imageLoadingListener) continue;
                this.pendingImageRequests.remove(dynamicImageLoader$ImageRequest);
                this.imageRequestPool.releaseObject(dynamicImageLoader$ImageRequest);
                break;
            }
        }
    }

    private static long calculateHashCode(HashCodeBuilder hashCodeBuilder, ResourceLocator resourceLocator, boolean bl, int n, int n2) {
        hashCodeBuilder.reset();
        if (Util.isNullOrEmpty(resourceLocator.getUrl())) {
            hashCodeBuilder.append(resourceLocator.getId());
        } else {
            hashCodeBuilder.append(resourceLocator.getUrl());
        }
        hashCodeBuilder.append(bl);
        hashCodeBuilder.append(n);
        hashCodeBuilder.append(n2);
        return hashCodeBuilder.longHashCode();
    }

    private static long calculateHashCode(HashCodeBuilder hashCodeBuilder, ResourceLocator resourceLocator, int n) {
        return DynamicImageLoader.calculateHashCode(hashCodeBuilder, resourceLocator, false, 1, n);
    }

    private static long calculateHashCode(HashCodeBuilder hashCodeBuilder, ResourceLocator resourceLocator, int n, int n2) {
        return DynamicImageLoader.calculateHashCode(hashCodeBuilder, resourceLocator, false, n, n2);
    }
}

