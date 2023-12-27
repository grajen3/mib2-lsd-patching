/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.Disposable;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.style.TextStyle;
import java.util.List;

public final class ScrollableTextModel$Tab
implements Disposable {
    private final int x;
    private final TextLayout textLayout;
    private final List textHighlights;
    private final TextStyle[] textStyles;

    public ScrollableTextModel$Tab(int n, TextLayout textLayout, List list, TextStyle[] textStyleArray) {
        this.x = n;
        this.textLayout = textLayout;
        this.textHighlights = list;
        this.textStyles = textStyleArray;
    }

    public int getX() {
        return this.x;
    }

    public TextLayout getTextLayout() {
        return this.textLayout;
    }

    public List getTextHighlights() {
        return this.textHighlights;
    }

    public TextStyle[] getTextStyles() {
        return this.textStyles;
    }

    @Override
    public void dispose() {
        if (this.textLayout != null) {
            this.textLayout.dispose();
        }
        if (this.textStyles != null) {
            for (int i2 = 0; i2 < this.textStyles.length; ++i2) {
                this.textStyles[i2].dispose();
            }
        }
    }
}

