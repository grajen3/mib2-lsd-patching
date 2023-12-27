/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.Glyph;
import de.vw.mib.util.StringBuilder;

public abstract class AbstractGlyph
implements Glyph {
    private final long id;
    private final Font font;
    private final int character;
    private final boolean characterIsGlyphIndex;
    private final int size;
    private int glyphAvailable;

    public AbstractGlyph(long l, Font font, int n, int n2) {
        this.id = l;
        this.font = font;
        this.character = n;
        this.characterIsGlyphIndex = true;
        this.size = n2;
        this.glyphAvailable = 0;
    }

    public AbstractGlyph(long l, Font font, char c2, int n, int n2) {
        this.id = l;
        this.font = font;
        this.size = n;
        this.character = c2;
        this.characterIsGlyphIndex = false;
        this.glyphAvailable = 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[font=").append(this.getFont());
        stringBuilder.append(",character='").append((char)this.character).append("'");
        stringBuilder.append(",size=").append(this.size);
        stringBuilder.append(",characterIsGlyphIndex=").append(this.characterIsGlyphIndex);
        stringBuilder.append(",glyphAvailable=").append(this.glyphAvailable);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public abstract void dispose() {
    }

    @Override
    public final long getId() {
        return this.id;
    }

    @Override
    public final Font getFont() {
        return this.font;
    }

    @Override
    public final int getCharacter() {
        return this.character;
    }

    @Override
    public final boolean isCharacterGlyphIndex() {
        return this.characterIsGlyphIndex;
    }

    @Override
    public final int getSize() {
        return this.size;
    }

    @Override
    public final void setGlyphAvailable(boolean bl) {
        this.glyphAvailable = bl ? 1 : -1;
    }

    @Override
    public final boolean wasGlyphAvailableSet() {
        return this.glyphAvailable != 0;
    }

    @Override
    public final boolean isGlyphAvailable() {
        return this.glyphAvailable == 1;
    }
}

