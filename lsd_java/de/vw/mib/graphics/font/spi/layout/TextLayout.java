/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.spi.layout;

import de.vw.mib.graphics.font.spi.layout.TextLineLayout;

public interface TextLayout {
    default public boolean isTruncated() {
    }

    default public int getWidth() {
    }

    default public int getHeight() {
    }

    default public int getLineCount() {
    }

    default public TextLineLayout getTextLine(int n) {
    }
}

