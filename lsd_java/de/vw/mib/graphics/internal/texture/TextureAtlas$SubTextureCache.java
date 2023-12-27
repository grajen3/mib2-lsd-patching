/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.texture;

import de.vw.mib.cache.AbstractCache$Entry;
import de.vw.mib.cache.LRUCache;
import de.vw.mib.cache.policies.UnlimitedCachingPolicy;
import de.vw.mib.graphics.internal.texture.TextureAtlas;
import de.vw.mib.graphics.internal.texture.TextureAtlas$SubTexture;

final class TextureAtlas$SubTextureCache
extends LRUCache {
    private final TextureAtlas textureAtlas;
    private final /* synthetic */ TextureAtlas this$0;

    public TextureAtlas$SubTextureCache(TextureAtlas textureAtlas, TextureAtlas textureAtlas2) {
        this.this$0 = textureAtlas;
        super(new UnlimitedCachingPolicy(), true);
        this.textureAtlas = textureAtlas2;
    }

    @Override
    protected boolean canEvict(AbstractCache$Entry abstractCache$Entry) {
        return !this.textureAtlas.isSubTextureLocked((TextureAtlas$SubTexture)abstractCache$Entry.getValue());
    }

    @Override
    protected void evict(AbstractCache$Entry abstractCache$Entry) {
        TextureAtlas$SubTexture textureAtlas$SubTexture = (TextureAtlas$SubTexture)abstractCache$Entry.getValue();
        textureAtlas$SubTexture.getTexturePage().removeSubTexture(textureAtlas$SubTexture);
        this.this$0.fireSubTextureRemoved(textureAtlas$SubTexture);
        textureAtlas$SubTexture.dispose();
        super.evict(abstractCache$Entry);
    }
}

