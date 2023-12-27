/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font;

import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.Glyph;

public interface KernedFont
extends Font {
    default public int getKerning(char c2, char c3, int n) {
    }

    default public int getKerning(Glyph glyph, char c2) {
    }
}

