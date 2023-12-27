/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.graphics.font.internal.CachingTextLayoutManager$AbstractPooledTextLayout;
import de.vw.mib.graphics.font.internal.CachingTextLayoutManager$PooledTextLineLayout;
import de.vw.mib.graphics.font.spi.layout.TextLineLayout;
import de.vw.mib.pool.ObjectPool;
import java.util.List;

final class CachingTextLayoutManager$PooledTextLayout
extends CachingTextLayoutManager$AbstractPooledTextLayout {
    private boolean truncated;
    private int width;
    private int height;
    private List textLineLayouts;

    public CachingTextLayoutManager$PooledTextLayout(ObjectPool objectPool) {
        super(objectPool);
    }

    public CachingTextLayoutManager$PooledTextLayout(String string, long l, int n, int n2, boolean bl, List list) {
        super(null);
        this.set(string, l, n, n2, bl, list);
    }

    public void set(String string, long l, int n, int n2, boolean bl, List list) {
        super.set(string, l);
        this.truncated = bl;
        this.width = n;
        this.height = n2;
        this.textLineLayouts = list;
    }

    @Override
    public void backToPool() {
        this.truncated = false;
        this.width = 0;
        this.height = 0;
        if (this.textLineLayouts != null) {
            for (int i2 = this.textLineLayouts.size() - 1; i2 >= 0; --i2) {
                CachingTextLayoutManager$PooledTextLineLayout cachingTextLayoutManager$PooledTextLineLayout = (CachingTextLayoutManager$PooledTextLineLayout)this.textLineLayouts.get(i2);
                cachingTextLayoutManager$PooledTextLineLayout.dispose();
            }
            this.textLineLayouts.clear();
            this.textLineLayouts = null;
        }
        super.backToPool();
    }

    @Override
    public boolean isTruncated() {
        return this.truncated;
    }

    @Override
    public int getLineCount() {
        return this.textLineLayouts.size();
    }

    @Override
    public TextLineLayout getTextLine(int n) {
        return (TextLineLayout)this.textLineLayouts.get(n);
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
    public boolean isGlyphIdCharacterCode() {
        return true;
    }
}

