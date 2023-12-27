/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.ExifInfo;
import de.vw.mib.graphics.image.ImageInfo;
import de.vw.mib.graphics.image.ImageLoadingListener;
import de.vw.mib.graphics.image.UnsupportedImageSizeException;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.DynamicImage;
import de.vw.mib.widgets.internal.ServiceManager;
import org.dsi.ifc.global.ResourceLocator;

public class DynamicImage$ImageLoadingHandler
implements ImageLoadingListener {
    private ExifInfo dynamicExifInfo;
    private BufferImage dynamicImage;
    private int prescaleDenom;
    private boolean waitForExifInformation;
    private final /* synthetic */ DynamicImage this$0;

    public DynamicImage$ImageLoadingHandler(DynamicImage dynamicImage) {
        this.this$0 = dynamicImage;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void newImage(boolean bl) {
        DynamicImage$ImageLoadingHandler dynamicImage$ImageLoadingHandler = this;
        synchronized (dynamicImage$ImageLoadingHandler) {
            this.reset();
            this.waitForExifInformation = bl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void reset() {
        DynamicImage$ImageLoadingHandler dynamicImage$ImageLoadingHandler = this;
        synchronized (dynamicImage$ImageLoadingHandler) {
            this.dynamicImage = null;
            this.dynamicExifInfo = null;
            this.prescaleDenom = 1;
        }
    }

    protected void checkLoadingComplete() {
        if (!(this.dynamicImage == null || this.waitForExifInformation && this.dynamicExifInfo == null)) {
            if (AbstractWidget.LOGGER.isTraceEnabled(4)) {
                LogMessage logMessage = AbstractWidget.LOGGER.trace(4);
                logMessage.append(this.this$0).append(": checkLoadingComplete() Image loading finished.").log();
            }
            this.this$0.imageLoadingSuccess(this.dynamicImage, this.dynamicExifInfo, this.prescaleDenom);
            this.dynamicExifInfo = null;
            this.dynamicImage = null;
        } else if (AbstractWidget.LOGGER.isTraceEnabled(4)) {
            LogMessage logMessage = AbstractWidget.LOGGER.trace(4);
            logMessage.append(this.this$0).append(": checkLoadingComplete() still waiting for further data to load (image/exif)").log();
        }
    }

    protected boolean isResourceRelevant(ResourceLocator resourceLocator) {
        return DynamicImage.resourceEquals(this.this$0.get_imageResource(), resourceLocator);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void exifInfoAvailable(ResourceLocator resourceLocator, int n, int[] nArray, ExifInfo exifInfo) {
        if (this.isResourceRelevant(resourceLocator)) {
            Object object;
            if (AbstractWidget.LOGGER.isTraceEnabled(4)) {
                object = AbstractWidget.LOGGER.trace(4);
                object.append(this.this$0).append(": exifInfoAvailable() Exif-Information loading succesfully finished: ").append(resourceLocator).append(", Exif Orentation:  ").append(exifInfo.getExifValue(274)).log();
            }
            object = this;
            synchronized (object) {
                this.dynamicExifInfo = exifInfo;
                this.checkLoadingComplete();
            }
        } else if (AbstractWidget.LOGGER.isTraceEnabled(4)) {
            LogMessage logMessage = AbstractWidget.LOGGER.trace(4);
            logMessage.append(this.this$0).append(": exifInfoAvailable() Exif-Information loading succesfully finished, but no longer required: ").append(resourceLocator).log();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void exifInfoError(ResourceLocator resourceLocator, int n, int[] nArray, Exception exception) {
        Object object;
        if (this.isResourceRelevant(resourceLocator)) {
            object = this;
            synchronized (object) {
                this.waitForExifInformation = false;
                this.checkLoadingComplete();
            }
        }
        object = AbstractWidget.LOGGER.warn(4);
        object.append(this.this$0).append(": exifInfoError() Error while getting exif info: ").append(resourceLocator);
        if (AbstractWidget.LOGGER.isTraceEnabled(4)) {
            object.attachThrowable(exception);
        }
        object.log();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void imageAvailable(ResourceLocator resourceLocator, BufferImage bufferImage) {
        if (this.isResourceRelevant(resourceLocator)) {
            Object object;
            if (AbstractWidget.LOGGER.isTraceEnabled(4)) {
                object = AbstractWidget.LOGGER.trace(4);
                object.append(this.this$0).append(": imageAvailable() Image data succesfully loaded: ").append(resourceLocator).log();
            }
            object = this;
            synchronized (object) {
                this.dynamicImage = bufferImage;
                this.checkLoadingComplete();
            }
        } else if (AbstractWidget.LOGGER.isTraceEnabled(4)) {
            LogMessage logMessage = AbstractWidget.LOGGER.trace(4);
            logMessage.append(this.this$0).append(": imageAvailable() Image data succesfully loaded, but no longer required: ").append(resourceLocator).log();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void imageError(ResourceLocator resourceLocator, Exception exception) {
        DynamicImage$ImageLoadingHandler dynamicImage$ImageLoadingHandler = this;
        synchronized (dynamicImage$ImageLoadingHandler) {
            this.dynamicExifInfo = null;
            this.processImageLoadingError(resourceLocator, exception);
        }
    }

    @Override
    public void thumbnailImageError(ResourceLocator resourceLocator, Exception exception) {
        this.processImageLoadingError(resourceLocator, exception);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void imageInfoAvailable(ResourceLocator resourceLocator, ImageInfo imageInfo) {
        DynamicImage$ImageLoadingHandler dynamicImage$ImageLoadingHandler = this;
        synchronized (dynamicImage$ImageLoadingHandler) {
            if (this.isResourceRelevant(resourceLocator)) {
                int n;
                int n2;
                int n3 = n2 = this.this$0.getMaxResourceSize();
                int n4 = n = DynamicImage.access$000(this.this$0) ? n2 : this.this$0.getDesiredResourceSize();
                int n5 = imageInfo.getWidth();
                int n6 = imageInfo.getHeight();
                if (n5 > n2 * 8 || n6 > n3 * 8) {
                    this.imageError(resourceLocator, new UnsupportedImageSizeException(n5, n6));
                } else {
                    int n7 = Util.nextPowerOfTwo(Math.max(Util.divideAndCeil(n5, n2), Util.divideAndCeil(n6, n3)));
                    int n8 = n > 0 && n4 > 0 ? DynamicImage.getNextAllowedScaleDenominator(Math.max(n5 / n, n6 / n4)) : 1;
                    int n9 = Math.max(n7, n8);
                    if (AbstractWidget.LOGGER.isTraceEnabled(4)) {
                        LogMessage logMessage = AbstractWidget.LOGGER.trace(4);
                        logMessage.append(this.this$0);
                        logMessage.append(": imageInfoAvailable( ) '").append(resourceLocator);
                        logMessage.append("'): original size ").append(n5).append("*").append(n6);
                        logMessage.append(" scaling by 1/").append(n9);
                        logMessage.append(" (").append(n5 / n9).append("*").append(n6 / n9);
                        logMessage.append(")");
                        logMessage.log();
                    }
                    this.prescaleDenom = n9;
                    boolean bl = false;
                    ServiceManager.imageManager.getImageFromResource(resourceLocator, this, false, n9);
                }
            }
        }
    }

    @Override
    public void imageInfoError(ResourceLocator resourceLocator, Exception exception) {
        this.processImageLoadingError(resourceLocator, exception);
    }

    @Override
    public void imageLoadingProgress(ResourceLocator resourceLocator, int n) {
    }

    @Override
    public void thumbnailImageAvailable(ResourceLocator resourceLocator, BufferImage bufferImage) {
        this.imageAvailable(resourceLocator, bufferImage);
    }

    private void processImageLoadingError(ResourceLocator resourceLocator, Exception exception) {
        if (this.isResourceRelevant(resourceLocator)) {
            LogMessage logMessage = AbstractWidget.LOGGER.warn(4);
            logMessage.append(this.this$0).append(": Error while loading image: ").append(resourceLocator);
            if (AbstractWidget.LOGGER.isTraceEnabled(4)) {
                logMessage.attachThrowable(exception);
            }
            logMessage.log();
            this.this$0.imageLoadingFailure();
        } else if (AbstractWidget.LOGGER.isTraceEnabled(4)) {
            LogMessage logMessage = AbstractWidget.LOGGER.warn(4);
            logMessage.append(this.this$0).append(": Error while loading image (no longer required): ").append(resourceLocator).attachThrowable(exception).log();
        }
    }
}

