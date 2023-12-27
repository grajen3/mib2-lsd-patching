/*
 * Decompiled with CFR 0.152.
 */
import de.vw.mib.graphics.font.spi.style.GlyphStyle;

class Font_test$TestGlyphStyle
implements GlyphStyle {
    private int mFontID;
    private boolean mBold;
    private boolean mItalic;
    private int mSize;
    private final /* synthetic */ Font_test this$0;

    public Font_test$TestGlyphStyle(Font_test font_test, int n, int n2) {
        this(font_test, n, n2, false, false);
    }

    public Font_test$TestGlyphStyle(Font_test font_test, int n, int n2, boolean bl, boolean bl2) {
        this.this$0 = font_test;
        this.mFontID = n;
        this.mSize = n2;
        this.mBold = bl;
        this.mItalic = bl2;
    }

    @Override
    public int getFontId() {
        return this.mFontID;
    }

    @Override
    public int getFontSize() {
        return this.mSize;
    }

    @Override
    public boolean isUnderline() {
        return false;
    }

    @Override
    public boolean isStrikeOut() {
        return false;
    }

    @Override
    public boolean isOverline() {
        return false;
    }

    @Override
    public boolean isItalic() {
        return this.mItalic;
    }

    @Override
    public boolean isBold() {
        return this.mBold;
    }

    @Override
    public boolean isByteCodeHintingDisabled() {
        return true;
    }

    @Override
    public boolean isHintingDisabled() {
        return false;
    }
}

