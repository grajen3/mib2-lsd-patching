/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.graphics.font.spi.layout.GlyphLayout;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.util.StringBuilder;

final class CachingTextLayoutManager$PooledGlyphLayout
implements GlyphLayout,
PooledObject {
    private final ObjectPool pool;
    private int glyphId;
    private int sourceIndex;
    private int x;
    private int y;
    private int width;
    private int height;
    private int caretX;

    public CachingTextLayoutManager$PooledGlyphLayout(ObjectPool objectPool) {
        this.pool = objectPool;
    }

    public void set(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        this.glyphId = n;
        this.sourceIndex = n2;
        this.x = n3;
        this.y = n4;
        this.width = n5;
        this.height = n6;
        this.caretX = n7;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[char=").append((char)this.glyphId);
        stringBuilder.append(",glyphId=").append(this.glyphId);
        stringBuilder.append(",sourceIndex=").append(this.sourceIndex);
        stringBuilder.append(",x=").append(this.x);
        stringBuilder.append(",y=").append(this.y);
        stringBuilder.append(",width=").append(this.width);
        stringBuilder.append(",height=").append(this.height);
        stringBuilder.append(",caretX=").append(this.caretX);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void dispose() {
        this.pool.releaseObject(this);
    }

    @Override
    public void backToPool() {
        this.glyphId = 0;
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
        this.caretX = 0;
        this.sourceIndex = 0;
    }

    @Override
    public int getGlyphId() {
        return this.glyphId;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getCaretX() {
        return this.caretX;
    }

    @Override
    public int getSourceIndex() {
        return this.sourceIndex;
    }

    @Override
    public boolean isRightToLeft() {
        return false;
    }
}

