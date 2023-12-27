/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.shader;

import de.vw.mib.cache.LRUCache;
import de.vw.mib.cache.policies.UnlimitedCachingPolicy;

final class ShaderFactory$ShaderSourceCache
extends LRUCache {
    public ShaderFactory$ShaderSourceCache() {
        super(new UnlimitedCachingPolicy(), false);
    }
}

