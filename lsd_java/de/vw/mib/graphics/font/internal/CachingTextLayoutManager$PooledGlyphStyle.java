/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.font.internal.CachingTextLayoutManager;
import de.vw.mib.graphics.font.style.GlyphStyle;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.util.StringBuilder;

public final class CachingTextLayoutManager$PooledGlyphStyle
implements GlyphStyle,
PooledObject {
    private static int STYLE_FLAG_UNDERLINE;
    private static int STYLE_FLAG_STRIKE_OUT;
    private static int STYLE_FLAG_OVERLINE;
    private static int STYLE_FLAG_ITALIC;
    private static int STYLE_FLAG_BOLD;
    private static int STYLE_FLAG_DISABLE_BC_HINTING;
    private static int STYLE_FLAG_DISABLE_HINTING;
    private static HashCodeBuilder hcb;
    private final ObjectPool pool;
    private int fontId;
    private int fontSize;
    private int styleFlags;
    private int references;
    static final /* synthetic */ boolean $assertionsDisabled;

    public CachingTextLayoutManager$PooledGlyphStyle(ObjectPool objectPool) {
        this.pool = objectPool;
    }

    public void set(int n, int n2, int n3) {
        this.set(n, n2, (n3 & 1) != 0, (n3 & 2) != 0, (n3 & 4) != 0, (n3 & 8) != 0, (n3 & 0x10) != 0, (n3 & 0x100) != 0, (n3 & 0x800000) != 0);
    }

    public void set(int n, int n2, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
        this.fontId = n;
        this.fontSize = n2;
        int n3 = 0;
        if (bl3) {
            n3 = CachingTextLayoutManager$PooledGlyphStyle.setFlag(n3, STYLE_FLAG_UNDERLINE);
        }
        if (bl4) {
            n3 = CachingTextLayoutManager$PooledGlyphStyle.setFlag(n3, STYLE_FLAG_OVERLINE);
        }
        if (bl4) {
            n3 = CachingTextLayoutManager$PooledGlyphStyle.setFlag(n3, STYLE_FLAG_STRIKE_OUT);
        }
        if (bl2) {
            n3 = CachingTextLayoutManager$PooledGlyphStyle.setFlag(n3, STYLE_FLAG_ITALIC);
        }
        if (bl) {
            n3 = CachingTextLayoutManager$PooledGlyphStyle.setFlag(n3, STYLE_FLAG_BOLD);
        }
        if (bl6) {
            n3 = CachingTextLayoutManager$PooledGlyphStyle.setFlag(n3, STYLE_FLAG_DISABLE_BC_HINTING);
        }
        if (bl7) {
            n3 = CachingTextLayoutManager$PooledGlyphStyle.setFlag(n3, STYLE_FLAG_DISABLE_HINTING);
        }
        this.styleFlags = n3;
        this.references = 1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[fontId=").append(this.fontId);
        stringBuilder.append(",fontSize=").append(this.fontSize);
        stringBuilder.append(",styleFlags=").append(this.styleFlags);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int hashCode() {
        if (hcb == null) {
            hcb = new HashCodeBuilder();
        }
        hcb.reset();
        hcb.append(this.fontId);
        hcb.append(this.fontSize);
        hcb.append(this.styleFlags);
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            CachingTextLayoutManager$PooledGlyphStyle cachingTextLayoutManager$PooledGlyphStyle = (CachingTextLayoutManager$PooledGlyphStyle)object;
            return this.fontId == cachingTextLayoutManager$PooledGlyphStyle.fontId && this.fontSize == cachingTextLayoutManager$PooledGlyphStyle.fontSize && this.styleFlags == cachingTextLayoutManager$PooledGlyphStyle.styleFlags;
        }
        return false;
    }

    @Override
    public void dispose() {
        if (!$assertionsDisabled && this.references <= 0) {
            throw new AssertionError((Object)"PooledGlyphStyle.dispose(): Reference count <= 0");
        }
        if (--this.references == 0) {
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
        this.fontId = -1;
        this.styleFlags = 0;
        this.fontSize = 0;
    }

    @Override
    public int getFontId() {
        return this.fontId;
    }

    @Override
    public int getFontSize() {
        return this.fontSize;
    }

    @Override
    public boolean isBold() {
        return CachingTextLayoutManager$PooledGlyphStyle.isFlagSet(this.styleFlags, STYLE_FLAG_BOLD);
    }

    @Override
    public boolean isUnderline() {
        return CachingTextLayoutManager$PooledGlyphStyle.isFlagSet(this.styleFlags, STYLE_FLAG_UNDERLINE);
    }

    @Override
    public boolean isStrikeOut() {
        return CachingTextLayoutManager$PooledGlyphStyle.isFlagSet(this.styleFlags, STYLE_FLAG_STRIKE_OUT);
    }

    @Override
    public boolean isOverline() {
        return CachingTextLayoutManager$PooledGlyphStyle.isFlagSet(this.styleFlags, STYLE_FLAG_OVERLINE);
    }

    @Override
    public boolean isItalic() {
        return CachingTextLayoutManager$PooledGlyphStyle.isFlagSet(this.styleFlags, STYLE_FLAG_ITALIC);
    }

    @Override
    public boolean isByteCodeHintingDisabled() {
        return CachingTextLayoutManager$PooledGlyphStyle.isFlagSet(this.styleFlags, STYLE_FLAG_DISABLE_BC_HINTING);
    }

    @Override
    public boolean isHintingDisabled() {
        return CachingTextLayoutManager$PooledGlyphStyle.isFlagSet(this.styleFlags, STYLE_FLAG_DISABLE_HINTING);
    }

    private static int setFlag(int n, int n2) {
        return n | n2;
    }

    private static boolean isFlagSet(int n, int n2) {
        return (n & n2) != 0;
    }

    static {
        $assertionsDisabled = !(CachingTextLayoutManager.class$de$vw$mib$graphics$font$internal$CachingTextLayoutManager == null ? (CachingTextLayoutManager.class$de$vw$mib$graphics$font$internal$CachingTextLayoutManager = CachingTextLayoutManager.class$("de.vw.mib.graphics.font.internal.CachingTextLayoutManager")) : CachingTextLayoutManager.class$de$vw$mib$graphics$font$internal$CachingTextLayoutManager).desiredAssertionStatus();
        STYLE_FLAG_UNDERLINE = 1;
        STYLE_FLAG_STRIKE_OUT = 2;
        STYLE_FLAG_OVERLINE = 4;
        STYLE_FLAG_ITALIC = 8;
        STYLE_FLAG_BOLD = 16;
        STYLE_FLAG_DISABLE_BC_HINTING = 32;
        STYLE_FLAG_DISABLE_HINTING = 64;
    }
}

