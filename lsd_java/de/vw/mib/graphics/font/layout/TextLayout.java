/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.layout;

import de.vw.mib.cache.Cacheable;
import de.vw.mib.graphics.Referenceable;

public interface TextLayout
extends de.vw.mib.graphics.font.spi.layout.TextLayout,
Referenceable,
Cacheable {
    default public long getId() {
    }

    default public boolean isGlyphIdCharacterCode() {
    }

    default public String getText() {
    }

    default public boolean isTextlineRtl(int n) {
    }

    default public int getLastGlyphIndex(int n) {
    }

    default public int getLastSourceIndex(int n) {
    }

    default public int getFirstSourceIndex(int n) {
    }

    default public int findRowBySourceIndex(int n) {
    }
}

