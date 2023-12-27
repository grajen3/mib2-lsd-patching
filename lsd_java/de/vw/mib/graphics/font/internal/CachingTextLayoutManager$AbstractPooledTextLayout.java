/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.graphics.font.internal.CachingTextLayoutManager;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.spi.layout.GlyphLayout;
import de.vw.mib.graphics.font.spi.layout.TextLineLayout;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.util.StringBuilder;

abstract class CachingTextLayoutManager$AbstractPooledTextLayout
implements TextLayout,
PooledObject {
    private final ObjectPool pool;
    private int references;
    private String text;
    private long id;
    static final /* synthetic */ boolean $assertionsDisabled;

    public CachingTextLayoutManager$AbstractPooledTextLayout(ObjectPool objectPool) {
        this.pool = objectPool;
    }

    public final void set(String string, long l) {
        this.text = string;
        this.id = l;
        this.references = 1;
    }

    @Override
    public final String getText() {
        return this.text;
    }

    @Override
    public void dispose() {
        if (!$assertionsDisabled && this.references <= 0) {
            throw new AssertionError((Object)"PooledTextLayout.dispose(): Reference count <= 0");
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
        this.text = null;
        this.references = 0;
        this.id = -1L;
    }

    @Override
    public final int getByteSize() {
        return 0;
    }

    @Override
    public final long getId() {
        return this.id;
    }

    @Override
    public int findRowBySourceIndex(int n) {
        for (int i2 = this.getLineCount() - 1; i2 >= 0; --i2) {
            if (n < this.getFirstSourceIndex(i2)) continue;
            return i2;
        }
        return -1;
    }

    @Override
    public int getFirstSourceIndex(int n) {
        int n2;
        if (n > this.getLineCount() - 1) {
            return -1;
        }
        TextLineLayout textLineLayout = this.getTextLine(n);
        int n3 = textLineLayout.getGlyphCount();
        if (n3 == 0) {
            return -1;
        }
        if (n3 == 1) {
            return textLineLayout.getGlyph(0).getSourceIndex();
        }
        int n4 = textLineLayout.getGlyph(0).getSourceIndex();
        if (n4 < (n2 = textLineLayout.getGlyph(n3 - 1).getSourceIndex())) {
            for (int i2 = 0; i2 < n3 && n4 >= textLineLayout.getGlyph(i2).getSourceIndex(); ++i2) {
                n4 = textLineLayout.getGlyph(i2).getSourceIndex();
            }
            return n4;
        }
        for (int i3 = n3 - 1; i3 > 0 && n2 >= textLineLayout.getGlyph(i3).getSourceIndex(); --i3) {
            n2 = textLineLayout.getGlyph(i3).getSourceIndex();
        }
        return n2;
    }

    @Override
    public int getLastSourceIndex(int n) {
        if (n > this.getLineCount() - 1) {
            return -1;
        }
        TextLineLayout textLineLayout = this.getTextLine(n);
        return textLineLayout.getGlyphCount() == 0 ? -1 : textLineLayout.getGlyph(this.getLastGlyphIndex(n)).getSourceIndex();
    }

    @Override
    public int getLastGlyphIndex(int n) {
        int n2;
        if (n > this.getLineCount() - 1) {
            return 0;
        }
        TextLineLayout textLineLayout = this.getTextLine(n);
        if (textLineLayout.getGlyphCount() == 0) {
            return 0;
        }
        if (this.isTextlineRtl(n)) {
            n2 = 0;
            int n3 = textLineLayout.getGlyph(n2).getSourceIndex();
            while (n2 < textLineLayout.getGlyphCount() - 2 && textLineLayout.getGlyph(n2 + 1).getSourceIndex() > n3) {
                n3 = textLineLayout.getGlyph(++n2).getSourceIndex();
            }
        } else {
            n2 = textLineLayout.getGlyphCount() - 1;
            int n4 = textLineLayout.getGlyph(n2).getSourceIndex();
            while (n2 > 1 && textLineLayout.getGlyph(n2 - 1).getSourceIndex() > n4) {
                n4 = textLineLayout.getGlyph(--n2).getSourceIndex();
            }
        }
        return n2;
    }

    @Override
    public boolean isTextlineRtl(int n) {
        if (n > this.getLineCount() - 1) {
            return false;
        }
        TextLineLayout textLineLayout = this.getTextLine(n);
        return textLineLayout != null && textLineLayout.getGlyphCount() > 0 && (textLineLayout.getGlyphCount() == 1 && textLineLayout.getGlyph(0).isRightToLeft() || textLineLayout.getGlyphCount() > 1 && textLineLayout.getGlyph(textLineLayout.getGlyphCount() - 1).getSourceIndex() < textLineLayout.getGlyph(0).getSourceIndex());
    }

    public String toString() {
        int n;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[text='").append(this.text);
        stringBuilder.append("'\n)");
        stringBuilder.append("text (buffer)='");
        stringBuilder.append(CachingTextLayoutManager.getUnicodeEscapeString(this.text));
        for (n = 0; n < this.text.length(); ++n) {
            stringBuilder.append("u\\").append(Integer.toHexString(this.text.charAt(n)));
        }
        stringBuilder.append("'\n");
        stringBuilder.append("id=0x").append(Long.toHexString(this.getId()));
        stringBuilder.append(",width=").append(this.getWidth());
        stringBuilder.append(",height").append(this.getHeight());
        stringBuilder.append(",lines=").append(this.getLineCount());
        stringBuilder.append(",truncated=").append(this.isTruncated());
        for (n = 0; n < this.getLineCount(); ++n) {
            CachingTextLayoutManager$AbstractPooledTextLayout.textLineLayoutToString(stringBuilder, this.getTextLine(n), this.text);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static void textLineLayoutToString(StringBuilder stringBuilder, TextLineLayout textLineLayout, String string) {
        stringBuilder.append(",baseline=").append(textLineLayout.getBaseline());
        stringBuilder.append(",left=").append(textLineLayout.getLeft());
        stringBuilder.append(",bottom=").append(textLineLayout.getBottom());
        stringBuilder.append(",top=").append(textLineLayout.getTop());
        stringBuilder.append(",glyphCount=").append(textLineLayout.getGlyphCount()).append("\n");
        stringBuilder.append("- Glyphs: \n");
        for (int i2 = 0; i2 < textLineLayout.getGlyphCount(); ++i2) {
            CachingTextLayoutManager$AbstractPooledTextLayout.glyphLayoutToString(stringBuilder, textLineLayout.getGlyph(i2), string);
        }
    }

    private static void glyphLayoutToString(StringBuilder stringBuilder, GlyphLayout glyphLayout, String string) {
        stringBuilder.append("Char '").append(glyphLayout.getSourceIndex() >= 0 && glyphLayout.getSourceIndex() < string.length() ? string.charAt(glyphLayout.getSourceIndex()) : (char)'?').append("' sourceIndex ").append(glyphLayout.getSourceIndex()).append(" ").append("glyphId ").append(glyphLayout.getGlyphId());
        stringBuilder.append(" x ").append(glyphLayout.getX()).append(" y ").append(glyphLayout.getY()).append(" width ").append(glyphLayout.getWidth()).append(" height ").append(glyphLayout.getHeight()).append(" caretX ").append(glyphLayout.getCaretX() >> 6).append(" RTL ").append(glyphLayout.isRightToLeft()).append("\n");
    }

    static {
        $assertionsDisabled = !(CachingTextLayoutManager.class$de$vw$mib$graphics$font$internal$CachingTextLayoutManager == null ? (CachingTextLayoutManager.class$de$vw$mib$graphics$font$internal$CachingTextLayoutManager = CachingTextLayoutManager.class$("de.vw.mib.graphics.font.internal.CachingTextLayoutManager")) : CachingTextLayoutManager.class$de$vw$mib$graphics$font$internal$CachingTextLayoutManager).desiredAssertionStatus();
    }
}

