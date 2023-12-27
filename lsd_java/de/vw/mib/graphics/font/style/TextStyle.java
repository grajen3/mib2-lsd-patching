/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.style;

import de.vw.mib.graphics.Referenceable;
import de.vw.mib.graphics.font.style.GlyphStyle;

public interface TextStyle
extends de.vw.mib.graphics.font.spi.style.TextStyle,
Referenceable {
    public static final int HORIZONTAL_ALIGNMENT_LEFT;
    public static final int HORIZONTAL_ALIGNMENT_CENTER;
    public static final int HORIZONTAL_ALIGNMENT_RIGHT;
    public static final int LINEBREAK_MODE_DEFAULT;
    public static final int LINEBREAK_MODE_CHARACTER;

    default public GlyphStyle getFontGlyphStyle() {
    }
}

