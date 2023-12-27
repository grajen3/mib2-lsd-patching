/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font;

import de.vw.mib.Disposable;
import de.vw.mib.graphics.font.Font;

public interface Glyph
extends Disposable {
    default public long getId() {
    }

    default public int getCharacter() {
    }

    default public boolean isCharacterGlyphIndex() {
    }

    default public Font getFont() {
    }

    default public int getSize() {
    }

    default public boolean wasGlyphAvailableSet() {
    }

    default public void setGlyphAvailable(boolean bl) {
    }

    default public boolean isGlyphAvailable() {
    }
}

