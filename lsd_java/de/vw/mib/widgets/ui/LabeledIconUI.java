/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.text.TextDrawable;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.style.TextStyle;
import de.vw.mib.widgets.models.LabeledIconModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.DynamicImageUI;

public final class LabeledIconUI
extends DynamicImageUI {
    private TextDrawable textDrawable;

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        if (this.textDrawable != null) {
            this.textDrawable.dispose();
            this.textDrawable = null;
        }
        super.deInit();
    }

    @Override
    protected void paintImage(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, Color4b color4b, float f2) {
        LabeledIconModel labeledIconModel = (LabeledIconModel)widgetModel;
        if (!labeledIconModel.isFallbackMode()) {
            super.paintImage(graphics3D, viewModel, widgetModel, rectangle, rectangle2, color4b, f2);
        }
        if (labeledIconModel.isTextDisplayEnabled() && labeledIconModel.getTextLayout() != null) {
            TextStyle[] textStyleArray;
            Object object;
            boolean bl = labeledIconModel.isDirty();
            if (this.textDrawable == null) {
                this.textDrawable = graphics3D.getDrawableManager().createTextDrawable();
                bl = true;
            }
            if (bl) {
                object = labeledIconModel.getTextLayout();
                textStyleArray = labeledIconModel.getTextStyles();
                this.textDrawable.setTextLayout((TextLayout)object);
                this.textDrawable.setTextStyles(textStyleArray);
                this.textDrawable.setFont(labeledIconModel.getFontRenderer());
                this.textDrawable.setIntervalStart(0);
                this.textDrawable.setIntervalEnd(-129);
            }
            object = labeledIconModel.getTextPosition();
            textStyleArray = labeledIconModel.getTextColor();
            this.textDrawable.setAlpha(f2);
            this.textDrawable.setColor((Color4b)textStyleArray);
            this.textDrawable.draw(((Point)object).x, ((Point)object).y);
        }
    }
}

