/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.widgets.speller.asia.AsiaCache;
import de.vw.mib.widgets.speller.asia.AsiaPhraseBuffer;
import de.vw.mib.widgets.speller.asia.ExtendedAsiaAdapter;

final class AsiaDatabase$AsiaPhraseBufferHandler
extends ExtendedAsiaAdapter {
    private final AsiaPhraseBuffer buffer;
    private final AsiaCache cache;

    public AsiaDatabase$AsiaPhraseBufferHandler(AsiaPhraseBuffer asiaPhraseBuffer, AsiaCache asiaCache) {
        this.buffer = asiaPhraseBuffer;
        this.cache = asiaCache;
    }

    @Override
    public void asiaSelectedCandidate(int n) {
        String[] stringArray = this.cache.getCandidates();
        if (stringArray != null && n >= 0 && n < stringArray.length) {
            this.buffer.addPhrase(stringArray[n]);
        }
    }
}

