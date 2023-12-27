/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui.util.decoration.internal;

import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.offscreen.OffscreenDrawable;
import de.vw.mib.widgets.interfaces.DecoratableUI;
import de.vw.mib.widgets.ui.util.decoration.Decoration;

public abstract class AbstractDecoration
implements Decoration {
    private AbstractDecoration previous;
    private AbstractDecoration next;
    private OffscreenDrawable offscreenDrawable;
    private boolean isValid;

    public AbstractDecoration(AbstractDecoration abstractDecoration) {
        this.previous = abstractDecoration;
        if (abstractDecoration != null) {
            abstractDecoration.setNextDecoration(this);
        }
        this.isValid = false;
    }

    public void setNextDecoration(AbstractDecoration abstractDecoration) {
        this.next = abstractDecoration;
    }

    public boolean isValid() {
        return this.isValid && this.offscreenDrawable != null && this.offscreenDrawable.isValid();
    }

    public final void invalidate() {
        if (this.isValid) {
            if (this.previous != null) {
                this.previous.invalidate();
            }
            this.isValid = false;
        }
    }

    protected void invalidateNext() {
        if (this.next != null) {
            this.next.invalidateNext();
        }
        this.isValid = false;
    }

    public void dispose() {
        if (this.previous != null) {
            this.previous.dispose();
            this.previous = null;
        }
        this.next = null;
        this.offscreenDrawable.dispose();
        this.offscreenDrawable = null;
    }

    public final OffscreenDrawable forgeDecoration(Graphics3D graphics3D, DecoratableUI decoratableUI, Rectangle rectangle, Rectangle rectangle2, Dimension dimension) {
        if (!this.isValid()) {
            this.isValid = true;
            OffscreenDrawable offscreenDrawable = this.previous != null ? this.previous.forgeDecoration(graphics3D, decoratableUI, rectangle, rectangle2, dimension) : null;
            this.resize(dimension);
            this.offscreenDrawable = AbstractDecoration.createOrUpdateDrawable(graphics3D, this.offscreenDrawable, dimension.getWidth(), dimension.getHeight());
            this.createDecoration(graphics3D, decoratableUI, rectangle, rectangle2, offscreenDrawable, this.offscreenDrawable);
        }
        return this.offscreenDrawable;
    }

    protected abstract void resize(Dimension dimension) {
    }

    protected abstract void createDecoration(Graphics3D graphics3D, DecoratableUI decoratableUI, Rectangle rectangle, Rectangle rectangle2, OffscreenDrawable offscreenDrawable, OffscreenDrawable offscreenDrawable2) {
    }

    protected static final int bisectCeil(int n) {
        return n + 1 >> 1;
    }

    protected static OffscreenDrawable createOrUpdateDrawable(Graphics3D graphics3D, OffscreenDrawable offscreenDrawable, int n, int n2) {
        if (offscreenDrawable == null || offscreenDrawable.getWidth() != n || offscreenDrawable.getHeight() != n2) {
            if (offscreenDrawable != null) {
                offscreenDrawable.dispose();
            }
            offscreenDrawable = graphics3D.getDrawableManager().createOffscreenDrawable(n, n2, true);
        }
        return offscreenDrawable;
    }
}

