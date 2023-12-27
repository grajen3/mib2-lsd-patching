/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.cache.Cacheable;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.FontManager;
import de.vw.mib.graphics.font.Glyph;
import de.vw.mib.graphics.font.GlyphBitmap;
import de.vw.mib.graphics.font.KernedFont;
import de.vw.mib.graphics.font.RasterizableFont;
import de.vw.mib.graphics.font.internal.AbstractFont;
import de.vw.mib.graphics.font.internal.GlyphCache;
import de.vw.mib.graphics.font.internal.KernedRasterFont;
import de.vw.mib.graphics.font.internal.ServiceManager;
import de.vw.mib.graphics.font.spi.style.GlyphStyle;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class LinkedFont
extends AbstractFont
implements RasterizableFont,
KernedFont,
Cacheable {
    private static final int ALTERNATIVE_FONT_DESCRIPTION_NAME;
    private static final int ALTERNATIVE_FONT_DESCRIPTION_LANGUAGE;
    private static final int FONT_INDEX_MAIN_FONT;
    private final Font[] alternativeFonts;
    private final String[][] alternativeFontsDescriptions;
    private String preferredLinkedFontLanguage;
    private int preferredLinkedFontIndex;
    private final char[][][] exclusionRanges;
    private final FontManager fontManager;

    public LinkedFont(Logger logger, FontManager fontManager, GlyphCache glyphCache, int n, String string, char[][][] cArray, String[][] stringArray, char[][] cArray2) {
        super(logger, string);
        this.fontManager = fontManager;
        this.exclusionRanges = cArray;
        this.alternativeFontsDescriptions = stringArray;
        this.alternativeFonts = new Font[stringArray.length + 1];
        this.alternativeFonts[0] = new KernedRasterFont(logger, glyphCache, n, string, cArray2);
        if (logger.isTraceEnabled(4)) {
            LogMessage logMessage = logger.trace(4);
            logMessage.append("Created linked font for '").append(string).append("'").log();
        }
        this.updateFontIndex();
    }

    @Override
    public int getFontId() {
        return this.getFontByIndex(this.preferredLinkedFontIndex).getFontId();
    }

    public void updateFontIndex() {
        this.updateCurrentLanguage(ServiceManager.configurationManager.getCurrentGuiLanguage());
    }

    private Font openFont(String string) {
        Logger logger = this.getLogger();
        try {
            if (logger.isTraceEnabled(4)) {
                LogMessage logMessage = logger.trace(4);
                logMessage.append("Opening linked font: '").append(string).append("'").log();
            }
            return this.fontManager.getFontFromCurrentSkin(string);
        }
        catch (IOException iOException) {
            LogMessage logMessage = logger.warn(4);
            logMessage.append("Could not load linked font: ").append(string);
            logMessage.attachThrowable(iOException);
            logMessage.log();
            return this.getFontByIndex(0);
        }
    }

    private void updateCurrentLanguage(String string) {
        this.preferredLinkedFontIndex = 0;
        for (int i2 = 0; i2 < this.alternativeFontsDescriptions.length; ++i2) {
            if (!string.equals(this.alternativeFontsDescriptions[i2][1])) continue;
            this.preferredLinkedFontIndex = i2 + 1;
        }
        this.preferredLinkedFontLanguage = string;
    }

    private int getFontIndex(char c2) {
        if (this.exclusionRanges.length == 0 || !LinkedFont.containsChar(this.exclusionRanges[0], c2)) {
            return 0;
        }
        String string = ServiceManager.configurationManager.getCurrentGuiLanguage();
        if (!string.equals(this.preferredLinkedFontLanguage)) {
            this.updateCurrentLanguage(string);
        }
        if (this.preferredLinkedFontIndex != -1 && !LinkedFont.containsChar(this.exclusionRanges[this.preferredLinkedFontIndex], c2)) {
            return this.preferredLinkedFontIndex;
        }
        for (int i2 = 1; i2 < this.exclusionRanges.length; ++i2) {
            if (LinkedFont.containsChar(this.exclusionRanges[i2], c2)) continue;
            return i2;
        }
        return 0;
    }

    private Font getFont(char c2) {
        return this.getFontByIndex(this.getFontIndex(c2));
    }

    private Font getFontByIndex(int n) {
        if (this.alternativeFonts[n] == null) {
            this.alternativeFonts[n] = this.openFont(this.alternativeFontsDescriptions[n - 1][0]);
        }
        return this.alternativeFonts[n];
    }

    @Override
    public Glyph getGlyph(int n, int n2) {
        return this.getFontByIndex(0).getGlyph(n, n2);
    }

    @Override
    public boolean isGlyphAvailable(char c2, int n) {
        return this.getFont(c2).isGlyphAvailable(c2, n);
    }

    @Override
    public Glyph getGlyph(char c2, int n) {
        return this.getFont(c2).getGlyph(c2, n);
    }

    @Override
    public Rectangle getBoundingBox(Glyph glyph, GlyphStyle glyphStyle) {
        return this.getFont((char)glyph.getCharacter()).getBoundingBox(glyph, glyphStyle);
    }

    @Override
    public Rectangle getBoundingBox(String string, GlyphStyle glyphStyle) {
        Rectangle rectangle = new Rectangle();
        this.getBoundingBox(string, glyphStyle, rectangle);
        return rectangle;
    }

    @Override
    public void getBoundingBox(String string, GlyphStyle glyphStyle, Rectangle rectangle) {
        rectangle.width = 0;
        rectangle.height = 0;
        if (string.length() > 0) {
            Font font;
            int n;
            int n2 = n = string.length() - 1;
            Font font2 = font = this.getFont(string.charAt(n));
            while (n >= 0) {
                if (n > 0) {
                    font2 = this.getFont(string.charAt(n - 1));
                }
                if (font2 != font || n == 0) {
                    Rectangle rectangle2 = font.getBoundingBox(string.substring(n, n2 + 1), glyphStyle);
                    rectangle.width += rectangle2.width;
                    rectangle.height = Math.max(rectangle2.height, rectangle.height);
                    n2 = n - 1;
                    font = font2;
                }
                --n;
            }
        }
    }

    @Override
    public Rectangle getBoundingBox(char c2, GlyphStyle glyphStyle) {
        return this.getFont(c2).getBoundingBox(c2, glyphStyle);
    }

    @Override
    public String getFamilyName() {
        return this.getFontByIndex(0).getFamilyName();
    }

    @Override
    public int getAscender(int n) {
        return this.getFontByIndex(0).getAscender(n);
    }

    @Override
    public int getDescender(int n) {
        return this.getFontByIndex(0).getDescender(n);
    }

    @Override
    public int getHeight(int n) {
        return this.getFontByIndex(0).getHeight(n);
    }

    @Override
    public int getMaxAdvanceWidth(int n) {
        return this.getFontByIndex(0).getMaxAdvanceWidth(n);
    }

    @Override
    public String getStyleName() {
        return this.getFontByIndex(0).getStyleName();
    }

    @Override
    public void dispose() {
        for (int i2 = 0; i2 < this.alternativeFonts.length; ++i2) {
            if (this.alternativeFonts[i2] == null) continue;
            this.alternativeFonts[i2].dispose();
            this.alternativeFonts[i2] = null;
        }
    }

    @Override
    public GlyphBitmap getGlyphBitmap(Glyph glyph, GlyphStyle glyphStyle) {
        Font font = this.getFont((char)glyph.getCharacter());
        if (font instanceof RasterizableFont) {
            return ((RasterizableFont)font).getGlyphBitmap(glyph, glyphStyle);
        }
        throw new UnsupportedEncodingException(new StringBuffer().append("Unable to rasterize glyph - The Font ").append(font.getFamilyName()).append(" is not an instance of RasterizeableFont").toString());
    }

    @Override
    public int getKerning(char c2, char c3, int n) {
        int n2;
        int n3 = this.getFontIndex(c2);
        if (n3 == (n2 = this.getFontIndex(c3))) {
            Font font = this.getFontByIndex(n3);
            return font instanceof KernedFont ? ((KernedFont)font).getKerning(c2, c3, n) : 0;
        }
        return 0;
    }

    @Override
    public int getKerning(Glyph glyph, char c2) {
        return this.getKerning((char)glyph.getCharacter(), c2, glyph.getSize());
    }

    @Override
    public int getByteSize() {
        int n = 0;
        for (int i2 = 0; i2 < this.alternativeFonts.length; ++i2) {
            n += this.alternativeFonts[i2] != null && this.alternativeFonts[i2] instanceof Cacheable ? ((Cacheable)((Object)this.alternativeFonts[i2])).getByteSize() : 0;
        }
        return n;
    }

    public int getPreferredLinkedFontId() {
        return this.preferredLinkedFontIndex;
    }
}

