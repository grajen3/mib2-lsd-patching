/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.texture;

import de.vw.mib.Disposable;
import de.vw.mib.cache.Cacheable;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.internal.texture.TextureAtlas$TexturePage;
import de.vw.mib.graphics.texture.Texture2D;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.util.StringBuilder;

public final class TextureAtlas$SubTexture
implements Cacheable,
Disposable,
PooledObject {
    private final ObjectPool pool;
    private long id;
    private boolean border;
    private TextureAtlas$TexturePage texturePage;
    private Rectangle rectangle;
    private Rectangle borderRectangle;

    public TextureAtlas$SubTexture(ObjectPool objectPool) {
        this.pool = objectPool;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[id=0x").append(Long.toHexString(this.id));
        stringBuilder.append(",border=").append(this.border);
        stringBuilder.append(",texturePage=").append(this.texturePage);
        stringBuilder.append(",rectangle=").append(this.rectangle);
        stringBuilder.append(",borderRectangle=").append(this.borderRectangle);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        this.pool.releaseObject(this);
    }

    @Override
    public int getByteSize() {
        return this.texturePage.getTexture().getByteSize();
    }

    @Override
    public void backToPool() {
        this.texturePage = null;
        this.rectangle = null;
        this.borderRectangle = null;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long l) {
        this.id = l;
    }

    public boolean hasBorder() {
        return this.border;
    }

    public void setBorder(boolean bl) {
        this.border = bl;
    }

    public TextureAtlas$TexturePage getTexturePage() {
        return this.texturePage;
    }

    public void setTexturePage(TextureAtlas$TexturePage textureAtlas$TexturePage) {
        this.texturePage = textureAtlas$TexturePage;
    }

    public Texture2D getTexture() {
        return this.texturePage.getTexture();
    }

    public Rectangle getRectangle() {
        return this.rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Rectangle getBorderRectangle() {
        return this.borderRectangle;
    }

    public void setBorderRectangle(Rectangle rectangle) {
        this.borderRectangle = rectangle;
    }
}

