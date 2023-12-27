/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image.internal;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.internal.ImageCache;
import de.vw.mib.graphics.image.internal.ServiceManager;
import de.vw.mib.graphics.image.internal.SkinImageLoader;
import de.vw.mib.graphics.image.internal.SkinImagePreloader$PreloadRequest;
import de.vw.mib.graphics.image.internal.SkinImagePreloader$PreloadRequestPool;
import de.vw.mib.graphics.image.spi.NativeImage;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.MIBRunnable;
import de.vw.mib.threads.MIBThread;
import de.vw.mib.threads.util.Queue;
import java.io.IOException;
import java.util.Iterator;

public final class SkinImagePreloader
implements MIBRunnable {
    private static final int INITIAL_QUEUE_CAPACITY;
    private static final int PRELOADREQUEST_POOL_MAXIMUM_CAPACITY;
    private final Logger logger;
    private final ImageCache skinImageCache;
    private final Queue pendingRequests;
    private final SkinImagePreloader$PreloadRequestPool preloadRequestPool;
    private final HashCodeBuilder hcb;
    private MIBThread thread;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$image$internal$SkinImagePreloader;

    public SkinImagePreloader(Logger logger, ImageCache imageCache) {
        this.logger = logger;
        this.skinImageCache = imageCache;
        this.pendingRequests = new Queue(50);
        this.preloadRequestPool = new SkinImagePreloader$PreloadRequestPool(20);
        this.hcb = new HashCodeBuilder();
        ServiceManager.threadManager.createThread(7, this).start();
    }

    public void die() {
        this.thread.stop();
    }

    @Override
    public void setThread(MIBThread mIBThread) {
        this.thread = mIBThread;
        this.pendingRequests.setThread(mIBThread);
    }

    @Override
    public void threadDeathDetected() {
        this.logger.fatal(2, "Thread deatch detected!");
    }

    @Override
    public void timeoutDetected() {
        this.logger.fatal(2, "Timeout detected!");
    }

    public void suspend() {
        this.thread.suspend();
    }

    public void resume() {
        this.thread.resume();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void operate() {
        SkinImagePreloader$PreloadRequest skinImagePreloader$PreloadRequest;
        block21: {
            skinImagePreloader$PreloadRequest = (SkinImagePreloader$PreloadRequest)this.pendingRequests.poll();
            if (skinImagePreloader$PreloadRequest == null) {
                this.thread.suspend();
                return;
            }
            BufferImage bufferImage = null;
            Object object = this.skinImageCache;
            synchronized (object) {
                bufferImage = (BufferImage)this.skinImageCache.get(skinImagePreloader$PreloadRequest.getKey());
            }
            if (bufferImage == null) {
                try {
                    long l;
                    object = this.logger.isTraceEnabled(2) ? this.logger.trace(2) : null;
                    boolean bl = object != null && this.logger.isTraceEnabled(128);
                    NativeImage nativeImage = null;
                    long l2 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
                    nativeImage = skinImagePreloader$PreloadRequest.getFilename() != null ? ServiceManager.imageSPI.loadImageFromSkin(skinImagePreloader$PreloadRequest.getSkinId(), skinImagePreloader$PreloadRequest.getFilename()) : ServiceManager.imageSPI.loadImageFromSkin(skinImagePreloader$PreloadRequest.getSkinId(), skinImagePreloader$PreloadRequest.getImageId());
                    long l3 = l = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
                    if (nativeImage != null) {
                        bufferImage = new BufferImage(skinImagePreloader$PreloadRequest.getKey(), nativeImage.getBuffer(), nativeImage.getFormat(), nativeImage.getWidth(), nativeImage.getHeight());
                        if (!$assertionsDisabled && nativeImage.buffer.capacity() < bufferImage.getByteSize()) {
                            throw new AssertionError((Object)new StringBuffer().append("NativeImage buffer too small: ").append(nativeImage.buffer.remaining()).append(" < ").append(bufferImage.getByteSize()).append(" bytes").toString());
                        }
                        if (object != null) {
                            object.append("SkinImagePreloader(").append(skinImagePreloader$PreloadRequest.getSkinId()).append(", #").append(skinImagePreloader$PreloadRequest.getImageId()).append(") = ").append(bufferImage.getWidth()).append("x").append(bufferImage.getHeight()).append(" Format ").append(bufferImage.getImageFormat()).append(" = ").append(bufferImage.getByteSize()).append(" bytes");
                            if (bl) {
                                object.append(": ").append(l - l2).append("\u00b5s");
                            }
                            object.log();
                        }
                        ImageCache imageCache = this.skinImageCache;
                        synchronized (imageCache) {
                            this.skinImageCache.put(skinImagePreloader$PreloadRequest.getKey(), bufferImage);
                            break block21;
                        }
                    }
                    object = this.logger.error(2);
                    if (skinImagePreloader$PreloadRequest.getFilename() != null) {
                        object.append("loadImageFromSkin(").append(skinImagePreloader$PreloadRequest.getSkinId()).append(", '").append(skinImagePreloader$PreloadRequest.getFilename()).append("') == null");
                    } else {
                        object.append("loadImageFromSkin(").append(skinImagePreloader$PreloadRequest.getSkinId()).append(", ").append(skinImagePreloader$PreloadRequest.getImageId()).append(") == null");
                    }
                    object.log();
                    throw new IOException("ImageSPI.loadImageFromSkin() == null");
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    LogMessage logMessage = this.logger.error(2);
                    if (skinImagePreloader$PreloadRequest.getFilename() != null) {
                        logMessage.append("Invalid filename '").append(skinImagePreloader$PreloadRequest.getFilename()).append("': ").append(illegalArgumentException);
                    } else {
                        logMessage.append("Invalid image id #").append(skinImagePreloader$PreloadRequest.getImageId()).append(": ").append(illegalArgumentException);
                    }
                    logMessage.log();
                }
                catch (IOException iOException) {
                    LogMessage logMessage = this.logger.error(2);
                    if (skinImagePreloader$PreloadRequest.getFilename() != null) {
                        logMessage.append("Unable to load image from file '").append(skinImagePreloader$PreloadRequest.getFilename()).append("' from skin #").append(skinImagePreloader$PreloadRequest.getSkinId()).append(": ").append(iOException);
                    } else {
                        logMessage.append("Unable to load image id #").append(skinImagePreloader$PreloadRequest.getImageId()).append(" from skin #").append(skinImagePreloader$PreloadRequest.getSkinId()).append(": ").append(iOException);
                    }
                    logMessage.log();
                }
            }
        }
        this.preloadRequestPool.releaseObject(skinImagePreloader$PreloadRequest);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void preloadImageFromSkin(int n, String string) {
        long l = SkinImageLoader.calculateHashCode(this.hcb, n, string);
        BufferImage bufferImage = null;
        ImageCache imageCache = this.skinImageCache;
        synchronized (imageCache) {
            bufferImage = (BufferImage)this.skinImageCache.get(l);
        }
        if (bufferImage == null) {
            this.loadImage(l, n, string);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void preloadImageFromSkin(int n, int n2) {
        long l = SkinImageLoader.calculateHashCode(this.hcb, n, n2);
        BufferImage bufferImage = null;
        ImageCache imageCache = this.skinImageCache;
        synchronized (imageCache) {
            bufferImage = (BufferImage)this.skinImageCache.get(l);
        }
        if (bufferImage == null) {
            this.loadImage(l, n, n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void loadImage(long l, int n, String string) {
        try {
            this.thread.suspend();
            Object object = this.pendingRequests;
            synchronized (object) {
                Iterator iterator = this.pendingRequests.iterator();
                while (iterator.hasNext()) {
                    SkinImagePreloader$PreloadRequest skinImagePreloader$PreloadRequest = (SkinImagePreloader$PreloadRequest)iterator.next();
                    if (skinImagePreloader$PreloadRequest.getKey() != l) continue;
                    return;
                }
            }
            this.addRequest(l, n, string, -1);
            if (!this.logger.isTraceEnabled(2)) return;
            object = this.logger.trace(2);
            object.append("Queuing preload request for image from skin '").append(string).append("' from skin #").append(n).log();
            return;
        }
        finally {
            this.thread.resume();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void loadImage(long l, int n, int n2) {
        try {
            this.thread.suspend();
            Object object = this.pendingRequests;
            synchronized (object) {
                Iterator iterator = this.pendingRequests.iterator();
                while (iterator.hasNext()) {
                    SkinImagePreloader$PreloadRequest skinImagePreloader$PreloadRequest = (SkinImagePreloader$PreloadRequest)iterator.next();
                    if (skinImagePreloader$PreloadRequest.getKey() != l) continue;
                    return;
                }
            }
            this.addRequest(l, n, null, n2);
            if (!this.logger.isTraceEnabled(2)) return;
            object = this.logger.trace(2);
            object.append("Queuing preload request for image #").append(n2).append(" from skin #").append(n).log();
            return;
        }
        finally {
            this.thread.resume();
        }
    }

    private void addRequest(long l, int n, String string, int n2) {
        SkinImagePreloader$PreloadRequest skinImagePreloader$PreloadRequest = (SkinImagePreloader$PreloadRequest)this.preloadRequestPool.borrowObject();
        skinImagePreloader$PreloadRequest.setKey(l);
        skinImagePreloader$PreloadRequest.setSkinId(n);
        skinImagePreloader$PreloadRequest.setFilename(string);
        skinImagePreloader$PreloadRequest.setImageId(n2);
        this.pendingRequests.add(skinImagePreloader$PreloadRequest);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$graphics$image$internal$SkinImagePreloader == null ? (class$de$vw$mib$graphics$image$internal$SkinImagePreloader = SkinImagePreloader.class$("de.vw.mib.graphics.image.internal.SkinImagePreloader")) : class$de$vw$mib$graphics$image$internal$SkinImagePreloader).desiredAssertionStatus();
    }
}

