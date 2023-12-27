/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.Drawable;
import de.vw.mib.graphics.drawable.shape.PolyLineDrawable;
import de.vw.mib.graphics.font.spi.layout.GlyphLayout;
import de.vw.mib.graphics.font.spi.layout.TextLineLayout;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.widgets.ui.AbstractTextUI$TextAttributeDrawableCreator;

final class AbstractTextUI$TextAttributeDrawableCreator$3
implements AbstractTextUI$TextAttributeDrawableCreator {
    AbstractTextUI$TextAttributeDrawableCreator$3() {
    }

    @Override
    public Drawable createDrawable(Graphics3D graphics3D, TextLineLayout textLineLayout, int n, int n2) {
        GlyphLayout glyphLayout = textLineLayout.getGlyph(n);
        GlyphLayout glyphLayout2 = textLineLayout.getGlyph(n2);
        int n3 = textLineLayout.getLeft() + glyphLayout.getX();
        int n4 = textLineLayout.getBaseline() - (textLineLayout.getTop() >> 1);
        Point2f[] point2fArray = new Point2f[]{new Point2f(n3, n4), new Point2f(textLineLayout.getLeft() + glyphLayout2.getX() + glyphLayout2.getWidth(), n4)};
        PolyLineDrawable polyLineDrawable = graphics3D.getDrawableManager().createPolyLineDrawable();
        polyLineDrawable.setClosed(false);
        polyLineDrawable.setStrokeWidth(1.0f);
        polyLineDrawable.setCoordinates2D(point2fArray);
        return polyLineDrawable;
    }
}

