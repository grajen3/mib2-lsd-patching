/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.drawable.Drawable;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.widgets.models.ScrollableTextModel$Tab;
import de.vw.mib.widgets.models.ScrollableTextModel$TabbedRow;
import de.vw.mib.widgets.models.ScrollableTextModel$TabbedTextLayout;
import de.vw.mib.widgets.ui.AbstractTextUI;
import java.util.ArrayList;
import java.util.List;

final class ScrollableTextUI$Page {
    private static final int INITIAL_DRAWABLE_LIST_SIZE;
    private final ScrollableTextModel$TabbedTextLayout tabbedTextLayout;
    private final Font font;
    private final int height;
    private final Color4b textForegroundColor;
    private int y;
    private boolean valid;
    private List tabDrawables;
    private List tabDrawableColors;
    private List tabPositions;

    public ScrollableTextUI$Page(ScrollableTextModel$TabbedTextLayout scrollableTextModel$TabbedTextLayout, Font font, Color4b color4b, int n) {
        this.tabbedTextLayout = scrollableTextModel$TabbedTextLayout;
        this.font = font;
        this.valid = false;
        this.tabDrawables = new ArrayList(5);
        this.tabPositions = new ArrayList(5);
        this.tabDrawableColors = new ArrayList(5);
        this.textForegroundColor = color4b;
        this.y = 0;
        this.height = n;
    }

    public void setY(int n) {
        if (n != this.y) {
            this.y = n;
            this.valid = false;
        }
    }

    public void draw(Graphics3D graphics3D, int n, int n2) {
        if (!this.valid) {
            this.update(graphics3D);
            this.valid = true;
        }
        for (int i2 = this.tabPositions.size() - 1; i2 >= 0; --i2) {
            Point point = (Point)this.tabPositions.get(i2);
            Drawable drawable = (Drawable)this.tabDrawables.get(i2);
            drawable.setColor((Color4b)this.tabDrawableColors.get(i2));
            drawable.draw(n + point.x, n2 + point.y);
        }
    }

    private void update(Graphics3D graphics3D) {
        int n = ScrollableTextUI$Page.findFirstRow(this.y, this.tabbedTextLayout);
        int n2 = ScrollableTextUI$Page.findLastRow(this.y + this.height, this.tabbedTextLayout);
        this.tabPositions.clear();
        AbstractTextUI.removeObsoleteDisposables(this.tabDrawables, 0);
        this.tabDrawableColors.clear();
        for (int i2 = n; i2 <= n2; ++i2) {
            ScrollableTextModel$TabbedRow scrollableTextModel$TabbedRow = this.tabbedTextLayout.rows[i2];
            ScrollableTextModel$Tab[] scrollableTextModel$TabArray = scrollableTextModel$TabbedRow.getTabs();
            for (int i3 = 0; i3 < scrollableTextModel$TabArray.length; ++i3) {
                int n3;
                int n4;
                int n5;
                int n6;
                ScrollableTextModel$Tab scrollableTextModel$Tab = scrollableTextModel$TabArray[i3];
                TextLayout textLayout = scrollableTextModel$Tab.getTextLayout();
                if (textLayout == null || (n6 = ScrollableTextUI$Page.getFirstTextLine(this.y - scrollableTextModel$TabbedRow.getY(), textLayout)) > (n5 = ScrollableTextUI$Page.getLastTextLine(this.y + this.height - scrollableTextModel$TabbedRow.getY(), textLayout)) || n6 == -1 || n5 == -1 || (n4 = textLayout.getFirstSourceIndex(n6)) > (n3 = textLayout.getLastSourceIndex(n5))) continue;
                AbstractTextUI.createDrawables(graphics3D, scrollableTextModel$Tab.getTextHighlights(), scrollableTextModel$Tab.getTextLayout(), scrollableTextModel$Tab.getTextStyles(), this.font, this.textForegroundColor, n4, n3, this.tabDrawables, this.tabDrawableColors);
                while (this.tabDrawables.size() > this.tabPositions.size()) {
                    this.tabPositions.add(new Point(scrollableTextModel$Tab.getX(), scrollableTextModel$TabbedRow.getY()));
                }
            }
        }
    }

    public void dispose() {
        AbstractTextUI.removeObsoleteDisposables(this.tabDrawables, 0);
    }

    private static int findFirstRow(int n, ScrollableTextModel$TabbedTextLayout scrollableTextModel$TabbedTextLayout) {
        int n2;
        for (n2 = 0; n2 < scrollableTextModel$TabbedTextLayout.rows.length && n > scrollableTextModel$TabbedTextLayout.rows[n2].getY() + scrollableTextModel$TabbedTextLayout.rows[n2].getHeight(); ++n2) {
        }
        return n2;
    }

    private static int findLastRow(int n, ScrollableTextModel$TabbedTextLayout scrollableTextModel$TabbedTextLayout) {
        int n2;
        for (n2 = scrollableTextModel$TabbedTextLayout.rows.length - 1; n2 > 0 && n < scrollableTextModel$TabbedTextLayout.rows[n2].getY(); --n2) {
        }
        return n2;
    }

    private static int getFirstTextLine(int n, TextLayout textLayout) {
        int n2;
        for (n2 = 0; n2 < textLayout.getLineCount() && (n > textLayout.getTextLine(n2).getBaseline() - textLayout.getTextLine(n2).getBottom() || textLayout.getTextLine(n2).getGlyphCount() == 0); ++n2) {
        }
        return n2 == textLayout.getLineCount() ? -1 : n2;
    }

    private static int getLastTextLine(int n, TextLayout textLayout) {
        int n2;
        for (n2 = textLayout.getLineCount() - 1; n2 >= 0 && (n <= textLayout.getTextLine(n2).getBaseline() - textLayout.getTextLine(n2).getBottom() || textLayout.getTextLine(n2).getGlyphCount() == 0); --n2) {
        }
        return n2;
    }
}

