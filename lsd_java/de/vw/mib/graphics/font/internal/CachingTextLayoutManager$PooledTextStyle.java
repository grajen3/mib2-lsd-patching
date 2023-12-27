/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.font.internal.CachingTextLayoutManager;
import de.vw.mib.graphics.font.spi.style.GlyphStyle;
import de.vw.mib.graphics.font.style.TextStyle;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.util.StringBuilder;

public final class CachingTextLayoutManager$PooledTextStyle
implements TextStyle,
PooledObject {
    private static HashCodeBuilder hcb;
    private final ObjectPool pool;
    private int lineSpacing;
    private int horizontalAlignment;
    private int linebreakMode;
    private int startIndex;
    private int endIndex;
    private de.vw.mib.graphics.font.style.GlyphStyle glyphStyle;
    private int references;
    static final /* synthetic */ boolean $assertionsDisabled;

    public CachingTextLayoutManager$PooledTextStyle(ObjectPool objectPool) {
        this.pool = objectPool;
    }

    public void set(int n, int n2, int n3, int n4, int n5, de.vw.mib.graphics.font.style.GlyphStyle glyphStyle) {
        this.lineSpacing = n;
        this.horizontalAlignment = n2;
        this.linebreakMode = n3;
        this.startIndex = n4;
        this.endIndex = n5;
        this.glyphStyle = glyphStyle;
        this.references = 1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[lineSpacing=").append(this.lineSpacing);
        stringBuilder.append(",horizontalAlignment=").append(this.horizontalAlignment);
        stringBuilder.append(",linebreakMode=").append(this.linebreakMode);
        stringBuilder.append(",startIndex=").append(this.startIndex);
        stringBuilder.append(",endIndex=").append(this.endIndex);
        stringBuilder.append(",glyphStyle=").append(this.glyphStyle);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int hashCode() {
        if (hcb == null) {
            hcb = new HashCodeBuilder();
        }
        hcb.reset();
        hcb.append(this.lineSpacing);
        hcb.append(this.horizontalAlignment);
        hcb.append(this.linebreakMode);
        hcb.append(this.startIndex);
        hcb.append(this.endIndex);
        hcb.append(this.glyphStyle);
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            CachingTextLayoutManager$PooledTextStyle cachingTextLayoutManager$PooledTextStyle = (CachingTextLayoutManager$PooledTextStyle)object;
            return this.lineSpacing == cachingTextLayoutManager$PooledTextStyle.lineSpacing && this.horizontalAlignment == cachingTextLayoutManager$PooledTextStyle.horizontalAlignment && this.linebreakMode == cachingTextLayoutManager$PooledTextStyle.linebreakMode && this.startIndex == cachingTextLayoutManager$PooledTextStyle.startIndex && this.endIndex == cachingTextLayoutManager$PooledTextStyle.endIndex && this.glyphStyle.equals(cachingTextLayoutManager$PooledTextStyle.glyphStyle);
        }
        return false;
    }

    @Override
    public void dispose() {
        if (!$assertionsDisabled && this.references <= 0) {
            throw new AssertionError((Object)"PooledTextStyle.dispose(): Reference count <= 0");
        }
        if (--this.references == 0) {
            if (this.glyphStyle != null) {
                this.glyphStyle.dispose();
                this.glyphStyle = null;
            }
            this.pool.releaseObject(this);
        }
    }

    @Override
    public boolean isReferenced() {
        return this.references > 1;
    }

    @Override
    public void reference() {
        ++this.references;
    }

    @Override
    public void backToPool() {
        this.lineSpacing = 0;
        this.horizontalAlignment = 0;
        this.startIndex = 0;
        this.endIndex = 0;
        this.linebreakMode = 0;
        this.glyphStyle = null;
    }

    @Override
    public int getLineSpacing() {
        return this.lineSpacing;
    }

    @Override
    public int getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    @Override
    public int getStartIndex() {
        return this.startIndex;
    }

    @Override
    public int getEndIndex() {
        return this.endIndex;
    }

    @Override
    public GlyphStyle getGlyphStyle() {
        return this.glyphStyle;
    }

    @Override
    public de.vw.mib.graphics.font.style.GlyphStyle getFontGlyphStyle() {
        return this.glyphStyle;
    }

    @Override
    public int getLinebreakMode() {
        return this.linebreakMode;
    }

    static {
        $assertionsDisabled = !(CachingTextLayoutManager.class$de$vw$mib$graphics$font$internal$CachingTextLayoutManager == null ? (CachingTextLayoutManager.class$de$vw$mib$graphics$font$internal$CachingTextLayoutManager = CachingTextLayoutManager.class$("de.vw.mib.graphics.font.internal.CachingTextLayoutManager")) : CachingTextLayoutManager.class$de$vw$mib$graphics$font$internal$CachingTextLayoutManager).desiredAssertionStatus();
    }
}

