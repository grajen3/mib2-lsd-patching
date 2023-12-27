/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.Drawable;
import de.vw.mib.graphics.drawable.shape.RectangleDrawable;
import de.vw.mib.graphics.font.spi.layout.GlyphLayout;
import de.vw.mib.graphics.font.spi.layout.TextLineLayout;
import de.vw.mib.widgets.ui.AbstractTextUI$TextAttributeDrawableCreator;

final class AbstractTextUI$TextAttributeDrawableCreator$1
implements AbstractTextUI$TextAttributeDrawableCreator {
    AbstractTextUI$TextAttributeDrawableCreator$1() {
    }

    @Override
    public Drawable createDrawable(Graphics3D graphics3D, TextLineLayout textLineLayout, int n, int n2) {
        GlyphLayout glyphLayout = textLineLayout.getGlyph(n);
        GlyphLayout glyphLayout2 = textLineLayout.getGlyph(n2);
        int n3 = textLineLayout.getLeft() + glyphLayout.getX();
        int n4 = textLineLayout.getBaseline() - textLineLayout.getTop();
        int n5 = textLineLayout.getLeft() + glyphLayout2.getX() + glyphLayout2.getWidth() - n3;
        int n6 = textLineLayout.getTop() - textLineLayout.getBottom();
        RectangleDrawable rectangleDrawable = graphics3D.getDrawableManager().createRectangleDrawable();
        rectangleDrawable.set(n3, n4, n5, n6);
        return rectangleDrawable;
    }
}

