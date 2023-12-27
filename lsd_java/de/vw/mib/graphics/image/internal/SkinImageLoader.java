/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image.internal;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.longs.LongIntMap;
import de.vw.mib.collections.longs.LongIntOptHashMap;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.internal.ImageCache;
import de.vw.mib.graphics.image.internal.ImageLoader;
import de.vw.mib.graphics.image.internal.ServiceManager;
import de.vw.mib.graphics.image.internal.SkinImagePreloader;
import de.vw.mib.graphics.image.spi.NativeImage;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;
import java.io.File;
import java.io.IOException;

public final class SkinImageLoader
implements ImageLoader {
    private final Logger logger;
    private final ImageCache skinImageCache;
    private final SkinImagePreloader skinImagePreloader;
    private final HashCodeBuilder hcb;
    private LongIntMap commonSkinImageIDMap;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$image$internal$SkinImageLoader;

    public SkinImageLoader(Logger logger, ImageCache imageCache, SkinImagePreloader skinImagePreloader) {
        this.logger = logger;
        this.skinImageCache = imageCache;
        this.skinImagePreloader = skinImagePreloader;
        this.hcb = new HashCodeBuilder();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public BufferImage getImageFromSkin(int n, int n2) {
        BufferImage bufferImage;
        block23: {
            Object object;
            long l = SkinImageLoader.calculateHashCode(this.hcb, n, n2);
            bufferImage = null;
            if (this.skinImagePreloader != null) {
                object = this.skinImageCache;
                synchronized (object) {
                    bufferImage = (BufferImage)this.skinImageCache.get(l);
                }
            } else {
                bufferImage = (BufferImage)this.skinImageCache.get(l);
            }
            if (bufferImage == null) {
                if (this.skinImagePreloader != null) {
                    this.skinImagePreloader.suspend();
                }
                try {
                    object = null;
                    try {
                        long l2;
                        LogMessage logMessage = this.logger.isTraceEnabled(1) ? this.logger.trace(1) : null;
                        boolean bl = logMessage != null && this.logger.isTraceEnabled(128);
                        long l3 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
                        object = ServiceManager.imageSPI.loadImageFromSkin(n, n2);
                        long l4 = l2 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
                        if (object != null) {
                            bufferImage = new BufferImage(l, ((NativeImage)object).getBuffer(), ((NativeImage)object).getFormat(), ((NativeImage)object).getWidth(), ((NativeImage)object).getHeight());
                            if (!$assertionsDisabled && ((NativeImage)object).buffer.capacity() < bufferImage.getByteSize()) {
                                throw new AssertionError((Object)new StringBuffer().append("NativeImage buffer too small: ").append(((NativeImage)object).buffer.remaining()).append(" < ").append(bufferImage.getByteSize()).append(" bytes").toString());
                            }
                            if (logMessage != null) {
                                logMessage.append("getImageFromSkin(").append(n).append(", #").append(n2).append(") = ").append(bufferImage.getWidth()).append("x").append(bufferImage.getHeight()).append(" Format ").append(bufferImage.getImageFormat()).append(" = ").append(bufferImage.getByteSize()).append(" bytes");
                                if (bl) {
                                    logMessage.append(": ").append(l2 - l3).append("\u00b5s");
                                }
                                logMessage.log();
                            }
                            if (this.skinImagePreloader != null) {
                                ImageCache imageCache = this.skinImageCache;
                                synchronized (imageCache) {
                                    this.skinImageCache.put(l, bufferImage);
                                    break block23;
                                }
                            }
                            this.skinImageCache.put(l, bufferImage);
                            break block23;
                        }
                        logMessage = this.logger.error(1);
                        logMessage.append("loadImageFromSkin(").append(n).append(", '").append(n2).append("') == null").log();
                        throw new IOException("ImageSPI.loadImageFromSkin() == null");
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        throw new IOException(illegalArgumentException.getMessage());
                    }
                }
                catch (IOException iOException) {
                    throw iOException;
                }
                finally {
                    if (this.skinImagePreloader != null) {
                        this.skinImagePreloader.resume();
                    }
                }
            }
        }
        return bufferImage;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public BufferImage getImageFromSkin(int n, String string) {
        BufferImage bufferImage;
        block23: {
            Object object;
            long l = SkinImageLoader.calculateHashCode(this.hcb, n, string);
            bufferImage = null;
            if (this.skinImagePreloader != null) {
                object = this.skinImageCache;
                synchronized (object) {
                    bufferImage = (BufferImage)this.skinImageCache.get(l);
                }
            } else {
                bufferImage = (BufferImage)this.skinImageCache.get(l);
            }
            if (bufferImage == null) {
                if (this.skinImagePreloader != null) {
                    this.skinImagePreloader.suspend();
                }
                try {
                    object = null;
                    try {
                        long l2;
                        LogMessage logMessage = this.logger.isTraceEnabled(1) ? this.logger.trace(1) : null;
                        boolean bl = logMessage != null && this.logger.isTraceEnabled(128);
                        long l3 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
                        object = ServiceManager.imageSPI.loadImageFromSkin(n, string);
                        long l4 = l2 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
                        if (object != null) {
                            bufferImage = new BufferImage(l, ((NativeImage)object).getBuffer(), ((NativeImage)object).getFormat(), ((NativeImage)object).getWidth(), ((NativeImage)object).getHeight());
                            if (!$assertionsDisabled && ((NativeImage)object).buffer.capacity() < bufferImage.getByteSize()) {
                                throw new AssertionError((Object)new StringBuffer().append("NativeImage buffer too small: ").append(((NativeImage)object).buffer.remaining()).append(" < ").append(bufferImage.getByteSize()).append(" bytes").toString());
                            }
                            if (logMessage != null) {
                                logMessage.append("getImageFromSkin(").append(n).append(", '").append(string).append("') = ").append(bufferImage.getWidth()).append("x").append(bufferImage.getHeight()).append(" Format ").append(bufferImage.getImageFormat()).append(" = ").append(bufferImage.getByteSize()).append(" bytes");
                                if (bl) {
                                    logMessage.append(": ").append(l2 - l3).append("\u00b5s");
                                }
                                logMessage.log();
                            }
                            if (this.skinImagePreloader != null) {
                                ImageCache imageCache = this.skinImageCache;
                                synchronized (imageCache) {
                                    this.skinImageCache.put(l, bufferImage);
                                    break block23;
                                }
                            }
                            this.skinImageCache.put(l, bufferImage);
                            break block23;
                        }
                        logMessage = this.logger.error(1);
                        logMessage.append("loadImageFromSkin(").append(n).append(", '").append(string).append("') == null").log();
                        throw new IOException("ImageSPI.loadImageFromSkin() == null");
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        throw new IOException(illegalArgumentException.getMessage());
                    }
                }
                catch (IOException iOException) {
                    throw iOException;
                }
                finally {
                    if (this.skinImagePreloader != null) {
                        this.skinImagePreloader.resume();
                    }
                }
            }
        }
        return bufferImage;
    }

    public BufferImage getImageFromCommonSkin(String string) {
        Object object;
        int n = ServiceManager.configurationManager.getCommonSkinId();
        if (this.logger.isTraceEnabled(1)) {
            object = this.logger.trace(1);
            object.append("getImageFromCommonSkin(filename=").append(string).append(")").log();
        }
        if (this.commonSkinImageIDMap == null) {
            object = new StringBuilder(256);
            ((StringBuilder)object).append(ServiceManager.configurationManager.getSkinPath(n));
            ((StringBuilder)object).append("/");
            ((StringBuilder)object).append("imageidmap.res");
            String string2 = ((StringBuilder)object).toString();
            File file = new File(string2);
            if (file.exists()) {
                Object[] objectArray = ServiceManager.fileManager.readDataFromObjectSwapperFile(file);
                int[] nArray = (int[])objectArray[0];
                String[] stringArray = (String[])objectArray[1];
                int[] nArray2 = (int[])objectArray[2];
                int n2 = stringArray.length;
                this.commonSkinImageIDMap = new LongIntOptHashMap(stringArray.length);
                for (int i2 = 0; i2 < n2; ++i2) {
                    this.hcb.reset();
                    this.hcb.append(stringArray[i2]);
                    this.commonSkinImageIDMap.put(this.hcb.longHashCode(), nArray2[i2]);
                }
                ServiceManager.imageSPI.setContentFileForSkin(ServiceManager.configurationManager.getCommonSkinId(), "images.mcf");
            }
        }
        if (this.commonSkinImageIDMap != null) {
            this.hcb.reset();
            this.hcb.append(string);
            long l = this.hcb.longHashCode();
            if (this.commonSkinImageIDMap.containsKey(l)) {
                return this.getImageFromSkin(n, this.commonSkinImageIDMap.get(l));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        return this.getImageFromSkin(n, stringBuilder.toString());
    }

    static long calculateHashCode(HashCodeBuilder hashCodeBuilder, int n, String string) {
        return hashCodeBuilder.reset().append(n).append(string).longHashCode();
    }

    static long calculateHashCode(HashCodeBuilder hashCodeBuilder, int n, int n2) {
        return hashCodeBuilder.reset().append(n).append(n2).longHashCode();
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$image$internal$SkinImageLoader == null ? (class$de$vw$mib$graphics$image$internal$SkinImageLoader = SkinImageLoader.class$("de.vw.mib.graphics.image.internal.SkinImageLoader")) : class$de$vw$mib$graphics$image$internal$SkinImageLoader).desiredAssertionStatus();
    }
}

