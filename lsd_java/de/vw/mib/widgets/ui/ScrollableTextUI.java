/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.widgets.models.ScrollableTextModel;
import de.vw.mib.widgets.models.ScrollableTextModel$TabbedTextLayout;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractTextUI;
import de.vw.mib.widgets.ui.ScrollableTextUI$Page;

public final class ScrollableTextUI
extends AbstractTextUI {
    private static final int PAGE_COUNT;
    private Rectangle clipRect = new Rectangle();
    private Rectangle viewport = new Rectangle();
    private ScrollableTextUI$Page[] pages = new ScrollableTextUI$Page[3];

    @Override
    public void deInit() {
        this.disposePages();
        super.deInit();
    }

    @Override
    protected void paintContent(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2, TextLayout textLayout, Color4b color4b, int n, int n2) {
        if (textLayout != null) {
            ScrollableTextModel scrollableTextModel = (ScrollableTextModel)widgetModel;
            scrollableTextModel.getViewPort(this.viewport);
            int n3 = this.viewport.height * 66 / 100;
            if (n3 > 0) {
                int n4 = this.viewport.y / n3;
                Insets insets = scrollableTextModel.get_padding();
                int n5 = scrollableTextModel.get_baselineOffset();
                if (scrollableTextModel.isDirty()) {
                    this.clipRect.setBounds(insets.left, 0, scrollableTextModel.get_width() - insets.left - insets.right, scrollableTextModel.get_height());
                    this.disposePages();
                }
                this.enableClipping(graphics3D, rectangle, this.clipRect, rectangle2);
                for (int i2 = 0; i2 < 3; ++i2) {
                    int n6 = (n4 + i2) % 3;
                    int n7 = (n4 + i2) * n3;
                    if (n7 < 0) continue;
                    if (this.pages[n6] == null) {
                        this.pages[n6] = new ScrollableTextUI$Page((ScrollableTextModel$TabbedTextLayout)textLayout, scrollableTextModel.getFont(), color4b, n3);
                    }
                    this.pages[n6].setY(n7);
                    this.pages[n6].draw(graphics3D, insets.left, insets.top - this.viewport.y + n5);
                }
                this.disableClipping(graphics3D);
            }
        }
    }

    private void disposePages() {
        if (this.pages != null) {
            for (int i2 = 0; i2 < this.pages.length; ++i2) {
                if (this.pages[i2] == null) continue;
                this.pages[i2].dispose();
                this.pages[i2] = null;
            }
        }
    }
}

