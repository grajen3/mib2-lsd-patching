/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.Glyph;
import de.vw.mib.graphics.font.KernedFont;
import de.vw.mib.graphics.font.RasterizableFont;
import de.vw.mib.graphics.font.TextLayoutManager;
import de.vw.mib.graphics.font.TextLayoutPerformanceMetrics;
import de.vw.mib.graphics.font.internal.BitmappedGlyph;
import de.vw.mib.graphics.font.internal.CachingTextLayoutManager$GlyphLayoutPool;
import de.vw.mib.graphics.font.internal.CachingTextLayoutManager$GlyphStylePool;
import de.vw.mib.graphics.font.internal.CachingTextLayoutManager$NativeTextLayoutPool;
import de.vw.mib.graphics.font.internal.CachingTextLayoutManager$PooledGlyphLayout;
import de.vw.mib.graphics.font.internal.CachingTextLayoutManager$PooledGlyphStyle;
import de.vw.mib.graphics.font.internal.CachingTextLayoutManager$PooledNativeTextLayout;
import de.vw.mib.graphics.font.internal.CachingTextLayoutManager$PooledTextLayout;
import de.vw.mib.graphics.font.internal.CachingTextLayoutManager$PooledTextLineLayout;
import de.vw.mib.graphics.font.internal.CachingTextLayoutManager$PooledTextStyle;
import de.vw.mib.graphics.font.internal.CachingTextLayoutManager$TextLayoutPool;
import de.vw.mib.graphics.font.internal.CachingTextLayoutManager$TextLineLayoutPool;
import de.vw.mib.graphics.font.internal.CachingTextLayoutManager$TextStylePool;
import de.vw.mib.graphics.font.internal.ServiceManager;
import de.vw.mib.graphics.font.internal.TextLayoutCache;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.spi.layout.GlyphLayout;
import de.vw.mib.graphics.font.spi.layout.TextLineLayout;
import de.vw.mib.graphics.font.spi.style.GlyphStyle;
import de.vw.mib.graphics.font.style.TextStyle;
import de.vw.mib.graphics.performance.CachePerformanceMetrics;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.util.StringBuilder;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class CachingTextLayoutManager
implements TextLayoutManager {
    private static final boolean FORCE_NATIVE_TEXT_LAYOUT = System.getProperty("de.vw.mib.graphics.font.nativetextlayout") != null;
    private static final boolean USE_UNFITTED_KERNING;
    private static final char WORD_SEPARATOR_SPACE;
    private static final char WORD_SEPARATOR_ZERO_WIDTH_SPACE;
    private static final char LINEBREAK_TAG;
    private static final char[] PUNCTUATIONS;
    private static final IntSet PUNCTUATION_SET;
    private static final char CONTROL_CHARACTER_C0_START;
    private static final char CONTROL_CHARACTER_C0_END;
    private static final char CONTROL_CHARACTER_C1_START;
    private static final char CONTROL_CHARACTER_C1_END;
    private static final char CONTROL_CHARACTER_BIDI_START;
    private static final char CONTROL_CHARACTER_BIDI_END;
    private static final char CONTROL_CHARACTER_DIRECTIONAL_START;
    private static final char CONTROL_CHARACTER_DIRECTIONAL_END;
    private static final char ZERO_WIDTH_JOINER;
    private static final char ZERO_WIDTH_NON_JOINER;
    private static final char ZERO_WIDTH_NO_BREAK_SPACE;
    private static final char NOTDEF_GLYPH;
    public static final int ALIGNMENT_LEFT;
    public static final int ALIGNMENT_CENTER;
    public static final int ALIGNMENT_RIGHT;
    private static final int GLYPH_LAYOUT_POOL_MAXIMUM_CAPACITY;
    private static final int TEXT_LINE_LAYOUT_POOL_MAXIMUM_CAPACITY;
    private static final int TEXT_LAYOUT_POOL_MAXIMUM_CAPACITY;
    private static final int NATIVE_TEXT_LAYOUT_POOL_MAXIMUM_CAPACITY;
    private static final int TEXT_LAYOUT_CACHE_SIZE;
    private static final int TEXT_STYLE_POOL_MAXIMUM_CAPACITY;
    private static final int GLYPH_STYLE_POOL_MAXIMUM_CAPACITY;
    private static final int GLYPH_LIST_INITIAL_CAPACITY;
    private static final int TEXTLINE_LAYOUTS_LIST_INITIAL_CAPACITY;
    private final Logger logger;
    private final ObjectPool glyphLayoutPool;
    private final ObjectPool textLineLayoutPool;
    private final ObjectPool textLayoutPool;
    private final ObjectPool nativeTextLayoutPool;
    private final ObjectPool glyphStylePool;
    private final ObjectPool textStylePool;
    private final TextLayoutCache textLayoutCache;
    private final HashCodeBuilder hashCodeBuilder;
    private boolean isNativeLayout;
    private final boolean nativeLayoutAvailable;
    static /* synthetic */ Class class$de$vw$mib$graphics$font$internal$CachingTextLayoutManager;

    public CachingTextLayoutManager(LoggerFactory loggerFactory) {
        this.logger = loggerFactory.getLogger(256);
        this.nativeLayoutAvailable = ServiceManager.fontSPI.isTextLayoutingAvailable();
        this.isNativeLayout = this.nativeLayoutAvailable && (ServiceManager.configurationManager.isArabicAvailable() || FORCE_NATIVE_TEXT_LAYOUT);
        this.glyphLayoutPool = new CachingTextLayoutManager$GlyphLayoutPool(100);
        this.textLineLayoutPool = new CachingTextLayoutManager$TextLineLayoutPool(50);
        this.textLayoutPool = new CachingTextLayoutManager$TextLayoutPool(25);
        this.nativeTextLayoutPool = new CachingTextLayoutManager$NativeTextLayoutPool(25);
        this.textLayoutCache = new TextLayoutCache(this.logger, 50);
        this.glyphStylePool = new CachingTextLayoutManager$GlyphStylePool(25);
        this.textStylePool = new CachingTextLayoutManager$TextStylePool(25);
        this.hashCodeBuilder = new HashCodeBuilder();
        LogMessage logMessage = this.logger.info(16);
        logMessage.append("TextLayoutManager initialized - ");
        logMessage.append("FontSPI supports layout creation: ").append(this.nativeLayoutAvailable);
        logMessage.append("; Use only FontSPI text-layouts: ").append(this.isNativeLayout);
        logMessage.log();
    }

    @Override
    public void dispose() {
    }

    @Override
    public TextLayoutPerformanceMetrics getPerformanceMetrics() {
        return new TextLayoutPerformanceMetrics();
    }

    public void setNewLanguage() {
        if (!FORCE_NATIVE_TEXT_LAYOUT) {
            boolean bl;
            boolean bl2 = bl = ServiceManager.configurationManager.isArabicAvailable() && ServiceManager.fontSPI.isTextLayoutingAvailable();
            if (bl != this.isNativeLayout) {
                this.isNativeLayout = bl;
                LogMessage logMessage = this.logger.info(16);
                logMessage.append("TextLayoutManager language updated - ");
                logMessage.append("FontSPI supports layout creation: ").append(this.nativeLayoutAvailable);
                logMessage.append("; Use only FontSPI text-layouts: ").append(this.isNativeLayout);
                logMessage.log();
            }
        }
    }

    @Override
    public TextLayout performTextLayout(int n, int n2, int n3, boolean bl, char c2, boolean bl2, char c3, TextStyle[] textStyleArray, String string, Font font) {
        if (string == null || string.length() == 0) {
            return CachingTextLayoutManager$TextLayoutPool.getEmptyTextLayout();
        }
        if (font == null || textStyleArray == null || n3 <= 0 || n <= 0 || n2 <= 0) {
            return CachingTextLayoutManager$TextLayoutPool.getEmptyTruncatedTextLayout();
        }
        this.hashCodeBuilder.reset();
        this.hashCodeBuilder.append(n).append(n2);
        this.hashCodeBuilder.append(n3).append(bl).append(c2).append(bl2).append(c3);
        for (int i2 = 0; i2 < textStyleArray.length; ++i2) {
            this.hashCodeBuilder.append(textStyleArray[i2]);
        }
        this.hashCodeBuilder.append(string).append(font.getName());
        long l = this.hashCodeBuilder.longHashCode();
        TextLayout textLayout = (TextLayout)this.textLayoutCache.get(l);
        if (textLayout == null) {
            if (this.isNativeLayout) {
                textLayout = this.performNativeTextLayout(l, n, n2, n3, bl, c2, bl2, c3, textStyleArray, string);
            } else {
                try {
                    textLayout = this.performReferenceTextLayout(l, n, n2, n3, bl, c2, bl2, c3, textStyleArray, string, font);
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    if (this.nativeLayoutAvailable) {
                        textLayout = this.performNativeTextLayout(l, n, n2, n3, bl, c2, bl2, c3, textStyleArray, string);
                    }
                    LogMessage logMessage = this.logger.error(16);
                    logMessage.append("Error performing linebreak on text: ").append(string).attachThrowable(unsupportedEncodingException).log();
                    textLayout = CachingTextLayoutManager$TextLayoutPool.getEmptyTruncatedTextLayout();
                }
            }
            this.textLayoutCache.put(l, textLayout);
            if (this.logger.isTraceEnabled(16)) {
                LogMessage logMessage = this.logger.trace(16);
                logMessage.append("TextLayoutManager.performTextLayout(").append(textLayout.isGlyphIdCharacterCode() ? "Java" : "Native").append("): ");
                logMessage.append("Box-size(w x h): ").append(n).append(" x ").append(n2).append("\n");
                logMessage.append("Max linecount: ").append(n3).append("\n");
                logMessage.append("Truncate / Hyphenate: ").append(bl).append(" / ").append(bl2).append("\n");
                for (int i3 = 0; i3 < textStyleArray.length; ++i3) {
                    logMessage.append("- Style ").append(i3).append("\n");
                    logMessage.append(textStyleArray[i3].toString());
                }
                logMessage.append("\n");
                logMessage.append(textLayout).log();
            }
        }
        textLayout.reference();
        return textLayout;
    }

    private TextLayout performNativeTextLayout(long l, int n, int n2, int n3, boolean bl, char c2, boolean bl2, char c3, TextStyle[] textStyleArray, String string) {
        try {
            de.vw.mib.graphics.font.spi.layout.TextLayout textLayout = ServiceManager.fontSPI.performTextLayout(n, n2, n3, bl, c2, bl2, c3, textStyleArray, string);
            CachingTextLayoutManager$PooledNativeTextLayout cachingTextLayoutManager$PooledNativeTextLayout = (CachingTextLayoutManager$PooledNativeTextLayout)this.nativeTextLayoutPool.borrowObject();
            cachingTextLayoutManager$PooledNativeTextLayout.set(string, l, textLayout);
            return cachingTextLayoutManager$PooledNativeTextLayout;
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            LogMessage logMessage = this.logger.error(16);
            logMessage.append("Unable to create native text layout due to exception thrown by FontSPI (supplier responsibility). Input data was:");
            logMessage.append("\nWidth: ").append(n);
            logMessage.append("\nHeight: ").append(n2);
            logMessage.append("\nMax Lines: ").append(n3);
            logMessage.append("\nTruncate: ").append(bl).append(" (").append(c2).append(" )");
            logMessage.append("\nHyphenate: ").append(bl2).append(" (").append(c3).append(")");
            logMessage.append("\nText styles: [");
            for (int i2 = 0; i2 < textStyleArray.length; ++i2) {
                logMessage.append(textStyleArray[i2].toString()).append(",");
            }
            logMessage.append("]\nText: '").append(string).append("'");
            logMessage.append("\nUnicode View: ").append(CachingTextLayoutManager.getUnicodeEscapeString(string));
            logMessage.attachThrowable(unsupportedOperationException);
            logMessage.log();
            return CachingTextLayoutManager$TextLayoutPool.getEmptyTextLayout();
        }
    }

    private TextLayout performReferenceTextLayout(long l, int n, int n2, int n3, boolean bl, char c2, boolean bl2, char c3, TextStyle[] textStyleArray, String string, Font font) {
        return this.performLineBreak(l, string, font, textStyleArray, n, n3, bl, c2, bl2, c3);
    }

    private TextLayout performLineBreak(long l, String string, Font font, TextStyle[] textStyleArray, int n, int n2, boolean bl, char c2, boolean bl2, char c3) {
        int n3;
        TextStyle textStyle = textStyleArray[0];
        int n4 = string.length();
        ArrayList arrayList = new ArrayList(5);
        int n5 = 0;
        for (int i2 = 0; n5 < n4 && i2 < n2 && (n3 = this.appendTextLine(string, n5, arrayList, textStyle.getHorizontalAlignment(), n, font, textStyle.getFontGlyphStyle(), bl && i2 == n2 - 1, c2, bl2, c3, textStyle.getLinebreakMode() == 1)) != n5; ++i2) {
            n5 = n3;
        }
        n3 = n4 != n5 ? 1 : 0;
        return this.performVerticalLayout(string, l, arrayList, textStyle.getLineSpacing(), n3 != 0);
    }

    private TextLayout performVerticalLayout(String string, long l, List list, int n, boolean bl) {
        Object object;
        int n2 = list.size();
        int n3 = 0;
        int n4 = 0;
        if (n2 > 0) {
            object = (TextLineLayout)list.get(0);
            int n5 = object.getBaseline();
            n3 = this.getTextlineWidth((TextLineLayout)object);
            n4 = n5 - object.getBottom();
            for (int i2 = 1; i2 < n2; ++i2) {
                CachingTextLayoutManager$PooledTextLineLayout cachingTextLayoutManager$PooledTextLineLayout = (CachingTextLayoutManager$PooledTextLineLayout)list.get(i2);
                if (cachingTextLayoutManager$PooledTextLineLayout.getGlyphCount() > 0) {
                    n3 = Math.max(n3, this.getTextlineWidth(cachingTextLayoutManager$PooledTextLineLayout));
                }
                if (n > 0) {
                    cachingTextLayoutManager$PooledTextLineLayout.setBaseline(n5 += n);
                    n4 = n5 - cachingTextLayoutManager$PooledTextLineLayout.getBottom();
                    continue;
                }
                int n6 = n4 + cachingTextLayoutManager$PooledTextLineLayout.getBaseline();
                cachingTextLayoutManager$PooledTextLineLayout.setBaseline(n6);
                n4 = n6 - cachingTextLayoutManager$PooledTextLineLayout.getBottom();
            }
        }
        object = (CachingTextLayoutManager$PooledTextLayout)this.textLayoutPool.borrowObject();
        ((CachingTextLayoutManager$PooledTextLayout)object).set(string, l, n3, n4, bl, list);
        return object;
    }

    private int appendTextLine(String string, int n, List list, int n2, int n3, Font font, de.vw.mib.graphics.font.style.GlyphStyle glyphStyle, boolean bl, char c2, boolean bl2, char c3, boolean bl3) {
        int n4;
        BitmappedGlyph bitmappedGlyph;
        Glyph glyph;
        KernedFont kernedFont = (KernedFont)font;
        RasterizableFont rasterizableFont = (RasterizableFont)font;
        int n5 = string.length();
        if (bl) {
            glyph = font.getGlyph(c2, glyphStyle.getFontSize());
            bitmappedGlyph = (BitmappedGlyph)rasterizableFont.getGlyphBitmap(glyph, glyphStyle);
            n4 = n3 - (bitmappedGlyph.getHorizontalAdvance() >> 6);
        } else if (bl2) {
            glyph = font.getGlyph(c3, glyphStyle.getFontSize());
            bitmappedGlyph = (BitmappedGlyph)rasterizableFont.getGlyphBitmap(glyph, glyphStyle);
            n4 = n3 - (bitmappedGlyph.getHorizontalAdvance() >> 6);
        } else {
            glyph = null;
            bitmappedGlyph = null;
            n4 = n3;
        }
        if (n > 0 && string.charAt(n - 1) != '\n') {
            while (n < n5 && string.charAt(n) == ' ') {
                ++n;
            }
            if (n < n5 && string.charAt(n) == '\n') {
                ++n;
            }
        }
        int n6 = n;
        int n7 = n;
        int n8 = 0;
        boolean bl4 = false;
        boolean bl5 = false;
        Glyph glyph2 = null;
        ArrayList arrayList = new ArrayList(20);
        boolean bl6 = false;
        while (n6 < n5 && !bl6) {
            GlyphLayout i2;
            int n9;
            Glyph n12;
            char c4 = string.charAt(n6);
            if (c4 != '\n' && this.isControlCharacter(c4)) {
                if (CachingTextLayoutManager.isWordSeparatorChar(c4, string, n6)) {
                    if (bl5) {
                        bl4 = true;
                    }
                    n7 = n6;
                }
                this.appendGlyph(-16842752, n6, n8, 0, 0, 0, arrayList);
                ++n6;
                continue;
            }
            if (!bl && c4 == '\n') {
                ++n6;
                break;
            }
            try {
                n12 = font.getGlyph(c4, glyphStyle.getFontSize());
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                if (this.nativeLayoutAvailable) {
                    throw unsupportedEncodingException;
                }
                c4 = '\uffff0000';
                n12 = font.getGlyph(c4, glyphStyle.getFontSize());
            }
            BitmappedGlyph unsupportedEncodingException = (BitmappedGlyph)rasterizableFont.getGlyphBitmap(n12, glyphStyle);
            int n10 = glyph2 == null ? 0 : kernedFont.getKerning(glyph2, c4);
            int n11 = n8 + n10;
            n8 = n11 + unsupportedEncodingException.getHorizontalAdvance();
            boolean bl7 = bl6 = n8 >> 6 > n3 || c4 == '\n';
            if (!bl6) {
                Rectangle n92 = font.getBoundingBox(n12, (GlyphStyle)glyphStyle);
                this.appendGlyph(n12.getCharacter(), n6, n11, -unsupportedEncodingException.getTopOffset(), unsupportedEncodingException.getHorizontalAdvance(), n92.height, arrayList);
                if (bl || bl3) {
                    if (n8 >> 6 <= n4) {
                        n7 = n6;
                    }
                } else if (CachingTextLayoutManager.isWordSeparatorChar(c4, string, n6)) {
                    if (bl5) {
                        bl4 = true;
                    }
                    n7 = n6;
                } else {
                    bl5 = true;
                    if (!(bl4 || bl2 && n8 >> 6 > n4)) {
                        n7 = n6;
                    }
                }
                glyph2 = n12;
                ++n6;
                continue;
            }
            if (!bl && !bl2 && string.charAt(n6) == ' ') {
                n9 = n6 - 1;
                n7 = n6;
            } else {
                n9 = bl4 && string.charAt(n7) == ' ' ? n7 - n - 1 : n7 - n;
            }
            for (int i3 = arrayList.size() - 1; i3 > n9; --i3) {
                CachingTextLayoutManager$PooledGlyphLayout cachingTextLayoutManager$PooledGlyphLayout = (CachingTextLayoutManager$PooledGlyphLayout)arrayList.remove(i3);
                cachingTextLayoutManager$PooledGlyphLayout.dispose();
            }
            GlyphLayout glyphLayout = i2 = !arrayList.isEmpty() ? (GlyphLayout)arrayList.get(arrayList.size() - 1) : null;
            if (i2 != null) {
                n8 = i2.getX() + i2.getWidth() << 6;
                n6 = n7 + 1;
            }
            if (!bl && (!bl2 || bl4) || glyph == null || bitmappedGlyph == null) continue;
            n8 = this.appendTruncationGlyph(string, font, kernedFont, glyph, bitmappedGlyph, c2, glyphStyle, i2, n8, n7, arrayList);
        }
        int n12 = font.getAscender(glyphStyle.getFontSize()) >> 6;
        int n13 = n12 - (font.getHeight(glyphStyle.getFontSize()) >> 6);
        list.add(this.performHorizontalLayout(n12, n13, n2, n3, n8 >> 6, arrayList));
        return n6;
    }

    private void appendGlyph(int n, int n2, int n3, int n4, int n5, int n6, List list) {
        CachingTextLayoutManager$PooledGlyphLayout cachingTextLayoutManager$PooledGlyphLayout = (CachingTextLayoutManager$PooledGlyphLayout)this.glyphLayoutPool.borrowObject();
        cachingTextLayoutManager$PooledGlyphLayout.set(n, n2, n3 >> 6, n4, n5 >> 6, n6 >> 6, n3);
        list.add(cachingTextLayoutManager$PooledGlyphLayout);
    }

    private int appendTruncationGlyph(String string, Font font, KernedFont kernedFont, Glyph glyph, BitmappedGlyph bitmappedGlyph, char c2, de.vw.mib.graphics.font.style.GlyphStyle glyphStyle, GlyphLayout glyphLayout, int n, int n2, List list) {
        int n3;
        Rectangle rectangle = font.getBoundingBox(glyph, (GlyphStyle)glyphStyle);
        if (glyphLayout != null) {
            int n4 = n2 == 0 ? 0 : kernedFont.getKerning(string.charAt(glyphLayout.getSourceIndex()), c2, glyphStyle.getFontSize());
            n3 = n + n4;
        } else {
            n3 = 0;
        }
        this.appendGlyph(glyph.getCharacter(), n2 + 1, n3, -bitmappedGlyph.getTopOffset(), bitmappedGlyph.getHorizontalAdvance(), rectangle.height, list);
        return n3 + bitmappedGlyph.getHorizontalAdvance();
    }

    private TextLineLayout performHorizontalLayout(int n, int n2, int n3, int n4, int n5, List list) {
        int n6;
        switch (n3) {
            case 1: {
                n6 = (n4 >> 1) - (n5 >> 1);
                break;
            }
            case 2: {
                n6 = n4 - n5;
                break;
            }
            default: {
                n6 = 0;
            }
        }
        CachingTextLayoutManager$PooledTextLineLayout cachingTextLayoutManager$PooledTextLineLayout = (CachingTextLayoutManager$PooledTextLineLayout)this.textLineLayoutPool.borrowObject();
        cachingTextLayoutManager$PooledTextLineLayout.set(n, n6, n, n2, list);
        return cachingTextLayoutManager$PooledTextLineLayout;
    }

    private int getTextlineWidth(TextLineLayout textLineLayout) {
        return textLineLayout.getGlyphCount() == 0 ? 0 : textLineLayout.getGlyph(textLineLayout.getGlyphCount() - 1).getX() + textLineLayout.getGlyph(textLineLayout.getGlyphCount() - 1).getWidth() - textLineLayout.getGlyph(0).getX();
    }

    @Override
    public de.vw.mib.graphics.font.style.GlyphStyle createGlyphStyle(int n, int n2, int n3) {
        CachingTextLayoutManager$PooledGlyphStyle cachingTextLayoutManager$PooledGlyphStyle = (CachingTextLayoutManager$PooledGlyphStyle)this.glyphStylePool.borrowObject();
        cachingTextLayoutManager$PooledGlyphStyle.set(n, n2, n3);
        return cachingTextLayoutManager$PooledGlyphStyle;
    }

    @Override
    public de.vw.mib.graphics.font.style.GlyphStyle createGlyphStyle(int n, int n2, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
        CachingTextLayoutManager$PooledGlyphStyle cachingTextLayoutManager$PooledGlyphStyle = (CachingTextLayoutManager$PooledGlyphStyle)this.glyphStylePool.borrowObject();
        cachingTextLayoutManager$PooledGlyphStyle.set(n, n2, bl, bl2, bl3, bl4, bl5, bl6, bl7);
        return cachingTextLayoutManager$PooledGlyphStyle;
    }

    @Override
    public TextStyle createTextStyle(int n, int n2, int n3, int n4, int n5, de.vw.mib.graphics.font.style.GlyphStyle glyphStyle) {
        CachingTextLayoutManager$PooledTextStyle cachingTextLayoutManager$PooledTextStyle = (CachingTextLayoutManager$PooledTextStyle)this.textStylePool.borrowObject();
        cachingTextLayoutManager$PooledTextStyle.set(n, n2, n3, n4, n5, glyphStyle);
        return cachingTextLayoutManager$PooledTextStyle;
    }

    private static boolean isWordSeparatorChar(char c2, String string, int n) {
        return c2 == ' ' || c2 == '\u200b' || n > 0 && n < string.length() - 1 && PUNCTUATION_SET.contains(c2) && (!CachingTextLayoutManager.isDigit(string.charAt(n - 1)) || !CachingTextLayoutManager.isDigit(string.charAt(n + 1)));
    }

    private boolean isControlCharacter(char c2) {
        return c2 == '\ufffe0000' || c2 == '\u200b' || c2 == '\u200d' || c2 == '\u200c' || c2 >= '\u0000' && c2 <= '\u0019' || c2 >= '\u0080' && c2 <= '\u009f' || c2 >= '\u0080' && c2 <= '\u009f' || c2 >= '\u202a' && c2 <= '\u202e' || c2 >= '\u2066' && c2 <= '\u2069';
    }

    private static boolean isDigit(char c2) {
        return Character.digit(c2, 10) != -1;
    }

    protected static String getUnicodeEscapeString(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < string.length(); ++i2) {
            stringBuilder.append("u\\").append(Integer.toHexString(string.charAt(i2)));
        }
        return stringBuilder.toString();
    }

    @Override
    public CachePerformanceMetrics getTextLayoutCacheUsage() {
        return new CachePerformanceMetrics(this.textLayoutCache.size(), this.textLayoutCache.getByteSize(), 0, this.textLayoutCache.hits(), this.textLayoutCache.misses());
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        PUNCTUATIONS = new char[]{'-', '/', ';', '\u2044'};
        PUNCTUATION_SET = new IntOptHashSet(PUNCTUATIONS.length);
        for (int i2 = 0; i2 < PUNCTUATIONS.length; ++i2) {
            PUNCTUATION_SET.add(PUNCTUATIONS[i2]);
        }
    }
}

