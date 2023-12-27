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

final class OPSUI$RectangleTrackDrawer
extends OPSUI$AbstractTrackDrawer
implements OPSUI$TrackDrawer {
    private final Graphics3D g;
    private final ImageDrawable trackImageDrawable;
    private final Rectangle[] trackValues;
    private final OPSModel ops;

    public OPSUI$RectangleTrackDrawer(Graphics3D graphics3D, OPSModel oPSModel, ImageDrawable imageDrawable, Rectangle[] rectangleArray) {
        super(null);
        this.g = graphics3D;
        this.trackImageDrawable = imageDrawable;
        this.trackValues = rectangleArray;
        this.ops = oPSModel;
    }

    @Override
    public void draw(Rectangle rectangle, float f2, float f3, float f4) {
        boolean bl = this.ops.get_trackDisplay() == 2;
        this.g.pushMatrix(0);
        float f5 = bl ? f3 : 0.0f;
        float f6 = this.trackValues[0].y;
        int n = Math.round(f3);
        int n2 = Math.round(f2);
        this.trackImageDrawable.setDestinationWidth(n);
        this.trackImageDrawable.setDestinationHeight(n2);
        this.trackImageDrawable.draw(f5, f6);
        this.g.popMatrix(0);
    }
}

