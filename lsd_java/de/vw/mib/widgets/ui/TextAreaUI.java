/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.Drawable;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.widgets.models.TextAreaModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractTextUI;
import java.util.ArrayList;
import java.util.List;

public class TextAreaUI
extends AbstractTextUI {
    private List drawables;
    private List drawableColors;
    private List fadeInDrawables;
    private List fadeInDrawableColors;

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        if (this.drawables != null) {
            TextAreaUI.removeObsoleteDisposables(this.drawables, 0);
            this.drawables = null;
            this.drawableColors = null;
        }
        if (this.fadeInDrawables != null) {
            TextAreaUI.removeObsoleteDisposables(this.fadeInDrawables, 0);
            this.fadeInDrawables = null;
            this.drawableColors = null;
        }
        super.deInit();
    }

    @Override
    protected void paintContent(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2, TextLayout textLayout, Color4b color4b, int n, int n2) {
        int n3;
        List list;
        List list2;
        if (textLayout == null) {
            return;
        }
        TextAreaModel textAreaModel = (TextAreaModel)widgetModel;
        boolean bl = textAreaModel.isInvalid();
        boolean bl2 = true;
        boolean bl3 = true;
        if (textAreaModel.isContentFadeInAnimationActive() && textAreaModel.getContentFadeInTextLines() == textLayout) {
            if (this.fadeInDrawables == null) {
                this.fadeInDrawables = new ArrayList(1);
                this.fadeInDrawableColors = new ArrayList(1);
                bl = true;
            }
            list2 = this.fadeInDrawables;
            list = this.fadeInDrawableColors;
        } else {
            if (this.drawables == null) {
                this.drawables = new ArrayList(1);
                this.drawableColors = new ArrayList(1);
                bl = true;
            }
            list2 = this.drawables;
            list = this.drawableColors;
        }
        if (bl) {
            TextAreaUI.removeObsoleteDisposables(list2, 0);
            list.clear();
            TextAreaUI.createDrawables(graphics3D, textAreaModel.getTextHighlights(), textLayout, textAreaModel.getTextStyles(), textAreaModel.getFont(), color4b, list2, list);
        }
        Insets insets = textAreaModel.get_padding();
        int n4 = textAreaModel.get_dynamicResizeDirection() == 1 && textAreaModel.get_alignmentHorizontal() != 0 ? n - textAreaModel.get_dynamicSize() + textLayout.getWidth() : n;
        switch (textAreaModel.get_alignmentVertical()) {
            case 1: {
                n3 = n2 + (textAreaModel.get_height() >> 1) - (textLayout.getHeight() >> 1) + textAreaModel.get_baselineOffset();
                break;
            }
            case 2: {
                n3 = n2 + textAreaModel.get_height() - textLayout.getHeight() - insets.bottom + textAreaModel.get_baselineOffset();
                break;
            }
            default: {
                n3 = n2 + insets.top + textAreaModel.get_baselineOffset();
            }
        }
        boolean bl4 = list2.size() == 1;
        for (int i2 = list2.size() - 1; i2 >= 0; --i2) {
            Drawable drawable = (Drawable)list2.get(i2);
            if (bl4) {
                drawable.setColor(color4b);
            } else {
                drawable.setColor((Color4b)list.get(i2));
            }
            drawable.setAlpha(f2);
            drawable.draw(n4 + insets.left, n3);
        }
    }
}

