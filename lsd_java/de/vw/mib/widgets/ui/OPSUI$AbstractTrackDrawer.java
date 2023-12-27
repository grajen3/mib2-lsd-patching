/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.widgets.ui.OPSUI$TrackDrawer;

abstract class OPSUI$AbstractTrackDrawer
implements OPSUI$TrackDrawer {
    protected OPSUI$TrackDrawer drawer;

    public OPSUI$AbstractTrackDrawer(OPSUI$TrackDrawer oPSUI$TrackDrawer) {
        this.drawer = oPSUI$TrackDrawer;
    }

    @Override
    public void dispose() {
        if (this.drawer != null) {
            this.drawer.dispose();
        }
    }
}

