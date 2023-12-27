/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.spi.layout.TextLineLayout;
import de.vw.mib.widgets.models.ScrollableTextModel$TabbedRow;

public final class ScrollableTextModel$TabbedTextLayout
implements TextLayout {
    public final int height;
    public final ScrollableTextModel$TabbedRow[] rows;
    private static HashCodeBuilder hcb;

    public ScrollableTextModel$TabbedTextLayout(int n, ScrollableTextModel$TabbedRow[] scrollableTextModel$TabbedRowArray) {
        this.height = n;
        this.rows = scrollableTextModel$TabbedRowArray;
    }

    @Override
    public void dispose() {
        if (this.rows != null) {
            for (int i2 = 0; i2 < this.rows.length; ++i2) {
                this.rows[i2].dispose();
                this.rows[i2] = null;
            }
        }
    }

    @Override
    public boolean isTruncated() {
        return false;
    }

    @Override
    public int getLineCount() {
        int n = 0;
        for (int i2 = 0; i2 < this.rows.length; ++i2) {
            n += this.rows[i2].getLineCount();
        }
        return n;
    }

    @Override
    public TextLineLayout getTextLine(int n) {
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public long getId() {
        if (hcb == null) {
            hcb = new HashCodeBuilder();
        }
        hcb.reset();
        for (int i2 = 0; i2 < this.rows.length; ++i2) {
            ScrollableTextModel$TabbedRow scrollableTextModel$TabbedRow = this.rows[i2];
            for (int i3 = 0; i3 < scrollableTextModel$TabbedRow.getTabs().length; ++i3) {
                hcb.append(scrollableTextModel$TabbedRow.getTabs()[i2].getTextLayout().getId());
            }
        }
        return hcb.longHashCode();
    }

    @Override
    public int getByteSize() {
        return 0;
    }

    @Override
    public boolean isGlyphIdCharacterCode() {
        return false;
    }

    @Override
    public boolean isReferenced() {
        return false;
    }

    @Override
    public void reference() {
    }

    @Override
    public boolean isTextlineRtl(int n) {
        return false;
    }

    @Override
    public int getLastGlyphIndex(int n) {
        return 0;
    }

    @Override
    public int getLastSourceIndex(int n) {
        return 0;
    }

    @Override
    public int getFirstSourceIndex(int n) {
        return 0;
    }

    @Override
    public int findRowBySourceIndex(int n) {
        return 0;
    }

    @Override
    public String getText() {
        return null;
    }
}

