/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.graphics.font.internal.CachingTextLayoutManager$AbstractPooledTextLayout;
import de.vw.mib.graphics.font.spi.layout.TextLayout;
import de.vw.mib.graphics.font.spi.layout.TextLineLayout;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.pool.PooledObject;

final class CachingTextLayoutManager$PooledNativeTextLayout
extends CachingTextLayoutManager$AbstractPooledTextLayout
implements PooledObject {
    private TextLayout textLayout;

    public CachingTextLayoutManager$PooledNativeTextLayout(ObjectPool objectPool) {
        super(objectPool);
    }

    public void set(String string, long l, TextLayout textLayout) {
        super.set(string, l);
        this.textLayout = textLayout;
    }

    @Override
    public void backToPool() {
        this.textLayout = null;
        super.backToPool();
    }

    @Override
    public boolean isTruncated() {
        return this.textLayout.isTruncated();
    }

    @Override
    public int getWidth() {
        return this.textLayout.getWidth();
    }

    @Override
    public int getHeight() {
        return this.textLayout.getHeight();
    }

    @Override
    public int getLineCount() {
        return this.textLayout.getLineCount();
    }

    @Override
    public TextLineLayout getTextLine(int n) {
        return this.textLayout.getTextLine(n);
    }

    @Override
    public boolean isGlyphIdCharacterCode() {
        return false;
    }
}

