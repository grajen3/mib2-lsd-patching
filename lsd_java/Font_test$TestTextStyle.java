/*
 * Decompiled with CFR 0.152.
 */
import de.vw.mib.graphics.font.spi.style.GlyphStyle;
import de.vw.mib.graphics.font.spi.style.TextStyle;

class Font_test$TestTextStyle
implements TextStyle {
    private GlyphStyle mStyle;
    private int mStart;
    private int mEnd;
    private int mLs;
    private final /* synthetic */ Font_test this$0;

    public Font_test$TestTextStyle(Font_test font_test, GlyphStyle glyphStyle, int n, int n2, int n3) {
        this.this$0 = font_test;
        this.mStyle = glyphStyle;
        this.mStart = n;
        this.mEnd = n2;
        this.mLs = n3;
    }

    @Override
    public int getLineSpacing() {
        return this.mLs;
    }

    @Override
    public int getHorizontalAlignment() {
        return 2;
    }

    @Override
    public int getLinebreakMode() {
        return 0;
    }

    @Override
    public int getStartIndex() {
        return this.mStart;
    }

    @Override
    public int getEndIndex() {
        return this.mEnd;
    }

    @Override
    public GlyphStyle getGlyphStyle() {
        return this.mStyle;
    }
}

