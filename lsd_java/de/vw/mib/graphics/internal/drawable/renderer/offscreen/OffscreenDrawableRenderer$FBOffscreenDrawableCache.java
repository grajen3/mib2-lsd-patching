/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.offscreen;

import de.vw.mib.cache.AbstractCache$Entry;
import de.vw.mib.cache.LRUCache;
import de.vw.mib.cache.policies.UnlimitedCachingPolicy;
import de.vw.mib.graphics.internal.drawable.renderer.offscreen.OffscreenDrawableRenderer$FrameBufferOffscreenDrawable;

final class OffscreenDrawableRenderer$FBOffscreenDrawableCache
extends LRUCache {
    public OffscreenDrawableRenderer$FBOffscreenDrawableCache() {
        super(new UnlimitedCachingPolicy(), true);
    }

    @Override
    protected boolean canEvict(AbstractCache$Entry abstractCache$Entry) {
        OffscreenDrawableRenderer$FrameBufferOffscreenDrawable offscreenDrawableRenderer$FrameBufferOffscreenDrawable = (OffscreenDrawableRenderer$FrameBufferOffscreenDrawable)abstractCache$Entry.getValue();
        return !offscreenDrawableRenderer$FrameBufferOffscreenDrawable.isLocked() && super.canEvict(abstractCache$Entry);
    }

    @Override
    protected void evict(AbstractCache$Entry abstractCache$Entry) {
        OffscreenDrawableRenderer$FrameBufferOffscreenDrawable offscreenDrawableRenderer$FrameBufferOffscreenDrawable = (OffscreenDrawableRenderer$FrameBufferOffscreenDrawable)abstractCache$Entry.getValue();
        offscreenDrawableRenderer$FrameBufferOffscreenDrawable.invalidate();
        super.evict(abstractCache$Entry);
    }
}

