/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.cache.Cacheable;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.internal.AbstractFontManager;
import de.vw.mib.graphics.font.internal.FontCache;
import de.vw.mib.graphics.font.internal.FontProperties;
import de.vw.mib.graphics.font.internal.GlyphCache;
import de.vw.mib.graphics.font.internal.KernedRasterFont;
import de.vw.mib.graphics.font.internal.LinkedFont;
import de.vw.mib.graphics.font.internal.ServiceManager;
import de.vw.mib.graphics.performance.CachePerformanceMetrics;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import java.io.File;
import java.io.IOException;

public final class CachingFontManager
extends AbstractFontManager {
    private static final String GLYPHCACHE_SIZE_MIB;
    private static final String DEFAULT_FONT_NAME;
    private final Logger logger;
    private final FontCache fontCache;
    private final GlyphCache glyphCache;
    private final HashCodeBuilder hcb;
    private FontProperties fontProperties;
    private final boolean nativeLayoutAvailable;

    CachingFontManager(LoggerFactory loggerFactory) {
        this.logger = loggerFactory.getLogger(256);
        int n = 4096;
        int n2 = Integer.getInteger("de.vw.mib.graphics.font.glyphcachesizemib", ServiceManager.configurationManager.getGraphicsFontCacheSizeMiB());
        int n3 = n2 * 4096;
        this.fontCache = new FontCache();
        int n4 = n3;
        this.glyphCache = new GlyphCache(this.logger, n4);
        this.logger.normal(2).append("Limiting font cache size to ").append(n2).append("MiB (").append(n4).append(" bytes as glyph cache)").log();
        this.hcb = new HashCodeBuilder();
        this.nativeLayoutAvailable = ServiceManager.fontSPI.isTextLayoutingAvailable();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public Font getDefaultFont() {
        return this.getFontFromCommonSkin("Default.ttf");
    }

    @Override
    public Font getFontFromCommonSkin(String string) {
        return this.getFontFromSkin(ServiceManager.configurationManager.getCommonSkinId(), string);
    }

    @Override
    public Font getFontFromCurrentSkin(String string) {
        return this.getFontFromSkin(ServiceManager.configurationManager.getCurrentSkinId(), string);
    }

    private Font getFontFromSkin(int n, String string) {
        boolean bl = ServiceManager.configurationManager.isFeatureFlagSet(28) && this.nativeLayoutAvailable;
        long l = this.hcb.reset().append(n).append(string).append(bl).longHashCode();
        Font font = (Font)((Object)this.fontCache.get(l));
        if (font == null) {
            font = this.getLinkedFont(n, string, bl);
            this.fontCache.put(l, (Cacheable)((Object)font));
        }
        return font;
    }

    public Font getLinkedFont(int n, String string, boolean bl) {
        int n2;
        char[][] cArray;
        if (this.fontProperties == null || this.fontProperties.skinId != n) {
            this.fontProperties = CachingFontManager.openFontProperties(n, this.logger);
        }
        char[][] cArray2 = cArray = (n2 = this.fontProperties.getFontId(string)) != -1 ? this.fontProperties.complexScriptRanges[n2] : (char[][])null;
        if (bl) {
            if (n2 != -1 && this.fontProperties.complexScriptFonts[n2] != null) {
                return new KernedRasterFont(this.logger, this.glyphCache, n, this.fontProperties.complexScriptFonts[n2], cArray);
            }
            if (n2 != -1 && this.fontProperties.linkedFonts[n2].length > 0) {
                String[][] stringArray = this.fontProperties.linkedFonts[n2];
                if (ServiceManager.configurationManager.isArabicAvailable()) {
                    for (int i2 = 0; i2 < stringArray.length; ++i2) {
                        if (!stringArray[i2][1].equals("ar_SA")) continue;
                        if (this.logger.isTraceEnabled(2)) {
                            LogMessage logMessage = this.logger.trace(2);
                            logMessage.append("Arabic language is available -> FontLinking Disabled -> use arabic font '").append(stringArray[i2][0]).append("' as main font instead of '").append(string).append("'").log();
                        }
                        return new KernedRasterFont(this.logger, this.glyphCache, n, stringArray[i2][0], cArray);
                    }
                }
            }
        } else if (n2 != -1 && this.fontProperties.linkedFonts[n2].length > 0) {
            return new LinkedFont(this.logger, this, this.glyphCache, n, string, this.fontProperties.exclusionRanges[n2], this.fontProperties.linkedFonts[n2], cArray);
        }
        return new KernedRasterFont(this.logger, this.glyphCache, n, string, cArray);
    }

    private static FontProperties openFontProperties(int n, Logger logger) {
        String[] stringArray = ServiceManager.configurationManager.getAvailableLanguages();
        if (logger.isTraceEnabled(2)) {
            LogMessage logMessage = logger.trace(2);
            logMessage.append("Opening font linking properties for skin '").append(n).append("'. Preferred languages are: ");
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                logMessage.append(stringArray[i2]).append(" ");
            }
            logMessage.log();
        }
        try {
            return ServiceManager.fontPropertiesLoader.openFontProperties(n, new File(ServiceManager.configurationManager.getCurrentFontPath()), stringArray);
        }
        catch (IOException iOException) {
            LogMessage logMessage = logger.error(2);
            logMessage.append("Error opening the linked font properties file. Text display will be defective. ");
            logMessage.attachThrowable(iOException);
            logMessage.log();
            return new FontProperties(n);
        }
    }

    @Override
    public CachePerformanceMetrics getFontCacheUsage() {
        return new CachePerformanceMetrics(this.fontCache.size(), this.fontCache.getByteSize(), 0, this.fontCache.hits(), this.fontCache.misses());
    }

    @Override
    public CachePerformanceMetrics getGlyphCacheUsage() {
        return new CachePerformanceMetrics(this.glyphCache.size(), this.glyphCache.getByteSize(), this.glyphCache.getMaximumCacheSizeBytes(), this.glyphCache.hits(), this.glyphCache.misses());
    }
}

