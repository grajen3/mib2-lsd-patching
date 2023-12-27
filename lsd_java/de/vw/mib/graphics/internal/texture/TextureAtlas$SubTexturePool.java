/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.texture;

import de.vw.mib.graphics.internal.texture.TextureAtlas$SubTexture;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractUnsynchronizedObjectPool;

final class TextureAtlas$SubTexturePool
extends AbstractUnsynchronizedObjectPool {
    public TextureAtlas$SubTexturePool(int n) {
        super(n);
    }

    @Override
    protected PooledObject createObjectInternal() {
        return new TextureAtlas$SubTexture(this);
    }
}

