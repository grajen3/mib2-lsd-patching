/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui.util;

import de.vw.mib.Disposable;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.offscreen.OffscreenDrawable;
import de.vw.mib.widgets.interfaces.DecoratableUI;
import de.vw.mib.widgets.ui.util.EffectDecorator$NullDecoration;
import de.vw.mib.widgets.ui.util.decoration.ConvolutionDecoration;
import de.vw.mib.widgets.ui.util.decoration.EllipseDecoration;
import de.vw.mib.widgets.ui.util.decoration.OutlineDecoration;
import de.vw.mib.widgets.ui.util.decoration.internal.AbstractDecoration;
import de.vw.mib.widgets.ui.util.decoration.internal.ConvolutionDecorationImpl;
import de.vw.mib.widgets.ui.util.decoration.internal.EllipseDecorationImpl;
import de.vw.mib.widgets.ui.util.decoration.internal.OutlineDecorationImpl;

public final class EffectDecorator
implements Disposable {
    private AbstractDecoration decoration;
    protected final DecoratableUI ui;
    private OffscreenDrawable offscreenDrawable;
    private int offsetX;
    private int offsetY;

    public EffectDecorator(DecoratableUI decoratableUI) {
        this.ui = decoratableUI;
        this.decoration = null;
    }

    public EllipseDecoration addEllipseDecotraion() {
        EllipseDecorationImpl ellipseDecorationImpl = new EllipseDecorationImpl(this.decoration);
        this.decoration = ellipseDecorationImpl;
        return ellipseDecorationImpl;
    }

    public ConvolutionDecoration addConvolutionDecoration() {
        ConvolutionDecorationImpl convolutionDecorationImpl = new ConvolutionDecorationImpl(this.decoration);
        this.decoration = convolutionDecorationImpl;
        return convolutionDecorationImpl;
    }

    public OutlineDecoration addOutlineDecoration() {
        OutlineDecorationImpl outlineDecorationImpl = new OutlineDecorationImpl(this.decoration);
        this.decoration = outlineDecorationImpl;
        return outlineDecorationImpl;
    }

    public void addNullDecoration() {
        this.decoration = new EffectDecorator$NullDecoration(this.decoration);
    }

    public void resetDecoration() {
        if (this.decoration != null) {
            this.decoration.dispose();
            this.decoration = null;
        }
    }

    public boolean isValid() {
        return this.decoration.isValid();
    }

    public void invalidate() {
        this.decoration.invalidate();
    }

    public void draw(Graphics3D graphics3D, Rectangle rectangle, Rectangle rectangle2, float f2) {
        this.draw(graphics3D, rectangle, rectangle2, f2, 0, 0);
    }

    public void draw(Graphics3D graphics3D, Rectangle rectangle, Rectangle rectangle2, float f2, int n, int n2) {
        if (this.offscreenDrawable == null || !this.offscreenDrawable.isValid() || !this.decoration.isValid()) {
            this.create(graphics3D, rectangle, rectangle2);
        }
        this.offscreenDrawable.setAlpha(f2);
        this.offscreenDrawable.draw(n + this.offsetX, n2 + this.offsetY);
    }

    public void create(Graphics3D graphics3D, Rectangle rectangle, Rectangle rectangle2) {
        Dimension dimension = new Dimension(rectangle2.getWidth(), rectangle2.getHeight());
        boolean bl = graphics3D.isBlendingEnabled();
        graphics3D.setBlendingEnabled(false);
        this.offscreenDrawable = this.decoration.forgeDecoration(graphics3D, this.ui, rectangle2, rectangle, dimension);
        this.offsetX = rectangle2.width - dimension.width >> 1;
        this.offsetY = rectangle2.height - dimension.height >> 1;
        graphics3D.setBlendingEnabled(bl);
    }

    @Override
    public void dispose() {
        this.offscreenDrawable = null;
        this.decoration.dispose();
    }
}

