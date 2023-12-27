/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ImageDrawable;
import de.vw.mib.widgets.models.OPSModel;
import de.vw.mib.widgets.ui.OPSUI$AbstractTrackDrawer;
import de.vw.mib.widgets.ui.OPSUI$TrackDrawer;

final class OPSUI$AlphaTrackDrawer
extends OPSUI$AbstractTrackDrawer
implements OPSUI$TrackDrawer {
    private Graphics3D g;
    private ImageDrawable trackAlphaImageDrawable;
    private OPSModel ops;

    public OPSUI$AlphaTrackDrawer(Graphics3D graphics3D, OPSModel oPSModel, OPSUI$TrackDrawer oPSUI$TrackDrawer, ImageDrawable imageDrawable) {
        super(oPSUI$TrackDrawer);
        this.g = graphics3D;
        this.trackAlphaImageDrawable = imageDrawable;
        this.ops = oPSModel;
    }

    @Override
    public void draw(Rectangle rectangle, float f2, float f3, float f4) {
        this.drawer.draw(rectangle, f2, f3, f4);
        this.drawAlphaMask();
    }

    private void drawAlphaMask() {
        int n = this.g.getBlendFactorSourceRGB();
        int n2 = this.g.getBlendFactorDestinationRGB();
        int n3 = this.g.getBlendFactorSourceAlpha();
        int n4 = this.g.getBlendFactorDestinationAlpha();
        this.g.pushMatrix(0);
        this.g.setBlendFactorsSeparate(0, 6, 0, 6);
        if (this.ops.is_showAreaView() && !this.ops.is_showOPSMini()) {
            this.trackAlphaImageDrawable.draw(-this.ops.getAbsX(), -this.ops.getAbsY());
        } else {
            this.trackAlphaImageDrawable.draw();
        }
        this.g.setBlendFactorsSeparate(n, n2, n3, n4);
        this.g.popMatrix(0);
    }
}

