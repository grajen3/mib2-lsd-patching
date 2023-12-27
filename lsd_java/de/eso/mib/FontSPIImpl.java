/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import com.sun.gluegen.runtime.BufferFactory;
import de.eso.mib.FontControlBox;
import de.eso.mib.FontGlyphInfo;
import de.eso.mib.FontMetricsInfo;
import de.eso.mib.FontSPIImpl$FontSPIFontMetrics;
import de.eso.mib.FontSPIImpl$FontSPITextLayout;
import de.eso.mib.SLineMetric;
import de.eso.mib.SPI;
import de.eso.mib.STextMetric;
import de.eso.mib.StateInfo;
import de.vw.mib.graphics.font.spi.FontMetrics;
import de.vw.mib.graphics.font.spi.FontSPI;
import de.vw.mib.graphics.font.spi.NativeGlyph;
import de.vw.mib.graphics.font.spi.NativeInvalidFontFormatException;
import de.vw.mib.graphics.font.spi.layout.TextLayout;
import de.vw.mib.graphics.font.spi.style.GlyphStyle;
import de.vw.mib.graphics.font.spi.style.TextStyle;
import de.vw.mib.graphics.image.spi.NativeImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class FontSPIImpl
implements FontSPI {
    public static boolean CREATE_DEBUG_OUTPUT = false;
    public static boolean FAKE_MODE = false;
    public static boolean CREATE_FUNCTION_TRACES = false;
    public static String VW_RESOURCE_PATH_PREFIX = null;
    public static String VW_RESOURCE_PATH_PREFIX_2 = new String("/Fonts/");
    public static boolean DISABLE_SKINNING = false;

    public void initNative() {
        SPI.init_native();
    }

    public void uninitNative() {
        SPI.uninit_native();
    }

    @Override
    public int openFont(int n, int n2) {
        if (CREATE_FUNCTION_TRACES) {
            System.out.println(new StringBuffer().append("eso::FontSPI openFont enter ").append(n).append(" ").append(n2).toString());
        }
        System.out.println("FontSPI::openFont_ii NOT YET IMPLEMENTED");
        if (CREATE_FUNCTION_TRACES) {
            System.out.println("eso::FontSPI openFont exit");
        }
        return 0;
    }

    @Override
    public int openFont(int n, String string) {
        int n2;
        if (CREATE_FUNCTION_TRACES) {
            System.out.println(new StringBuffer().append("eso::FontSPI openFont enter ").append(n).append(" ").append(string).toString());
        }
        if (FAKE_MODE) {
            return 1;
        }
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println(new StringBuffer().append(">>openFont( ").append(n).append(",").append(string).append(" )").toString());
        }
        if ((n2 = SPI.font_open(n, string = DISABLE_SKINNING ? new StringBuffer().append(VW_RESOURCE_PATH_PREFIX).append(string).toString() : new StringBuffer().append(VW_RESOURCE_PATH_PREFIX).append(n).append(VW_RESOURCE_PATH_PREFIX_2).append(string).toString())) < 0) {
            if (CREATE_FUNCTION_TRACES) {
                System.out.println("eso::FontSPI openFont throw exception");
            }
            switch (n2) {
                case -3: {
                    throw new FileNotFoundException(string);
                }
                case -4: {
                    throw new IOException();
                }
                case -7: {
                    throw new NativeInvalidFontFormatException();
                }
                case -9: {
                    throw new IllegalArgumentException();
                }
            }
        }
        if (CREATE_FUNCTION_TRACES) {
            System.out.println("eso::FontSPI openFont exit");
        }
        return n2;
    }

    @Override
    public void closeFont(int n) {
        int n2;
        if (CREATE_FUNCTION_TRACES) {
            System.out.println(new StringBuffer().append("eso::FontSPI closeFont enter").append(n).toString());
        }
        if (FAKE_MODE) {
            return;
        }
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println(new StringBuffer().append(">>closeFont( ").append(n).append(" )").toString());
        }
        if ((n2 = SPI.font_close(n)) < 0) {
            throw new IllegalArgumentException();
        }
        if (CREATE_FUNCTION_TRACES) {
            System.out.println("eso::FontSPI closeFont exit");
        }
    }

    @Override
    public String getFamilyName(int n) {
        if (CREATE_FUNCTION_TRACES) {
            System.out.println(new StringBuffer().append("eso::FontSPI getFamilyName enter ").append(n).toString());
        }
        if (FAKE_MODE) {
            return new String("Arial");
        }
        StateInfo stateInfo = StateInfo.create();
        String string = SPI.font_get_family_name(n, stateInfo);
        if (stateInfo.state() < 0) {
            throw new IllegalArgumentException();
        }
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println(new StringBuffer().append(">>getFamilyName( ").append(n).append(" )=").append(string).toString());
        }
        if (CREATE_FUNCTION_TRACES) {
            System.out.println("eso::FontSPI getFamilyName exit");
        }
        return string;
    }

    @Override
    public String getStyleName(int n) {
        if (CREATE_FUNCTION_TRACES) {
            System.out.println(new StringBuffer().append("eso::FontSPI getStyleName enter ").append(n).toString());
        }
        if (FAKE_MODE) {
            return new String("Plain");
        }
        StateInfo stateInfo = StateInfo.create();
        String string = SPI.font_get_style_name(n, stateInfo);
        if (stateInfo.state() < 0) {
            throw new IllegalArgumentException();
        }
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println(new StringBuffer().append(">>getStyleName( ").append(n).append(" )=").append(string).toString());
        }
        if (CREATE_FUNCTION_TRACES) {
            System.out.println("eso::FontSPI getStyleName exit");
        }
        return string;
    }

    @Override
    public int getAscender(int n, int n2) {
        if (CREATE_FUNCTION_TRACES) {
            System.out.println(new StringBuffer().append("eso::FontSPI getAscender enter ").append(n).append(" ").append(n2).toString());
        }
        if (FAKE_MODE) {
            return 640;
        }
        StateInfo stateInfo = StateInfo.create();
        int n3 = SPI.font_get_ascender(n, n2, stateInfo);
        if (stateInfo.state() < 0) {
            throw new IllegalArgumentException();
        }
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println(new StringBuffer().append(">>getAscender( ").append(n).append(",").append(n2).append(" )=").append(n3).toString());
        }
        if (CREATE_FUNCTION_TRACES) {
            System.out.println("eso::FontSPI getAscender exit");
        }
        return n3;
    }

    @Override
    public int getDescender(int n, int n2) {
        if (CREATE_FUNCTION_TRACES) {
            System.out.println(new StringBuffer().append("eso::FontSPI getDescender enter ").append(n).append(" ").append(n2).toString());
        }
        if (FAKE_MODE) {
            return 640;
        }
        StateInfo stateInfo = StateInfo.create();
        int n3 = SPI.font_get_descender(n, n2, stateInfo);
        if (stateInfo.state() < 0) {
            throw new IllegalArgumentException();
        }
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println(new StringBuffer().append(">>getDescender( ").append(n).append(",").append(n2).append(" )=").append(n3).toString());
        }
        if (CREATE_FUNCTION_TRACES) {
            System.out.println("eso::FontSPI getDescender exit");
        }
        return n3;
    }

    @Override
    public int getHeight(int n, int n2) {
        if (CREATE_FUNCTION_TRACES) {
            System.out.println(new StringBuffer().append("eso::FontSPI getHeight enter ").append(n).append(" ").append(n2).toString());
        }
        if (FAKE_MODE) {
            return 640;
        }
        StateInfo stateInfo = StateInfo.create();
        int n3 = SPI.font_get_height(n, n2, stateInfo);
        if (stateInfo.state() < 0) {
            throw new IllegalArgumentException();
        }
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println(new StringBuffer().append(">>getHeight( ").append(n).append(",").append(n2).append(" )=").append(n3).toString());
        }
        if (CREATE_FUNCTION_TRACES) {
            System.out.println("eso::FontSPI getHeight exit");
        }
        return n3;
    }

    @Override
    public int getMaxAdvanceWidth(int n, int n2) {
        if (CREATE_FUNCTION_TRACES) {
            System.out.println(new StringBuffer().append("eso::FontSPI getMaxAdvanceWidth enter ").append(n).append(" ").append(n2).toString());
        }
        if (FAKE_MODE) {
            return 640;
        }
        StateInfo stateInfo = StateInfo.create();
        int n3 = SPI.font_get_max_advance_width(n, n2, stateInfo);
        if (stateInfo.state() < 0) {
            throw new IllegalArgumentException();
        }
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println(new StringBuffer().append(">>getMaxAdvanceWidth( ").append(n).append(",").append(n2).append(" )=").append(n3).toString());
        }
        if (CREATE_FUNCTION_TRACES) {
            System.out.println("eso::FontSPI getMaxAdvanceWidth exit");
        }
        return n3;
    }

    @Override
    public void getControlBox(int n, char c2, int n2, int[] nArray) {
        if (CREATE_FUNCTION_TRACES) {
            System.out.println(new StringBuffer().append("eso::FontSPI getControlBox enter ").append(n).append(" ").append(c2).append(" ").append(n2).toString());
        }
        if (FAKE_MODE) {
            nArray[0] = 1280;
            nArray[1] = 1280;
        }
        FontControlBox fontControlBox = FontControlBox.create();
        SPI.font_get_control_box(n, c2, n2, fontControlBox);
        switch (fontControlBox.state()) {
            case -2: {
                throw new IllegalArgumentException();
            }
            case -8: {
                throw new UnsupportedEncodingException();
            }
        }
        nArray[0] = fontControlBox.width();
        nArray[1] = fontControlBox.height();
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println(new StringBuffer().append(">>getControlBox( ").append(n).append(",").append(c2).append(",").append(n2).append(" )=").append(fontControlBox.width()).append(",").append(fontControlBox.height()).toString());
        }
        if (CREATE_FUNCTION_TRACES) {
            System.out.println("eso::FontSPI getControlBox exit");
        }
    }

    @Override
    public int getKerning(int n, char c2, char c3, int n2) {
        if (CREATE_FUNCTION_TRACES) {
            System.out.println(new StringBuffer().append("eso::FontSPI getKerning enter ").append(n).append(" ").append(c2).append(" ").append(c3).append(" ").append(n2).toString());
        }
        if (FAKE_MODE) {
            return 0;
        }
        StateInfo stateInfo = StateInfo.create();
        int n3 = SPI.font_get_kerning(n, c2, c3, n2, stateInfo);
        switch (stateInfo.state()) {
            case -2: {
                throw new IllegalArgumentException();
            }
            case -8: {
                throw new UnsupportedEncodingException();
            }
        }
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println(new StringBuffer().append(">>getKerning( ").append(n).append(",").append(c2).append(",").append(c3).append(",").append(n2).append(" )=").append(n3).toString());
        }
        if (CREATE_FUNCTION_TRACES) {
            System.out.println("eso::FontSPI getKerning exit");
        }
        return n3;
    }

    @Override
    public NativeGlyph getGlyph(int n, char c2, int n2, int n3) {
        return this.getGlyph(n, c2, n2, n3, false);
    }

    private NativeGlyph getGlyph(int n, int n2, int n3, int n4, boolean bl) {
        if (CREATE_FUNCTION_TRACES) {
            System.out.println(new StringBuffer().append("eso::FontSPI getGlyph enter ").append(n).append(" ").append(n2).append(" ").append(n3).append(" ").append(n4).append(" ").append(bl).toString());
        }
        if (FAKE_MODE) {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(64);
            byteBuffer.rewind();
            int n5 = 64;
            for (int i2 = 0; i2 < n5; ++i2) {
                byteBuffer.put(i2, (byte)-96);
            }
            byteBuffer.rewind();
            NativeImage nativeImage = new NativeImage(byteBuffer, 8, 8, 4096);
            NativeGlyph nativeGlyph = new NativeGlyph((char)n2, nativeImage, 0, 0, 64);
            return nativeGlyph;
        }
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println(">>getGlyph()");
        }
        FontGlyphInfo fontGlyphInfo = FontGlyphInfo.create();
        ByteBuffer byteBuffer = SPI.font_get_glyph(n, n2, n3, n4, fontGlyphInfo, bl ? 1 : 0);
        if (CREATE_FUNCTION_TRACES && fontGlyphInfo.state() < 0) {
            System.out.println("eso::FontSPI getGlyph throw exception");
        }
        switch (fontGlyphInfo.state()) {
            case -2: {
                throw new IllegalArgumentException();
            }
            case -8: {
                throw new UnsupportedEncodingException();
            }
            case -10: {
                throw new UnsupportedEncodingException("Out of memory");
            }
        }
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocateDirect(0);
        }
        NativeImage nativeImage = new NativeImage(byteBuffer, fontGlyphInfo.width(), fontGlyphInfo.height(), 4096);
        if (CREATE_DEBUG_OUTPUT) {
            int n6 = 0;
            if (byteBuffer != null) {
                n6 = byteBuffer.capacity();
            }
            System.out.println(new StringBuffer().append(">>getGlyph: ").append(fontGlyphInfo.width()).append(",").append(fontGlyphInfo.height()).append(",").append(n6).toString());
        }
        NativeGlyph nativeGlyph = new NativeGlyph((char)n2, nativeImage, fontGlyphInfo.left_offset(), fontGlyphInfo.top_offset(), fontGlyphInfo.horizontal_advance());
        if (CREATE_FUNCTION_TRACES) {
            System.out.println("eso::FontSPI getGlyph exit");
        }
        return nativeGlyph;
    }

    @Override
    public void releaseGlyph(ByteBuffer byteBuffer) {
        BufferFactory.dispose(byteBuffer);
    }

    private int toStyleFlags(GlyphStyle glyphStyle) {
        int n = 0;
        if (glyphStyle.isBold()) {
            n |= 1;
        }
        if (glyphStyle.isItalic()) {
            n |= 2;
        }
        if (glyphStyle.isUnderline()) {
            n |= 4;
        }
        if (glyphStyle.isOverline()) {
            n |= 8;
        }
        if (glyphStyle.isStrikeOut()) {
            n |= 0xF;
        }
        if (glyphStyle.isHintingDisabled()) {
            n |= 0x800000;
        }
        if (glyphStyle.isByteCodeHintingDisabled()) {
            n |= 0x100;
        }
        return n;
    }

    @Override
    public NativeGlyph getGlyphById(GlyphStyle glyphStyle, int n) {
        int n2 = this.toStyleFlags(glyphStyle);
        try {
            NativeGlyph nativeGlyph = this.getGlyph(glyphStyle.getFontId(), n, n2, glyphStyle.getFontSize(), true);
            return nativeGlyph;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new UnsupportedOperationException(unsupportedEncodingException.getMessage());
        }
    }

    private static void print(PrintStream printStream, GlyphStyle glyphStyle) {
        printStream.println(new StringBuffer().append("STYLE fontId:").append(glyphStyle.getFontId()).append(" size:").append(glyphStyle.getFontSize()).append(" isUnderline:").append(glyphStyle.isUnderline()).append(" isStrikeOut:").append(glyphStyle.isStrikeOut()).append(" isOverline:").append(glyphStyle.isOverline()).append(" isItalic:").append(glyphStyle.isItalic()).append(" isBold:").append(glyphStyle.isBold()).append(" isByteCodeHintingDisabled:").append(glyphStyle.isByteCodeHintingDisabled()).append(" isHintingDisabled:").append(glyphStyle.isHintingDisabled()).toString());
    }

    @Override
    public FontMetrics getFontMetrics(GlyphStyle glyphStyle) {
        if (CREATE_FUNCTION_TRACES) {
            System.out.print("eso::FontSPI getFontMetrics");
            FontSPIImpl.print(System.out, glyphStyle);
        }
        if (FAKE_MODE) {
            FontMetricsInfo fontMetricsInfo = FontMetricsInfo.create();
            fontMetricsInfo.ascender(47);
            fontMetricsInfo.descender(-50);
            fontMetricsInfo.height(97);
            fontMetricsInfo.advanceWidth(67);
            fontMetricsInfo.underlinePosition(-3);
            fontMetricsInfo.underlineThickness(1);
            FontSPIImpl$FontSPIFontMetrics fontSPIImpl$FontSPIFontMetrics = new FontSPIImpl$FontSPIFontMetrics(fontMetricsInfo);
            if (CREATE_FUNCTION_TRACES) {
                System.out.println("eso::FontSPI getFontMetrics exit");
            }
            return fontSPIImpl$FontSPIFontMetrics;
        }
        int n = this.toStyleFlags(glyphStyle);
        FontMetricsInfo fontMetricsInfo = FontMetricsInfo.create();
        SPI.font_get_metrics(glyphStyle.getFontId(), glyphStyle.getFontSize(), n, fontMetricsInfo);
        FontSPIImpl$FontSPIFontMetrics fontSPIImpl$FontSPIFontMetrics = new FontSPIImpl$FontSPIFontMetrics(fontMetricsInfo);
        if (CREATE_FUNCTION_TRACES) {
            System.out.println("eso::FontSPI getFontMetrics exit");
        }
        return fontSPIImpl$FontSPIFontMetrics;
    }

    @Override
    public TextLayout performTextLayout(int n, int n2, int n3, boolean bl, char c2, boolean bl2, char c3, TextStyle[] textStyleArray, String string) {
        STextMetric sTextMetric;
        Object object;
        if (CREATE_FUNCTION_TRACES) {
            int n4;
            System.out.println(new StringBuffer().append("eso::FontSPI performTextLayout width:").append(n).append(" height:").append(n2).append(" maxLines:").append(n3).append(" truncate:").append(bl).append(" truncation:").append(c2).append("(").append((int)c2).append(") hyphenate:").append(bl2).append(" hyphenation:").append(c3).append("(").append((int)c3).append(") text:").append(string).toString());
            System.out.print("text in ints: ");
            for (n4 = 0; n4 < string.length(); ++n4) {
                System.out.print(new StringBuffer().append((int)string.charAt(n4)).append(" ").toString());
            }
            System.out.println("");
            for (n4 = 0; n4 < textStyleArray.length; ++n4) {
                System.out.println(new StringBuffer().append("TEXTSTYLE: lineSpacing:").append(textStyleArray[n4].getLineSpacing()).append(" alignment:").append(textStyleArray[n4].getHorizontalAlignment()).append(" linebreak:").append(textStyleArray[n4].getLinebreakMode()).append(" startIndex:").append(textStyleArray[n4].getStartIndex()).append(" endIndex:").append(textStyleArray[n4].getEndIndex()).toString());
                FontSPIImpl.print(System.out, textStyleArray[n4].getGlyphStyle());
            }
        }
        int[] nArray = new int[textStyleArray.length];
        int[] nArray2 = new int[textStyleArray.length];
        int[] nArray3 = new int[textStyleArray.length];
        int[] nArray4 = new int[textStyleArray.length];
        int[] nArray5 = new int[textStyleArray.length];
        int[] nArray6 = new int[textStyleArray.length];
        int[] nArray7 = new int[textStyleArray.length];
        int[] nArray8 = new int[textStyleArray.length];
        for (int i2 = 0; i2 < textStyleArray.length; ++i2) {
            nArray[i2] = textStyleArray[i2].getLineSpacing();
            nArray2[i2] = textStyleArray[i2].getHorizontalAlignment();
            nArray3[i2] = textStyleArray[i2].getLinebreakMode();
            nArray4[i2] = textStyleArray[i2].getStartIndex();
            nArray5[i2] = textStyleArray[i2].getEndIndex();
            object = textStyleArray[i2].getGlyphStyle();
            nArray6[i2] = object.getFontId();
            nArray7[i2] = object.getFontSize();
            nArray8[i2] = this.toStyleFlags((GlyphStyle)object);
        }
        if (FAKE_MODE) {
            FontSPIImpl$FontSPITextLayout fontSPIImpl$FontSPITextLayout = new FontSPIImpl$FontSPITextLayout(true);
            if (CREATE_FUNCTION_TRACES) {
                System.out.println(fontSPIImpl$FontSPITextLayout);
                System.out.println("eso::FontSPI performTextLayout exit");
            }
            return fontSPIImpl$FontSPITextLayout;
        }
        SLineMetric[] sLineMetricArray = SPI.font_perform_text_layout(n, n2, n3, bl ? 1 : 0, c2, bl2 ? 1 : 0, c3, string, textStyleArray.length, nArray, 0, nArray2, 0, nArray3, 0, nArray4, 0, nArray5, 0, nArray6, 0, nArray7, 0, nArray8, 0, sTextMetric = STextMetric.create(), (int[])(object = new int[1]), 0);
        if (sLineMetricArray == null) {
            FontSPIImpl$FontSPITextLayout fontSPIImpl$FontSPITextLayout = new FontSPIImpl$FontSPITextLayout(false);
            if (CREATE_FUNCTION_TRACES) {
                System.out.println(fontSPIImpl$FontSPITextLayout);
                System.out.println("eso::FontSPI performTextLayout exit");
            }
            return fontSPIImpl$FontSPITextLayout;
        }
        FontSPIImpl$FontSPITextLayout fontSPIImpl$FontSPITextLayout = new FontSPIImpl$FontSPITextLayout(sTextMetric, sLineMetricArray);
        SPI.font_release_layout();
        if (CREATE_FUNCTION_TRACES) {
            System.out.println(fontSPIImpl$FontSPITextLayout);
            System.out.println("eso::FontSPI performTextLayout exit");
        }
        return fontSPIImpl$FontSPITextLayout;
    }

    @Override
    public boolean isTextLayoutingAvailable() {
        return true;
    }

    @Override
    public boolean isGlyphAvailable(int n, char c2) {
        int n2 = SPI.font_is_glyph_available(n, c2);
        if (n2 < 0) {
            throw new IllegalArgumentException();
        }
        return n2 != 0;
    }

    static {
        System.loadLibrary("mibhighvwspi");
        VW_RESOURCE_PATH_PREFIX = System.getProperty("spi.resourcepath");
        DISABLE_SKINNING = Boolean.getBoolean("spi.disableskinning");
        CREATE_FUNCTION_TRACES = Boolean.getBoolean("spi.trace.font");
        if (VW_RESOURCE_PATH_PREFIX == null) {
            VW_RESOURCE_PATH_PREFIX = DISABLE_SKINNING ? new String("/eso/hmi/lsd/Resources/") : new String("/eso/hmi/lsd/Resources/skin");
        } else {
            if (!VW_RESOURCE_PATH_PREFIX.endsWith("/")) {
                VW_RESOURCE_PATH_PREFIX = new StringBuffer().append(VW_RESOURCE_PATH_PREFIX).append("/").toString();
            }
            if (!DISABLE_SKINNING) {
                VW_RESOURCE_PATH_PREFIX = new StringBuffer().append(VW_RESOURCE_PATH_PREFIX).append("skin").toString();
            }
        }
    }
}

