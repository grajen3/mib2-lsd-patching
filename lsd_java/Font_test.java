/*
 * Decompiled with CFR 0.152.
 */
import de.eso.mib.FontSPIImpl;
import de.vw.mib.graphics.font.spi.FontMetrics;
import de.vw.mib.graphics.font.spi.NativeGlyph;
import de.vw.mib.graphics.font.spi.layout.GlyphLayout;
import de.vw.mib.graphics.font.spi.layout.TextLayout;
import de.vw.mib.graphics.font.spi.layout.TextLineLayout;
import de.vw.mib.graphics.font.spi.style.GlyphStyle;
import de.vw.mib.graphics.font.spi.style.TextStyle;
import de.vw.mib.graphics.image.spi.NativeImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

class Font_test {
    private FontSPIImpl fontspi;
    private int IMG_WIDTH = 1100;
    private int IMG_HEIGHT = 400;

    Font_test() {
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

    private void writeBitmap(NativeImage nativeImage, String string) {
        byte[] byArray = new byte[nativeImage.buffer.capacity()];
        nativeImage.buffer.get(byArray);
        this.writeBitmap(nativeImage.width, nativeImage.height, byArray, string);
        nativeImage.buffer.rewind();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void writeBitmap(int n, int n2, byte[] byArray, String string) {
        OutputStreamWriter outputStreamWriter = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(string);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            String string2 = new StringBuffer().append("P6\n").append(n).append(" ").append(n2).append("\n255\n").toString();
            outputStreamWriter.write(string2);
            outputStreamWriter.flush();
            for (int i2 = 0; i2 < byArray.length; ++i2) {
                fileOutputStream.write(byArray[i2]);
                fileOutputStream.write(byArray[i2]);
                fileOutputStream.write(byArray[i2]);
            }
        }
        catch (Exception exception) {
            System.err.println(exception);
        }
        finally {
            try {
                outputStreamWriter.close();
            }
            catch (Exception exception) {}
        }
    }

    private void blitGlyph(byte[] byArray, int n, int n2, int n3, int n4, NativeGlyph nativeGlyph) {
        if (nativeGlyph == null || nativeGlyph.bitmap == null || nativeGlyph.bitmap.buffer == null || nativeGlyph.bitmap.buffer.capacity() == 0) {
            return;
        }
        byte[] byArray2 = new byte[nativeGlyph.bitmap.buffer.capacity()];
        nativeGlyph.bitmap.buffer.get(byArray2);
        nativeGlyph.bitmap.buffer.rewind();
        int n5 = 0;
        if (n4 < 0) {
            n5 = -n4;
        }
        for (int i2 = n5; i2 < nativeGlyph.bitmap.height; ++i2) {
            for (int i3 = 0; i3 < nativeGlyph.bitmap.width; ++i3) {
                byte by = byArray2[i2 * nativeGlyph.bitmap.width + i3];
                if (by == 0) continue;
                int n6 = (n4 + i2) * n + n3 + i3;
                byArray[n6] = by;
            }
        }
    }

    private void renderStringClassical(String string, GlyphStyle glyphStyle, int n, int n2, byte[] byArray) {
        FontMetrics fontMetrics = this.fontspi.getFontMetrics(glyphStyle);
        int n3 = fontMetrics.getAscender() / 64;
        int n4 = 0;
        int n5 = n3;
        for (int i2 = 0; i2 < string.length(); ++i2) {
            NativeGlyph nativeGlyph = this.fontspi.getGlyph(glyphStyle.getFontId(), string.charAt(i2), this.toStyleFlags(glyphStyle), glyphStyle.getFontSize());
            int n6 = nativeGlyph.leftOffset;
            int n7 = nativeGlyph.topOffset;
            this.blitGlyph(byArray, n, n2, n4 + n6, n5 - n7, nativeGlyph);
            n4 += nativeGlyph.horizontalAdvance / 64;
        }
    }

    private GlyphStyle getStyle(TextStyle[] textStyleArray, int n) {
        TextStyle textStyle = textStyleArray[0];
        for (int i2 = 1; i2 < textStyleArray.length; ++i2) {
            if (n < textStyleArray[i2].getStartIndex() || n >= textStyleArray[i2].getEndIndex() && textStyleArray.length - 1 != i2) continue;
            textStyle = textStyleArray[i2];
        }
        return textStyle.getGlyphStyle();
    }

    private TextLayout renderStringLayout(String string, TextStyle[] textStyleArray, int n, int n2, byte[] byArray, boolean bl) {
        TextLayout textLayout = null;
        textLayout = this.fontspi.performTextLayout(n, n2, 3, bl, '\u2026', false, '-', textStyleArray, string);
        if (textLayout == null) {
            System.err.println("performTextLayout failed");
            return null;
        }
        System.out.println(textLayout);
        for (int i2 = 0; i2 < textLayout.getLineCount(); ++i2) {
            System.out.println(new StringBuffer().append("line ").append(i2 + 1).toString());
            TextLineLayout textLineLayout = textLayout.getTextLine(i2);
            int n3 = textLineLayout.getBaseline();
            for (int i3 = 0; i3 < textLineLayout.getGlyphCount(); ++i3) {
                GlyphLayout glyphLayout = textLineLayout.getGlyph(i3);
                GlyphStyle glyphStyle = this.getStyle(textStyleArray, glyphLayout.getSourceIndex());
                if (glyphStyle == null) {
                    System.err.println(new StringBuffer().append("No glyph style found for index ").append(glyphLayout.getSourceIndex()).toString());
                    continue;
                }
                System.out.println(new StringBuffer().append("glyph id ").append(glyphLayout.getGlyphId()).append(" x:").append(glyphLayout.getX()).append(" y:").append(glyphLayout.getY()).toString());
                NativeGlyph nativeGlyph = this.fontspi.getGlyphById(glyphStyle, glyphLayout.getGlyphId());
                this.blitGlyph(byArray, this.IMG_WIDTH, this.IMG_HEIGHT, glyphLayout.getX() + nativeGlyph.leftOffset, n3 + glyphLayout.getY(), nativeGlyph);
            }
        }
        return textLayout;
    }

    public void kerningTestCase() {
        this.fontspi = new FontSPIImpl();
        this.fontspi.initNative();
        try {
            int n = this.fontspi.openFont(1, "VWThesis_MIB_Regular.ttf");
            this.fontspi.getKerning(n, 'V', 'e', 31);
            this.fontspi.getKerning(n, 'V', 'e', 31);
        }
        catch (Exception exception) {
            System.err.println(exception);
            exception.printStackTrace();
        }
        this.fontspi.uninitNative();
    }

    public void doTest() {
        this.fontspi = new FontSPIImpl();
        this.fontspi.initNative();
        try {
            int n = this.fontspi.openFont(1, "VWThesis_MIB_Arabic_Light.ttf");
            Font_test$TestGlyphStyle font_test$TestGlyphStyle = new Font_test$TestGlyphStyle(this, n, 52);
            Font_test$TestGlyphStyle font_test$TestGlyphStyle2 = new Font_test$TestGlyphStyle(this, n, 35);
            TextStyle[] textStyleArray = new Font_test$TestTextStyle[]{new Font_test$TestTextStyle(this, font_test$TestGlyphStyle2, 0, -129, 55)};
            String string = "               ";
            byte[] byArray = new byte[this.IMG_WIDTH * this.IMG_HEIGHT];
            this.renderStringLayout(string, textStyleArray, 120, 110, byArray, false);
            this.writeBitmap(this.IMG_WIDTH, this.IMG_HEIGHT, byArray, "layout4.ppm");
            string = "\u0645\u00b3\u200e/\u200f100 \u0643\u0645";
            byte[] byArray2 = new byte[this.IMG_WIDTH * this.IMG_HEIGHT];
            this.renderStringLayout(string, textStyleArray, 480, 44, byArray2, true);
            this.writeBitmap(this.IMG_WIDTH, this.IMG_HEIGHT, byArray2, "layout5.ppm");
            byte[] byArray3 = new byte[this.IMG_WIDTH * this.IMG_HEIGHT];
            string = "\u0634\u062f\u0629 \u0625\u0636\u0627\u0621\u0629 \u0627\u0644\u0634\u0627\u0634\u0629 / Hello World!";
            this.renderStringClassical(string, font_test$TestGlyphStyle, this.IMG_WIDTH, this.IMG_HEIGHT, byArray3);
            this.writeBitmap(this.IMG_WIDTH, this.IMG_HEIGHT, byArray3, "layout_classical.ppm");
            byArray3 = new byte[this.IMG_WIDTH * this.IMG_HEIGHT];
            TextStyle[] textStyleArray2 = new Font_test$TestTextStyle[]{new Font_test$TestTextStyle(this, font_test$TestGlyphStyle, 0, 2, 40)};
            this.renderStringLayout(string, textStyleArray2, this.IMG_WIDTH, this.IMG_HEIGHT, byArray3, true);
            this.writeBitmap(this.IMG_WIDTH, this.IMG_HEIGHT, byArray3, "layout.ppm");
            byte[] byArray4 = new byte[this.IMG_WIDTH * this.IMG_HEIGHT];
            Font_test$TestTextStyle[] font_test$TestTextStyleArray = new Font_test$TestTextStyle[]{new Font_test$TestTextStyle(this, font_test$TestGlyphStyle, 0, 10000, 40)};
            string = "\u0634\u062f\u0629\u064b\u0634\u062f\u0629 \u0634\u062f\u0629\u064b\u0634\u062f\u0629 \u0634\u062f\u0629\u064b\u0634\u062f\u0629 \u0634\u062f\u0629\u064b\u0634\u062f\u0629 \u0634\u062f\u0629\u064b\u0634\u062f\u0629 \u0634\u062f\u0629\u064b\u0634\u062f\u0629";
            this.renderStringLayout(string, textStyleArray2, 600, 438, byArray4, true);
            this.writeBitmap(this.IMG_WIDTH, this.IMG_HEIGHT, byArray4, "layout2.ppm");
            byte[] byArray5 = new byte[this.IMG_WIDTH * this.IMG_HEIGHT];
            string = "\u062a\u0645 \u0642\u0637\u0639 \u0627\u0644\u0627\u062a\u0635\u0627\u0644.";
            this.renderStringLayout(string, textStyleArray, 480, 44, byArray5, true);
            this.writeBitmap(this.IMG_WIDTH, this.IMG_HEIGHT, byArray5, "layout3.ppm");
            this.fontspi.closeFont(n);
        }
        catch (IOException iOException) {
            System.err.println(iOException);
            iOException.printStackTrace();
        }
        catch (IllegalArgumentException illegalArgumentException) {
            System.err.println(illegalArgumentException);
            illegalArgumentException.printStackTrace();
        }
        this.fontspi.uninitNative();
    }

    public void doTest2() {
        this.fontspi = new FontSPIImpl();
        this.fontspi.initNative();
        try {
            int n = this.fontspi.openFont(1, "VWThesis_MIB_Regular.ttf");
            byte[] byArray = new byte[this.IMG_WIDTH * this.IMG_HEIGHT];
            Font_test$TestGlyphStyle font_test$TestGlyphStyle = new Font_test$TestGlyphStyle(this, n, 31, false, false);
            Font_test$TestGlyphStyle font_test$TestGlyphStyle2 = new Font_test$TestGlyphStyle(this, n, 52, false, true);
            TextStyle[] textStyleArray = new Font_test$TestTextStyle[]{new Font_test$TestTextStyle(this, font_test$TestGlyphStyle, 0, -129, 48)};
            TextStyle[] textStyleArray2 = new Font_test$TestTextStyle[]{new Font_test$TestTextStyle(this, font_test$TestGlyphStyle2, 0, -129, 40)};
            this.renderStringLayout("!@\ufffd\uffff", textStyleArray, 1000, 40, byArray, true);
            this.renderStringLayout("Who knows what might happen if I render this first?!", textStyleArray2, 1100, 40, byArray, true);
            String string = "-";
            TextLayout textLayout = this.renderStringLayout(string, textStyleArray, 10000, 48, byArray, true);
            System.out.println(new StringBuffer().append("Layout width: ").append(textLayout.getWidth()).append(" layout height: ").append(textLayout.getHeight()).toString());
            TextLineLayout textLineLayout = textLayout.getTextLine(0);
            System.out.println(new StringBuffer().append("Baseline: ").append(textLineLayout.getBaseline()).append(", ").append(textLineLayout.getLeft()).append(", ").append(textLineLayout.getBottom()).append(", ").append(textLineLayout.getTop()).toString());
            this.writeBitmap(this.IMG_WIDTH, this.IMG_HEIGHT, byArray, "layout_test.ppm");
            this.fontspi.closeFont(n);
        }
        catch (Exception exception) {
            System.err.println(exception);
            exception.printStackTrace();
        }
        this.fontspi.uninitNative();
    }

    public static void main(String[] stringArray) {
        Font_test font_test = new Font_test();
        font_test.doTest();
        font_test.doTest2();
    }
}

