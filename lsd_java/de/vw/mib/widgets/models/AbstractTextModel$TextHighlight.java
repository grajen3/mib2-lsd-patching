/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Color;

public class AbstractTextModel$TextHighlight {
    private int startOffset;
    private int endOffset;
    private Color colorForeground;
    private Color colorBackground;

    public AbstractTextModel$TextHighlight() {
    }

    public AbstractTextModel$TextHighlight(int n, int n2, Color color, Color color2) {
        this.set(n, n2, color, color2);
    }

    public void set(int n, int n2, Color color, Color color2) {
        this.startOffset = n;
        this.endOffset = n2;
        this.colorForeground = color;
        this.colorBackground = color2;
    }

    public int getStartOffset() {
        return this.startOffset;
    }

    public int getEndOffset() {
        return this.endOffset;
    }

    public Color getColorForeground() {
        return this.colorForeground;
    }

    public Color getColorBackground() {
        return this.colorBackground;
    }
}

