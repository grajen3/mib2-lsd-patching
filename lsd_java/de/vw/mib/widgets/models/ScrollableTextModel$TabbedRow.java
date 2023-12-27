/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.Disposable;
import de.vw.mib.widgets.models.ScrollableTextModel$Tab;

public final class ScrollableTextModel$TabbedRow
implements Disposable {
    private final int y;
    private final int height;
    private final ScrollableTextModel$Tab[] tabs;

    public ScrollableTextModel$TabbedRow(int n, int n2, ScrollableTextModel$Tab[] scrollableTextModel$TabArray) {
        this.y = n;
        this.tabs = scrollableTextModel$TabArray;
        this.height = n2;
    }

    public int getY() {
        return this.y;
    }

    public int getHeight() {
        return this.height;
    }

    public ScrollableTextModel$Tab[] getTabs() {
        return this.tabs;
    }

    public int getLineCount() {
        int n = 0;
        for (int i2 = 0; i2 < this.tabs.length; ++i2) {
            n = Math.max(n, this.tabs[i2].getTextLayout().getLineCount());
        }
        return n;
    }

    @Override
    public void dispose() {
        if (this.tabs != null) {
            for (int i2 = 0; i2 < this.tabs.length; ++i2) {
                this.tabs[i2].dispose();
                this.tabs[i2] = null;
            }
        }
    }
}

