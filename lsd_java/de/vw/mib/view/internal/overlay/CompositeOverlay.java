/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal.overlay;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.shape.RectangleDrawable;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.view.internal.overlay.AbstractOverlay;
import de.vw.mib.view.internal.overlay.Overlay;
import java.util.ArrayList;
import java.util.List;

public class CompositeOverlay
extends AbstractOverlay {
    private final Color4f backgroundColor;
    private RectangleDrawable backgroundDrawable;
    private final List overlays;

    public CompositeOverlay(Logger logger, Graphics3D graphics3D, String string, Dimension dimension, Color4f color4f) {
        super(logger, graphics3D, string, dimension);
        this.backgroundColor = (Color4f)color4f.clone();
        this.overlays = new ArrayList();
    }

    @Override
    public void dispose() {
        if (this.backgroundDrawable != null) {
            this.backgroundDrawable.dispose();
            this.backgroundDrawable = null;
        }
        for (int i2 = this.overlays.size() - 1; i2 >= 0; --i2) {
            Overlay overlay = (Overlay)this.overlays.get(i2);
            overlay.dispose();
        }
        super.dispose();
    }

    @Override
    public void draw() {
        Graphics3D graphics3D = this.getGraphics3D();
        if (this.backgroundColor != null && !this.backgroundColor.isFullyTransparent()) {
            if (this.backgroundDrawable == null) {
                this.backgroundDrawable = graphics3D.getDrawableManager().createRectangleDrawable();
                this.backgroundDrawable.set(this.getRectangle());
            }
            if (this.backgroundDrawable != null) {
                this.backgroundDrawable.setColor(this.backgroundColor);
                this.backgroundDrawable.draw();
            }
        }
        int n = this.overlays.size();
        for (int i2 = 0; i2 < n; ++i2) {
            Overlay overlay = (Overlay)this.overlays.get(i2);
            overlay.draw();
        }
    }

    public final Color4f getBackgroundColor() {
        return this.backgroundColor;
    }

    public final void setBackgroundColor(Color4f color4f) {
        this.backgroundColor.set(color4f);
    }

    public void addOverlay(Overlay overlay) {
        this.overlays.add(overlay);
    }

    public void removeOverlay(Overlay overlay) {
        this.overlays.remove(overlay);
    }
}

