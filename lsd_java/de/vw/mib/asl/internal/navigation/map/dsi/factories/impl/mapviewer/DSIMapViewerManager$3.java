/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer;

import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.DSIMapViewerManager;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.status.DSIMapViewerStatusListener;

class DSIMapViewerManager$3
implements DSIMapViewerStatusListener {
    private final /* synthetic */ DSIMapViewerManager this$0;

    DSIMapViewerManager$3(DSIMapViewerManager dSIMapViewerManager) {
        this.this$0 = dSIMapViewerManager;
    }

    @Override
    public void mapViewerNotReady() {
        this.this$0.mapViewer2NotReady();
    }

    @Override
    public void mapViewerReady() {
        this.this$0.mapViewer2Ready();
    }
}

