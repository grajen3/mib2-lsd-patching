/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui.util;

import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.offscreen.OffscreenDrawable;
import de.vw.mib.widgets.interfaces.DecoratableUI;
import de.vw.mib.widgets.ui.util.decoration.internal.AbstractDecoration;

final class EffectDecorator$NullDecoration
extends AbstractDecoration {
    public EffectDecorator$NullDecoration(AbstractDecoration abstractDecoration) {
        super(abstractDecoration);
    }

    @Override
    protected void resize(Dimension dimension) {
    }

    @Override
    protected void createDecoration(Graphics3D graphics3D, DecoratableUI decoratableUI, Rectangle rectangle, Rectangle rectangle2, OffscreenDrawable offscreenDrawable, OffscreenDrawable offscreenDrawable2) {
        offscreenDrawable2.prepareGraphics(graphics3D, rectangle, 0);
        if (offscreenDrawable != null) {
            offscreenDrawable.draw();
        }
        graphics3D.setBlendingEnabled(true);
        decoratableUI.drawDecoratableContent(graphics3D, rectangle2, rectangle);
        graphics3D.setBlendingEnabled(false);
        offscreenDrawable2.restoreGraphics(graphics3D, rectangle);
    }
}

