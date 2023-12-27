/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.texture;

import de.vw.mib.cache.Cacheable;
import de.vw.mib.cache.LRUCache;
import de.vw.mib.cache.policies.CumulativeObjectSizeCachingPolicy;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.texture.Texture;

public final class TextureCache
extends LRUCache {
    private static final int DEFAULT_TEXTURE_CACHE_SIZE_LIMIT_KB;
    private static final int TEXTURE_CACHE_SIZE_BYTES;
    private final HashCodeBuilder hcb = new HashCodeBuilder();

    public TextureCache() {
        super(new CumulativeObjectSizeCachingPolicy(TEXTURE_CACHE_SIZE_BYTES), true);
    }

    public Texture get(BufferImage[] bufferImageArray) {
        this.hcb.reset();
        this.hcb.append(bufferImageArray);
        long l = this.hcb.longHashCode();
        return (Texture)this.get(l);
    }

    public void put(BufferImage[] bufferImageArray, Texture texture) {
        this.hcb.reset();
        this.hcb.append(bufferImageArray);
        long l = this.hcb.longHashCode();
        this.put(l, (Cacheable)texture);
    }

    public int getMaximumCacheSizeBytes() {
        return TEXTURE_CACHE_SIZE_BYTES;
    }

    static {
        TEXTURE_CACHE_SIZE_BYTES = Integer.getInteger("de.vw.mib.graphics.texturecachesizekb", 16384) * 1024;
    }
}

