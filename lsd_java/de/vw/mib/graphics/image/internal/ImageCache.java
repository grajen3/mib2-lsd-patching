/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image.internal;

import de.vw.mib.cache.AbstractCache$Entry;
import de.vw.mib.cache.LRUCache;
import de.vw.mib.cache.policies.CumulativeObjectSizeCachingPolicy;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.nio.ByteBuffer;

public final class ImageCache
extends LRUCache {
    private final Logger logger;
    private final int maximumCacheSizeBytes;

    public ImageCache(Logger logger, int n) {
        super(new CumulativeObjectSizeCachingPolicy(n), true);
        this.logger = logger;
        this.maximumCacheSizeBytes = n;
    }

    @Override
    protected boolean canEvict(AbstractCache$Entry abstractCache$Entry) {
        BufferImage bufferImage = (BufferImage)abstractCache$Entry.getValue();
        return !bufferImage.isReferenced();
    }

    @Override
    protected void evict(AbstractCache$Entry abstractCache$Entry) {
        BufferImage bufferImage = (BufferImage)abstractCache$Entry.getValue();
        ByteBuffer byteBuffer = bufferImage.getBuffer();
        if (this.logger.isTraceEnabled(32768)) {
            LogMessage logMessage = this.logger.trace(32768);
            logMessage.append("Evicting image ").append(bufferImage).append(" from cache");
            logMessage.log();
        }
        if (byteBuffer != null) {
            ServiceManager.imageSPI.releaseImage(byteBuffer);
        }
        bufferImage.dispose();
        super.evict(abstractCache$Entry);
    }

    public int getMaximumCacheSizeBytes() {
        return this.maximumCacheSizeBytes;
    }
}

