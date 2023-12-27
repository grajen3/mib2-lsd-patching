/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.Drawable;
import de.vw.mib.graphics.font.spi.layout.TextLineLayout;
import de.vw.mib.widgets.ui.AbstractTextUI$TextAttributeDrawableCreator$1;
import de.vw.mib.widgets.ui.AbstractTextUI$TextAttributeDrawableCreator$2;
import de.vw.mib.widgets.ui.AbstractTextUI$TextAttributeDrawableCreator$3;

interface AbstractTextUI$TextAttributeDrawableCreator {
    public static final AbstractTextUI$TextAttributeDrawableCreator HIGHLIGHT_BACKGROUND_DRAWABLE_CREATOR = new AbstractTextUI$TextAttributeDrawableCreator$1();
    public static final AbstractTextUI$TextAttributeDrawableCreator UNDERLINE_DRAWABLE_CREATOR = new AbstractTextUI$TextAttributeDrawableCreator$2();
    public static final AbstractTextUI$TextAttributeDrawableCreator STRIKEOUT_DRAWABLE_CREATOR = new AbstractTextUI$TextAttributeDrawableCreator$3();

    default public Drawable createDrawable(Graphics3D graphics3D, TextLineLayout textLineLayout, int n, int n2) {
    }
}

