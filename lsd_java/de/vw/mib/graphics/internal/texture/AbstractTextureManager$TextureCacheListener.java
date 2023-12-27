/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.texture;

import de.vw.mib.cache.CacheListener;
import de.vw.mib.cache.Cacheable;
import de.vw.mib.graphics.texture.Texture;

final class AbstractTextureManager$TextureCacheListener
implements CacheListener {
    @Override
    public void add(long l, Cacheable cacheable) {
    }

    @Override
    public void clear() {
    }

    @Override
    public void hit(long l, Cacheable cacheable) {
    }

    @Override
    public void miss(long l) {
    }

    @Override
    public void remove(Cacheable cacheable) {
        Texture texture = (Texture)cacheable;
        if (texture != null) {
            texture.dispose();
        }
    }
}

