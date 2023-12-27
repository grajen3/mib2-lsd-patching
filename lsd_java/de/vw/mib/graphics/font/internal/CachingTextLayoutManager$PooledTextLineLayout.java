/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.graphics.font.internal.CachingTextLayoutManager$PooledGlyphLayout;
import de.vw.mib.graphics.font.spi.layout.GlyphLayout;
import de.vw.mib.graphics.font.spi.layout.TextLineLayout;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.util.StringBuilder;
import java.util.List;

final class CachingTextLayoutManager$PooledTextLineLayout
implements TextLineLayout,
PooledObject {
    private final ObjectPool pool;
    private int baseline;
    private int left;
    private int top;
    private int bottom;
    private List glyphLayouts;

    public CachingTextLayoutManager$PooledTextLineLayout(ObjectPool objectPool) {
        this.pool = objectPool;
    }

    public void set(int n, int n2, int n3, int n4, List list) {
        this.baseline = n;
        this.left = n2;
        this.top = n3;
        this.bottom = n4;
        this.glyphLayouts = list;
    }

    public void dispose() {
        if (this.glyphLayouts != null) {
            for (int i2 = this.glyphLayouts.size() - 1; i2 >= 0; --i2) {
                CachingTextLayoutManager$PooledGlyphLayout cachingTextLayoutManager$PooledGlyphLayout = (CachingTextLayoutManager$PooledGlyphLayout)this.glyphLayouts.get(i2);
                cachingTextLayoutManager$PooledGlyphLayout.dispose();
            }
            this.glyphLayouts.clear();
        }
        this.pool.releaseObject(this);
    }

    @Override
    public void backToPool() {
        this.glyphLayouts = null;
        this.baseline = 0;
        this.left = 0;
        this.top = 0;
        this.bottom = 0;
    }

    @Override
    public int getLeft() {
        return this.left;
    }

    @Override
    public int getTop() {
        return this.top;
    }

    @Override
    public int getBottom() {
        return this.bottom;
    }

    @Override
    public int getBaseline() {
        return this.baseline;
    }

    protected void setBaseline(int n) {
        this.baseline = n;
    }

    @Override
    public int getGlyphCount() {
        return this.glyphLayouts.size();
    }

    @Override
    public GlyphLayout getGlyph(int n) {
        return (GlyphLayout)this.glyphLayouts.get(n);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[top=").append(this.top);
        stringBuilder.append(",bottom=").append(this.bottom);
        stringBuilder.append(",left=").append(this.left);
        stringBuilder.append(",baseline=").append(this.baseline);
        stringBuilder.append(",glyphLayouts=");
        for (int i2 = 0; i2 < this.glyphLayouts.size(); ++i2) {
            stringBuilder.append(this.glyphLayouts.get(i2));
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

