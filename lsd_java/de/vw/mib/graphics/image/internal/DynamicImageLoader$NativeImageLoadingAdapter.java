/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image.internal;

import de.vw.mib.graphics.image.internal.DynamicImageLoader$ImageRequest;
import de.vw.mib.graphics.image.spi.NativeImageLoadingListener;

final class DynamicImageLoader$NativeImageLoadingAdapter
implements NativeImageLoadingListener {
    private final DynamicImageLoader$ImageRequest request;

    public DynamicImageLoader$NativeImageLoadingAdapter(DynamicImageLoader$ImageRequest dynamicImageLoader$ImageRequest) {
        this.request = dynamicImageLoader$ImageRequest;
    }

    @Override
    public void imageLoadingProgress(int n, int n2, int n3, int n4) {
        int n5 = (n3 + n / n2) / n4;
        this.request.getListener().imageLoadingProgress(this.request.getResource(), n5);
    }
}

