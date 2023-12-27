/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.cache.AbstractCache$Entry;
import de.vw.mib.cache.LRUCache;
import de.vw.mib.cache.policies.CumulativeObjectSizeCachingPolicy;
import de.vw.mib.graphics.font.internal.BitmappedGlyph;
import de.vw.mib.graphics.font.internal.KernedRasterGlyph;
import de.vw.mib.graphics.font.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.nio.ByteBuffer;

public final class GlyphCache
extends LRUCache {
    private final Logger logger;
    private final int maximumCacheSizeBytes;

    public GlyphCache(Logger logger, int n) {
        super(new CumulativeObjectSizeCachingPolicy(n), true);
        this.logger = logger;
        this.maximumCacheSizeBytes = n;
    }

    @Override
    protected boolean canEvict(AbstractCache$Entry abstractCache$Entry) {
        return true;
    }

    @Override
    protected void evict(AbstractCache$Entry abstractCache$Entry) {
        KernedRasterGlyph kernedRasterGlyph = (KernedRasterGlyph)abstractCache$Entry.getValue();
        Object[] objectArray = kernedRasterGlyph.getBitmappedGlyphs();
        if (this.logger.isTraceEnabled(8)) {
            LogMessage logMessage = this.logger.trace(8);
            logMessage.append("Evicting glyph ").append(kernedRasterGlyph).append(" from cache");
            logMessage.log();
        }
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            BitmappedGlyph bitmappedGlyph = (BitmappedGlyph)objectArray[i2];
            ByteBuffer byteBuffer = bitmappedGlyph.getImage().getBuffer();
            if (byteBuffer != null) {
                ServiceManager.fontSPI.releaseGlyph(byteBuffer);
            }
            bitmappedGlyph.dispose();
        }
        super.evict(abstractCache$Entry);
    }

    public int getMaximumCacheSizeBytes() {
        return this.maximumCacheSizeBytes;
    }
}

