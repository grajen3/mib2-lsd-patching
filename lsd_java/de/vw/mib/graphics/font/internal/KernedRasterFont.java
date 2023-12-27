/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.cache.Cacheable;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.longs.LongObjectMap;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.Glyph;
import de.vw.mib.graphics.font.GlyphBitmap;
import de.vw.mib.graphics.font.KernedFont;
import de.vw.mib.graphics.font.RasterizableFont;
import de.vw.mib.graphics.font.internal.AbstractFont;
import de.vw.mib.graphics.font.internal.BitmappedGlyph;
import de.vw.mib.graphics.font.internal.GlyphCache;
import de.vw.mib.graphics.font.internal.KernedRasterFont$GlyphCacheListener;
import de.vw.mib.graphics.font.internal.KernedRasterFont$SizeInfo;
import de.vw.mib.graphics.font.internal.KernedRasterGlyph;
import de.vw.mib.graphics.font.internal.ServiceManager;
import de.vw.mib.graphics.font.spi.NativeGlyph;
import de.vw.mib.graphics.font.spi.NativeInvalidFontFormatException;
import de.vw.mib.graphics.font.spi.style.GlyphStyle;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.spi.NativeImage;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public final class KernedRasterFont
extends AbstractFont
implements KernedFont,
RasterizableFont,
Cacheable {
    private static final boolean MOCK_SPI_CALLS;
    private static final boolean PRINT_GLYPH_BITMAP;
    private final GlyphCache glyphCache;
    private final KernedRasterFont$GlyphCacheListener glyphCacheListener;
    private final int fontId;
    private final char[][] complexScriptRanges;
    private static final int GLYPH_MAP_INITIAL_CAPACITY;
    protected final LongObjectMap glyphMap;
    private static final int SIZEINFO_MAP_INITIAL_CAPACITY;
    private final IntObjectMap sizeInfoMap;
    private String familyName;
    private String styleName;
    private final HashCodeBuilder hcb;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$font$internal$KernedRasterFont;

    public KernedRasterFont(Logger logger, GlyphCache glyphCache, int n, String string, char[][] cArray) {
        super(logger, string);
        this.glyphCache = glyphCache;
        this.complexScriptRanges = cArray;
        this.glyphCacheListener = new KernedRasterFont$GlyphCacheListener(this);
        this.glyphCache.addCacheListener(this.glyphCacheListener);
        try {
            long l;
            LogMessage logMessage = logger.isTraceEnabled(4) ? logger.trace(4) : null;
            boolean bl = logMessage != null && logger.isTraceEnabled(128);
            long l2 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
            this.fontId = MOCK_SPI_CALLS ? 0 : ServiceManager.fontSPI.openFont(n, string);
            long l3 = l = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
            if (logMessage != null) {
                logMessage.append("openFont(").append(n).append(", '").append(string).append("')");
                if (bl) {
                    logMessage.append(": ").append(l - l2).append("\u00b5s");
                }
                logMessage.log();
            }
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalStateException(illegalArgumentException.getMessage());
        }
        catch (NativeInvalidFontFormatException nativeInvalidFontFormatException) {
            throw new IOException(nativeInvalidFontFormatException.getMessage());
        }
        this.glyphMap = new LongObjectOptHashMap(50);
        this.sizeInfoMap = new IntObjectOptHashMap(10);
        this.hcb = new HashCodeBuilder();
    }

    @Override
    public void dispose() {
        this.glyphCache.removeCacheListener(this.glyphCacheListener);
        throw new NotYetImplementedException();
    }

    @Override
    public int getFontId() {
        return this.fontId;
    }

    @Override
    public int getByteSize() {
        Object[] objectArray = this.glyphMap.valuesToArray();
        int n = 0;
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            n += ((KernedRasterGlyph)objectArray[i2]).getByteSize();
        }
        return n;
    }

    @Override
    public String getFamilyName() {
        if (this.familyName == null) {
            this.familyName = MOCK_SPI_CALLS ? "DummyFamily" : ServiceManager.fontSPI.getFamilyName(this.fontId);
        }
        return this.familyName;
    }

    @Override
    public String getStyleName() {
        if (this.styleName == null) {
            this.styleName = MOCK_SPI_CALLS ? "DummyStyle" : ServiceManager.fontSPI.getStyleName(this.fontId);
        }
        return this.styleName;
    }

    private KernedRasterFont$SizeInfo getSizeInfo(int n) {
        KernedRasterFont$SizeInfo kernedRasterFont$SizeInfo = (KernedRasterFont$SizeInfo)this.sizeInfoMap.get(n);
        if (kernedRasterFont$SizeInfo == null) {
            kernedRasterFont$SizeInfo = new KernedRasterFont$SizeInfo(n);
            this.sizeInfoMap.put(n, kernedRasterFont$SizeInfo);
        }
        return kernedRasterFont$SizeInfo;
    }

    @Override
    public int getAscender(int n) {
        KernedRasterFont$SizeInfo kernedRasterFont$SizeInfo = this.getSizeInfo(n);
        if (!kernedRasterFont$SizeInfo.hasAscender()) {
            long l;
            long l2;
            Logger logger = this.getLogger();
            LogMessage logMessage = logger.isTraceEnabled(4) ? logger.trace(4) : null;
            boolean bl = logMessage != null && logger.isTraceEnabled(128);
            long l3 = l2 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
            if (MOCK_SPI_CALLS) {
                kernedRasterFont$SizeInfo.setAscender(0);
            } else {
                kernedRasterFont$SizeInfo.setAscender(ServiceManager.fontSPI.getAscender(this.fontId, n));
            }
            long l4 = l = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
            if (logMessage != null) {
                logMessage.append("getAscender(").append(n).append(") = ").append(kernedRasterFont$SizeInfo.getAscender());
                if (bl) {
                    logMessage.append(": ").append(l - l2).append("\u00b5s");
                }
                logMessage.log();
            }
        }
        return kernedRasterFont$SizeInfo.getAscender();
    }

    @Override
    public int getDescender(int n) {
        KernedRasterFont$SizeInfo kernedRasterFont$SizeInfo = this.getSizeInfo(n);
        if (!kernedRasterFont$SizeInfo.hasDescender()) {
            long l;
            long l2;
            Logger logger = this.getLogger();
            LogMessage logMessage = logger.isTraceEnabled(4) ? logger.trace(4) : null;
            boolean bl = logMessage != null && logger.isTraceEnabled(128);
            long l3 = l2 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
            if (MOCK_SPI_CALLS) {
                kernedRasterFont$SizeInfo.setDescender(0);
            } else {
                kernedRasterFont$SizeInfo.setDescender(ServiceManager.fontSPI.getDescender(this.fontId, n));
            }
            long l4 = l = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
            if (logMessage != null) {
                logMessage.append("getDescender(").append(n).append(") = ").append(kernedRasterFont$SizeInfo.getDescender());
                if (bl) {
                    logMessage.append(": ").append(l - l2).append("\u00b5s");
                }
                logMessage.log();
            }
        }
        return kernedRasterFont$SizeInfo.getDescender();
    }

    @Override
    public int getHeight(int n) {
        KernedRasterFont$SizeInfo kernedRasterFont$SizeInfo = this.getSizeInfo(n);
        if (!kernedRasterFont$SizeInfo.hasHeight()) {
            long l;
            long l2;
            Logger logger = this.getLogger();
            LogMessage logMessage = logger.isTraceEnabled(4) ? logger.trace(4) : null;
            boolean bl = logMessage != null && logger.isTraceEnabled(128);
            long l3 = l2 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
            if (MOCK_SPI_CALLS) {
                kernedRasterFont$SizeInfo.setHeight(64);
            } else {
                kernedRasterFont$SizeInfo.setHeight(ServiceManager.fontSPI.getHeight(this.fontId, n));
            }
            long l4 = l = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
            if (logMessage != null) {
                logMessage.append("getHeight(").append(n).append(") = ").append(kernedRasterFont$SizeInfo.getHeight());
                if (bl) {
                    logMessage.append(": ").append(l - l2).append("\u00b5s");
                }
                logMessage.log();
            }
        }
        return kernedRasterFont$SizeInfo.getHeight();
    }

    @Override
    public int getMaxAdvanceWidth(int n) {
        KernedRasterFont$SizeInfo kernedRasterFont$SizeInfo = this.getSizeInfo(n);
        if (!kernedRasterFont$SizeInfo.hasMaxAdvanceWidth()) {
            long l;
            long l2;
            Logger logger = this.getLogger();
            LogMessage logMessage = logger.isTraceEnabled(4) ? logger.trace(4) : null;
            boolean bl = logMessage != null && logger.isTraceEnabled(128);
            long l3 = l2 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
            if (MOCK_SPI_CALLS) {
                kernedRasterFont$SizeInfo.setMaxAdvanceWidth(64);
            } else {
                kernedRasterFont$SizeInfo.setMaxAdvanceWidth(ServiceManager.fontSPI.getMaxAdvanceWidth(this.fontId, n));
            }
            long l4 = l = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
            if (logMessage != null) {
                logMessage.append("getMaxAdvanceWidth(").append(n).append(") = ").append(kernedRasterFont$SizeInfo.getMaxAdvanceWidth());
                if (bl) {
                    logMessage.append(": ").append(l - l2).append("\u00b5s");
                }
                logMessage.log();
            }
        }
        return kernedRasterFont$SizeInfo.getMaxAdvanceWidth();
    }

    @Override
    public Rectangle getBoundingBox(String string, GlyphStyle glyphStyle) {
        Rectangle rectangle = new Rectangle();
        this.getBoundingBox(string, glyphStyle, rectangle);
        return rectangle;
    }

    @Override
    public void getBoundingBox(String string, GlyphStyle glyphStyle, Rectangle rectangle) {
        int n = string.length();
        Glyph glyph = null;
        rectangle.width = 0;
        rectangle.height = 0;
        for (int i2 = 0; i2 < n; ++i2) {
            char c2 = string.charAt(i2);
            Glyph glyph2 = this.getGlyph(c2, glyphStyle.getFontSize());
            BitmappedGlyph bitmappedGlyph = (BitmappedGlyph)this.getGlyphBitmap(glyph2, glyphStyle);
            Rectangle rectangle2 = this.getBoundingBox(glyph2, glyphStyle);
            rectangle.width += bitmappedGlyph.getHorizontalAdvance();
            if (glyph != null) {
                rectangle.width += this.getKerning(glyph, c2);
            }
            if (rectangle.height < rectangle2.height) {
                rectangle.height = rectangle2.height;
            }
            glyph = glyph2;
        }
    }

    @Override
    public Rectangle getBoundingBox(Glyph glyph, GlyphStyle glyphStyle) {
        KernedRasterGlyph kernedRasterGlyph = (KernedRasterGlyph)glyph;
        Rectangle rectangle = kernedRasterGlyph.getBoundingBox();
        if (rectangle == null) {
            long l;
            long l2;
            Logger logger = this.getLogger();
            LogMessage logMessage = logger.isTraceEnabled(4) ? logger.trace(4) : null;
            boolean bl = logMessage != null && logger.isTraceEnabled(128);
            long l3 = l2 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
            if (MOCK_SPI_CALLS) {
                rectangle = new Rectangle(0, 0, 64, 64);
            } else {
                int[] nArray = new int[2];
                ServiceManager.fontSPI.getControlBox(this.fontId, (char)kernedRasterGlyph.getCharacter(), kernedRasterGlyph.getSize(), nArray);
                rectangle = new Rectangle(0, 0, nArray[0], nArray[1]);
            }
            long l4 = l = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
            if (logMessage != null) {
                logMessage.append("getControlBox(Font: ").append(this.getName()).append(", Char: '").append((char)glyph.getCharacter()).append("') = ").append(rectangle);
                if (bl) {
                    logMessage.append(": ").append(l - l2).append("\u00b5s");
                }
                logMessage.log();
            }
            kernedRasterGlyph.setBoundingBox(rectangle);
        }
        return rectangle;
    }

    @Override
    public Rectangle getBoundingBox(char c2, GlyphStyle glyphStyle) {
        return this.getBoundingBox(this.getGlyph(c2, glyphStyle.getFontSize()), glyphStyle);
    }

    @Override
    public boolean isGlyphAvailable(char c2, int n) {
        if (this.isComplexCharacter(c2)) {
            throw new UnsupportedEncodingException("Script not supported.");
        }
        Glyph glyph = this.getGlyph(c2, n);
        if (!glyph.wasGlyphAvailableSet()) {
            glyph.setGlyphAvailable(ServiceManager.fontSPI.isGlyphAvailable(this.fontId, c2));
        }
        return glyph.isGlyphAvailable();
    }

    @Override
    public int getKerning(Glyph glyph, char c2) {
        KernedRasterGlyph kernedRasterGlyph = (KernedRasterGlyph)glyph;
        int n = 0;
        if (kernedRasterGlyph.hasKerning(c2)) {
            n = kernedRasterGlyph.getKerning(c2);
        } else {
            long l;
            Logger logger = this.getLogger();
            LogMessage logMessage = logger.isTraceEnabled(4) ? logger.trace(4) : null;
            boolean bl = logMessage != null && logger.isTraceEnabled(128);
            long l2 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
            n = MOCK_SPI_CALLS ? 0 : ServiceManager.fontSPI.getKerning(this.fontId, (char)kernedRasterGlyph.getCharacter(), c2, kernedRasterGlyph.getSize());
            long l3 = l = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
            if (logMessage != null) {
                logMessage.append("getKerning(Font: ").append(this.getName()).append(", Char left: '").append((char)glyph.getCharacter()).append("', Char right: '").append(c2).append("', Size: ").append(kernedRasterGlyph.getSize()).append(") = ").append(n);
                if (bl) {
                    logMessage.append(": ").append(l - l2).append("\u00b5s");
                }
                logMessage.log();
            }
            kernedRasterGlyph.addKerning(c2, n);
        }
        return n;
    }

    @Override
    public int getKerning(char c2, char c3, int n) {
        return this.getKerning(this.getGlyph(c2, n), c3);
    }

    @Override
    public Glyph getGlyph(int n, int n2) {
        long l = this.createGlyphKey(true, n, n2);
        KernedRasterGlyph kernedRasterGlyph = (KernedRasterGlyph)this.glyphCache.get(l);
        if (kernedRasterGlyph == null) {
            kernedRasterGlyph = new KernedRasterGlyph(l, (Font)this, n, n2);
            this.addGlyph(l, kernedRasterGlyph);
        }
        if (!($assertionsDisabled || kernedRasterGlyph.getCharacter() == n && kernedRasterGlyph.getSize() == n2 && kernedRasterGlyph.isCharacterGlyphIndex())) {
            throw new AssertionError((Object)new StringBuffer().append("glyphCache returned wrong glyph: glyphIndex").append(n).append(" size:").append(n2).append("glyph: ").append(kernedRasterGlyph).toString());
        }
        return kernedRasterGlyph;
    }

    @Override
    public Glyph getGlyph(char c2, int n) {
        long l = this.createGlyphKey(false, c2, n);
        KernedRasterGlyph kernedRasterGlyph = (KernedRasterGlyph)this.glyphCache.get(l);
        if (kernedRasterGlyph == null) {
            if (this.isComplexCharacter(c2)) {
                throw new UnsupportedEncodingException("Script not supported.");
            }
            kernedRasterGlyph = new KernedRasterGlyph(l, (Font)this, c2, n);
            this.addGlyph(l, kernedRasterGlyph);
        }
        if (!$assertionsDisabled && (kernedRasterGlyph.getCharacter() != c2 || kernedRasterGlyph.getSize() != n || kernedRasterGlyph.isCharacterGlyphIndex())) {
            throw new AssertionError((Object)new StringBuffer().append("glyphCache returned wrong glyph: character").append(c2).append(" size:").append(n).append("glyph: ").append(kernedRasterGlyph).toString());
        }
        return kernedRasterGlyph;
    }

    private boolean isComplexCharacter(char c2) {
        return this.complexScriptRanges != null && KernedRasterFont.containsChar(this.complexScriptRanges, c2);
    }

    private void addGlyph(long l, KernedRasterGlyph kernedRasterGlyph) {
        this.glyphCache.put(l, kernedRasterGlyph);
        this.glyphMap.put(l, kernedRasterGlyph);
    }

    private long createGlyphKey(boolean bl, int n, int n2) {
        this.hcb.reset();
        this.hcb.append(this.fontId);
        this.hcb.append(bl);
        this.hcb.append(n);
        this.hcb.append(n2);
        return this.hcb.longHashCode();
    }

    @Override
    public GlyphBitmap getGlyphBitmap(Glyph glyph, GlyphStyle glyphStyle) {
        KernedRasterGlyph kernedRasterGlyph = (KernedRasterGlyph)glyph;
        BitmappedGlyph bitmappedGlyph = kernedRasterGlyph.getBitmappedGlyph(glyphStyle);
        if (bitmappedGlyph == null) {
            long l;
            Logger logger = this.getLogger();
            LogMessage logMessage = logger.isTraceEnabled(4) ? logger.trace(4) : null;
            boolean bl = logMessage != null && logger.isTraceEnabled(128);
            NativeGlyph nativeGlyph = null;
            long l2 = l = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
            if (MOCK_SPI_CALLS) {
                NativeImage nativeImage = new NativeImage(ByteBuffer.allocateDirect(1), 1, 1, 4096);
                nativeGlyph = new NativeGlyph((char)glyph.getCharacter(), nativeImage, 0, 0, 64);
            } else if (!kernedRasterGlyph.isCharacterGlyphIndex()) {
                int n = glyphStyle.isBold() ? 1 : 0;
                n |= glyphStyle.isItalic() ? 2 : 0;
                n |= glyphStyle.isHintingDisabled() ? 0x800000 : 0;
                nativeGlyph = ServiceManager.fontSPI.getGlyph(this.fontId, (char)kernedRasterGlyph.getCharacter(), n |= glyphStyle.isByteCodeHintingDisabled() ? 256 : 0, glyphStyle.getFontSize());
            } else {
                nativeGlyph = ServiceManager.fontSPI.getGlyphById(glyphStyle, kernedRasterGlyph.getCharacter());
            }
            long l3 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
            long l4 = this.hcb.reset().append(this.fontId).append(glyph.isCharacterGlyphIndex()).append(glyph.getCharacter()).append(glyph.getSize()).append(glyphStyle.isBold()).append(glyphStyle.isByteCodeHintingDisabled()).append(glyphStyle.isHintingDisabled()).append(glyphStyle.isItalic()).longHashCode();
            BufferImage bufferImage = new BufferImage(l4, nativeGlyph.bitmap.getBuffer(), nativeGlyph.bitmap.getFormat(), nativeGlyph.bitmap.getWidth(), nativeGlyph.bitmap.getHeight());
            bitmappedGlyph = new BitmappedGlyph(bufferImage, nativeGlyph.leftOffset, nativeGlyph.topOffset, nativeGlyph.horizontalAdvance);
            if (!$assertionsDisabled && nativeGlyph.bitmap.buffer.capacity() < nativeGlyph.bitmap.getHeight() * nativeGlyph.bitmap.getWidth()) {
                throw new AssertionError((Object)new StringBuffer().append("NativeGlyph buffer too small: ").append(nativeGlyph.bitmap.buffer.remaining()).append(" < ").append(nativeGlyph.bitmap.getHeight() * nativeGlyph.bitmap.getWidth()).append(" bytes").toString());
            }
            if (logMessage != null) {
                logMessage.append("getGlyphBitmap(Font: ").append(this.getName()).append(", Char: '").append((char)kernedRasterGlyph.getCharacter()).append(", isCharacterCodeGlyphIndex: ").append(kernedRasterGlyph.isCharacterGlyphIndex()).append("', Size: ").append(kernedRasterGlyph.getSize()).append(", Style: ").append(glyphStyle).append(") = ").append(bufferImage.getWidth()).append("x").append(bufferImage.getHeight()).append(" Format ").append(bufferImage.getImageFormat()).append(" = ").append(bufferImage.getByteSize()).append(" bytes");
                if (bl) {
                    logMessage.append(": ").append(l3 - l).append("\u00b5s");
                }
                logMessage.log();
                if (PRINT_GLYPH_BITMAP) {
                    LogMessage logMessage2 = logger.trace(4);
                    logMessage2.append("Glyph Bitmap:\n");
                    for (int i2 = 0; i2 < nativeGlyph.bitmap.height; ++i2) {
                        for (int i3 = 0; i3 < nativeGlyph.bitmap.width; ++i3) {
                            logMessage2.append((nativeGlyph.bitmap.buffer.get() & 0xFF) != 0 ? "*" : " ");
                        }
                        logMessage2.append("\n");
                    }
                    logMessage2.log();
                }
            }
            kernedRasterGlyph.addBitmappedGlyph(glyphStyle, bitmappedGlyph);
        }
        return bitmappedGlyph;
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$font$internal$KernedRasterFont == null ? (class$de$vw$mib$graphics$font$internal$KernedRasterFont = KernedRasterFont.class$("de.vw.mib.graphics.font.internal.KernedRasterFont")) : class$de$vw$mib$graphics$font$internal$KernedRasterFont).desiredAssertionStatus();
        MOCK_SPI_CALLS = System.getProperty("de.vw.mib.graphics.font.mockspi") != null;
        PRINT_GLYPH_BITMAP = System.getProperty("de.vw.mib.graphics.font.printglyphbitmap") != null;
    }
}

