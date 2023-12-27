/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.cache.AbstractCache$Entry;
import de.vw.mib.cache.LRUCache;
import de.vw.mib.cache.policies.MaximumObjectCountCachingPolicy;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

public final class TextLayoutCache
extends LRUCache {
    private final Logger logger;

    public TextLayoutCache(Logger logger, int n) {
        super(new MaximumObjectCountCachingPolicy(n), true);
        this.logger = logger;
    }

    @Override
    protected boolean canEvict(AbstractCache$Entry abstractCache$Entry) {
        TextLayout textLayout = (TextLayout)abstractCache$Entry.getValue();
        return !textLayout.isReferenced();
    }

    @Override
    protected void evict(AbstractCache$Entry abstractCache$Entry) {
        TextLayout textLayout = (TextLayout)abstractCache$Entry.getValue();
        if (this.logger.isTraceEnabled(32)) {
            LogMessage logMessage = this.logger.trace(32);
            logMessage.append("Evicting textlayout ").append(textLayout).append(" from cache");
            logMessage.log();
        }
        textLayout.dispose();
        super.evict(abstractCache$Entry);
    }
}

