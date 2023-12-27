/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image.internal;

import de.vw.mib.graphics.image.ImageLoadingListener;
import de.vw.mib.pool.PooledObject;
import org.dsi.ifc.global.ResourceLocator;

final class DynamicImageLoader$ImageRequest
implements PooledObject {
    public static final int REQUEST_TYPE_IMAGE_INFO;
    public static final int REQUEST_TYPE_IMAGE;
    public static final int REQUEST_TYPE_THUMBNAIL;
    public static final int REQUEST_TYPE_EXIF;
    private int requestType;
    private ResourceLocator resource;
    private ImageLoadingListener listener;
    private boolean reportProgress;
    private int scaleDenom;
    private long hashCode;
    private int[] tags;
    private int ifd;

    @Override
    public void backToPool() {
        this.resource = null;
        this.listener = null;
        this.reportProgress = false;
        this.scaleDenom = 1;
        this.hashCode = 0L;
        this.tags = null;
    }

    public void setIfd(int n) {
        this.ifd = n;
    }

    public int getIfd() {
        return this.ifd;
    }

    public void setTags(int[] nArray) {
        this.tags = nArray;
    }

    public int[] getTags() {
        return this.tags;
    }

    public int getRequestType() {
        return this.requestType;
    }

    public void setRequestType(int n) {
        this.requestType = n;
    }

    public ResourceLocator getResource() {
        return this.resource;
    }

    public void setResource(ResourceLocator resourceLocator) {
        this.resource = resourceLocator;
    }

    public ImageLoadingListener getListener() {
        return this.listener;
    }

    public void setListener(ImageLoadingListener imageLoadingListener) {
        this.listener = imageLoadingListener;
    }

    public boolean isReportProgress() {
        return this.reportProgress;
    }

    public void setReportProgress(boolean bl) {
        this.reportProgress = bl;
    }

    public int getScaleDenom() {
        return this.scaleDenom;
    }

    public void setScaleDenom(int n) {
        this.scaleDenom = n;
    }

    public long getHashCode() {
        return this.hashCode;
    }

    public void setHashCode(long l) {
        this.hashCode = l;
    }
}

